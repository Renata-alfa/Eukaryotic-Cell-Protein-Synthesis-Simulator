package Interface;


import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import AcidosNucleicos.Dna;
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

 public class Controlador{
	
	 Convencional convencional ;
	 public Controlador()
	 {
		 
	 }
	 public void Ini(int op,String nome,String seq)
	 {
		if(op == 1)
		{
			
			JOptionPane.showMessageDialog(null,"op="+op+"nome="+nome+"seq="+seq+"\nIniciando modo CONVENCIONAL");			
			convencional = new Convencional(nome,seq);
			
		}
		if(op == 2)
		{
			JOptionPane.showMessageDialog(null,"Iniciando modo INTERAÇÃO");
			Interacao interacao = new Interacao();
			interacao.Enter(nome,seq);
		}
		if(op == 3)
		{
			JOptionPane.showMessageDialog(null,"Iniciando modo SIMULAÇÃO");
			Simulacao simulacao = new Simulacao();
		}
		
		
	 }
	 
	 public String getInfstr()
	 {		 
			 //return convencional.getString();
		 return "InfStr-DÃn";
	  }
	
	 public int getInfint()
	 {		 
		 //return convencional.getInt();
		 return 13;
	 }
	
	 
 }
		