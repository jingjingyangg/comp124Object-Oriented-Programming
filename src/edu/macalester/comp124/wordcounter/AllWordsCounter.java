package edu.macalester.comp124.wordcounter;

/**
 * A counter that keeps track of counts for all words
 * 
 * @author shilad
 *
 */
public class AllWordsCounter {

    public static final int MAX_WORDS = 10000;
    private SingleWordCounter counters[];

    /**
     * Constructor that initializes the SingleWordCounter instance variable
     */
    public AllWordsCounter() {
        counters = new SingleWordCounter[MAX_WORDS];
        // TODO: initialize instance variable to hold MAX_WORDS objects

    }

    /**
     * Returns the number of words stored in SingleWordCounter
     * @return the filled size of SingleWordcounter
     */
    public int getNumWords() {
        // TODO: count the number of distinct words,
        // ie. the number of non-null counter objects.
        int count = 0;
        for (int i = 0; i < counters.length; i++){
            if (counters[i] != null) {
                count++;
            }
        }
        return count;
    }
	
	/**
	 * Increment the count for the specified word.  Remember that this may
     * be the first time the word counter has seen this particular word.
	 * 
	 * @param word
	 */
	public void count(String word) {
        if(word.equals("")){
            return;
        }

        for (int i=0; i < counters.length; i++) {
            //TODO: If you find the word increment the count and return
            if (counters[i] != null){
                if (counters[i].wordMatches(word)){
                    counters[i].incrementCount();
                    break;
                }
            } else {
                counters[i] = new SingleWordCounter(word);
                counters[i].incrementCount();
                break;
            }
        }

        //TODO: You didn't find the word. Add a new word counter to the array.
        // Don't forget to increment the word's count to get it to 1!

	}
	
	/**
	 * Return the count for the particular word.  Remember that the
	 * word may not have been seen before.
	 * @param word
	 * @return
	 */
	public int getCount(String word) {
        // TODO: pattern this after the count() function.
        // Make sure to return 0 for words you haven't seen before.
        if(word.equals("")){
            return(0);
        }

        for (int i=0; i < counters.length; i++) {
            if (counters[i] != null) {
                if (counters[i].wordMatches(word)) {
                    return (counters[i].getCount());
                }
            }
        }
        return(0);
        }
	
	/**
	 * @return The an array of all words that have been counted
	 * (just the words, not the values).
	 */
	public String []  getAllWords(){
        //TODO: part one: create an array of strings of size equal to the number of words
        int n = getNumWords();
        String words[] = new String[n];  // FIXME

        //TODO: part two: fill the array of strings using a loop
        for (int i=0; i < words.length; i++) {
            if (counters[i] != null) {
                words[i] = counters[i].getWord();
            }
        }
        return words;
	}
}
















