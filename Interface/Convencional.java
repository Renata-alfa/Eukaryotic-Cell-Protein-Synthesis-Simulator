package Interface;

import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.Rna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;

public class Convencional {

	Base base = new Base();
	/**
	 * @param args
	 */
	public Convencional(String nome,String seq)
	{
		base.Enter(nome,seq);
	}
	
	public String getString()
	{
		
		return base.infProt();
		
	}
	
	public int getInt()
	{
		
			return base.infDna();
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Convencional conv= new Convencional("tatu","tactactactactactac" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
				"aaaaaaaaaaaaaaaaaaaaattt");
		JOptionPane.showMessageDialog(null,"infDNA="+conv.getInt());
		System.exit(0);
	}

}
