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
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class Funcionamento extends JFrame implements ActionListener
{
	private Container cont;
	private JPanel painelCentral, painelBtnOk;
	private JLabel label44, label55, label66, label2, label4, label1, label3, label6, labelMenos, label5;
	private JButton btnOk;
	
	private ImageIcon imgLeft = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Virus.jpg"));
	private ImageIcon imgMais = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("embriao-peq.jpg"));
	private ImageIcon imgMouse = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("Virus-verm.jpg"));
	JLabel espaco1, espaco2, espaco3, espaco4;

	public Funcionamento()
	{
		//Coloca o t�tulo
		super("Funcionamento - Informa��es");
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		
		/** CRIA OS COMPONENTES E OS PAINEIS **/
		
		painelCentral = new JPanel(new GridLayout(15, 1));
		painelBtnOk = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		espaco1 = new JLabel();
		espaco2 = new JLabel();
		espaco3 = new JLabel();
		espaco4 = new JLabel();
		label1 = new JLabel("1� - Coloque o nome da esp�cie doadora de DNA.",  JLabel.LEFT);
		
		label2 = new JLabel("2� - Coloque a sequ�ncia do DNA.",  JLabel.LEFT);
		
		label3 = new JLabel("3� - Escolha uma das op��es:",  JLabel.LEFT);
		
		label4 = new JLabel("Convencional", imgLeft, JLabel.LEFT);
		label44 = new JLabel("O usu�rio deve entrar com o nome e a sequ�ncia de DNA para a transcri��o e tradu��o.",  JLabel.LEFT);
		label5 = new JLabel("Intera��o", imgMouse, JLabel.LEFT);
		label55 = new JLabel("Intera��o - O usu�rio pode inferir com sua sequ�ncia na Simula��o", JLabel.LEFT);
		label6 = new JLabel("Simula��o", imgMais, JLabel.LEFT);
		label66 = new JLabel("Simula��o - Ser� utilizado uma sequ�ncia Default para a Simula��o.", JLabel.LEFT);
		btnOk = new JButton("Ok");
		btnOk.addActionListener(this);

		/** ADICIONANDO OS COMPONENTES NOS PAINEIS **/
		
		painelBtnOk.add(btnOk);
		
		painelCentral.add(label1);
		painelCentral.add(label2);
		painelCentral.add(label3);
		painelCentral.add(label4);
		painelCentral.add(label44);
		painelCentral.add(espaco1);
		painelCentral.add(label5);
		painelCentral.add(label55);
		painelCentral.add(espaco2);
		painelCentral.add(label6);
		painelCentral.add(label66);
		
		painelCentral.add(espaco4);
		painelCentral.add(painelBtnOk);
		
		cont.add(painelCentral, BorderLayout.CENTER);
		
		this.setIconImage((new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/controle.png"))).getImage());
		this.setContentPane(cont);
		this.pack();
		this.setResizable(false);
		this.setSize(550, 510);
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
		if ( ev.getSource() == btnOk )
		{
			setVisible(false);
		}
	}
}