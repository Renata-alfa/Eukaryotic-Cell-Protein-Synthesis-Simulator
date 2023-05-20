package Interface;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

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
public class Principal extends JFrame implements ActionListener, MouseInputListener, KeyListener
{
	private Container cont = new Container();
	private JMenu menu;
	private JMenuBar menuBar;
	private JMenuItem itemControle, itemSobre, itemSair;
//	private JPanel painelEsq, painelInc, painelBus, painelExc, painelNor, painelZer, painelAltura;
	private JPanel painelEsq, painelInc, painelBus, painelNor, painelZer, painelAltura;
	private JPanel painelPre, painelPost, painelIn;
	private JSeparator linha1, linha2;
//	private JLabel labelInc, labelBus, labelExc, labelNor, labelLimpar, espaco;
	private JLabel labelInc, labelBus, labelNor, labelLimpar, espaco;
	private JLabel labelAltura, labelAlturaStr, labelPre, labelPreStr, labelPost, labelPostStr, labelIn, labelInStr;
//	private JTextField campoTextoInc, campoTextoBus, campoTextoExc;
	private JTextField campoTextoInc, campoTextoBus;
//	private JButton botaoInc, botaoBus, botaoExc, botaoNor, botaoLimpar;
	private JButton botaoInc, botaoBus, botaoNor, botaoLimpar;
	private String preOrder, postOrder, inOrder;
	private ImageIcon imgControle = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/controleIcon.png"));
	private ImageIcon imgSobre = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/sobre.png"));
	private ImageIcon imgSair = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/sair.png"));
	private ImageIcon imgInc = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/add.png"));
	private ImageIcon imgIncOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/addOver.png"));
	private ImageIcon imgBus = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/find.png"));
	private ImageIcon imgBusOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/findOver.png"));
	private ImageIcon imgExc = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/remove.png"));
	private ImageIcon imgExcOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/removeOver.png"));
	private ImageIcon imgLimpar = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/limpar.png"));
	private ImageIcon imgLimparOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/limparOver.png"));
	private ImageIcon imgNor = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/normal.png"));
	private ImageIcon imgNorOver = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/normalOver.png"));
	private ImageIcon imgErro = new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/erro.png"));
	private boolean teclaOk, teclaMaxInc = true, teclaMaxBus = true, teclaMaxExc = true;
	private Grafico gra = new Grafico();
	private Controle controle = new Controle();
	private Sobre2 sobre = new Sobre2();
	
