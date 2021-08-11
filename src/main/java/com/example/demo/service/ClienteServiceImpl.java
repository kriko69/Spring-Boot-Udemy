package com.example.demo.service;

import com.example.demo.models.dao.IClienteDao;
import com.example.demo.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClienteServiceImpl implements IClienteService {

    @Autowired
    private IClienteDao ClienteDao;

    @Transactional
    public List<Cliente> findAll() //listar clientes
    {
       return (List<Cliente>) ClienteDao.findAll();
    }

    @Transactional
    public void save(Cliente cliente) //agregar cleintes
    {
        ClienteDao.save(cliente);
    }

    @Transactional
    public Cliente findOne(Long id) //editar cleinte
    {
        return ClienteDao.findById(id).orElse(null);
    }

    @Transactional
    public void delete(Long id) //eliminar cliente
    {
        ClienteDao.deleteById(id);
    }


}
