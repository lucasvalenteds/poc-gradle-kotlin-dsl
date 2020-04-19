val sourceFolder: String by project
val targetFile: String by project

val printProperties by tasks.registering {
    doLast {
        println("Source: $sourceFolder")
        println("Target: $targetFile")
    }
}

val listMessages by tasks.registering {
    doLast {
        fileTree(sourceFolder)
            .filter(File::isFile)
            .map(File::name)
            .forEach(::println)
    }
}

val zipMessages by tasks.registering(Zip::class) {
    archiveFileName.set(targetFile)
    destinationDirectory.set(file("./"))
    from(files(sourceFolder))

    doFirst {
        println("Creating file \"$archiveFileName\"")
    }
}

val inspectMessagesZip by tasks.registering(Exec::class) {
    commandLine(listOf("unzip", "-l", targetFile))
}

val deleteMessagesZipFile by tasks.registering(Delete::class) {
    delete(targetFile)

    doFirst {
        println("Deleting file $targetFile")
    }
}

val processMessages by tasks.registering {
    dependsOn(printProperties)
    finalizedBy(listMessages, zipMessages, inspectMessagesZip)
    mustRunAfter(deleteMessagesZipFile)
}

tasks.register("run") {
    dependsOn(deleteMessagesZipFile)
    finalizedBy(processMessages)
}

