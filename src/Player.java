import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;

public class Player {
	
	public Player(float xArg, float yArg){

		xPos = xArg;
		yPos = yArg;

	}
	public static final float PLAYER_START_X = 1280/2;
	public static final float PLAYER_START_Y = 720/2;
	
	public static final float PLAYER_SIZE = 20;
	private float xPos = 1280/2;
	private float yPos = 720 / 2;
	private float xspeedm = 1;
			
	private float yspeedm = 1;
	private float xspeedp = 1;
	private float yspeedp = 1;
	private float accel = 3;
	private int q = 0;
	public static void initialize() {
		hvlLoad("arrowup.png"); //0
		hvlLoad("arrowleft.png"); //1
		hvlLoad("arrowright.png"); //2
		hvlLoad("arrowdown.png"); //3
	}

	public void update(float delta) {
		//System.out.println(xspeedp);
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xspeedm = xspeedm + delta*accel;
		} else {
			xspeedm = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xspeedp = xspeedp + delta*accel;
		} else {
			xspeedp = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yspeedp = yspeedp + delta*accel;
		} else {
			yspeedp = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yspeedm = yspeedm + delta*accel;
		} else {
			yspeedm = 1;
		}
		if( xspeedm > 2){
			xspeedm = 2;
			}
		if(xspeedp > 2) {
			xspeedp = 2;
		}
		if(yspeedp > 2) {
			yspeedp = 2;
		}
		if(yspeedm > 2) {
			yspeedm = 2;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W)) {
			yPos = yPos - 1*yspeedm;
			q = 0;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_S)) {
			yPos = yPos + 1*yspeedp;
			q = 3;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A)) {
			xPos = xPos - 1*xspeedm;
			q = 1;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D)) {
			xPos = xPos + 1*xspeedp;
			q = 2;
		}
		if(xPos > 1270) {
			xPos = 1270;} 
		if(xPos < 10) {
			xPos =10;}
		if(yPos > 710) {
			yPos = 710;}
		if(yPos < 10) {
			yPos = 10;}
	}
	
	public void draw(float delta){
		
		hvlDraw(hvlQuadc(xPos, yPos, PLAYER_SIZE, PLAYER_SIZE), hvlTexture(q));
		
	}
		
		public float getxPos() {
		return xPos;
	}


	public void setxPos(float xPos) {
		this.xPos = xPos;
	}


	public float getyPos() {
		return yPos;
	}


	public void setyPos(float yPos) {
		this.yPos = yPos;
	}






		
}
