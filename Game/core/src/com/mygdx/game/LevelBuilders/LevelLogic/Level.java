package com.mygdx.game.LevelBuilders.LevelLogic;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.MainMenu;
import com.mygdx.game.MyGdxGame;
import com.mygdx.game.Background;

import java.util.LinkedList;
import java.util.ListIterator;

public class Level implements Screen {

    SpriteBatch batch;
    Background background;
    static LinkedList<Lazer> playerLasers = new LinkedList<>();
    static LinkedList<Lazer> enemyLasers = new LinkedList<>();
    boolean gameOver = false;
    LinkedList<Ship> enemyShips;
    Texture restartButtonNotPushed;
    Texture restartButtonPushed;
    int restartButtonWidth;
    int restartButtonHeight;
    Vector2 restartButtonPos = new Vector2(100, 250);
    static BitmapFont font;
    Texture heartPicture;
    Texture winnerPicture;
    Texture loserPicture;
    int countOfEnemies;
    MyGdxGame game;
    PlayerShipChooseContext shipChooseContext;

    public Level(SpriteBatch batch, MyGdxGame game, Player player) {
        this.gameOver = false;
        this.enemyShips = new LinkedList<>();
        this.restartButtonNotPushed = new Texture("Restart_not_pushed.png");
        this.restartButtonPushed = new Texture("Restart_pushed.png");
        this.restartButtonHeight = 55;
        this.restartButtonWidth = 145;
        this.heartPicture = new Texture("heart.png");
        this.winnerPicture =  new Texture("you_win.png");
        this.loserPicture = new Texture("you_lose.png");
        this.countOfEnemies = enemyShips.size();
        this.batch = batch;
        this.background = new Background(1);
        this.game = game;
        font = new BitmapFont();
        this.shipChooseContext = new PlayerShipChooseContext(player);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        update();
        background.render(batch);

        if(!gameOver) {
            batch.draw(heartPicture, 20, 463);
            font.draw(batch, "x"+shipChooseContext.playerShip.HP, 40, 480);
            for(Ship ship : enemyShips){
                ship.render(batch);
            }
            shipChooseContext.playerShip.render(batch);
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
            if (Gdx.input.getX() > restartButtonPos.x && Gdx.input.getX() < restartButtonPos.x + restartButtonWidth &&
                    Gdx.input.getY() < restartButtonPos.y && Gdx.input.getY() > restartButtonPos.y - restartButtonHeight) {
                batch.draw(restartButtonPushed, restartButtonPos.x, restartButtonPos.y);
                if (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT)) ;
                {
                    this.gameOver = false;
                    restart();
                }
            }else{
                batch.draw(restartButtonNotPushed, restartButtonPos.x, restartButtonPos.y);
            }
       }

        batch.end();
    }

    public void update(){
        background.update();
        countOfEnemies = enemyShips.size();

        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            this.shipChooseContext.ChangeShip();
        }

        for(Ship ship: enemyShips){
            ship.update();
        }

         shipChooseContext.playerShip.update();
        if(shipChooseContext.playerShip.HP <= 0 || countOfEnemies == 0){
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
                    try {
                        iterator.remove();
                    }catch (IllegalStateException e){
                        continue;
                    }
                }
            }
        }

        //попал ли нпс в игрока
        iterator = enemyLasers.listIterator();
        while (iterator.hasNext()){
            Lazer laser = iterator.next();
            if(shipChooseContext.playerShip.intersects(laser.getBounds())){
                shipChooseContext.playerShip.HP -= laser.power;
                try{
                    iterator.remove();
                }catch (IllegalStateException e){
                    continue;
                }
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

    public void addEnemy(NPC enemy){
        enemyShips.add(enemy);
    }

    public void restart(){
        this.dispose();
        game.setScreen(new MainMenu(game));
    }


    public void setSpeedOfBack(int speed){
        background.setSpeed(speed);
    }
    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() { }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
