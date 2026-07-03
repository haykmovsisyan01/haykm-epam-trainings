# Java Homework: Drawing Triangles with Loops

**Topic:** Nested `for` loops  
**Language:** Java  
**Difficulty:** Beginner

---

## Background

A triangle made of `*` characters is just multiple rows printed one after another. The key insight is:

> The number of stars (or spaces) on each row depends on the **row number**.

Your job is to figure out that relationship and express it with a loop.

---

## Exercise 1 — Left-Aligned Triangle

**Expected output (5 rows):**

```
*
**
***
****
*****
```

**Your task:**

Write a Java program using nested `for` loops that produces the output above.

---

## Exercise 2 — Upside-Down Triangle

**Expected output (5 rows):**

```
*****
****
***
**
*
```

**Your task:**

Modify your solution from Exercise 1 so the triangle is flipped upside down.

---

## Exercise 3 — Pyramid (Centered Triangle)

**Expected output (5 rows):**

```
    *
   ***
  *****
 *******
*********
```

**Your task:**

Each row has two things: **spaces** on the left, then **stars** in the middle.

---

## What to Submit

- A single `.java` file for each exercise (or all three in one file with separate methods).
- Your code must compile and run without errors.
- No use of arrays or `String` multiplication — only `for` loops and `System.out.print`.