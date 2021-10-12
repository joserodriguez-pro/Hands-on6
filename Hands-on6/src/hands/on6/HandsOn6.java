package hands.on6;

import javax.swing.JOptionPane;



public class HandsOn6 {
     double tablaX[][]={{1,41.9,29.1},{1,43.4,29.3},{1,43.9,29.5},{1,44.5,29.7},{1,47.3,29.9},
        {1,47.5,30.3},{1,47.9,30.5}, {1,50.2,30.7}, {1,52.8,30.8}, {1,53.2,30.9}, {1,56.7,31.5},
        {1,57,31.7}, {1,63.5,31.9}, {1,65.3,32}, {1,71.1,32.1}, {1,77,32.5}, {1,77.8,32.9}};
    
    double tablaY[][]={{251.3},{251.3},{248.3},{267.5},{273},{276.5},{270.3},{274.9},{285},{290},
        {297},{302.5},{304.5},{309.3},{321.7},{330.7},{349}};
    
    double transpuesta[][];
    double producto[][];
    double inversa[][]; 
    
    public double[][] TranspuestaMatriz(double [][] matriz){
        this.transpuesta= new double[matriz[0].length][matriz.length];
        for(int i=0;i<=matriz[0].length-1;i++){
            for(int j=0; j<=matriz.length-1;j++){
                transpuesta[i][j]=matriz[j][i];
            }
        }
        return transpuesta;
    }
    
    public void ProductoMatriz(double[][]matriz1, double[][]matriz2){
        this.producto= new double[matriz1.length][matriz2[0].length];
        for(int x=0;x<=matriz1.length-1;x++){
            for(int y=0; y<=matriz2[0].length-1;y++){
                double n=0;
                for (int c=0; c<= matriz1[0].length-1; c++){
                    n = n + matriz1[x][c]*matriz2[c][y];
                }
                producto[x][y]=n;
            }
        }
    }
    
    public void InversaMatriz(double[][] matriz){
        double inversa[][]= new double[matriz.length][matriz[0].length+2];
        for (int i=0; i<=matriz.length-1;i++){
             for(int j=0; j<=matriz[0].length-1;j++){
                inversa[i][j]=matriz[i][j];
            }
        }
        
        inversa[0][3]=inversa[0][0];
        inversa[0][4]=inversa[0][1];
        
        inversa[1][3]=inversa[1][0];
        inversa[1][4]=inversa[1][1];
        
        inversa[2][3]=inversa[2][0];
        inversa[2][4]=inversa[2][1];
        
        double A,B,C,D,E,F;
        double determinante;
        A=inversa[0][0]*inversa[1][1]*inversa[2][2];
        B=inversa[0][1]*inversa[1][2]*inversa[2][3];
        C=inversa[0][2]*inversa[1][3]*inversa[2][4];
        
        D=inversa[0][4]*inversa[1][3]*inversa[2][2];
        E=inversa[0][3]*inversa[1][2]*inversa[2][1];
        F=inversa[0][2]*inversa[1][1]*inversa[2][0];
        
        determinante =(A+B+C-D-E-F);
        
        System.out.print("\n");
        System.out.print(determinante);
        System.out.print("\n\n");

        double TranspuestaAux[][]= new double[matriz[0].length][matriz.length];
        for(int i=0;i<=matriz[0].length-1;i++){
            for(int j=0; j<=matriz.length-1;j++){
                TranspuestaAux[i][j]=matriz[j][i];
            }
        }
        
         for (int i=0; i<TranspuestaAux.length;i++){
             for(int j=0; j<TranspuestaAux[0].length;j++){
                System.out.print(" "+String.format("%.3f",TranspuestaAux[i][j])+" ");
                    }
             System.out.print("\n");
                }
        System.out.print("\n\n");
        
        double adj[][] = new double[matriz.length][matriz[0].length];
        double aux[][] = new double[2][2];
        
        int AuxCorA=0;
        int AuxCorB=0;
        for(int h=0; h<=2;h++){
            for(int g=0; g<=2;g++){
                for(int m=0; m<=2;m++){
                    for(int n=0; n<=2;n++){
                        if (m!=h && n!=g){
                            if(AuxCorB<=1){
                            aux[AuxCorA][AuxCorB]=TranspuestaAux[m][n];
                            AuxCorB++; AuxCorA=0;
                            }else{
                                AuxCorA++; AuxCorB=0;
                                aux[AuxCorA][AuxCorB]=TranspuestaAux[m][n];
                                AuxCorB++;
                            }
                        }
                    }
                }
                AuxCorA=0; AuxCorB=0;
                if(h==0 && g==0)adj[h][g]= (aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]);
                if(h==0 && g==1)adj[h][g]= (-1)*((aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]));
                if(h==0 && g==2)adj[h][g]= (aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]);
                
