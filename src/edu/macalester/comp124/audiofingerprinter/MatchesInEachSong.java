package edu.macalester.comp124.audiofingerprinter;

/**
 * Created by JingjingYang on 12/4/15.
 */
public class MatchesInEachSong implements Comparable<MatchesInEachSong>{

    private String songName;
    private int maxMatches;

    public MatchesInEachSong(String songName, int maxMatches){
        this.songName = songName;
        this.maxMatches = maxMatches;
    }

    public String getName(){
        return songName;
    }
    public int compareTo(MatchesInEachSong matches){
        if (this.maxMatches == matches.maxMatches){
            return 0;
        } else if (this.maxMatches > matches.maxMatches){
            return 1;
        } else {
            return -1;
        }
    }

    public String toString(){
        return (": " + maxMatches + " matches.");
    }

}
