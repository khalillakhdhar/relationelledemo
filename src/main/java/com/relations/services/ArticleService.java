package com.relations.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.relations.entity.Article;
import com.relations.repo.ArticleRepository;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Article existingArticle = articleRepository.findById(id).orElse(null);
        if (existingArticle != null) {
            existingArticle.setTitre(updatedArticle.getTitre());
            existingArticle.setDate(updatedArticle.getDate());
            existingArticle.setAuteur(updatedArticle.getAuteur());
            existingArticle.setPublication(updatedArticle.getPublication());
            existingArticle.setResume(updatedArticle.getResume());
            existingArticle.setType(updatedArticle.getType());
            return articleRepository.save(existingArticle);
        }
        return null;
    }

    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }
    public List<Article> findByAuteur(String auteur) {
        return articleRepository.findByAuteur(auteur);
    }

    public List<Article> findByResumeContaining(String contenuResume) {
        return articleRepository.findByResumeContaining(contenuResume);
    }

    public List<Article> findByType(String type) {
        return articleRepository.findByType(type);
    }

    public List<Article> findByTypeOrAuteur(String type, String auteur) {
        return articleRepository.findByTypeOrAuteur(type, auteur);
    }

    public List<Article> findByPublicationTrue() {
        return articleRepository.findByPublicationTrue();
    }

    public List<Article> findByTitreContaining(String titre) {
        return articleRepository.findByTitreContaining(titre);
    }
}

