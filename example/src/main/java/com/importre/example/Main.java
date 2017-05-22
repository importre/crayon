package com.importre.example;

import com.importre.crayon.Crayon;

public class Main {

    public static void main(String[] args) {
        String title = Crayon.red("= Crayon Examples\n");
        System.out.println(title);

        Utils.printDecorators();
        Utils.printColors();
        Utils.printBrightColors();
        Utils.printBackgroundColors();
        Utils.printBackgroundBrightColors();
        Utils.printCompositions();
    }
}
