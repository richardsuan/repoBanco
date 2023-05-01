package com.credibanco.assessment.library.dto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.credibanco.assessment.library.model.user;
import com.credibanco.assessment.library.services.user_servi;
import com.credibanco.assessment.library.services.tarjeta_servi;

public class dotuser implements Serializable{
	
	private Long  id;
	private Long  d_identidad;
	private String nombre;
	private String  fecha_nacimiento;
	private String correo;
	private String  tarjetasUsuario;
	
	public List<dotuser> creardot(String valorBusqueda, String tipo, user_servi User_servi, tarjeta_servi Tarjeta_servi  ) {
		//System.out.print("dot "+autor_busqueda+"\n");
		List<dotuser> User =new ArrayList<>();
		List<user> autores_semejantes =new ArrayList<>();
		if(valorBusqueda != null) {
			System.out.print("dot if \n" + valorBusqueda);
			autores_semejantes.addAll(User_servi.findAllByName(valorBusqueda.toUpperCase(),tipo));
		}else {
			autores_semejantes.addAll(User_servi.findAll());//esto se hace para pedir todos los autores
		}
		int contador=0;
		for (contador =0; contador< autores_semejantes.size(); contador++) {
			//System.out.print(" \n FOR /n");
			dotuser dot = new dotuser();
			dot.setId(autores_semejantes.get(contador).getId());
			dot.setD_identidad(autores_semejantes.get(contador).getD_identidad());
			dot.setNombre(autores_semejantes.get(contador).getNombre().toUpperCase());
			dot.setCorreo(autores_semejantes.get(contador).getCorreo().toLowerCase());
			dot.setFecha_nacimiento(autores_semejantes.get(contador).getFecha_nacimiento());
			dot.setTarjeta(Tarjeta_servi.findTarjetaUserString(autores_semejantes.get(contador).getId()));
			User.add(dot);
		}
		return User;
	}
	public dotuser() {//constructor vacio
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getD_identidad() {
		return d_identidad;
	}
	public void setD_identidad(Long d_identidad) {
		this.d_identidad = d_identidad;
	}
	public dotuser(String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo,
				   String tarjetasUsuario) {
		super();
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo = correo;
		this.tarjetasUsuario = tarjetasUsuario;
	}
	//aqui se crean los get y set 
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTarjetasUsuario() {
		return tarjetasUsuario;
	}
	public void setTarjeta(String tarjetasUsuario) {
		this.tarjetasUsuario = tarjetasUsuario;
	}
}
