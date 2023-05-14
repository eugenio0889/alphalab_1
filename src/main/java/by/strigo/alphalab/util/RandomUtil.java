package by.strigo.alphalab.util;

import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

@UtilityClass
public class RandomUtil {

    public static String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(10);
    }

    public static Long generateRandomLong() {
        return RandomUtils.nextLong();
    }

}
