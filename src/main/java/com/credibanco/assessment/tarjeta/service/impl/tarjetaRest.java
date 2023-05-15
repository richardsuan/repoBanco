package com.credibanco.assessment.tarjeta.service.impl;

import java.net.URI;
import java.util.List;

import com.credibanco.assessment.tarjeta.model.tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.tarjeta.dto.dotTarjeta;
import com.credibanco.assessment.tarjeta.services.user_servi;
import com.credibanco.assessment.tarjeta.services.tarjeta_servi;

@RestController
public class tarjetaRest {
	@Autowired
	private tarjeta_servi tarjetaServicio;
	@Autowired
	private user_servi usuarioServicio;
	@RequestMapping("/tarjetas/")//listar
	@GetMapping	
	private ResponseEntity <List<dotTarjeta>> getAllTarjet(){//este metodo trae a todas las libroes
		//System.out.println("hicieron get");
		dotTarjeta dot_libro = new dotTarjeta();
		return ResponseEntity.ok(dot_libro.creardotTarjeta(null, tarjetaServicio, usuarioServicio));
	}
	//
	@RequestMapping(value="/tarjeta/buscar")//buscar por nombre
	@GetMapping
	private ResponseEntity<List<dotTarjeta>> getOnetarjet(@RequestParam("titulo")  String libro_busqueda){
		System.out.println(libro_busqueda);
		//List<autor> Autor =new ArrayList<>();
		//System.out.println(libro_busqueda.getTitulo());
		dotTarjeta dotlibros = new dotTarjeta();
		return ResponseEntity.ok(dotlibros.creardotTarjeta(libro_busqueda, tarjetaServicio,usuarioServicio));//cambiar
	}
	//
	@RequestMapping(value="/tarjeta/buscar2/{id}")
	@DeleteMapping
	private  ResponseEntity<List<tarjeta>> buscar2Tarjet(@PathVariable Long id){
		//tarjetaServicio.deleteById(id);
		return ResponseEntity.ok((tarjetaServicio.findbookAutor(id)));
	}
	//
	@RequestMapping("/tarjeta/agregar/")
	@PostMapping
	private ResponseEntity<tarjeta> saveTarjet(@RequestBody tarjeta tarjeta){//sirve para guardar las libroes
		try {
			System.out.println("hicieron post");
			tarjeta.setNombreTarjeta(tarjeta.getNombreTarjeta().toUpperCase());
			tarjeta.setMiUsuario(tarjeta.getMiUsuario());
			System.out.println("hicieron post222");
			//Libro.setAutor_this(Libro.getAutor_this().getId());
			tarjeta Autorguardado = tarjetaServicio.save(tarjeta);
			System.out.println("hicieron post");
			System.out.println("hicieron post"+tarjeta.getMiUsuario());
			System.out.println("hicieron post"+tarjeta);

			return  ResponseEntity.created(new URI("/tarjeta/agregar/"+Autorguardado.getId())).body(Autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	@RequestMapping(value="/tarjeta/eliminar/{id}")
	@DeleteMapping
	private  ResponseEntity<Boolean> eliminateTarjet(@PathVariable Long id){
		tarjetaServicio.deleteById(id);
		return ResponseEntity.ok(tarjetaServicio.findById(id) == null);
	}
}
