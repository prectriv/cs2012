import java.util.NoSuchElementException;

public class HeapValidator implements IValidator {
    private boolean valid = true;

    /**
     * Constructor that kicks off the loop
     *
     * @param someTree a tree you wish to loop over
     */
    public HeapValidator(IBinTree someTree) {
        someTree.accept(this);
    }

    /**
     * A callback function for when the current traversal reaches a NodeBT
     *
     * @param data  the data in the current node
     * @param left  the left subtree of the current node
     * @param right the right subtree of the current node
     * @return true when the traversal should continue; false if it should stop
     *         early (short-circuiting)
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        int leftData = left.getRoot().isPresent() ? left.getRoot().get() : Integer.MIN_VALUE;
        if (data < leftData) {
            this.valid = false;
            return false;
        }

        int rightData = right.getRoot().isPresent() ? right.getRoot().get() : Integer.MIN_VALUE;
        ;
        if (data < rightData) {
            this.valid = false;
            return false;
        }

        return true;
    }

    /**
     * A callback function for when the current traversal reaches an EmptyBT
     *
     * @return true when the traversal should continue (backtracking); false if it
     *         should stop early (short-circuiting)
     */
    @Override
    public boolean visit() {
        return true;
    }

    /**
     * Produces the answer if the tree passes the heap test
     *
     * @return a boolean representing if it passed the test.
     */
    @Override
    public boolean isValid() {
        return valid;
    }
}
