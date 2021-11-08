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

    //cette methode suivante nous permetra de savoir si un regex est bien former et envoyer un message d'erreur aux cas contraire
    public boolean VerifierQueLeRegexEstBienFormer(String Regex) {

        return false;
    }

    //cette methode suivante nous permetra de savoir si un regex est bien parenthèser et envoyer un message d'erreur aux cas contraire 
    public boolean VerifierQueLeRegexEstBienParentheser(String Regex) {

        return false;
    }
    
    
    //cette methode suivante nous permetra de recupérer automatiquement l'alphabet du regex entrer par l'utilisateur .  
    public String[] RecupérationAlphabetDuRegex(String Regex) {

        return null;
    }
    
    //cette methode suivante nous permetra de transformer un regex infixé sous forme postfixé.  
    public String TransformeUnRegexSousFormePostfixe(String Regex) {

        return null;
    }
     //cette methode suivante nous permetra de construire l'ensemble des transitions du regex.  
    public String ConstruireTransitionAFN(String Regex) {

    
         return null;
    }
}
