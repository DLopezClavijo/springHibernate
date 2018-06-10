package es.altair.mongodb.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import es.altair.mongodb.bean.Persona;

@Repository
public class PersonaDAOImplMongo implements PersonaDAO {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public void anadir(Persona p) {
		if (!mongoTemplate.collectionExists("personas"))
			mongoTemplate.createCollection("personas");
		
		p.setId(UUID.randomUUID().toString());
		mongoTemplate.insert(p, "personas");
	}

	@Override
	public List<Persona> listado() {
		return mongoTemplate.findAll(Persona.class, "personas");
	}

	@Override
	public void borrar(Persona p) {
		mongoTemplate.remove(p, "personas");
	}

	@Override
	public void actualizar(Persona p) {
		mongoTemplate.save(p, "personas");		
	}

	@Override
	public Persona obtener(String id) {
		return mongoTemplate.findById(id, Persona.class, "personas");
	}

}
