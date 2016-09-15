/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import entidad.Clima;
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
public class ClimaDao {


    public List<Clima> mostrarClimasCiudad() {
        List<Clima> lista = new ArrayList<Clima>();

        try {
            int id = 0;
           String sql="select id,estado,celsius,"
                   + "farenheit,probprec,humedad,"
                   + "viento,codciudad from clima";
            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
              Clima clima = new Clima();
              clima.setId(rs.getInt(1));
              clima.setEstado(rs.getInt(2));
              clima.setCelsius(rs.getInt(3));
              clima.setFarenheit(rs.getInt(4));
              clima.setProbprec(rs.getInt(5));
              clima.setHumedad(rs.getInt(6));
              clima.setViento(rs.getInt(7));
              clima.setCodCiudad(rs.getString(8));
              lista.add(clima);
              
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
