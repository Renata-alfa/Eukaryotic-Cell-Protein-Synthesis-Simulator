package AcidosNucleicos;

import javax.swing.JOptionPane;

import Organelas.Ribossomo;
import Sequencias.Proteina;


//esta classe herda - extends- de Rna
public class RnaMensageiro extends Rna{
//	variaveis globais do RnaMensageiro
	private String codon; 	   
	public int tam,startc,stopc;
	
	
	//construtor
	public RnaMensageiro()
	{	
		classificacao="Mensageiro";
		tam=0;
		startc=0;
		stopc=0;
	}
	
	//metodo para set codon
	public void setcodon(String cod)
	{
		codon=cod;
	}
	
	//metodo para set sequencia
	public void setseq(String sq)
	{
		seq=sq;
	}
	
	//metodo para acessar startc
	public int getstart()
	{
		return startc;
	}
	
	//metodo para acessar stopc
	public int getstop()
	{
		return stopc;
	}
	
	//atribui tamanho da sequencia de Rnam
	public void tamSeqRnam()
	{
		tam=seq.length();
	}
	
	public int showTam()
	{
		return tam;
	}

	//chama novo Rnat
	public RnaTransportador callRnat(int tam)
	{	
		//switch(escolha)
		//{case 1
		//		simulação invoca Rnat, jah deve existir, sem usar geraRnat
		// case 2
		//		interação invoca Rnat, jah deve existir, sem usar geraRnat
		// case 3
		//		modo convencional cria}
		
		//modo convencional
		//JOptionPane.showMessageDialog(null,"Chamando Rnat");
		
		RnaTransportador rnat=new RnaTransportador();
		rnat=rnat.geraRnat(tam);
		
		return rnat;
	}
	
	//metodo para achar o StartCodon e retorna a posição, 
	//senão -1
	public int startcodon()
	{	JOptionPane.showMessageDialog(null,"Procurando Start Códon");
		int i;
		char c1,c2,c3;
				
		for(i=0;i<this.tam;i++)
		{	
			c1=this.seq.charAt(i);
			c2=this.seq.charAt(i+1);
			c3=this.seq.charAt(i+2);
			
			//AUG metionina
		 	if((c1=='a'&& c2=='u'&& c3=='g')||(c1 == 'A'&& c2 == 'U'&& c3 == 'G'))	
		 	{	
		 		this.startc=i;
		 		JOptionPane.showMessageDialog(null,"Encontrado Start Códon");
		 		return i;//achou a posição do start codon no rnam
		 		}
		 	
		}     
		JOptionPane.showMessageDialog(null,"Não encontrado o Start Códon");
		return -1;
	}
	
	//metodo para achar o StopCodon e retorna a posição, senão -1
	public int stopcodon(int j)
	{	
		char c1,c2,c3;
										
			c1=this.seq.charAt(j);
			c2=this.seq.charAt(j+1);
			c3=this.seq.charAt(j+2);
			
			//inicializa o laço com a nova posição		    
			//a parada eh determinada quando achar o stopcodon q saum: UAA,UGA ou UAG
			if((c1=='u'&& c2=='a' && c3=='a')||('u'==c1 &&'g'==c2 &&'a'==c3)||(c1=='u'&& c2=='a' && c3=='g'))
			{	JOptionPane.showMessageDialog(null,"Encontrado Stop Códon");
				this.stopc=j;
				return 1;
			}
				
		return -1;
	}
	
	//metodo de tradução chama RnaM e RnaT	
	public Proteina traducao(RnaTransportador rnat)
	{
		JOptionPane.showMessageDialog(null,"Inicializando Tradução" );
		int i,j;
		boolean r=true;
		Proteina p=new Proteina();
		Ribossomo rib=new Ribossomo();
		this.tamSeqRnam();
		
		if(this.tam <= 4)
		{
			JOptionPane.showMessageDialog(null,"O tamanho do RANm é"+this.tam+"ou seja,<=4\n" +
					"não podendo realizar a tradução.\nEntre com uma sequência maior");
			System.exit(0);
		}
		JOptionPane.showMessageDialog(null,"Tam do RANm"+this.showTam());
		//verifica aonde estah o start codon
		i=this.startcodon();
		
		if(i>=0)
		{//começa a síntese na posição do startcodon
			
				for(j=i;j<this.tam-2;j++)//é -2 devido a trinca de bases
					{//ex:tam=10,10-2=8	e 7<8, 3 posições garantidas=7,8 e 9	
					
						if(this.stopcodon(j)==1)//achou stopcodon
						  return p;
						  
												
																					
																		
						while(rib.verCodon(this,j,rnat)==false)
						{
							
							//chama outro rnat
							//atualiza o rnat na funçao de tradução							
							
							rnat=callRnat(rnat.showTam());			 			
							p.numRnat+=1;
				 			
						}
						
						p.setSeq(rnat.Aminoacido);
											
					}
						     
				
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Não houve início de Tradução\nnão há Start Codon");
			p=null;
	
		}	
		
		return p;
	}
	
	
	public static void main(String[] args) 
	{
		RnaMensageiro rnam=new RnaMensageiro ();
		Dna dna=new Dna();
		RnaTransportador rnat=new RnaTransportador();
		Proteina p=new Proteina();
		int n;
		String r;
		
		
		
		r=JOptionPane.showInputDialog("Para entrar com sequência\ndigite 0\n" +
										"Para sequência automática\ndigite 1");	
		n=Integer.parseInt(r);
		if(n == 0)
		{
			rnam.seq=JOptionPane.showInputDialog("Entre com sequência para RNAm\n" +
					"apenas com caracteres A,U,C e G\n" +
					"deve iniciar com AUG\n" +
					"e terminar com UAA,UGA ou UAG");
			rnam.tamSeqRnam();
			rnat.seq=JOptionPane.showInputDialog("Entre com sequência para RNAt\n" +
					"apenas com caracteres A,U,C e G");
			rnat.Aminoacido=JOptionPane.showInputDialog("Entre com o Aminoácido\nEscolha entre:\n" +
					"Asp-Glu-Ala-Arg-Asn-Cys-Phe-Gly\n" +
					"Gln-His-Ile-Leu-Lys-Met-Pro-Ser\n" +
					"Tyr-Thr-Trp-Val");
			rnat.Anticodon=JOptionPane.showInputDialog("Entre com o Anti-códon\n" +
					"deve ser uma combinação de 3 carcateres\n" +
					"dentre eles A,U,C e G");
			rnat.tamSeqRnat();
			
		}
		else
		{
			rnat.Aminoacido="Glu";
			rnat.Anticodon="cgc";
			rnat.seq="uacacu";
			rnat.tamSeqRnat();
			
			
			rnam.seq="auguaacgc cgcgcgcggcgc cgcgcgcgcg cgcgcgcgcgc " +
					"ggcgcgcgcgcgcgc ggcgcgcgcgcgcgc" +
					"ggcgcgcgcgcgcgc ggcgcgcgcgcgcgc " +
					"ggcgcgcgcgcgcgc uaaaaaaaaaa";
		}
		
		p=rnam.traducao(rnat);		
		JOptionPane.showMessageDialog(null,"Proteina Finalizada\nsequencia de AA:\n"+p.showSeq());
		System.exit(0);
	}
}