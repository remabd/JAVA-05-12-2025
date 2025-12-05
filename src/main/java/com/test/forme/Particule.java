package com.test.forme;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class Particule extends GraphicalObject {
  private static final Random RNG = new Random();

  public float vx, vy, vz;
  public float life, maxLife;
  private Texture cubeTex;

  private TextureCarre shape = new TextureCarre(0f, 0f, 0f, 0f, 0f, 0f, 1f, 1f, 0f, 1f);

  public Particule() {
    super(0, 0, -10f, 0, 0, 0, 1f, 1f, 0, 0.1f);
    this.vx = RNG.nextFloat();
    this.vy = RNG.nextFloat();
    this.vz = 2f + 2f * RNG.nextFloat();
    this.life = 150 + 50 * RNG.nextFloat();
    this.maxLife = 200;

    try {
      this.cubeTex = TextureIO.newTexture(new File("assets/wood2.jpg"), true);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  public Particule(float vx, float vy, float vz, float life, float maxLife) {
    super(0, 0, -10f, 0, 0, 0, 1f, 1f, 0, 0.1f);
    this.vx = vx;
    this.vy = vy;
    this.vz = vz;
    this.life = life;
    this.maxLife = maxLife;

    try {
      this.cubeTex = TextureIO.newTexture(new File("assets/wood2.jpg"), true);
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
  }

  @Override
  public void displayNormalized(GL2 gl) {
    this.shape.displayNormalized(gl);
  }

  private boolean isAlive() {
    return this.life > 0;
  }

  public void update(float dt, float ax, float ay, float az, float drag) {
    if (!isAlive())
      return;

    vx += (ax - drag * vx) * dt;
    vy += (ay - drag * vy) * dt;
    vz += (az - drag * vz) * dt;

    translate(vx * dt, vy * dt, vz * dt);

    life -= dt;
    float t = life / maxLife; // 1 -> 0
    setAlpha(Math.max(0f, Math.min(1f, t)) * 0.5f);
  }

}
