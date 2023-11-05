package com.relations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;
import com.relations.entity.Article;
import com.relations.services.ArticleService;

@SpringBootApplication
public class RelationelleApplication implements CommandLineRunner {
	@Autowired
    private ArticleService articleService;
	public static void main(String[] args) {
		SpringApplication.run(RelationelleApplication.class, args);
	}

	 

	    @Override
	    public void run(String... args) throws Exception {
	        // Création de nouveaux articles
	        Article article1 = new Article();
	        article1.setTitre("Article 1");
	        article1.setDate("2023-11-05");
	        article1.setAuteur("Auteur1");
	        article1.setPublication(true);
	        article1.setResume("Ceci est le résumé de l'article 1.");
	        article1.setType("Type1");

	        Article article2 = new Article();
	        article2.setTitre("Article 2");
	        article2.setDate("2023-11-06");
	        article2.setAuteur("Auteur2");
	        article2.setPublication(false);
	        article2.setResume("Ceci est le résumé de l'article 2.");
	        article2.setType("Type2");

	        // Enregistrement des articles dans la base de données
	        articleService.createArticle(article1);
	        articleService.createArticle(article2);

	        // Récupération et affichage de tous les articles
	        System.out.println("Tous les articles :");
	        articleService.getAllArticles().forEach(article -> {
	            System.out.println("Titre : " + article.getTitre());
	            System.out.println("Auteur : " + article.getAuteur());
	            System.out.println("Résumé : " + article.getResume());
	            System.out.println("Type : " + article.getType());
	            System.out.println("Publication : " + article.getPublication());
	            System.out.println();
	        });

	        // Récupération d'un article par son ID
	        Article article = articleService.getArticleById(1L);
	        if (article != null) {
	            System.out.println("Article trouvé par ID : " + article.getTitre());
	        } else {
	            System.out.println("Aucun article trouvé avec cet ID.");
	        }

	        // Mise à jour d'un article
	        Article updatedArticle = new Article();
	        updatedArticle.setTitre("Nouveau Titre");
	        updatedArticle.setDate("2023-11-07");
	        updatedArticle.setAuteur("Nouvel Auteur");
	        updatedArticle.setPublication(true);
	        updatedArticle.setResume("Nouveau résumé.");
	        updatedArticle.setType("Nouveau Type");

	        Article updated = articleService.updateArticle(1L, updatedArticle);
	        if (updated != null) {
	            System.out.println("Article mis à jour avec le titre : " + updated.getTitre());
	        } else {
	            System.out.println("Aucun article trouvé avec cet ID pour la mise à jour.");
	        }

	        // Suppression d'un article par son ID
	        articleService.deleteArticle(2L);
	        System.out.println("Article supprimé avec succès.");

	        // Recherche d'articles par auteur
	        List<Article> articlesByAuthor = articleService.findByAuteur("Auteur1");
	        System.out.println("Articles trouvés par auteur :");
	        articlesByAuthor.forEach(a -> System.out.println(a.getTitre()));

	        // Recherche d'articles dont le titre contient "Nouveau"
	        List<Article> articlesByTitle = articleService.findByTitreContaining("Nouveau");
	        System.out.println("Articles dont le titre contient 'Nouveau' :");
	        articlesByTitle.forEach(a -> System.out.println(a.getTitre()));
	    }

}
