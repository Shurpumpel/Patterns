package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainMenu implements Screen {
    SpriteBatch batch;
    private Texture playButton;
    private Texture playButtonPushed;
    private int playButtonWidth = 90;
    private int playButtonHeight = 50;
    private MyGdxGame game;

    private Background background;

    public MainMenu(MyGdxGame game) {
        batch = new SpriteBatch();
        this.background = new Background(3);
        this.playButton = new Texture("play_but.png");
        this.playButtonPushed = new Texture("play_but_pushed.png");
        this.game = game;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        background.update();
        batch.begin();
        background.render(batch);
        if(Gdx.input.getX()>150 && Gdx.input.getX()<150+playButtonWidth &&
                Gdx.input.getY()<250 && Gdx.input.getY()>250-playButtonHeight) {
            batch.draw(playButtonPushed, 150, 250, playButtonWidth, playButtonHeight);
            if(Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)){
                this.dispose();
                game.setScreen(new LevelMenu(background, batch, game));
            }

        }else{
            batch.draw(playButton, 150, 250, playButtonWidth, playButtonHeight);
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
