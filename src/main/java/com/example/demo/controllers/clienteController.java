package com.example.demo.controllers;

import com.example.demo.models.entity.Cliente;
import com.example.demo.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
@SessionAttributes("cliente")
public class clienteController {

    @Autowired

    private ClienteServiceImpl clienteDao;

    @RequestMapping(value = "/listar",method = RequestMethod.GET)
    public String Listar(Model model)
    {
        model.addAttribute("titulo","Listado de clientes");
        model.addAttribute("clientes",clienteDao.findAll());
        return "listar";
    }

    @RequestMapping(value = "/form", method = RequestMethod.GET)
    public String crear(Model model)
    {
        Cliente c = new Cliente();
        model.addAttribute("titulo","formulario de cliente");
        model.addAttribute("cliente",c);
        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, Model model, SessionStatus status)
    {
        if (result.hasErrors()) //si el resultado tiene errores retorna a la vista formulario
        {
            return  "form";
        }
        model.addAttribute("titulo","formulario de cliente");
        clienteDao.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @RequestMapping(value = "/form/{id}", method = RequestMethod.GET)
    public String editar(@PathVariable(value = "id") Long id, Model model)
    {
        Cliente c = null;
        if (id>0)
        {
            c=clienteDao.findOne(id);
        }else{
            return "redirect:/listar";
        }
        model.addAttribute("cliente",c);
        model.addAttribute("titulo","Editar de cliente");
        return "form";
    }

    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.GET)
    public String eliminar(@PathVariable(value = "id") long id, Model model)
    {

        if (id>0)
        {
            clienteDao.delete(id);
        }
        return "redirect:/listar";
    }
}
