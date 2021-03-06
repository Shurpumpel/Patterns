package com.mygdx.game.LevelBuilders;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.LevelBuilders.LevelLogic.BigNPC;
import com.mygdx.game.LevelBuilders.LevelLogic.Level;
import com.mygdx.game.LevelBuilders.LevelLogic.LittleNPC;
import com.mygdx.game.LevelBuilders.LevelLogic.Player;

public class LevelOneBuilder extends LevelBuilder {

    @Override
    public void setSpeedOfBack() {
        level.setSpeedOfBack(4);
    }

    @Override
    public void addEnemies() {
        for (int i = 0; i < 3; i++) {
            level.addEnemy(new LittleNPC(3, new Vector2((i+1)*50, (i+1)*100+600)));
        }
    }
    
}
