package edu.macalester.comp124.hw2;


public class CollatzIterator {
    
    public int recordSettingSeed(int max) {
        int record = 0, recordSeed = 1;
        int seed = 1;
        while(seed <= max) {
            int iters = sequenceLength(seed);
            if(iters > record) {
                record = iters;
                recordSeed = seed;
            }
            seed++;
        }
        return recordSeed;
    }

    public int iterate(int x){
        if (x % 2 == 0) {
            x = x/2;
        } else {
            x = 3 * x + 1;
        } return x;
    }

    public int sequenceLength(int seed){
        int iters = 0;
        while (true){
            seed = iterate(seed);
            if(seed == 1){
                break;
            }
            iters ++;

        } return iters;
    }

}
