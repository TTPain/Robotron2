import static com.osreboot.ridhvl2.HvlStatics.hvlDraw;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuad;
import static com.osreboot.ridhvl2.HvlStatics.hvlQuadc;
import static com.osreboot.ridhvl2.HvlStatics.hvlTexture;

import org.newdawn.slick.Color;

import com.osreboot.ridhvl2.HvlCoord;
import com.osreboot.ridhvl2.loader.HvlLoader;
import com.osreboot.ridhvl2.loader.HvlLoaderTexture;
import com.osreboot.ridhvl2.template.HvlDisplayWindowed;
import com.osreboot.ridhvl2.template.HvlTemplateI;

public class Main extends HvlTemplateI{

    public static void main(String[] args) {
    	for(int i = 0; i < 5; i++) {
    		System.out.println("Hello Worlk!");
    	}
        new Main();
    }

    public static final int 
    INDEX_MOVE_UP = 0,
    INDEX_MOVE_LEFT = 1,
    INDEX_MOVE_RIGHT = 2,
    INDEX_MOVE_DOWN = 3,
    INDEX_GRUNTSTEP_1 = 4,
    INDEX_GRUNTSTEP_2 = 5;

    public Main() {
        super(new HvlDisplayWindowed(144, 1280, 720, "Robotron 2", false));
    }

    @Override
    public void initialize() {
		hvlLoad("PlayerBlueBack.png"); //0
		hvlLoad("arrowleft.png"); //1
		hvlLoad("arrowright.png"); //2
		hvlLoad("PlayerBlue.png"); //3
		hvlLoad("GruntStep1.png"); //4
		hvlLoad("GruntStep2.png"); //5
        Game.initialize();

       // Player.initialize(); 
    }

    @Override
    public void update(float delta) {

    	//hvlDraw(hvlQuadc(640, 360, 1280, 720),Color.white);
        Game.update(delta);

    }

}