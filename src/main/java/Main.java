
import java.io.IOException;

public class Main {

    private static final char CHARACTER_IN_SEQUENCE = '0';

    private static int findLongestSequenceLength(String input, char characterInSequence) {
        int currentSequenceLength=0;
        int longestSequenceLength=0;
        for (char currentCharacter: input.toCharArray()) {
            if (currentCharacter == characterInSequence) {
                currentSequenceLength++;
            } else {
                if (currentSequenceLength > longestSequenceLength) {
                    longestSequenceLength = currentSequenceLength;
                }
                currentSequenceLength = 0;
            }
        }

        String Array[]=input.split("");
        for (String aArray : Array) {
            if (aArray.equals("0")) {
                currentSequenceLength++;
            } else {
                if (currentSequenceLength > longestSequenceLength) {
                    longestSequenceLength = currentSequenceLength;
                }
                currentSequenceLength = 0;
            }
        }
        return longestSequenceLength;
    }

    public static void main(String[] args) {
        try {
            String input = FileDao.readOneLineFromFile();
            Integer result = findLongestSequenceLength(input,CHARACTER_IN_SEQUENCE);
            FileDao.writeStringToFile(result.toString());
        } catch (IOException | NullPointerException e) {
            System.err.println(e.toString());
        }

    }
}
