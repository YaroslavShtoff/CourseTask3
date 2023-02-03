package pro.sky.cw3.coursetask3.model;

import org.springframework.lang.Nullable;

public enum Color {

    RED,
    GREEN,
    YELLOW,
    BLUE,
    BLACK;

    @Nullable
    public static Color parse(String color) {
        for (Color c : values()) {
            if (c.name().equals(color)) {
                return c;
            }
        }
        return null;
    }

}
