package Interface;

import java.awt.event.*;
import java.util.*;
//import net.java.games.jogl.*;
//import net.java.games.jogl.util.GLUT;





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
/**
 * @author renata
 *
 */
public class Grafico implements GLEventListener, MouseListener, MouseMotionListener, KeyListener
{
	private GLCanvas canvas = null;
	private double xmax, ymax;
	private double X = 0.0, Y = 0.0, zoom = 60.0; //Movimenta a sua visão
	private double currentX = 0.0, currentY = 0.0; //Movimenta a sua visão 
	private double[] corText = {1.0, 1.0, 1.0};
	private double[] corRaiz = {1.0, 1.0, 1.0};
	private double[] corFilho = {0.0, 0.7, 1.0};
	private double[] corFind = {0.8, 0.4, 0.3};
	private double[] corAresta = {1.0, 1.0, 0.7};
	public ArvoreBinaria arv = new ArvoreBinaria();
	
	public Grafico()
	{
		GLCapabilities capabilities = new GLCapabilities();
		capabilities.setHardwareAccelerated(true);
		capabilities.setDoubleBuffered(true);
		
		canvas = GLDrawableFactory.getFactory().createGLCanvas(capabilities);
		
		canvas.addGLEventListener(this);
		canvas.addMouseListener(this);
		canvas.addMouseMotionListener(this);
		canvas.addKeyListener(this);
		
		canvas.setSize(600, 600);
	}
	public GLCanvas getCanvas()
	{
		return this.canvas;
	}
	public void normalizeCanvas()
	{
		this.X = 0.0;
		this.Y = 0.0;
		this.zoom = 60.0;
		this.currentX = 0.0;
		this.currentY = 0.0;
		this.canvas.repaint();
	}
	public void repaintCanvas()
	{
		this.canvas.repaint();
	}
	public void defineWindow (int width, int height, float dx, float dy, float xc, float yc)
	{
		float dcr = (float) height / (float) width;
		
		if ( dy / dx < dcr )
			dy = dx * dcr;
		else
			dx = dy / dcr;
		
		this.xmax = xc + dx;
		this.ymax = yc + dy;
	}
	public void init(GLDrawable glDrawable)
	{
		
	}
	public void display(GLDrawable glDrawable)
	{
		GL gl = glDrawable.getGL();
		GLU glu = glDrawable.getGLU();
		int width = canvas.getWidth();
		int height = canvas.getHeight();
		int widthCanvas = 500;
		int heightCanvas = 500;
		float[] posLuz = {1.0f, 2.0f, 3.0f, 0.3f};
		
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posLuz); // Cria e configura a posição da LUZ
		
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // Coloca a cor Preta no fundo
		gl.glShadeModel(GL.GL_FASTEST);
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT); // Limpa o Buffer de cores

		gl.glViewport(0, 0, width, height); // Define a vizualização da VIEWPORT
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		
		this.defineWindow(width, height, widthCanvas, heightCanvas, 0, 0); // Define a janela sem distorção
		
		glu.gluPerspective(this.zoom, xmax / ymax, 1, 20);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL.GL_LIGHTING); // Ativa as luzes
		gl.glEnable(GL.GL_LIGHT0);
		gl.glEnable(GL.GL_COLOR_MATERIAL);
		glu.gluLookAt(0,0,5, 0,-2.5,0, 0,1,0);
		
		gl.glPushMatrix();
			gl.glTranslated(X, Y, 0.0);
			gl.glRotated(currentX, 1.0, 0.0, 0.0);
			gl.glRotated(currentY, 0.0, 1.0, 0.0);
			
			// Desenha a Árvore
			this.drawArvore();
		gl.glPopMatrix();
	}
	public void reshape(GLDrawable glDrawable, int arg1, int arg2, int arg3, int arg4)
	{
		
	}
	public void displayChanged(GLDrawable glDrawable, boolean arg1, boolean arg2)
	{
		
	}
 	public void drawText(double[] corText, double x, double y, String text)
 	{
 		GL gl = canvas.getGL();
 		GLUT glut = new GLUT();
 		
		gl.glColor3dv(corText);
		gl.glRasterPos3d(x, y, 0.12);
		glut.glutBitmapString(gl, GLUT.BITMAP_HELVETICA_12, text);
 	}
 	public void drawNoRaiz(double[] corNo, double EsfX, double EsfY)
 	{
 		GL gl = canvas.getGL();
 		GLU glu = canvas.getGLU();
 		GLUT glut = new GLUT();
 		
 		gl.glPushMatrix();
			gl.glTranslated(EsfX, EsfY, 0.0); // Transformação da Esfera p/ Localização
			
			gl.glColor3dv(corNo); // Define a Cor da Esfera
			glut.glutSolidSphere(glu, 0.1, 100, 100);
		gl.glPopMatrix();
 	}
 	public void drawNoDir(double[] corNo, double[] corAresta, double EsfX, double EsfY, double tamLig)
 	{
 		GL gl = canvas.getGL();
 		GLU glu = canvas.getGLU();
 		GLUT glut = new GLUT();
 		GLUquadric gluQuadric = glu.gluNewQuadric();
 		
 		gl.glPushMatrix();
 			gl.glTranslated(EsfX, EsfY, 0.0); // Transformação da Aresta p/ a Esquerda ou Direita
			gl.glRotated(90.0, -2.0, 1.0, 0.0); // Transformação para Rotacionar
	
			gl.glColor3dv(corAresta); // Define a Cor da Aresta
			glu.gluCylinder(gluQuadric, 0.03, 0.03, tamLig, 100, 100);
		gl.glPopMatrix();
 		
		gl.glPushMatrix();
			gl.glTranslated(EsfX, EsfY, 0.0); // Transformação da Esfera p/ Localização
		
			gl.glColor3dv(corNo); // Define a Cor da Esfera
			glut.glutSolidSphere(glu, 0.1, 100, 100);
		gl.glPopMatrix();
 	}
 	public void drawNoEsq(double[] corNo, double[] corAresta, double EsfX, double EsfY, double tamLig)
 	{
 		GL gl = canvas.getGL();
 		GLU glu = canvas.getGLU();
 		GLUT glut = new GLUT();
 		GLUquadric gluQuadric = glu.gluNewQuadric();
 		
 		gl.glPushMatrix();
			gl.glTranslated(EsfX, EsfY, 0.0); // Transformação da Aresta p/ a Esquerda ou Direita
			gl.glRotated(90.0, -2.0, -1.0, 0.0); // Transformação para Rotacionar
		
			gl.glColor3dv(corAresta); // Define a Cor da Aresta
			glu.gluCylinder(gluQuadric, 0.03, 0.03, tamLig, 100, 100);
		gl.glPopMatrix();
		
 		gl.glPushMatrix();
 			gl.glTranslated(EsfX, EsfY, 0.0); // Transformação da Esfera p/ Localização
		
 			gl.glColor3dv(corNo); // Define a Cor da Esfera
 			glut.glutSolidSphere(glu, 0.1, 100, 100);
 		gl.glPopMatrix();
 	}
 	public void drawArvore()
 	{
		// info das coordenadas dos nós
		int nivelTot = this.arv.getAltura(), nivelNo;
		double posXesq, posYesq, posXdir, posYdir;
		double disNo = 0.4, auxDisNoEsq, auxDisNoDir;
		Stack pilha = new Stack();
		
		//Calculo a distância dos Nós de um modo geral
		for ( int i = 0; i < nivelTot-2; i++ )
			disNo *= 2;
		
		//Não coloca a Raiz na pilha, se a Árvore estiver vazia 
		if ( this.arv.getRaiz() != null )
		{
			//Marca o nó como visitado
			pilha.push(this.arv.getRaiz());
			
			//Mostra a Raiz
			if ( this.arv.getRaiz() == this.arv.noAchado )
				this.drawNoRaiz(corFind, (this.arv.getRaiz()).getX(), (this.arv.getRaiz()).getY()); // Nó Raiz Achado
			else
				this.drawNoRaiz(corRaiz, (this.arv.getRaiz()).getX(), (this.arv.getRaiz()).getY()); // Nó Raiz
			this.drawText(corText, (this.arv.getRaiz()).getX(), (this.arv.getRaiz()).getY(), (this.arv.getRaiz()).getChave() + "" );
			
			//System.out.println((this.arv.getRaiz()).getChave() + "-" + (this.arv.getRaiz()).getNivel());
		}
		else
		{
			this.drawText(corText, -0.35, -2.35, "A Árvore está vazia!");
		}
		
		while ( !pilha.isEmpty() )
 		{
			this.arv.auxNo = (No) pilha.pop();
			
 			if ( this.arv.auxNo.getEsq() == null && this.arv.auxNo.getDir() != null )
 			{
 				if ( pilha.search(this.arv.auxNo.getDir()) != 1 )
 				{
 					//Marca o nó como visitado
					pilha.push(this.arv.auxNo.getDir());
				}
 				
 				//Calculo as coordenadas do Nó DIREITO para ser inseridas na Cena
 				posXdir = ((this.arv.auxNo.getDir()).getPai()).getX(); //Pego a coordenada X do Nó Pai
 				posYdir = ((this.arv.auxNo.getDir()).getPai()).getY(); //Pego a coordenada Y do Nó Pai
 				nivelNo = (this.arv.auxNo.getDir()).getNivel(); //Pego o nível do Nó Pai
 				auxDisNoDir = disNo;
 				
 				for ( int i = 0; i < nivelNo; i++ )
 					auxDisNoDir /= 2;
 				
 				posXdir -= (auxDisNoDir / 2);
 				posYdir -= auxDisNoDir;
 				
 				auxDisNoDir = auxDisNoDir + (auxDisNoDir / 8.5); //Colocar o tamanho exato da Ligação
 				
 				//Inserir os valores das coordenadas para auxiliar seus filhos
 				(this.arv.auxNo.getDir()).setX(posXdir);
 				(this.arv.auxNo.getDir()).setY(posYdir);
 				
 				/* Desenha o Nó Direito */
 				if ( this.arv.auxNo.getDir() == this.arv.noAchado )
 					this.drawNoDir(corFind, corAresta, posXdir, posYdir, auxDisNoDir); // Nó direito Achado
 				else
 					this.drawNoDir(corFilho, corAresta, posXdir, posYdir, auxDisNoDir); // Nó direito
				this.drawText(corText, posXdir, posYdir, (this.arv.auxNo.getDir()).getChave() + "");
 				
				//System.out.println((this.arv.auxNo.getDir()).getChave() + "-" + (this.arv.auxNo.getDir()).getNivel());
 			}
 			else if ( this.arv.auxNo.getEsq() != null && this.arv.auxNo.getDir() == null )
 			{
 				if ( pilha.search(this.arv.auxNo.getEsq()) != 1 )
 				{
 					//Marca nó como visitado
 					pilha.push(this.arv.auxNo.getEsq());
 				}
 				
 				//Calculo as coordenadas do Nó ESQUERDO para ser inseridas na Cena
 				posXesq = ((this.arv.auxNo.getEsq()).getPai()).getX(); //Pego a coordenada X do Nó Pai
 				posYesq = ((this.arv.auxNo.getEsq()).getPai()).getY(); //Pego a coordenada Y do Nó Pai
 				nivelNo = (this.arv.auxNo.getEsq()).getNivel(); //Pego o nível do Nó Pai
 				auxDisNoEsq = disNo;
 				
 				for ( int i = 0; i < nivelNo; i++ )
 					auxDisNoEsq /= 2;
 				
 				posXesq += (auxDisNoEsq / 2);
 				posYesq -= auxDisNoEsq;
 				
 				auxDisNoEsq = auxDisNoEsq + (auxDisNoEsq / 8.5); //Colocar o tamanho exato da Ligação
 				
 				//Inserir os valores das coordenadas para auxiliar seus filhos
 				(this.arv.auxNo.getEsq()).setX(posXesq);
 				(this.arv.auxNo.getEsq()).setY(posYesq);

 				/* Desenha o Nó Esquerdo */
 				if ( this.arv.auxNo.getEsq() == this.arv.noAchado )
 					this.drawNoEsq(corFind, corAresta, posXesq, posYesq, auxDisNoEsq); // Nó esquerdo Achado
 				else
 					this.drawNoEsq(corFilho, corAresta, posXesq, posYesq, auxDisNoEsq); // Nó esquerdo
				this.drawText(corText, posXesq, posYesq, (this.arv.auxNo.getEsq()).getChave() + "");
 				
				//System.out.println((this.arv.auxNo.getEsq()).getChave()  + "-" + (this.arv.auxNo.getEsq()).getNivel());
 			}
 			else if ( this.arv.auxNo.getEsq() != null && this.arv.auxNo.getDir() != null )
 			{
 				if ( pilha.search(this.arv.auxNo.getEsq()) != 1 )
 				{
 					//Marca nó como visitado
 					pilha.push(this.arv.auxNo.getEsq());
 				}
 				if ( pilha.search(this.arv.auxNo.getDir()) != 1 )
 				{
 					//Marca nó com visitado
 					pilha.push(this.arv.auxNo.getDir());
				}
 				
 				//Calculo as coordenadas do Nó DIREITO para ser inseridas na Cena
 				posXdir = ((this.arv.auxNo.getDir()).getPai()).getX(); //Pego a coordenada X do Nó Pai
 				posYdir = ((this.arv.auxNo.getDir()).getPai()).getY(); //Pego a coordenada Y do Nó Pai
 				nivelNo = (this.arv.auxNo.getDir()).getNivel(); //Pego o nível do Nó Pai
 				auxDisNoDir = disNo;
 				
 				for ( int i = 0; i < nivelNo; i++ )
 					auxDisNoDir /= 2;
 				
				posXdir -= (auxDisNoDir / 2);
 				posYdir -= auxDisNoDir;
 				
 				auxDisNoDir = auxDisNoDir + (auxDisNoDir / 8.5); //Colocar o tamanho exato da Ligação
 				
 				//Inserir os valores das coordenadas para auxiliar seus filhos
 				(this.arv.auxNo.getDir()).setX(posXdir);
 				(this.arv.auxNo.getDir()).setY(posYdir);
 				
				/* Desenha Nó Direito */
 				if ( this.arv.auxNo.getDir() == this.arv.noAchado )
 					this.drawNoDir(corFind, corAresta, posXdir, posYdir, auxDisNoDir); // Nó direito Achado
 				else
 					this.drawNoDir(corFilho, corAresta, posXdir, posYdir, auxDisNoDir); // Nó direito
				this.drawText(corText, posXdir, posYdir, (this.arv.auxNo.getDir()).getChave() + "");
 				
 				//Calculo as coordenadas do Nó ESQUERDO para ser inseridas na Cena
 				posXesq = ((this.arv.auxNo.getEsq()).getPai()).getX(); //Pego a coordenada X do Nó Pai
 				posYesq = ((this.arv.auxNo.getEsq()).getPai()).getY(); //Pego a coordenada Y do Nó Pai
 				nivelNo = (this.arv.auxNo.getEsq()).getNivel(); //Pego o nível do Nó Pai
 				auxDisNoEsq = disNo;
 				
 				for ( int i = 0; i < nivelNo; i++ )
 					auxDisNoEsq /= 2;

 				posXesq += (auxDisNoEsq / 2);
 				posYesq -= auxDisNoEsq;
 				
 				auxDisNoEsq = auxDisNoEsq + (auxDisNoEsq / 8.5); //Colocar o tamanho exato da Ligação
 				
 				//Inserir os valores das coordenadas para auxiliar seus filhos
 				(this.arv.auxNo.getEsq()).setX(posXesq);
 				(this.arv.auxNo.getEsq()).setY(posYesq);

 				/* Desenha Nó Esquerdo */				
 				if ( this.arv.auxNo.getEsq() == this.arv.noAchado )
 					this.drawNoEsq(corFind, corAresta, posXesq, posYesq, auxDisNoEsq); // Nó esquerdo Achado
 				else
 					this.drawNoEsq(corFilho, corAresta, posXesq, posYesq, auxDisNoEsq); // Nó esquerdo
				this.drawText(corText, posXesq, posYesq, (this.arv.auxNo.getEsq()).getChave() + "");
				
				//System.out.println((this.arv.auxNo.getDir()).getChave() + "-" + (this.arv.auxNo.getDir()).getNivel());
				//System.out.println((this.arv.auxNo.getEsq()).getChave() + "-" + (this.arv.auxNo.getEsq()).getNivel());
 			}
 		}
 	}
	public void mouseClicked(MouseEvent me)
	{
		
	}
	public void mousePressed(MouseEvent me)
	{
		
	}
	public void mouseReleased(MouseEvent me)
	{
		
	}
	public void mouseEntered(MouseEvent me)
	{
		
	}
	public void mouseExited(MouseEvent me)
	{
		
	}
	public void mouseDragged(MouseEvent me)
	{
		// transforma a visualização
		currentX = me.getY();
		currentY = me.getX();
		canvas.repaint();
	}
	public void mouseMoved(MouseEvent me)
	{
		
	}
	public void keyTyped(KeyEvent ke)
	{
		
	}
	public void keyPressed(KeyEvent ke)
	{
		if ( ke.getKeyCode() == KeyEvent.VK_UP )
		{
			this.Y -= 0.1;
			canvas.repaint();
		}
		if ( ke.getKeyCode() == KeyEvent.VK_LEFT )
		{
			this.X += 0.1;
			canvas.repaint();
		}
		if ( ke.getKeyCode() == KeyEvent.VK_RIGHT )
		{
			this.X -= 0.1;
			canvas.repaint();
		}
		if ( ke.getKeyCode() == KeyEvent.VK_DOWN )
		{
			this.Y += 0.1;
			canvas.repaint();
		}
		if ( ke.getKeyCode() == KeyEvent.VK_ADD || ke.getKeyCode() == KeyEvent.VK_EQUALS )
		{
			this.zoom--;
			canvas.repaint();
		}
		if ( ke.getKeyCode() == KeyEvent.VK_SUBTRACT || ke.getKeyCode() == KeyEvent.VK_MINUS )
		{
			this.zoom++;
			canvas.repaint();
		}
	}
	public void keyReleased(KeyEvent ke)
	{
		
	}
}