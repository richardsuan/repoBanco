package com.credibanco.assessment.library.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.credibanco.assessment.library.model.tarjeta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.repository.tarjeta_rep;

@Service
public class tarjeta_servi implements tarjeta_rep {
	@Autowired
	private tarjeta_rep tarjeta_rep;
	
	public List<tarjeta> findbookAutor (Long id){
		List<tarjeta> t_tarjetas = tarjeta_rep.findAll();
		List<tarjeta> tarjetas =new ArrayList<>();
		int contador=0;
		for (contador=0; contador< t_tarjetas.size(); contador++) {
			if(t_tarjetas.get(contador).getMyUser()==id) {
				tarjetas.add(t_tarjetas.get(contador));
			}
		}
		return tarjetas;
	}
	public String findTarjetaUserString (Long id_autor){
		String libros =" ";
		List<tarjeta> t_tarjetas = tarjeta_rep.findAll();
		int contador=0;
		for (contador=0; contador< t_tarjetas.size(); contador++) {
			if(t_tarjetas.get(contador).getMyUser()==id_autor) {
					
					libros=libros+" "+ t_tarjetas.get(contador).getTitulo();
					System.out.println(libros);
			}
		}
		System.out.println(libros);
		return libros;
		
	}
	@Override
	public List<tarjeta> findAll() {
		// TODO Auto-generated method stub
		return tarjeta_rep.findAll();
	}

	@Override
	public List<tarjeta> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return tarjeta_rep.findAll(sort);
	}
	public List<tarjeta> findAllByName(String titulo) {
		// TODO Auto-generated method stub
		List<tarjeta> tarjetas = tarjeta_rep.findAll();
		List<tarjeta> tarjeta_salida =new ArrayList<>();
		int contador=0;
		for(contador=0; contador< tarjetas.size(); contador++) {
			if(tarjetas.get(contador).getTitulo().contains(titulo)) {
				tarjeta_salida.add(tarjetas.get(contador));
			}
		}
				
		return tarjeta_salida;
	}
	

	@Override
	public List<tarjeta> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends tarjeta> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<tarjeta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public tarjeta getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<tarjeta> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> S save(S entity) {
		// TODO Auto-generated method stub
		return tarjeta_rep.save(entity);
	}

	@Override
	public Optional<tarjeta> findById(Long id) {
		// TODO Auto-generated method stub
		return tarjeta_rep.findById(id);
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
		tarjeta_rep.deleteById(id);
	}

	@Override
	public void delete(tarjeta entity) {
		// TODO Auto-generated method stub
		tarjeta_rep.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends tarjeta> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <S extends tarjeta> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends tarjeta> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends tarjeta> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

}
