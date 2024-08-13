import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.math.BigInteger;

public class RansomNote {

    public static void main(String [] args) {
        System.out.printf("Hello Ransom Note Solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java RansomNote%n");
            return;
        }

//        String note = "ab";
//        String note = "aab";
        String note = "aaab";
        String magazine = "baa";
        
        RansomNote ransomNote = new RansomNote(note, magazine);

        boolean result = ransomNote.solution();

        if (result) {

            System.out.printf("the ransom note %s can be created from the magazine %s%n", note, magazine);

        } else {

            System.out.printf("the ransom note %s cannot be created from the magazine %s%n", note, magazine);

        }

    }

    private String note;
    private String magazine;

    public RansomNote(String note, String magazine) {

        this.note = note;
        this.magazine = magazine;

    }

    public boolean solution() {

        final List<Character> magazineList = 
            magazine.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toList());

        final Map<Character, Integer> magazineMap = new HashMap<>();

        // tabulate the count per character of the magazine
        magazineList.forEach(letter -> {
            magazineMap.put(letter, magazineMap.getOrDefault(letter, 0) + 1);
        });

        final List<Character> noteList =
            note.chars()
                .mapToObj(item -> (char) item)
                .collect(Collectors.toList());

        // analyze whether the ransom note can be created from the magazine
        final Set<Boolean> noMatch = new HashSet<>();
        noteList.forEach(letter -> {
            if (magazineMap.containsKey(letter)) {
                int previous = magazineMap.get(letter);
                previous--;
                if (previous == 0) {
                    magazineMap.remove(letter);
                } else {
                    magazineMap.put(letter, previous);
                }
            } else {
                noMatch.add(true);
            }
        });

        return magazineMap.isEmpty() && noMatch.isEmpty();
    }

}
