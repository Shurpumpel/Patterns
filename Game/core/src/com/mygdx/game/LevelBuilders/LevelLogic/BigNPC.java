package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class BigNPC extends NPC implements Shooter{


    private boolean moveLeft;

    public BigNPC(int hp, Vector2 pos){
        this.img = new Texture("npc1.png");
        this.HP = hp;
        this.pos = pos;
        this.moveLeft = true;
        this.speed = 1;
        this.width = 56;
        this.height = 51;
    }


    public void render(SpriteBatch batch){
        batch.draw(img, pos.x, pos.y);
    }
    public void update(){
        pos.y-=speed;
        if(pos.y<-50){
            pos.y = 550;
        }
        if(pos.x == 0){
            moveLeft = false;
        }
        if(pos.x == 350){
            moveLeft = true;
        }
        if(moveLeft){
            pos.x -= speed;
        }else{
            pos.x += speed;
        }

        if((timeSinceLastShot - timeBetweenShots >= 0)&& pos.y<=400){
            Level.enemyLasers.add(makeShot());
            timeSinceLastShot = 0;
        }else {
            timeSinceLastShot += 1;
        }

        if(HP <= 0){
            desroyed = true;
        }
    }


    @Override
    public Lazer makeShot() {
        return new RedLaser(new Vector2(pos.x, pos.y));
    }
}
