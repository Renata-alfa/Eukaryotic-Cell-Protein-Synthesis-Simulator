package Sequencias;

import javax.swing.JOptionPane;

/**@author Renata Klein do Amaral
 * Proteina - Esta classe pertence ao pacote de Sequencias.
 * O objeto da classe DNA tem como seus atributos:
 * 		func 		- função que a proteína possuem, dentre elas:
 * 				  	  enzimática, transportadora, armazenamento,
 * 				  	  estruturais, defesa, contráteis, reguladoras
 * 				  	  entre outras.	
 * 		seqaa		- sequência de aminoácidos
 * 		numRnat		- número de RNAt requisitados para a sua composição
 * 		movingProt	- valor de posição
 * A Classe é composta pelos métodos:
 * 		Proteina- construtor
 * 		setSeq	- atribui parâmetro a sequência
 * 		showSeq	- return sequência*/
		


public class Proteina {
//	variaveis globais
		public String func;
		public String seqaa;//tem q ter alocação dinamica
		public int numRnat;
		int movingProt;
		
		//construtor
		public Proteina() {
			func="modelo de teste";
			movingProt=0;
			seqaa="";
			
		}

		public void setSeq(String aa)
		{
			seqaa+=aa;
			
		}
		
		public String showSeq()
		{
			return seqaa;
		}
		
		
		
		public static void main(String[] args) {
			// sem metodo;
			
			System.exit(0);
		}

	}
