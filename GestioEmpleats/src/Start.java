import javax.swing.JFrame;
import com.gestioempleats.components.FirstFrame;
import java.awt.BorderLayout;


public class Start extends JFrame {
	public Start() {
		
		FirstFrame firstFrame = new FirstFrame();
		getContentPane().add(firstFrame, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		
	}
	
}