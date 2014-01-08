package ma.bricbreacker.game;

import ma.bricbreacker.model.Image;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class BarreBalle implements ApplicationListener {
	
	SpriteBatch spriteBatch; // #6

	CasseBrique casseBrique;

	private float margeBarre = 200;
	private int margeBrique = 150 ;
	private int nbrBrique = 15;
	private float initialSpeed = 8;

	private BitmapFont font;
	private CharSequence str = "Hello World!";
    
	public BarreBalle(float margeBarre, int margeBrique, int nbrBrique, float initialSpeed) {
		this.margeBarre = margeBarre;
		this.margeBrique = margeBrique;
		this.nbrBrique = nbrBrique;
		this.initialSpeed = initialSpeed;
	}
	
	@Override
	public void create() {
		Gdx.input
				.setInputProcessor(new GestureDetector(new MyGestureListener()));

		spriteBatch = new SpriteBatch(); // #12
		
		casseBrique = new CasseBrique(Gdx.audio.newSound(Gdx.files.internal("data/gameover.mp3")), Gdx.audio.newSound(Gdx.files.internal("data/clash.mp3")), Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), margeBarre, margeBrique, nbrBrique, initialSpeed);
		
        font = new BitmapFont();
        font.setScale(2f);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		spriteBatch.begin();
		
		casseBrique.renderGame();

		for (Sound sound : casseBrique.getListSound()) {
			sound.play();
		}
		
		for (Image image : casseBrique.getListImage()) {
			spriteBatch.draw(image.getTexture(), image.getX(), image.getY());
		}

        font.draw(spriteBatch, "Breaked brick " + casseBrique.getBriqueBreaked(), 10, 50);
        font.draw(spriteBatch, "Hit on walls " + casseBrique.getHitOnWalls(), 10, 100);

		spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	class MyGestureListener implements GestureListener {

		@Override
		public boolean fling(float arg0, float arg1, int arg2) {
			return false;
		}

		@Override
		public boolean longPress(float arg0, float arg1) {
			return false;
		}

		@Override
		public boolean pan(float arg0, float arg1, float arg2, float arg3) {
			if (!casseBrique.isGameOver()) {
				casseBrique.getBarre().move(arg0);
			}

			return false;
		}

		@Override
		public boolean panStop(float arg0, float arg1, int arg2, int arg3) {
			return false;
		}

		@Override
		public boolean pinch(Vector2 arg0, Vector2 arg1, Vector2 arg2,
				Vector2 arg3) {
			return false;
		}

		@Override
		public boolean tap(float arg0, float arg1, int arg2, int arg3) {
			return false;
		}

		@Override
		public boolean touchDown(float arg0, float arg1, int arg2, int arg3) {
			return false;
		}

		@Override
		public boolean zoom(float arg0, float arg1) {
			return false;
		}

	}
}
