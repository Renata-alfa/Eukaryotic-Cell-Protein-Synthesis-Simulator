package Organelas;

import javax.swing.JOptionPane;

import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;



/**@author Renata Klein do Amaral
 * Ribossomo - Esta classe pertence ao pacote de Organelas.
 * O objeto da classe DNA tem como seus atributos:
 * 		movingRib  - valor de posição
 * A Classe é composta pelos métodos:
 * 		Ribossomo  - construtor
 * 		verCodon   - retorna um valor booleano, após receber RnaMensageiro,
 *  				 RnaTransportador e posição aonde deve ser verificada a
 *  				 compatibilidade dos códons
 *  */

public class Ribossomo {
//variaveis globais
//	local onde RNAm e RNAt se encontram;
	int movingRib;
	
	//construtor
	public Ribossomo()
	{
		movingRib=0;
	}
	
	//verificar codon de rnam e anticodon de rnat se são compatíveis
	public boolean verCodon(RnaMensageiro rnam,int i,RnaTransportador rnat)
	{int j=0;
		
	
	//tem que passar pelos 3 char's
	  while(j<3)
	  {	
		switch (rnam.seq.charAt(i)) 
		{		case 'a':
					if('u'==rnat.showcharAc(j))
						break; 
				case 'A':
					if('U'==rnat.showcharAc(j))
						break;
				case 'u':
					if('a'==rnat.showcharAc(j))
						break;
				case 'U':
					if('A'==rnat.showcharAc(j))
						break;	
				case 'c':
					if('g'==rnat.showcharAc(j))
						break;
				case 'C':
					if('G'==rnat.showcharAc(j))
						break;	
				case 'g':
					if('c'==rnat.showcharAc(j))
						break;
				case 'G':
					if('C'==rnat.showcharAc(j))
						break;	
				case ' ':
					if(' '==rnat.showcharAc(j))
						break;
				default:
					return false;
		}
		i++;
		j++;
		if(i >= rnam.showTam())
			{
			JOptionPane.showMessageDialog(null,"Erro -Não há mais códon");
			return false;
			}
			
	  }			
	  
		//retronar se tem o referente ao codon,true ou false
		return true;
	}

	
	public static void main(String[] args) {
		boolean resp;
		RnaTransportador rnat=new RnaTransportador();
		RnaMensageiro rnam=new RnaMensageiro();
		int i;
		Ribossomo rib=new Ribossomo ();
		
		rnat.seq="agggccccuaaaagcgc";
		rnat.setAc("xxx");
		//rnat.setAc("gcg");
		rnat.setAa("linaAlgumaCoisa");
		//rnam.setSeq("   ");
		rnam.setseq("gcgcgcgcgcgcgcgcg");
		rnam.setcodon("cgc");
		rnam.tamSeqRnam();
		i=3;
		
		resp=rib.verCodon(rnam,i,rnat);
		System.exit(0);
	}

}