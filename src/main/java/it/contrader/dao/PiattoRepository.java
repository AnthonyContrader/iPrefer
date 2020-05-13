package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Piatto;

@Repository
@Transactional
public interface PiattoRepository extends CrudRepository<Piatto, Long> {

	Piatto findById(long id);

}
