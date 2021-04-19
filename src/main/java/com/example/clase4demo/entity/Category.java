package com.example.clase4demo.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private int id;
    @Column(nullable = false)
    private String categoryname;
    private String description;
    @Lob
    private byte[] picture;

    @OneToMany(mappedBy = "category")
    private List<Product> listaProductosPorCategoria;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }


    public List<Product> getListaProductosPorCategoria() {
        return listaProductosPorCategoria;
    }

    public void setListaProductosPorCategoria(List<Product> listaProductosPorCategoria) {
        this.listaProductosPorCategoria = listaProductosPorCategoria;
    }
}
