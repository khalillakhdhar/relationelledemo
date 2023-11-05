package com.relations.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
	public class Article extends Audit {
	   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(unique = true)
	    private String titre;
	    private String date;
	    private String auteur;
	    private Boolean publication;
	    private String resume;
	    private String type;
	    
	}


