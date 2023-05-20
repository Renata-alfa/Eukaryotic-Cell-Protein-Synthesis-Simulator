package Interface;

import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;

public class SaidaCel {

	public SaidaCel(Dna dna,int i,int j,RnaMensageiro rnam,Proteina p) {
		JOptionPane.showMessageDialog(null,"nome científico:\n"+dna.shownome()+
				"\nPosição do StartCodon:\n"+i+"\nPosição do StopCodon:\n"+j+"\nProteína,sequência de aminoácidos:\n"+p.showSeq());
	}

	
	public static void main(String[] args) {
		
		

	}

}
