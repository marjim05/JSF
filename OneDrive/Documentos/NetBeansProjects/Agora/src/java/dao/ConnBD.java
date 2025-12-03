/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marce
 */
public class ConnBD {
        public static Connection conectar () {
        Connection conn = null;
        
        try {
            Driver drv = new Driver();
            DriverManager.registerDriver(drv);
            
            String cad = "jdbc:mysql://localhost:3306/prueba?user=root&useSSL=false";
            
            conn = DriverManager.getConnection(cad);
            
        } catch (SQLException e){
            System.out.println("Error en conexión de base de datos");
        }
        return conn;
    }
    
}
