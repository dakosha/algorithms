package olimp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author Dauren Mussa
 * @since 6/9/17
 */

@RunWith(JUnit4.class)
public class ExtensionAppenderTest {

    private static Set<String> extensions = new TreeSet<>();

    static {
        extensions.add("txt");
        extensions.add("doc");
        extensions.add("acc");
        extensions.add("mp3");
    }

    String withExtension = "Should extension be appended.txt";
    String withExtensionCheck = "Should extension be appended.txt";

    String withoutExtension = "Should extension be appended";
    String withoutExtensionCheck = "Should extension be appended\u200B.txt";

    String withExtensionAndSymbol = "Should extension be appended\u200B.txt";
    String withExtensionAndSymbolCheck = "Should extension be appended\u200B\u200B.txt";

    String withSymbol = "Should extension be appended\u200B";
    String withSymbolCheck = "Should extension be appended\u200B\u200B\u200B.txt";

    String withExtensionAndSymbols = "Shoul\u200Bd extension be appended\u200B\u200B.txt";
    String withExtensionAndSymbolsCheck = "Shoul\u200B\u200Bd extension be appended\u200B\u200B\u200B\u200B.txt";

    String withSymbols = "Should \u200B\u200Bextension be appended\u200B\u200B\u200B";
    String withSymbolsCheck = "Should \u200B\u200B\u200B\u200Bextension be appended\u200B\u200B\u200B\u200B\u200B\u200B\u200B.txt";

    String noName = ".txt";
    String noNameCheck = ".txt";

    String noNameNoExtension = "";
    String noNameNoExtensionCheck = "\u200B.txt";

    String nameFullOfZeros = "\u200B\u200B\u200B\u200B\u200B";
    String nameFullOfZerosCheck = "\u200B\u200B\u200B\u200B\u200B\u200B\u200B\u200B\u200B\u200B\u200B.txt";

    private ExtensionAppender appender = new ExtensionAppender(extensions);

    @Test
    public void testShouldExtensionBeAppended() {
        assert appender.appendExtension(withExtension, "txt").equals(withExtensionCheck);
        assert appender.appendExtension(withoutExtension, "txt").equals(withoutExtensionCheck);
        assert appender.appendExtension(withExtensionAndSymbol, "txt").equals(withExtensionAndSymbolCheck);
        assert appender.appendExtension(withSymbol, "txt").equals(withSymbolCheck);
        assert appender.appendExtension(withExtensionAndSymbols, "txt").equals(withExtensionAndSymbolsCheck);
        assert appender.appendExtension(withSymbols, "txt").equals(withSymbolsCheck);
        assert appender.appendExtension(noName, "txt").equals(noNameCheck);
        assert appender.appendExtension(noNameNoExtension, "txt").equals(noNameNoExtensionCheck);
        assert appender.appendExtension(nameFullOfZeros, "txt").equals(nameFullOfZerosCheck);

    }

    @Test
    public void testShouldExtensionBeRemoved() {
        assert appender.removeExtension(withExtensionCheck).equals(withExtension);
        assert appender.removeExtension(withoutExtensionCheck).equals(withoutExtension);
        assert appender.removeExtension(withExtensionAndSymbolCheck).equals(withExtensionAndSymbol);
        assert appender.removeExtension(withSymbolCheck).equals(withSymbol);
        assert appender.removeExtension(withExtensionAndSymbolsCheck).equals(withExtensionAndSymbols);
        assert appender.removeExtension(withSymbolsCheck).equals(withSymbols);
        assert appender.removeExtension(noNameCheck).equals(noName);
        assert appender.removeExtension(noNameNoExtensionCheck).equals(noNameNoExtension);
        assert appender.removeExtension(nameFullOfZerosCheck).equals(nameFullOfZeros);
    }

}
