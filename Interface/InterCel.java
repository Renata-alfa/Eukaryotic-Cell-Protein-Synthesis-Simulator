package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class InterCel extends JFrame{
	private CaixaNomeCel cx1;
	private CaixaSeqCel cx2;	
	private EscolhaCel botao;
	
	public InterCel() {		
		super("Celula Eucarionte Virutal");		
		cx2=new CaixaSeqCel();
		cx1=new CaixaNomeCel();
		botao=new EscolhaCel();
		
		Container container=getContentPane();
		container.add(cx1);
		container.add(cx2);
		container.add(botao);
		
		
		
		setSize(500,500);
		setVisible(true);
	
	}

	
	public static void main(String[] args) {
		InterCel inter=new InterCel();
		
		inter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
