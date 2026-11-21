# Library Book Record Management System

Java file-handling lab that writes, displays, appends and searches book records by ID.

## Run
```bash
javac LibraryManagement.java
java LibraryManagement
```

## File format
`Library.txt` stores `ID,Title,Author,Status` rows. Sample records are retained.

## Important
Menu option **1 (Write)** replaces existing records; option **4 (Append)** preserves the file and adds records. Back up your data before choosing Write. Inputs are validated for positive IDs and nonempty comma-free text. Future improvements: reject duplicate IDs, support commas/quotes via a CSV library, and handle malformed records gracefully.
