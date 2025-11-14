package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Cliente;
import jakarta.validation.constraints.*;

//Aqui empieza el DTO para el registro de un nuevo Cliente

public class ClienteRegistroDTO{
    //Validadores de vacio y longitud pendientes
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombre;

    @Size(max = 50, message = "El apellido no debe exceder los 50 caracteres.")

    private String apellido;
    

    @Size(max = 20, message = "El teléfono no debe exceder los 20 caracteres.")

    private String telefono;


    @Size(max = 255, message = "La dirección no debe exceder los 255 caracteres.")

    private String direccion;

    @NotBlank(message="El nombre de usuario no puede estar vacio")
    @Size(min=5,max=100,message="El nombre de usuario debe tener entre 5 y 100 caracteres")
    private String usuario;

    @NotBlank(message="La contraseña no puede estar vacia")
    @Size(min=8,message="La contraseña debe tener al menos 8 caracteres")
    private String contraseña;

    //constructor vacio
    public ClienteRegistroDTO() {
    }
    //constructor lleno

    public ClienteRegistroDTO(String nombre, String apellido, String telefono, String direccion, String usuario, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    // Helper: convierte este DTO a la entidad Cliente (no crea la Cuenta)
    // Útil si en el service quieres crear primero la Cuenta y luego el Cliente
    public Cliente toClienteEntity() {
        Cliente c = new Cliente();
        c.setNombre(this.nombre);
        c.setApellido(this.apellido);
        c.setTelefono(this.telefono);
        c.setDireccion(this.direccion);
        return c;
    }
    
   //Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getContraseña() {
        return contraseña;
    }
    //Setters

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }


    //y el toString

    @Override
    public String toString() {
        return "ClienteRegistroDTO{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    
}