# Red-Black Tree Implementation in Java

## Overview

This project implements a **Red-Black Tree**, a self-balancing binary search tree that guarantees efficient operations.

The project includes:

* Full implementation of Red-Black Tree (Insert, Delete, Search)
* Tree visualization (console-based)
* Performance comparison with Binary Search Tree (BST)
* Experimental analysis using large datasets
* Test cases and demo execution

---

## Objectives

* Implement a self-balancing tree structure
* Ensure **O(log n)** time complexity for operations
* Compare performance with an unbalanced BST
* Demonstrate correctness through testing and visualization

---

## Red-Black Tree Properties

1. Every node is either **Red or Black**
2. The root is always **Black**
3. No two consecutive **Red nodes**
4. Every path from root to leaf has the same number of **Black nodes**

---

## Features

### Core Operations

* Insert with balancing
* Delete with fix-up
* Search
* Inorder traversal
* Height calculation

### Visualization

* Console-based tree structure
* Shows node values with colors:

  * `(R)` → Red
  * `(B)` → Black
  * `N` → Null node

### Experiments

* Dataset sizes: **1000, 5000, 10000**
* Measures:

  * Insertion time
  * Tree height
* Comparison:

  * Red-Black Tree vs Binary Search Tree (BST)

---

## Project Structure

```
RedBlackTreeProject/
└── src/
    └── redblacktreeproject/
        ├── Node.java
        ├── RedBlackTree.java
        ├── TreeVisualizer.java
        ├── BST.java
        ├── ExperimentRunner.java
        ├── Demo.java
        └── TestCases.java
```

---

## How to Run

### Compile

```
javac *.java
```

### Run Experiments (Main Execution)

```
java redblacktreeproject.ExperimentRunner
```

### Run Demo (Visualization)

```
java redblacktreeproject.Demo
```

### Run Test Cases

```
java redblacktreeproject.TestCases
```

---

## Sample Output

```
Inserted: 10
10(B)

Inserted: 20
10(B)
N 20(R)

Inserted: 30
20(B)
10(R) 30(R)
```

---

## Complexity Analysis

| Operation | Time Complexity |
| --------- | --------------- |
| Search    | O(log n)        |
| Insert    | O(log n)        |
| Delete    | O(log n)        |

---

## Experimental Results 

* Red-Black Tree maintains **balanced height**
* BST becomes skewed for ordered input
* Red-Black Tree performs consistently better for large datasets

---

## Testing

Includes:

* Insert validation
* Search verification
* Delete operation testing
* Edge case handling

---

## Generative AI Usage

AI tools were used to:

* Understand balancing logic and rotations
* Generate initial code structure
* Assist in debugging

All outputs were:

* Reviewed manually
* Tested with custom datasets
* Validated against expected behavior

---

## Notes

* No external libraries are used (fully self-contained project)
* Runs directly in any Java environment (e.g., Eclipse)

---

## Conclusion

This project demonstrates an efficient and practical implementation of a Red-Black Tree with proper balancing, testing, and performance evaluation.

---
