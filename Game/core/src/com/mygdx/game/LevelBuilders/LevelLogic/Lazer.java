package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Lazer {
    protected int power;
    protected int speed;
    Texture img;
    public Vector2 laserPos;
    private int width = 6;
    private int height = 30;

    public Rectangle getBounds(){
        return new Rectangle(laserPos.x, laserPos.y, width, height);
    }

    public void render(SpriteBatch batch){
        batch.draw(this.img, this.laserPos.x, this.laserPos.y);
    }

    public abstract void update();
}
