package com.test.system;

import java.util.ArrayList;

import com.test.forme.Particule;

public class ParticuleSystem {
  private final ArrayList<Particule> particules = new ArrayList<>();
  private float emitterX, emitterY, emitterZ;

  public float emissionRate = 200f; // particles/sec
  public float gravityY = -40.0f;
  public float windX = 10.0f, windZ = 0.0f;
  public float drag = 0.3f;

  private float emitAcc = 0f;

  public ParticuleSystem(float x, float y, float z) {
    this.emitterX = x;
    this.emitterY = y;
    this.emitterZ = z;
    for (int i = 0; i < 200; i++) {
      this.particules.add(new Particule());
    }
  }
}
