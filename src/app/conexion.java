/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Uriel
 */
import java.sql.*;
/**
 *
 * @author Uriel
 */
public class conexion {
    private static Connection con;
    // Lo de abajo es para declarar los datos de conexion a la bd local
    /*
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="root";
    private static final String pass="";
    private static final String url="jdbc:mysql://localhost:3306/appwords";
    */
    /** Lo de abajo es para declarar los datos de conexion a la bd remota
     */
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String user="us2a36ei4rnftro2";
    private static final String pass="qgOZqUyLVykLDwWDq4F8";
    private static final String url="jdbc:mysql://us2a36ei4rnftro2:qgOZqUyLVykLDwWDq4F8@bqyymxz7zosereerx8ff-mysql.services.clever-cloud.com:3306/bqyymxz7zosereerx8ff";
    /* 
     */
    
     public static Connection conectar() {
        // Reseteamos a null la conexion a la bd
        con=null;
        try{
            Class.forName(driver);
            // Nos conectamos a la bd
            con= (Connection) DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){
                System.out.println("Conexion establecida");
            }
        }
        // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println("Error de conexion" + e);
        }
        return con;
    }                                     
}
