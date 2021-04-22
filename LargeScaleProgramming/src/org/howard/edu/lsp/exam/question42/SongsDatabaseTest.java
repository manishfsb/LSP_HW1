package org.howard.edu.lsp.exam.question42;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SongsDatabaseTest {

	SongsDatabase database;
	Set<String> expectedSongList;
	
	@BeforeEach
	@DisplayName("Initializing a SongsDatabase object and the expectedSongList before each test")
	public void setUp() {
		database = new SongsDatabase();
		
		//we use this set to verify correctness of the returned set
		expectedSongList = new HashSet<>(); 
	}
	
	@Test
	@DisplayName("Testing addSong and getSongs() method") 
	void testAddandGet()
	{
		database.addSong("Rap", "Savage");
		database.addSong("Rap", "Gin and Juice");
		database.addSong("Rap", "Vten");
		
		database.addSong("Jazz", "Always there");
		database.addSong("Jazz", "Moon shines");
		database.addSong("Jazz", "In your pocket");
		
		database.addSong("Hip- Hop", "Random song");
		
		//checking to see if duplicate songs will be handled, since it is a set it should is verified in line 39 as only 1 entry of the song is in the list
		database.addSong("Jazz", "Always there");
		
		//testing if rap key value pairs were correctly added
		expectedSongList.add("Savage");
		expectedSongList.add("Gin and Juice");
		expectedSongList.add("Vten");
		assertEquals(database.getSongs("Rap"), expectedSongList);
		
		//testing if jazz key value pairs were correctly added
		expectedSongList.clear();
		expectedSongList.add("Always there");
		expectedSongList.add("Moon shines");
		expectedSongList.add("In your pocket");
		assertEquals(database.getSongs("Jazz"), expectedSongList);
		
		//since key 'Hip Hop' hasn't been added yet, this should return an empty set.
		expectedSongList.clear();
		assertEquals(database.getSongs("Hip Hop"), expectedSongList);
		
		
	}
	@Test
	@DisplayName("Testing getGenreofSong method") 
	void testGetGenre() {
		database.addSong("Rap", "Savage");
		database.addSong("Rap", "Gin and Juice");
		database.addSong("Rap", "Vten");
		
		database.addSong("Jazz", "Always there");
		database.addSong("Jazz", "Moon shines");
		database.addSong("Jazz", "In your pocket");
		
		database.addSong("Hip- Hop", "Random song");
		
		//looking for songs that have genres added to our database
		assertEquals(database.getGenreOfSong("Random song"), "Hip- Hop");
		assertEquals(database.getGenreOfSong("In your pocket"), "Jazz");
		assertEquals(database.getGenreOfSong("Moon shines"), "Jazz");
		assertEquals(database.getGenreOfSong("Savage"), "Rap");
		assertEquals(database.getGenreOfSong("Vten"), "Rap");
		
		//in case we search for song that hasn't been added to a genre yet
		assertEquals(database.getGenreOfSong("I'm not afraid"), "Song not found in our records");
	}
		
}
