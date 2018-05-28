
package didacticosmusicales.Autenticacion.moduloautenticacion;

import didacticosmusicales.Autenticacion.Controlador.*;
import didacticosmusicales.Personal.*;
import didacticosmusicales.Personal.UI.Personal;
import didacticosmusicales.ProduccionF.Presentacion.FromPrincipal;
import didacticosmusicales.Ventas.Presentacion.VentanaPrincipal1;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.util.Calendar;

/**
 *
 * Autores Juan pablo posada, Joiner Herrera, Santiaog Salazar 
 */
public class Usuario {
    Rol k = new Rol();
    Archivos a = new Archivos();
    //s1 es una variable String que guarda TODO el texto de la bae de datos 
    String s1 =a.leerTxt("C:\\Users\\Juan Pablo\\Desktop\\didacticosMusicales-master\\DidacticosMusicales\\src\\didacticosmusicales\\Autenticacion\\BaseDeDatos\\BaseDatos.txt");

    public Archivos getA() {
        return a;
    }

    public String getS1() {
        return s1;
    }
    
    public void validar(String contraseña, String usuario){
       String rol= "";
       boolean bandera = false;
       if(contraseña.length()<21){
           for(int i=contraseña.length();i<20;i++){
               contraseña = contraseña + " ";
           }           
       }
       
       if(usuario.length()<21){
           for(int i=usuario.length();i<20;i++){
               usuario = usuario + " ";
           }           
       }      
       
       
       for(int i=0; i<s1.length() ;i=i+71){
           
           //Sacamos el usuario de la base de datos 
           String validarUsuario = s1.substring(i,i+20);
           
           
           //Pruebas para solucionar errores encontrados
           System.out.println(validarUsuario);
           System.out.println(usuario);
           System.out.println(s1.length());
           System.out.println(i);
           
           
           if(validarUsuario.equals(usuario) && bandera==false){ 
               
                
               
               String validarContraseña = s1.substring(i+20, i+40);
               
               if(validarContraseña.equals(contraseña)){
                   bandera = true;
                   
                   rol = s1.substring(i+40, i+70);
                   k.setRol(rol);
                   i=s1.length()+10; 
                   
                   //Dependiendo del Rol se accede ccon el Switch a las ventanas y botones a los cuales tiene acceso cada usuario
                   switch(rol)
                   {
                       
                       case "AdministradorPersonal         ":
                           //Aca se enviaria el usuario al modulo personal
                           MainPersonal.AbrirModuloPersonal();
                           
                             
                           break;
                           
                       case "SecretarioPersonal            ":
                           MainPersonal.AbrirModuloPersonal();
                           
                           //Aca se enviaria el usuario al modulo personal
                           break;
                           
                       case "EnviaPedidos                  ":
                           //Aca se enviaria el usuario al modulo de produccion
                           FromPrincipal f = new FromPrincipal();
                           f.setVisible(true);
                           f.desactivarBotonProveedores();
                           f.desactivarBotonProductos();
                           
                           
                           break;
                       case "GestionProductosProveedores   ":
                           //Aca se enviaria el usuario al modulo de produccion
                           FromPrincipal w = new FromPrincipal();
                           w.setVisible(true);
                           w.desactivarBotonMateriales();
                           w.desactivarBotonPedidos();
                           
                           
                           break;
                       
                       case "AdministradorProduccion       ":
                           //Aca se enviaria el usuario al modulo de produccion
                           FromPrincipal q = new FromPrincipal();
                           q.setVisible(true);
                           
                           break;
                           
                       case "Cajero                        ":
                           VentanaPrincipal1 h = new VentanaPrincipal1();
                           h.setVisible(true);
                           
                           h.ocultarBotonListarProductos();
                           h.ocultarBotonRegistrarCliente();
                           
                           //Aca se enviaria el usuario al modulo de ventas
                           break;
                           
                       case "AdministradorVentas           ":
                           VentanaPrincipal1 m = new VentanaPrincipal1();
                           m.setVisible(true);
                           
                           //Aca se enviaria el usuario al modulo de ventas
                           break;
                           
                       default:
                           
                           System.out.println("error");
                           break;
                           
                           
                   }
                        
                   
                                     
               }
               
               
           }
           
             
              
       }
       if(bandera==false){
           //Esta es la parte de logica que nos guarda en la base de datos de log errores los logg-in sin éxito
               Calendar cal=Calendar.getInstance(); 
               String fecha=cal.get(cal.DATE)+"/"+cal.get(cal.MONTH)+"/"+cal.get(cal.YEAR);
               
           //Inserta en la base de datos del archivo plano de errores el usuario, la cotnraseña y la fecha de quien intentó acceder sin exito
               String insertar =  "User: " + usuario + "Contraseña: " + contraseña + "Fecha: " + fecha +" Modulo de autenticacion" +";" + "\n"; 
               Archivos b = new Archivos();
               String s1 =a.leerTxt("C:\\Users\\Juan Pablo\\Desktop\\didacticosMusicales-master\\DidacticosMusicales\\src\\didacticosmusicales\\Autenticacion\\BaseDeDatos\\ErroresAutenticacion.txt");
               a.escribirTxt("C:\\Users\\Juan Pablo\\Desktop\\didacticosMusicales-master\\DidacticosMusicales\\src\\didacticosmusicales\\Autenticacion\\BaseDeDatos\\ErroresAutenticacion.txt", s1 , insertar);
           
               JOptionPane.showMessageDialog(null, "Verificar Usuario y Contraseña ");
           }
       
              
    }
}
