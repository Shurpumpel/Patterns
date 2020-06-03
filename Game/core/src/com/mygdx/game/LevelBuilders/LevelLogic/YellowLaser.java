package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class YellowLaser extends Lazer{

    public YellowLaser(Vector2 shooterPos) {
        this.power = 1;
        this.img = new Texture("yellowLaser.png");
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
