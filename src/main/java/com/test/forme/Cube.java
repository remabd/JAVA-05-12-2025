package com.test.forme;

import java.util.ArrayList;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;

public class Cube extends GraphicalObject {
  Texture cubeTex;
  private ArrayList<TextureCarre> faces;

  public Cube(float posX, float posY, float posZ,
      float angleX, float angleY, float angleZ,
      float r, float g, float b,
      float scale) {
    super(posX, posY, posZ, angleX, angleY, angleZ, r, g, b, scale);
    faces = new ArrayList<TextureCarre>();
    faces.add(new TextureCarre(0, 0, 1, 0, 0, 0, 0.12f, 0.25f, 0.69f, 1));
    faces.add(new TextureCarre(0, 0, -1, 0, 0, 0, 0.32f, 0.39f, 0.6f, 1));
    faces.add(new TextureCarre(1, 0, 0, 0, 90, 0, 0.05f, 0.16f, 0.53f, 1));
    faces.add(new TextureCarre(-1, 0, 0, 0, -90, 0, 0.41f, 0.47f, 0.69f, 1));
    faces.add(new TextureCarre(0, 1, 0, 90, 0, 0, 0.14f, 0.2f, 0.43f, 1));
    faces.add(new TextureCarre(0, -1, 0, 90, 0, 0, 0.57f, 0.63f, 0.83f, 1));
  }

  public void displayNormalized(GL2 gl) {
    for (TextureCarre face : faces) {
      face.display(gl);
    }
  }
}
