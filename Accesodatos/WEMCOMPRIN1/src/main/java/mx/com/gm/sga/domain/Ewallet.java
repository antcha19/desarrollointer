/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.domain;

import java.sql.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import mx.com.gm.sga.domain.Compra;

/**
 *
 * @author antonio
 */
@Entity
//nombre de la tabla
@Table(name="ewallet")
public class Ewallet {
    private static final long SerialVersionUID=1l;
    //primary key
    @Id
    //id es autoincrementable
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //nombres de las columnas de la tabla
    private int idwallet;
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fechanacimiento;
    private String email;
    private int saldopuntos;
    private int saldoeuros;
    
   

    public Ewallet() {
    }

    public Ewallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public Ewallet(String nombre, String apellidos, String dni, Date fechanacimiento, String email, int saldopuntos, int saldoeuros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
    }

    public Ewallet(int idwallet, String nombre, String apellidos, String dni, Date fechanacimiento, String email, int saldopuntos, int saldoeuros) {
        this.idwallet = idwallet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimiento = fechanacimiento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public int getIdwallet() {
        return idwallet;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechanacimiento() {
        return fechanacimiento;
    }

    public String getEmail() {
        return email;
    }

    public int getSaldopuntos() {
        return saldopuntos;
    }

    public int getSaldoeuros() {
        return saldoeuros;
    }

    public void setIdwallet(int idwallet) {
        this.idwallet = idwallet;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setFechanacimiento(Date fechanacimiento) {
        this.fechanacimiento = fechanacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSaldopuntos(int saldopuntos) {
        this.saldopuntos = saldopuntos;
    }

    public void setSaldoeuros(int saldoeuros) {
        this.saldoeuros = saldoeuros;
    }

    @Override
    public String toString() {
        return "Ewallet{" + "idwallet=" + idwallet + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", fechanacimiento=" + fechanacimiento + ", email=" + email + ", saldopuntos=" + saldopuntos + ", saldoeuros=" + saldoeuros + '}';
    }

    
    
    

    

    
}
