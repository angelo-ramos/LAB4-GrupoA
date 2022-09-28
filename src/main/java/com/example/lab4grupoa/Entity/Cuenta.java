package com.example.lab4grupoa.Entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cuenta")
public class Cuenta {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idcuenta")
    private int idcuenta;
    @Basic
    @Column(name = "correo")
    private String correo;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "telefono")
    private String telefono;
    @Basic
    @Column(name = "admin")
    private Integer admin;

    public int getIdcuenta() {
        return idcuenta;
    }

    public void setIdcuenta(int idcuenta) {
        this.idcuenta = idcuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cuenta cuenta = (Cuenta) o;
        return idcuenta == cuenta.idcuenta && Objects.equals(correo, cuenta.correo) && Objects.equals(direccion, cuenta.direccion) && Objects.equals(password, cuenta.password) && Objects.equals(telefono, cuenta.telefono) && Objects.equals(admin, cuenta.admin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idcuenta, correo, direccion, password, telefono, admin);
    }
}
