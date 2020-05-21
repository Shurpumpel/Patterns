package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class RedLaser extends Lazer{
    public RedLaser(Vector2 shooterPos) {
        this.power = 3;
        this.img = new Texture("redLaser.png");
        this.speed = 5;
        this.laserPos = shooterPos;
        laserPos.x += 30;
        laserPos.y -= 70;
    }

    @Override
    public void update() {
        this.laserPos.y -= speed;
    }
}
