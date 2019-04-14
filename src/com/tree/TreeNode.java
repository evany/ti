package com.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TreeNode treeNode = (TreeNode) o;

        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return val;
    }

    public static TreeNode build(Integer[] arr){
        return build(arr, 0);
    }

    private static TreeNode build(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }
        TreeNode node = new TreeNode(arr[index]);
        node.left = build(arr, index * 2 + 1);
        node.right = build(arr, index * 2 + 2);

        return node;
    }


    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        System.out.println(build(arr));
    }
}
