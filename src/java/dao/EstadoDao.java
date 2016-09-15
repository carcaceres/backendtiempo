/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import entidad.Ciudad;
import entidad.Estado;
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
public class EstadoDao {
     
    public List<Estado> mostrarEstado() {
        List<Estado> lista = new ArrayList<Estado>();

        try {
            
            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(
                    "select idestado,nomestado from estado");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Estado estado = new Estado();
                estado.setIdestado(rs.getInt(1));
                estado.setNomestado(rs.getString(2));
                lista.add(estado);

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
