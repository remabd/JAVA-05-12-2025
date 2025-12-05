package com.test.forme;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class TextureCarre extends GraphicalObject {
  Texture cubeTex;

  public TextureCarre(float pX, float pY, float pZ,
      float angX, float angY, float angZ,
      float r, float g, float b,
      float scale) {
    super(pX, pY, pZ, angX, angY, angZ, r, g, b, scale);

    try {
      this.cubeTex = TextureIO.newTexture(new File("assets/wood2.jpg"), true);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  public void displayNormalized(GL2 gl) {
    cubeTex.enable(gl);
    cubeTex.bind(gl);
    gl.glTexEnvi(GL2.GL_TEXTURE_ENV, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);
    gl.glBegin(GL2.GL_QUADS);
    gl.glTexCoord2f(0, 0);
    gl.glVertex3f(-1f, -1f, 0f);
    gl.glTexCoord2f(1, 0);
    gl.glVertex3f(1f, -1f, 0f);
    gl.glTexCoord2f(1, 1);
    gl.glVertex3f(1f, 1f, 0f);
    gl.glTexCoord2f(0, 1);
    gl.glVertex3f(-1f, 1f, 0f);
    gl.glEnd();
  }

}
