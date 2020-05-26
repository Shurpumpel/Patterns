package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public abstract class Ship {
    protected Texture img;
    public Vector2 pos;
    public int HP;
    protected int speed;
    protected int width;
    protected int height;

    public abstract void render(SpriteBatch batch);
    public abstract void update();

    public Rectangle getBounds(){
        return new Rectangle(pos.x,pos.y, width, height);
    }

    public boolean intersects(Rectangle otherRectangle){
        Rectangle thisRectangle = new Rectangle(pos.x, pos.y, width, height);
        return thisRectangle.overlaps(otherRectangle);
    }
}
