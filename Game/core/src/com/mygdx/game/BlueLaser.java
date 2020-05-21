package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BlueLaser extends Lazer {
    public BlueLaser(Vector2 shooterPos) {
        this.power = 2;
        this.img = new Texture("playerLazer.png");
        this.speed = 6;
        this.laserPos = shooterPos;
        laserPos.x += 30;
        laserPos.y += 70;
    }

    @Override
    public void update() {
        this.laserPos.y += speed;
    }
}
