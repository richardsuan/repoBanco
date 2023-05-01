package com.credibanco.assessment.library.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.library.model.tarjeta;
import com.credibanco.assessment.library.services.user_servi;
import com.credibanco.assessment.library.services.tarjeta_servi;

public class dotTarjeta implements Serializable {
	private Long  id;
	private String titulo;
	private String ano;
	private  int NumeroTarjeta;
	private String  myUser;
	
public List<dotTarjeta> creardotTarjeta(String tarjeta_busqueda, tarjeta_servi tarjetaList_servi, user_servi Autor_servi  ){
		List<dotTarjeta> tarjetaList =new ArrayList<>();
		List<tarjeta> tarjetas_semejantes =new ArrayList<>();
		if(tarjeta_busqueda!=null) {
			System.out.println("if /n");
			tarjetas_semejantes.addAll(tarjetaList_servi.findAllByName(tarjeta_busqueda.toUpperCase()));
		}else {
			System.out.println("else /n");
			tarjetas_semejantes.addAll(tarjetaList_servi.findAll());//esto se hace para pedir todos los editoriales
		}
		int contador=0;
		for (contador =0;contador<tarjetas_semejantes.size();contador++) {
			dotTarjeta dot = new dotTarjeta();
			dot.setId(tarjetas_semejantes.get(contador).getId());
			dot.setTitulo(tarjetas_semejantes.get(contador).getTitulo().toUpperCase());
			dot.setAno(tarjetas_semejantes.get(contador).getAno().toUpperCase());
			dot.setNumeroTarjeta(tarjetas_semejantes.get(contador).getNumeroTarjeta());
			dot.setMyUser(Autor_servi.findAutorstring(tarjetas_semejantes.get(contador).getMyUser()));
			tarjetaList.add(dot);
		}
		return tarjetaList;
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
	public String getMyUser() {
		return myUser;
	}
	public void setMyUser(String myUser) {
		this.myUser = myUser;
	}
	public dotTarjeta(Long id, String titulo, String ano, String genero, int NumeroTarjeta, String myUser) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.ano = ano;
		this.NumeroTarjeta = NumeroTarjeta;
		this.myUser = myUser;
	}
	public dotTarjeta() {
		
	}
}
