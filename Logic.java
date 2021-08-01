
public class Logic {
private int logicAr[][][][] = new int[3][3][3][3];
private int won[][] = new int[3][3];
private boolean turn = true;
public Logic(){
	//füllt das Array logic[][][][] mit dem Standardwert 5
for(int i=0;i<=2;i++){
	for(int j=0;j<=2;j++){
		for(int k=0;k<=2;k++){
			for(int l=0;l<=2;l++){
				logicAr[i][j][k][l]=5;
			}
		}
	}
}
//Füllt das Array won[][] mit dem Standardwert 0
for(int i=0;i<=2;i++){
	for (int j=0;j<=2;j++){
		won[i][j]=0;
	}
}
}
//Gibt einem Feld je nach Spielzug einen Wert. Spieler1=1 Spieler2=10
public void setValue(int i,int j,int k, int l){
	if(turn){
		logicAr[i][j][k][l]=1;
		turn=false;
	}
	else{
		logicAr[i][j][k][l]=10;
		turn =true;
	}
		}
//isWon überprüft ob 3 Werte in einer Reihe(row/collumn/diag) gleich sind und gibt in diesem Falle true zurück.
public boolean isWon(int i,int j){
	if(won[i][j]!=0){
		return true;
	}
	if(this.checkRows(i, j)||this.checkCollumn(i, j)||this.checkDiagonals(i, j)){
		return true;
	}
	return false;
}
//überprüft ob die Win-Vorgaben erfüllt sind(Summe 3||30) und gibt je nach Gewinner won[][] einen Wert(o/x)
public int whoWon(int i,int j){

	for (int k=0;k<=2;k++){
		//überprüft Spalten und Reihen - Summe soll 3(3*1) sein
		if (	logicAr[i][j][k][0]+logicAr[i][j][k][1]+logicAr[i][j][k][2]==3||
				logicAr[i][j][0][k]+logicAr[i][j][1][k]+logicAr[i][j][2][k]==3){
			won[i][j]=1;
		}}
	//überprüft die Diagonalen- Summer soll 3 sein(3*1)
	if(logicAr[i][j][0][0]+logicAr[i][j][1][1]+logicAr[i][j][2][2]==3||
		logicAr[i][j][2][0]+logicAr[i][j][1][1]+logicAr[i][j][0][2]==3){
		won[i][j]=1;}
	for (int k=0;k<=2;k++){
		//überprüft Spalten und Reihen - Summer soll 30(3*10) sein
		if (	logicAr[i][j][k][0]+logicAr[i][j][k][1]+logicAr[i][j][k][2]==30||
				logicAr[i][j][0][k]+logicAr[i][j][1][k]+logicAr[i][j][2][k]==30){
			won[i][j]=2;
		}}
	//Überprüft die Diagonalen - Summe soll 30 sein(3*10)
	if(logicAr[i][j][0][0]+logicAr[i][j][1][1]+logicAr[i][j][2][2]==30||
		logicAr[i][j][2][0]+logicAr[i][j][1][1]+logicAr[i][j][0][2]==30){
		won[i][j]=2;}
	return won[i][j];
}



private boolean checkRows(int i, int j){
	for (int k=0;k<=2;k++){
		//eine Reihe soll gleiche Werte haben aber ungleich dem Standardwert(5) sein
		if		(logicAr[i][j][0][k]==logicAr[i][j][1][k]&&
				logicAr[i][j][1][k]==logicAr[i][j][2][k]&&
				logicAr[i][j][2][k]!=5){
			return true;
			}
		}
	return false;
}

private boolean checkCollumn(int i, int j){
	for(int k=0;k<=2;k++){
		//eine Spalte soll gleiche Werte haben aber ungleich dem Standardwert(5) sein
		if		(logicAr[i][j][k][0]==logicAr[i][j][k][1]&&
				logicAr[i][j][k][1]==logicAr[i][j][k][2]&&
				logicAr[i][j][k][2]!=5){
			return true;
			}
		}
	return false;
}

private boolean checkDiagonals(int i, int j){
	//eine Diagonale soll gleiche Werte haben aber ungleich dem Standardwert(5) sein
	if	(logicAr[i][j][0][0]==logicAr[i][j][1][1]&&
			logicAr[i][j][1][1]==logicAr[i][j][2][2]&&
			logicAr[i][j][2][2]!=5||			
			logicAr[i][j][2][0]==logicAr[i][j][1][1]&&
			logicAr[i][j][1][1]==logicAr[i][j][0][2]&&
			logicAr[i][j][1][1]!=5){
			return true;}
	return false;}
//Getter für turn
public boolean getTurn(){
	return turn;
}

}