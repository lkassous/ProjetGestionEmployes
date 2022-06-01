package com.leith.employes.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Poste {
  @Id
  @GeneratedValue(strategy =GenerationType.IDENTITY)
  private Long idPoste;
  private String nomPoste;
  private String description;
  @JsonIgnore
  @OneToMany(mappedBy="poste")
  private List<Employee> employes;
  public Long getIdPoste() {
	  return this.idPoste;
  }
public void setIdPoste(Long idPoste) {
	this.idPoste = idPoste;
}
public void setNomPoste(String nomPoste) {
	this.nomPoste = nomPoste;
}
public void setDescription(String description) {
	this.description = description;
}
public void setEmployes(List<Employee> employes) {
	this.employes = employes;
}
  
}
