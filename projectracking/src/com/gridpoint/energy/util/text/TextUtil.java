package com.gridpoint.energy.util.text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextUtil {

    private static final Pattern pattern = Pattern.compile("(^(?:\\\\\\\\)*|.*?[^\\\\](?:\\\\\\\\)*|(?<=})(?:\\\\\\\\)*)\\$\\{([a-zA-Z0-9.]+)\\}");

    public static String substitute(String line, Variables variables) {
        Matcher matcher = pattern.matcher(line);

        StringBuilder buffer = new StringBuilder();
        int index = 0;

        while (matcher.find(index)) {
            // Find prefix, preceding ${var} construct
            String prefix = matcher.group(1);
            buffer.append(prefix);
            
            // Retrieve value of variable
            String key = matcher.group(2);
            String value = variables.get(key);
            buffer.append(value);
            
            // Update index
            index = matcher.end();
        }
            
        // Append final segment of the string
        buffer.append(line.substring(index));

        return buffer.toString();
    }

    /**
     * Removes the token prefix, if present, from a premises reference ID.
     * @param token the tokenized reference ID, e.g. "ADM_TOKEN:XXX1234"
     * @return the decoded site ID without the initial token
     * @deprecated Use premises.legacy_site_id
     */
    // scartwright: I have deprecated this method as it results in frequently sending non-ADM site IDs to the ADMMicro Site Service.
    @Deprecated
    public static String getReferenceIdFromPremisesToken(String token) {
        String [] split = token.split(":");
        return split.length == 2 ? split[1] : split[0];
    }
    
    public static Long getChannelIdFromChannelWithValue(String token) {
        int index = findFirstLetterIndex(token);
        return Long.valueOf(token.substring(0, index));
    }
    
    public static String getTupleFromChannelWithValue(String token) {
        int index = findFirstLetterIndex(token);
        return token.substring(index, token.length());
    }
    
    private static int findFirstLetterIndex(String token) {
        int index = 0;
        for(; index < token.length(); index++) {
            if(Character.isLetter(token.charAt(index))) {
                break;
            }
        }
        return index;
    }
    

    /**
     * remove characters for Jasper that can fail for field lists
     * @param input
     * @return
     */
    public static String sanitateJasperInput(String input) {
        return input.replaceAll("[\\.\\&\"<>']", "");
    }
}
