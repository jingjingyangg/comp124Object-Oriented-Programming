package edu.macalester.comp124.music;

import acm.program.ConsoleProgram;

/**
 * Searches the "iTunes Music Library.xml" file for a query.
 */
public class MusicSearcher extends ConsoleProgram {
	public static final String PATH = "124-itunes/res/iTunes Music Library.xml";
	private static final String STOP = "stop";


	private void summarize(){
		ITunesReader reader = new ITunesReader(PATH);
		int count = 0;
		while (true){
			Song song = reader.readNextSong();
			if (song==null) break;
			count ++;
			if (song.getCount()>=100){
				println(song);
			}
		}
		println(count);
	}

	private void search(String query){
		ITunesReader reader = new ITunesReader(PATH);
		while (true){
			Song song = reader.readNextSong();
			if (song==null) break;
			if (song.matchesQuery(query)){
				println(song);
			}
		}
	}

	public void run() {
		summarize();
		while (true){
			String query = readLine("Enter search entry, or 'stop' to stop: ");
			if (query.equals(STOP)) break;
			search(query);
			println();
		}

	}
}
