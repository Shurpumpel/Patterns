package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class GreenPlayerShip extends Player {

    public GreenPlayerShip() {
        this.setShipTexture();
        this.setSpeedOfShip();
    }

    @Override
    public void setShipTexture() {
        this.img = new Texture("GreenPlayerShip.png");
    }

    @Override
    public void setSpeedOfShip() {
        this.speed = 5;
    }

    @Override
    public void changeShip(PlayerShipChooseContext context) {
        context.setPlayerShip(new BluePlayerShip());
        context.setCurrentHp(this.HP);
        context.setPosition(new Vector2(this.pos.x, this.pos.y));
    }

    @Override
    public Lazer makeShot() {
        return new GreenLaser(new Vector2(pos.x, pos.y));
    }
}
