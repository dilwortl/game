import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.utils.Array;

import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;

import com.badlogic.gdx.Screen;

public class CheeseLevel implements Screen
{
  private Stage upperStage;
  private Stage bottomStage;
  private Stage uiStage;
  
  private BaseActor mousey;
  private BaseActor mine;
  private BaseActor mine2;
  private BaseActor mine3;
  private BaseActor mine4;
  private BaseActor mine5;
  private BaseActor mine6;
  private BaseActor mine7;
  private BaseActor mine8;
  private BaseActor mine9;
  private BaseActor mine10;
  private BaseActor mine11;
  private BaseActor mine12;
  private BaseActor ryan1;
  private BaseActor health;
  private BaseActor health2;
  private BaseActor cheese;
  private BaseActor char2;
  private BaseActor floor;
  private BaseActor floor2;
  private BaseActor winText;   
  private boolean win;
  private BaseActor fish;
 
  private int IanHealth = 100;
  private int SharkHealth = 100;
  private int SharkBonus;
  private int IanPoint=0;
  private int SharkPoint=0;
  private int HealthIncrease=0;
  private int HealthIncrease2=0;
  private boolean hit1=false;
  private boolean hit2=false;
  private boolean hit3=false;
  private boolean hit4=false;
  private boolean hit5=false;
  private boolean hit6=false;
  private boolean hit7=false;
  private boolean hit8=false;
  private boolean hit9=false;
  private boolean hit10=false;
  private boolean hit11=false;
  private boolean hit12=false;
  
  
  private float timeElapsed = 100;
  private Label timeLabel;
  private Label timeLabel2;
  private Label healthLabel;
  private Label healthLabel2;
  private float healthElapsed;
  private Label sharkPoint;
  private Label ianPoint;
  private Label playerUp;


  
  // game world dimensions
  final int mapWidth = 800;
  final int mapHeight = 800;
  // window dimensions
  final int viewWidth = 640;
  final int viewHeight = 480;
  
  public Game game;
  public CheeseLevel(Game g)
  {
    game = g;
    create();
  }
  
  public void create() 
  {        
    upperStage = new Stage();
    bottomStage= new Stage();
    uiStage = new Stage();
    timeElapsed = 120;
    
    
    floor = new BaseActor();
    floor.setTexture( new Texture(Gdx.files.internal("assets/water-background.jpg")) );
    floor.setPosition( 0, 0 );
    upperStage.addActor( floor );
    
    floor2 = new BaseActor();
    floor2.setTexture( new Texture(Gdx.files.internal("assets/water-background.jpg")) );
    floor2.setPosition( 0, 0 );
    bottomStage.addActor( floor2 );
    
    
    health = new BaseActor();
    health.setTexture( new Texture(Gdx.files.internal("assets/health22.jpg")) );
    health.setPosition( 0, 0 );
    bottomStage.addActor( health );
    upperStage.addActor( health );
    
    health2 = new BaseActor();
    health2.setTexture( new Texture(Gdx.files.internal("assets/health22.jpg")) );
    health2.setPosition( 0, 0 );
    bottomStage.addActor( health2 );
    
    cheese = new BaseActor();
    cheese.setTexture( new Texture(Gdx.files.internal("assets/trophy2.png")) );
    cheese.setPosition( 400, 300 );
    cheese.setOrigin( cheese.getWidth()/2, cheese.getHeight()/2 );
    upperStage.addActor( cheese );
    
    
    fish = new BaseActor();
    fish.setTexture( new Texture(Gdx.files.internal("assets/fish3.png")) );
    fish.setPosition( 400, 300 );
    fish.setOrigin( fish.getWidth()/2, fish.getHeight()/2 );
    bottomStage.addActor( fish );
    
 
    
    mine = new BaseActor();
    mine.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine.setPosition( 300, 300 );
    mine.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine );
    
    mine2 = new BaseActor();
    mine2.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine2.setPosition( 400, 400 );
    mine2.setOrigin( mine2.getWidth()/2, mine2.getHeight()/2 );
    bottomStage.addActor( mine2 );
    
    mine3 = new BaseActor();
    mine3.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine3.setPosition( 500, 500 );
    mine3.setOrigin( mine3.getWidth()/2, mine3.getHeight()/2 );
    bottomStage.addActor( mine3 );
    
