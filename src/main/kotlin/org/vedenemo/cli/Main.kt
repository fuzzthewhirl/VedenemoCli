package org.vedenemo.cli

import kotlinx.coroutines.runBlocking
import java.util.Scanner

fun main() {
    println("🧠 Vedenemo CLI Interactive Mode")
    println("Type 'q' to quit.")
    println()

    val scanner = Scanner(System.`in`)

    while (true) {
        print("📝 > ")
        if (!scanner.hasNextLine()) {
            println("\nEOF reached or input closed. Exiting...")
            break
        }

        val line = scanner.nextLine()
        if (line.lowercase() == "q") break
        if (line.isNotBlank()) {
            println("\nline to send: $line\n")
            runBlocking {
                try {
                    val echoed = BackendClient.echo(line)
                    println("🔁 Echoed from backend: $echoed")
                } catch (e: Exception) {
                    println("❌ Failed to contact backend: ${e.message}")
                }
            }
        }
    }
}