package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class LittleNPC extends NPC implements Shooter{

    public LittleNPC(int hp, Vector2 pos){
        this.img = new Texture("npc2.png");
        this.HP = hp;
        this.pos = pos;
        this.timeSinceLastShot = 20;
        this.speed = 2;
        this.width = 59;
        this.height = 60;
    }



    public void render(SpriteBatch batch){
        batch.draw(img, pos.x, pos.y);
    }

    public void update(){
        pos.y -= speed;
        if(pos.y<-50){
            pos.y = 550;
        }

        if((timeSinceLastShot - timeBetweenShots >= 0) && pos.y <=400){
            Level.enemyLasers.add(makeShot());
            timeSinceLastShot = 0;
        }else {
            timeSinceLastShot += 1;
        }

    }

    @Override
    public Lazer makeShot() {
        return new OrangeLaser(new Vector2(pos.x, pos.y));
    }

}
