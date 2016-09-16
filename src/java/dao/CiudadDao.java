/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import entidad.Ciudad;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos
 */
public class CiudadDao {

    public int nuevaCiudad(Ciudad ciudad) {
        int ret = 0;

        try {
            // TODO code application logic here
            String tsql = "{? = call NEWCIUDAD(?,?)}";
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            CallableStatement cstmt = conn.prepareCall(tsql);

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, ciudad.getCodCiudad());
            cstmt.setString(3, ciudad.getNomCiudad());

            cstmt.executeUpdate();
            ret = cstmt.getInt(1);
            // System.out.println("retorno funcion " + ret);
        } catch (SQLException ex) {
            ret = -2;
        }

        return ret;
    }

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
    
    public List<Ciudad> mostrarCiudad(String codCiudad) {
        List<Ciudad> lista = new ArrayList<Ciudad>();

        try {
            int id = 0;

            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(
                    "select codciudad,nomciudad from ciudad "
                            + "where codciudad=?");

            pstmt.setString(1, codCiudad);
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
