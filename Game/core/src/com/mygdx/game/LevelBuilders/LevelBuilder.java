package com.mygdx.game.LevelBuilders;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.LevelBuilders.LevelLogic.Level;
import com.mygdx.game.LevelBuilders.LevelLogic.LittleNPC;

public abstract class LevelBuilder {
    Level level;
    public void createLevel(SpriteBatch batch){
        level = new Level(batch);
        level.addEnemy(new LittleNPC(1, new Vector2(100, 800)));
    }
    
    public abstract Level createPlayer();
    public abstract void setSpeedOfBack();
    public abstract void addEnemies();
    
    public Level getLevel(){
        return level;
    }

}
