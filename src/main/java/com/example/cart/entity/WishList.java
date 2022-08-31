package com.example.cart.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "WISHLIST")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class WishList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @ManyToMany
    @JoinTable(name = "WISHLIST_COURSES",
            joinColumns = @JoinColumn(name = "WISHLIST_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    //@JsonManagedReference(value = "WishListCourse")
    private Set<Course> wishListCourses;

    @OneToOne(mappedBy = "wishList")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Course> getWishListCourses() {
        return wishListCourses;
    }

    public void setWishListCourses(Set<Course> wishListCourses) {
        this.wishListCourses = wishListCourses;
    }
}
