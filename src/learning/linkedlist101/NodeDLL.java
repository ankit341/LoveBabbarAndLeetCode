package learning.linkedlist101;

public class NodeDLL<T> {
    private NodeDLL previousNode;
    private T value;
    private NodeDLL nextNode;

    public NodeDLL(NodeDLL previousNode, T value, NodeDLL nextNode) {
        this.previousNode = previousNode;
        this.value = value;
        this.nextNode = nextNode;
    }

    public NodeDLL() {
    }

    public NodeDLL getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(NodeDLL previousNode) {
        this.previousNode = previousNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeDLL getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeDLL nextNode) {
        this.nextNode = nextNode;
    }

}
