package com.credibanco.assessment.library.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author richa
 *
 */
@Entity
@Table (name="Usuarios")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long  id;
	private Long  d_identidad;
	private String nombre;
	private String  fecha_nacimiento;
	private String correo;
	private String  tarjetasUsuario;
	//private String libros_escritos;
	//esto se hace para hacer las relaciones 
	
  
    

	
	public user() {
			
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


	public String gettarjetasUsuario() {
		return tarjetasUsuario;
	}





	public void setTarjetasUsuario(String tarjetasUsuario) {
		this.tarjetasUsuario = tarjetasUsuario;
	}





	public user(Long d_identidad, String nombre, String fecha_nacimiento, String lugar_nacimiento, String correo, String tarjetasUsuario) {
		super();
		this.d_identidad = d_identidad;
		this.nombre = nombre;
		this.fecha_nacimiento = fecha_nacimiento;
		this.correo = correo;
		this.tarjetasUsuario = tarjetasUsuario;
	}
	
	
	
	
	
}
