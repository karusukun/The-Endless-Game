package com.mygdx.EndlessGame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.*;

public class appMain extends ApplicationAdapter {
	private SpriteBatch batch;
	private BitmapFont font;
        private Sprite miSprite;
        private int gameHeight;
	
	@Override //codigo que se ejecutara al arrancar la aplicacion
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
                gameHeight = Gdx.graphics.getHeight();
                miSprite = new Sprite(new Texture("badlogic.jpg"));
                
	}

	@Override
        //render se llama cada vez que necesitamos refrescar la pantalla es como un emtodo paint.
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 0.5f); // Metodo par aborrar la pantalla
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);//Metodos para borrar la pantalla
		//Gdx.etc es el punto de acceso para accesar las librerias de gdx
                //para dibujar las imagenes en pantalla se necesitan los metodos begin y end the batch. y estar entre ambos
                batch.begin();
		font.draw(batch, "hola mundo", 50, gameHeight - 10);
                batch.draw(miSprite,50,50);
		batch.end();
	}
}
