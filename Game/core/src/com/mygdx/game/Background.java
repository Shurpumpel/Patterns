package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Background {

    class BGPicture{
        private Texture img;
        private Vector2 position;


        public BGPicture(Vector2 position) {
            this.img = new Texture("fon.jpg");
            this.position = position;
        }

    }

    private int speed;
    private BGPicture[] bgPictures;

    public Background(){
        speed = 5;
        bgPictures = new BGPicture[2];
        bgPictures[0] = new BGPicture(new Vector2(0,0));
        bgPictures[1] = new BGPicture(new Vector2(0,500));
    }

    public void render(SpriteBatch batch){
        for (int i = 0; i < bgPictures.length; i++) {
            batch.draw(bgPictures[i].img, bgPictures[i].position.x,bgPictures[i].position.y);
        }
    }

    public void update(){
        for (int i = 0; i < bgPictures.length; i++) {
            bgPictures[i].position.y-=speed;
        }

        if(bgPictures[0].position.y < -500){
            bgPictures[0].position.y = 0;
            bgPictures[1].position.y = 500;
        }
    }
}
