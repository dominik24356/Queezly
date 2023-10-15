package com.opensource.queezly.repository;


import com.opensource.queezly.common.enums.Difficulty;
import com.opensource.queezly.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> getQuizById(Long quizId);


    @Query("SELECT q FROM Quiz q " +
            "WHERE (:title is null OR LOWER(q.title) LIKE LOWER(concat('%', :title, '%'))) " +
            "AND (:category is null OR LOWER(q.category) LIKE LOWER(concat('%', :category, '%'))) " +
            "AND (:difficulty is null OR q.difficulty = :difficulty)")
    List<Quiz> findQuizzesByTitleAndCategoryAndDifficulty(@Param("title") String title, @Param("category") String category, @Param("difficulty") Difficulty difficulty);

}
