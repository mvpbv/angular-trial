
package com.mvpbv.bootutils.models.links;

import java.util.List;

import com.mvpbv.bootutils.dto.ReadmeDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;

@Entity
public class Readme {
    
    @Lob
    @Column(name = "readme", columnDefinition="LONGTEXT")
    private String readme;

    @Id
    private String uuid;

    private int length;

    @OneToMany(mappedBy = "readme", cascade=CascadeType.ALL)
    private List<Url> urls;


    public Readme() {

    }
    public Readme(String readme, String uuid, int length) {
        this.readme = readme;
        this.uuid = uuid;
        this.length = length;
    }
    public Readme(ReadmeDTO readmeDTO) {
        this.readme = readmeDTO.getDescription();
        this.uuid = readmeDTO.getUuid();
        this.length = this.readme.length();
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public List<Url> getUrls() {
        return urls;
    }

    public void setUrls(List<Url> urls) {
        this.urls = urls;
    }

}
