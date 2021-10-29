package javaMiscellaneous.others;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Random;

public class RandomStringGenerator {

    public static void GeneratingRandomStringUnbounded_thenCorrect() {

        for(int j=0; j <5; j++) {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();
            StringBuilder buffer = new StringBuilder(targetStringLength);
            for (int i = 0; i < targetStringLength; i++) {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                buffer.append((char) randomLimitedInt);
            }
            String generatedString = buffer.toString();

            System.out.println(generatedString);
        }
    }
    public static void main(String[] args) throws IOException {
        GeneratingRandomStringUnbounded_thenCorrect();
    }
}

