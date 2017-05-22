@file:JvmName("Utils")

package com.importre.example

import com.importre.crayon.*

fun printDecorators() {
    println(listOf(
        "bold".bold(),
        "italic".italic(),
        "underline".underline(),
        "reversed".reversed()
    ).joinToString(" "))
}

fun printColors() {
    println(listOf(
        "black".black(),
        "blue".blue(),
        "cyan".cyan(),
        "green".green(),
        "magenta".magenta(),
        "red".red(),
        "white".white(),
        "yellow".yellow()
    ).joinToString(" "))
}

fun printBrightColors() {
    println(listOf(
        "brightBlack".brightBlack(),
        "brightBlue".brightBlue(),
        "brightCyan".brightCyan(),
        "brightGreen".brightGreen(),
        "brightMagenta".brightMagenta(),
        "brightRed".brightRed(),
        "brightWhite".brightWhite(),
        "brightYellow".brightYellow()
    ).joinToString(" "))
}

fun printBackgroundColors() {
    println(listOf(
        "bgBlack".bgBlack(),
        "bgBlue".bgBlue(),
        "bgCyan".bgCyan(),
        "bgGreen".bgGreen(),
        "bgMagenta".bgMagenta(),
        "bgRed".bgRed(),
        "bgWhite".bgWhite(),
        "bgYellow".bgYellow()
    ).joinToString(" "))
}

fun printBackgroundBrightColors() {
    println(listOf(
        "bgBrightBlack".bgBrightBlack(),
        "bgBrightBlue".bgBrightBlue(),
        "bgBrightCyan".bgBrightCyan(),
        "bgBrightGreen".bgBrightGreen(),
        "bgBrightMagenta".bgBrightMagenta(),
        "bgBrightRed".bgBrightRed(),
        "bgBrightWhite".bgBrightWhite(),
        "bgBrightYellow".bgBrightYellow()
    ).joinToString(" "))
}

fun printCompositions() {
    println(listOf(
        "red & bgGreen".red().bgGreen()
    ).joinToString(" "))
}
