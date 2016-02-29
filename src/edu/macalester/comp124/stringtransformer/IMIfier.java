package edu.macalester.comp124.stringtransformer;

import java.util.Random;

/**
 * Created by jyang1 on 10/1/15.
 */
public class IMIfier extends StringTransformer {

    private Random rand;
    private String addOn;

    public IMIfier(){
        this.rand = new Random();
        this.addOn = "";
    }

    @Override
    public String transform(String s) {

        StringBuilder out = new StringBuilder();
        for (int i = 0; i < s.length(); i++){
            char ch = Character.toLowerCase(s.charAt(i));
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u'){
                out.append(ch);
            }
        }
        addSymbolsRandomly();
        out.append(addOn);
        return out.toString();
    }

    private String addSymbolsRandomly(){
        int random100 = rand.nextInt(99);
        if (random100 < 20){
            int random5 = rand.nextInt(4);
            conversion(random5);
            return addOn;
        } else {
            addOn = "";
        } return addOn;
    }

    private String conversion(int num){
        if (num == 1) {
            addOn = " lol";
        }
        if (num == 2) {
            addOn = " lmao";
        }
        if (num == 3) {
            addOn = " omg";
        }
        if (num == 4) {
            addOn = " jk";
        }
        if (num == 0) {
            addOn = " rofl";
        }
        return addOn;
    }

    @Override
    public String toString() {
        return "IMIfier";
    }


}
