package learning.linkedlist101;

import java.util.Iterator;

public class NodeSLL<T> implements Iterable<T>{
    private T value;
    private NodeSLL nextNode;

    public NodeSLL(T value, NodeSLL nextNode) {
        this.value = value;
        this.nextNode = nextNode;
    }

    public NodeSLL() {
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeSLL getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeSLL nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}
