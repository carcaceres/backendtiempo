/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import ce.DatosClimaCE;
import dao.CiudadDao;
import dao.ClimaDao;
import dao.EstadoDao;
import entidad.Ciudad;
import entidad.Clima;
import entidad.DatosClima;
import entidad.Estado;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class Servicios implements Serviciosable{
    public List<Ciudad> mostrarCiudades(){
        CiudadDao ciudadDao=new CiudadDao();
        return ciudadDao.mostrarCiudades();
    }

    public List<Estado> mostrarEstados(){
        EstadoDao estadoDao=new EstadoDao();
        return estadoDao.mostrarEstado();
    }
    
    public List<Clima> mostrarClimas(){
        ClimaDao climaDao=new ClimaDao();
        return climaDao.mostrarClimasCiudad();
    }

    @Override
    public List<DatosClima> mostrarDatosClima() {
        DatosClimaCE datosClima = new DatosClimaCE();
        return datosClima.mostrarDatosClimas();
    }

    @Override
    public List<DatosClima> mostrarDatosClimasCiudad(String codCiudad) {
      DatosClimaCE datosClima = new DatosClimaCE();
        return datosClima.mostrarDatosClimasCiudad(codCiudad);
   
    }
    
    
}
