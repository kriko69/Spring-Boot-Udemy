package com.example.demo.models.entity;


//clase de entidad

import javassist.SerialVersionUID;
import org.hibernate.validator.constraints.Email;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;


@Entity //indicamos que es una entidad
@Table(name = "clientes") //indicamos el nombre de la tabla de la DB
public class Cliente implements Serializable { //buena practica

    public static final long SerialVersionUID = 1L; //identificador para el JPA de forma interna
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id incremental
    private Long id;

    @Column(name = "nombre") //nombre del campo en la tabla por variable
    @NotEmpty
    private String nombre;

    @Column(name = "apellido")
    @NotEmpty

    private String apellido;

    @Column(name = "email")
    @NotEmpty //campo no vacio
    @Email //de tipo email
    private String email;

    @Column(name = "create_at")
    @Temporal(TemporalType.DATE) //para tipo fecha
    @DateTimeFormat(pattern = "yyyy-MM-dd") //formato de fecha
    @NotNull //no null
    private Date createAt;

    /*@PrePersist  //se llama justo antes de crear el registro en la DB
    public void prePresist()
    {
        createAt = new Date();
    }*/


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
