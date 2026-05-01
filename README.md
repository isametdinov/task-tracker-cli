# 🧾 Task Tracker CLI (Java)

A simple command-line application to manage tasks.
Built using Java (JDK 21) without external libraries.

---

## 🚀 Features

* Add tasks
* Update tasks
* Delete tasks
* Mark tasks as **in-progress** or **done**
* List all tasks
* Filter tasks by status

---

## 🛠️ Tech Stack

* Java 21
* File handling (JSON)
* CLI (Command Line Interface)

---

## 📁 Project Structure

```
src/main/java/com/tasktracker/
│── Main.java
│── Task.java
│── TaskManager.java
│── FileHandler.java
│── Utils.java

tasks.json (auto-created)
```

---

## ▶️ How to Run

### 1. Compile

```
javac -d out src/main/java/com/tasktracker/*.java
```

### 2. Run commands

```
java -cp out com.tasktracker.Main add "Buy milk"
java -cp out com.tasktracker.Main list
java -cp out com.tasktracker.Main mark-done 1
```

---

## 📌 Available Commands

```
add "task description"
update <id> "new description"
delete <id>
mark-in-progress <id>
mark-done <id>
list
list done
list todo
list in-progress
```

---

## 🧠 Notes

* Tasks are stored in a local `tasks.json` file
* JSON is handled manually (no external libraries)
* Designed for learning CLI + file handling in Java

---

## 📈 Future Improvements

* Better JSON parsing
* Table-style output
* CLI shortcut command (task-cli)
* Convert to REST API (Spring Boot)

---
project URL: https://github.com/isametdinov/task-tracker-cli.git
## 👨‍💻 Author
Isametdinov Muhammadboburbek
