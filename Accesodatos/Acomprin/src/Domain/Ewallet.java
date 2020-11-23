/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.sql.Date;
/**
 *
 * @author antonio
 */
public class Ewallet {
    
    private int idwallet;
    private String nombre;
    private String apellidos;
    private String dni;
    private Date fechanacimento;
    private String email;
    private int saldopuntos;
    private int saldoeuros;

    
    public Ewallet() {
    }

    public Ewallet(String nombre, String apellidos, String dni, Date fechanacimento, String email, int saldopuntos, int saldoeuros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimento = fechanacimento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
    }
    //constructor con todo
    public Ewallet(int idwallet, String nombre, String apellidos, String dni, Date fechanacimento, String email, int saldopuntos, int saldoeuros) {
        this.idwallet = idwallet;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.fechanacimento = fechanacimento;
        this.email = email;
        this.saldopuntos = saldopuntos;
        this.saldoeuros = saldoeuros;
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

    public Date getFechanacimento() {
        return fechanacimento;
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

    public void setFechanacimento(Date fechanacimento) {
        this.fechanacimento = fechanacimento;
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

    
    
}
