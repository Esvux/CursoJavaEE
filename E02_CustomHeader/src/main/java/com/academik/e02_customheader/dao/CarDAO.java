package com.academik.e02_customheader.dao;

import com.academik.e02_customheader.model.Car;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DAO - Data Access Object
 * Singleton - Garantiza que siempre se accede a un unico objeto
 * @author esvux
 */
public class CarDAO {
    //Aqui inicia singleton
    /**
     * Referencia unica para todos.
     */
    private static CarDAO singleton = null;
    
    /**
     * 
     * @return 
     */
    public static CarDAO getInstance() {
        if(singleton == null) {
            singleton = new CarDAO();
        }
        return singleton;
    }
    
    /**
     * Contructor privado para evitar instancias fuera de CarDAO.
     */
    private CarDAO() {
        items = new ArrayList<>();
        items.add(new Car(1, "Mazda", "Mazda3", "#454545", 2008));
        items.add(new Car(2, "Chevy", "SparkGT", "#FF0000", 2013));
        items.add(new Car(3, "Toyota", "Yaris", "#000", 2008));
        items.add(new Car(4, "Mazda", "Protege", "#FFF", 1999));
    }
    //Aqui termina singleton
    
    private List<Car> items;
    
    /**
     * Lista todos los carros.
     * @return 
     */
    public List<Car> getAll() {
        List<Car> temp = new ArrayList<>();
        Connection conn;
        try {
            /*
            A nivel de libreria
            1) Descargar el driver de la base de datos que sea de su preferencia JAR
            2) Copiar el driver dentro de la carpeta PayaraHome/glassfish/lib
            
            En su codigo
            1) Cargar el driver, eso lo hacen con Class.forName("paquete de su driver");
            2) Obtener una conexion a la base de datos con getConnection y el String de conexion, usuario y contraseña
            3) Demostrar que saben SQL
            */
            
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/academik", "postgres", "1234qwer");
            PreparedStatement stmn = conn.prepareStatement("SELECT code, brand, model, color, year FROM car");
            ResultSet result = stmn.executeQuery();
            while(result.next()) {
                int code = result.getInt("code");
                String brand = result.getString("brand");
                String model = result.getString("model");
                String color = result.getString("color");
                int year = result.getInt("year");
                temp.add(new Car(code, brand, model, color, year));
            }
        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        
        return temp;
    }
    
    /**
     * Guarda un nuevo carro.
     * @param theCar 
     */
    public void create(Car theCar) {
        //TODO: Cambiar this.items.add(theCar); por su SQL
        this.items.add(theCar);
    }
    
}
