import java.util.HashMap;
import java.util.Arrays;

/**
 * StammeringAliens
 */
public class StammeringAliens {

    public static void main(String[] args) {
        int m = 3;
        // String s = "baaaababababbababbab";
        String s = "";
        for(int i=0; i<40000; i++) {
            s += "a";
        }
        long start = System.currentTimeMillis();
        System.out.println(Arrays.toString(maxSubString(m, s)));
        System.out.println(System.currentTimeMillis()-start);
    }

    public static long hash(String s) {
        long rv = s.charAt(0)-97;
        for(int i=1; i<s.length(); i++) {
            rv = (rv * 26 + s.charAt(i)-97) % 354745078340568241L;
        }
        return rv;
    }

    public static long adjustedHash(long oldHash, char newChar, char oldChar, long multiplier) {
        long newHash = 26 * oldHash + (newChar-97);
        newHash = newHash - multiplier * (oldChar-97);
        newHash %= 354745078340568241L;
        return newHash;
    }

    public static int[] maxSubString(int m, String s) {
        int lastLength = 0;
        int lastStart = 0;
        int currentLength = s.length() / 2;
        int rangeStart = 1;
        int rangeEnd = s.length();
        while(rangeEnd >= rangeStart) {
            System.out.println(currentLength + " " + rangeStart + " " + rangeEnd);
            long multiplier = 1;
            for(int i=0; i<currentLength; i++) {
                multiplier = multiplier * 26 % 354745078340568241L;
            }
            HashMap<Long, Integer> counts = new HashMap<>();
            String substring = s.substring(0, 0+currentLength);
            long hashValue = hash(substring);
            counts.put(hashValue, 1);
            int topStart = 0;
            int topCount = 1;
            for(int i=1; i<=s.length()-currentLength; i++) {
                hashValue = adjustedHash(
                    hashValue,
                    s.charAt(i+currentLength-1),
                    s.charAt(i-1),
                    multiplier);
                counts.put(hashValue, counts.getOrDefault(hashValue, 0)+1);
                if(counts.get(hashValue) > topCount) {
                    topCount = counts.get(hashValue);
                    topStart = i;
                }
            }
            if(topCount >= m) {
                rangeStart = currentLength + 1;
                lastLength = currentLength;
                lastStart = topStart;
            } else {
                rangeEnd = currentLength - 1;
            }
            currentLength = (rangeEnd - rangeStart) / 2 + rangeStart;
        }
        int[] rv = new int[2];
        rv[0] = lastLength;
        rv[1] = lastStart;
        return rv;
    }


}