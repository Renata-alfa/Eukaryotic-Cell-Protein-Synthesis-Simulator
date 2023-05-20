package AcidosNucleicos;

import javax.swing.JOptionPane;

/**
 * @author Renata Klein do Amaral 
 *	O Dna - Esta classe pertence ao pacote de AcidosNucleicos.
 *	� nela que ser� realizado o 1� processo da s�ntese, a transcri��o
 * para o RNA.
 *  O objeto da classe Dna tem como seus atributos:
 *  	nome      - nome da esp�cie doadora
 *  	seqDna    - seq de DNA constituida apenas pelos caracteres 'A','T','C' e 'G'
 *  	movingDna - valor de posi��o
 *  	tam    	  - tamanho da sequ�ncia
 *  A Classe � composta pelos m�todos:
 *  	Dna 	  - contrutor
 *  	entDna	  - exibi caixa para entrada e atribui��o a nome
 *  	entSeqDna - exibi caixa para entrada e atribui��o a sequ�ncia
 *  	tamSeqDna - verifica tamanho da string e atribui tamanho a tam
 *  	shownome  - return nome
 *  	setnome   - atribui par�metro recebido a nome	
 *  	setseq	  - atribui par�metro recebido a seq
 *  	verifica  - verifica se sequencia � v�lida
 *  	promotor  - representa componente biol�gico que indica o in�cio e 
 *  				fim da transcri��o que traduz a sequ�ncia de DNA para RNA
 *  	transcricao - chama m�todo promotor para inicializar a transcri�a� 
 *  	DnaTrans  - determina o tamanho das sequ�ncias de RNA's, e cria��o de
 *  				RnaMensageiro e RnaTransportador.O RnaMensageiro de ser de 1%a 5% do RNA total
 *  				e o RnaTransportador deve ser de 10% a 15%
 *  	ini		  - inicializa todo o procedimento incluso na classe DNA
 *  
 *  
 *  O Rna - Esta classe pertence ao pacote de AcidosNucleicos.
 * 	O objeto da classe Rna tem como seus atributos:
 * 		classificacao - aceita a string ribose 
 * 		seq			  - seq de DNA constituida apenas pelos caracteres 'A','U','C' e 'G'	   
	 	movingRna     - valor de posi��o
    A Classe � composta pelos m�todos:
  		Rna           - construtor  		
  		  		
  		
  	RnaMensageiro - Esta classe pertence ao pacote de AcidosNucleicos
  	O objeto da classe RnaMensageiro tem como seus atributos:
  		codon		  - string de 3 caracteres compreendidos entre A,U,C e G 	   
  		tam			  - tamanho da seq do RnaMensageiro
  		startc		  - posi��o do start codon na sequ�ncia
  		stopc		  - posi��o do stop codon na sequ�ncia
  	A Classe � composta pelos m�todos:
  		RnaMensageiro - construtor
  		setcodon	  - atribui par�metro a codon
  		setseq		  -
  		getstart	  - retorna a posi��o do startc
  		getstop		  - retorna a posi��o do stopc
  		tamSeqRnam	  - verifica tamanho da string e atribui tamanho a tam
  		showTam		  - retorna valor de tam
  		callRnat	  - gera novo RnaTransportador
  		startcodon	  - retorna posi��o onde se encontra "AUG"-Metionina
  		stopcodon	  - retorna posi��o onde se encontra "UAA","UGA" ou "UAG" ou 1- caso n�o encontre
  		traducao	  - retorna a sequ�ncia de amino�cido que constituem a prote�na, recebendo como
  						par�metro o RnaTransportador que auxilia na tradu��o
  				
  	RnaTransportador - Esta classe pertence ao pacote de AcidosNucleicos
  	O objeto da classe RnaTransportador tem como seus atributos:
  		Aminoacido	 - o RnaTransportador pode transportar 1 ou mais Aminoacidos
  					   dentre os 20:{"Asp","Glu","Ala","Arg","Asn","Cys","Phe",
  					   "Gly","Gln","His","Ile","Leu","Lys","Met","Pro","Ser","Tyr","Thr","Trp","Val"};
		Anticodon	 - string de 3 caracteres compreendidos entre A,U,C e G
		tam			 - tamanho da sequ�ncia do RnaTransportador
	A Classe � composta pelos m�todos:
		RnaTransportador - construtor
		geraAA		 - gera Amino�cidos por meio de random
		geraAnticodon- gera Anticodon por meio de random
		geraRnat	 - gera RnaTransportador, invocando geraSeq,geraAA e geraAnticodon
		setAa		 - atribui string a Aminoacido
		setAc		 - atribui string a Anticodon
		showcharAc	 - retorna um caracter de 3, que compoem o Anticodon
		showSeq		 - retorna seq de RnaTransportador
		showTam		 - retorna o tam de RnaTransportador
		tamSeqRnat	 - atribui o tamanho da sequ�ncia de RnaTransportador a tam
		
 *   * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

public class Dna {
//variaveis globais
	//Nucleotideo seqDna = new Nucleotideo();	 
	 public String nome;
	 public String seqDna;
	 private int movingDna,
				tam;
	
	//construtor
	public Dna()
	{	
		nome="desoxirribose";	
		seqDna="";
		movingDna=0;
		tam=0;
	}
	
	
	
	
	//metodo para atribuir nome com intera��o
	public void entDna()
	{
		nome=JOptionPane.showInputDialog("Nome Cient�fico:\n");
	}
	
	
    //metodo para atribuir sequencia com intera��o
	public void entSeqDna()
	{
		seqDna=JOptionPane.showInputDialog("Entre com a sequ�ncia de DNA");
		
	}
	
	
    //metodo para atribuir tamanho da seq
	public void tamSeqDna()
	{
		tam=seqDna.length();
	}
	
	
	//metodo para retornar nome
	public String shownome()
	{
		return nome;
	}
	
	
	//metodo para retornar seq
	public String showseq()
	{
		return seqDna;
	}
	
	
	//metodo para retornar valor de tam
	public int showtam()
	{
		return tam;
	}
	
	
	//metodo para atribuir string a nome
	public void setnome(String str)
	{
		nome=str;
	}
	
	//metodo para atribuir string a sequencia
	public void setseq(String str)
	{
		seqDna=str;
	}
	
	
	//metodo para validar a seq de entrada
	private int verifica()
	{int i,j;
	 char c;
	 	
	 
	 for(i=0;i<this.tam;i++)
		{	c=this.seqDna.charAt(i);
		
		 		switch (c) 
				{	
		 				case 'a':
					            				            
								break;
		 				case 'A':
				            
							break;
						case 't':
																
								break;
						case 'T':
				            
							break;
						case 'c':
																
								break;
						case 'C':
				            
							break;
						case 'g':
																
								break;
						case 'G':
				            
							break;
						case ' ':
																
								break;
						default:
													
							System.out.println("erro na transcri��o do rnam");
							return 0;
				}		 		
		}	
	 
	 return 1;
	}
	
	
	
	
	
	//metodo onde o promotor come�a a fazer transcri��o para cada Rna	
	private Rna promotor(int inicio,int fim)
	{int i,tam_trans;
	 char c;
	 Rna rna=new Rna();	 
	 JOptionPane.showMessageDialog(null,"Promotor");
	 //passo o tam da seq de DNA p/ buscar posi��o inicial aleat�ria para transcrever
	 //este metodo esta sendo usado para substituir a determina��o de posi��o que � 
	 //feita pelo promotor
	 	 
	 
	 
	 for(i=inicio;i<fim;i++)
		{	c=this.seqDna.charAt(i);
		
		 		switch (c) 
				{	
		 				case 'a':
					            rna.seq+='U';					            
								break; 
		 				case 'A':
				            rna.seq+='U';					            
							break; 
						case 't':
								rna.seq+='A';								
								break;
						case 'T':
							rna.seq+='A';								
							break;
						case 'c':
								rna.seq+='G';								
								break;
						case 'C':
							rna.seq+='G';								
							break;
						case 'g':
								rna.seq+='C';								
								break;
						case 'G':
							rna.seq+='C';								
							break;
						case ' ':
								rna.seq+=" ";								
								break;
						default:
													
							System.out.println("erro na transcri��o do rnam");
							break;
				}	
		 		
		}	
	 
	 return rna;
	}
	
	
	//metodo que inicializa a transcri��o chamando o promotor
	public Rna transcricao(int inicio,int fim)
    {	Rna rna=new Rna();
    	rna=promotor(inicio,fim);    	
		 return rna;	   	
    }
	
	public void DnaTrans()
	{
		int inicio,fim,tam_trans;
		RnaMensageiro rnam=new RnaMensageiro();
		RnaTransportador rnat=new RnaTransportador();
		Rna rna=new Rna();
		
		//este valor representa o tamanho do RNA transcrito do DNA
		//esta porcentagem � simb�lica podendo ser alterada
		 tam_trans=(tam *50)/100; 
		
		//o tam ser� divido por 4, para for�ar o in�cio da transcri��o, no 1/4
		//da sequencia de DNA e dentre o 1/4 ser� escolhido posi��o inicial
		//aleat�ria 
		inicio=( int ) ( Math.random() * (tam/4) );
		
		//o fim ser� igual ao in�cio + 5% do tamanho total de RNA(pode variar
		// de 1 a 5% para o RNAm)
		// e -1, para posi��es de array
		fim=(inicio+(tam_trans * 5)/100);
		
		//na 1� chamada de transcri��o terei o RNAm
		rna=transcricao(inicio,fim);
		rnam.seq=rna.seq;
		rnam.tamSeqRnam();
		
		//o RNAt ter� de 10 a 15% do RNAtotal
		inicio=fim - 1;
		fim=(inicio + (tam_trans * 15)/100);
		
		//na 1� chamada de transcri��o terei o RNAt			
		rna=transcricao(inicio,fim);
		
		rnat.seq=rna.seq;
		rnat.tamSeqRnat();		
		rnat.geraAnticodon();
		JOptionPane.showMessageDialog(null," saiu");
		rnat.geraAA();
				
		
			
	}
	
	public void ini(String nome,String seq)
	{
				
		this.setnome(nome);
		this.setseq(seq);		
		this.tamSeqDna();
		if(this.verifica()==0)
		{
			JOptionPane.showMessageDialog(null,"sequ�ncia de DNA incorreta");
			System.exit(0);
		}
		
		this.DnaTrans();
		
		
	}
	
	
	public static void main(String[] args){
		Dna dna=new Dna();
		String str,r;
		int n;
	    
		str="atactactactactactactactactactactactactactactacta" +
			 "tactactactactactactactactatactactactactactactact" +
			 "actactactactactactactactactactactactactactacttac" +
			 "tactactacacttaa";
		
		
		r=JOptionPane.showInputDialog("Para entrar com sequ�ncia\ndigite 0\n" +
				"Para sequ�ncia autom�tica\ndigite 1");
		n=Integer.parseInt(r);
		
		if(n == 1)
		{
			dna.setseq(str);
			dna.tamSeqDna();
		}
		else
		{	dna.entDna();
			dna.entSeqDna();
			dna.tamSeqDna();
			if(dna.verifica()==0)
			{
				JOptionPane.showMessageDialog(null,"sequ�ncia de DNA incorreta");
				System.exit(0);
			}
		}
		dna.ini(dna.nome,dna.seqDna);
		JOptionPane.showMessageDialog(null,"DNA\nNome=\n"+dna.shownome()+"\nTRanscri��o OK");
		
		
		System.exit(0);
	}
	
}
