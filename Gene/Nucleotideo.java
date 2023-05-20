package Gene;

import Molecula.Acucar;
import Molecula.BaseNitrogenada;
import Molecula.MoleculaFosfato;


/**@author Renata Klein do Amaral
 * Nucleotideo - Esta classe pertence ao pacote de Gene.
 * O objeto da classe DNA tem como seus atributos:
 * 		ac 		   - representa��o de uma mol�cula de a��car
 * 		bn		   - representa��o de uma mol�cula de base nitrogenada
 * 		mf		   - representa��o de uma mol�cula de fosfato
 * 		NumFosfato - n�mero de fosfato que constituem o gene
 * 		movingNuc  - valor da posi��o * 			 
 * A Classe � composta pelos m�todos:
 * 		Nucleotideo- construtor */
//por enquanto naum influencia nos metodos
public class Nucleotideo {
//variaveis globais
    Acucar ac=new Acucar();
	BaseNitrogenada bn=new BaseNitrogenada();
	MoleculaFosfato mf=new MoleculaFosfato();
	int NumFosfato;
	int movingNuc;
	public Nucleotideo()
	{
		 Acucar ac=new Acucar();
		 BaseNitrogenada bn=new BaseNitrogenada();
		 MoleculaFosfato mf=new MoleculaFosfato();
		 NumFosfato=1;
		 movingNuc=0;
	}

	public static void main(String[] args) {
		//metodo LigarNucleotideo;

	}

}
