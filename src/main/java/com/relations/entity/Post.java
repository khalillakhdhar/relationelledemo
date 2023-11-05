package com.relations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Data
public class Post extends Audit implements Serializable {
private String content,description;
@Column(unique = true)
private String title;

// List (accepte les doublant)
// set (n'accepte plus)
@OneToMany(mappedBy = "post")
@JsonIgnoreProperties({"applications","hibernateLazyInitializer"})

private List<Comment> comments=new ArrayList<Comment>();

}
