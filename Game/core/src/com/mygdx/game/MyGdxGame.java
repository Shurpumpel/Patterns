package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;
import java.util.ListIterator;


public class MyGdxGame extends Game {

	SpriteBatch batch;
	MainMenu menu;


	@Override
	public void create () {
		batch = new SpriteBatch();
		menu = new MainMenu(this);
		this.setScreen(menu);
	}

	@Override
	public void render () {
		super.render();
	}


	public void dispose () {
		batch.dispose();
	}



}
