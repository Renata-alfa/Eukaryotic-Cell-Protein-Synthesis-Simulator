package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;


import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.MouseInputListener;

import AcidosNucleicos.Dna;
import AcidosNucleicos.Rna;
import AcidosNucleicos.RnaMensageiro;
import AcidosNucleicos.RnaTransportador;
import Sequencias.Proteina;
import java.awt.*;
import java.awt.event.*;



/**
 * @author Renata Klein do Amaral
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class InterfaceUser extends JFrame implements ActionListener,MouseInputListener, KeyListener
{
	
	private Container cont=new Container();
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem itemControle, itemSobre, itemSair;
	private JPanel painelEsq,painelDir,painelOp,painelInc,painelInf;
	private JSeparator linha1, linha2;
	private JLabel labelOp1,labelOp2,labelOp3,labelOp4,labelInc1,labelInc2,
	labelInc3,labelInc4,labelInf1,labelInf2,labelInf3,labelInf4,labelInf5;
	private JTextField campoTexInc1,campoTexInc2;
	private ImageIcon imgControle = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/controleIcon.png"));
	private ImageIcon imgSobre = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/sobre.png"));
	private ImageIcon imgSair = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/sair.png"));
	private ImageIcon imgInc = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/add.png"));
	private ImageIcon imgIncOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/addOver.png"));
	private ImageIcon imgBus = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/find.png"));
	private ImageIcon imgBusOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/findOver.png"));
	private ImageIcon imgNor = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/normal.png"));
	private JButton botaoInc1,botaoInc2;
	private JRadioButton ent,sim,conv;
	private ButtonGroup radiogroup;
	private Sobre sobre = new Sobre();	
	private Funcionamento controle = new Funcionamento();
	private String entrada;	
	private Controlador controlador = new Controlador();
	
	
	
	public InterfaceUser(){
	
	
	
	cont=getContentPane();
	cont.setLayout(new BorderLayout());
	
	
	/* Menu */ 
	
	menu = new JMenu("Ajuda");	
	
	//Controles do Teclado
	itemControle = new JMenuItem("Funcionamento", imgControle);
	//tenho q implementar o metodo acionado
	itemControle.addActionListener(this);
	menu.add(itemControle);
	
	menu.addSeparator(); //Linha
	
    //Sobre o Programa
	itemSobre = new JMenuItem("Sobre...", imgSobre);
	itemSobre.addActionListener(this);
	menu.add(itemSobre);
	
	menu.addSeparator(); //Linha
	
	//Item Sair
	itemSair = new JMenuItem("Sair", imgSair);
	//tenho q implementar o metodo acionado
	itemSair.addActionListener(this);
	menu.add(itemSair);
	
	//Cria a Barra de Menu
	menuBar = new JMenuBar();
	menuBar.add(menu);
	
	setJMenuBar(menuBar);
	
	/* Prepara os Paineis para ser colocado no Container */
	painelEsq = new JPanel();
    painelEsq.setLayout(new GridLayout(12, 1));
    painelDir = new JPanel();
    painelDir.setLayout(new GridLayout(22, 10));
    painelOp = new JPanel();
    painelOp.setLayout(new FlowLayout(FlowLayout.LEFT));
    painelInc = new JPanel();
    painelInc.setLayout(new FlowLayout(FlowLayout.LEFT));
    painelInf = new JPanel();
    painelInf.setLayout(new FlowLayout(FlowLayout.LEFT));
  
	
	
	
	
	
