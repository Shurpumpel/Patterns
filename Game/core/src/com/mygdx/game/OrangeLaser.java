package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class OrangeLaser extends Lazer{

    public OrangeLaser(Vector2 shooterPos) {
        this.power = 1;
        this.img = new Texture("orangeLaser.png");
        this.speed = 5;
        this.laserPos = shooterPos;
        laserPos.x += 24;
        laserPos.y -= 70;
    }
    @Override
    public void update() {
        this.laserPos.y -= speed;
    }
}
