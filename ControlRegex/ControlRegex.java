/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlRegex;

/**
 * cette classe nous permetra d'éffectuer toute les verification et analyse
 * faite sur un regex entrer par l'utilisateurs
 *
 * @author donald
 */
public class ControlRegex {

    private String Regex;
    private String[] AlphabetRegex;
    private String[] Operateur;

   // cette methode verifie si un charactere est une lettre de l'alphabet ou pas
   // public boolean VerifierQueLeCharactereEstUneLettreOuUnPas(char lettre) {
   //     if ((lettre >= 'A' && lettre <= 'Z') || (lettre >= 'a' && lettre <= 'z'))
   //         return true;
   //     return false;
   // }

    // cette methode verifie si un charactere est un operateur ou pas
    public boolean VerifierQueLeCharactereEstUnOperateurOuUnPas(char Operateur) {
        if (Operateur == '+' ||Operateur == '|')
            return true;
        return false;
    }

    // cette methode teste si le texte saisir ne contient que les operateur et les
    // lettres
    public boolean ContientLettreEtOperateur(String Regex) {
        int cpt = 0;
        for (int i = 0; i < Regex.length(); i++) {
            if (!((Regex.charAt(i) >= 'A' && Regex.charAt(i) <= 'Z')
                    || (Regex.charAt(i) >= 'a' && Regex.charAt(i) <= 'z')
                    || (Regex.charAt(i) == '+' || Regex.charAt(i) == '*' || Regex.charAt(i) == '|')
                    || (Regex.charAt(i) == '0' || Regex.charAt(i) == '1' || Regex.charAt(i) == '2'
                            || Regex.charAt(i) == '3' || Regex.charAt(i) == '4' || Regex.charAt(i) == '5'
                            || Regex.charAt(i) == '6' || Regex.charAt(i) == '7' || Regex.charAt(i) == '8'
                            || Regex.charAt(i) == '9') || Regex.charAt(i) == '(' || Regex.charAt(i) == ')')) {
                cpt++;
            }
        }
        if (cpt == 0)
            return true;
        return false;
    } 

    // cette methode suivante nous permetra de savoir si un regex est bien former et
    // envoyer un message d'erreur aux cas contraire
    public boolean VerifierQueLeRegexEstBienFormer(String Regex) {
        int cpt = 0;
        if(VerifierQueLeRegexEstBienParentheser(Regex)==true){
            if (ContientLettreEtOperateur(Regex) == true) {
                if (VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(Regex.length() - 1)) == true
                        || VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(0)) == true || Regex.charAt(0)=='*') {
                    return false;
                } else {
                    for (int i = 1; i < Regex.length(); i++) {
                        if ((VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i - 1)) == true
                                && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i)) == true) || (Regex.charAt(i)=='*' && Regex.charAt(i - 1)=='*') || (Regex.charAt(i)=='*' && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i-1)) == true)) {
                            cpt++;
                        }
                    }
                    if (cpt == 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
    
            } else {
                return false;
            }
        }else{
            return false;
        }
        

    }

    // cette methode suivante nous permetra de savoir si un regex est bien
    // parenthèser et envoyer un message d'erreur aux cas contraire
    public boolean VerifierQueLeRegexEstBienParentheser(String Regex) {
        int nbrouvrant = 0;
        int nbrfermente = 0;
         
        for (int i = 0; i < Regex.length(); i++) {
            if (Regex.charAt(i) == '(') {
                nbrouvrant = nbrouvrant + 1;
            }  

            if (Regex.charAt(i) == ')') {
                if (nbrouvrant == 0) {
                    return false;
                } else {
                    nbrfermente = nbrfermente + 1;
                    
                }
            }
        }
        if (nbrfermente != nbrouvrant ) {
          return false;  
        }
        return true;
    }

    // cette methode suivante nous permetra de recupérer automatiquement l'alphabet
    // du regex entrer par l'utilisateur .
    public String RecupérationAlphabetDuRegex(String Regex) {
        String resut = new String();
        for (int i = 0; i < Regex.length(); i++) {
            if ((Regex.charAt(i) >= 'A' && Regex.charAt(i) <= 'Z') || (Regex.charAt(i) >= 'a' && Regex.charAt(i) <= 'z')
                    || (Regex.charAt(i) >= '0' && Regex.charAt(i) <= '9')) {
                if (!resut.contains(Character.toString(Regex.charAt(i)))) {
                    resut = resut + " " + Character.toString(Regex.charAt(i));

                }
            }

        }
        return resut;
    }

    // cette methode suivante nous permetra de transformer un regex infixé sous
    // forme postfixé.
    public String TransformeUnRegexSousFormePostfixe(String Regex) {

        return null;
    }

    // cette methode suivante nous permetra de construire l'ensemble des transitions
    // du regex.
    public String ConstruireTransitionAFN(String Regex) {

        return null;
    }
}
