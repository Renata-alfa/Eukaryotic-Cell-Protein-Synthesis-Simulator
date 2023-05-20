package Interface;

import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;

public class TesteChamada {

	
	public void teste() 
	{
		RnaMensageiro rnam=new RnaMensageiro ();
		Dna dna=new Dna();
		RnaTransportador rnat=new RnaTransportador();
		Proteina p=new Proteina();
		
		//dna.entDna();
		//dna.entSeqDna();//tem q incluir ATG e UAG no final
		rnat.setAa("metionina");
		rnat.setAc("cgc");
		rnat.setSeq("uacacu");
	
		//rnam=dna.transcricao(dna);
		rnam.setSeq("auggcguga");
		p=rnam.traducao(rnat);		
		JOptionPane.showMessageDialog(null,"sequencia da proteina=\n"+p.showSeq());
		SaidaCel s=new SaidaCel(dna,rnam.getstart(),rnam.getstop(),rnam,p);
		
		
	
	}

	public static void main(String[] args)
	{
		TesteChamada tc=new TesteChamada();
		tc.teste();
	}
}
