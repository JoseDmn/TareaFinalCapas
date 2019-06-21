 
package entidades;

 
public class Producto {
    private String nombre_producto;
    private int categoria;
    private Double precio_unitario;
    private int cantidad_existencia;
    
    public Producto(){
        
    }
    
    public Producto(String nombre_producto , Double  precio_unitario ,int cantidad_existencia,int categoria ){
        this.nombre_producto = nombre_producto;
        this.categoria=categoria; 
        this.precio_unitario = precio_unitario;
        this.cantidad_existencia = cantidad_existencia;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public int getCategoria() {
        return categoria;
    }

    public Double getPrecio_unitario() {
        return precio_unitario;
    }

    public int getCantidad_existencia() {
        return cantidad_existencia;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }


    public void setPrecio_unitario(Double precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public void setCantidad_existencia(int cantidad_existencia) {
        this.cantidad_existencia = cantidad_existencia;
    }

    
}

 
