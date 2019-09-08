package com.huaze.shen;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Huaze Shen
 * @date 2019-09-07
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> results = new ArrayList<>();
        if (words == null || words.length == 0) {
            return results;
        }
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            while (j < words.length && len + words[j].length() + j - i <= maxWidth) {
                len += words[j].length();
                j += 1;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int remainingSpace = maxWidth - len;
            for (int k = i; k < j; k++) {
                stringBuilder.append(words[k]);
                if (remainingSpace > 0) {
                    int currentSpace;
                    if (j == words.length) {
                        if (j - k > 1) {
                            currentSpace = 1;
                        } else {
                            currentSpace = remainingSpace;
                        }
                    } else {
                        if (j - k > 1) {
                            if (remainingSpace % (j - k - 1) == 0) {
                                currentSpace = remainingSpace / (j - k - 1);
                            } else {
                                currentSpace = remainingSpace / (j - k - 1) + 1;
                            }
                        } else {
                            currentSpace = remainingSpace;
                        }
                    }
                    for (int m = 0; m < currentSpace; m++) {
                        stringBuilder.append(" ");
                    }
                    remainingSpace -= currentSpace;
                }
            }
            results.add(stringBuilder.toString());
            i = j;
        }
        return results;
    }

    public static void main(String[] args) {
        //String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        //String[] words = {"What", "must", "be", "acknowledgment", "shall", "be"};
        String[] words = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        //int maxWidth = 16;
        int maxWidth = 20;
        List<String> results = new TextJustification().fullJustify(words, maxWidth);
        for (String line: results) {
            System.out.println("\"" + line + "\"");
        }
    }
}
