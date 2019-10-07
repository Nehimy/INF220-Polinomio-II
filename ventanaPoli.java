/*
Enlaces de referencia:
  - https://www.smartick.es/blog/matematicas/algebra/sumas-polinomios/
  - http://www.sc.ehu.es/sbweb/fisica/cursoJava/fundamentos/introduccion/primero.htm
  - http://chuwiki.chuidiang.org/index.php?title=Ejemplos_con_JTextField
  - http://www.chuidiang.org/java/ejemplos/JFormattedTextField/EjemplosJFormattedTextField.php
  - http://www.chuidiang.org/java/ejemplos/JFormattedTextField/EjemplosJFormattedTextField.php
  - https://es.stackoverflow.com/questions/1487/guia-definitiva-de-conversi%C3%B3n-de-tipos-en-java
*/

import Logic.Polinomio;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.JOptionPane;


public class ventanaPoli{
  //Atributos
  private Polinomio A = new Polinomio();
  private Polinomio B = new Polinomio(); 
  private Polinomio C = new Polinomio();
  private Polinomio D = new Polinomio();
  
  private Polinomio C_Extra = new Polinomio();
  private Polinomio D_Extra = new Polinomio();
  private Polinomio E_Extra = new Polinomio();
  private Polinomio F_Extra = new Polinomio();
  
  private JFrame ventana;
  private JTextField SignoTxt;
  private JTextField CoefTxt;
  private JTextField ExpTxt;
  private JTextField Poli_A_Txt;
  private JTextField Poli_B_Txt;
  private JTextField ResultadoTxt;
  
  private JButton InsertarEn_A;
  private JButton InsertarEn_B;
  private JButton Sumar_AyB;
  private JButton Multiplicar_AyB;
  private JButton Dividir_AyB;
  private JButton Clear;
  
  private JLabel labelSigno;
  private JLabel labelCoef;
  private JLabel labelExp;
  
  //Clase pincipal
  public static void main(String[] args){  
    new ventanaPoli();
  }
  
