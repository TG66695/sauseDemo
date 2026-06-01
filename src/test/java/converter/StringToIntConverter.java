package converter;

public class StringToIntConverter {

    public static Integer getIntFromString(String value) {
        return switch (value) {
            case "first" -> 1;
            case "second" -> 2;
            case "third" -> 3;
            case "fourth" -> 4;
            case "fifth" -> 5;
            case "sixth" -> 6;
            case "seventh" -> 7;
            case "eighth" -> 8;
            case "ninth" -> 9;
            case "tenth" -> 10;
            default -> Integer.parseInt(value);
        };
    }
}
