package com.credibanco.assessment.tarjeta.model;

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
	private String nombreTarjeta;
	private String ano;
	private  Long numeroTarjeta;

	private Long miUsuario;

	private String estado;

	private String numeroEnrole;

	private String tipoTarjeta;

	public tarjeta() {
		
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumeroEnrrole() {
		return numeroEnrole;
	}

	public void setNumeroEnrrole(String numeroEnrole) {
		this.numeroEnrole = numeroEnrole;
	}

	public String getTipoTarjeta() {
		return tipoTarjeta;
	}

	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreTarjeta() {
		return nombreTarjeta;
	}

	public void setNombreTarjeta(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Long getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(Long NumeroTarjeta) {
		this.numeroTarjeta = NumeroTarjeta;
	}

	public Long getMiUsuario() {
		return miUsuario;
	}

	public void setMiUsuario(Long miUsuario) {
		this.miUsuario = miUsuario;
	}
	public tarjeta(String nombreTarjeta, String ano, String genero, Long numeroTarjeta, Long miUsuario, String estado, String numeroEnrole, String tipoTarjeta) {
		super();
		this.nombreTarjeta = nombreTarjeta;
		this.ano = ano;
		this.numeroTarjeta = numeroTarjeta;
		this.miUsuario = miUsuario;
		this.estado = estado;
		this.numeroEnrole = numeroEnrole;
		this.tipoTarjeta = tipoTarjeta;
	}
}
