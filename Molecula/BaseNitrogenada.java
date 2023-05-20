package Molecula;

import javax.swing.JOptionPane;

public class BaseNitrogenada {
//variaveis globais
	private String Classificacao;//purica ou pirimidica
	private String base;//CGATU
	private int movingBas;
	
	
	//construtor
	public BaseNitrogenada()
	{//não está atribuindo
		Classificacao="purica";
		base="cg";//verificar se purica eh CG
		movingBas=0;
	}
	

	
	public static void main(String[] args) {
		//metodo Ligar;
		BaseNitrogenada bn=new BaseNitrogenada();
		bn.base="cg";//soh atribuindo no main que aparece
		JOptionPane.showMessageDialog(null,"Base Nitrogenada criada\nClassificação:\n"+bn.Classificacao+"\nTipo de base:\n"+bn.base+"\nposição:\n"+bn.movingBas);
		System.exit(0);
	}

}
