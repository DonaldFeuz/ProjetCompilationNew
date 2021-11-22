/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.Scanner;

import java.util.Stack;

import ControlRegex.ControlRegex;
import automate.AutomateAFN;
import automate.Etat;
import automate.TransitionAFN;

/**
 *
 * @author donald
 */
public class Main {

    /**
     * cette classe vas nous permettre de recuperer une regex et d'éffectuer toute
     * les taches qui sont associés tout commence ici!!! beaucoup de courage et de
     * concentration à tous !!!!
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String Alphabet = new String();
        // String compt = new String("o");
        // while (compt.equals("o")) {

        String Regex;
        System.out.println("Entrer l'expression reguliere de votre language");
        Scanner sc = new Scanner(System.in);
        Regex = sc.next();
        ControlRegex rex = new ControlRegex();
        //System.out.println(rex.VerifierQueLeRegexEstBienParentheser("(((a8b)+bs))"));

        ControlRegex c= new ControlRegex();
       // c.TransformeUnRegexSousFormePostfixe("+", " ", tab);
        System.out.println(c.TransformeUnRegexSousFormePostfixe("(aa)*(a+a)"));
        //System.out.println(c.VerifierQueLeRegexEstBienFormer("R(a+b)eg*e.x"));

        if (rex.VerifierQueLeRegexEstBienParentheser(Regex)) {
            // System.out.println(rex.VerifierQueLeRegexEstBienParentheser(Regex));
            Alphabet = rex.RecupérationAlphabetDuRegex(Regex);

        }
        Stack<AutomateAFN> pile = new Stack<>();

        AutomateAFN automateAFN = new AutomateAFN();
        TransitionAFN transitionAFN = new TransitionAFN();

        for (int i = 0; i < Regex.length(); i++) {

            // pile.add(i, String.valueOf(Regex.charAt(i)));
            // String s = "a";


            if (Alphabet.contains(String.valueOf(Regex.charAt(i)))) {

                automateAFN = transitionAFN.construireTransitionAFNSinple(String.valueOf(Regex.charAt(i)));
                pile.add(automateAFN);

            }
            if (String.valueOf(Regex.charAt(i)).equals("+")) {
                AutomateAFN automat1 = new AutomateAFN();
                AutomateAFN automat2 = new AutomateAFN();
                automat1 = pile.pop();
                automat2 = pile.pop();

                automateAFN = transitionAFN.ConstruireTransitionAFNAddition(automat1, automat2);
                pile.add(automateAFN);

            }
            
            
        }
        
        System.out.println("bienvenu");
        for (TransitionAFN item : pile.firstElement().GetTransitions()) {
            System.out.println(item);
        }


        // ControlRegex c = new ControlRegex();

        // System.out.println(c.VerifierQueLeRegexEstBienFormer("gm+a\n"));
        // VerifierQueLeRegexEstBienFormer(Regex);
        // VerifierQueLeRegexEstBienParentheser(Regex);
        // RecupérationAlphabetDuRegex(Regex);
        // TransformeUnRegexSousFormePostfixe();
        // ConstruireTransitionAFN();
        // ConstruireTransitionAFD();

        // System.out.println("voulez vous entrer une autre expression???");
        // Scanner sc = new Scanner(System.in);
        // compt = sc.next();
        // System.out.println("" + compt);

        // }
    }

}
