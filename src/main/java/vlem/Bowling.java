package vlem;
/**
 * Created by valentin on 18/03/15. test push
 */
public class Bowling implements InterfaceBowling {
    /**
     * variable magic number 9.
     */
    public static final int INT9 = 9;
    /**
     * variable magic number 10.
     */
    public static final int INT10 = 10;
    /**
     * variable magic number 11.
     */
    public static final int INT11 = 11;
    /**
     * variable magic number 21.
     */
    public static final int INT21 = 21;
    /**
     * Fonction vérifiant que la partie contient un nombre correct de lancers.
     * @param partie La partie du joueur.
     * @return true si la taille est correcte.
     */
    public final boolean correctLength(final String partie) {
        boolean correct = true;
        int taille = partie.length();
        return !(taille < INT11 || taille > INT21);

    }
    /**
     * Fonction vérifiant que le score du round courant est valide.
     * @param partie La partie du joueur.
     * @param current Lancer actuel (doit correspondre à un début de round).
     * @return true si le format du round est correct.
     */
    public final boolean correctRound(final String partie, final int current) {
            boolean correct = true;
            String chiffres = "0123456789";
            char c1 = partie.charAt(current);
            char c2;
            if (c1 == 'X') {
                c1 = partie.charAt(current + 1);
                if (c1 == 'X') {
                    c1 = partie.charAt(current + 2);
                    if (c1 != 'X' && !chiffres.contains("" + c1)) {
                        correct = false;
                    }
                } else {
                    if (chiffres.contains("" + c1)) {
                        c2 = partie.charAt(current + 2);
                        if (c2 != '/' && (!chiffres.contains("" + c2)
                                || (Integer.parseInt("" + c1)
                                + Integer.parseInt("" + c2)) > INT9)) {
                            correct = false;
                        }
                    } else {
                        correct = false;
                    }
                }
            } else {
                if (chiffres.contains("" + c1)) {
                    c2 = partie.charAt(current + 1);
                    if (c2 == '/') {
                        c1 = partie.charAt(current + 2);
                        if (c1 != 'X' && !chiffres.contains("" + c1)) {
                            correct = false;
                        }
                    } else {
                        if (!chiffres.contains("" + c2)
                                || Integer.parseInt("" + c1)
                                + Integer.parseInt("" + c2) > INT9) {
                            correct = false;
                        }
                    }
                } else {
                    correct = false;
                }
            }
            return correct;
    }
    /**
     * Fonction vérifiant si une partie est correctement formée.
     * @param partie La partie du joueur.
     * @return true si le format de la partie est correct.
     */
    public final boolean correctGame(final String partie) {
        boolean correct = correctLength(partie);
        int i = 0;
        int j = 0;
        while (correct && j < INT10) {
            correct = correctRound(partie, i);
            i++;
            if (partie.charAt(i - 1) != 'X') {
                i++;
            }
            j++;
        }
        return correct;
    }
    /**
     * Fonction permettant de récupérer le score final du joueur.
     * @param partie La partie du joueur.
     * @return Le score du joueur.
     */
    public final int score(final String partie) {
        int scoreFinal = 0;
        if (correctGame(partie)) {
            int i = 0;
            // j correspond à la manche courante
            for (int j = 0; j < INT10; j++) {
                if (partie.charAt(i) == 'X') {
                    scoreFinal += INT10;
                    if (partie.charAt(i + 1) == 'X') {
                        scoreFinal += INT10;
                        if (partie.charAt(i + 2) == 'X') {
                            scoreFinal += INT10;
                        } else {
                            scoreFinal +=
                                    Integer.parseInt("" + partie.charAt(i + 2));
                        }
                    } else {
                        if (partie.charAt(i + 2) == '/') {
                            scoreFinal += INT10;
                        } else {
                            scoreFinal +=
                                    Integer.parseInt("" + partie.charAt(i + 1));
                            scoreFinal +=
                                    Integer.parseInt("" + partie.charAt(i + 2));
                        }
                    }
                    i++;
                } else {
                    if (partie.charAt(i + 1) == '/') {
                        scoreFinal += INT10;
                        if (partie.charAt(i + 2) == 'X') {
                            scoreFinal += INT10;
                        } else {
                            scoreFinal +=
                                    Integer.parseInt("" + partie.charAt(i + 2));
                        }
                    } else {
                        scoreFinal += Integer.parseInt("" + partie.charAt(i));
                        scoreFinal
                                += Integer.parseInt("" + partie.charAt(i + 1));
                    }
                    i += 2;
                }
            }
        }
        return scoreFinal;
    }
}
