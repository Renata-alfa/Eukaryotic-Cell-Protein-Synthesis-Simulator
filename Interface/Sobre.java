package Interface;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
/*
 * Created on 19/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Renata Klein do Amaral
 * 		   Valéria Cristina Pacheco da Silva
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class Sobre extends JFrame implements ActionListener
{
	private Container cont;
	private JPanel painelTitulo, painelConteudo, painelBotao;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8,label9,label10;
	private JButton btnOk;
	private ImageIcon imgArvore = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/arvore.png"));
	private JLabel espaco1, espaco2, espaco3, espaco4,espaco5,espaco6,espaco7,espaco8;
    
	/**
	 * 
	 */
	public Sobre()
	{
		//Coloca o título
		super("Sobre...");
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		
		painelTitulo = new JPanel();
		painelTitulo.setLayout(new GridLayout( 4, 1 ));
		painelBotao = new JPanel();
		painelBotao.setLayout(new FlowLayout(FlowLayout.CENTER));
		painelConteudo = new JPanel();
		painelConteudo.setLayout(new GridLayout( 10, 1 ));
		
		espaco1 = new JLabel();
		label1 = new JLabel("Síntese Protéica de Célula Eucarionte", imgArvore, JLabel.CENTER);
		label2 = new JLabel("Versão 1.0",JLabel.CENTER);
		espaco2 = new JLabel();
		label3 = new JLabel("Author:", JLabel.CENTER);
		espaco3 = new JLabel();
		label4 = new JLabel("Renata Klein do Amaral", JLabel.CENTER);
		//espaco4 = new JLabel();
        label5 = new JLabel("Valéria Cristina Pacheco da Silva", JLabel.CENTER);
		label4.setToolTipText("Author do Software");
		label5.setToolTipText("Author do Software");
		espaco5 = new JLabel();
		label6 = new JLabel("Profª Juliana Bernardes da Silva", JLabel.CENTER);
		label6.setToolTipText("Orientadora");
		label7 = new JLabel("Profª Patrícia Fiuza", JLabel.CENTER);
		label7.setToolTipText("Orientadora");
		espaco6 = new JLabel();
		
		//espaco7 = new JLabel();
		label8 = new JLabel("Este Software foi desenvolvido em caráter exclusivamente Acadêmico.", JLabel.CENTER);
		label9 = new JLabel("Não poderá ser utilizado para outros fins.", JLabel.CENTER);
		//espaco8 = new JLabel();
		label10 = new JLabel("- Todos os direitos reservados. © Copyright 2006 -", JLabel.CENTER);
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		painelTitulo.add(espaco1);
		painelTitulo.add(label1);
		painelTitulo.add(label2);
		
		//painelConteudo.add(espaco2);
		painelConteudo.add(label3);
		//painelConteudo.add(espaco3);
		painelConteudo.add(label4);	
		//painelConteudo.add(espaco4);
		painelConteudo.add(label5);
		painelConteudo.add(espaco5);		
		painelConteudo.add(label6);
		painelConteudo.add(label7);
		painelConteudo.add(espaco6);
		
		//painelConteudo.add(espaco7);
				
		painelConteudo.add(label8);
		painelConteudo.add(label9);
		//painelConteudo.add(espaco8);
		painelConteudo.add(label10);
		painelBotao.add(btnOk);
		
		cont.add(painelTitulo, BorderLayout.NORTH);
		cont.add(painelConteudo, BorderLayout.CENTER);
		cont.add(painelBotao, BorderLayout.SOUTH);
		
		this.setIconImage((new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/logo.png"))).getImage());
		this.setContentPane(cont);
		this.pack();
		this.setResizable(false);
		this.setSize(450, 420);
		this.centerWindow(this);
		this.setVisible(false);
	}
	public void centerWindow(Component frame)
	{
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		
		if ( frameSize.width > screenSize.width )
			frameSize.width = screenSize.width;
		
		if ( frameSize.height > screenSize.height )
			frameSize.height = screenSize.height;
		
		frame.setLocation ( (screenSize.width - frameSize.width ) >> 1, (screenSize.height - frameSize.height) >> 1 );
	}
	public void actionPerformed(ActionEvent ev)
	{
		if(ev.getSource() == btnOk)
		{
			setVisible(false);
		}
	}
}