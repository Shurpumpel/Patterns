package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Player extends Ship implements Shooter{
    protected int speed;


    public Player(){
        pos = new Vector2(150, 50);
        HP = 10;
        width = 40;
        height = 45;
    }


    public void render(SpriteBatch batch){
        batch.draw(img, pos.x, pos.y);
    }

    public void update(){
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && pos.x > speed){
            pos.x -= speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && pos.x + speed < 400){
            pos.x += speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.UP) && pos.y + speed < 500){
            pos.y += speed;
        }

        if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && pos.y > speed){
            pos.y -= speed;
        }
        
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            Level.playerLasers.add(makeShot());
        }

    }

    public abstract void setShipTexture();
    public abstract void setSpeedOfShip();
    public abstract void changeShip(PlayerShipChooseContext context);

    public abstract Lazer makeShot();
}