/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entidad.Ciudad;
import entidad.Clima;
import java.util.List;

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
       ClimaDao climaDao = new ClimaDao();
        List<Clima> lista=climaDao.mostrarClimasCiudad();
        for(Clima clima:lista){
            
            System.out.println("codigo ciudad:"+clima.getCelsius());
            System.out.println("Nombre Ciudad "+clima.getFarenheit());
        
        }
        
    }
    
}
