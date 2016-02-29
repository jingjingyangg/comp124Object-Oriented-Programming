package edu.macalester.comp124.stringtransformer;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by jyang1 on 10/1/15.
 */
public class Piratizer extends StringTransformer {

    private String addOn;
    private Random rand;

    public Piratizer(){
        this.rand = new Random();
        this.addOn = "";
    }

    @Override
    public String transform(String s) {

        s.replaceAll("r", "rrr");
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            out.append(ch);
        }

        addSymbolsRandomly();
        out.append(addOn);
        return out.toString();
    }

    private String addSymbolsRandomly(){
        int random100 = rand.nextInt(100);
        if (random100 <= 25){
            int random1 = rand.nextInt(2);
            conversion(random1);
            return addOn;
        } else {
            addOn = "";
        } return addOn;
    }

    @Override
    public String transformEachWord(String in) {
        Scanner wordScanner = new Scanner(in).useDelimiter("\\p{Punct}");
        StringBuilder out = new StringBuilder();
        int prevEnd = 0;
        while(wordScanner.hasNext()) {
            String sentence = wordScanner.next();
            out.append(in.substring(prevEnd, wordScanner.match().start()));
            out.append(transform(sentence));
            prevEnd = wordScanner.match().end();
        }
        out.append(in.substring(prevEnd));
        return out.toString();
    }


    @Override
    public String toString() {
        return "Piratizer";
    }

    private String conversion(int num){
        if (num == 0) {
            addOn = " Arrrrr!";
        }
        if (num == 1) {
            addOn = " Ahoy!";
        }
        return addOn;
    }
}
