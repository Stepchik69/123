public class ReverseString {
    public static String reverseString(String s) {
        // Базовый случай
        if (s.length() <= 1) {
            return s;
        }
        // Рекурсивный случай
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }

    public static void main(String[] args) {
        String input = "Пример";
        String result = reverseString(input);
        System.out.println("Исходная строка: " + input);
        System.out.println("Перевернутая строка: " + result);
    }
}
