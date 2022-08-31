package com.example.cart.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "CART")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TOTAL_PRICE")
    private Float totalPrice;

    @ManyToMany
    @JoinTable(name = "COURSE_CART",
            joinColumns = @JoinColumn(name = "CART_ID"),
            inverseJoinColumns = @JoinColumn(name = "COURSE_ID"))
    //@JsonManagedReference
    private List<Course> cartCourses;

    @OneToOne(mappedBy = "cart")
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Course> getCartCourses() {
        return cartCourses;
    }

    public void setCartCourses(List<Course> cartCourses) {
        this.cartCourses.addAll(cartCourses);
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", totalPrice=" + totalPrice +
                ", cartCourses=" + cartCourses +
                ", user=" + user +
                '}';
    }
}
