# Substitution Cipher Problem

A substitution cipher is a simple way to obfuscate a string, by replacing the letters, given a mapping.
For example:
```json
{
  "cipher": "zyxwvutsrqponmlkjihgfedcba",
  "alphabet": "abcdefghijklmnopqrstuvwxyz"
}
```

Each letter in the cipher replaces the corresponding letter in the alphabet. So a word like `abs` becomes `zyf`.

## Example

Input:
```json
{
  "text": "Hello, folks!",
  "cipher": "zyxwvutsrqponmlkjihgfedcba"
}
```

Output: `Svool, uloph!`
