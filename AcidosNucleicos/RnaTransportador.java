package AcidosNucleicos;

import javax.swing.JOptionPane;



public class RnaTransportador extends Rna{
//variaveis globais
	String Aminoacido;
	String Anticodon;
	int tam;
	
	//construtor
	public RnaTransportador()
	{
		Aminoacido="";
		Anticodon="";
		tam=0;
	}
	
	//set Aminoacido
	public void setAa(String aa)
	{
		Aminoacido=aa;
	}
	
	//set Anticodon
	public void setAc(String ac)
	{
		Anticodon=ac;
	}
	
	
	//metodo para atribuir tamanho da sequencia em tam
	public void tamSeqRnat()
	{
		tam=seq.length();
	}
	
	
	//metodo que retorna tam
	public int showTam()
	{
		return tam;
	}
	
	//retornar um caracter dos 3 do Anticodon
	public char showcharAc(int i)
	{
		return Anticodon.charAt(i);
	}
	
	public String showSeq()
	{
		return seq;
	}
	
	//metodo que gera sequencia do Rnat aleatoriamente
	public void geraSeq(int tam)
	{
		String str="aucg";//bases para Rna - A,U,C e G
		int j, i;
		
		j=0;
		for(i=0;i<tam;i++)
		{	//é passado o número de bases que são 4
			
			j=( 1 + ( int ) ( Math.random() * 4 ) ); 
			
			this.seq+=str.charAt(j-1);	
			
			
		}
		
			
	}
	
	//metodo que gera Anticodon do Rnat aleatoriamente
	public void geraAnticodon()
	{
		int i,
			j;
		
		//o anticodon tem q escolher 3 na seq gerada
		j=(( int ) ( Math.random() * (this.tam - 3) ));
		if(j < 0)
			j=j*(-1);
			
		for(i=0;i<3;i++)
		{	
			
			this.Anticodon+=this.seq.charAt(j);
			
			j++;
			
		}
		
	}
	
	
	//metodo que gera Aminoacido
	public void geraAA()
	{
		int i,j;
		String aa[]={"Asp","Glu","Ala","Arg","Asn","Cys","Phe","Gly","Gln","His","Ile",
				"Leu","Lys","Met","Pro","Ser","Tyr","Thr","Trp","Val"};
		//entre outros,tem q verificar se são correspndentes ao anticodon
		
		//o aminoacido tem q ser escolhido entre os da lista,no caso 20
		//o rnat pode carregar mais de um AA
		//aqui está sendo considerado apenas 1 naum precisando de for 
			
			j=  ( int ) ( Math.random() * (20) );
			if(j < 0)
				j=j*(-1);
			
			Aminoacido=aa[j];
			//this.Aminoacido=aa[j];
					
		
	}
	
	//metodo que gera Rnat
	public RnaTransportador geraRnat(int tam_tot_rnat) {
		//criar aleatoriamente
		int tam;
		
		RnaTransportador rnat=new RnaTransportador();
		
		
		//o Rnat é formado por 10% do RNAtotal, ou 75 a 100 bases do RNAtotal
		
		
		tam=tam_tot_rnat; 
		rnat.geraSeq(tam);	
		rnat.tamSeqRnat();
		rnat.geraAnticodon();
		rnat.geraAA();
		return rnat;
		
	}

	
	
	
	public static void main(String[] args) {
		RnaTransportador rnat=new RnaTransportador();
		rnat=rnat.geraRnat(20);//aleatorio, mas entra o tam total de RNA
		
		JOptionPane.showMessageDialog(null,"Foi gerado\nsequencia Rnat="+rnat.seq);
		JOptionPane.showMessageDialog(null,"Foi gerado\nanticodon Rnat="+rnat.Anticodon);
		JOptionPane.showMessageDialog(null,"Foi gerado\naminoacido Rnat="+rnat.Aminoacido);
		System.exit(0);

	}

}
