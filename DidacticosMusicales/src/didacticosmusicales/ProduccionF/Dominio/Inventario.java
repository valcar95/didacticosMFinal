/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.ProduccionF.Dominio;

import didacticosmusicales.ProduccionF.Datos.ConexionBD;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hecto
 */
public class Inventario {

    private List<Material> materiales;
    private List<Producto> productos;
    private static Inventario inventario;

    private Inventario(List<Material> materiales, List<Producto> productos) {
        this.materiales = materiales;
        this.productos = productos;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public static List<Producto> ObtenerProductos() throws IOException {
        List<Producto> productosR = new ArrayList<>();
        FileReader fr = new FileReader("C:\\Users\\Juan Pablo\\Desktop\\didacticosMusicales-master\\DidacticosMusicales\\src\\didacticosmusicales\\ProduccionF\\productos.txt");
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        while ((line = br.readLine()) != null && line != "") {
           productosR.add(obtenerProductoDesdeLinea(line));
        }
        br.close();
        fr.close();
        
        return productosR;
    }

    public static Producto obtenerProductoDesdeLinea(String texto) {

        String nombre = null;
        String id = null;
        String material = null;
        int cantMaterial = 0;
        int precio = 0;
        int tiempoElaboracion = 0;
        int cantidadEnInventario = 0;

        char[] x = texto.toCharArray();
        int cont = 0;
        String t = "";
        for (int i = 0; i < x.length; i++) {
            if (x[i] == ',' && cont == 0) {
                nombre = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 1) {
                id = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 2) {
                material = t;
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 3) {
                cantMaterial = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 4) {
                precio = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 5) {
                tiempoElaboracion = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] == ',' && cont == 6) {
                cantidadEnInventario = Integer.parseInt(t);
                cont++;
                t = "";
            } else if (x[i] != ',') {
                t = t + x[i];
            }
        }
        return new Producto(nombre,id,null,cantMaterial,precio,tiempoElaboracion);
    }

    public static Inventario getInstance(List<Material> materiales, List<Producto> productos) {
        if (inventario == null) {
            inventario = new Inventario(materiales, productos);
        } else {
            System.out.println("No se realiza una nueva instacia de inventario");
        }
        return inventario;
    }

    public Producto buscarProducto(String id) {
        Iterator<Producto> it = productos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Material buscarMaterial(String nombre) {
        Iterator<Material> it = materiales.iterator();
        while (it.hasNext()) {
            Material p = it.next();
            if (p.getNombre().equals(nombre)) {
                return p;
            }
        }
        return null;
    }

    public int mostrarCantidadMaterial(String nombre) {
        Iterator<Material> it = materiales.iterator();
        int posicion = 0;
        int cantidad = 0;
        while (it.hasNext()) {
            Material p = it.next();
            if (p.getNombre().equals(nombre)) {
                cantidad = p.getCantidadEnInventario();
            }
            posicion = posicion + 1;
        }
        return cantidad;
    }

    public int mostrarCantidadProducto(String id) {
        Iterator<Producto> it = productos.iterator();
        int posicion = 0;
        int cantidad = 0;
        while (it.hasNext()) {
            Producto p = it.next();

            if (p.getId().equals(id)) {
                cantidad = p.getCantidadEnInventario();
            }
            posicion = posicion + 1;
        }
        return cantidad;
    }

    public void ingresarNuevoProducto(Producto p) {
        productos.add(p);
    }

    public void modificarProducto(Producto p) {
        Iterator<Producto> it = productos.iterator();
        int posicion = 0;
        String id = p.getId();
        while (it.hasNext()) {
            Producto o = it.next();
            if (o.getId().equals(id)) {
                productos.remove(posicion);
                productos.add(posicion, p);
            }
            posicion = posicion + 1;
        }

    }

    public void ingresarNuevoMaterial(Material p) {
        materiales.add(p);
    }

    public void eliminarProducto(String id) {
        Producto o = null;
        for (int i = 0; i < productos.size(); i++) {
            o = productos.get(i);
            if (o.getId().equals(id)) {
                productos.remove(i);
            }
        }

    }

    public void eliminarMaterial(String m) {
        Iterator<Material> it = materiales.iterator();
        int posicion = 0;
        String nombre = m;
        while (it.hasNext()) {
            Material o = it.next();
            if (o.getNombre().equals(nombre)) {
                materiales.remove(posicion);
            }
            posicion = posicion + 1;
        }
    }
}
