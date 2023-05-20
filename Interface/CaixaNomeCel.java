package Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.JOptionPane;

import AcidosNucleicos.Dna;



public class CaixaNomeCel extends JFrame{
	private JTextField area;
	//JTextArea - área onde o usuário insere dados 
	//private JTextArea area;
	//JButton - área que aciona evento quando clicado
	private JButton botao;
	//JLabel - local para ser exibidos textos não editáveis ou ícones
	private JLabel label,labelCaixa,labelBotao;
	
	private Container cont;
	//JPanel - container onde os elementos podem ser adicionados
	private JPanel painelCentral;
	private ImageIcon imgVirus = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Virus.jpg"));
	
	private String entrada;	
	
	public CaixaNomeCel() {						
		 
		
		entrada=" ";
		Box box=Box.createVerticalBox();
		//area=new JTextArea(entrada,10,15);
		
		area=new JTextField(20);
		box.add(new JScrollPane(area));
		
		
		botao=new JButton();
		botao.setIcon(imgVirus);
		ButtonHandler evento=new ButtonHandler();
		botao.addActionListener(evento);
		box.add(botao);
		
		Container container=getContentPane();
		container.setLayout(new FlowLayout());
		
		label=new JLabel("Entre com o nome científico originador do DNA:");
		label.setToolTipText("nome científico");
		
		//labelEmbriao=new JLabel();
		
		
		
		container.add(label);
		container.add(box);
		//container.add(labelEmbriao);
		
		
		setSize(500,150);
		setVisible(true);
	}
	
	

	

	public static void main(String[] args) {
		CaixaNomeCel caixa=new CaixaNomeCel();
		caixa.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			Dna dna=new Dna();
						
			dna.setnome(area.getText());
			JOptionPane.showMessageDialog(null,"nome="+dna.shownome());
			//passar DNA
		}
	}
}