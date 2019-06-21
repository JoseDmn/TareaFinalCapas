package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private final String DRIVER = "org.postgresql.Driver";  
    private final String URL = "jdbc:postgresql://localhost:5432/tarea";  
    private final String USERNAME = "postgres";    
    private final String PASSWORD = "root"; 
    
    private Connection connection;

    public Conexion() {
        connection = null;
        try{
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
        }catch(Exception e){
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Opened database successfully");

    }
    public Connection getConnection(){
        return connection;
    }

}