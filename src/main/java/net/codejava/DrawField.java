package net.codejava;

import lombok.Data;

@Data
public class DrawField {

    // desc of operation performed
    private String request = "hello world";

    // size of bg repeating image
    private int bgXpx = 1500;
    private int bgYpx = 1500;

    // size of box drawn onto bg
    private int yft = 0;
    private int xft = 0;

    private String filename = DrawFieldService.IMAGE_FILE_NAME;
}
