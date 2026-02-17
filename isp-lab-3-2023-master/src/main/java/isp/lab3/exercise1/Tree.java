package isp.lab3.exercise1;

public class Tree {
    private int height;

    public Tree() {
        this.height = 15;
    }

    public int grow(int n) {
        if (n >= 1) {
            this.height += n;
        }
        return this.height;
    }

    @Override
    public String toString() {
        return "Tree{" + "height=" + height + '}';
    }
}