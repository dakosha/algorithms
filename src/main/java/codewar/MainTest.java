package codewar;

import java.io.UnsupportedEncodingException;

/**
 * @author Dauren Mussa
 * @since 3/21/17
 */
public class MainTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String data = "\u0414\u0435\u043c\u0430\u0440\u043a\u043e \u0422., \u041b\u0438\u0441\u0442\u0435\u0440 \u0422., \u041c\u0430\u043a\u043c\u0435\u043d\u0430\u043c\u0438\u043d \u0421. - \u0411\u0430\u043b\u0434\u0435\u044e\u0449\u0438\u0435 \u043e\u0442 \u0430\u0434\u0440\u0435\u043d\u0430\u043b\u0438\u043d\u0430 \u0438 \u0437\u043e\u043c\u0431\u0438\u0440\u043e\u0432\u0430\u043d\u043d\u044b\u0435 \u0448\u0430\u0431\u043b\u043e\u043d\u0430\u043c\u0438. \u041f\u0430\u0442\u0442\u0435\u0440\u043d\u044b \u043f\u043e\u0432\u0435\u0434\u0435\u043d\u0438\u044f \u043f\u0440\u043e\u0435\u043a\u0442\u043d\u044b\u0445 \u043a\u043e\u043c\u0430\u043d\u0434 (2010).docx";

        int length = data.getBytes("UTF-8").length;

        int documentumLength = calculateEncodedLength(data);

        System.out.println(length + " vs " + data.length() + " vs " + documentumLength);
    }

    public static int calculateMaximumAllowedChars(String value, int maximumAllowedBytes) {
        assert value != null;

        int lengthInBytes = 0;
        int lengthInChars = 0;
        int i = 0;

        for(int limit = value.length(); i < limit; ++i) {
            char charNum = value.charAt(i);
            if(charNum <= 127) {
                ++lengthInBytes;
            } else if(charNum <= 2047) {
                lengthInBytes += 2;
            } else {
                lengthInBytes += 3;
            }

            if(lengthInBytes > maximumAllowedBytes) {
                break;
            }

            ++lengthInChars;
        }

        return lengthInChars;
    }

    public static int calculateEncodedLength(String value) {
        assert value != null;

        int lengthInBytes = 0;
        int i = 0;

        for(int limit = value.length(); i < limit; ++i) {
            char charNum = value.charAt(i);
            if(charNum <= 127) {
                ++lengthInBytes;
            } else if(charNum <= 2047) {
                lengthInBytes += 2;
            } else if(isSurrogate(charNum)) {
                lengthInBytes += 2;
            } else {
                lengthInBytes += 3;
            }
        }

        return lengthInBytes;
    }

    public static boolean isSurrogate(int c) {
        return '\ud800' <= c && c <= '\udfff';
    }

}
