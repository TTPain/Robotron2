package robotron2.weapon;

import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlSound;

import java.util.ArrayList;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Color;


import com.osreboot.ridhvl2.HvlCoord;

import robotron2.Game;
import robotron2.Player;
import robotron2.util.Utility;

public class BulletLogic {

	private static float bulletSpeedx;
	private static float bulletSpeedy;
	private static float cooldownClock = 0.0f;
	private static float cooldownSpeed = 12;
	private static int availableBullets = 1;


	//Add bullets as they are needed, add them back to queue as they leave the screen.
	public static ArrayList<Bullet> bulletTotal = new ArrayList<>();

	// xArg, yArg, xSpeed, ySpeed, fired, drawn
	public static Bullet initialBullet = new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0);


	public static void initialize() {
		bulletTotal.add(initialBullet);
	}

	public static void reset(Player player) {
		bulletTotal.clear();
		bulletTotal.add(initialBullet);

		for(Bullet b : bulletTotal) {
			b.setxPos(player.getxPos());
			b.setyPos(player.getyPos());
			b.setFired(false);
			b.setBulletDrawn(false);
			b.setxSpeed(0);
			b.setySpeed(0);
		}
	}

	public static void update(float delta, Player player) {

		if (cooldownClock > 0) {
			cooldownClock = cooldownClock - (delta * cooldownSpeed);
		}

		if (cooldownClock < 0) {
			cooldownClock = 0;
		}

		bulletSpeedx =Utility.getCursorX() - (Display.getWidth()/2);
		bulletSpeedy = Utility.getCursorY() - (Display.getHeight()/2);


		HvlCoord bulletSpeed = new HvlCoord(bulletSpeedx, bulletSpeedy);


		bulletSpeed.normalize();

		bulletSpeedx = bulletSpeed.x * 750;
		bulletSpeedy = bulletSpeed.y * 750;	


		if(Mouse.isButtonDown(0) && player.isAlive()) {

			for (Bullet b : bulletTotal){
				availableBullets = bulletTotal.size();
				if(b.isFired() == false && (cooldownClock == 0) && player.isAlive() && b.getxSpeed() == 0&& b.getySpeed() == 0) {
					b.setFired(true);
					//Bullet firing sound
					hvlSound(0).playAsSoundEffect(Utility.randomFloatBetween(0.90f, 1.05f), 1, false);
					if (cooldownClock == 0) {
						cooldownClock = 1;
					}
					b.setxSpeed(bulletSpeedx);
					b.setySpeed(bulletSpeedy);
				}
			}
			for(Bullet q : bulletTotal) {
				if(q.isOnScreen()) {
					availableBullets--;
				}
				if(availableBullets == 0 && cooldownClock == 0) {
					System.out.println("OUT OF BULLETS! Adding a new bullet to the array...");
					bulletTotal.add(new Bullet(Game.player.getxPos(), Game.player.getyPos(), 0, 0, false, false, 0));
					System.out.println("Total Number of Bullets: " + bulletTotal.size());
					break;
				}
			}
		}

		for (Bullet bullet : bulletTotal) {
			if (bullet.isOnScreen()) {
				bullet.setyPos(bullet.getyPos() + (delta * bullet.getySpeed()));
				bullet.setxPos(bullet.getxPos() + (delta * bullet.getxSpeed()));
			}
			if (bullet.isOnScreen() && bullet.isFired()) {
				bullet.draw(delta);
				bullet.setBulletDrawn(true);
			} else {
				bullet.setFired(false);
				bullet.setxPos(player.getxPos());
				bullet.setyPos(player.getyPos());
				bullet.setxSpeed(0);
				bullet.setySpeed(0);
				bullet.setBulletDrawn(false);
			}
		}
	}	
}





