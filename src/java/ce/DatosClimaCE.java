/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ce;

import conexion.Conexion;
import entidad.Ciudad;
import entidad.DatosClima;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Carlos
 */
public class DatosClimaCE{

   
    public List<DatosClima> mostrarDatosClimas() {
        List<DatosClima> lista = new ArrayList<DatosClima>();
        String sql="select codciudad,nomciudad,idestado,"
                + "nomestado,celsius,farenheit,probprec,"
                + "humedad,viento "
                + "from mostrarview order by nomciudad asc";
        try {
            int id = 0;

            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                DatosClima datosClima = new DatosClima();
                datosClima.setCodCiudad(rs.getString(1));
                datosClima.setNomCiudad(rs.getString(2));
                datosClima.setIdestado(rs.getInt(3));
                datosClima.setNomestado(rs.getString(4));
                datosClima.setCelsius(rs.getInt(5));
                datosClima.setFarenheit(rs.getInt(6));
                datosClima.setProbprec(rs.getInt(7));
                datosClima.setHumedad(rs.getInt(8));
                datosClima.setViento(rs.getInt(9));
                lista.add(datosClima);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            lista = null;
        }

        return lista;
    }
    
    
    public List<DatosClima> mostrarDatosClimasCiudad(String codCiudad) {
        List<DatosClima> lista = new ArrayList<DatosClima>();
       
        
       String sql="select codciudad,nomciudad,idestado,"
               + "nomestado,celsius,farenheit,probprec,"
               + "humedad,viento,url from vistadatosclima"
               + " where codciudad=?";
        
        try {
            int id = 0;

            // TODO code application logic r
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, codCiudad.trim());
            

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                DatosClima datosClima = new DatosClima();
                datosClima.setCodCiudad(rs.getString(1));
                datosClima.setNomCiudad(rs.getString(2).toUpperCase());
                datosClima.setIdestado(rs.getInt(3));
                datosClima.setNomestado(rs.getString(4));
                datosClima.setCelsius(rs.getInt(5));
                datosClima.setFarenheit(rs.getInt(6));
                datosClima.setProbprec(rs.getInt(7));
                datosClima.setHumedad(rs.getInt(8));
                datosClima.setViento(rs.getInt(9));
                datosClima.setUrl(rs.getString(10));
                 lista.add(datosClima);
            }

            pstmt.close();
            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex);
          // lista = null;
        }

        return lista;
    }
    
     public int nuevaClimaCiudad(DatosClima datosClima) {
        int ret = 0;

        try {
            // TODO code application logic here
            String tsql = "{? = call NEWCIUDADCLIMA (?,?,?,?,?,?,?,?)}";
            Conexion conexion = Conexion.getInstance();
            Connection conn = conexion.conexionOracle();
            CallableStatement cstmt = conn.prepareCall(tsql);
            int f=(int)convertirFarenheit(datosClima.getCelsius());
            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, datosClima.getCodCiudad());
            cstmt.setString(3, datosClima.getNomCiudad());
            cstmt.setInt(4, datosClima.getIdestado());
            cstmt.setInt(5, datosClima.getCelsius());
            cstmt.setInt(6, f);
            cstmt.setInt(7, datosClima.getProbprec());
            cstmt.setInt(8, datosClima.getHumedad());
            cstmt.setInt(9, datosClima.getViento());            

            cstmt.executeUpdate();
            ret = cstmt.getInt(1);
            // System.out.println("retorno funcion " + ret);
        } catch (SQLException ex) {
            ret = -2;
        }

        return ret;
    }
    
    
    
     public double convertirFarenheit(int grados){
        return grados*1.8+32;
    }
}
