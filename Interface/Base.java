package Interface;

import javax.swing.JOptionPane;

import AcidosNucleicos.Dna;
import AcidosNucleicos.Rna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;

public class Base {
	private Dna dna = new Dna();
	private RnaMensageiro rnam= new RnaMensageiro();
	private RnaTransportador rnat= new RnaTransportador();
	private Rna rna=new Rna();
	private Proteina p= new Proteina();
	/**
	 * @param args
	 */
	public Base()
	{
		
	}
	public void Enter(String nome,String seq)
	{
				
		dna.setnome(nome);
		dna.setseq(seq);
		dna.tamSeqDna();
		
		int inicio,fim,tam_trans;
		
		//a transcrição do DNA para RNA começa ser feita pelo Promotor,
		//que por informações químicas sabe o quanto,aonde é inicio e fim
		//para transcrição.
		//este valor representa o tamanho do RNA transcrito do DNA
		//esta porcentagem é simbólica podendo ser alterada
		 tam_trans=(dna.showtam()*50)/100; 
		 
		//o tam será divido por 4, para forçar o início da transcrição, no 1/4
		//da sequencia de DNA e dentre o 1/4 será escolhido posição inicial
		//aleatória 
		inicio=(( int ) ( Math.random() * (dna.showtam()/4) ))-1;
		if(inicio < 0)
			inicio= inicio * (-1);
		
		//o fim será igual ao início + 5% do tamanho total de RNA(pode variar
		// de 1 a 5% para o RNAm)
		// e -1, para posições de array
		fim=(inicio+(tam_trans * 5)/100)-1;
		
		//na 1ª chamada de transcrição terei o RNAm
		rna=dna.transcricao(inicio,fim);
		rnam.seq=rna.seq;
		rnam.tamSeqRnam();
		//o RNAt terá de 10 a 15% do RNAtotal
		inicio=fim - 1;
		fim=(inicio + (tam_trans * 15)/100)-1;
		//na 1ª chamada de transcrição terei o RNAt			
		rna=dna.transcricao(inicio,fim);
		
		rnat.seq=rna.seq;
		rnat.tamSeqRnat();		
		rnat.geraAnticodon();			
		rnat.geraAA();
		p=rnam.traducao(rnat);
		JOptionPane.showMessageDialog(null,"Sequencia da Proteina = "+p.showSeq());
		
	}
	
	public String infProt()
	{
		//return p.showSeq();
		return "FOI";
	}
	
	public int infRnam()
	{
		return rnam.showTam(); 	
	}
	
	public int infDna()
	{
		return dna.showtam();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Base b=new Base();
		b.Enter("nome","tacatactactactactacattacttactact" +
				"actactactactactactatactactactacatctactac" +
				"actactactactactactatactactactacatctactac" +
				"actactactactactactatactactactacatctactac" +
				"actactactactactactatactactactacatctactac" +
				"actactacatactactacttaattaa");
		JOptionPane.showMessageDialog(null,"Base,OK");
	}

}
