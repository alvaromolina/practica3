package edu.ucbcba.taller.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;


@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;


    @ManyToOne
    @JoinColumn(name="autor_id")
    private Autor autor;

    @NotNull
    @Size(min=1, max=20)
    private String title;

    @NotNull
    @Size(min=1, max=100)
    private String text;

    @NotNull
    private Date date = new Date();

    @OneToMany(mappedBy="article", cascade = CascadeType.ALL)
    private Set<Comment> comments;

    private Integer likes = 0;

    private Boolean toShow = true;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Boolean getToShow() {
        return toShow;
    }

    public void setToShow(Boolean toShow) {
        this.toShow = toShow;
    }
}
