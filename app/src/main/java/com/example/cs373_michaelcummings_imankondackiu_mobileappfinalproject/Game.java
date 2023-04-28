package com.example.cs373_michaelcummings_imankondackiu_mobileappfinalproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Build;
import android.view.SurfaceView;

import androidx.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class representing an instance of a mobile game
 * Rewritten for Android Studio
 *
 * @author Michael Cummings
 * @version 4.27.23
 */
public class Game extends SurfaceView implements Runnable {
    private Thread gameThread;
    private boolean gameOver;
    public int gameWidth;
    public int gameHeight;//9:16 480p aspect ratio
    public float gameAspectRatioX, gameAspectRatioY;
    private Background gameBackground;
    private Paint gamePaint;
    private ArrayList<MovableGameObject> gameWorldObjects;
    private Player gamePlayerCharacter;
    private int gamePlayerCharacterContinuesRemaining; //Represents number of collisions player has left before gameOver state evaluates true
    private long gamePointsScore;
    private long gamePointsHighScore = 0;
    private int gamePointsCounter;
    private int gameDifficultyLevel;
    private Random gameRandomSeed; //Will hold a random value generated at initialization that will be used to decide the coordinates to place Obstacles

    /**
     * Method to call one of the createMovableGameObject() methods, depending on a random number and gameDifficultyLevel
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public MovableGameObject movableGameObjectObstacleSpawner()
    {
        double gameRandomDouble = gameRandomSeed.nextDouble();
        int gameRandomInt = (int)Math.round(gameRandomDouble * 10) + 1;

        if(gameRandomInt == 1)
        {
            return createMovableGameObjectBonusItemGold();
        }
        if(gameRandomInt + gameDifficultyLevel >= 13 && gameRandomInt + gameDifficultyLevel <= 15)
        {
            return createMovableGameObjectObstacleFast();
        }
        if((gameRandomInt + gameDifficultyLevel == 16))
        {
            return createMovableGameObjectObstacleLarge();
        }
        return createMovableGameObjectObstacle();
    }

    /**
     * Method to instantiate an Obstacle MovableGameObject
     * Intended to make Obstacles appear at a random point along the x-axis from 16 to 448, and at a random point from -32 to -886 on the y-axis to give the player time to react as it moves down the screen and up the y-axis
     *
     * @return Obstacle
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Obstacle createMovableGameObjectObstacle()
    {
        return new Obstacle((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }

    /**
     * Method to instantiate an ObstacleLarge MovableGameObject
     *
     * @return  ObstacleLarge
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ObstacleLarge createMovableGameObjectObstacleLarge()
    {
        return new ObstacleLarge((int)(gameRandomSeed.nextDouble() * (gameWidth - 64) + 32), (int)(gameRandomSeed.nextDouble() * -gameHeight - 64));
    }

    /**
     * Method to instantiate an ObstacleFast MovableGameObject
     *
     * @return  ObstacleFast
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public ObstacleFast createMovableGameObjectObstacleFast()
    {
        return new ObstacleFast((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }

    /**
     * Method to instantiate a BonusItem MovableGameObject
     *
     * @return  BonusItem
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public BonusItem createMovableGameObjectBonusItemGold()
    {
        return new BonusItemGold((int)(gameRandomSeed.nextDouble() * (gameWidth - 48) + 16), (int)(gameRandomSeed.nextDouble() * -gameHeight - 32));
    }

    /**
     * Method to instantiate a Player MovableGameObject
     *
     * @return  Player
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Player createMovableGameObjectPlayer()
    {
        int gamePlayerCharacterStartYCoordinate = gameHeight - 64;
        int gamePlayerCharacterStartXCoordinate = gameWidth / 2;
        return new Player(gamePlayerCharacterStartXCoordinate, gamePlayerCharacterStartYCoordinate);
    }

    /**
     * Method to prepare the initial conditions to run the game
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void gameInitialize()
    {
        gameOver = false;
        gamePlayerCharacter = createMovableGameObjectPlayer(); //Values subject to change once I see how the game looks on a phone screen
        gamePlayerCharacterContinuesRemaining = 2;
        gamePointsScore = 0;
        gamePointsCounter = 0;
        gameDifficultyLevel = 0;
        gameRandomSeed = new Random();
        gameWorldObjects = new ArrayList<>();

        for (int i = 0; i < 10; i++)
        {
            gameWorldObjects.add(movableGameObjectObstacleSpawner());
        }

        run();
    }

    /**
     * Method detailing the actions the game should take every time the frame refreshes, depending on user input and the state of the game
     */
    @Override
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void run() {
        while (!gameOver) {

            gameUpdate();
            gameFrameDraw();
            gameThreadSleep();

        }

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void gameUpdate(){
        ArrayList<MovableGameObject> gameWorldObjectsAlreadyRendered = new ArrayList<>(gameWorldObjects);

        for (MovableGameObject movableGameObject : gameWorldObjectsAlreadyRendered) {
            movableGameObject.translateMovableGameObject(0, (int) movableGameObject.getMovableGameObjectSpeed() * (int) gameAspectRatioY);
            if (movableGameObject.getGameObjectLocation().y - movableGameObject.getGameObjectHeight() > gameHeight) {
                if (!(movableGameObject instanceof BonusItem)) {
                    gamePointsScore += 100;
                    gamePointsCounter += 100;
                }
                if (gamePointsCounter / 5000 > 0) {
                    if (gameDifficultyLevel < 10) {
                        gameDifficultyLevel++;
                    }
                    gamePointsCounter = 0;
                }
                if (gamePointsScore > gamePointsHighScore) {
                    gamePointsHighScore = gamePointsScore;
                }
                gameWorldObjects.remove(movableGameObject);
                gameWorldObjects.add(movableGameObjectObstacleSpawner());
                for (int i = 1; i < gameDifficultyLevel; i++) {
                    if ((int) (gameRandomSeed.nextDouble() * 100) == 1) {
                        gameWorldObjects.add(movableGameObjectObstacleSpawner());
                    }
                }
            } else {
                if (GameObject.collision(gamePlayerCharacter, movableGameObject)) {
                    if (movableGameObject instanceof BonusItemGold) {
                        gamePointsScore += ((BonusItemGold) movableGameObject).getBonusItemPointValue();
                        gamePointsCounter += ((BonusItemGold) movableGameObject).getBonusItemPointValue();
                        if (gamePointsCounter / 5000 > 0) {
                            if (gameDifficultyLevel < 10) {
                                gameDifficultyLevel++;
                            }
                            gamePointsCounter = 0;
                        }
                        if (gamePointsScore > gamePointsHighScore) {
                            gamePointsHighScore = gamePointsScore;
                        }
                        gameWorldObjects.remove(movableGameObject);
                        gameWorldObjects.add(movableGameObjectObstacleSpawner());
                    } else {
                        if (gamePlayerCharacterContinuesRemaining > 0) {
                            gamePlayerCharacterContinuesRemaining--;
                            gamePointsCounter = 0;
                            if (gameDifficultyLevel - 3 >= 0) {
                                gameDifficultyLevel -= 3;
                            } else {
                                gameDifficultyLevel = 0;
                            }
                            gameWorldObjects.remove(movableGameObject);
                        } else {
                            gameOver = true;
                        }
                    }
                }
            }
        }
    }


    public void gameFrameDraw(){
        if(getHolder().getSurface().isValid()){
            Canvas gameCanvas = getHolder().lockCanvas();
            gameCanvas.drawBitmap(gameBackground.background, gameBackground.x, gameBackground.y, gamePaint);

            getHolder().unlockCanvasAndPost(gameCanvas);
        }
    }

    public void gameThreadSleep(){
        try {
            Thread.sleep(1000 / 120); //1000 ms / 120 frames per second = 8.33 ms
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void gameResume(){

        gameThread = new Thread(this);
        gameThread.start();

    }

    public void gamePause(){

        try {
            gameThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Method to draw objects after the game's conditions are initialized using Graphics package
     * Need to rewrite to use Android packages!!!
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void gameGraphicsInitialRender(Canvas gameGraphics)
    {
        Paint gameGraphicsBackgroundColor = new Paint(Color.GRAY);
        Paint gameGraphicsText = new Paint();

        gameGraphics.drawRect(0, 0, gameWidth, gameHeight, gameGraphicsBackgroundColor); //Background

        gameGraphics.drawRect(gamePlayerCharacter.getGameObjectBounds(), gamePlayerCharacter.getGameObjectPaint()); //Player

        for(MovableGameObject movableGameObject: gameWorldObjects)
        {
            gameGraphics.drawRect(movableGameObject.getGameObjectBounds(), movableGameObject.getGameObjectPaint()); //Obstacles and BonusItems
        }

        gameGraphicsText.setTypeface(Typeface.create("Consolas", Typeface.NORMAL));
        gameGraphicsText.setColor(Color.WHITE);
        gameGraphics.drawText(String.valueOf(gamePointsScore), gameWidth - gameGraphicsText.measureText(String.valueOf(gamePointsScore)) - 16, 22, gameGraphicsText);
        gameGraphics.drawText("LIVES: " + gamePlayerCharacterContinuesRemaining, 8, 22, gameGraphicsText);
        gameGraphics.drawText("DIFFICULTY: " + gameDifficultyLevel, 8, 44, gameGraphicsText);

        gameGraphicsText.setColor(Color.GREEN);
        gameGraphics.drawText(("HIGH SCORE: " + gamePointsHighScore), gameWidth - gameGraphicsText.measureText(("HIGH SCORE: " + gamePointsHighScore)) - 16, 44, gameGraphicsText);

        gameGraphicsText.setColor(Color.WHITE);
        gameGraphicsText.setTextSize(11);
        gameGraphics.drawText("Spacebar to start a new game", gameWidth - gameGraphicsText.measureText("Spacebar to start a new game") - 16, 55, gameGraphicsText);
        gameGraphics.drawText("A to move left", gameWidth - gameGraphicsText.measureText("A to move left") - 16, 66, gameGraphicsText);
        gameGraphics.drawText("D to move right", gameWidth - gameGraphicsText.measureText("D to move right") - 16, 77, gameGraphicsText);
        gameGraphics.drawText("Avoid RED!", gameWidth - gameGraphicsText.measureText("Avoid RED!") - 16, 88, gameGraphicsText);
        gameGraphics.drawText("Touch GOLD for points!", gameWidth - gameGraphicsText.measureText("Touch GOLD for points!") - 16, 99, gameGraphicsText);


        if(gameOver)
        {
            gameGraphicsText.setTextSize(88);
            gameGraphics.drawText("GAME", (float)gameWidth / 2 - (float)gameWidth / 4, (float)gameHeight / 2, gameGraphicsText);
            gameGraphics.drawText("OVER", (float)gameWidth / 2 - (float)gameWidth / 4, (float)gameHeight / 2 + 88, gameGraphicsText);
        }
    }

    /**
     * Default constructor for objects of class Game
     * Need to change method calls to reflect change to Android environment
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public Game(Context context, int gameWidth, int gameHeight) {
        super(context);

        this.gameWidth = gameWidth;
        this.gameHeight = gameHeight;
        gameAspectRatioX = 1920f / gameWidth;
        gameAspectRatioY = 1080f / gameHeight; //Using common values of 1920 x 1080 resolution

        gameBackground = new Background(gameWidth, gameHeight, getResources());

        gamePaint = new Paint();

        gameInitialize();
    }

}
