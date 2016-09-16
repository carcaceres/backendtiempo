/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import entidad.Ciudad;
import entidad.Clima;
import entidad.DatosClima;
import entidad.Estado;
import java.util.List;

/**
 *
 * @author Carlos
 */
public interface Serviciosable {

    public List<Ciudad> mostrarCiudades();
    
    public String nuevaCiudad(Ciudad ciudad);

    public List<Estado> mostrarEstados();

    public List<Clima> mostrarClimas();
    
    public List<DatosClima> mostrarDatosClima();
    
    public List<DatosClima> mostrarDatosClimasCiudad(String codCiudad);
    
     public List<Ciudad> mostrarCiudad(String codCiudad);
     
      public String nuevaClimaCiudad(DatosClima datosClima);
   
    
}
