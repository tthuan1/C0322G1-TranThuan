package ss8_clean_code_and_refactoring.exercise;

public class TennisGame {

    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final int TWO = 2;
    public static final int THREE = 3;

    public static String getScore(String player1Name, String player2Name, int m_score1, int m_score2) {
        StringBuilder score = new StringBuilder();
        int tempScore = 0;
        boolean equal = m_score1 == m_score2;
        if (equal) {
            switch (m_score1) {
                case ZERO:
                    score = new StringBuilder("Love-All");
                    break;
                case ONE:
                    score = new StringBuilder("Fifteen-All");
                    break;
                case TWO:
                    score = new StringBuilder("Thirty-All");
                    break;
                case THREE:
                    score = new StringBuilder("Forty-All");
                    break;
                default:
                    score = new StringBuilder("Deuce");
                    break;
            }
        } else {
            boolean compare = m_score1 >= 4 || m_score2 >= 4;
            if (compare) {
                int minusResult = m_score1 - m_score2;
                if (minusResult == 1) score = new StringBuilder("Advantage player1");
                else if (minusResult == -1) score = new StringBuilder("Advantage player2");
                else if (minusResult >= 2) score = new StringBuilder("Win for player1");
                else score = new StringBuilder("Win for player2");
            } else {
                for (int i = 1; i < 3; i++) {
                    if (i == 1) tempScore = m_score1;
                    else {
                        score.append("-");
                        tempScore = m_score2;
                    }
                    switch (tempScore) {
                        case 0:
                            score.append("Love");
                            break;
                        case 1:
                            score.append("Fifteen");
                            break;
                        case 2:
                            score.append("Thirty");
                            break;
                        case 3:
                            score.append("Forty");
                            break;
                    }
                }
            }
        }
        return score.toString();
    }
}
