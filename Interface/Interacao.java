package Interface;

import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;
import AcidosNucleicos.Rna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;





//classe q possui metodo para chamar outros para usuario enteragir
public class Interacao{

	public Interacao()
	{
		
	}
	
	public void Enter(String nome,String seq) {
				
		Dna dna = new Dna();

		dna.setseq(seq);
		dna.tamSeqDna();
		dna.DnaTrans();
			
		
		
		
	}

	
	public static void main(String[] args) {
		int i;
		String n,s;
		Interacao e=new Interacao();
		n=JOptionPane.showInputDialog("Inicializar Interação\nEntre com o nome para o DNA");
		s=JOptionPane.showInputDialog("Entre com a seq");
		e.Enter(n,s);
		JOptionPane.showMessageDialog(null,"Finalizar Enteração");
		System.exit(0);
	}

}
