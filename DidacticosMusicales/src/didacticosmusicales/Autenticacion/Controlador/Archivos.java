package didacticosmusicales.Autenticacion.Controlador;

import java.io.*;

/**
 *
 * @author joiner.herrera
 */
public class Archivos {
    String texto = "";
    
    //Metodo para sobreescribir en un archivo plano .txt previamente existente
    //Bien sea el log de errores o la base de datos
    
    public void escribirTxt(String direccion, String texto, String usuarioNuevo){
        File f;
        FileWriter w;
        BufferedWriter bw;
        PrintWriter wr;
        
        try{
            f=new File(direccion);
            w=new FileWriter(f);
            bw=new BufferedWriter(w);
            wr=new PrintWriter(bw);
            
           
            wr.append( texto + usuarioNuevo);
            
            wr.close();
            
        }catch(Exception e){
            System.err.println("No se encontro archivo");
            
        }
    }
    
    //permite buscar en el computador mediante una direcion el archvo de texto a leer y lo almacena en un STring 
    public String leerTxt(String direccion){
        try{
            BufferedReader bf = new BufferedReader(new FileReader(direccion));
            String temp = "";
            String bfRead;
            while((bfRead = bf.readLine()) != null){
                temp = temp + bfRead; //Guardado el texto del archivo
                
            }
            texto = temp;
        }catch(Exception e){
            System.err.println("No se encontro archivo");
        }
        
        return texto;
    }
    
}