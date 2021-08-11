package com.example.demo.models.dao;

import com.example.demo.models.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface IClienteDao extends CrudRepository<Cliente,Long>{ //crud repository tiene todos los metodos para la DB <objetos o claase, long por el id>




}
