package edu.macalester.comp124.audiofingerprinter;

import java.io.File;
import java.util.*;

/**
 * Created by JingjingYang on 11/29/15.
 * Have received help from Bret Jackson and Jiayin Qu.
 */
public class FingerPrinter implements AudioFingerprinter {

    private SongDatabase DB;
    private static final int FUZ_FACTOR = 2;
    public final int[] RANGE = new int[] { 40, 80, 120, 180, 300 };

    public FingerPrinter(SongDatabase DB){
        this.DB = DB;
    }

    public SongDatabase getSongDB(){
        return DB;
    }

    public List<String> recognize(byte[] audioData){
        double[][] frequencies = DB.convertToFrequencyDomain(audioData);
        long[][] keyPoints = determineKeyPoints(frequencies);
        Map<String, Map<Integer, Integer>> allSongsThatMatch = new HashMap<>();
        for (int t = 0; t < frequencies.length; t++){
            long h = hash(keyPoints[t]);
            List<DataPoint> matchingPts = DB.getMatchingPoints(h);
            if (matchingPts!= null){
                for (DataPoint dataPt: matchingPts){
                    String songName = DB.getSongName(dataPt.getSongId());
                    int offSetDiff = t - dataPt.getTime();
                    if (allSongsThatMatch.containsKey(songName)){
                        if (allSongsThatMatch.get(songName).containsKey(offSetDiff)){
                            allSongsThatMatch.get(songName).put(offSetDiff,allSongsThatMatch.get(songName).get(offSetDiff)+1);
                        } else {
                            allSongsThatMatch.get(songName).put(offSetDiff, 1);
                        }
                    } else {
                        Map<Integer, Integer> offsetAndCount = new HashMap<>();
                        offsetAndCount.put(offSetDiff, 1);
                        allSongsThatMatch.put(songName, offsetAndCount);
                    }
                }
            }
        }
        List<MatchesInEachSong> maxMatches = new ArrayList<MatchesInEachSong>();
        for (String songName: allSongsThatMatch.keySet()){
            int max = 0;
            for (int offSet: allSongsThatMatch.get(songName).keySet()){
                if (allSongsThatMatch.get(songName).get(offSet) > max){
                    max = allSongsThatMatch.get(songName).get(offSet);
                }
            }
            MatchesInEachSong maxMatchEachSong = new MatchesInEachSong(songName, max);
            maxMatches.add(maxMatchEachSong);
        }
        Collections.sort(maxMatches);
        Collections.reverse(maxMatches);
        List<String> sortedResult = new ArrayList<String>();
        for (MatchesInEachSong matches: maxMatches){
            sortedResult.add(matches.getName() + matches.toString());
        }
        return sortedResult;
    }

    public List<String> recognize(File fileIn){
        byte[] audio = DB.getRawData(fileIn);
        List<String> matchingSongs = recognize(audio);
        return matchingSongs;
    }

    public long[][] determineKeyPoints(double[][] results){
        double[][] highScores = new double[results.length][5];
        long[][] points = new long[results.length][5];
        for (int x = 0; x < results.length; x++){
            for (int y = 0; y < 5; y++){
                highScores[x][y] = 0;
                points[x][y] = 0;
            }
        }
        for (int t = 0; t < results.length; t++){
            for (int freq = 40; freq < 300; freq ++) {
                double re = results[t][2 * freq];
                double im = results[t][2 * freq + 1];
                double mag = Math.log(Math.sqrt(re * re + im * im) + 1);
                int index = getIndex(freq);
                if (mag > highScores[t][index]) {
                    highScores[t][index]= mag;
                    points[t][index] = freq;
                }
            }
        }
        return points;
    }

    public long hash(long[] points){
        return (points[3] - (points[3] % FUZ_FACTOR)) * 100000000 + (points[2] - (points[2] % FUZ_FACTOR))
                * 100000 + (points[1] - (points[1] % FUZ_FACTOR)) * 100 +
                (points[0] - (points[0] % FUZ_FACTOR));
    }

    public int getIndex(int freq){
        int i = 0;
        while (RANGE[i] < freq)
            i++;
        return i;
    }
}
