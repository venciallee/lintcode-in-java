package com.bytetree.lintcode.design.ood;

/**
 * 456. Reference
 * <p>
 * Implement the class ReferenceManager. Include the following two methods:
 * <p>
 * copyValue(Node obj). This would just copy the value from parameter obj to the public attribute node. But obj and node are still two difference instances / objects.
 * copyReference(Node obj). This would copy the reference from obj to node. So that both node and obj are point to the same object.
 * <p>
 * Example
 * ReferenceManager ref = ReferenceManager();
 * Node obj = new Node(0);
 * ref.copyValue(obj);
 * ref.node.val; // will be 0
 * ref.node; // will be different with obj.
 * <p>
 * Node obj2 = new Node(1);
 * ref.copyReference(obj2);
 * ref.node.val; // will be 1
 * ref.node; // will be the same with obj2
 * <p>
 * <a href="https://www.lintcode.com/problem/reference/description">456. Reference</a>
 * <p>
 * Created by vencial on 2019-10-09.
 */
public class ReferenceManager {

    public Node node;

    public void copyValue(Node obj) {
        // copy value from obj to node
        if (obj == null) {
            return;
        }
        if (node == null) {
            node = new Node(obj.val);
        }

        node.val = obj.val;
    }

    public void copyReference(Node obj) {
        // copy reference from obj to node
        this.node = obj;
    }
}

class Node {
    public int val;

    public Node(int val) {
        this.val = val;
    }
}
