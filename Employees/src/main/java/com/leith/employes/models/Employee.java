package com.leith.employes.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


import groovyjarjarantlr4.v4.runtime.misc.NotNull;

@Entity
@Table(name="employee")
public class Employee {
	
	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  private long idEmploye;
	  @NotNull
	  @Size(min=4,max=15)
	  private String nomEmploye;
	  private String domaine;
	  @Temporal(TemporalType.DATE)
	  @DateTimeFormat(pattern = "yyyy-MM-dd")
	  @PastOrPresent
	  private Date dateNaissance;
	  @ManyToOne
	  private Poste poste;
	  public Employee() {
			super();
		}

		public Employee(String nomEmploye, String domaine, Date dateNaissance,Poste pos) {
			super();
			this.nomEmploye = nomEmploye;
			this.domaine = domaine;
			this.dateNaissance = dateNaissance;
			this.setPoste(pos);;
		}

		public Poste getPoste() {
			return poste;
		}

		public void setPoste(Poste poste) {
			this.poste = poste;
		}

		public long getIdEmploye() {
			return idEmploye;
		}

		public void setIdEmploye(long idEmploye) {
			this.idEmploye = idEmploye;
		}

		public String getNomEmploye() {
			return nomEmploye;
		}

		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
		}

		public String getDomaine() {
			return domaine;
		}

		public void setDomaine(String domaine) {
			this.domaine = domaine;
		}

		public Date getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		
}
