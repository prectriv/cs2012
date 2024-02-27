import java.util.LinkedList;

public class ContainsElementValidator implements IValidator {
    private int lookingFor;
    private boolean foundIt = false;

    /**
     * Constructor that kicks off the loop and stores values.
     *
     * @param lookingFor the number you are looking for
     * @param someTree the tree you wish to loop over
     */
    public ContainsElementValidator(int lookingFor, IBinTree someTree){
        this.lookingFor = lookingFor;
        someTree.accept(this);
    }

    /**
     * A callback function for when the current traversal reaches a NodeBT
     *
     * @param data  the data in the current node
     * @param left  the left subtree of the current node
     * @param right the right subtree of the current node
     * @return true when the traversal should continue; false if it should stop early (short-circuiting)
     */
    @Override
    public boolean visit(int data, IBinTree left, IBinTree right) {
        if(this.lookingFor == data){
            foundIt = true;
            return false;
        }
        return true;
    }

    /**
     * A callback function for when the current traversal reaches an EmptyBT
     *
     * @return true when the traversal should continue (backtracking); false if it should stop early (short-circuiting)
     */
    @Override
    public boolean visit() {
        return true;
    }

    /**
     * Produces the answer for if the tree contains the element
     *
     * @return a boolean representing if it passed or failed.
     */
    @Override
    public boolean isValid() {
        return this.foundIt;
    }

    /**
     * Produces the accumulated list of all the integers within the tree
     *
     * @return a LinkedList of Integers
     */
}
