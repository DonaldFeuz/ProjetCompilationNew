/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import ControlRegex.ControlRegex;

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
        ControlRegex rex = new ControlRegex();
        System.out.println(rex.VerifierQueLeRegexEstBienParentheser("(((a8b)+bs))"));

        ControlRegex c= new ControlRegex();

        System.out.println(c.VerifierQueLeRegexEstBienFormer("00m+8a+m+a\n"));
        // VerifierQueLeRegexEstBienFormer(Regex);
        // VerifierQueLeRegexEstBienParentheser(Regex);
        // RecupérationAlphabetDuRegex(Regex);
        // TransformeUnRegexSousFormePostfixe();
        // ConstruireTransitionAFN();
        // ConstruireTransitionAFD();

    }

}
