package com.hh.structure.tree;

/**
 * @Description: 二叉查找树
 * @Author: gorun
 * @date 2020/10/8
 */
public class BinarySearchTree {

    BSTNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BSTNode search(Integer key) {
        return search(root, key);
    }

    private BSTNode search(BSTNode node, Integer key) {
        if (node == null) {
            return null;
        }
        int compare = key.compareTo(node.key);
        if (compare > 0) {
            return search(node.right, key);
        } else if (compare == 0) {
            return node;
        } else {
            return search(node.left, key);
        }

    }

    /**
     * 删除操作
     * @param key
     */
    public void insert(Integer key) {
        insert(root, key);
    }

    private void insert(BSTNode root, Integer key) {
        if (root == null) {
            root = new BSTNode(key);
            return;
        }

        BSTNode node = root;
        while (node != null) {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                if (node.left == null) {
                    node.left = new BSTNode(key);
                    break;
                }
                node = node.left;
            } else {
                if (node.right == null) {
                    node.right = new BSTNode(key);
                    break;
                }
                node = node.right;
            }
        }
    }

    /**
     * 删除操作相对比较复杂，有三种情况需要考虑：
     *
     * 1. 删除叶子节点。只需解除父节点与此节点的关系即可。
     * 2. 删除只有一个子节点的子树根节点。
     *       如果只存左子节点，则先解除父节点与根节点的关系，然后再将父节点与左子节点建立关系。如果只存在右子节点，则同样先与父节点解除关系，然后将父节点与右子节点建立关系即可。
     * 3. 删除一个左右子节点均存在的子树根节点。
     *       此时采用替换操作，从右子树中查找到最小节点（也就是最左节点），将要删除的这个节点的值替换为个最小节点的值（由中序遍历序列可知，这两个值是相邻的），之后再将这个最小节点从树中删除即可。
     * @param key
     * @return
     */
    public BSTNode remove(Integer key){
        //1、找到要删除的节点在树中的位置
        return null;
    }


    /**
     * 定义树结构
     */
    public class BSTNode {

        public Integer key;

        public BSTNode left;

        public BSTNode right;

        public BSTNode() {
        }

        public BSTNode(Integer key) {
            this.key = key;
        }

        public BSTNode(Integer key, BSTNode left, BSTNode right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }

    }
}
