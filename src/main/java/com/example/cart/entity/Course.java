package com.example.cart.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COURSE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DURATION")
    private Float duration;

    @Column(name = "CREATOR")
    private String creator;

    @Column(name = "PRICE")
    private Float price;

    @Column(name = "CATEGORY")
    @Enumerated(EnumType.STRING)
    private Category category;

    @Column(name = "CREATED_ON", updatable = false)
    @CreationTimestamp
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "LAST_MODIFIED")
    private Timestamp lastModified;

    @Nullable
    @Column(name = "RATING")
    private Float rating;

    @ManyToMany(mappedBy = "cartCourses")
    //@JsonBackReference
    private Set<Cart> carts;

    @ManyToMany(mappedBy = "wishListCourses")
    //@JsonBackReference(value = "WishListCourse")
    private Set<WishList> wishLists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getDuration() {
        return duration;
    }

    public void setDuration(Float duration) {
        this.duration = duration;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getLastModified() {
        return lastModified;
    }

    public void setLastModified(Timestamp lastModified) {
        this.lastModified = lastModified;
    }

    @Nullable
    public Float getRating() {
        return rating;
    }

    public void setRating(@Nullable Float rating) {
        this.rating = rating;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }
}
