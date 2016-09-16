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
public class Servicios implements Serviciosable {

    @Override
    public List<Ciudad> mostrarCiudades() {
        CiudadDao ciudadDao = new CiudadDao();
        return ciudadDao.mostrarCiudades();
    }

    @Override
    public List<Estado> mostrarEstados() {
        EstadoDao estadoDao = new EstadoDao();
        return estadoDao.mostrarEstado();
    }

    @Override
    public List<Clima> mostrarClimas() {
        ClimaDao climaDao = new ClimaDao();
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

    @Override
    public String nuevaCiudad(Ciudad ciudad) {
        String mensaje="";
        CiudadDao ciudadDao = new CiudadDao();
        int ret=ciudadDao.nuevaCiudad(ciudad);
        if(ret==1){
            mensaje="Ingreso Ciudad Con Exito!!";
        }
        else if(ret==0){
            mensaje="La Ciudad "+ciudad.getNomCiudad()+" Existe!!";
        }
        else if(ret==-2){
            mensaje="Problemas en El Servicio consulte con el Administrador";
        }
        
        return mensaje;

    }

    @Override
    public List<Ciudad> mostrarCiudad(String codCiudad) {
     CiudadDao ciudadDao = new CiudadDao();
        return ciudadDao.mostrarCiudad(codCiudad);   
        
    }

    @Override
    public String nuevaClimaCiudad(DatosClima datosClima) {
      String mensaje="";
        DatosClimaCE datosClimaCe = new DatosClimaCE();
        int ret=datosClimaCe.nuevaClimaCiudad(datosClima);
        if(ret==1){
            mensaje="Ingreso Ciudad Con Exito!!";
        }
        else if(ret==0){
            mensaje="La Ciudad "+datosClima.getNomCiudad()+" Existe!!";
        }
        else if(ret==-2){
            mensaje="Problemas en El Servicio consulte con el Administrador";
        }
        
        return mensaje;
    }

}
