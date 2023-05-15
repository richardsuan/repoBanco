package com.credibanco.assessment.tarjeta.model;


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
	private Long  documentoIdentidad;
	private String nombre;
	private String  fechaNacimiento;
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
		return documentoIdentidad;
	}





	public void setD_identidad(Long documentoIdentidad) {
		this.documentoIdentidad = documentoIdentidad;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getFecha_nacimiento() {
		return fechaNacimiento;
	}





	public void setFecha_nacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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





	public user(Long documentoIdentidad, String nombre, String fechaNacimiento, String lugar_nacimiento, String correo, String tarjetasUsuario) {
		super();
		this.documentoIdentidad = documentoIdentidad;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.correo = correo;
		this.tarjetasUsuario = tarjetasUsuario;
	}
	
	
	
	
	
}
