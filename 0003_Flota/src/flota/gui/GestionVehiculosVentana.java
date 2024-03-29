/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flota.gui;

import flota.dominio.Caja;
import flota.dominio.Camion;
import flota.dominio.Excepciones.CajaExcepcion;
import flota.dominio.Excepciones.VehiculoExcepcion;
import flota.dominio.Vehiculo;
import javax.swing.JOptionPane;

/**
 *
 * @author begonaolea
 */
public class GestionVehiculosVentana extends javax.swing.JFrame {

    //ATRIBUTOS 
    //vehiculo que usare en la pantalla
    // y al que cargaré cajas
    private Vehiculo vehiculo;

    /**
     * Creates new form GestionVehiculosVentana
     */
    public GestionVehiculosVentana() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmpMatricula = new javax.swing.JTextField();
        cmdCrearVehiculo = new javax.swing.JButton();
        lbListado = new javax.swing.JLabel();
        listaCajas = new javax.swing.JScrollPane();
        lista = new javax.swing.JTextArea();
        lbTotales = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmdCargar = new javax.swing.JButton();
        cmpPesoCaja = new javax.swing.JTextField();
        cmbDescargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Matrícula:");

        cmdCrearVehiculo.setText("Crear Vehiculo");
        cmdCrearVehiculo.setToolTipText("");
        cmdCrearVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCrearVehiculoActionPerformed(evt);
            }
        });

        lbListado.setText("Lista de cajas cargadas para el vehículo ");

        lista.setColumns(20);
        lista.setLineWrap(true);
        lista.setRows(5);
        listaCajas.setViewportView(lista);

        lbTotales.setBackground(new java.awt.Color(204, 204, 0));
        lbTotales.setText("Totales:");
        lbTotales.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Peso Caja:");

        cmdCargar.setText("Cargar");
        cmdCargar.setToolTipText("");
        cmdCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCargarActionPerformed(evt);
            }
        });

        cmpPesoCaja.setText("100");

        cmbDescargar.setText("Descargar");
        cmbDescargar.setToolTipText("");
        cmbDescargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDescargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmpPesoCaja)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmdCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbDescargar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lbListado)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmpMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cmdCrearVehiculo))
                        .addComponent(listaCajas)
                        .addComponent(lbTotales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmpMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdCrearVehiculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbListado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(listaCajas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmdCargar)
                    .addComponent(cmpPesoCaja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDescargar))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCrearVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCrearVehiculoActionPerformed

        //crear un Vehiculo con la matrícula indicada
        //leer matricula
        String matricula = this.cmpMatricula.getText();

        vehiculo = new Camion(matricula);

        String titulo = this.lbListado.getText()
                + vehiculo.getMatricula();

        this.lbListado.setText(titulo);


    }//GEN-LAST:event_cmdCrearVehiculoActionPerformed

    private void cmdCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCargarActionPerformed

        //leer peso y lo convierto en un double
        //crear una caja con el peso
        //añadir caja al vehículo
        //mostrar listado y totales
        String sPeso = this.cmpPesoCaja.getText();
        try{
            double dPeso = Double.parseDouble(sPeso);

            Caja c = new Caja(dPeso);
            this.vehiculo.cargar(c);

            refrescarListadoyTotales();
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "El peso debe ser numérico");
        }catch(CajaExcepcion e1){
            System.err.println("Error: " + e1.getMessage());
            JOptionPane.showMessageDialog(this, "El peso no puede ser negativo");
        }catch(VehiculoExcepcion e2){
            System.err.println("Error: " + e2.getMessage());
            if(e2.getExcesoDePeso()==0){
                JOptionPane.showMessageDialog(this, "Se ha alcanzado el límite de cajas");
            }
            else{
                JOptionPane.showMessageDialog(this, "La caja supera en "+ e2.getExcesoDePeso()+" kg el peso máximo del vehículo");
            }
        }

    }//GEN-LAST:event_cmdCargarActionPerformed

    private void cmbDescargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDescargarActionPerformed

        //descargar la ultima caja
        this.vehiculo.descargar();
        refrescarListadoyTotales();
    }//GEN-LAST:event_cmbDescargarActionPerformed

    private void refrescarListadoyTotales(){
        //refrescar dados lista de cajas  
        //System.out.println("vehiculo " + vehiculo);
        Caja[] listaCajas = this.vehiculo.getCajasCargadas();
        if (listaCajas == null) {
            this.lista.setText("No hay cajas");
        } else {
            this.lista.setText("");
            for (Caja c : listaCajas) {
                this.lista.append("caja " + c.getPeso() + "kg\n");
            }
        }
        //MOSTRAR TOTALES
        String totales = "Totales - peso "
                + this.vehiculo.getCargaActual()
                + " - numero cajas: " + this.vehiculo.getNumCajas();

        this.lbTotales.setText(totales);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GestionVehiculosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionVehiculosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionVehiculosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionVehiculosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionVehiculosVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmbDescargar;
    private javax.swing.JButton cmdCargar;
    private javax.swing.JButton cmdCrearVehiculo;
    private javax.swing.JTextField cmpMatricula;
    private javax.swing.JTextField cmpPesoCaja;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbListado;
    private javax.swing.JLabel lbTotales;
    private javax.swing.JTextArea lista;
    private javax.swing.JScrollPane listaCajas;
    // End of variables declaration//GEN-END:variables
}
