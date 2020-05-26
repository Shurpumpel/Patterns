package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Player extends Ship implements Shooter{
    private static Player instance;

    private int speed = 5;


    private Player(){
        pos = new Vector2(150, 50);
        img = new Texture("Player.png");
        HP = 100;
        width = 40;
        height = 45;
    }

    public static Player getInstance() {
        if(instance==null){
            instance = new Player();
        }
        return instance;
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

    @Override
    public Lazer makeShot() {
        return new BlueLaser(new Vector2(pos.x, pos.y));
    }
}
