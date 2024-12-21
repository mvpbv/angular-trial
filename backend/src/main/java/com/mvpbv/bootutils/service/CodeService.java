package com.mvpbv.bootutils.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mvpbv.bootutils.models.analytics.CodeChallenge;
import com.mvpbv.bootutils.models.analytics.HotSpot;
import com.mvpbv.bootutils.repositories.CodeChallengeRepository;

@Service
public class CodeService {

    @Autowired
    private CodeChallengeRepository codeChallengeRepository;
    


    public Map<Integer, List<HotSpot>>findPrimary(int window, int limit) {
        var codingLessons = codeChallengeRepository.findPrimaryLessons();
        codingLessons.sort(Comparator.comparing(CodeChallenge::getChron));
        var hotSpots = new ArrayList<HotSpot>();
        for (int i = 0; i < codingLessons.size() - window; i++) {
            var subList = codingLessons.subList(i, i + window);
            int sum = subList.stream().mapToInt(CodeChallenge::getDifficulty).sum();
            HotSpot hotSpot = new HotSpot(sum, subList);
            hotSpots.add(hotSpot);
        }
        hotSpots = removeOverlaps(window, hotSpots);
        hotSpots.sort(Comparator.comparing(HotSpot::getSum).reversed());
        
        return hotSpots.stream()
            .limit(limit)
            .collect(Collectors.groupingBy(HotSpot::getCourseIndex, Collectors.toList()));
    }

    public ArrayList<HotSpot> removeOverlaps(int window, List<HotSpot> hotSpots) {
        var noOverlaps = new HashSet<HotSpot>();
    
        for (int i = 0; i < hotSpots.size() - window; i++) {
            noOverlaps.add(hotSpots.subList(i, i + window).stream().max(Comparator.comparing(HotSpot::getSum)).get());

        }
        return new ArrayList<>(noOverlaps);
    }

}
