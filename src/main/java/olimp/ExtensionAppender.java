package olimp;

import java.util.Set;

/**
 * @author Dauren Mussa
 * @since 6/9/17
 */
public class ExtensionAppender {

    final protected char zeroWidthCharacter = '\u200B';
    final protected char extensionDot = '.';

    final private Set<String> extensions;

    public ExtensionAppender(Set<String> extensions) {
        this.extensions = extensions;
    }

    public String removeExtension(String fileName) {
        final int lastIndex = fileName.lastIndexOf(extensionDot);
        if (lastIndex >= 0) {
            //Has some extension
            final String extension = fileName.substring(lastIndex + 1, fileName.length());
            if (extensions.contains(extension)) {
                final String fileNameWithoutExtension = fileName.substring(0, lastIndex);
                final int lastZeroSymbolsCount = countLastZeroWidthSymbols(fileNameWithoutExtension);
                if (lastZeroSymbolsCount % 2 == 0) {
                    return unEscapeZeroWidthSymbol(fileNameWithoutExtension) + this.extensionDot + extension;
                } else {
                    return unEscapeZeroWidthSymbol(fileNameWithoutExtension.substring(0, fileNameWithoutExtension.length() - 1));
                }
            }
        }
        //return the same name cause we did nothing with this file
        return fileName;
    }


    public String appendExtension(String fileName, String extensionToAppend) {
        final int lastIndex = fileName.lastIndexOf(extensionDot);
        if (lastIndex >= 0) {
            //Has some extension
            final String extension = fileName.substring(lastIndex + 1, fileName.length());
            if (extensions.contains(extension)) {
                //Extension is known
                return escapeZeroWidthSymbol(fileName);
            } else {
                //Extension is unknown
                return escapeZeroWidthSymbol(fileName) + this.zeroWidthCharacter + this.extensionDot + extensionToAppend;
            }
        } else {
            //There is no extension at all
            return escapeZeroWidthSymbol(fileName) + this.zeroWidthCharacter + this.extensionDot + extensionToAppend;
        }
    }

    private int countLastZeroWidthSymbols(String fileName) {
        char symbol;
        if (fileName.length() == 0)
            return 0;
        int index = fileName.length();
        int result = 0;
        while ((symbol = fileName.charAt(--index)) == this.zeroWidthCharacter) {
            result++;
            if (index == 0) break;
        }
        return result;
    }

    private String unEscapeZeroWidthSymbol(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fileName.length(); i++) {
            char symbol = fileName.charAt(i);
            stringBuilder.append(symbol);
            if (symbol == this.zeroWidthCharacter) {
                i++;
            }
        }
        return stringBuilder.toString();
    }

    private String escapeZeroWidthSymbol(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < fileName.length(); i++) {
            char symbol = fileName.charAt(i);
            stringBuilder.append(symbol);
            if (symbol == this.zeroWidthCharacter) {
                stringBuilder.append(symbol);
            }
        }
        return stringBuilder.toString();
    }

}
