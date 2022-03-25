package com.glsi_a.tp1.service;

import com.glsi_a.tp1.models.Category;
import com.glsi_a.tp1.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    //Création d'un nouveau produit
    public void saveCategory(Category category)
    {
        categoryRepository.save(category);
    }

    //Affichage de tous les produits
    public List<Category> showAllCategory()
    {
        return categoryRepository.findAll();
    }

    //Selection d'un seul produit
    public Category selectedCategory(int id)
    {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = null;
        if (optional.isPresent())
        {
            category = optional.get();
        }
        else {
            throw new RuntimeException("Id introuvable");
        }
        return category;
    }

    //Supprimer un produit
    public void deleteCategory(int id)
    {
        if (categoryRepository.findById(id).isPresent())
        {
            categoryRepository.deleteById(id);
        }
        else {
            throw new RuntimeException("Impossible de supprimer cet élément");
        }
    }
}
