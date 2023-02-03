package pro.sky.cw3.coursetask3.model;

import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;

public enum Size {
    SIZE_36(36),
    SIZE_38(38),
    SIZE_40(40),
    SIZE_42(42),
    SIZE_44_5(44.5F);

    private final float size;

    Size(float size) {
        this.size = size;
    }

    @JsonValue
    public float getSize() {

        return size;
    }
    @Nullable
    public static Size parse(float size) {
        for (Size s : values()) {
            if (Float.compare(s.size,size)==0) {
                return s;
            }
        }
        return null;
    }
}
