package com.test.app;

import java.awt.Dimension;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.Animator;

import java.awt.event.KeyEvent;

import com.test.forme.Cube;
import com.test.forme.GraphicalObject;

public class App extends GLCanvas implements GLEventListener {

  public ArrayList<GraphicalObject> objects;
  public Cube cube1, cube2, cube3;
  public float rot1, rot2, rot3;
  public float eX, eY, eZ;

  /**
   * 
   */
  public App() {
    this.addGLEventListener(this);
    this.objects = new ArrayList<GraphicalObject>();

  }

  /**
   * 
   */
  public void init(GLAutoDrawable drawable) {
    this.cube1 = new Cube(0, 0, 0, 0, 0, 0, 1, 0, 0, 0.4f);
    this.cube2 = new Cube(0, 1.0f, 0, 0, 0, 0, 1, 0, 0, 0.25f);
    this.cube3 = new Cube(0, 1.5f, 0, 0, 0, 0, 1, 0, 0, 0.125f);
    this.eX = 0.0f;
    this.eY = 0.0f;
    this.eZ = 0.0f;
    this.objects.add(cube1);
    this.objects.add(cube2);
    this.objects.add(cube3);
    this.addKeyListener(new KeyListener() {

      @Override
      public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub

      }

      @Override
      public void keyPressed(KeyEvent e) {

      }

      @Override
      public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

      }

    });
    GL2 gl = drawable.getGL().getGL2();
    gl.glEnable(GL2.GL_TEXTURE_2D);
    gl.glEnable(GL2.GL_BLEND);
    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE);
    gl.glDepthFunc(GL2.GL_ALWAYS);
    gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    gl.glHint(GL2.GL_POINT_SMOOTH_HINT, GL2.GL_NICEST);
  }

  /**
   * 
   */
  public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    GL2 gl = drawable.getGL().getGL2();
    final GLU glu = new GLU();
    float aspect = (float) width / height;
    // Set the view port (display area)
    gl.glViewport(0, 0, width, height);
    // Setup perspective projection,
    gl.glMatrixMode(GL2.GL_PROJECTION);
    gl.glLoadIdentity();
    glu.gluPerspective(45.0, aspect, 0.1, 100.0);
    // Enable the model-view transform
    gl.glMatrixMode(GL2.GL_MODELVIEW);
    gl.glLoadIdentity();
    // Enable depth test
    gl.glEnable(GL2.GL_DEPTH_TEST);
  }

  /**
   * 
   */
  public void display(GLAutoDrawable drawable) {
    GL2 gl = drawable.getGL().getGL2();
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();

    gl.glTranslatef(0, 0, -5);

    gl.glRotatef(this.rot1, 1.0f, 1.0f, 0.0f);
    this.cube1.setAlpha(0.3f);
    this.cube1.display(gl);
    gl.glRotatef(this.rot2, 1.0f, 0.0f, 1.0f);
    this.cube3.display(gl);
    gl.glRotatef(this.rot3, 0.0f, 1.0f, 1.0f);
    this.cube2.display(gl);

    this.rot1 += 0.01f;
    this.rot2 += 0.25f;
    this.rot3 += 0.4f;
  }

  /**
   *  
   */
  public void dispose(GLAutoDrawable drawable) {
  }

  public static void main(String[] args) {
    GLCanvas canvas = new App();
    canvas.setPreferredSize(new Dimension(800, 600));
    final JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(canvas);
    frame.setTitle("Java - OpenGL");
    frame.pack();
    frame.setVisible(true);
    final Animator animator = new Animator(canvas);
    animator.start();
  }
}
