package Interface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class EscolhaCel extends JFrame{
	
	private JRadioButton ent,sim,conv;
	private ButtonGroup radiogroup;
	private JLabel label;
	//private CaixaCel cx,cv;
	
	public EscolhaCel() {
		//super("Teste unica opção");
		// obtem painel de conteudo e configura layout
		Container container=getContentPane();
		container.setLayout(new FlowLayout());
		

		//construtor JLabel com argumento String
		label=new JLabel("Escolha o modo de sistema:\n");
		label.setToolTipText("sistema de processamento");
		container.add(label);
		
				
		//cria botoes de opcao
		ent=new JRadioButton("Interação",true);
		container.add(ent);
		sim=new JRadioButton("Simulação",false);
		container.add(sim);
		conv=new JRadioButton("Convencional",false);
		container.add(conv);
		
		//registra eventos para JRadioButton
		RadioButtonHandler handler=new RadioButtonHandler();
		ent.addItemListener(handler);
		sim.addItemListener(handler);
		conv.addItemListener(handler);
		
		//cria o relacionamento logico JRadioButton
		radiogroup=new ButtonGroup();
		radiogroup.add(ent);
		radiogroup.add(sim);
		radiogroup.add(conv);
		
		
		
		
		
		setSize(300,100);
		setVisible(true);
		
	}

	
	public static void main(String[] args) {
		EscolhaCel buttom=new EscolhaCel();
		CaixaSeqCel cx=new CaixaSeqCel();
		buttom.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	//classe interna privativa para tratar de eventos de opção
	private class RadioButtonHandler implements ItemListener
	{   Interacao e;
		InterfaceUser c;
		Simulacao s;
		String str;
		int i;
		public void itemStateChanged (ItemEvent event)
		{ //acionar a opção escolhida
			if(event.getSource()==ent)
			{
				e=new Interacao();
				str=JOptionPane.showInputDialog("Inicializar Enteração\n0 com teste e 1 com entradas");
				i=Integer.parseInt(str);
				e.Enter(i);
				JOptionPane.showMessageDialog(null,"Finalizar Enteração");
				
			}
			if(event.getSource()==sim)
					s=new Simulacao();
			//if(event.getSource()==conv)
					//c=new Convencional();
			
			
		}
	}

}
