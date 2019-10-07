//https://es.stackoverflow.com/questions/9146/arreglos-din%C3%A1micos-en-metodosjava

package Logic;
import java.util.Scanner;
import java.util.*;

public class Polinomio{
  double[] V_Coef;
  int[] V_Exp;
  int dim;


  //constructor
  public Polinomio(){
    dim = -1;
    V_Exp = new int [5];
    V_Coef = new double [5];
    
  }
  
  /*------Operaciones auxiliares--------*/
  public void Redimensionar(){
    if(dim+1 == V_Coef.length){
      double aux1[] = new double[V_Coef.length+1];
      int aux2[] = new int [V_Coef.length+1];
    
      System.arraycopy(V_Coef,0,aux1,0,dim+1);
      System.arraycopy(V_Exp,0,aux2,0,dim+1);
    
      V_Coef = aux1;
      V_Exp = aux2;
    }
  }
  
  public boolean Pertenece(char signo){
    String auxSigno = Character.toString(signo);
    
    if(auxSigno.matches("[-+]")){
      return true;
    }else{
      return false;
    }
    
  }
  
  //Retorna todo el polinomio concatenado
  public String ObtenerTodo(){
    String cadena = "";
    int contador = 0;
    while(contador <= dim){
      if (V_Coef[contador]<0){
        if(V_Exp[contador] == 0){
          cadena = cadena + String.valueOf(V_Coef[contador]) + "  ";
        }else{
          if(V_Exp[contador] == 1){
            cadena = cadena + String.valueOf(V_Coef[contador]) + "x" + "  ";
          }else{
            cadena = cadena + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]) + "  ";
          } 
        }
      }else{
        if(V_Exp[contador] == 0){
          cadena = cadena + "+" + String.valueOf(V_Coef[contador]) + "  ";
        }else{
          if(V_Exp[contador] == 1){
            cadena = cadena + "+" + String.valueOf(V_Coef[contador]) + "x" + "  ";
          }else{
            cadena = cadena + "+" + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]) + "  ";
          }
        }
      }
      contador++;
    }
    return cadena;
  } 
  
  //Preguntar si el coeficiente es 0 retorna falso
  public boolean SiCoeficienteEsCero(double coeficiente){
    if(coeficiente == 0){
        return true;
      }else{
        return false;
      }
  }
  
  //Si un monomio del vector es mayor que uno nuevo retornar la posicion del monomio en el vector
  public int BuscarPosicion(int exponente){
    int i = dim;
    while(i > -1 && exponente >= V_Exp[i]){
      i--;
    }
    i++;//retorna en position 0
    return i;    
  }
  
  //Insertar monomio en una posicion astras
  public void InsertarEn(int position, double coeficiente, int exponente){
    Redimensionar();
    int i = dim;
    while(i > position){
      i--;
      V_Coef[i+1] = V_Coef[i];
      V_Exp[i+1] = V_Exp[i];
    }
    V_Coef[position] = coeficiente;
    V_Exp[position] = exponente;

  }
  
  /*------------------------------------*/
  
  //Insertar monomio
  public void Insertar(char signo, double coeficiente, int exponente){
    if(!SiCoeficienteEsCero(coeficiente) && Pertenece(signo)){
      if(signo == '-' && coeficiente>0){
         coeficiente = - coeficiente;  
      }
      if(dim == -1 ){
        dim++;
        V_Coef[dim] = coeficiente;
        V_Exp[dim] = exponente;
      }else{
        int position = BuscarPosicion(exponente);
        if(V_Exp[position] == exponente && position <= dim){
          V_Coef[position] = V_Coef[position] + coeficiente;       
        }else{
          dim++;
          InsertarEn(position,coeficiente, exponente);
          //System.out.println(String.valueOf(exponente));//de int a string
        }
      }
      
    }
  
  }
  
  //get monomio
  //Obtiene el coeficiente si existe, para ello recibe un exponente
  public double ObtenerCoeficiente( int exponente){
    int i=0;
    while(i <= dim && V_Exp[i]!=exponente){
      i++;
    }
    return V_Coef[i];
  }
  
  //Obtener Signo del coeficiente
  public char ObtenerSigno_DelCoeficiente(double Coeficiente){
    char Signito;
    if(Coeficiente > 0){
      Signito = '+';
    }else{
      Signito = '-';
    }
    return Signito;
  }
  
  //Suma de 2 polinomios
  public void Sumar(Polinomio A, Polinomio B){
    int i = 0;
    char Signito;
    while(i <= A.dim){
      Signito = ObtenerSigno_DelCoeficiente(A.V_Coef[i]);
      Insertar(Signito,A.V_Coef[i],A.V_Exp[i]);
      i++;
    }
    
    i=0;
    while(i <= B.dim){
      Signito = ObtenerSigno_DelCoeficiente(B.V_Coef[i]);
      Insertar(Signito,B.V_Coef[i],B.V_Exp[i]);
      i++;
    }
  }
  
  //Multiplicar 2 polinomios
  public void Multiplicar(Polinomio A, Polinomio B){
    int contador1, contador2, expAux;
    double coefAux;
    char signoAux;
    contador1 = 0;
    contador2 = 0;
    
    while(contador1 <= A.dim){
      while(contador2 <= B.dim){
        coefAux = A.V_Coef[contador1] * B.V_Coef[contador2];
        expAux = A.V_Exp[contador1] + B.V_Exp[contador2];
        signoAux = ObtenerSigno_DelCoeficiente(coefAux);
        Insertar(signoAux,coefAux,expAux);
        contador2++;
      }
      contador1++;
      contador2 = 0;
    }
    
  }
  
  public void CambiarSigno(Polinomio D_Extra){
  int i =0;
    while(i<=D_Extra.dim){
      if(D_Extra.V_Coef[i] > 0){
        D_Extra.V_Coef[i] = -1 * D_Extra.V_Coef[i];
      }else{
        D_Extra.V_Coef[i] = -1 * D_Extra.V_Coef[i];
      }
      i++;
    }
  }
  
  public void Suma_of_Division(Polinomio B, Polinomio D_Extra){
    
    D_Extra.V_Coef[0] = B.V_Coef[0] + D_Extra.V_Coef[0];
    D_Extra.V_Coef[1] = B.V_Coef[1] + D_Extra.V_Coef[1];
    
    /*D_Extra.V_Coef[2] = B.V_Coef[2];
    D_Extra.V_Exp[2] = B.V_Exp[2];
    int i=2;
    System.out.println(String.valueOf(B.dim));
    while(i<=B.dim){
      InsertarEn(i,B.V_Coef[i],B.V_Exp[i]);
      System.out.println(String.valueOf(D_Extra.V_Coef[i]));
      i++;  
    }*/
  }
  
  public void Clear(){
    dim = -1;
    V_Exp = new int [5];
    V_Coef = new double [5];
  }
  
}
