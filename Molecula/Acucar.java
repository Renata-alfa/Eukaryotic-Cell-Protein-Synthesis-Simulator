package Molecula;

import javax.swing.JOptionPane;

/**@author Renata Klein do Amaral
 * Acucar - Esta classe pertence ao pacote de Molecula.
 * O objeto da classe Acucar tem como seus atributos:
 * 		Nomenclatura	- deve ser determinado se é uma Ribose ou uma Desoxirribose
 * 		movingAc		- valor de posição *
 * A Classe é composta pelos métodos:
 * 		Acucar			- construtor
 * 
 * BaseNitrogenada - Esta classe pertence ao pacote de Molecula
 * O objeto da classe BaseNitrogenda tem como seus atributos:
 * 		Classificacao - tem que classificar em "purica" ou "pirimidica";
		base		  - em caso purica,deve receber "ag", senão "tc"
		movingBas     - valor de posição
	A Classe é composta pelos métodos:
		BaseNitrogenda- construtor
	
	MoleculaFosfato - Esta classe pertence ao pacote de Molecula.
	O objeto da classe Acucar tem como seus atributos:
		Nomenclatura - deve receber a nomenclatura de acordo com as normas 
						internacionais de padrão - no caso referente a Fosfato (PO4-)
		movingMol	 - valor de posição
	A Classe é composta pelos métodos:
		MoleculaFosfato	-	construtor
		*/


public class Acucar {
//variaveis globais
	private String Nomenclatura;
	private int movingAc;
	
	//construtor
	public Acucar() {
	Nomenclatura="ose";
	movingAc=0;
	}

	
	public static void main(String[] args) {
		// metodo Ligar;
		Acucar a=new Acucar();
		JOptionPane.showMessageDialog(null,"açúcar criado\nNomenclatura:\n"+a.Nomenclatura+"\nposição:\n"+a.movingAc);
		System.exit(0);
	}

}
