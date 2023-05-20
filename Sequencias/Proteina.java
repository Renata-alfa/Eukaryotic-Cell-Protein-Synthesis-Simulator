package Sequencias;

import javax.swing.JOptionPane;

/**@author Renata Klein do Amaral
 * Proteina - Esta classe pertence ao pacote de Sequencias.
 * O objeto da classe DNA tem como seus atributos:
 * 		func 		- fun��o que a prote�na possuem, dentre elas:
 * 				  	  enzim�tica, transportadora, armazenamento,
 * 				  	  estruturais, defesa, contr�teis, reguladoras
 * 				  	  entre outras.	
 * 		seqaa		- sequ�ncia de amino�cidos
 * 		numRnat		- n�mero de RNAt requisitados para a sua composi��o
 * 		movingProt	- valor de posi��o
 * A Classe � composta pelos m�todos:
 * 		Proteina- construtor
 * 		setSeq	- atribui par�metro a sequ�ncia
 * 		showSeq	- return sequ�ncia*/
		


public class Proteina {
//	variaveis globais
		public String func;
		public String seqaa;//tem q ter aloca��o dinamica
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
