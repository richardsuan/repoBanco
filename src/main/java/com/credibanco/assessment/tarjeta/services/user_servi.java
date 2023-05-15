package com.credibanco.assessment.tarjeta.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.credibanco.assessment.tarjeta.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.tarjeta.repository.user_rep;

@Service
public class user_servi implements user_rep {
	@Autowired
	private user_rep user_rep;
	
	
	
	public List<user> findAllByName(String valor_busqueda, String tipo) {
		// TODO Auto-generated method stub
		List<user> usuarios = user_rep.findAll();
		List<user> user_salida =new ArrayList<>();
		int contador=0;
		for(contador=0;contador<usuarios.size();contador++) {
			
			if("2".equals(tipo)) {//ID DB
				System.out.println(tipo);
				if(usuarios.get(contador).getId().toString().contains(valor_busqueda)) {
					user_salida.add(usuarios.get(contador));
				}
			}
			
			if("3".equals(tipo)) {//docuemnto identidad
				System.out.println(tipo);
				if(usuarios.get(contador).getD_identidad().toString().contains(valor_busqueda)) {
					user_salida.add(usuarios.get(contador));
				}
			}
			if("4".equals(tipo)) {//nombre
				System.out.println(tipo);
				if(usuarios.get(contador).getNombre().contains(valor_busqueda)) {
					user_salida.add(usuarios.get(contador));
				}
			}
			if("7".equals(tipo)) {
				System.out.println(tipo);
				System.out.println(usuarios.get(contador).getCorreo());
				if(usuarios.get(contador).getCorreo().toUpperCase().contains(valor_busqueda)) {
					user_salida.add(usuarios.get(contador));
				}
			}
		}
				
		return user_salida;
	}
	public String findAutorstring (Long id_libro){
		String usuario =" ";
		List<user> t_usuarios = user_rep.findAll();
		int contador=0;
		System.out.println("********** findAutorString long id :"+ id_libro);
		for (contador=0;contador<t_usuarios.size();contador++) {
			System.out.println("********** findAutorString :"+t_usuarios.get(contador).getNombre());
			if(Objects.equals(t_usuarios.get(contador).getId(), id_libro)) {
				usuario=usuario+" "+t_usuarios.get(contador).getNombre();
			}
		}
		return usuario;
	}
	@Override
	public List<user> findAll() {
		// TODO Auto-generated method stub
		return user_rep.findAll();
	}
	@Override
	public List<user> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<user> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return user_rep.findAllById(ids);
	}
	@Override
	public <S extends user> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends user> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteInBatch(Iterable<user> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public user getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends user> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends user> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Page<user> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends user> S save(S entity) {
		// TODO Auto-generated method stub
		return user_rep.save(entity);
	}
	@Override
	public Optional<user> findById(Long id) {
		// TODO Auto-generated method stub
		return user_rep.findById(id);
	}
	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		user_rep.deleteById(id);
	}
	@Override
	public void delete(user entity) {
		// TODO Auto-generated method stub
		user_rep.delete(entity);
	}
	@Override
	public void deleteAll(Iterable<? extends user> entities) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <S extends user> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends user> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public <S extends user> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public <S extends user> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
