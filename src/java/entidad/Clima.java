/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author Carlos
 */
public class Clima {
    private int id;
    private int estado;
    private int celsius;
    private int farenheit;
    private int probprec;
    private int humedad;
    private int viento;
    private String codCiudad;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getCelsius() {
        return celsius;
    }

    public void setCelsius(int celsius) {
        this.celsius = celsius;
    }

    public int getFarenheit() {
        return farenheit;
    }

    public void setFarenheit(int farenheit) {
        this.farenheit = farenheit;
    }

    public int getProbprec() {
        return probprec;
    }

    public void setProbprec(int probprec) {
        this.probprec = probprec;
    }

    public int getHumedad() {
        return humedad;
    }

    public void setHumedad(int humedad) {
        this.humedad = humedad;
    }

    public int getViento() {
        return viento;
    }

    public void setViento(int viento) {
        this.viento = viento;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }
    
    
    
}
