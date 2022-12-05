package org.generation.italy.demo.repository;

import org.generation.italy.demo.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	
	

}
