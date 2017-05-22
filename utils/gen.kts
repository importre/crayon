#!/usr/bin/env kotlinc -script

import java.io.File

val reset = listOf("reset" to "\\u001b[0m")

val deco = listOf(
    "bold" to "\\u001b[1m",
    "italic" to "\\u001b[3m",
    "underline" to "\\u001b[4m",
    "reversed" to "\\u001b[7m"
)

val colors = listOf(
    "black", "red", "green", "yellow",
    "blue", "magenta", "cyan", "white"
)

fun default(background: Boolean, bright: Boolean) = colors
    .mapIndexed { index, color ->
        val num = index + if (background) 40 else 30
        val postfix = if (bright) ";1m" else "m"
        val name = if (background) {
            (if (bright) "bgBright" else "bg") + color.capitalize()
        } else {
            if (bright) "bright" + color.capitalize() else color
        }
        name to "\\u001b[$num$postfix"
    }
    .sortedBy { it.first }

val crayonMap = (reset + deco +
    default(false, false) +
    default(false, true) +
    default(true, false) +
    default(true, true))
    .associate { it.first to it.second }

val raw = """
fun String.raw(): String {
    val regex = Regex("(?:\u001b)(\\[\\d+(?:;1)?m(?:.+?))(?:\u001b)(\\[0m)")
    return replace(regex, "\\\\u001b$1\\\\u001b$2")
}
""".trim()

val ansi = listOf(
    "@file:JvmName(\"Ansi\")", "",
    "package com.importre.crayon", "",
    raw, "") + crayonMap
    .map { (name, code) -> "const val $name = \"$code\"" }

val crayon = listOf(
    "@file:JvmName(\"Crayon\")", "",
    "package com.importre.crayon", "") + crayonMap
    .filterNot { (k, _) -> k == "reset" }
    .map { (name, code) ->
        """
        fun String.$name() = "$code${'$'}{this}${reset.first().second}"
        """.trim()
    }

File("../src/main/kotlin/com/importre/crayon/Ansi.kt")
    .writeText(ansi.joinToString("\n"), Charsets.UTF_8)

File("../src/main/kotlin/com/importre/crayon/Crayon.kt")
    .writeText(crayon.joinToString("\n"), Charsets.UTF_8)
