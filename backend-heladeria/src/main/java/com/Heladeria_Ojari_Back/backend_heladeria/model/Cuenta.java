package com.Heladeria_Ojari_Back.backend_heladeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;

@Entity
@Table(name="cuentas",uniqueConstraints = @UniqueConstraint(columnNames = "usuario"))
public class Cuenta{
    //id de la cuenta
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //usuario o email de la cuenta

    @NotBlank(message="El nombre de usuario no puede estar vacio")
    @Column(name="usuario", nullable=false, unique=true, length=100)
    private String usuario;

    //Aqui vamos con la contraseña
    //esto se guarda como hash
    //para mas seguridad
    @NotBlank(message="La contraseña no puede estar vacia")
    @Column(nullable=false)
    private String contrasena;

    //roles de cada cuenta

    @ElementCollection(fetch=FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name="cuenta_roles",joinColumns=@JoinColumn(name="cuenta_id"))
    private Set<Rol> roles;

    //constructor vacio que requiere JPA
    public Cuenta() {
    }
    //getters
    public Long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contrasena;
    }

    public Set<Rol> getRoles() {
        return roles;
    }
    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contrasena;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

  
    

}