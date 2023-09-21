package com.conversor;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


public class Conversor extends JFrame {
	/**
	 * Conversor de Moneda Rodrigo Valle Sanchez - Grupo 5 Oracle One Education -Alura Latam
	 */
	
	/*
	 * Version 0.1 Septiembre 2023
	 */
	private static final long serialVersionUID = 1L;
	private JTextField medidasC;
	private JComboBox cambioMoneda;
	private JTextField ValorConvertir;
	private JComboBox medidasYtempearturas;
	private JToggleButton Convertir;
	private JLabel Resultado;
	private JToggleButton Conversion;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Conversor() {
		setResizable(false);
		setFont(new Font("Roboto Medium", Font.BOLD, 14));
		setTitle("CONVERSOR");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 500);
		getContentPane().setLayout(null);
		
		JLabel tituloConversorUnidades = new JLabel("CONVERSOR DE MEDIDAS Y TEMPERATURAS");
		tituloConversorUnidades.setFont(new Font("FiraCode Nerd Font", Font.BOLD, 16));
		tituloConversorUnidades.setBounds(22, 10, 357, 14);
		getContentPane().add(tituloConversorUnidades);
		
		JLabel unidadAconvertir = new JLabel("Ingrese la unidad a Convertir");
		unidadAconvertir.setFont(new Font("Roboto", Font.BOLD, 14));
		unidadAconvertir.setBounds(77, 101, 223, 14);
		getContentPane().add(unidadAconvertir);
		
		Resultado = new JLabel("0");
		Resultado.setFont(new Font("Roboto Light", Font.BOLD, 15));
		Resultado.setBounds(363, 276, 235, 30);
		getContentPane().add(Resultado);
		
		JLabel montoAconvertir = new JLabel("Ingrese el monto a convertir");
		montoAconvertir.setFont(new Font("Roboto", Font.BOLD, 14));
		montoAconvertir.setBounds(555, 90, 184, 37);
		getContentPane().add(montoAconvertir);
		
		medidasYtempearturas = new JComboBox();
		medidasYtempearturas.setFont(new Font("Roboto", Font.BOLD, 14));
		medidasYtempearturas.setModel(new DefaultComboBoxModel(new String[] {"Grados Celsisus a Grados Fahrenheit", "Kilometros a Millas", "Metros a Yardas", "Centimetros a Pulgadas", "Grados Fahrenheit a Grados Celsius", "Millas a Kilómetros", "Yardas a Metros", "Pulgadas a Centímetros"}));
		medidasYtempearturas.setBounds(53, 37, 265, 22);
		getContentPane().add(medidasYtempearturas);
		
		JLabel tituloConversorMoneda = new JLabel("CONVERSOR DE MONEDA");
		tituloConversorMoneda.setBounds(555, 11, 198, 13);
		tituloConversorMoneda.setFont(new Font("FiraCode Nerd Font Mono", Font.BOLD, 16));
		getContentPane().add(tituloConversorMoneda);
		
		cambioMoneda = new JComboBox();
		cambioMoneda.setFont(new Font("Roboto", Font.BOLD, 14));
		
		cambioMoneda.setModel(new DefaultComboBoxModel(new String[] {"Pesos Mexicanos a Dólares", 
				"Pesos Mexicanos a Euros", "Pesos Mexicanos a Libra Esterlina", 
				"Dólares a Pesos Mexicanos", "Euros a Pesos Mexicanos", 
				"Libras a Pesos Mexicanos"}));
		cambioMoneda.setBounds(501, 38, 300, 21);
		getContentPane().add(cambioMoneda);
		
		JLabel lblimage = new JLabel("");
		lblimage.setBounds(0, 0, 836, 148);
		lblimage.setFont(new Font("Roboto Black", Font.PLAIN, 13));
		lblimage.setIcon(new ImageIcon("C:\\Users\\Rodrigo\\Documents\\GitHub\\ConversorJava\\Conversor_moneda\\imagenes\\Fondo-Azul1.jpg"));
		getContentPane().add(lblimage);
		
		medidasC = new JTextField();
		medidasC.setFont(new Font("Roboto Light", Font.BOLD, 15));
		medidasC.setBounds(77, 217, 180, 30);
		getContentPane().add(medidasC);
		medidasC.setColumns(10);
		
