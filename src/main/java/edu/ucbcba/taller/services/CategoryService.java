package edu.ucbcba.taller.services;

import edu.ucbcba.taller.entities.Category;

/**
 * Created by alvaro on 26/4/17.
 */
public interface CategoryService {
    Iterable<Category> listAllCategories();

    Category getCategoryById(Integer id);

    Category saveCategory(Category category);

    void deleteCategory(Integer id);
}
