package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.math.Vector2;

public class PlayerShipChooseContext {
    Player playerShip;

    PlayerShipChooseContext(Player player){
        this.playerShip = player;
    }

    public void ChangeShip(){
        playerShip.changeShip(this);
    }

    public void setPlayerShip(Player ship){
        this.playerShip = ship;
    }

    public void setCurrentHp(int hp){
        this.playerShip.HP = hp;
    }

    public void setPosition(Vector2 pos){
        this.playerShip.pos = pos;
    }
}
