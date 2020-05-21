package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public abstract class NPC extends Ship{
    protected int timeBetweenShots = 50;
    protected int timeSinceLastShot = 0;
    public boolean desroyed = false;

}
