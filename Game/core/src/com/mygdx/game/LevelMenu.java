package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.LevelBuilders.LevelBuilder;
import com.mygdx.game.LevelBuilders.LevelLogic.Level;
import com.mygdx.game.LevelBuilders.LevelLogic.Player;
import com.mygdx.game.LevelBuilders.LevelOneBuilder;

public class LevelMenu implements Screen {
    private Background background;
    private SpriteBatch batch;
    private MyGdxGame game;
    private final Texture level1NotPushedButton;
    private final Texture level1PushedButton;
    private LevelBuilder levelBuilder;
    int level1ButtonWidth = 100;
    int level1ButtonHeight = 40;
    private Player typeOfPlayerShip;

    public LevelMenu(Background background, SpriteBatch batch, MyGdxGame game, Player player) {
        this.background = background;
        this.batch = batch;
        this.level1NotPushedButton = new Texture("lvl1_not_pushed.png");
        this.level1PushedButton = new Texture("lvl1_pushed.png");
        this.game = game;
        this.typeOfPlayerShip = player;
    }

    @Override
    public void show() { }

    @Override
    public void render(float delta) {
        background.update();
        batch.begin();
        background.render(batch);

        if(Gdx.input.getX()>150 && Gdx.input.getX()<150+ level1ButtonWidth &&
                Gdx.input.getY()<250 && Gdx.input.getY()>250- level1ButtonHeight) {
            batch.draw(level1PushedButton, 150, 250, level1ButtonWidth, level1ButtonHeight);
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                createLevel(new LevelOneBuilder(), typeOfPlayerShip);
                this.dispose();
                game.setScreen(levelBuilder.getLevel());
            }
        }else{
            batch.draw(level1NotPushedButton, 150, 250, level1ButtonWidth, level1ButtonHeight);

        }
        batch.end();
    }

    private void setBuilder(LevelBuilder levelBuilder){
        this.levelBuilder = levelBuilder;
    }

    private void createLevel(LevelBuilder levelBuilder, Player player){
        setBuilder(levelBuilder);
        levelBuilder.createLevel(batch, game, player);
        levelBuilder.addEnemies();
        levelBuilder.setSpeedOfBack();
        //levelBuilder.createPlayer();
    }
    @Override
    public void resize(int width, int height) { }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() { }
}
