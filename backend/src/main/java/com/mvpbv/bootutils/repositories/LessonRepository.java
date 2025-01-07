package com.mvpbv.bootutils.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mvpbv.bootutils.dto.ReadmeDTO;
import com.mvpbv.bootutils.models.lesson.Lesson;


public interface LessonRepository extends JpaRepository<Lesson, Long> {
    @Query(value = "SELECT * FROM lessons", nativeQuery = true)
   List<Lesson> getAllLessonDetails();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_cli.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title  FROM lesson join lesson_cli ON lesson.cli_command_id = lesson_cli.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionCLI();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_code_output.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_code_output ON lesson.lesson_code_output_id = lesson_code_output.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionOutput();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_code_sql.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_code_sql ON lesson.lesson_code_completion_sql_id = lesson_code_sql.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionSQL();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_code_tests.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_code_tests ON lesson.lesson_code_tests_id = lesson_code_tests.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionTests();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_github.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_github ON lesson.lesson_github_id = lesson_github.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionGithub();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_http_tests.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_http_tests ON lesson.lesson_http_tests_id = lesson_http_tests.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionHttpTests();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_multiple_choice.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_multiple_choice ON lesson.lesson_multiple_choice_id = lesson_multiple_choice.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionMultipleChoice();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_text_input.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_text_input ON lesson.text_input_id = lesson_text_input.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionTextInput();
    @Query(value = "SELECT lesson.id, lesson.uuid, lesson_manual.description, lesson.course_slug, lesson.chapter_slug, lesson.chapter_title FROM lesson join lesson_manual ON lesson.lesson_manual_id = lesson_manual.id", nativeQuery = true)
    List<ReadmeDTO> getDescriptionManual();
}
