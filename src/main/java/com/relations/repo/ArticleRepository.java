package com.relations.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.relations.entity.Article;
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByAuteur(String auteur);
    List<Article> findByResumeContaining(String contenuResume);
    List<Article> findByType(String type);
    List<Article> findByTypeOrAuteur(String type, String auteur);
    List<Article> findByPublicationTrue();
    List<Article> findByTitreContaining(String titre);
}
