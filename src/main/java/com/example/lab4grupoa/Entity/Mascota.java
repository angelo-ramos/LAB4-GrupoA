package com.example.lab4grupoa.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "mascota")
public class Mascota {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "idmascota")
    private int idmascota;
    @Column(name = "nombre")
    @Pattern(regexp="^[a-zA-Z\\s]*$",message="Solo letras")
    @NotBlank(message = "Ingrese un nombre")
    private String nombre;
    @Column(name = "anho")
    @Pattern(regexp="^[0-9]*$",message="Solo numeros")
    @NotBlank(message = "Ingrese año")
    private String anho;
    @Column(name = "historia")
    @NotBlank(message = "Ingrese historia")
    private String historia;
    @Column(name = "observaciones")
    @Size(max = 200, message = "Máximo 200 caracteres")
    @Pattern(regexp="(?:^[a-zA-Z0-9]*)(?:[^$%¡!¿?])$",message="Solo formato permitido")
    private String observaciones;
    @Column(name = "sexo")
    private String sexo;
    @Basic
    @Column(name = "raza_especie_idraza")
    private int razaEspecieIdraza;
    @Column(name = "raza_otros")
    @Size(max = 45, message = "Máximo 45 caracteres")
    @Pattern(regexp="(?:^[a-zA-Z ]*)(?:[^0-9])$",message="No numeros")
    private String razaOtros;
    @Basic
    @Column(name = "cuenta_idcuenta")
    private Integer cuentaIdcuenta;

    public int getIdmascota() {
        return idmascota;
    }

    public void setIdmascota(int idmascota) {
        this.idmascota = idmascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAnho() {
        return anho;
    }

    public void setAnho(String anho) {
        this.anho = anho;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getRazaEspecieIdraza() {
        return razaEspecieIdraza;
    }

    public void setRazaEspecieIdraza(int razaEspecieIdraza) {
        this.razaEspecieIdraza = razaEspecieIdraza;
    }

    public String getRazaOtros() {
        return razaOtros;
    }

    public void setRazaOtros(String razaOtros) {
        this.razaOtros = razaOtros;
    }

    public Integer getCuentaIdcuenta() {
        return cuentaIdcuenta;
    }

    public void setCuentaIdcuenta(Integer cuentaIdcuenta) {
        this.cuentaIdcuenta = cuentaIdcuenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mascota mascota = (Mascota) o;
        return idmascota == mascota.idmascota && razaEspecieIdraza == mascota.razaEspecieIdraza && Objects.equals(nombre, mascota.nombre) && Objects.equals(anho, mascota.anho) && Objects.equals(historia, mascota.historia) && Objects.equals(observaciones, mascota.observaciones) && Objects.equals(sexo, mascota.sexo) && Objects.equals(razaOtros, mascota.razaOtros) && Objects.equals(cuentaIdcuenta, mascota.cuentaIdcuenta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idmascota, nombre, anho, historia, observaciones, sexo, razaEspecieIdraza, razaOtros, cuentaIdcuenta);
    }
}
