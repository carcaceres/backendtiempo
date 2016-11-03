package servlet;

import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.File;

import java.util.List;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONObject;
import org.json.simple.JSONValue;

public class Upload extends HttpServlet {
    
    private String dirUploadFiles;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        dirUploadFiles = getServletContext().getRealPath( getServletContext().getInitParameter( "dirUploadFiles" ) ); 
        System.out.println("directorio: "+dirUploadFiles);
        HttpSession sesion = request.getSession( true );
        if( ServletFileUpload.isMultipartContent( request ) ){
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload( factory ); 
            upload.setSizeMax( new Long( getServletContext().getInitParameter( "maxFileSize" ) ).longValue() );          
            List listUploadFiles = null;
            FileItem item = null;            
            try{
                listUploadFiles = upload.parseRequest( request );
                Iterator it = listUploadFiles.iterator();
                while( it.hasNext() ){
                    item = ( FileItem ) it.next();
                    if( !item.isFormField() ){
                        if( item.getSize() > 0 ){
                            String nombre   = item.getName();                            
                            String tipo     = item.getContentType();
                            long tamanio    = item.getSize();
                            String extension = nombre.substring( nombre.lastIndexOf( "." ) );
                                       
                            sesion.setAttribute("sArNombre", String.valueOf(nombre));
                            sesion.setAttribute("sArTipo", String.valueOf(tipo));
                            sesion.setAttribute("sArExtension", String.valueOf(extension));
                            sesion.setAttribute("directorio", String.valueOf(dirUploadFiles));
                            
                            File archivo = new File( dirUploadFiles, nombre );
                            item.write( archivo );
                            if ( archivo.exists() ){
                                response.sendRedirect("success.html");
                               /* request.setCharacterEncoding("utf8");
        //response.setCharacterEncoding("utf8");
        response.setContentType("application/json");
         JSONObject jsonObj = (JSONObject) JSONValue.parse(request.getParameter(nombre));
        System.out.println(jsonObj.get("message"));
        JSONObject obj = new JSONObject();
        obj.put("message", "hello from server");
        out.print(obj);
                               */
                             
                            }else{  
                                sesion.setAttribute("sArError","Ocurrio un error al subir el archivo");
                                response.sendRedirect("error.html");
                            }
                            
                        }
                    }
                }
                
            }catch( FileUploadException e ){
                sesion.setAttribute("sArError", String.valueOf(e.getMessage()));
                response.sendRedirect("error.html");
            }catch (Exception e){
                sesion.setAttribute("sArError", String.valueOf(e.getMessage()));
                response.sendRedirect("error.html");
            }            
        }        
        out.close();
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /** Returns a short description of the servlet.
     */
    public String getServletInfo() {
        return "Short description";
    }
    // </editor-fold>
}
