package Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JOptionPane;
import AcidosNucleicos.Dna;



public class CaixaSeqCel extends JFrame{
	private JTextArea area2;
	private JButton botao;
	private JLabel label;

	public CaixaSeqCel() {
		Box box=Box.createVerticalBox();
		String entrada;
		
				
		/*entrada=" ";
		area2=new JTextArea(entrada,10,15); 
		box.add(new JScrollPane(area2));
		*/
		botao=new JButton("Enter");
		ButtonHandler evento=new ButtonHandler();
		botao.addActionListener(evento);
		
		box.add(botao);
		
		//Container container=getContentPane();
		//container.setLayout(new FlowLayout());
		//label=new JLabel("Entre com a squência do DNA:");
		//label.setToolTipText("sequência do Dna");
		//container.add(label);
		//container.add(box);
		
		//setSize(300,300);
		//setVisible(true);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CaixaSeqCel caixa=new CaixaSeqCel();
		
		caixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Dna dna=new Dna();
			dna.seqDna=area2.getText();
			JOptionPane.showMessageDialog(null,"seq="+dna.seqDna);
			//passar DNA
		}
	}
}
