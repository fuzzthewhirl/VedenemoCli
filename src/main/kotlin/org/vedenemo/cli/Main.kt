package org.vedenemo.cli

import java.util.Scanner

fun main() {
    println("🧠 Vedenemo CLI Interactive Mode")
    println("Type commands like:")
    println("  entity \"Person\" named \"Person\"")
    println("  \"Person\" addAttribute \"email\" ofType TEXT since 1.0")
    println("Type 'exit' to quit.")
    println()

    val scriptLines = mutableListOf<String>()
    val scanner = Scanner(System.`in`)

    while (true) {
        print("📝 > ")
        if (!scanner.hasNextLine()) {
            println("\nEOF reached or input closed. Exiting...")
            break
        }

        val line = scanner.nextLine()
        if (line.lowercase() == "exit") break
        if (line.isNotBlank()) {
            scriptLines.add(line)
        }
    }


    println("\n📜 DSL Script:")
    println(scriptLines.joinToString("\n"))

    // Future: Parse + send to backend or save as file
}