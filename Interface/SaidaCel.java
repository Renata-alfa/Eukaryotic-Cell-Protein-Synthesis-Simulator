package Interface;

import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;

public class SaidaCel {

	public SaidaCel(Dna dna,int i,int j,RnaMensageiro rnam,Proteina p) {
		JOptionPane.showMessageDialog(null,"nome cient�fico:\n"+dna.shownome()+
				"\nPosi��o do StartCodon:\n"+i+"\nPosi��o do StopCodon:\n"+j+"\nProte�na,sequ�ncia de amino�cidos:\n"+p.showSeq());
	}

	
	public static void main(String[] args) {
		
		

	}

}
