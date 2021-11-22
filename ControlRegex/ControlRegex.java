/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlRegex;

import java.lang.ref.Cleaner;
import java.util.Stack;

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
    private int i = 0;

    // cette methode verifie si un charactere est une lettre de l'alphabet ou pas
    // public boolean VerifierQueLeCharactereEstUneLettreOuUnPas(char lettre) {
    // if ((lettre >= 'A' && lettre <= 'Z') || (lettre >= 'a' && lettre <= 'z'))
    // return true;
    // return false;
    // }

    // cette methode verifie si un charactere est un operateur ou pas
    public boolean VerifierQueLeCharactereEstUnOperateurOuUnPas(char Operateur) {
        if (Operateur == '+' || Operateur == '|' || Operateur == '.')
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
                            || Regex.charAt(i) == '9')
                    || Regex.charAt(i) == '.' || Regex.charAt(i) == '(' || Regex.charAt(i) == ')')) {
                cpt++;
            }
        }
        if (cpt == 0)
            return true;
        return false;
    }

    // cette methode teste si le texte saisir ne contient que les lettres
    public boolean ContientLettre(String Regex) {
        int cpt = 0;
        for (int i = 0; i < Regex.length(); i++) {
            if (!((Regex.charAt(i) >= 'A' && Regex.charAt(i) <= 'Z')
                    || (Regex.charAt(i) >= 'a' && Regex.charAt(i) <= 'z')
                    || (Regex.charAt(i) == '0' || Regex.charAt(i) == '1' || Regex.charAt(i) == '2'
                            || Regex.charAt(i) == '3' || Regex.charAt(i) == '4' || Regex.charAt(i) == '5'
                            || Regex.charAt(i) == '6' || Regex.charAt(i) == '7' || Regex.charAt(i) == '8'
                            || Regex.charAt(i) == '9'))) {
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
        if (VerifierQueLeRegexEstBienParentheser(Regex) == true) {
            if (ContientLettreEtOperateur(Regex) == true) {
                if (VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(Regex.length() - 1)) == true
                        || VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(0)) == true
                        || Regex.charAt(0) == '*') {
                    return false;
                } else {
                    for (int i = 1; i < Regex.length(); i++) {
                        if ((VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i - 1)) == true
                                && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i)) == true)
                                || (Regex.charAt(i) == '*' && Regex.charAt(i - 1) == '*')
                                || (Regex.charAt(i) == '*'
                                        && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i - 1)) == true)
                                || (Regex.charAt(i) == ')'
                                        && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i - 1)) == true)
                                || (Regex.charAt(i - 1) == '('
                                        && VerifierQueLeCharactereEstUnOperateurOuUnPas(Regex.charAt(i)) == true)
                                || (Regex.charAt(i - 1) == '(' && Regex.charAt(i) == ')')
                                || (Regex.charAt(i - 1) == ')' && Regex.charAt(i) == '(')) {
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
        } else {
            return false;
        }

    }

    // mettre les points sur les expressions regulieres
    public String transformerEspaceEnPoint(String Regex) {
        char[] ExpR = new char[Regex.length() + 10];
        int k = 0;
        ExpR[k] = Regex.charAt(0);
        k++;
        for (int i = 1; i < Regex.length(); i++) {
            if ((ContientLettre(String.valueOf(Regex.charAt(i - 1))) == true
                    && ContientLettre(String.valueOf(Regex.charAt(i))) == true)
                    || (ContientLettre(String.valueOf(Regex.charAt(i - 1))) == true && Regex.charAt(i) == '(')
                    || (Regex.charAt(i - 1) == ')' && Regex.charAt(i) == '(')
                    || (ContientLettre(String.valueOf(Regex.charAt(i))) == true && Regex.charAt(i - 1) == ')')
                    || (Regex.charAt(i) == '(' && Regex.charAt(i - 1) == '*')
                    || (ContientLettre(String.valueOf(Regex.charAt(i))) == true && Regex.charAt(i - 1) == '*')) {
                ExpR[k] = '.';
                k++;
                ExpR[k] = Regex.charAt(i);
                k++;
            } else {
                ExpR[k] = Regex.charAt(i);
                k++;
            }

        }
        return String.valueOf(ExpR);
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
        if (nbrfermente != nbrouvrant) {
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

    // methode pour verifier que c'est un operateur telque ('(','+','*','|')
    public boolean verificationOperateur(char Regex) {
        if (Regex == '(' || Regex == '+' || Regex == '*' || Regex == '|')
            return true;
        return false;
    }

    // cette methode permet de contruire l'AFN a partir dun regex
    public String ConstruireTransitionAFN(String Regex) {
        return null;
    }

    // cette methode permet de choisir l'operateur
    public int Prec(char ch) {
        switch (ch) {
        case '+':
        case '|':
            return 1;

        case '.':
        case '/':
            return 2;

        case '*':
            return 3;
        }
        return -1;
    }

    // cette methode transforme une expression en infix sous forme postfixe
    public String TransformeUnRegexSousFormePostfixe(String Exp) {
        if (VerifierQueLeRegexEstBienFormer(Exp)) {
            String exp = transformerEspaceEnPoint(Exp);
            String result = new String("");

            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < exp.length(); ++i) {
                char c = exp.charAt(i);

                if (Character.isLetterOrDigit(c))
                    result += c;

                else if (c == '(')
                    stack.push(c);

                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(')
                        result += stack.pop();

                    stack.pop();
                } else {
                    while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {

                        result += stack.pop();
                    }
                    stack.push(c);
                }

            }

            while (!stack.isEmpty()) {
                if (stack.peek() == '(')
                    return "Invalid Expression";
                result += stack.pop();
            }
            return result;
        } else {
            System.out.println("Regex mal former");
            return null;
        }

    }

}

