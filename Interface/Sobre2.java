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

public class Sobre2 extends JFrame implements ActionListener
{
	private Container cont;
	private JPanel painelTitulo, painelConteudo, painelBotao;
	private JLabel label1, label2, label3, label4, label5, label6, label7, label8;
	private JButton btnOk;
	private ImageIcon imgArvore = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/arvore.png"));
	private JLabel espaco1, espaco2, espaco3, espaco4;
    
	public Sobre2()
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
		label4 = new JLabel("Renata Klein do Amaral\nValéria Cristina Pacheco da Silva", JLabel.CENTER);
		label4.setToolTipText("Author do Software");
		espaco3 = new JLabel();
		label5 = new JLabel("Prof° Juliana Bernardes da Silva\nPatrícia Fiuza", JLabel.CENTER);
		espaco4 = new JLabel();
		label6 = new JLabel("Este Software foi desenvolvido em caráter exclusivamente Acadêmico.", JLabel.CENTER);
		label7 = new JLabel("Não poderá ser utilizado para outros fins.", JLabel.CENTER);
		label8 = new JLabel("- Todos os direitos reservados. © Copyright 2006 -", JLabel.CENTER);
		btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		
		painelTitulo.add(espaco1);
		painelTitulo.add(label1);
		painelTitulo.add(label2);
		painelConteudo.add(espaco2);
		painelConteudo.add(label3);
		painelConteudo.add(label4);
		painelConteudo.add(espaco3);
		painelConteudo.add(label5);
		painelConteudo.add(espaco4);
		painelConteudo.add(label6);
		painelConteudo.add(label7);
		painelConteudo.add(label8);
		painelBotao.add(btnOk);
		
		cont.add(painelTitulo, BorderLayout.NORTH);
		cont.add(painelConteudo, BorderLayout.CENTER);
		cont.add(painelBotao, BorderLayout.SOUTH);
		
		this.setIconImage((new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/logo.png"))).getImage());
		this.setContentPane(cont);
		this.pack();
		this.setResizable(false);
		this.setSize(450, 320);
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