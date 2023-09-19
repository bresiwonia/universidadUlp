
package vista;

public class MenuPrincipal extends javax.swing.JFrame {

 
    public MenuPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenuItem1 = new javax.swing.JMenu();
        jMenuFAlumno = new javax.swing.JMenuItem();
        jmMateria = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jmAdministracion = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jmConsultas = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jmSalir = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 445, Short.MAX_VALUE)
        );

        jMenuItem1.setText("Alumno");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });

        jMenuFAlumno.setText("Formulario de Alumno");
        jMenuFAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuFAlumnoActionPerformed(evt);
            }
        });
        jMenuItem1.add(jMenuFAlumno);

        jMenuBar1.add(jMenuItem1);

        jmMateria.setText("Materia");

        jMenuItem2.setText("jMenuItem2");
        jmMateria.add(jMenuItem2);

        jMenuBar1.add(jmMateria);

        jmAdministracion.setText("Administración");

        jMenuItem3.setText("Manejo de Inscripciones");
        jmAdministracion.add(jMenuItem3);

        jMenuItem4.setText("Manipulación de Notas");
        jmAdministracion.add(jMenuItem4);

        jMenuBar1.add(jmAdministracion);

        jmConsultas.setText("Consultas");

        jMenuItem5.setText("Alumnos por Materia");
        jmConsultas.add(jMenuItem5);

        jMenuBar1.add(jmConsultas);

        jmSalir.setText("Salir");
        jMenuBar1.add(jmSalir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 460, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuFAlumnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuFAlumnoActionPerformed
        // TODO add your handling code here:
        
        escritorio.removeAll();
        escritorio.repaint();
        AlumnoView formulario = new AlumnoView(); 
        formulario.setVisible(true);
        escritorio.add(formulario);
        escritorio.moveToFront(formulario);
                                        
    }//GEN-LAST:event_jMenuFAlumnoActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
                
          
            }
        }); 
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuFAlumno;
    private javax.swing.JMenu jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenu jmAdministracion;
    private javax.swing.JMenu jmConsultas;
    private javax.swing.JMenu jmMateria;
    private javax.swing.JMenu jmSalir;
    // End of variables declaration//GEN-END:variables
}