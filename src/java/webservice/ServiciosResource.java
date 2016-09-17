/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import entidad.Ciudad;
import entidad.Clima;
import entidad.DatosClima;
import entidad.Estado;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import servicio.Servicios;
import servicio.Serviciosable;
import util.Mensaje;

/**
 * REST Web Service
 *
 * @author Carlos
 */
@Path("servicios")
public class ServiciosResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ServiciosResource
     */
    public ServiciosResource() {
    }

    /**
     * Retrieves representation of an instance of webservice.ServiciosResource
     * @return an instance of java.lang.String
     */
    

    @GET
    @Path("/mostrarciudades")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ciudad> mostrarCiudades(){
        Serviciosable servicioCiudad=new Servicios();
        return servicioCiudad.mostrarCiudades();
    }
    
   
    
    @GET
    @Path("/mostrarestados")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> mostrarEstado(){
         Serviciosable servicioCiudad=new Servicios();
        return servicioCiudad.mostrarEstados();
    }
    
    @GET
    @Path("/mostrarclimas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Clima> mostrarClimas(){
         Serviciosable servicioCiudad=new Servicios();
        return servicioCiudad.mostrarClimas();
    }
    
    @GET
    @Path("/mostrardatosclimas")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatosClima> mostrarDatosClimas(){
         Serviciosable servicioCiudad=new Servicios();
        return servicioCiudad.mostrarDatosClima();
    }
    
    @GET
    @Path("/climaciudad")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DatosClima> mostrarDatosClimaCiudad(
            @QueryParam("codciudad") String codigo){
         Serviciosable servicioCiudad=new Servicios();
        return servicioCiudad.mostrarDatosClimasCiudad(codigo);
    }
    
     @GET
    @Path("/nuevaciudad")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje mostrarDatosClimaCiudad(
           
            @QueryParam("codciudad") String codciudad,
            @QueryParam("nomciudad") String nomciudad){
         Mensaje mensaje=new Mensaje();
        Ciudad ciudad=new Ciudad();
        ciudad.setCodCiudad(codciudad);
        ciudad.setNomCiudad(nomciudad);
        Serviciosable servicioCiudad=new Servicios();
        mensaje.setMensaje(servicioCiudad.nuevaCiudad(ciudad));
        return mensaje;
    }
    
    
     @GET
    @Path("/nuevaciudadclima")
    @Produces(MediaType.APPLICATION_JSON)
    public Mensaje nuevaClimaCiudad(
           
            @QueryParam("codciudad") String codciudad,
            @QueryParam("nomciudad") String nomciudad,
            @QueryParam("idestado") int estado,
            @QueryParam("celsius") int celsius,
            @QueryParam("probprec") int probprec,
            @QueryParam("humedad") int humedad,
            @QueryParam("viento") int viento            
            ){
        
         Mensaje mensaje=new Mensaje();
        
        Serviciosable servicio = new Servicios();
        DatosClima datosClima = new DatosClima();
        datosClima.setCodCiudad(codciudad);
        datosClima.setNomCiudad(nomciudad);
        datosClima.setIdestado(estado);
        datosClima.setCelsius(celsius);
        datosClima.setProbprec(probprec);
        datosClima.setHumedad(humedad);
        datosClima.setViento(viento);
        mensaje.setMensaje(servicio.nuevaClimaCiudad(datosClima));         
        return mensaje;
    }
    
    
    /**
     * PUT method for updating or creating an instance of ServiciosResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
