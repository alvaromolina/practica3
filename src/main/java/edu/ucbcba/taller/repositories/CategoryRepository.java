package edu.ucbcba.taller.repositories;

import edu.ucbcba.taller.entities.Category;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}