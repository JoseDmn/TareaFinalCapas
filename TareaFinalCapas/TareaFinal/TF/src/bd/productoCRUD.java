 
package bd;

import entidades.Producto;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class productoCRUD {

    public Conexion bd;

    public productoCRUD() {
        bd = new Conexion();
    }

        public boolean agregar(String nombre_producto,int categoria,Double precio_unitario, int cantidad_existencia) throws SQLException{
        Connection conn = bd.getConnection();
        boolean isSuccess = false;
        String query = "INSERT INTO producto(nombre_producto,id_categoria,precio_unitario,cantidad_existencia) VALUES (?,?,?,?)";
        String query2 = "SELECT * FROM producto WHERE nombre_producto= ?";
        try{
            
            PreparedStatement pstm = conn.prepareStatement(query);
            PreparedStatement pstm2 = conn.prepareStatement(query2);
            pstm.setString(1 , nombre_producto);
            pstm.setInt(2 , categoria);
            pstm.setDouble(3, precio_unitario);
            pstm.setInt(4, cantidad_existencia);
             
            
            pstm2.setString(1, nombre_producto);
            if(!pstm2.executeQuery().isFirst()){
                pstm.execute();
                isSuccess = true;
            }
            //conn.close();
        }catch(SQLException ex){
            isSuccess = false;
            ex.printStackTrace();
        }
        return isSuccess;
    }
        

        
        public List<Producto> mostrar(){
        Connection conn = bd.getConnection();
        List<Producto> products = new ArrayList();
        String query = "SELECT * FROM producto";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Producto producto = new Producto();
                producto.setNombre_producto(rs.getString("nombre_producto"));
                producto.setPrecio_unitario(rs.getDouble("precio_unitario"));
                producto.setCantidad_existencia(rs.getInt("cantidad_existencia"));
                producto.setCategoria(rs.getInt("id_categoria"));
                products.add(producto);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return products;
    }
        

   public boolean eliminar(String nombre_producto)throws SQLException{
        boolean flag = false;
        Connection conn = bd.getConnection();
        String query = "DELETE FROM producto WHERE nombre_producto = ?";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, nombre_producto);
            int rows = stm.executeUpdate();
            if(rows!=0) flag = true;
            conn.close();
        }catch(SQLException ex){
            System.out.println("Error " + ex.getMessage());
            ex.printStackTrace();
        }
        return flag;
    }
   
       public boolean actualizar(String id_producto,Producto product) throws SQLException{
        boolean flag = false;
        Connection conn = bd.getConnection();
        String query = "UPDATE producto SET nombre_producto = ?,id_categoria=?, precio_unitario =?,cantidad_existencia=? WHERE nombre_producto = ?";
        try{
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, product.getNombre_producto());
            stm.setDouble(2, product.getCategoria());
            stm.setDouble(3, product.getPrecio_unitario());
            stm.setInt(4, product.getCantidad_existencia());
            stm.setString(5, id_producto);
            
            if(stm.executeUpdate()!=0) flag = true; 
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return flag;
    }
}


