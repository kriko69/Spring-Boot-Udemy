package com.example.demo.service;

import com.example.demo.models.entity.Cliente;

import java.util.List;

public interface IClienteService {

    public List<Cliente> findAll(); //listar clientes

    public void save(Cliente cliente); //agregar cleintes

    public Cliente findOne(Long id); //editar cleinte

    public void delete(Long id); //eliminar cliente
}
