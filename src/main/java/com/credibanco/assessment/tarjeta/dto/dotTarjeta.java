package com.credibanco.assessment.tarjeta.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.tarjeta.model.tarjeta;
import com.credibanco.assessment.tarjeta.services.user_servi;
import com.credibanco.assessment.tarjeta.services.tarjeta_servi;

public class dotTarjeta implements Serializable {
	private Long  id;
	private String nombreTarjeta;
	private String ano;
	private  Long numeroTarjeta;
	private String miUsuario;

	private String estado;

	private String numeroEnrole;

	private String tipoTarjeta;

public List<dotTarjeta> creardotTarjeta(String tarjetaBusqueda, tarjeta_servi tarjetaListaServio, user_servi autorServicio  ){
		List<dotTarjeta> tarjetaList =new ArrayList<>();
		List<tarjeta> tarjetasSemejantes =new ArrayList<>();
		if(tarjetaBusqueda!=null) {
			System.out.println("if /n");
			tarjetasSemejantes.addAll(tarjetaListaServio.findAllByName(tarjetaBusqueda.toUpperCase()));
		}else {
			System.out.println("else /n");
			tarjetasSemejantes.addAll(tarjetaListaServio.findAll());//esto se hace para pedir todos los editoriales
		}
		int contador=0;
		for (contador =0; contador<tarjetasSemejantes.size(); contador++) {
			dotTarjeta dot = new dotTarjeta();
			dot.setId(tarjetasSemejantes.get(contador).getId());
			dot.setTitulo(tarjetasSemejantes.get(contador).getNombreTarjeta().toUpperCase());
			dot.setAno(tarjetasSemejantes.get(contador).getAno().toUpperCase());
			dot.setNumeroTarjeta(tarjetasSemejantes.get(contador).getNumeroTarjeta());
			dot.setMiUsuario(autorServicio.findAutorstring(tarjetasSemejantes.get(contador).getMiUsuario()));
			dot.setTipoTarjeta(tarjetasSemejantes.get(contador).getTipoTarjeta());
			dot.setNumeroEnrrole(tarjetasSemejantes.get(contador).getNumeroEnrrole());
			dot.setEstado(tarjetasSemejantes.get(contador).getEstado());
			tarjetaList.add(dot);
		}
		return tarjetaList;
	}
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}


	public String getNumeroEnrrole() {
		return numeroEnrole;
	}

	public void setNumeroEnrrole(String numeroEnrole) {
		this.numeroEnrole = numeroEnrole;
	}
	public void setTipoTarjeta(String tipoTarjeta){
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
	public void setTitulo(String nombreTarjeta) {
		this.nombreTarjeta = nombreTarjeta;
	}
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public long getNumeroTarjeta() {
		return numeroTarjeta;
	}
	public void setNumeroTarjeta(long numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}
	public String getMiUsuario() {
		return miUsuario;
	}
	public void setMiUsuario(String miUsuario) {
		this.miUsuario = miUsuario;
	}
	public dotTarjeta(Long id, String nombreTarjeta, String ano, String genero, long NumeroTarjeta, String miUsuario) {
		super();
		this.id = id;
		this.nombreTarjeta = nombreTarjeta;
		this.ano = ano;
		this.numeroTarjeta = NumeroTarjeta;
		this.miUsuario = miUsuario;
	}
	public dotTarjeta() {
		
	}
}
