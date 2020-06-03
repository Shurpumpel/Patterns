package com.mygdx.game.LevelBuilders;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.LevelBuilders.LevelLogic.Level;
import com.mygdx.game.LevelBuilders.LevelLogic.LittleNPC;
import com.mygdx.game.LevelBuilders.LevelLogic.Player;
import com.mygdx.game.MyGdxGame;

public abstract class LevelBuilder {
    Level level;
    public void createLevel(SpriteBatch batch, MyGdxGame game, Player player){
        level = new Level(batch, game, player);
    }

    public abstract void setSpeedOfBack();
    public abstract void addEnemies();
    
    public Level getLevel(){
        return level;
    }

}
