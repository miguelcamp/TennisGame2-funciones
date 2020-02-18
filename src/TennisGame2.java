
public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;
    
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = normal();
		if (isTie())
		    score = getLiteral(P1point)+"-All";
		if (isDeuce())
			score = "Deuce";
		if (isP1Advantage())
		    score = "Advantage player1";
		if (isP2Advantage())
		    score = "Advantage player2";
        
        score = win(score);
        return score;
    }

	private boolean isP2Advantage() {
		return P2point > P1point && P1point >= 3;
	}

	private boolean isP1Advantage() {
		return P1point > P2point && P2point >= 3;
	}

	private boolean isDeuce() {
		return P1point==P2point && P1point>=3;
	}

	private String win(String score) {
		if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for player2";
        }
		return score;
	}

	private String advantage(String score) {
		if (isP1Advantage())
        {
            score = "Advantage player1";
        }
        
        if (isP2Advantage())
        {
            score = "Advantage player2";
        }
		return score;
	}



	private String normal() {

		return getLiteral(P1point) + "-" + getLiteral(P2point);
	}

	private String getLiteral(int auxP1Point) {
		String resultado="";
		if (auxP1Point==0)
			resultado = "Love";
		if (auxP1Point==1)
			resultado = "Fifteen";
		if (auxP1Point==2)
			resultado = "Thirty";
		if (auxP1Point==3)
			resultado = "Forty";
		return resultado;
	}

	private String deuce(String score) {
		if (isDeuce())
            score = "Deuce";
		return score;
	}

	private String tie(String score) {
		if (isTie())
        {
            score = getLiteral(P1point)+"-All";
        }
		return score;
	}

	private boolean isTie() {
		return P1point == P2point && P1point < 4;
	}
    
    public void SetP1Score(int number){
    	P1point+=number;
    }
    
    public void SetP2Score(int number){
        P2point+=number;
    }
    
    public void P1Score(){
        P1point++;
    }
    
    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}