# Binary Tree Note:



Let T be a non empty binary tree:
- <img src="https://latex.codecogs.com/svg.latex?n"/> : total number of nodes
- <code>$h$</code> : height
- <code>$n_e$</code> : total number of external nodes (leaf)
- <code>$n_i$</code> : total number of internal nodes

<img src="https://latex.codecogs.com/svg.latex?(\sum_{i=0}^n 2^i = 2^{n+1}-1)"/>

<code>$h + 1 \leqslant n \leqslant 2^{h+1}-1$</code>
- the minimum number of node in a tree is <code>$h+1$</code>
  - each level only has one node
- the maximum number of node in a tree is <code>$2^{h+1}-1$</code>
  - each level is filled with <code>$2^h$</code> nodes

<code>$1\leqslant n_e \leqslant 2^h$</code>
- at least one leaf exists
- maximum: the deepest level is all leaves

<code>$h \leqslant n_i \leqslant 2^h-1$</code>


![(\sum_{i=0}^n 2^i = 2^{n+1}-1)(https://latex.codecogs.com/svg.latex?x%3D%5Cfrac%7B-b%5Cpm%5Csqrt%7Bb%5E2-4ac%7D%7D%7B2a%7D)]


<img src="https://latex.codecogs.com/svg.latex?"/>