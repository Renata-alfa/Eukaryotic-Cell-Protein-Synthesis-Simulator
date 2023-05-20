package Interface;

//import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.RnaMensageiro;




public class LeituraSequencia extends JApplet{
//variaveis globais	
 
    
	public Dna leitura()
	{
		//variaveis locais
		int tam,i,j;
		
		Dna dna= new Dna();//variavel do tipo Dna
		
		dna.entDna();
		dna.entSeqDna();
		dna.tamSeqDna();
		 
		 //para caixa maior e com dados dentro,apost.224
		 //para colocar barra de rolagem,apost.240
		 //passar dados para Dna para transcrição
		 //tam=strlen(SeqDna);
		 return dna;	  
		 
	}
	
//metodo para chamar os outros metodos e criar o Rna
	public static void main(String[] args) {
		//variaveis locais
		int tam,i,j;
		
		Dna dna= new Dna();//variavel do tipo Dna
		
		dna.entDna();
		dna.entSeqDna();
		dna.tamSeqDna();
		 
		 //para caixa maior e com dados dentro,apost.224
		 //para colocar barra de rolagem,apost.240
		 //passar dados para Dna para transcrição
		 //tam=strlen(SeqDna);
		 JOptionPane.showMessageDialog(null,"LeituraSequencia OK");	  
		 System.exit(0);
	}

}
