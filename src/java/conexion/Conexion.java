/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class Conexion {
    
    private Conexion() {
    }
    
    public static Conexion getInstance() {
        return ConexionHolder.INSTANCE;
    }
    
    public Connection conexionOracle(){
         Connection connection = null;

        System.out.println("-------- Oracle JDBC Connection Testing ------");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			

		}

		System.out.println("Oracle JDBC Driver Registered!");

		
		try {

			connection = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:XE", 
                                         "inventario","car741852");

		} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			

		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
        
                return connection;
          } 
          
         
  
    
    private static class ConexionHolder {

        private static final Conexion INSTANCE = new Conexion();
    }
}