                if(h==1 && g==0)adj[h][g]= (-1)*((aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]));
                if(h==1 && g==1)adj[h][g]= (aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]);
                if(h==1 && g==2)adj[h][g]= (-1)*((aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]));
                
                if(h==2 && g==0)adj[h][g]= (aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]);
                if(h==2 && g==1)adj[h][g]= (-1)*((aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]));
                if(h==2 && g==2)adj[h][g]= (aux[0][0]*aux[1][1])-(aux[0][1]*aux[1][0]);
            }
        }
        
        for(int i=0; i<3;i++){
            for(int j=0; j<3;j++){
                adj[i][j]=adj[i][j]/determinante;
            }
        }
        this.inversa= new double[adj.length][adj[0].length];
        for (int i=0; i<=adj.length-1;i++){
             for(int j=0; j<=adj[0].length-1;j++){
                this.inversa[i][j]=adj[i][j];
            }
        }    
    }
    
    public void printMatriz(double [][] x){
        
        for (int i=0; i<x.length;i++){
             for(int j=0; j<x[0].length;j++){
                System.out.print(" "+String.format("%.3f",x[i][j])+" ");
                    }
             System.out.print("\n");
                }
             }
    
    public double[][] getMatrizX(){
        return tablaX;
    }
    
    public double[][] getTranspuesta(){
        return transpuesta;
    }
    
    public double[][] getProducto(){
        return producto;
    }
    
    public double[][] getInversa(){
        return inversa;
    }
    
    public double[][] getMatrizY(){
        return tablaY;
    }
    
    public double yield(){
    float X1= Float.parseFloat(JOptionPane.showInputDialog(null, "-Ingresa el valor de X1:  "));
    float X2= Float.parseFloat(JOptionPane.showInputDialog(null, "-Ingresa el valor de X2:  "));
    double R;
    R= producto[0][0] + (producto[1][0]*X1) + (producto[2][0]*X2);
    return R;
    }

    public static void main(String[] args) {
        HandsOn6 hands = new HandsOn6();
   
        hands.printMatriz(hands.getMatrizX());
        System.out.print("\n");
        
        hands.TranspuestaMatriz(hands.getMatrizX());
        hands.printMatriz(hands.getTranspuesta());
        System.out.print("\n");
        
        hands.ProductoMatriz(hands.getTranspuesta(), hands.getMatrizX());
        hands.printMatriz(hands.getProducto());
        
        hands.InversaMatriz(hands.getProducto());
        hands.printMatriz(hands.getInversa());
        System.out.print("\n");
        
        hands.ProductoMatriz(hands.getTranspuesta(), hands.getMatrizY());
        hands.printMatriz(hands.getProducto());
        System.out.print("\n");
        
        hands.ProductoMatriz(hands.getInversa(), hands.getProducto());
        hands.printMatriz(hands.getProducto());
        System.out.println("");
         System.out.println("-La prediccion es:  " + String.format("%.3f", hands.yield()));
        
    }
    
}
