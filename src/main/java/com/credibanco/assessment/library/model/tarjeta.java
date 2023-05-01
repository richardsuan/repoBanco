package com.credibanco.assessment.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Tarjetas")
public class tarjeta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private String titulo;
	private String ano;
	private  int NumeroTarjeta;
	private Long  myUser;
	public tarjeta() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getNumeroTarjeta() {
		return NumeroTarjeta;
	}

	public void setNumeroTarjeta(int NumeroTarjeta) {
		this.NumeroTarjeta = NumeroTarjeta;
	}

	public Long getMyUser() {
		return myUser;
	}

	public void setMyUser(Long myUser) {
		this.myUser = myUser;
	}
	public tarjeta(String titulo, String ano, String genero, int NumeroTarjeta, Long myUser) {
		super();
		this.titulo = titulo;
		this.ano = ano;
		this.NumeroTarjeta = NumeroTarjeta;
		this.myUser = myUser;
	}
}
