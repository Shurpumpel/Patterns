package com.mygdx.game.LevelBuilders.LevelLogic;

public abstract class NPC extends Ship{
    protected int timeBetweenShots = 100;
    protected int timeSinceLastShot = 0;
    public boolean desroyed = false;

}
