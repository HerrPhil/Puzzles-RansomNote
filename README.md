# Puzzles-RansomNote

Compare whether a ransom note matches the letters of a magazine.

## Leetcode Notes of Lesson Task

Here is an easy Google interview question.

We are given a note, as well as a magazine.

These are just strings.

We want to know, given the letters of the magazine,
whether we can produce the ransom note.

Intuitively, we draw lines to connect letters in the note and magazine strings.

This can show us whether we can produce the ransom note.

For example:
```
Note =       a a b -\
             | |    |
             | |    |
             | |    |
Magazine = b a a    |
           |        |
           \ ______ /
```
would return true.

If the note has another 'a', then we need 3 a's, and the magazine only has 2 a's.

That would return false.

Whenever a problem involves counting values, a good strategy is always to use a hash map.

The key is the letter, and the value is the number of occurrences we have.

In this case, the hash map is populated with the results of the magazine string.

Then the solution can loop through the ransom note.

The solution decrements letter counts in the hash map as letters are encountered.

When a count reaches 0, then remove that map entry, entirely.

When the ransom note loop exits, then check whether the hash map is empty.