/*
 * public String TransformeUnRegexSousFormePostfixe(String regex) { String
 * Regex=transformerEspaceEnPoint(regex); int k = 0; Stack<String> pile = new
 * Stack<>(); char[] ExpressPostfixe = new char[Regex.length()]; for (int i = 0;
 * i < Regex.length(); i++) { if (Regex.charAt(i) == '*' || Regex.charAt(i) ==
 * '(') { pile.add(String.valueOf(Regex.charAt(i))); } else if (Regex.charAt(i)
 * == '+' || Regex.charAt(i) == '|') { if (!pile.empty()) { if
 * (pile.lastElement().equals("*") || pile.lastElement().equals(".")) { while
 * (pile.lastElement().equals("*") || pile.lastElement().equals(".")) { String
 * myString = pile.lastElement(); char[] MyChars = myString.toCharArray();
 * ExpressPostfixe[k] = MyChars[0]; pile.pop(); k++; } } else {
 * pile.add(String.valueOf(Regex.charAt(i))); } } else {
 * pile.add(String.valueOf(Regex.charAt(i))); }
 * 
 * } else if (Regex.charAt(i) == '.') { if (!pile.empty()) { if
 * (pile.lastElement().equals("*")) { while (pile.lastElement().equals("*")) {
 * String myString = pile.lastElement(); char[] MyChars =
 * myString.toCharArray(); ExpressPostfixe[k] = MyChars[0]; pile.pop(); k++; } }
 * else { pile.add(String.valueOf(Regex.charAt(i))); } } else {
 * pile.add(String.valueOf(Regex.charAt(i))); }
 * 
 * } else if (Regex.charAt(i) == ')') { while (!pile.lastElement().equals("("))
 * { String myString = pile.lastElement(); char[] MyChars =
 * myString.toCharArray(); ExpressPostfixe[k] = MyChars[0]; pile.pop(); k++; } }
 * else { ExpressPostfixe[k] = Regex.charAt(i); k++; } }
 * 
 * for (int i = k; i < Regex.length(); i++) { if (!pile.empty()) { if
 * (pile.lastElement().equals("(")) { if (pile.empty()) break; pile.pop(); }
 * else { if (pile.empty()) break; String myString = pile.lastElement(); char[]
 * MyChars = myString.toCharArray(); ExpressPostfixe[k] = MyChars[0];
 * pile.pop(); k++; }
 * 
 * }
 * 
 * }
 * 
 * return String.valueOf(ExpressPostfixe); }
 * 
 * public String TransformeUnRegexSousFormePostfixes(String Regex) { char[] a =
 * Regex.toCharArray(); int n = a.length; Stack<String> pile = new Stack<>();
 * String res = " "; for (int i = 0; i < a.length; i++) { if (a[i] == ')') { res
 * = res + pile.lastElement() + " "; pile.pop(); } if (a[i] == '(') {
 * 
 * } if (a[i] == ' ') {
 * 
 * } if ((a[i] == '+') || (a[i] == '|') || (a[i] == '*')) {
 * pile.add(String.valueOf(a[i])); } if ((a[i] >= '0') && (a[i] <= '9')) { while
 * ((a[i] >= '0') && (a[i] <= '9')) { res = res + a[i++]; } i--; res = res + '
 * '; } } return String.valueOf(res); }
 */

