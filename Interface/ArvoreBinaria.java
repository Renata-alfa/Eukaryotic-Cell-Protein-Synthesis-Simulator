package Interface;

import java.util.*;
import java.util.Stack;

/*
 * Created on 19/04/2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

/**
 * @author Rodrigo Achilles Pereira
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ArvoreBinaria
{
	public static final int ARVORE_VAZIA = 0;
	public static final int NO_ACHADO = 1;
	public static final int NAO_ACHADO_ESQ = 2;
	public static final int NAO_ACHADO_DIR = 3;
	public static final int INSERIDO_SUCESSO = 4;
	public static final int ERRO_NIVEL_10 = 5;
	public int statusBusca; //É a variável "f"
	public int statusInserir;
	public No noAchado = new No();
	private No noInsercao = new No();
	
	private No raiz;
	private int altura;
	private String preOrder = new String(), postOrder = new String(), inOrder = new String();
	protected Stack pilha = new Stack();
	public No auxNo = new No();
	
	public ArvoreBinaria()
	{
		
	}
	public int getAltura()
	{
		if ( this.raiz == null )
			return 0;
		
		this.calcAltura(raiz);
		
		return this.altura;
	}
	public void calcAltura(No auxNo)
	{
		// insere o nó na pilha
		this.pilha.push(auxNo);
		
		if ( auxNo.getDir() != null )
			this.calcAltura(auxNo.getDir());
		
		if ( auxNo.getEsq() != null )
			this.calcAltura(auxNo.getEsq());
		
		if (pilha.size() > this.altura)
			this.altura = this.pilha.size();

		// retira o nó da pilha
		this.pilha.pop();
	}
	public No getRaiz()
	{
		return this.raiz;
	}
	public String getPreOrder()
	{
		this.preOrder = ""; // Zera a variável para não pegar lixo
		
		if ( this.raiz == null )
			return null;
		
		this.preOrder(this.raiz);
		
		return this.preOrder;
	}
	public String getPostOrder()
	{
		this.postOrder = ""; // Zera a variável para não pegar lixo
		
		if ( this.raiz == null )
			return null;
		
		this.postOrder(this.raiz);
		
		return this.postOrder;
	}
	public String getInOrder()
	{
		this.inOrder = ""; // Zera a variável para não pegar lixo
		
		if ( this.raiz == null )
			return null;
		
		this.inOrder(this.raiz);
		
		return this.inOrder;
	}
	public void addNo(int chave)
	{
		No no = this.raiz;
		
		findNo(no, chave, true); //Busca o número para não por de novo
		
		if ( this.statusBusca == ArvoreBinaria.NO_ACHADO )
		{
			this.statusInserir = ArvoreBinaria.NO_ACHADO; // Achei, não pode ser inserido!
		}
		else
		{
			No novoNo = new No(chave); // Cria o Nó
			
			if ( this.statusBusca == ArvoreBinaria.ARVORE_VAZIA )
			{
				this.raiz = novoNo;
				this.raiz.setX(0.0);
				this.raiz.setY(0.0);
				this.raiz.setNivel(0);
				this.statusInserir = ArvoreBinaria.INSERIDO_SUCESSO; // Sucesso!
			}
			else
			{
				if( this.statusBusca == ArvoreBinaria.NAO_ACHADO_ESQ )
				{
					if ( this.noInsercao.getNivel() == 9 )
					{
						this.statusInserir = ArvoreBinaria.ERRO_NIVEL_10; // 1 - Número não pode ficar abaixo do Nível 10. Minha Regra!
					}
					else
					{
						this.noInsercao.setEsq(novoNo);
						novoNo.setPai(this.noInsercao);
						novoNo.setNivel(this.noInsercao.getNivel() + 1);
						this.statusInserir = ArvoreBinaria.INSERIDO_SUCESSO; // Sucesso!
					}
				}
				else if ( this.statusBusca == ArvoreBinaria.NAO_ACHADO_DIR )
				{
					if ( this.noInsercao.getNivel() == 9 )
					{
						this.statusInserir = ArvoreBinaria.ERRO_NIVEL_10; // 1 - Número não pode ficar abaixo do Nível 10. Minha Regra!
					}
					else
					{
						this.noInsercao.setDir(novoNo);
						novoNo.setPai(this.noInsercao);
						novoNo.setNivel(this.noInsercao.getNivel() + 1);
						this.statusInserir = ArvoreBinaria.INSERIDO_SUCESSO; // Sucesso!
					}
				}
			}
		}
	}
	public void findNo(No no, int chave, boolean insercao)
	{
		if ( no == null )
			this.statusBusca = ArvoreBinaria.ARVORE_VAZIA;
		else
		{
			if ( chave == no.getChave() )
			{
				this.statusBusca = ArvoreBinaria.NO_ACHADO;
				if ( !insercao )
					this.noAchado = no;
			}
			else
			{
				if ( chave > no.getChave())
				{
					if ( no.getEsq() == null )
					{
						this.statusBusca = ArvoreBinaria.NAO_ACHADO_ESQ;
						this.noInsercao = no;
					}
					else
					{
						findNo(no.getEsq(), chave, insercao);
					}
				}
				else
				{
					if ( no.getDir() == null )
					{
						this.statusBusca = ArvoreBinaria.NAO_ACHADO_DIR;
						this.noInsercao = no;
					}
					else
					{
						findNo(no.getDir(), chave, insercao);
					}
				}
			}
		}
	}
	public boolean removeNo(int chave)
	{
		return false;
	}
	public boolean limparArvore()
	{
		if ( this.raiz != null )
		{
			this.altura = 0;
			this.raiz = null;
			return true;
		}
		
		return false;
	}
	public void preOrder(No no)
	{
		this.preOrder += no.getChave() + " "; //No início
		
		if ( no.getDir() != null )
			preOrder(no.getDir());
		
		if ( no.getEsq() != null )
			preOrder(no.getEsq());
	}
	public void postOrder(No no)
	{
		if ( no.getDir() != null )
			postOrder(no.getDir());
		
		if ( no.getEsq() != null )
			postOrder(no.getEsq());
		
		this.postOrder += no.getChave() + " "; //No fim
	}
	public void inOrder(No no)
	{
		if ( no.getDir() != null )
			inOrder(no.getDir());
		
		this.inOrder += no.getChave() + " "; //No meio
		
		if ( no.getEsq() != null )
			inOrder(no.getEsq());
	}
}