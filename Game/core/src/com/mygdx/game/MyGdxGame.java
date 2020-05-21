package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;
import java.util.ListIterator;


public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Background background;
	Player player;
	static LinkedList<Lazer> playerLasers = new LinkedList<>();
	static LinkedList<Lazer> enemyLasers = new LinkedList<>();
	boolean gameOver = false;
	LinkedList<Ship> enemyShips = new LinkedList<>();
	Texture restartButton;
	static BitmapFont font;
	Texture heartPicture;
	Texture winnerPicture;
	Texture loserPicture;
	int countOfEnemies = 0;


	@Override
	public void create () {
		font = new BitmapFont();
		font.setColor(1,1,1,0.5f);
		batch = new SpriteBatch();
		background = new Background();
		enemyShips.add(new LittleNPC(3, new Vector2(30, 400))); countOfEnemies++;
		enemyShips.add(new BigNPC(3, new Vector2(20, 300))); countOfEnemies++;
		player = Player.getInstance();
		restartButton = new Texture("restartButton.png");
		heartPicture = new Texture("heart.png");
		winnerPicture = new Texture("winner.png");
		loserPicture = new Texture("loser.png");
	}

	@Override
	public void render () {
		update();
		Gdx.gl.glClearColor(1,1,1, 0.5f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		background.render(batch);

		if(!gameOver) {
			batch.draw(heartPicture, 20, 463);
			font.draw(batch, "x"+player.HP, 40, 480);
			for(Ship ship : enemyShips){
				ship.render(batch);
			}
			player.render(batch);
			for(Lazer laser : enemyLasers){
				laser.render(batch);
			}
			for(Lazer laser : playerLasers){
				laser.render(batch);
			}
		}else{
			if(countOfEnemies == 0){
				batch.draw(winnerPicture, 100, 350);
			}else{
				batch.draw(loserPicture, 100,350);
			}
			batch.draw(restartButton, 100, 250);
		}

		batch.end();

	}
	public void update(){
		background.update();
		if(Gdx.input.isKeyPressed(Input.Keys.SPACE) && gameOver) {
			this.gameOver = false;
			restart();
		}

		for(Ship ship: enemyShips){
			ship.update();
		}

		player.update();
		if(player.HP <= 0 || countOfEnemies == 0){
			gameOver = true;
		}

		for(Lazer laser : enemyLasers){
			laser.update();
		}
		for(Lazer laser : playerLasers){
			laser.update();
		}
		detectCollisions();
		removeLasersOutOfScreen();
	}

	private void detectCollisions(){
		//попал ли игрок в нпс
		ListIterator<Lazer> iterator = playerLasers.listIterator();
		while (iterator.hasNext()){
			Lazer laser = iterator.next();
			for(Ship ship : enemyShips){
				if(ship.intersects(laser.getBounds())){
					ship.HP -= laser.power;
					iterator.remove();
				}
			}
		}

		//попал ли нпс в игрока
		iterator = enemyLasers.listIterator();
		while (iterator.hasNext()){
			Lazer laser = iterator.next();
			if(player.intersects(laser.getBounds())){
				player.HP -= laser.power;
				iterator.remove();
			}
		}

		removeKilledEnemies();

	}

	public void removeKilledEnemies(){
		ListIterator<Ship> iterator = enemyShips.listIterator();
		while (iterator.hasNext()){
			Ship ship = iterator.next();
			if(ship.HP <= 0){
				iterator.remove();
				countOfEnemies--;
			}
		}
	}

	public void removeLasersOutOfScreen(){
		ListIterator<Lazer> iterator = enemyLasers.listIterator();
		while (iterator.hasNext()){
			Lazer laser = iterator.next();
			if(laser.laserPos.y < -60)
				iterator.remove();
		}
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	public void restart(){
		enemyShips.clear();
		countOfEnemies = 0;
		enemyShips.add(new LittleNPC(3, new Vector2(30, 400))); countOfEnemies++;
		enemyShips.add(new BigNPC(3, new Vector2(20, 300))); countOfEnemies++;
		player = Player.getInstance();
		player.HP = 10;
	}



}
