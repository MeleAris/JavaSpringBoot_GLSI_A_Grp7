package com.glsi_a.tp1.controller;

import com.glsi_a.tp1.models.Category;
import com.glsi_a.tp1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/show")
    private String showCategories(Model model)
    {
        model.addAttribute("listCategories",categoryService.showAllCategory());
        return "category/showCategory";
    }

    @GetMapping("/create")
    private String formCategory()
    {
        return "category/formCategory";
    }

    @PostMapping("/save")
    private String save(Category category)
    {
        categoryService.saveCategory(category);
        return "redirect:/category/show";
    }

    @GetMapping("/edit/{id}")
    public String formEdit(@PathVariable("id") int id, Model model)
    {
        model.addAttribute("uneCategory", categoryService.selectedCategory(id));
        return "category/formEditCategory";
    }

    @PostMapping("/edit")
    public String editCategory(@ModelAttribute("uneCategory") Category category)
    {
        categoryService.saveCategory(category);
        return "redirect:/category/show";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") int id)
    {
        categoryService.deleteCategory(id);
        return "redirect:/category/show";
    }



}
