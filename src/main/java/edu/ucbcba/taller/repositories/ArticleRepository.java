package edu.ucbcba.taller.repositories;


import edu.ucbcba.taller.entities.Article;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ArticleRepository extends CrudRepository<Article, Integer> {

}