package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Dauren Mussa
 * @since 1/30/18
 */
public class ShuffleDeck {

    public static String[] cardName = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
    public static String[] cardLogo = {"♠", "♣", "♦", "♥"};

    public static void main(String[] args) {
        String[] cards = generateDeckInitial();

        /*HashMap<Short, Integer> map = new HashMap<>();

        Random rnd = new Random();

        for (int i=0; i<100000000; i++) {
            short index = (short) rnd.nextInt(6);
            map.put(index, map.get(index) == null ? 1 : map.get(index)+1);
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Map.Entry<Short, Integer> entry : map.entrySet()) {
            System.out.println("Number: "+ entry.getKey() + "; Count: "+entry.getValue());
            if (entry.getValue() < min) {
                min = entry.getValue();
            }
            else if (entry.getValue() > max) {
                max = entry.getValue();
            }
        }

        System.out.println(min);
        System.out.println(max);
        System.out.println(max - min);*/

        printDeck(cards);
        shuffleCards(cards);
        printDeck(cards);

        /*for (int i = 0; i < 20; i++) {
            String[] res = shuffle(cards);
            printDeck(res);
        }*/
    }

    public static void shuffleCards(String[] cards) {
        Random random = new Random();
        for (int i = 0; i < cards.length; i++) {
            int rand = random.nextInt(cards.length);
            String temp = cards[rand];
            cards[rand] = cards[i];
            cards[i] = temp;
        }
    }

    public static void printDeck(String[] cards) {
        for (String value : cards) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static String[] generateDeckInitial() {
        String[] result = new String[cardLogo.length * cardName.length];
        for (int i = 0; i < cardLogo.length; i++) {
            for (int j = 0; j < cardName.length; j++) {
                int index = i * cardName.length + j;
                result[index] = cardName[j] + cardLogo[i];
            }
        }
        return result;
    }

    public static String[] shuffle(String[] cards) {
        List<String> list = new ArrayList();
        for (int i = 0; i < cards.length; i++) {
            list.add(cards[i]);
        }
        String[] result = new String[cards.length];
        Random rnd = new Random();
        int index = 0;

        for (int i = 0; i < result.length; i++) {
            int randIndex = rnd.nextInt(list.size());
            result[i] = list.get(randIndex);
            list.remove(randIndex);
        }

        return result;
    }

}
