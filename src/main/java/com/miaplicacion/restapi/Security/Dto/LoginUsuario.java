package com.miaplicacion.restapi.Security.Dto;

public class LoginUsuario {
    private String nombreUsuario;
    private String password;
    
    // GETTER Y SETTER

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
