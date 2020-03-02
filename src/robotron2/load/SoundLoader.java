package robotron2.load;
import static com.osreboot.ridhvl2.HvlStatics.hvlLoad;

import com.osreboot.ridhvl2.loader.HvlLoaderSound;

public class SoundLoader {

	 public static final int 
	    INDEX_PEW = 0,
	 	INDEX_FF = 1,
	 	INDEX_GRUNTSTEP = 2;
	 

		public static void loadSounds() {
			hvlLoad("pew.wav"); //0
			hvlLoad("ff.wav");//1
			hvlLoad("GruntStep.wav");//2
		}
		
		
	
}
