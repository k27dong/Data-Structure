# Binary Tree Note:

Let T be a non empty binary tree:
- <code>$n$</code> : total number of nodes
- <code>$h$</code> : height
- <code>$n_e$</code> : total number of external nodes (leaf)
- <code>$n_i$</code> : total number of internal nodes

<code>$(\sum_{i=0}^n 2^i = 2^{n+1}-1)$</code>

<code>$h + 1 \leqslant n \leqslant 2^{h+1}-1$</code>
- the minimum number of node in a tree is <code>$h+1$</code>
  - each level only has one node
- the maximum number of node in a tree is <code>$2^{h+1}-1$</code>
  - each level is filled with <code>$2^h$</code> nodes

<code>$1\leqslant n_e \leqslant 2^h$</code>
- at least one leaf exists
- maximum:the deepest level is all leaves

<code>$h \leqslant n_i \leqslant 2^h-1$</code>
- 