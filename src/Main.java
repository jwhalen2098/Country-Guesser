import java.time.LocalDate;

public class Main {

    static Countries data = new Countries();
    static int index = getIndexFor(LocalDate.now(), data.countryNames.length);
    static String correctAnswer = data.countryNames[index].toLowerCase();

    public static void main(String[] args) {

        IO.println("Today's puzzle index: " + index);
        IO.println("Hint 1 (continent): " + data.continents[index]);
        if (check(IO.readln())) {
            IO.println("Correct!");
            return;
        }
        IO.println("Incorrect, next hint");

        IO.println("Hint 2 (population): " + data.countryPops[index]);
        if (check(IO.readln())) {
            IO.println("Correct!");
            return;
        }
        IO.println("Incorrect, next hint");

        IO.println("Hint 3 (landmark): " + data.landmarks[index]);
        if (check(IO.readln())) {
            IO.println("Correct!");
        } else {
            IO.println("Incorrect, you failed! The answer was " + data.countryNames[index]);
        }
    }

    static int getIndexFor(LocalDate date, int size) {
        return (int) (date.toEpochDay() % size);
    }

    static boolean check(String guess) {
        return guess.trim().toLowerCase().equals(correctAnswer);
    }
}