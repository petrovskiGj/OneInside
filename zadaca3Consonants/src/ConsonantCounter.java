 public class ConsonantCounter {
     public static int countConsonants(String line) {
        if (line.isEmpty()) {
             return 0;
        }

        char ch = line.charAt(0);

        if (isConsonant(ch)) {
             return countConsonants(line.substring(1))+1;
        } else {
             return countConsonants(line.substring(1));
        }
    }

    public static boolean isConsonant(char a) {
         a = Character.toLowerCase(a);
         return Character.isLetter(a) && !isVowel(a);
    }

    public static boolean isVowel(char a) {
        a = Character.toLowerCase(a);
         return a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u';
    }
    public static void main(String[] args) {
        String line1 = "aeiou";
        String line2 = "ManchesterUnited";
         String line3 = "BMW";

         System.out.println("Consonants in '" + line1 + "': " + countConsonants(line1));
        System.out.println("Consonants in '" + line2 + "': " + countConsonants(line2));
        System.out.println("Consonants in '" + line3 + "': " + countConsonants(line3));
    }
}
