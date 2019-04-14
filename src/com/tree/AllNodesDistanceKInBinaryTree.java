package com.tree;


import java.util.*;


class AllNodesDistanceKInBinaryTree {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null || target == null){
            return res;
        }
        Map<Integer,List<TreeNode>> g = new HashMap<Integer, List<TreeNode>>();
        buildGraph(root, g);
        Set<Integer> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int cd = 0;//current distance
        queue.offer(target);
        while(!queue.isEmpty()){
            if(cd == K){
                break;
            }
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                visited.add(node.val);
                if(g.get(node.val) != null){
                    for(TreeNode cn : g.get(node.val)){
                        if(!visited.contains(cn.val)){
                            queue.offer(cn);
                            visited.add(cn.val);
                        }
                    }
                }


            }
            cd++;
        }

        while(!queue.isEmpty()){
            res.add(queue.poll().val);
        }
        return res;
    }

    private void buildGraph(TreeNode root, Map<Integer, List<TreeNode>> g){
        if(root == null) return;
        if(root.left != null){
            addLink(g, root, root.left);
            buildGraph(root.left, g);
        }
        if(root.right != null){
            addLink(g, root, root.right);
            buildGraph(root.right, g);
        }
    }

    private void addLink(Map<Integer, List<TreeNode>> g, TreeNode a, TreeNode b){
        List<TreeNode> ac = g.get(a.val);//a children
        if(ac == null){
            ac = new ArrayList<TreeNode>();
            g.put(a.val, ac);
        }
        ac.add(b);

        List<TreeNode> bc = g.get(b.val);//a children
        if(bc== null){
            bc = new ArrayList<TreeNode>();
            g.put(b.val, bc);
        }
        bc.add(a);
    }


    public static void main(String[] args) {
        TreeNode root = TreeNode.build(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        AllNodesDistanceKInBinaryTree a = new AllNodesDistanceKInBinaryTree();
        List<Integer> res = a.distanceK(root, root.left, 2);
        System.out.println(res);

    }
}