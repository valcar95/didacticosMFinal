/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI.Clientes;

import didacticosmusicales.Autenticacion.moduloautenticacion.Rol;
import didacticosmusicales.Personal.Aplicacion.Implementaciones.ClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Interfaces.IClienteCtrl;
import didacticosmusicales.Personal.Aplicacion.Utilidades.Response;
import didacticosmusicales.Personal.Dominio.Entidades.Cliente;
import didacticosmusicales.Personal.UI.Utilidades.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author XGAnalista2
 */
public class ClientesLista extends javax.swing.JPanel {

    private IClienteCtrl clienteCtrl;
    private DefaultTableModel tblModel;
    
    /**
     * Creates new form ClientesLista
     */
    public ClientesLista() {
        initComponents();
        this.clienteCtrl= new ClienteCtrl();
        this.CargarClientes();
        btnNuevoCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MostrarTrabajadorForm("");
            }
        });
    }

    
     private void iniciarModeloTabla(){
        tblModel= new DefaultTableModel();
        tblModel.addColumn("Cedula");
        tblModel.addColumn("Nombre");
        tblModel.addColumn("Celular");
        tblModel.addColumn("Correo");
        tblModel.addColumn("Dirección");
        tblModel.addColumn("Tipo de cliente");
        tblModel.addColumn("");
        tblModel.addColumn("");
    }

    private void CargarClientes(){
        this.iniciarModeloTabla();
        Response<List<Cliente>> consulta=this.clienteCtrl.ObtenerClientes();
        if(consulta.isExitoso()){
            List<Cliente> clientes=consulta.getEntidad();

            for (Cliente c:clientes) {
                tblModel.addRow(new Object[]{c.getCedula(),c.getNombre(),c.getCelular(),c.getCorreo(),c.getDireccion(),c.getTipoCliente().getDescripcion(),"Modificar","Eliminar"});
            }
            tablaClientes.setCellSelectionEnabled(false);
            tablaClientes.setModel(tblModel);
            tablaClientes.setRowHeight(30);
            this.add(panelClientes);
        }
        Rol k = new Rol();
        if(k.getRol().equals("AdministradorPersonal         ")){
            this.AgregarBotonesTabla();            
        }else{
            btnNuevoCliente.setVisible(false);            
        }

        
    }

    private void AgregarBotonesTabla(){
        this.AgregarBotonModificacion();
        this.AgregarBotonEliminacion();
    }

    private void AgregarBotonModificacion(){
        Action update = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                JTable table = (JTable)e.getSource();
                int modelRow = Integer.valueOf( e.getActionCommand() );
                String cedula=((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString();
                MostrarTrabajadorForm(cedula);
            }
        };

        ButtonColumn buttonColumn = new ButtonColumn(tablaClientes, update, 6);
    }

    private void AgregarBotonEliminacion(){
        Action delete = new AbstractAction()
        {
            public void actionPerformed(ActionEvent e)
            {
                int dialogResult = JOptionPane.showConfirmDialog (null, "¿Realemnte desea eliminar al cliente?","Confirmar eliminación",JOptionPane.YES_NO_OPTION);
                if(dialogResult == JOptionPane.YES_OPTION){
                    JTable table = (JTable)e.getSource();
                    int modelRow = Integer.valueOf( e.getActionCommand() );
                    String cedula=((DefaultTableModel)table.getModel()).getValueAt(modelRow,0).toString();
                    Response<Boolean> eliminacionT= clienteCtrl.EliminarClientePorCedula(cedula);
                    if(eliminacionT.isExitoso()){
                        ((DefaultTableModel)table.getModel()).removeRow(modelRow);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Hubo un problema al realizar la eliminación","Error",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(tablaClientes, delete, 7);
    }

    private void MostrarTrabajadorForm(String cedula){
        JFrame jframe = new ClienteForm(cedula);
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.setVisible(true);
        jframe.addWindowListener( new WindowAdapter()
        {
            @Override
            public void windowClosed(WindowEvent e) {
                CargarClientes();
            }
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelClientes = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnNuevoCliente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();

        panelClientes.setLayout(new java.awt.CardLayout());

        btnNuevoCliente.setText("Nuevo Cliente");

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoCliente)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnNuevoCliente)
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
        );

        panelClientes.add(jPanel1, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevoCliente;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}