//////* Prepara os objetos dos Paineis *//////////////////
	/*Objetos do Painel de Opção*/	
	
	labelOp1 = new JLabel("Escolha o modo de sistema;");
		
	//cria botoes de opcao
	ent=new JRadioButton("Interação",false);	
	sim=new JRadioButton("Simulação",false);	
	conv=new JRadioButton("Convencional",false);	
	linha1 = new JSeparator();
	
	
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
	
	
	
	/*Objetos do Painel de Inclusao*/
	entrada="";
	labelInc1 = new JLabel("DNA - Nome científico");
	
	campoTexInc1= new JTextField(10);
	ButtonHandler evento1=new ButtonHandler();
	botaoInc1 = new JButton(imgInc);
	botaoInc1.addActionListener(evento1);
	botaoInc1.setBorderPainted(false);
	botaoInc1.setContentAreaFilled(false);
	botaoInc1.addMouseListener(this);
	botaoInc1.setRolloverIcon(this.imgIncOver);
	
	labelInc2 = new JLabel("Entre com a sequência de DNA");
	
	campoTexInc2= new JTextField(20);	
	ButtonHandler evento2=new ButtonHandler();
	botaoInc2 = new JButton(imgInc);
	botaoInc2.addActionListener(evento2);
	botaoInc2.setBorderPainted(false);
	botaoInc2.setContentAreaFilled(false);
	botaoInc2.addMouseListener(this);
	botaoInc2.setRolloverIcon(this.imgIncOver);
	linha2 = new JSeparator();
	
	
	/*Objetos do Painel de Informação*/
	
	labelInf1 = new JLabel("Informações");
	labelInf2 = new JLabel("DNA - tamanho da sequência");
	//labelInf3 = new JLabel("",controlador.getInfint());
	//labelInf3.setForeground(Color.MAGENTA);
	labelInf4 = new JLabel("RNAm - tamanho da sequência");
	
	//labelInf5 = new JLabel(controlador.getInfstr());
	//labelInf5.setForeground(Color.MAGENTA);
	
	//p/aparecer
	/*labelPre = new JLabel(" pré-ordem:");
		labelPreStr = new JLabel(this.gra.arv.getPreOrder());
		labelPreStr.setForeground(Color.MAGENTA);*/
	
	/* Adiciona os objetos no PainelOp */
	painelOp.add(labelOp1);
	painelOp.add(conv);
	painelOp.add(ent);
	painelOp.add(sim);
	
	/* Adiciona os objetos no PainelInc */
	painelInc.add(labelInc1);
	painelInc.add(campoTexInc1);
	painelInc.add(botaoInc1);
	painelInc.add(labelInc2);
	painelInc.add(campoTexInc2);
	painelInc.add(botaoInc2);
	
	/*Adiciona os objetos no PainelInf*/
	painelInf.add(labelInf1);
	painelInf.add(labelInf2);
	
	painelInf.add(labelInf4);
	
	
	
	/*Adiciona ps paineis no Painel Principal*/
	painelEsq.add(painelInc);
	painelEsq.add(linha1);
	painelEsq.add(painelOp);
	painelEsq.add(linha2);
	painelEsq.add(painelInf);
	

	//painel esquerdo funções
	cont.add(painelEsq, BorderLayout.WEST); 
	cont.add(painelDir, BorderLayout.CENTER);
	//painel direito do desenho 3D
	//cont.add(gra.getCanvas(), BorderLayout.CENTER);
	

	
	this.setIconImage((new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/logo.png"))).getImage());
	this.setContentPane(cont);
	this.pack();
	this.centerWindow(this);
	this.setVisible(true);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if ( ae.getSource() == this.itemControle )
			controle.setVisible(true);
		
		if ( ae.getSource() == this.itemSobre )
			sobre.setVisible(true);
		
		if ( ae.getSource() == this.itemSair )
			System.exit(0);
	}
	public void mouseClicked(MouseEvent me)
	{
		
	}
	public void mousePressed(MouseEvent me)
	{
		/* Controle dos Botões */
		if ( me.getSource() == botaoInc1 )
			botaoInc1.setIcon(imgInc);
		if ( me.getSource() == botaoInc2 )
			botaoInc2.setIcon(imgInc);
		
	}
	
	public void mouseReleased(MouseEvent me)
	{String nome, seq;
		/* Controle dos Botões */
		if ( me.getSource() == botaoInc1 )
		{
			botaoInc1.setIcon(imgIncOver); // Ícone
		
				//Adiciona string a nome 	
				nome=this.campoTexInc1.getText();
				
				JOptionPane.showMessageDialog(null,"nome="+nome);	
			
		}
		if ( me.getSource() == botaoInc2 )
		{
			botaoInc2.setIcon(imgInc);
			
			//Adiciona string a seq
			seq=this.campoTexInc2.getText();
			
			JOptionPane.showMessageDialog(null,"seq="+seq);	
				
			}
	
		
		
		
	}
	public void mouseEntered(MouseEvent me)
	{
		if ( me.getSource() == this.botaoInc1 )
			botaoInc1.setIcon(this.imgIncOver);
		if ( me.getSource() == this.botaoInc2 )
			botaoInc2.setIcon(this.imgInc);
		/*if ( me.getSource() == this.botaoInc1 )
			botaoInc1.setIcon(this.imgNor);
	*/
	}
	
	
	public void mouseExited(MouseEvent me)
	{
		if ( me.getSource() == this.botaoInc1 )
			botaoInc1.setIcon(this.imgInc);
		if ( me.getSource() == this.botaoInc2 )
			botaoInc2.setIcon(this.imgInc);

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
    
	//metodo para mostrar o controle

	

	
	public void keyReleased(KeyEvent ke)
	{	
		
		
		
		
	}

	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InterfaceUser conv=new InterfaceUser();
		
	}

//	classe interna privativa para tratar de eventos de opção
	private class RadioButtonHandler implements ItemListener
	{   
		String str;
		int i;
		public void itemStateChanged (ItemEvent event)
		{ //acionar a opção escolhida
			if(event.getSource()==conv)
			{	
				
				controlador.Ini(1,campoTexInc1.getText(),campoTexInc2.getText());
				//Limpa a area de texto				
				campoTexInc1.setText("");
				campoTexInc2.setText("");
			}
			
			if(event.getSource()==ent)
			{
				
				controlador.Ini(2,campoTexInc1.getText(),campoTexInc2.getText());
				campoTexInc1.setText("");
				campoTexInc2.setText("");
				
			}
			if(event.getSource()==sim)
			{
				
				controlador.Ini(3,campoTexInc1.getText(),campoTexInc2.getText());
				campoTexInc1.setText("");
				campoTexInc2.setText("");
			}
			
			
		}
	}

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
			String nome,str;
			
						
			if(event.getSource()== campoTexInc2)
			{	
				str=campoTexInc2.getText();						
			}
			if(event.getSource()== campoTexInc1)
			{
				nome=campoTexInc1.getText();
			}
			
		}			
	}
	
}
