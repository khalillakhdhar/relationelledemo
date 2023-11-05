package com.relations.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.relations.entity.Article;
import com.relations.services.ArticleService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/articles")
public class ArticleController {
	private final ArticleService articleService;
@Autowired
	public ArticleController(ArticleService articleService) {
		super();
		this.articleService = articleService;
	}
@GetMapping
public List<Article> getArticles(@PathParam(value = "auteur") String auteur)
{
	if(auteur==null)
	return this.articleService.getAllArticles();
	else
		return this.articleService.findByAuteur(auteur);
	}
@PostMapping
public Article createArticle(@RequestBody Article article)
{
return articleService.createArticle(article);	
}
@PutMapping("/{id}")
public Article updateArticle(@PathVariable Long id,@RequestBody Article article)
{
return articleService.updateArticle(id, article);	
}
@DeleteMapping("/{id}")
public String deleteArticle(@PathVariable Long id)
{
	try
	{
	articleService.deleteArticle(id);
	return "article "+id+" supprimé avec succés";
	
	}
	catch(Exception exception)
	{
		return "erreur de suppression"+exception.toString();
	}
}

}
