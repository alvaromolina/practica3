package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Article;

/**
 * Created by alvaro on 26/4/17.
 */
public interface ArticleService {


    Iterable<Article> listAllArticles();

    Article getArticleById(Integer id);

    Article saveArticle(Article article);

    void deleteArticle(Integer id);

}
