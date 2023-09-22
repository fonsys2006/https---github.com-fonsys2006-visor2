/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author FONSYS
 */
public class propiedades2 extends JFrame implements ActionListener {
    JButton btnguardar,btncancelar,btndir;
    JLabel label1,label2,label3,label4,label5;
    JTextField textfield1;
    static JSlider tiempo1,tiempo2,tiempo3;
    static JLabel labeltiempo1,labeltiempo2,labeltiempo3;
    Properties p = new Properties();
    public propiedades2() throws IOException  {
        super("Configuración");
        //getContentPane().setLayout(new FlowLayout());
        this.setBounds(440,10,600,420);                         // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        ImageIcon ImageIcon = new ImageIcon(getClass().getResource("/resources/iconovisor.png"));
        Image image = ImageIcon.getImage();
        this.setIconImage(image);

        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso        
        
        
        label1 = new JLabel("CONFIGURACION DE TIEMPOS DE ESPERA DE IMAGENES");
        label1.setBounds(80, 0, 400, 25);
        label1.setForeground(Color.blue);
        label2 = new JLabel("Ruta de las Imagenes :");
        label2.setBounds(50, 40, 300, 25);   
        textfield1 = new JTextField("",250);
        textfield1.setBounds(50, 70, 400, 35); 
        textfield1.setEnabled(false);
        textfield1.setDisabledTextColor(Color.red);
        
        //* Tiempo Muestra Publicidad 1
        label3 = new JLabel("Tiempo Muestra Publicidad 1 :");
        label3.setBounds(50, 115, 170, 25);   
        labeltiempo1 = new JLabel("0   seg.");
        labeltiempo1.setBounds(430, 115, 60, 25); 
        labeltiempo1.setForeground(Color.red);
        tiempo1 = new JSlider(JSlider.HORIZONTAL, 0, 50, 25);
        tiempo1.setBounds(220, 115, 200, 50);
        tiempo1.setInverted(false);
        tiempo1.setPaintTicks(true);
        tiempo1.setMajorTickSpacing(10);
        tiempo1.setMinorTickSpacing(5);
        tiempo1.setPaintLabels(true);
        tiempo1.addChangeListener(new cambiotiempo());       
        //* Fin Tiempo Muestra Publicidad 1

        //* Tiempo Muestra Publicidad 2
        label4 = new JLabel("Tiempo Muestra Publicidad 2 :");
        label4.setBounds(50, 180, 170, 25);
        labeltiempo2 = new JLabel("0   seg.");
        labeltiempo2.setBounds(430, 180, 60, 25); 
        labeltiempo2.setForeground(Color.red);
        tiempo2 = new JSlider(JSlider.HORIZONTAL, 0, 120, 25);
        tiempo2.setBounds(220, 180, 200, 50);
        tiempo2.setInverted(false);
        tiempo2.setPaintTicks(true);
        tiempo2.setMajorTickSpacing(20);
        tiempo2.setMinorTickSpacing(10);
        tiempo2.setPaintLabels(true);
        tiempo2.addChangeListener(new cambiotiempo());       
        //* Fin Tiempo Muestra Publicidad 2
        
        //* Tiempo Velocidad Mensajes
        label5 = new JLabel("Velocidad Mensajes de Texto:");
        label5.setBounds(50, 245, 170, 25);   
        labeltiempo3 = new JLabel("0 ");
        labeltiempo3.setBounds(430, 245, 60, 25); 
        labeltiempo3.setForeground(Color.red);
        tiempo3 = new JSlider(JSlider.HORIZONTAL, 0, 20, 5);
        tiempo3.setBounds(220, 245, 200, 50);
        tiempo3.setInverted(false);
        tiempo3.setPaintTicks(true);
        tiempo3.setMajorTickSpacing(10);
        tiempo3.setMinorTickSpacing(1);
        tiempo3.setPaintLabels(true);
        tiempo3.addChangeListener(new cambiotiempo());       
        //* Fin Tiempo Velocidad Mensajes
                   
        btnguardar = new JButton("Guardar");   
        btnguardar.setBounds(150, 320, 100, 30); 
        btnguardar.addActionListener(this);
        
        btncancelar = new JButton("Cancelar");   
        btncancelar.setBounds(300, 320, 100, 30); 
        btncancelar.addActionListener(this);     

        btndir = new JButton("Buscar");   
        btndir.setBounds(460, 70, 80, 35); 
        btndir.addActionListener(this);     
        
        getContentPane().add(label1);
        getContentPane().add(label2);
        getContentPane().add(label3);
        getContentPane().add(label4);
        getContentPane().add(label5);
        getContentPane().add(textfield1);
        getContentPane().add(btnguardar);
        getContentPane().add(btncancelar);
        getContentPane().add(btndir);
        getContentPane().add(tiempo1);
        getContentPane().add(labeltiempo1);
        getContentPane().add(tiempo2);
        getContentPane().add(labeltiempo2);
        getContentPane().add(tiempo3);
        getContentPane().add(labeltiempo3);

        setVisible(true);
        //p.load(getClass().getResourceAsStream("config.properties"));
        //p.load(getClass().getResourceAsStream("//config.properties"));
        //p.load(this.getClass().getClassLoader().getResourceAsStream("/resources/config.properties"));
        FileReader archivo = new FileReader((System.getProperty("user.dir")+ "\\config.properties"));
        p.load(archivo);
        textfield1.setText(p.getProperty("rutaimagen"));
        tiempo1.setValue(Integer.valueOf(p.getProperty("tiempoprod"))/1000);
        labeltiempo1.setText(Integer.toString(tiempo1.getValue()) + String.format("%1$3s"," ") + "Seg.");
        tiempo2.setValue(Integer.valueOf(p.getProperty("tiempopubl"))/1000);
        labeltiempo2.setText(Integer.toString(tiempo2.getValue()) + String.format("%1$3s"," ") + "Seg.");
        tiempo3.setValue(Integer.valueOf(p.getProperty("tiempoletr"))/10);
        labeltiempo3.setText(Integer.toString(tiempo3.getValue()));        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btncancelar) {
			setVisible(false);
		}
		if (e.getSource() == btnguardar) {
                    //File archivo = new File(this.getClass().getResource("config.properties").getFile().replace("%20", " "));
                     // File archivo = new File(this.getClass().getResourceAsStream("/config.properties"));
                      //File archivo = new File(this.getClass().getClassLoader().getResource("config.properties").getFile().replace("%20", " "));
//                     FileReader archivo;
//                    try {
//                        archivo = new FileReader((System.getProperty("user.dir")+ "\\config.properties"));
//                    } catch (FileNotFoundException ex) {
//                        Logger.getLogger(propiedades2.class.getName()).log(Level.SEVERE, null, ex);
//                    }
                    try {
                        p.setProperty("rutaimagen", textfield1.getText());
                        p.setProperty("tiempoprod",String.valueOf(tiempo1.getValue()*1000));
                        p.setProperty("tiempopubl",String.valueOf(tiempo2.getValue()*1000));
                        p.setProperty("tiempoletr",String.valueOf(tiempo3.getValue()*10));
                        FileOutputStream arch= new FileOutputStream((System.getProperty("user.dir")+ "\\config.properties"));    //FileOutputStream(archivo.toString().replace("\\", "/"));
                        p.store(arch,null);
                        JOptionPane.showMessageDialog(this, "Configuración Guardada exitosamente...");
                        setVisible(false);                       
                    } catch (IOException ex) {
                        Logger.getLogger(propiedades2.class.getName()).log(Level.SEVERE, null, ex);
                    }                       	    
		}
		if (e.getSource() == btndir) {
		    javax.swing.JFileChooser zdialogo= new javax.swing.JFileChooser();
                    zdialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    //zdialogo.showOpenDialog(this);
                    int returnVal = zdialogo.showOpenDialog(this); 
                    if(returnVal == JFileChooser.APPROVE_OPTION) { 
                       String path= zdialogo.getSelectedFile().getAbsolutePath();
                       textfield1.setText(path.concat("\\"));                      
                    }
                }
                
    }
    
    public static class cambiotiempo implements ChangeListener{

        public void stateChanged(ChangeEvent e){
           int ztiempo1 = tiempo1.getValue();
           String ztiem1 = Integer.toString(ztiempo1) + String.format("%1$3s"," ") + "Seg.";
           labeltiempo1.setText(ztiem1);

           int ztiempo2 = tiempo2.getValue();
           String ztiem2 = Integer.toString(ztiempo2) + String.format("%1$3s"," ") + "Seg.";
           labeltiempo2.setText(ztiem2);

           int ztiempo3 = tiempo3.getValue();
           String ztiem3 = Integer.toString(ztiempo3);
           labeltiempo3.setText(ztiem3);
           
           
        }
    } 

}