// cette methode suivante nous permetra de construire l'ensemble des transitions
// du regex.

// renvoyer une chaine de caractere prive du dernier elements
/*
 * public String DepilerDernierElement(String Regex){ char[] mot=new
 * char[Regex.length()]; for (int i = 0; i < Regex.length() - 1; i++) {
 * mot[i]=Regex.charAt(i); } return String.valueOf(mot); } //renvoyer une chaine
 * de caractere prive du premier elements public String
 * DepilerPremierElement(String Regex){ char[] mot=new char[Regex.length()]; for
 * (int i = 1; i < Regex.length(); i++) { mot[i]=Regex.charAt(i); } return
 * String.valueOf(mot); } //renvoyer une chaine de caractere prive du premier
 * elements public char[] DepilerPremierElements(char [] Regex){ char[] mot=new
 * char[Regex.length]; for (int i = 1; i < Regex.length; i++) { mot[i]=Regex[i];
 * } return mot; }
 * 
 * //prend un tableau et un element et ajoute lelement a la suite du tableau
 * public String ajouteSuite(String Regex, char elem){ char[] regex=new
 * char[Regex.length() +1]; for (int i = 0; i < Regex.length(); i++) {
 * regex[i]=Regex.charAt(i); } regex[Regex.length()]=elem; return
 * String.valueOf(regex); } // cette methode suivante nous permetra de
 * transformer un regex infixé sous // forme postfixé.
 * 
 * public String TransformeUnRegexSousFormePostfixe(String Regex, String
 * ExpressPostfixe, char[] TabOperateur){
 * 
 * if(Regex.length()!=0){ if(Regex.charAt(0)=='*' || Regex.charAt(0)=='('){
 * TabOperateur[0]=Regex.charAt(0); Regex=DepilerPremierElement(Regex); }else
 * if(Regex.charAt(0)=='+' || Regex.charAt(0)=='|'){
 * while(TabOperateur[0]=='*'){ ExpressPostfixe=ajouteSuite(ExpressPostfixe,
 * TabOperateur[0]); TabOperateur=DepilerPremierElements(TabOperateur); } }else
 * if(Regex.charAt(0)==')'){ while(TabOperateur[0]!='('){
 * ExpressPostfixe=ajouteSuite(ExpressPostfixe, TabOperateur[0]);
 * TabOperateur=DepilerPremierElements(TabOperateur); }
 * TabOperateur=DepilerPremierElements(TabOperateur); }else{
 * ExpressPostfixe=ajouteSuite(ExpressPostfixe, Regex.charAt(0)); } return
 * TransformeUnRegexSousFormePostfixe(Regex, ExpressPostfixe, TabOperateur);
 * 
 * }else{
 * 
 * return ExpressPostfixe; }
 * 
 * }
 */
