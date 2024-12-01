package com.honeybug.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.TaskAction
import org.gradle.process.ExecOperations
import java.io.ByteArrayOutputStream
import java.nio.charset.StandardCharsets
import javax.inject.Inject

abstract class GitCommitHashTask @Inject constructor(
    private val execOperations: ExecOperations
) : DefaultTask() {

    @get:OutputFile
    abstract val outputFile: RegularFileProperty

    init {
        outputFile.convention(project.layout.buildDirectory.file("git/git-commit-hash.txt"))
    }

    @TaskAction
    fun resolveGitCommitHash() {
        val stdout = ByteArrayOutputStream()
        execOperations.exec {
            commandLine("git", "rev-parse", "--short", "HEAD")
            standardOutput = stdout
        }
        val gitCommitHash = stdout.toString(StandardCharsets.UTF_8).trim()
        outputFile.get().asFile.parentFile.mkdirs()
        outputFile.get().asFile.writeText(gitCommitHash)

        println("Resolved Git Commit Hash: $gitCommitHash")
    }
}