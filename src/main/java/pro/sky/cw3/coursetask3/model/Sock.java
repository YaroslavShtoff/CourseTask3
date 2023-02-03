package pro.sky.cw3.coursetask3.model;

import lombok.*;

@NoArgsConstructor
@Data
public class Sock {
    private Size size;

    private Color color;

    private int cottonPart;


    public Sock(Size size,
                    Color color,
                    int cottonPart) {
        this.size = size;
        this.color = color;
        this.cottonPart = cottonPart;

    }



}
