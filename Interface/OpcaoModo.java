package Interface;

//import java.lang.System;
import javax.swing.JOptionPane;

public class OpcaoModo 
{
	
		public void Escolha()
		{
			String Entrada;
		    int Num;
		   
	
		    Entrada=JOptionPane.showInputDialog("Escolha: 1 para Simula��o\n2 para Intera��o\n3 para Convencional");
		    Num=Integer.parseInt(Entrada);
		    		
			switch(Num) 
			{
				case 1:
					//ativar Simula��o;
					JOptionPane.showMessageDialog(null,"Simula��o Ativada");
					break;
				case 2:
					JOptionPane.showMessageDialog(null,"Intera��o Ativada");
					break;
				case 3:
					JOptionPane.showMessageDialog(null,"Convencional Ativado");
					break;
				default :
					JOptionPane.showMessageDialog(null,"Valor Inv�lido");
				//falta tratamento para entrada de string e caracteres;
			}
		
		}
		
	
		
		public static void main (String[] args)//
		{
			OpcaoModo opm=new OpcaoModo();
			opm.Escolha();
		}
	
 
}