    mine4 = new BaseActor();
    mine4.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine4.setPosition( 600, 600 );
    mine4.setOrigin( mine4.getWidth()/2, mine4.getHeight()/2 );
    bottomStage.addActor( mine4 );
    
    mine5 = new BaseActor();
    mine5.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine5.setPosition( 700, 700 );
    mine5.setOrigin( mine5.getWidth()/2, mine5.getHeight()/2 );
    bottomStage.addActor( mine5 );
    
    mine6 = new BaseActor();
    mine6.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine6.setPosition( 100, 200 );
    mine6.setOrigin( mine6.getWidth()/2, mine6.getHeight()/2 );
    bottomStage.addActor( mine6 );
    
    mine7 = new BaseActor();
    mine7.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine7.setPosition( 200, 100 );
    mine7.setOrigin( mine7.getWidth()/2, mine7.getHeight()/2 );
    bottomStage.addActor( mine7 );
    
    mine8 = new BaseActor();
    mine8.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine8.setPosition( 50, 50 );
    mine8.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine8 );
    
    mine9 = new BaseActor();
    mine9.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine9.setPosition( 400,100  );
    mine9.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine9 );
    
    mine10 = new BaseActor();
    mine10.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine10.setPosition( 500, 200 );
    mine10.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine10 );
    
    mine11 = new BaseActor();
    mine11.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine11.setPosition( 600, 300 );
    mine11.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine11 );
    
    mine12 = new BaseActor();
    mine12.setTexture( new Texture(Gdx.files.internal("assets/mine2.png")) );
    mine12.setPosition( 700, 400 );
    mine12.setOrigin( mine.getWidth()/2, mine.getHeight()/2 );
    bottomStage.addActor( mine12 );
    
    
    ryan1 = new BaseActor();
    ryan1.setTexture( new Texture(Gdx.files.internal("assets/ryan2.png")) );
    ryan1.setPosition( 100,200 );
    ryan1.setOrigin( ryan1.getWidth(), ryan1.getHeight() );
    upperStage.addActor( ryan1 );
    

    
    char2 = new BaseActor();
    char2.setTexture( new Texture(Gdx.files.internal("assets/left_shark.png")) );
    char2.setPosition( 200, 300 );
    char2.setOrigin( char2.getWidth()/2, char2.getHeight()/2 );
    upperStage.addActor( char2 );
    bottomStage.addActor(char2);
    
    
    mousey = new BaseActor();
    mousey.setTexture( new Texture(Gdx.files.internal("assets/ian2.png")) );
    mousey.setPosition( 0, 0 );
    mousey.setOrigin( cheese.getWidth()/2, cheese.getHeight()/2 );
    upperStage.addActor( mousey );
    
    winText = new BaseActor();
    winText.setTexture( new Texture(Gdx.files.internal("assets/you-win.png")) );
    winText.setPosition( 170, 60 );
    winText.setVisible( false );
    uiStage.addActor( winText );
    
    BitmapFont font = new BitmapFont();
    
    BitmapFont font2=new BitmapFont();
    String text2="Health: 100";
    LabelStyle style2=new LabelStyle(font2,Color.GREEN);
    healthLabel=new Label(text2,style2);
    healthLabel.setFontScale(2);
    healthLabel.setPosition(500,400/2-10);
    uiStage.addActor(healthLabel);
    
    BitmapFont font3 = new BitmapFont();
    String text3 = "Time: 0";
    LabelStyle style3 = new LabelStyle( font, Color.BLACK );
    timeLabel2 = new Label( text3, style3 );
    timeLabel2.setFontScale(2);
    timeLabel2.setPosition(0,460); // sets bottom left (baseline) corner?
    uiStage.addActor( timeLabel2 );
    
    BitmapFont font4=new BitmapFont();
    String text4="Health: 100";
    LabelStyle style4=new LabelStyle(font2,Color.GREEN);
    healthLabel2=new Label(text4,style4);
    healthLabel2.setFontScale(2);
    healthLabel2.setPosition(500,440);
    uiStage.addActor(healthLabel2);
    
    BitmapFont font5=new BitmapFont();
    String text5="Point: 0";
    LabelStyle style5=new LabelStyle(font5,Color.NAVY);
    ianPoint=new Label(text5,style5);
    ianPoint.setFontScale(2);
    ianPoint.setPosition(500,410);
    uiStage.addActor(ianPoint);
    
    BitmapFont font6=new BitmapFont();
    String text6="Point: 0";
    LabelStyle style6=new LabelStyle(font6,Color.RED);
    sharkPoint=new Label(text6,style6);
    sharkPoint.setFontScale(2);
    sharkPoint.setPosition(500,360/2-20);
    uiStage.addActor(sharkPoint);
    
    
    BitmapFont font7=new BitmapFont();
    String text7="Shark is Winning";
    LabelStyle style7=new LabelStyle(font7,Color.PURPLE);
    playerUp=new Label(text7,style7);
    playerUp.setFontScale(2);
    playerUp.setPosition(420,10/2);
    uiStage.addActor(playerUp);
    
    win = false;
  }
  
  public void render(float dt) 
  {   
    Gdx.gl.glClearColor(1, 1, 50/255f, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
    
    upperStage.act(dt);
    bottomStage.act(dt);
    
    // process input
    mousey.velocityX = 0;
    mousey.velocityY = 0;
    char2.velocityX=0;
    char2.velocityY=0;
    
    if (Gdx.input.isKeyPressed(Keys.LEFT)) 
      mousey.velocityX -= 100;
    if (Gdx.input.isKeyPressed(Keys.RIGHT))
      mousey.velocityX += 100;;
    if (Gdx.input.isKeyPressed(Keys.UP)) 
      mousey.velocityY += 100;
    if (Gdx.input.isKeyPressed(Keys.DOWN)) 
      mousey.velocityY -= 100;
    
    if (Gdx.input.isKeyPressed(Keys.A)) 
      char2.velocityX -= 100;
    if (Gdx.input.isKeyPressed(Keys.D))
      char2.velocityX += 100;
    if (Gdx.input.isKeyPressed(Keys.W)) 
      char2.velocityY += 100;
    if (Gdx.input.isKeyPressed(Keys.S)) 
      char2.velocityY -= 100;
    
    if (Gdx.input.isKeyPressed(Keys.M)) 
      game.setScreen( new CheeseMenu(game) );
   

    // update
    upperStage.act(dt);
    bottomStage.act(dt);
    uiStage.act(dt);
    
    // bound mousey to the rectangle defined by mapWidth, mapHeight
    mousey.setX( MathUtils.clamp( mousey.getX(), 0,  mapWidth - mousey.getWidth() ));
    mousey.setY( MathUtils.clamp( mousey.getY(), 0,  (mapHeight - mousey.getHeight()) ));
    
    char2.setX( MathUtils.clamp( char2.getX(), 0,  mapWidth - char2.getWidth() ));
    char2.setY( MathUtils.clamp( char2.getY(), 0,  mapHeight - char2.getHeight() ));
    
    // check win condition: mousey must be overlapping cheese
    Rectangle cheeseRectangle = cheese.getBoundingRectangle();
    Rectangle mouseyRectangle = mousey.getBoundingRectangle();
    Rectangle fishRectangle = fish.getBoundingRectangle();
    Rectangle char2Rectangle = char2.getBoundingRectangle();
    Rectangle healthRectangle = health.getBoundingRectangle();
    Rectangle health2Rectangle = health2.getBoundingRectangle();
    Rectangle mineRectangle = mine.getBoundingRectangle();
    Rectangle mine2Rectangle = mine2.getBoundingRectangle();
    Rectangle mine3Rectangle = mine3.getBoundingRectangle();
    Rectangle mine4Rectangle = mine4.getBoundingRectangle();
    Rectangle mine5Rectangle = mine5.getBoundingRectangle();
    Rectangle mine6Rectangle = mine6.getBoundingRectangle();
    Rectangle mine7Rectangle = mine7.getBoundingRectangle();
    Rectangle mine8Rectangle = mine8.getBoundingRectangle();
    Rectangle mine9Rectangle = mine9.getBoundingRectangle();
    Rectangle mine10Rectangle = mine10.getBoundingRectangle();
    Rectangle mine11Rectangle = mine11.getBoundingRectangle();
    Rectangle mine12Rectangle = mine12.getBoundingRectangle();
    Rectangle ryan1Rectangle = ryan1.getBoundingRectangle();
    
    
  
    if ( char2Rectangle.contains( fishRectangle ) )
    {
      fish.setPosition((float)Math.random()*500, (float)Math.random()*500);
      SharkPoint+=2;
    }
     if ( healthRectangle.contains( mouseyRectangle ) )
    {
      health.setPosition((float)Math.random()*500,(float)Math.random()*500);
     
      HealthIncrease2+=5;
    }
      if ( health2Rectangle.contains( char2Rectangle ) )
    {
      health2.setPosition((float)Math.random()*500,(float)Math.random()*500);
     
      HealthIncrease+=5;
    }

    if (!hit1 &&  mineRectangle.contains( char2Rectangle ) )
    {
      hit1 = true;
      mine.setPosition(301,301);
      Action mineDisappear = Actions.parallel(
                                              Actions.rotateBy(360, 1),
                                              Actions.fadeOut(1)
                                             );
      mine.addAction(mineDisappear);
      SharkPoint-=2;
    }
    if (!hit2 && mine2Rectangle.contains( char2Rectangle ) )
    {
      hit2=true;
      mine2.setPosition(401,401);
      Action mine2Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine2.addAction(mine2Disappear);
      SharkPoint-=2;
    }
    if (!hit2 && mine2Rectangle.contains( char2Rectangle ) )
    {
      hit2=true;
      mine2.setPosition(401,401);
      Action mine2Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine2.addAction(mine2Disappear);
      SharkPoint-=2;
    }
    if (!hit3 && mine3Rectangle.contains( char2Rectangle ) )
    {
      hit3=true;
      mine3.setPosition(501,501);
      Action mine3Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine3.addAction(mine3Disappear);
      SharkPoint-=2;
    }
    if (!hit4 && mine4Rectangle.contains( char2Rectangle ) )
    {
      hit4=true;
      mine4.setPosition(601,601);
      Action mine4Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine4.addAction(mine4Disappear);
      SharkPoint-=2;
    }
    if (!hit5 && mine5Rectangle.contains( char2Rectangle ) )
    {
      hit5=true;
      mine5.setPosition(701,701);
      Action mine5Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine5.addAction(mine5Disappear);
      SharkPoint-=2;
    }
    
    
    if (!hit6 && mine6Rectangle.contains( char2Rectangle ) )
    {
      hit6=true;
      mine6.setPosition(101,201);
      Action mine6Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine5.addAction(mine6Disappear);
      SharkPoint-=2;
    }
    if (!hit7 && mine7Rectangle.contains( char2Rectangle ) )
    {
      hit7=true;
      mine7.setPosition(201,101);
      Action mine7Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine7.addAction(mine7Disappear);
      SharkPoint-=2;
    }
    if (!hit8 && mine8Rectangle.contains( char2Rectangle ) )
    {
      hit8=true;
      mine8.setPosition(51,51);
      Action mine8Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine8.addAction(mine8Disappear);
      SharkPoint-=2;
    }
    
    if (!hit8 && mine8Rectangle.contains( char2Rectangle ) )
    {
      hit8=true;
      mine8.setPosition(51,51);
      Action mine8Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine8.addAction(mine8Disappear);
      SharkPoint-=2;
    }
    
    if (!hit9 && mine9Rectangle.contains( char2Rectangle ) )
    {
      hit9=true;
      mine9.setPosition(401,101);
      Action mine9Disappear = Actions.parallel(
                                               Actions.rotateBy(360, 1),
                                               Actions.fadeOut(1)
                                              );
      mine9.addAction(mine9Disappear);
      SharkPoint-=2;
    }
    
    if (!hit10 && mine10Rectangle.contains( char2Rectangle ) )
    {
      hit10=true;
      mine10.setPosition(501,201);
      Action mine10Disappear = Actions.parallel(
                                                Actions.rotateBy(360, 1),
                                                Actions.fadeOut(1)
                                               );
      mine10.addAction(mine10Disappear);
      SharkPoint-=2;
    }
    
    if (!hit11 && mine8Rectangle.contains( char2Rectangle ) )
    {
      hit11=true;
      mine11.setPosition(601,301);
      Action mine11Disappear = Actions.parallel(
                                                Actions.rotateBy(360, 1),
                                                Actions.fadeOut(1)
                                               );
      mine11.addAction(mine11Disappear);
      SharkPoint-=2;
    }
    
    
    if (!hit12 && mine12Rectangle.contains( char2Rectangle ) )
    {
      hit12=true;
      mine12.setPosition(701,401);
      Action mine12Disappear = Actions.parallel(
                                                Actions.rotateBy(360, 1),
                                                Actions.fadeOut(1)
                                               );
      mine12.addAction(mine12Disappear);
      SharkPoint-=2;
    }
    
    
    if ( mouseyRectangle.contains( cheeseRectangle ) )
    {
      cheese.setPosition((float)Math.random()*500,(float) Math.random()*500);
      IanPoint+=2;
    }
    
    if (ryan1Rectangle.contains( mouseyRectangle ) )
    {
      ryan1.setPosition((float)Math.random()*500,(float) Math.random()*500);
      IanPoint-=2;
    }
    if (!win)
    {
      timeElapsed -= dt;
      String h = "Health: "+((int)timeElapsed+HealthIncrease2);
      String h2 = "Health: "+((int) timeElapsed+HealthIncrease);
      
      
      timeLabel2.setText( "Time: " + (int)timeElapsed );
      healthLabel.setText(h);
      healthLabel2.setText(h2);
      sharkPoint.setText("Point: "+IanPoint);
      ianPoint.setText("Point: "+SharkPoint);
      
      if(SharkPoint>IanPoint)
        playerUp.setText("Shark is Winning");
      
      if(IanPoint>SharkPoint)
        playerUp.setText("Ian is Winning");
      
      if(IanPoint==SharkPoint)
        playerUp.setText("Tied");
      if(SharkPoint==100&&SharkPoint>IanPoint&&SharkHealth!=0)
        game.setScreen( new sharkWinScreen(game) );
      if(IanPoint==100&&IanPoint>SharkPoint&&IanHealth!=0)
        game.setScreen( new MouseWinScreen(game) );
      if((int)timeElapsed == 0&&(IanPoint==SharkPoint))
        game.setScreen( new DrawScreen(game) );
      if((int)timeElapsed == 0&&(IanPoint>SharkPoint))
        game.setScreen( new MouseWinScreen(game) );
      if((int)timeElapsed == 0&&(IanPoint<SharkPoint))
        game.setScreen( new sharkWinScreen(game) );
      if(SharkHealth==0&&IanHealth>0)
        game.setScreen( new MouseWinScreen(game) );
      if(IanHealth==0&&SharkHealth>0)
        game.setScreen( new MouseWinScreen(game) );
    }
    
   
    // draw graphics
    Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    
    // camera adjustment
    Camera cam = upperStage.getCamera();
    
    // center camera on player
    cam.position.set( mousey.getX() + mousey.getOriginX(), 
                     mousey.getY() + mousey.getOriginY(), 0 );
    
    
    // bound camera to layout
    cam.position.x = MathUtils.clamp(cam.position.x, viewWidth/2,  mapWidth - viewWidth/2);
    cam.position.y = MathUtils.clamp(cam.position.y, viewHeight/2, mapHeight - viewHeight/2);
    cam.update();
    
    
    
    
    // camera adjustment
    Camera cam2 = bottomStage.getCamera();
    
    // center camera on player
    cam2.position.set( char2.getX() + char2.getOriginX(), 
                      char2.getY() + char2.getOriginY(), 0 );
    
    
    // bound camera to layout
    cam2.position.x = MathUtils.clamp(cam2.position.x, viewWidth/2,  mapWidth - viewWidth/2);
    cam2.position.y = MathUtils.clamp(cam2.position.y, viewHeight/2, mapHeight - viewHeight/2);
    cam2.update();
    
    
    
    Gdx.gl.glViewport(0,Gdx.graphics.getHeight()/2,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);      
    bottomStage.draw();  
    
    Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight()/2);    
    upperStage.draw();  
    
    Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());    
    uiStage.draw();
  }
  
  public void resize(int width, int height) {  }
  
  public void pause()   {  }
  
  public void resume()  {  }
  
  public void dispose() { 
    upperStage.dispose();
    bottomStage.dispose();
  }
  
  public void show()    {  }
  
  public void hide()    { 
    dispose();
  }
}