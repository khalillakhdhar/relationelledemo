package com.relations.entity;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
/*@Getter
@Setter
@ToString
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Student extends Audit {
	
@Column(nullable =false)
private String nom,prenom;
@Email
private String email;
@Column(nullable =false)

private String mdp;
@Min(value=18)
@Max(value = 33)
private int age;
}
