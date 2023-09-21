/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author FONSYS
 */
public class propiedades extends JDialog implements ActionListener {
    private JButton boton;
    private JLabel label;
    private JTextField textfield;
    public propiedades(JFrame principal,boolean modal)  {
        //super("Formulario Basico");
        super(principal,modal);
        //getContentPane().setLayout(new FlowLayout());
        setLayout(null);
        setBounds(440,10,500,400);        
        label = new JLabel("Introduce tu nombre:");
        textfield = new JTextField("nombre",20);
        boton = new JButton("Enviar");
        getContentPane().add(label);
        getContentPane().add(textfield);
        getContentPane().add(boton);
        setSize(400,300);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
		if (e.getSource() == boton) {
			/* Inicializo y muestro la segunda pantalla con los argumentos this (JFrame) y true (modal) */
			setVisible(false);
		}
    }
    
    
}
