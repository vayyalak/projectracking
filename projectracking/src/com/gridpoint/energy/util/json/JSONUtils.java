package com.gridpoint.energy.util.json;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * A simple string cleaner to remove comments and extra space from JSON streams
 * 
 * @author mrochon
 *
 */
public class JSONUtils {
	
	public static final Pattern commentPattern = Pattern.compile("(\\/\\/|##)");
	public static final Pattern whitespacePattern = Pattern.compile("[\\s]{2,}");

	public static String clean(String json) {
		return clean(json,true);
	}

    /**
     * This was originally implemented to help with the config.vm stuffs
     *
     * @param json to be cleaned
     * @param cleanWhiteSpace  this tells us if we should clean out the white space also
     * @return the scrubbed JSON
     */

    public static String clean(String json,boolean cleanWhiteSpace) {

		StringBuffer str = new StringBuffer();

		Scanner scanner = new Scanner(json);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			Matcher commentMatcher = commentPattern.matcher(line);

			//remove from the comment to the end of the line
			if (commentMatcher.find()) {
				int index = commentMatcher.start();
				line = line.substring(0, index);
			}

			//remove extra whitespace
			if(cleanWhiteSpace){
                Matcher whitespaceMatcher = whitespacePattern.matcher(line);
			    line = whitespaceMatcher.replaceAll("");
            }
			str.append(line);

		}

		return str.toString();
	}
}