  //Constructor de ventanaPoli
  public ventanaPoli(){
  
    //Variablede tipo JFrame    
    ventana = new JFrame("ventanita");
    ventana.setSize(950,550);
    ventana.getContentPane().setBackground(Color.white);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Finaliza el programa*/
    ventana.setLayout(new GridBagLayout());  
    
    //Declarando todas las cajas de texto
    SignoTxt = new JTextField("");
    Border bordeSigno = BorderFactory.createLineBorder(Color.pink, 2);
    SignoTxt.setBorder(bordeSigno);
    
    CoefTxt = new JTextField("");
    Border bordeCoef = BorderFactory.createLineBorder(Color.pink, 2);
    CoefTxt.setBorder(bordeCoef);
    
    ExpTxt = new JTextField("");
    Border bordeExp = BorderFactory.createLineBorder(Color.pink, 2);
    ExpTxt.setBorder(bordeExp);
    
    Poli_A_Txt = new JTextField("");
    Border bordePoli_A_Txt = BorderFactory.createLineBorder(Color.pink, 2);
    Poli_A_Txt.setBorder(bordePoli_A_Txt);
    
    Poli_B_Txt = new JTextField("");
    Border bordePoli_B_Txt = BorderFactory.createLineBorder(Color.pink, 2);
    Poli_B_Txt.setBorder(bordePoli_B_Txt);
    
    ResultadoTxt = new JTextField("");
    Border bordeResultado = BorderFactory.createLineBorder(Color.pink, 2);
    ResultadoTxt.setBorder(bordeResultado);
    
    
    //Declaramos botón Insertar en A
    InsertarEn_A = new JButton("Insert in A");
    InsertarEn_A.setBackground(Color.pink);

     //Declaramos botón Insertar en B
     InsertarEn_B = new JButton("Insert in B");  
     InsertarEn_B.setBackground(Color.pink); 
     
     //Declaramos botón Sumar_AyB
     Sumar_AyB = new JButton("  Sumar  ");
     Sumar_AyB.setBackground(Color.pink);
     
     //Declaramos botón Multiplicar_AyB
     Multiplicar_AyB = new JButton("Multiplicar");
     Multiplicar_AyB.setBackground(Color.pink);
     
     //Declaramos botón Dividir_AyB
     Dividir_AyB = new JButton("Dividir");
     Dividir_AyB.setBackground(Color.pink);
     
     //Declaramos botón Clear
     Clear = new JButton("Limpiar");
     Clear.setBackground(Color.pink);
        
        
    //Declaramos todos los labels    
    labelSigno= new JLabel("Signo");
    labelSigno.setFont(new Font("Arial", 0, 18));
    
    labelCoef= new JLabel("Coeficiente");
    labelCoef.setFont(new Font("Arial", 0, 18));
    
    labelExp = new JLabel("Exponente");
    labelExp.setFont(new Font("Arial", 0, 18));
    
    /*Objeto de configuración del grid*/
    GridBagConstraints gridConf = new GridBagConstraints();
    gridConf.fill = GridBagConstraints.HORIZONTAL;
    
    /*-------------------------------*/
    /* Adherir elementos a la ventana*/
    /*-------------------------------*/
    
    
    /****************/
    /*Caja de textos*/ 
    /****************/
    
    //Confi de pocicion SignoTxt
    gridConf.gridx = 2;
    gridConf.gridy = 0;
    gridConf.ipady = 20;
    gridConf.ipadx = 50;
    gridConf.gridwidth = 1;
    gridConf.insets = new Insets(0,0,3,3); //padding

    
    //Añadir SignoTxt a la ventana
    ventana.add(SignoTxt, gridConf);
    
    //Confi de pocicion CoefTxt
    gridConf.gridx = 2;
    gridConf.gridy = 1;
    gridConf.insets = new Insets(0,0,3,3); //padding

    
    //Añadir CoefTxt a la ventana
    ventana.add(CoefTxt, gridConf);
    
    //Confi de pocicion ExpTxt
    gridConf.gridx = 2;
    gridConf.gridy = 2;
    gridConf.insets = new Insets(0,0,3,3);

    
    //Añadir ExpTxt a la ventana
    ventana.add(ExpTxt, gridConf);
    
    //Confi de Poli_A_Txt
    gridConf.gridx = 1;
    gridConf.gridy = 4; 
    gridConf.gridwidth = 3;
    gridConf.insets = new Insets(0,0,3,3);
    
    //Añadir Poli_A_Txt en la ventana
    ventana.add(Poli_A_Txt, gridConf);
    
    //Confi de Poli_B_Txt
    gridConf.gridx = 1;
    gridConf.gridy = 5; 
    gridConf.gridwidth = 3;
    gridConf.insets = new Insets(0,0,3,3);
    
    //Añadir Poli_B_Txt en la ventana
    ventana.add(Poli_B_Txt, gridConf);
    
    //Confi de pocicion ResultadoTxt
    gridConf.gridx = 1;
    gridConf.gridy = 6; 
    gridConf.gridwidth = 3;
    gridConf.insets = new Insets(0,0,3,3);
    
    //Añadir ResultadoTxt a la ventana
    ventana.add(ResultadoTxt, gridConf);
    gridConf.gridwidth = 1;
    
    /*********/
    /*Botones*/ 
    /*********/
    
    //Confi de InsertarEn_A en la ventana
    gridConf.ipadx = 20;
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir InsertarEn_A en la ventana
    gridConf.gridx = 0;
    gridConf.gridy = 3;
    ventana.add(InsertarEn_A, gridConf);
    
    //Confi de InsertarEn_B
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir InsertarEn_B en la ventana
    gridConf.gridx = 1;
    gridConf.gridy = 3;
    ventana.add(InsertarEn_B, gridConf);
    
    //Confi de Sumar_AyB
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir Sumar_AyB en la ventana
    gridConf.gridx = 2;
    gridConf.gridy = 3;
    
    ventana.add(Sumar_AyB, gridConf);
      
    //Confi de Multiplicar_AyB
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir Multiplicar_AyB en la ventana
    gridConf.gridx = 3;
    gridConf.gridy = 3;
    ventana.add(Multiplicar_AyB, gridConf);  
    
    //Confi de Dividir_AyB
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir Dividir_AyB en la ventana
    gridConf.gridx = 4;
    gridConf.gridy = 3;
    ventana.add(Dividir_AyB, gridConf); 
    
    //Confi de Clear
    gridConf.insets = new Insets(10,10,10,10);
    
    //Añadir Clear a la ventana
    gridConf.gridx = 2;    
    gridConf.gridy = 7;
    ventana.add(Clear, gridConf); 
    
    /****************/
    /*   Labels     */ 
    /****************/
      
    //Añadir labels a la ventana
      gridConf.gridx = 1;
      gridConf.gridy = 0;
      gridConf.ipadx = 15;
      ventana.add(labelSigno, gridConf); 
      
      gridConf.gridy = 1;
      ventana.add(labelCoef, gridConf);
      
      gridConf.gridy = 2;
      ventana.add(labelExp, gridConf);
      
    
    //onclick Insertar en A
    InsertarEn_A.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        InsertarEn_AClick();
      }
    });
    
    //onclick Insertar en B
    InsertarEn_B.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        InsertarEn_BClick();
      }
    }); 
    
    //onclick Sumar_AyB
    Sumar_AyB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Sumar_AyBClick();
      }
    });
    
    //onclick Multiplicar_AyB
    Multiplicar_AyB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Multiplicar_AyBClick();
      }
    });
      
    //onclick Dividir_AyB
    Dividir_AyB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Dividir_AyBClick();
      }
    });  
      
    //onclick Clear
    Clear.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ClearClick();
      }
    });  
      
    /*------------------------*/
    //ventanaM.pack();
    ventana.setVisible(true);//Configurando visualización de la ventana
    /*------------------------*/
  }
  

    

    
	public void InsertarEn_AClick(){
	
	  char signo = SignoTxt.getText().charAt(0);
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    int exponente = Integer.parseInt(ExpTxt.getText());
	  A.Insertar(signo,coeficiente,exponente);
	  Poli_A_Txt.setText(A.ObtenerTodo());
	}
 
  public void InsertarEn_BClick(){
  
    char signo = SignoTxt.getText().charAt(0);
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    int exponente = Integer.parseInt(ExpTxt.getText());
	  B.Insertar(signo,coeficiente,exponente);
	  Poli_B_Txt.setText(B.ObtenerTodo());
  }
 
  public void Sumar_AyBClick(){
   C.Sumar(A,B);
   ResultadoTxt.setText(C.ObtenerTodo());
  }
 
  public void Multiplicar_AyBClick(){
    D.Multiplicar(A,B);
    ResultadoTxt.setText(D.ObtenerTodo());
  }
  
  public void Dividir_AyBClick(){
    char signoExtra = JOptionPane.showInputDialog(ventana, "Ingresa signo: ").charAt(0);
    double coeficienteExtra =  Double.parseDouble(JOptionPane.showInputDialog(ventana, "Ingresa coeficiente: "));
    int exponenteExtra =  Integer.parseInt(JOptionPane.showInputDialog(ventana, "Ingresa exponente: "));
    
    C_Extra.Insertar(signoExtra,coeficienteExtra,exponenteExtra);
    
    D_Extra.Multiplicar(A,C_Extra);
    D_Extra.CambiarSigno(D_Extra);
    D_Extra.Suma_of_Division(B,D_Extra);
    ResultadoTxt.setText(D_Extra.ObtenerTodo());
  }
  
  public void ClearClick(){
    A.Clear();
    B.Clear();
    C.Clear();
    D.Clear();
    C_Extra.Clear();
    D_Extra.Clear();
    E_Extra.Clear();
    F_Extra.Clear();
    
    SignoTxt.setText("");
    CoefTxt.setText("");
    ExpTxt.setText("");
    Poli_A_Txt.setText("");
    Poli_B_Txt.setText("");
    ResultadoTxt.setText("");
  }
  
  
  
}
