/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.Aplicacion.Adaptadores.Implementaciones;

import didacticosmusicales.Personal.Aplicacion.Adaptadores.Interfaces.IMaterialesAdaptador;
import didacticosmusicales.Personal.Dominio.Entidades.Material;
import didacticosmusicales.ProduccionF.Dominio.Inventario;
import didacticosmusicales.ProduccionF.Dominio.Producto;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author XGAnalista2
 */
public class MaterialesAdaptador implements IMaterialesAdaptador {

    private List<Material> materiales;
    
    public MaterialesAdaptador(){
     this.materiales= new ArrayList<Material>();
     materiales.add(new Material(1,"Material 1"));
     materiales.add(new Material(2,"Material 2"));
     materiales.add(new Material(3,"Material 3"));
     materiales.add(new Material(4,"Material 4"));
     materiales.add(new Material(5,"Material 5"));
    }
    
     @Override
    public List<Material> ObtenerMateriales() {
        List<Material> lista=new ArrayList<>();
       List<Producto> productos;
        try {
            productos = Inventario.ObtenerProductos();
             for (Producto m:productos
             ) {
                lista.add(new Material(Integer.parseInt(m.getId()),m.getNombre()));
            
            }
            return lista;
        } catch (IOException ex) {
            return null;
        }
           
    }

    @Override
    public List<Material> ObtenerMaterialesPorIds(List<Integer> ids) {
        List<Material> result=new ArrayList<Material>();
        for (int id:ids
             ) {
            Material m=this.ObtenerMaterialPorId(id);
            if(m!=null){
                result.add(m);
            }
        }
        return result;
    }

    @Override
    public Material ObtenerMaterialPorId(int id) {
        try {
            List<Producto> productos=Inventario.ObtenerProductos();
            for (Producto m:productos
             ) {
            if(m.getId()==String.valueOf(id)){
                return new Material(Integer.parseInt(m.getId()),m.getNombre());
            }
            return null;
        }
        return null;
        } catch (IOException ex) {
            return null;
        }
        
    }
    
}
