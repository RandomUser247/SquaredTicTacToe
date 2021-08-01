import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI {
	private JFrame frame = new JFrame("TicTacToe"),frame2;
	private JPanel panel[][] = new JPanel[3][3];
	private JPanel mainP = new JPanel();
	private CustomButton[][][][] button = new CustomButton[3][3][3][3];
	private String turn;
	private Logic logic=new Logic();
	
	public UI() {
		//Größe des Fensters festlegen
		frame.setSize(900, 1200);
		
		//Grid-Layout für eine "TicTacToe-Anordnung der Panel 3x3
		
		mainP.setLayout(new GridLayout(3, 3));
		frame.add(mainP);
		
		//Schließt das Programm bei Fenster schließen
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i <= 2; i++) {
			for(int ii = 0; ii<=2;ii++){
				//Panel werden erzeugt und erhalten ein TicTacToe-Gridlayout 3x3
				panel[i][ii] = new JPanel(new GridLayout(3, 3));
				//Panel kriegen eine Umrandung für bessere Sichtbarkeit
				panel[i][ii].setBorder(new LineBorder(Color.black,2));

				for (int j = 0; j <= 2; j++) {
					for(int jj=0; jj<=2;jj++){

						//innerhalb jedes Panels werden 9 Button Objekte gespeicht 
						button[i][ii][j][jj] = new CustomButton();
						//Jedes CustomButton-Objekt kriegt einen A.L. 
						button[i][ii][j][jj].addActionListener(new NewActionListener());
						//jeweils ein 2dArray von Buttons wird in ein Panel eingefügt
						panel[i][ii].add(button[i][ii][j][jj]);
					}}
				//Panel werden dem Fenster hinzugefügt

				
				mainP.add(panel[i][ii]);
				

			}}
		//Fenster wird sichtbar gemacht
		frame.setVisible(true);
	}
	public String gibTurn(){
		if(logic.getTurn()){ 
			turn = "X";
			
		}
		else { 
			turn="O";
		}
		return turn;
	}

	//Funktion um ein Panel und dessen Inhalt zu "sperren"(false) oder entsperren(true)
	public void setPanelEnabled(JPanel P,boolean arg){

		for (Component cp : P.getComponents() ){
			//wie kann man hier ein Component auslassen durch isPressed() in CustomButton?
			//if(cp.isPressed())
			cp.setEnabled(arg);}

	}
	private class NewActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent a){

			for (int i=0;i<=2;i++){
				for (int j=0;j<=2;j++){
					for (int k=0;k<=2;k++){
						for (int l=0;l<=2;l++){
							//wenn Source==button (Button ist gedrückt worden)
							if(a.getSource()==button[i][j][k][l]){
								//Überprüft ob der Button schon gepresst war
								
									//Der Button kriegt den Text X/O(gibTurn()) als Beschriftung
									button[i][j][k][l].setText(gibTurn());
									//Der Button wird deaktiviert
									button[i][j][k][l].setEnabled(false);
									//Im reserved Objekt wird ein Element
									logic.setValue(i,j,k,l);
									//überprüft ob gewon/fertig
									if(logic.isWon(i, j))
									{
										switch (logic.whoWon(i, j))
										{
										//im Fall, dass Spieler Eins gewonnen -> Blau
										case 1: panel[i][j].setBackground(Color.blue);
										panel[i][j].setBorder(new LineBorder(Color.blue,2));
										break;
										//im Falle, dass Spieler Zwei gewonnen -> Rot
										case 2: panel[i][j].setBackground(Color.red);
										panel[i][j].setBorder(new LineBorder(Color.red,2));

										break;
										}
									}
									for(int ii=0; ii<=2;ii++){
										for(int jj=0;jj<=2;jj++){
											setPanelEnabled(panel[ii][jj],false);
										}
									}

									if(!logic.isWon(k, l)){
										setPanelEnabled(panel[k][l],true);
									}
									else{
										for(int ii=0; ii<=2;ii++){
											for(int jj=0;jj<=2;jj++){
												if(!logic.isWon(ii, jj)){
													setPanelEnabled(panel[ii][jj],true);
												}
											}
										}
									}
							  	}							
						}
					}
				}
			}
		}
	}
}