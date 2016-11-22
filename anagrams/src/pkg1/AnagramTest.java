package pkg1;

import static org.junit.Assert.*;

import org.junit.Test;

public class AnagramTest {

	@Test
	public void testIsAnagram() {
		Anagram anagram = new Anagram();
		String str1= "asdf";
		String str2 = "fsda";
		boolean isAnagram = anagram.isAnagram(str1, str2);
		assertTrue(isAnagram);
	}

}
