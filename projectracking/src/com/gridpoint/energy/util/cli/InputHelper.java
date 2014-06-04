package com.gridpoint.energy.util.cli;

import java.io.InputStream;
import java.io.IOException;

public class InputHelper {
    /**
     * Prompt the user for for a selection choice.
     *
     * @param message the message to prompt the user with.
     * @param options the options to present to the user.
     * @param selected zero based index of selected option, or -1 for no default selection.
     * @param offset the numbering offset, usually one or zero.
     * @param size the number of options to present to the user at a time.
     *
     * @exception IOException thrown if user input could not be read.
     */
    public static int selectOption(String message, String[] options, int selected, int offset, int size) throws IOException {
        return selectOption(System.in, message, options, selected, offset, size);
    }

    public static int selectOption(InputStream in, String message, String[] options, int selected, int offset, int size) throws IOException {
        int start = 0;
        int end = options.length;

        int idx = -1;
        while (end - start > size) {
            int n = (end - start + size - 1) / size;
            String[] buffer = new String[(end - start + n - 1) / n];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = options[start + i * n] + "-" + options[Math.min(end, start + (i + 1) * n) - 1];
            }
            
            int index = selectOption(in, message, buffer, (selected - start) / n, offset, size);
            
            start += index * n;
            end = Math.min(end, start + n);
        }

        int selection = -1;
        while (selection < 0 || selection > options.length) {
            // print out the options
            System.out.printf("%s [%s]:\n", message, (selected >= 0 && selected <= options.length) ? options[selected] : "");
            for (int i = start; i < end; i++) {
                System.out.println("" + (i - start + offset) + ") " + options[i]);
            }

            selection = readInput(in, selected - start) - offset;
        }
        return selection + start;

    }

    /**
     * Read a line of input from the user.  If the user does not
     * provide any import, the given default value will be returned.
     *
     * @param value default selection if user provides no input.
     * @return the selection made by the user.
     *
     * @exception IOException thrown if the input from the user
     * cannot be read.
     */
    private static int readInput(InputStream in, int value) throws IOException {
        StringBuffer buffer = new StringBuffer();

        int c;
        while(true) {
            switch(c = in.read()) {
            case '\r':
                break;
            case -1:
            case '\n':
                try {
                    return (buffer.length() == 0) ? value : Integer.parseInt(buffer.toString());
                } catch (Exception ex) {
                    return -1;
                }
            default:
                buffer.append((char)c);
            }
        }
    }

}