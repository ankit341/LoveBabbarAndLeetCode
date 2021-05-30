package problemsolving.LeetCodeMarchChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Day15_TinyUrl {

    private static final String BASE_URL = "http://tinyurl.com/";
    Map<String, String> longToShortUrl;
    {
        longToShortUrl = new HashMap<String, String>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String generatedString = this.randomStringGenerator();
        String generatedUrl = BASE_URL+generatedString;
        this.longToShortUrl.put(generatedUrl, longUrl);
        return generatedUrl;
    }



    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (this.longToShortUrl.containsKey(shortUrl)) {
            return this.longToShortUrl.get(shortUrl);
        }

        return "longUrl not registered";
    }

    public String randomStringGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();



        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        if (!this.longToShortUrl.containsKey(generatedString)) {
            return generatedString;
        }
        return randomStringGenerator();
    }

    public static void main(String[] args) {
        Day15_TinyUrl newUrl = new Day15_TinyUrl();

        String shortUrl = newUrl.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(shortUrl);

        String longUrl = newUrl.decode(shortUrl);
        System.out.println(longUrl);
        
    }
}
