package com.sekhar.coding;

import java.util.*;


class NodeWithPosition {
    public TreeNode node;
    public int position;

    public NodeWithPosition(TreeNode node, int position) {
        this.node = node;
        this.position = position;
    }
}

public class VerticalOrderTraversal {
    private TreeMap<Integer, List<Integer>> positionMap = new TreeMap<Integer, List<Integer>>();
    private LinkedList<NodeWithPosition> queue = new LinkedList<NodeWithPosition>();

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        queue.add(new NodeWithPosition(root, 0));
        populatePositions();
        for (Map.Entry<Integer, List<Integer>> eachEntry : positionMap.entrySet())
            result.add(eachEntry.getValue());
        return result;
    }

    private void populatePositions() {
        while (queue.size() != 0) {
            NodeWithPosition head = queue.pollFirst();
            if (!positionMap.containsKey(head.position))
                positionMap.put(head.position, new ArrayList());
            positionMap.get(head.position).add(head.node.val);
            if (head.node.left != null)
                queue.add(new NodeWithPosition(head.node.left, head.position - 1));
            if (head.node.right != null)
                queue.add(new NodeWithPosition(head.node.right, head.position + 1));
        }
    }
}
