package com.crud.user.user.model;

import java.sql.Date;

import lombok.Data;

@Data
public class User {
    int id;
    String nombre;
    String apellido;
    String correo;
    String contraseña;
    Date fecha_registro;
    int status;
}
