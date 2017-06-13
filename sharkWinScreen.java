import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.Screen;

public class sharkWinScreen implements Screen
{
    private Stage uiStage;
    private Game game;

    public sharkWinScreen(Game g)
    {
        game = g;
        create();
    }

    public void create() 
    {        
        uiStage  = new Stage();

        BaseActor background = new BaseActor();
        background.setTexture( new Texture(Gdx.files.internal("assets/sharkWin.png")) );
        uiStage.addActor( background );


       
    }

    public void render(float dt) 
    {   
        // process input
        if (Gdx.input.isKeyPressed(Keys.M)) 
            game.setScreen( new CheeseMenu(game) );

        // update
        uiStage.act(dt);

        // draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        
         Gdx.gl.glViewport(0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
        uiStage.draw();
    }

    public void resize(int width, int height) {  }

    public void pause()   {  }

    public void resume()  {  }

    public void dispose() {  }

    public void show()    {  }

    public void hide()    {  }
}