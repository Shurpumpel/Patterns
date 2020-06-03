package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class BluePlayerShip extends Player{
    public BluePlayerShip() {
        this.setShipTexture();
        this.setSpeedOfShip();
    }

    @Override
    public void setShipTexture() {
        this.img = new Texture("BluePlayerShip.png");
    }

    @Override
    public void setSpeedOfShip() {
        this.speed = 1;
    }

    @Override
    public void changeShip(PlayerShipChooseContext context) {
        context.setPlayerShip(new GreenPlayerShip());
        context.setCurrentHp(this.HP);
        context.setPosition(new Vector2(this.pos.x, this.pos.y));
    }

    @Override
    public Lazer makeShot() {
        return new BlueLaser(new Vector2(pos.x, pos.y));
    }


}
