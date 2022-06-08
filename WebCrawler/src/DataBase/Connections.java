/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author amtme
 */
public class Connections {
    java.sql.Connection conn;
    Statement stmt;
    private String host = "localhost";
    private String port = "3309";
    private String dbname = "wikipedia";
    private String username = "root";
    private String password = "1234";
    
  
    
    public void connect(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        }catch (final ClassNotFoundException e) {
            System.err.println("ERROR" + e);
            System.out.println("Aquí rasta");
        }
        try {
     //jdbc:mysql://localhost:3306/db?allowPublicKeyRetrieval=true&useSSL=false
            String url = "jdbc:mariadb://" + this.host + ":" + this.port + "/" + this.dbname;
            this.conn = DriverManager.getConnection(url, this.username, this.password);
            System.out.println("Succed!!");
            this.stmt = conn.createStatement();
            
            
            //stmt.execute("CREATE DATABASE prueba1"); //to try if the connection is working
            
        } catch (SQLException ex) {
            System.out.println("Cannot connect to the Database");
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public boolean createPagina(int ID, String titulo, String link, int cantSubtitulos, int cantPalabras, int cantPalabrasTitulo, int cantReferencias)
    {
        boolean result = false; //used to return if the insert was succesful = 1 or not = 0
        
        String query = "INSERT INTO pagina (ID, TITULO, LINK, CantSubtitulos, CantPalabras, CantReferencias, CantPalabrasTitulo)" + 
                       " VALUES(?,?,?,?,?,?,?);";
        
        try {
            PreparedStatement  pstmt = conn.prepareStatement(query);
            
            pstmt.setInt(1, ID);
            pstmt.setString(2, titulo);
            pstmt.setString(3, link);
            pstmt.setInt(4, cantSubtitulos);
            pstmt.setInt(5, cantPalabras);
            pstmt.setInt(6, cantReferencias);
            pstmt.setInt(7, cantPalabrasTitulo);
            
            int success = pstmt.executeUpdate();
            
            if (success > 0) {
                System.out.println("Insert Success");
                result = true;
            } else {
                System.out.println("Insert Fail");
                result = false;
            }
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean createSubtitulo(String subtitulo, int ID_Pagina, int CantPalabras)
    {
        boolean result = false; //used to return if the insert was succesful = 1 or not = 0
        String query = "INSERT INTO Subtitulo (Subtitulo, ID_Pagina, CantPalabras)" + 
                       " VALUES(?,?,?);";
        
        try {
            PreparedStatement  pstmt = conn.prepareStatement(query);
            
           
            pstmt.setString(1, subtitulo);
            pstmt.setInt(2, ID_Pagina);
            pstmt.setInt(3, CantPalabras);
           
            
            int success = pstmt.executeUpdate();
            
            if (success > 0) {
                System.out.println("Insert Success");
                result = true;
            } else {
                System.out.println("Insert Fail");
                result = false;
            }
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean createImagen(String url, String alt, int cantPalabras, int ID_Pagina)
    {
        boolean result = false; //used to return if the insert was succesful = 1 or not = 0
        String query = "INSERT INTO Imagen (URL, alt, CantPalabras, ID_Pagina)" + 
                       " VALUES(?,?,?,?);";
        
        try {
            PreparedStatement  pstmt = conn.prepareStatement(query);
            
           
            pstmt.setString(1, url);
            pstmt.setString(2, alt);
            pstmt.setInt(3, cantPalabras);
            pstmt.setInt(4, ID_Pagina);
           
            
            int success = pstmt.executeUpdate();
            
            if (success > 0) {
                System.out.println("Insert Success");
                result = true;
            } else {
                System.out.println("Insert Fail");
                result = false;
            }
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean createReferencia(String referencia, String link, boolean activo, int ID_Pagina)
    {
        boolean result = false; //used to return if the insert was succesful = 1 or not = 0
        String query = "INSERT INTO referencia (referencia, link, activo, ID_Pagina)" + 
                       " VALUES(?,?,?,?);";
        
        try {
            PreparedStatement  pstmt = conn.prepareStatement(query);
            
           
            pstmt.setString(1, referencia);
            pstmt.setString(2, link);
            pstmt.setBoolean(3, activo);
            pstmt.setInt(4, ID_Pagina);
           
            
            int success = pstmt.executeUpdate();
            
            if (success > 0) {
                System.out.println("Insert Success");
                result = true;
            } else {
                System.out.println("Insert Fail");
                result = false;
            }
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

     public boolean createPopulares(int numTop, String palabra, int apariciones, int ID_Pagina)
    {
        boolean result = false; //used to return if the insert was succesful = 1 or not = 0
        String query = "INSERT INTO populares (numTop, palabra, apariciones, ID_Pagina)" + 
                       " VALUES(?,?,?,?);";
        
        try {
            PreparedStatement  pstmt = conn.prepareStatement(query);
            
           
            pstmt.setInt(1, numTop);
            pstmt.setString(2, palabra);
            pstmt.setInt(3, apariciones);
            pstmt.setInt(4, ID_Pagina);
           
            
            int success = pstmt.executeUpdate();
            
            if (success > 0) {
                System.out.println("Insert Success");
                result = true;
            } else {
                System.out.println("Insert Fail");
                result = false;
            }
            
            pstmt.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Connections.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
}



