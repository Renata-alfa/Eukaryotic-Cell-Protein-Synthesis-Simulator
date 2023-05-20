package Interface;

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
public class No
{
	private int chave, nivel;
	//private boolean status; //TRUE - Se o Nó foi achado e FALSE - Se o Nó não foi achado
	private double x, y;
	private No pai;
	private No esq;
	private No dir;
	
	public No()
	{
		
	}
	public No(int chave)
	{
		this.chave = chave;
		this.nivel = 0;
		this.pai = null;
		this.esq = null;
		this.dir = null;
	}
	public int getChave()
	{
		return this.chave;
	}
	public int getNivel()
	{
		return this.nivel;
	}

	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public No getEsq()
	{
		return this.esq;
	}
	public No getPai()
	{
		return this.pai;
	}
	public No getDir()
	{
		return this.dir;
	}
	public void setChave(int chave)
	{
		this.chave = chave;
	}
	public void setNivel(int nivel)
	{
		this.nivel = nivel;
	}

	public void setX(double x)
	{
		this.x = x;
	}
	public void setY(double y)
	{
		this.y = y;
	}
	public void setPai(No pai)
	{
		this.pai = pai;
	}
	public void setEsq(No esq)
	{
		this.esq = esq;
	}
	public void setDir(No dir)
	{
		this.dir = dir;
	}
}
