/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import entidad.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Carlos
 */
public class CiudadDao{

   
    public List<Ciudad> mostrarCiudades() {
        List<Ciudad> lista = new ArrayList<Ciudad>();

        try {
            int id = 0;

            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(
                    "select codciudad,nomciudad from ciudad");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Ciudad ciudad = new Ciudad();
                ciudad.setId(++id);
                ciudad.setCodCiudad(rs.getString(1));
                ciudad.setNomCiudad(rs.getString(2));
                lista.add(ciudad);

            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            lista = null;
        }

        return lista;
    }
}
