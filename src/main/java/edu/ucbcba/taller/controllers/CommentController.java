package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Article;
import edu.ucbcba.taller.entities.Comment;

import edu.ucbcba.taller.services.ArticleService;
import edu.ucbcba.taller.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
/**
 * Created by alvaro on 26/4/17.
 */
@Controller
public class CommentController {

    private CommentService commentService;
    private ArticleService articleService;

    @Autowired
    public void setCommentService(CommentService commentService) {
        this.commentService = commentService;
    }
    @Autowired
    public void setArticleService(ArticleService articleService) {
        this.articleService = articleService;
    }

    @RequestMapping(value = "comment", method = RequestMethod.POST)
    public String saveComment(@Valid Comment comment, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("article", comment.getArticle());
            model.addAttribute("comment", comment);
            return "article";
        }
        commentService.saveComment(comment);
        return "redirect:/article/" + comment.getArticle().getId();
    }

    @RequestMapping(value = "/comment/like/{id}", method = RequestMethod.GET)
    public String likeComment(@PathVariable Integer id){
        Comment comment=commentService.getCommentById(id);
        comment.setLikes(comment.getLikes()+1);
        commentService.saveComment(comment);
        return "redirect:/article/" + comment.getArticle().getId();
    }

    @RequestMapping(value = "/comment/dislike/{id}", method = RequestMethod.GET)
    public String dislikeComment(@PathVariable Integer id){
        Comment comment=commentService.getCommentById(id);
        if(comment.getLikes()>0) {
            comment.setLikes(comment.getLikes() - 1);
            commentService.saveComment(comment);
        }
        return "redirect:/article/" + comment.getArticle().getId();
    }
}
