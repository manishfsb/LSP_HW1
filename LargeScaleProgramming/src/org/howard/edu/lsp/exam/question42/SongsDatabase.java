package org.howard.edu.lsp.exam.question42;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SongsDatabase {
	
	private Map<String, Set<String>> map = new HashMap<String, Set<String>>();
			
	/* Add a song title to a genre */
	public void addSong(String genre, String songTitle) {
		if (!map.containsKey(genre)) {
			Set <String> newSongSet = new HashSet<>(); 
			newSongSet.add(songTitle);
			map.put(genre, newSongSet);
		}
		
		else {
			map.get(genre).add(songTitle);
		}
	}
   
	/* Return the Set that contains all songs for a genre */
	public Set<String> getSongs(String genre) {
    	if (map.containsKey(genre)){
    		return map.get(genre);
    	}
    	
    	else {
    		Set <String> emptySongSet = new HashSet<>();
    		return emptySongSet;
    	}
	}

	/* Return genre, i.e., jazz, given a song title */
	public String getGenreOfSong(String songTitle) {
		for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
			if (entry.getValue().contains(songTitle)){
				return entry.getKey();
			}

		}
		String notFound = "Song not found in our records";
		return notFound;
		
			
	}

}
