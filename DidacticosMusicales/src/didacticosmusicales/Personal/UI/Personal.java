/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package didacticosmusicales.Personal.UI;

import didacticosmusicales.Personal.UI.Clientes.ClientesLista;
import didacticosmusicales.Personal.UI.Clientes.TiposCliente.TiposClienteLista;
import didacticosmusicales.Personal.UI.Horarios.HorariosLista;
import didacticosmusicales.Personal.UI.Servicios.ServiciosLista;
import didacticosmusicales.Personal.UI.Trabajadores.TrabajadoresLista;

/**
 *
 * @author XGAnalista2
 */
public class Personal extends javax.swing.JFrame {

    /**
     * Creates new form Personal
     */
    public Personal() {
        super("Personal");
        initComponents();
        setContentPane(panelPrincipal);
        panelTrabajadores.add(new TrabajadoresLista());
        panelTiposCliente.add(new TiposClienteLista());
        panelClientes.add(new ClientesLista());
        panelHorarios.add(new HorariosLista());
        panelServicios.add(new ServiciosLista());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPrincipal = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelTrabajadores = new javax.swing.JPanel();
        panelTiposCliente = new javax.swing.JPanel();
        panelClientes = new javax.swing.JPanel();
        panelHorarios = new javax.swing.JPanel();
        panelServicios = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelTrabajadores.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Trabajadores", panelTrabajadores);

        panelTiposCliente.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Tipos de clientes", panelTiposCliente);

        panelClientes.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Clientes", panelClientes);

        panelHorarios.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Horarios laborales", panelHorarios);

        panelServicios.setLayout(new java.awt.CardLayout());
        jTabbedPane1.addTab("Servicios", panelServicios);

        javax.swing.GroupLayout panelPrincipalLayout = new javax.swing.GroupLayout(panelPrincipal);
        panelPrincipal.setLayout(panelPrincipalLayout);
        panelPrincipalLayout.setHorizontalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 740, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelPrincipalLayout.setVerticalGroup(
            panelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPrincipalLayout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel panelClientes;
    private javax.swing.JPanel panelHorarios;
    private javax.swing.JPanel panelPrincipal;
    private javax.swing.JPanel panelServicios;
    private javax.swing.JPanel panelTiposCliente;
    private javax.swing.JPanel panelTrabajadores;
    // End of variables declaration//GEN-END:variables
}
