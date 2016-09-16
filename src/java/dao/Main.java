/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.DatosClima;
import servicio.Servicios;

/**
 *
 * @author Carlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Servicios servicio = new Servicios();
        DatosClima datosClima = new DatosClima();
        datosClima.setCodCiudad("4001");
        datosClima.setNomCiudad("calir");
        datosClima.setIdestado(3);
        datosClima.setCelsius(28);
        datosClima.setProbprec(78);
        datosClima.setHumedad(77);
        datosClima.setViento(11);
        System.out.println(servicio.nuevaClimaCiudad(datosClima));
        
    }
    
    
    
}
