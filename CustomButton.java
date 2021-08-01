//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
import javax.swing.JToggleButton;

public class CustomButton extends JToggleButton  {

	private static final long serialVersionUID = 2382304075566412404L;
private boolean ispressed=false;
//private ImageIcon kreuz,kreis;
public CustomButton(){
	
		}
//Setter für ispressed
public void setpressed(boolean press){
	ispressed=press;
}
//Überprüft ispressed/Getter
public boolean isPressed(){
	return ispressed;
}
//Soll ein Icon für den Button vergeben, basierend auf c(wer dran ist) - deutlicher als nur Beschriftung
public void SetIcon(char c){
	switch (c){
		case 'x': 
			//this.setIcon(kreuz);
			this.setpressed(true);
			break;
		case 'o':
			//this.setIcon(kreis);
			this.setpressed(true);
			break;
		default: 
			throw new IllegalArgumentException( "Unknown Operator!" );
	}
}

}
