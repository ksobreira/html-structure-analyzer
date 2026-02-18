# Html-structure-analyzer
A Java-based HTML structure analyzer that identifies the deepest nested text element using a Stack data structure.
## Overview
This solution was developed as a technical challenge, focusing on algorithm efficiency and adherence to core Java principles without the use of external libraries. It implements a stack-based parsing strategy to handle hierarchical data structures.

## Requirements
* **Java JDK 17**
* Active internet connection for URL content fetching.

## Technical Implementation Details
* Data Retrieval: Uses BufferedReader and InputStreamReader to read the URL stream line by line.
* Structural Validation: A Stack<String> monitors tag nesting. If a closing tag does not match the last opened tag, the system identifies it as malformed HTML.
* Attribute Handling: The parser isolates tag names from attributes using the split method.
* Depth Tracking: The "depth" is defined by the stack size at the moment a text element is read. Only the element at the maxDepth is stored and displayed.


## 1. Compilation
In accordance with the project requirements, use the following command to compile the source code from the root directory open your terminal in the root directory:

```bash
javac HtmlAnalyzer.java
````

## 2. Execution
To compile the source code, open your terminal in the root directory and run:

```bash
java HtmlAnalyzer http://hiring.axreng.com/internship/example1.html
```

Developed by: Kauam Sobreira