package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GreenLaser extends Lazer{

    public GreenLaser(Vector2 shooterPos){
        this.power = 2;
        this.img = new Texture("greenLaser.png");
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
