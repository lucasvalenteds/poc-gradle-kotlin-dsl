# POC: Gradle Kotlin DSL

A Gradle script based on Kotlin DSL demonstrating how to automate the creation of a `.zip` file with files from a directory.

Some of the concepts involved in the sample includes tasks (registration, dependencies, types), Gradle properties manipulation and the usage of Gradle Wrapper.

| Description | Command |
| :--- | :--- |
| Run the script | `./gradlew run` |

## Output

```
> Task :deleteMessagesZipFile
Deleting file messages-compressed.zip

> Task :printProperties
Source: messages
Target: messages-compressed.zip

> Task :zipMessages
Creating file "task ':zipMessages' property 'archiveFileName'"

> Task :listMessages
goodbye.txt
hello-world.txt

> Task :inspectMessagesZip
Archive:  messages-compressed.zip
  Length      Date    Time    Name
---------  ---------- -----   ----
        7  2020-04-19 00:31   goodbye.txt
       12  2020-04-19 00:31   hello-world.txt
---------                     -------
       19                     2 files

BUILD SUCCESSFUL in 678ms
5 actionable tasks: 5 executed
```
