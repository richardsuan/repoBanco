package com.credibanco.assessment.library.service.impl;

import java.net.URI;
import java.util.List;

import com.credibanco.assessment.library.model.user;
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

import com.credibanco.assessment.library.dto.dotuser;
import com.credibanco.assessment.library.services.user_servi;
import com.credibanco.assessment.library.services.tarjeta_servi;


@RestController
public class userRest {
	@Autowired
	private user_servi User_servi;
	@Autowired
	private tarjeta_servi Tarjeta_servi;
	@RequestMapping("/users/")//listar autores
	@GetMapping	
	private ResponseEntity <List<dotuser>> getAllUsers(){//este metodo trae a todos los autores que estan en la base de datos
		System.out.println("hicieron get");
		dotuser autor_salida = new dotuser();
		return ResponseEntity.ok(autor_salida.creardot(null,null,User_servi,Tarjeta_servi));//cambiar
	}
	
	@RequestMapping(value="/user/buscar")//buscar por nombre
	@GetMapping
	private ResponseEntity<List<dotuser>> getOneUser(@RequestParam("valor")  String Valor_busqueda, @RequestParam("tipo")  String tipo){
		//List<autor> Autor =new ArrayList<>();
		System.out.println("hicieron get en /user/buscar/ \n");
		
		dotuser autor_salida = new dotuser();//aqui paso nombre como valor

		return ResponseEntity.ok(autor_salida.creardot(Valor_busqueda,tipo,User_servi,Tarjeta_servi));//cambiar
		//return ResponseEntity.ok(dot);
		
	}
	
	//
	@RequestMapping(value="/user/eliminar/{id}")
	@DeleteMapping
	private  ResponseEntity<Boolean> eliminarUser(@PathVariable Long id){
		User_servi.deleteById(id);
		return ResponseEntity.ok(!(User_servi.findById(id)!=null));
	}

	@RequestMapping("/user/agregar/")
	@PostMapping
	private ResponseEntity<user> saveUser(@RequestBody user user){//sirve para guardarlas personas y la anotacion sirve para hacer que el body sea obligatorio
		try {
			user.setNombre(user.getNombre().toUpperCase());
			user autorguardado = User_servi.save(user);
			return  ResponseEntity.created(new URI("/user/agregar/"+ autorguardado.getId())).body(autorguardado);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}