	public Principal()
	{
		super("Árvore Binária");
		cont = getContentPane();
		cont.setLayout(new BorderLayout());
		
		/* Menu */ 
		
		menu = new JMenu("Ajuda");
		
		//Controles do Teclado
		itemControle = new JMenuItem("Controle", imgControle);
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
		itemSair.addActionListener(this);
		menu.add(itemSair);
		
		//Cria a Barra de Menu
		menuBar = new JMenuBar();
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
        
        /* Prepara os Paineis para ser colocado no Container */
        painelEsq = new JPanel();
        painelEsq.setLayout(new GridLayout(12, 1));
        painelInc = new JPanel();
		painelInc.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelBus = new JPanel();
		painelBus.setLayout(new FlowLayout(FlowLayout.LEFT));
/*		painelExc = new JPanel();
		painelExc.setLayout(new FlowLayout(FlowLayout.LEFT));*/
		painelNor = new JPanel();
		painelNor.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelZer = new JPanel();
		painelZer.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelAltura = new JPanel();
		painelAltura.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelPre = new JPanel();
		painelPre.setLayout(new GridLayout(2, 1));
		painelPost = new JPanel();
		painelPost.setLayout(new GridLayout(2, 1));
		painelIn = new JPanel();
		painelIn.setLayout(new GridLayout(2, 1));
		
		/* Prepara os objetos dos Paineis */
		linha1 = new JSeparator();
		linha2 = new JSeparator();
		espaco = new JLabel("");
		labelInc = new JLabel("Incluir: ");
		campoTextoInc = new JTextField(6);
		campoTextoInc.addKeyListener(this);
		botaoInc = new JButton(imgInc);
		botaoInc.setBorderPainted(false);
		botaoInc.setContentAreaFilled(false);
		botaoInc.addMouseListener(this);
		botaoInc.setRolloverIcon(this.imgIncOver);
		labelBus = new JLabel("Busca: ");
		campoTextoBus = new JTextField(6);
		campoTextoBus.addKeyListener(this);
		botaoBus = new JButton(imgBus);
		botaoBus.setBorderPainted(false);
		botaoBus.setContentAreaFilled(false);
		botaoBus.addMouseListener(this);
		botaoBus.setRolloverIcon(this.imgBusOver);
/*		labelExc = new JLabel("Excluir: ");
		campoTextoExc = new JTextField(6);
		campoTextoExc.addKeyListener(this);
		botaoExc = new JButton(imgExc);
		botaoExc.setBorderPainted(false);
		botaoExc.setContentAreaFilled(false);
		botaoExc.addMouseListener(this);
		botaoExc.setRolloverIcon(this.imgExcOver);*/
		labelNor = new JLabel("Normalizar o Gráfico: ");
		botaoNor = new JButton(imgNor);
		botaoNor.setBorderPainted(false);
		botaoNor.setContentAreaFilled(false);
		botaoNor.addMouseListener(this);
		botaoNor.setRolloverIcon(this.imgNorOver);
		labelLimpar = new JLabel("Limpar a Árvore:         ");
		botaoLimpar = new JButton(imgLimpar);
		botaoLimpar.setBorderPainted(false);
		botaoLimpar.setContentAreaFilled(false);
		botaoLimpar.addMouseListener(this);
		botaoLimpar.setRolloverIcon(this.imgLimparOver);
		labelAltura = new JLabel("Áltura: ");
		labelAlturaStr = new JLabel();
		labelAlturaStr.setForeground(Color.MAGENTA);
		labelPre = new JLabel(" pré-ordem:");
		labelPreStr = new JLabel(this.gra.arv.getPreOrder());
		labelPreStr.setForeground(Color.MAGENTA);
		labelPost = new JLabel(" pós-ordem:");
		labelPostStr = new JLabel(this.gra.arv.getPostOrder());
		labelPostStr.setForeground(Color.MAGENTA);
		labelIn = new JLabel(" in-ordem:");
		labelInStr = new JLabel(this.gra.arv.getInOrder());
		labelInStr.setForeground(Color.MAGENTA);
		
		/* Adiciona os objetos nos Paineis */
		painelInc.add(labelInc);
		painelInc.add(campoTextoInc);
		painelInc.add(botaoInc);
		painelBus.add(labelBus);
		painelBus.add(campoTextoBus);
		painelBus.add(botaoBus);
/*		painelExc.add(labelExc);
		painelExc.add(campoTextoExc);
		painelExc.add(botaoExc);*/
		painelNor.add(labelNor);
		painelNor.add(botaoNor);
		painelZer.add(labelLimpar);
		painelZer.add(botaoLimpar);
		painelAltura.add(labelAltura);
		painelAltura.add(labelAlturaStr);
		painelPre.add(labelPre);
		painelPre.add(labelPreStr);
		painelPost.add(labelPost);
		painelPost.add(labelPostStr);
		painelIn.add(labelIn);
		painelIn.add(labelInStr);
		
		painelEsq.add(painelInc);
		painelEsq.add(painelBus);
//		painelEsq.add(painelExc);
		painelEsq.add(linha1);
		painelEsq.add(painelNor);
		painelEsq.add(painelZer);
		painelEsq.add(espaco);
		painelEsq.add(linha2);
		painelEsq.add(painelAltura);
		painelEsq.add(painelPre);
		painelEsq.add(painelPost);
		painelEsq.add(painelIn);
		
		cont.add(painelEsq, BorderLayout.WEST); //painel esquerdo funções
		cont.add(gra.getCanvas(), BorderLayout.CENTER); //painel direito - desenho 3D
		
		this.setIconImage((new ImageIcon(ClassLoader.getSystemClassLoader().getResource("img/logo.png"))).getImage());
		this.setContentPane(cont);
		this.pack();
		this.centerWindow(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		if ( me.getSource() == botaoInc )
			botaoInc.setIcon(imgInc);
		if ( me.getSource() == botaoBus )
			botaoBus.setIcon(imgBus);
/*		if ( me.getSource() == botaoExc )
			botaoExc.setIcon(imgExc);*/
		if ( me.getSource() == botaoNor )
			botaoNor.setIcon(imgNor);
	}
	public void mouseReleased(MouseEvent me)
	{
		/* Controle dos Botões */
		if ( me.getSource() == botaoInc )
		{
			botaoInc.setIcon(imgIncOver); // Ícone
			
			if ( (this.campoTextoInc.getText()).length() != 0 )
			{
				int chave;
				
				chave = Integer.parseInt(this.campoTextoInc.getText()); // Pega o texto
				this.gra.arv.addNo(chave); // Tenta adicionar na Árvore
				this.campoTextoInc.setText("");
				
				if ( this.gra.arv.statusInserir == ArvoreBinaria.INSERIDO_SUCESSO )
				{
					this.gra.repaintCanvas();
					this.labelAlturaStr.setText("" + this.gra.arv.getAltura());
					this.labelPreStr.setText(this.gra.arv.getPreOrder());
					this.labelPostStr.setText(this.gra.arv.getPostOrder());
					this.labelInStr.setText(this.gra.arv.getInOrder());
				}
				else if ( this.gra.arv.statusInserir == ArvoreBinaria.ERRO_NIVEL_10 )
					JOptionPane.showMessageDialog(null, "O programa estipula o número máximo de 10 níveis.\n Este Nó não poderá ser incluído, pois irá ultrapassar esse número!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				else if ( this.gra.arv.statusInserir == ArvoreBinaria.NO_ACHADO )
					JOptionPane.showMessageDialog(null, "Nó já existe na Árvore!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
			}
			else
				JOptionPane.showMessageDialog(null, "O campo texto deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
		}
		if ( me.getSource() == botaoBus )
		{
			botaoBus.setIcon(imgBusOver);
			
			if ( (this.campoTextoBus.getText()).length() != 0 )
			{
				int chave;
				
				chave = Integer.parseInt(this.campoTextoBus.getText()); // Pega o texto
				this.campoTextoBus.setText("");
				
				this.gra.arv.findNo(this.gra.arv.getRaiz(), chave, false);
				
				if ( this.gra.arv.statusBusca == ArvoreBinaria.NAO_ACHADO_DIR || this.gra.arv.statusBusca == ArvoreBinaria.NAO_ACHADO_ESQ )
					JOptionPane.showMessageDialog(null, "Nó não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				if ( this.gra.arv.statusBusca == ArvoreBinaria.ARVORE_VAZIA )
					JOptionPane.showMessageDialog(null, "Árvore está vazia!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				
				this.gra.repaintCanvas();
			}
			else
				JOptionPane.showMessageDialog(null, "O campo texto deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
		}
/*		if ( me.getSource() == botaoExc )
		{
			botaoExc.setIcon(imgExcOver);
			
			if ( (this.campoTextoExc.getText()).length() != 0 )
			{
				int chave;
				
				chave = Integer.parseInt(this.campoTextoInc.getText()); // Pega o texto
				
				if ( !this.gra.arv.removeNo(chave) )
					JOptionPane.showMessageDialog(null, "A Árvore está vazia!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				this.gra.repaintCanvas();
				this.labelAlturaStr.setText("" + this.gra.arv.getAltura());
				this.labelPreStr.setText(this.gra.arv.getPreOrder());
				this.labelPostStr.setText(this.gra.arv.getPostOrder());
				this.labelInStr.setText(this.gra.arv.getInOrder());
			}
			else
				JOptionPane.showMessageDialog(null, "O campo texto deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
		}*/
		if ( me.getSource() == botaoNor )
		{
			botaoNor.setIcon(imgNorOver);
			this.gra.normalizeCanvas();
		}
		if ( me.getSource() == botaoLimpar )
		{
			botaoLimpar.setIcon(imgLimparOver);
			if ( !this.gra.arv.limparArvore() )
				JOptionPane.showMessageDialog(null, "A Árvore já está vazia!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
			this.gra.repaintCanvas();
			this.labelAlturaStr.setText("" + this.gra.arv.getAltura());
			this.labelPreStr.setText(this.gra.arv.getPreOrder());
			this.labelPostStr.setText(this.gra.arv.getPostOrder());
			this.labelInStr.setText(this.gra.arv.getInOrder());
		}
	}
	public void mouseEntered(MouseEvent me)
	{
		if ( me.getSource() == this.botaoInc )
			botaoInc.setIcon(this.imgIncOver);
		if ( me.getSource() == this.botaoBus )
			botaoBus.setIcon(this.imgBusOver);
/*		if ( me.getSource() == this.botaoExc )
			botaoExc.setIcon(this.imgExcOver);*/
		if ( me.getSource() == this.botaoNor )
			botaoNor.setIcon(this.imgNorOver);
		if ( me.getSource() == this.botaoLimpar )
			botaoLimpar.setIcon(this.imgLimparOver);
	}
	public void mouseExited(MouseEvent me)
	{
		if ( me.getSource() == this.botaoInc )
			botaoInc.setIcon(this.imgInc);
		if ( me.getSource() == this.botaoBus )
			botaoBus.setIcon(this.imgBus);
/*		if ( me.getSource() == this.botaoExc )
			botaoExc.setIcon(this.imgExc);*/
		if ( me.getSource() == this.botaoNor )
			botaoNor.setIcon(this.imgNor);
		if ( me.getSource() == this.botaoLimpar )
			botaoLimpar.setIcon(this.imgLimpar);
	}
	public void mouseDragged(MouseEvent me)
	
	{
		
	}
	public void mouseMoved(MouseEvent me)
	{
		
	}
	public void keyTyped(KeyEvent ke)
	{
		if ( !teclaOk )
			ke.consume();
	}
	public void keyPressed(KeyEvent ke)
	{
		int code = ke.getKeyCode();
		
//		if ( ke.getSource() == this.campoTextoInc || ke.getSource() == this.campoTextoBus || ke.getSource() == this.campoTextoExc )
		if ( ke.getSource() == this.campoTextoInc || ke.getSource() == this.campoTextoBus )
		{
			//0-9 (numerico) / 1-0 (alfanumerico) 
			this.teclaOk = (code > 95 && code < 106) || (code > 47 && code < 58);
			
//			if ( this.campoTextoInc.getText().length() > 2 || this.campoTextoBus.getText().length() > 2 || this.campoTextoExc.getText().length() > 2 )
			if ( this.campoTextoInc.getText().length() > 2 || this.campoTextoBus.getText().length() > 2 )
				this.teclaOk = false;
		}
	}
	public void keyReleased(KeyEvent ke)
	{
		if ( ke.getSource() == this.campoTextoInc && ke.getKeyCode() == KeyEvent.VK_ENTER )
		{
			botaoInc.setIcon(imgIncOver); // Ícone
			
			if ( (this.campoTextoInc.getText()).length() != 0 )
			{
				int chave;
				
				chave = Integer.parseInt(this.campoTextoInc.getText()); // Pega o texto
				this.gra.arv.addNo(chave); // Tenta adicionar na Árvore
				this.campoTextoInc.setText("");
				
				if ( this.gra.arv.statusInserir == ArvoreBinaria.INSERIDO_SUCESSO )
				{
					this.gra.repaintCanvas();
					this.labelAlturaStr.setText("" + this.gra.arv.getAltura());
					this.labelPreStr.setText(this.gra.arv.getPreOrder());
					this.labelPostStr.setText(this.gra.arv.getPostOrder());
					this.labelInStr.setText(this.gra.arv.getInOrder());
				}
				else if ( this.gra.arv.statusInserir == ArvoreBinaria.ERRO_NIVEL_10 )
					JOptionPane.showMessageDialog(null, "O programa estipula o número máximo de 10 níveis.\n Este Nó não poderá ser incluído, pois irá ultrapassar esse número!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				else if ( this.gra.arv.statusInserir == ArvoreBinaria.NO_ACHADO )
					JOptionPane.showMessageDialog(null, "Nó já existe na Árvore!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
			}
			else
				JOptionPane.showMessageDialog(null, "O campo texto deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
		}
		if ( ke.getSource() == this.campoTextoBus && ke.getKeyCode() == KeyEvent.VK_ENTER )
		{
			botaoBus.setIcon(imgBusOver);
			
			if ( (this.campoTextoBus.getText()).length() != 0 )
			{
				int chave;
				
				chave = Integer.parseInt(this.campoTextoBus.getText()); // Pega o texto
				this.campoTextoBus.setText("");
				
				this.gra.arv.findNo(this.gra.arv.getRaiz(), chave, false);
				
				if ( this.gra.arv.statusBusca == ArvoreBinaria.NAO_ACHADO_DIR || this.gra.arv.statusBusca == ArvoreBinaria.NAO_ACHADO_ESQ )
					JOptionPane.showMessageDialog(null, "Nó não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				if ( this.gra.arv.statusBusca == ArvoreBinaria.ARVORE_VAZIA )
					JOptionPane.showMessageDialog(null, "Árvore está vazia!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
				
				this.gra.repaintCanvas();
			}
			else
				JOptionPane.showMessageDialog(null, "O campo texto deve estar preenchido!", "Erro", JOptionPane.ERROR_MESSAGE, imgErro);
		}
/*		if ( ke.getSource() == this.campoTextoExc && ke.getKeyCode() == KeyEvent.VK_ENTER )
		{
			
		}*/
	}
	public static void main(String[] args)
	{
		new Principal();
	}
}