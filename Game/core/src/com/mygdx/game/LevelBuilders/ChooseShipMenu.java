package com.mygdx.game.LevelBuilders;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.LevelBuilders.LevelLogic.BluePlayerShip;
import com.mygdx.game.LevelBuilders.LevelLogic.GreenPlayerShip;
import com.mygdx.game.LevelMenu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Background;

public class ChooseShipMenu implements Screen {
    SpriteBatch batch;
    private final Background background;
    private MyGdxGame game;
    private final Texture blueShipTexture;
    private int blueShipWidth = 80;
    private int blueShipHeight = 55;

    private final Texture greenShipTexture;
    private int greenShipWidth = 80;
    private int greenShipHeight = 55;


    public ChooseShipMenu(Background background, SpriteBatch batch, MyGdxGame game) {
        this.game = game;
        this.batch = batch;
        this.background = background;
        this.blueShipTexture = new Texture("BluePlayerShip.png");
        this.greenShipTexture = new Texture("GreenPlayerShip.png");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        background.update();
        batch.begin();
        background.render(batch);

        if(Gdx.input.getX()>150 && Gdx.input.getX()<150+blueShipWidth &&
                Gdx.input.getY()<250 && Gdx.input.getY()>250-blueShipHeight) {
            batch.draw(blueShipTexture, 150, 250, blueShipWidth, blueShipHeight);
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                this.dispose();
                game.setScreen(new LevelMenu(background, batch, game, new BluePlayerShip()));
            }
        }else{
            batch.draw(blueShipTexture, 153, 250, blueShipWidth, blueShipHeight);
        }

        if(Gdx.input.getX()>150 && Gdx.input.getX()<150+greenShipWidth &&
                Gdx.input.getY()<310 && Gdx.input.getY()>310-greenShipHeight) {
            batch.draw(greenShipTexture, 150, 190, greenShipWidth, greenShipHeight);
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                this.dispose();
                game.setScreen(new LevelMenu(background, batch, game, new GreenPlayerShip()));
            }
        }else{
            batch.draw(greenShipTexture, 153, 190, greenShipWidth, greenShipHeight);
        }
        batch.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