		ValorConvertir = new JTextField();
		ValorConvertir.setFont(new Font("Roboto Light", Font.BOLD, 15));
		ValorConvertir.setBounds(559, 217, 180, 30);
		getContentPane().add(ValorConvertir);
		ValorConvertir.setColumns(10);
		
		
		/*
		 * Cambio de moneda
		 */
		
		
		Convertir = new JToggleButton("Convertir");
		Convertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ValorAconvertir = ValorConvertir.getText();
				Double valorNum = Double.parseDouble(ValorAconvertir);
				double tipoCambio = 17;
				double resultadoFinal = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				
				
			if(cambioMoneda.getSelectedIndex()==0) {
				resultadoFinal = (valorNum/tipoCambio);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Pesos a Dolares
			}else if(cambioMoneda.getSelectedIndex()==1) {
				double tipoCambioEU = 18;
				resultadoFinal = (valorNum/tipoCambioEU);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Pesos a Euro
			}else if(cambioMoneda.getSelectedIndex()==2) {
				double tipoCambioLS = 21;
				resultadoFinal = (valorNum/tipoCambioLS);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Pesos a  Libras
			}else if(cambioMoneda.getSelectedIndex()==3) {
				resultadoFinal = (valorNum*tipoCambio);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Dolares a Pesos
			}else if(cambioMoneda.getSelectedIndex()==4) {
				double tipoCambioEU = 18;
				resultadoFinal = (valorNum*tipoCambioEU);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Euros a Pesos
			}else if(cambioMoneda.getSelectedIndex()==5) {
				double tipoCambioLS = 21;
				resultadoFinal = (valorNum*tipoCambioLS);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Libras a Pesos
			}			
				/*
				 * Cambio unidades de medida y temperatura
				 * 
				 */
			
	////////////////////////////////////////////////////		Double valorConv = Double.parseDouble(ValorAconvertir) ;
				
 			}
		});
		Convertir.setFont(new Font("Roboto", Font.BOLD, 16));
		Convertir.setBounds(593, 159, 121, 23);
		getContentPane().add(Convertir);
		
		
		JToggleButton botonSalir = new JToggleButton("Salir de la Aplicación");
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		botonSalir.setFont(new Font("Roboto Light", Font.BOLD, 13));
		botonSalir.setBounds(658, 350, 166, 23);
		getContentPane().add(botonSalir);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Rodrigo\\Documents\\GitHub\\ConversorJava\\Conversor_moneda\\imagenes\\LogoFooter.jpg"));
		lblNewLabel_4.setBounds(0, 393, 836, 68);
		getContentPane().add(lblNewLabel_4);
		
		Conversion = new JToggleButton("Conversión");
		Conversion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String medidas = medidasC.getText();
				Double valorNum = Double.parseDouble(medidas);
				//double tipoConv = 1.9 + 30;
				double resultadoFinal = 0;
				
				DecimalFormat formatear = new DecimalFormat("0.00");
				
				
			if(medidasYtempearturas.getSelectedIndex()==0) {
				resultadoFinal = (valorNum*9/5+32);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Grados celsius a Fº
			}else if(medidasYtempearturas.getSelectedIndex()==1){
				resultadoFinal = (valorNum/1.609);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // kilometros a Millas
			}else if(medidasYtempearturas.getSelectedIndex()==2){
				resultadoFinal = (valorNum/0.914);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Metros a Yardas 
			}else if(medidasYtempearturas.getSelectedIndex()==3){
				resultadoFinal = (valorNum/0.393);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Centímetros a Pulgadas
			}else if(medidasYtempearturas.getSelectedIndex()==4){
				resultadoFinal = ((valorNum-32)*5/9);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Fº a Celsius
			}else if(medidasYtempearturas.getSelectedIndex()==5){
				resultadoFinal = (valorNum*1.609);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Millas a Kilómetros
			}else if(medidasYtempearturas.getSelectedIndex()==6){
				resultadoFinal = (valorNum*0.914);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Yardas a Metros
			}else if(medidasYtempearturas.getSelectedIndex()==7){
				resultadoFinal = (valorNum*0.393);
				Resultado.setText("Resultado: " + formatear.format(resultadoFinal)); // Pulgadas a centimetros
			}
			
			
			
			
				
			}
		});
		Conversion.setFont(new Font("Roboto", Font.BOLD, 16));
		Conversion.setBounds(101, 159, 121, 23);
		getContentPane().add(Conversion);
		
		
												
	}
}

