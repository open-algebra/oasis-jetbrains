# OasisPALM-IDEA: OASIS PALM Plugin for JetBrains IDEs

OasisPALM-IDEA is a JetBrains plugin that provides syntax highlighting and error checking for OASIS PALM files.

---

## What is OASIS PALM?

OASIS PALM (Portable Algebra and Logic Medium) is a prefix-based language designed for defining algebraic structures and logical frameworks in a modular and reusable way. It is part of the OASIS ecosystem, which aims to facilitate the development and sharing of formal mathematical content.

---

## Palm Definition

Palm files follow the BNF grammar described in the [OASIS PALM Specification](./src/main/grammars/PALM.bnf). Below is a brief overview of the key components of a Palm file:
- **Expressions**: Define algebraic expressions using a prefix notation.
- **Operators**: Specify operations.
- **Operands**: Define the operands for the operations.
- **Identifiers**: Used to name variables.
- **Numbers**: Represent numerical values.

---

## Example Palm File
Here is a simple example of a Palm file:

```palm ExamplePalm
(- (/ (real 10) (real 2)) (log (real 10) (real 100)))
```

This expression represents:
- Subtraction
  - Division
    - Real
      - Number 10
    - Real
      - Number 2
  - Logarithm
    - Real
      - Number 10
    - Real
      - Number 100

In infix notation, this would be equivalent to:
```
(10 / 2) - log_10(100)
```