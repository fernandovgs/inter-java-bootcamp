package br.com.digital.innovation.one;

public class StringIsBlankExample {
    public static void main(String[] args) {
        String space = "                                    ";

        System.out.println(space == null || space.length() == 0 || space.chars()
                .allMatch(c -> c == ' ')
        );
        System.out.println(space.isBlank());
    }
}
