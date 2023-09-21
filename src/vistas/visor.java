package vistas;

import clases.consultas.consultasproducido;
import clases.modelos.Producido;
import clases.propiedades2;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import java.util.Properties;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FONSYS
 */
public class visor extends javax.swing.JFrame {

    /**
     * Creates new form visor
     */
    public List<Producido> listprod ;
    public List<Producido> listprodgrup ;
    DecimalFormat formateador = new DecimalFormat("###,###");
    DecimalFormat formateador2 = new DecimalFormat("###,###.##");
    Dimension pantalla;
    String zrutaimagen ="";
    boolean zvariablecontrol = false;
    int ztiempopubl1 = 2000;
    int ztiempopubl = 2000;
    int ztiempoletr = 80;
    imagen1 img = new imagen1();
    imagen2 img2 = new imagen2();
    imagen3 img3 = new imagen3();
    DefaultTableCellRenderer alinearCentro, alinearDerecha, alinearIzquierda;  
    int x,y;
    
    public visor() throws IOException {
        
        initComponents();
        this.setLayout(null);
        this.setResizable(true);
        //this.setUndecorated(true);
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/resources/iconovisor.png"));
        Image image = ImageIcon.getImage();
        this.setIconImage(image);
        this.setExtendedState(NORMAL);
        capturaResolucion();   
        ObtenerConfiguracion(); 
        zvariablecontrol = true;
        img.start();
        img2.start();
        img3.start();   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menusalir = new javax.swing.JPopupMenu();
        opcion3 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        opcion4 = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        opcion5 = new javax.swing.JMenuItem();
        opcion6 = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        opcion1 = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        opcion2 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        opcion3.setText("Configuración");
        opcion3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion3ActionPerformed(evt);
            }
        });
        Menusalir.add(opcion3);
        Menusalir.add(jSeparator1);

        opcion4.setText("Aplicar Cambios");
        opcion4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion4ActionPerformed(evt);
            }
        });
        Menusalir.add(opcion4);
        Menusalir.add(jSeparator4);

        opcion5.setText("Minimizar");
        opcion5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion5ActionPerformed(evt);
            }
        });
        Menusalir.add(opcion5);

        opcion6.setText("Maximizar");
        opcion6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion6ActionPerformed(evt);
            }
        });
        Menusalir.add(opcion6);
        Menusalir.add(jSeparator5);

        opcion1.setText("Salir de la Aplicación");
        opcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcion1ActionPerformed(evt);
            }
        });
        Menusalir.add(opcion1);
        Menusalir.add(jSeparator3);

        opcion2.setText("Cancelar");
        Menusalir.add(opcion2);
        Menusalir.add(jSeparator2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel3.setComponentPopupMenu(Menusalir);

        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel1.setComponentPopupMenu(Menusalir);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("jLabel2");
        jLabel2.setComponentPopupMenu(Menusalir);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLabel2MouseDragged(evt);
            }
        });
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel2MousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("jLabel2");
        jLabel5.setComponentPopupMenu(Menusalir);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 51));
        jLabel4.setText("jLabel4");

        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jLabel6.setComponentPopupMenu(Menusalir);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void opcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion1ActionPerformed
        System.exit(0);
        //dispose();
    }//GEN-LAST:event_opcion1ActionPerformed

    private void opcion3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion3ActionPerformed
        try {
            //propiedades configuracion = new propiedades(this,true);
            propiedades2 configuracion = new propiedades2();
            configuracion.setAlwaysOnTop(true); //Esto nos permite que el jFrame sea un modal
            configuracion.setVisible(true);
            //showOnScreen(2,configuracion,1);
            
        } catch (IOException ex) {
            Logger.getLogger(visor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_opcion3ActionPerformed

    private void opcion4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion4ActionPerformed
        zvariablecontrol = false;
        ObtenerConfiguracion();
        pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        zvariablecontrol = true;
        //new Thread(img).start();
       // img.start();
        //img2.start();
        //img3.start();           
    }//GEN-LAST:event_opcion4ActionPerformed

    private void jLabel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MousePressed
       x = evt.getX();
       y = evt.getY();
    }//GEN-LAST:event_jLabel2MousePressed

    private void jLabel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseDragged
         this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_jLabel2MouseDragged

    private void opcion5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion5ActionPerformed
        this.setExtendedState(NORMAL);
    }//GEN-LAST:event_opcion5ActionPerformed

    private void opcion6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcion6ActionPerformed
        this.setExtendedState(MAXIMIZED_BOTH);
    }//GEN-LAST:event_opcion6ActionPerformed

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
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(visor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    visor vistaprincipal = new visor();
                    vistaprincipal.setVisible(true);
                    //vistaprincipal.setAlwaysOnTop(true);
                    //showOnScreen(2,vistaprincipal,2);
                    
                } catch (IOException ex) {
                    Logger.getLogger(visor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
   
    private class imagen1 extends Thread {
        @Override
        public void run(){
            ImageIcon icono = new ImageIcon();
            int z= Image.SCALE_AREA_AVERAGING;

            //int zalto2  = jLabel1.getHeight();   //670;
            File f = new File(zrutaimagen);
            try {
                while (zvariablecontrol){                     
                    capturaResolucion();
                    jLabel6.setBounds(10,101,pantalla.width-520,pantalla.height-180);
                    jLabel6.setHorizontalAlignment((int) CENTER_ALIGNMENT);
                    int zalto2  = jLabel6.getHeight();
                    int zancho2 = jLabel6.getWidth();
                    File[] ficheros = f.listFiles();
                    jLabel2.setText("");
                    for (int x=0;x<ficheros.length;x++){
                        if ((ficheros[x].getName().toLowerCase().endsWith(".jpg") || ficheros[x].getName().toLowerCase().endsWith(".jpeg") || ficheros[x].getName().toLowerCase().endsWith(".png") ||
                           ficheros[x].getName().toLowerCase().endsWith(".gif") || ficheros[x].getName().toLowerCase().endsWith(".bmp")) && ficheros[x].getName().substring(0,3).equals("ID_") ){
                           icono = new ImageIcon(new ImageIcon(zrutaimagen + ficheros[x].getName()).getImage().getScaledInstance(zancho2,zalto2,z));
                           jLabel6.setIcon(icono);
                           Thread.sleep(ztiempopubl1);
                        }
                        jLabel2.setText(ficheros[x].getName());
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(visor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    } 
    private class imagen2 extends Thread {
        @Override
        public void run(){
            ImageIcon icono = new ImageIcon();
            int z= Image.SCALE_AREA_AVERAGING;
            int zancho2 = 500;
            //int zalto2  = jLabel1.getHeight();   //670;
            File f = new File(zrutaimagen);
            try {
                while (zvariablecontrol){                     
                    capturaResolucion();
                    jLabel1.setBounds(pantalla.width-500,101,490,pantalla.height-180);
                    int zalto2  = jLabel1.getHeight();
                    File[] ficheros = f.listFiles();
                    for (int x=0;x<ficheros.length;x++){
                        if (ficheros[x].getName().toLowerCase().endsWith(".jpg") || ficheros[x].getName().toLowerCase().endsWith(".jpeg") || ficheros[x].getName().toLowerCase().endsWith(".png") ||
                           ficheros[x].getName().toLowerCase().endsWith(".gif") || ficheros[x].getName().toLowerCase().endsWith(".bmp")){
                           icono = new ImageIcon(new ImageIcon(zrutaimagen + ficheros[x].getName()).getImage().getScaledInstance(zancho2,zalto2,z));
                           jLabel1.setIcon(icono);
                           Thread.sleep(ztiempopubl);
                        }
                    }
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(visor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    

     private class imagen3 extends Thread {
         String letrero="";
         @Override
         public void run(){
            try{
                File f;
                //FileReader lectorArchivo;
                f = new File(zrutaimagen+"letrero.txt");
                FileReader lectorArchivo = new FileReader(f);
                BufferedReader br = new BufferedReader(lectorArchivo);
                
                String aux="";/*variable auxiliar*/
                while(zvariablecontrol){
                    aux=br.readLine();
                    if(aux!=null)
                      letrero=letrero+aux;
                    else
                      break;
                }
                br.close();
                lectorArchivo.close();
            }catch(IOException e){
                System.out.println("Error al Leer Archivo : "+e.getMessage());
            }
 
            try {
                int zposicion=0;
                int zancho=0;
                int zancho3=0;  // 80;
//               String zespacios = "%1$"+zancho3+"s";
//               letrero=String.format(letrero,zespacios);
                int zlargotexto= letrero.length();
                capturaResolucion();
                zancho3= (int)((pantalla.width * 5.8)/100);
                jLabel3.setBounds(0,pantalla.height-80, pantalla.width-10,70);
                jLabel3.setHorizontalAlignment(4);  // ALINEAMIENTO A LA DERECHA
                while (true){ 
                    zancho ++;
                    if (zancho > (zancho3-1)){
                       zposicion ++;
                    }
                    if (zposicion == zlargotexto){
                       zancho = 0; 
                       zposicion =0;
                       jLabel3.setHorizontalAlignment(4);  // ALINEAMIENTO A LA DERECHA
                    }
                    if (zancho >= zancho3){
                       jLabel3.setHorizontalAlignment(2); // ALINEAMIENTO A LA IZQUIERDA
                    }                    
                    if (zancho >= zlargotexto  & zposicion < zlargotexto){
                       zancho = zlargotexto; 
                       jLabel3.setHorizontalAlignment(2); // ALINEAMIENTO A LA IZQUIERDA
                    }
                    jLabel3.setText(letrero.substring(zposicion, zancho));
                    Thread.sleep(ztiempoletr);
                    
                }
             } catch (InterruptedException ex) {
                 Logger.getLogger(visor.class.getName()).log(Level.SEVERE, null, ex);
             }
         }
     } 
     public void abrirarchivo(String archivo){

     try {

            File objetofile = new File (archivo);
            Desktop.getDesktop().open(objetofile);

     }catch (IOException ex) {

            System.out.println(ex);

     }

    }
    
    public List<Producido> FiltrarGrupo(String Grp )
    {
        Predicate<Producido> filtroGrupo = new Predicate<Producido>() {
           @Override
           public boolean test(Producido p) {
                  return p.getGrupo().equals(Grp);
            }   
        };
        List<Producido> grpfi = listprod.stream().filter(filtroGrupo).collect(Collectors.toList());
        return grpfi;
    }
    public List<Producido> FiltrarGrupoOrdenado(String Grp)
    {
        List<Producido> filtroGrupo = 
        listprod.parallelStream()
        .filter(x -> x.getGrupo().equals(Grp))
        .sorted((x,y)-> x.getNumeroveh().compareTo(y.getNumeroveh()))
        //.distinct()
        .collect(toList());         
        return filtroGrupo;
    }    
    public void ObtenerConfiguracion()
    {        
         //***********Obtener configuracion *********
        try {
            Properties p = new Properties();
                // p.load(getClass().getResourceAsStream("config.properties"));
                //p.load(this.getClass().getClassLoader().getResourceAsStream("config.properties"));
                FileReader archivo = new FileReader((System.getProperty("user.dir")+ "\\config.properties"));
                p.load(archivo);
                zrutaimagen = p.getProperty("rutaimagen");
                ztiempopubl1 = Integer.valueOf(p.getProperty("tiempoprod"));
                ztiempopubl = Integer.valueOf(p.getProperty("tiempopubl"));
                ztiempoletr = Integer.valueOf(p.getProperty("tiempoletr"));          
        } catch (Exception e) {
            System.out.println(e);
        }
            
        //***********Fin Obtener configuracion *********
    }
    
    
    public static void showOnScreen( int screen, JFrame frame, int normalofull )
    {
        GraphicsEnvironment ge = GraphicsEnvironment
            .getLocalGraphicsEnvironment();
        GraphicsDevice[] gs = ge.getScreenDevices();
        if( screen > -1 && screen < gs.length )
        {
            gs[screen].setFullScreenWindow( frame );
        }
        else if( gs.length > 0 )
        {
            if(normalofull==1){
                frame.setExtendedState(NORMAL);                        // colocamos tamanio a la ventana (ancho, alto)
                frame.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla 
                frame.setAlwaysOnTop(true);
            }else{
              gs[0].setFullScreenWindow( frame );
            }  
        }
        else
        {
            throw new RuntimeException( "No Screens Found" );
        }
    }    
    public void capturaResolucion(){
       pantalla = Toolkit.getDefaultToolkit().getScreenSize();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Menusalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JMenuItem opcion1;
    private javax.swing.JMenuItem opcion2;
    private javax.swing.JMenuItem opcion3;
    private javax.swing.JMenuItem opcion4;
    private javax.swing.JMenuItem opcion5;
    private javax.swing.JMenuItem opcion6;
    // End of variables declaration//GEN-END:variables
}