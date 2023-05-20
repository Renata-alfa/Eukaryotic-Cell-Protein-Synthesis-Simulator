package Molecula;

import javax.swing.JOptionPane;

/**@author Renata Klein do Amaral
 * Acucar - Esta classe pertence ao pacote de Molecula.
 * O objeto da classe Acucar tem como seus atributos:
 * 		Nomenclatura	- deve ser determinado se � uma Ribose ou uma Desoxirribose
 * 		movingAc		- valor de posi��o *
 * A Classe � composta pelos m�todos:
 * 		Acucar			- construtor
 * 
 * BaseNitrogenada - Esta classe pertence ao pacote de Molecula
 * O objeto da classe BaseNitrogenda tem como seus atributos:
 * 		Classificacao - tem que classificar em "purica" ou "pirimidica";
		base		  - em caso purica,deve receber "ag", sen�o "tc"
		movingBas     - valor de posi��o
	A Classe � composta pelos m�todos:
		BaseNitrogenda- construtor
	
	MoleculaFosfato - Esta classe pertence ao pacote de Molecula.
	O objeto da classe Acucar tem como seus atributos:
		Nomenclatura - deve receber a nomenclatura de acordo com as normas 
						internacionais de padr�o - no caso referente a Fosfato (PO4-)
		movingMol	 - valor de posi��o
	A Classe � composta pelos m�todos:
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
		JOptionPane.showMessageDialog(null,"a��car criado\nNomenclatura:\n"+a.Nomenclatura+"\nposi��o:\n"+a.movingAc);
		System.exit(0);
	}

}
