package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Article;
import edu.ucbcba.taller.entities.Comment;
import edu.ucbcba.taller.services.ArticleService;
import edu.ucbcba.taller.services.AutorService;
import edu.ucbcba.taller.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by alvaro on 26/4/17.
 */
@Controller
public class ArticleController {

    private ArticleService articleService;
    private CategoryService categoryService;
    private AutorService autorService;

    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public void setAutorService(AutorService autorService) {
        this.autorService = autorService;
    }
    /**
     * List all articles.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/articles", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("articles", articleService.listAllArticles());
        return "articles";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("articles", articleService.listAllArticles());
        return "index";
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public String showArticle(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        Comment comment = new Comment();
        comment.setArticle(articleService.getArticleById(id));
        model.addAttribute("comment", comment);
        return "article";
    }


    @RequestMapping(value = "/article/delete/{id}", method = RequestMethod.GET)
    public String deleteArticle(@PathVariable Integer id, Model model) {
        articleService.deleteArticle(id);
        return "articles";
    }

    @RequestMapping(value = "/article/new", method = RequestMethod.GET)
    public String newArticle(Model model) {
        model.addAttribute("article", new Article());
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("autors",autorService.listAllAutors());
        return "articleForm";
    }

    @RequestMapping("article/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("article", articleService.getArticleById(id));
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("autors",autorService.listAllAutors());
        return "articleForm";
    }


    @RequestMapping(value = "article", method = RequestMethod.POST)
    public String saveArticle(@Valid Article article, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("categories", categoryService.listAllCategories());
            model.addAttribute("autors",autorService.listAllAutors());
            return "articleForm";
        }

        articleService.saveArticle(article);
        return "redirect:/article/" + article.getId();
    }

    @RequestMapping(value = "/article/like/{id}", method = RequestMethod.GET)
    public String likeArticle(@PathVariable Integer id, HttpServletRequest request){
        Article article=articleService.getArticleById(id);
        article.setLikes(article.getLikes()+1);
        articleService.saveArticle(article);

        String referrer = request.getHeader("referer");

        return "redirect:"+referrer;
    }

    @RequestMapping(value = "/article/dislike/{id}", method = RequestMethod.GET)
    public String dislikeArticle(@PathVariable Integer id){
        Article article=articleService.getArticleById(id);
        if(article.getLikes()>0) {
            article.setLikes(article.getLikes() - 1);
            articleService.saveArticle(article);
        }
        return "redirect:/article/" + article.getId();
    }

}
