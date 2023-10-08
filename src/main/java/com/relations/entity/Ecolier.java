package com.relations.entity;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Ecolier extends Student {
private String groupe,superviseur;

}
