package com.mygdx.game.LevelBuilders;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.LevelBuilders.LevelLogic.BigNPC;
import com.mygdx.game.LevelBuilders.LevelLogic.Level;

public class LevelTwoBuilder extends LevelBuilder{

    @Override
    public void setSpeedOfBack() {
        level.setSpeedOfBack(7);
    }

    @Override
    public void addEnemies() {
        for (int i = 0; i < 3; i++) {
            level.addEnemy(new BigNPC(5, new Vector2((i+1)*50, (i+1)*100+600)));
        }
    }
}
