import java.util.LinkedList;

public class ContainsAllValidator implements IValidator {
    private LinkedList<Integer> intsInTree = new LinkedList<>();
    private IBinTree someTree;

    /**
     * Constructor that kicks off the loop and stores necessary values for isValid().
     *
     * @param fromTree the integers from this tree must be in the second tree provided
     * @param inTree this tree must contain all the ints from the previous tree.
     */
    public ContainsAllValidator(IBinTree fromTree, IBinTree inTree){
        this.someTree = inTree;
        fromTree.accept(this);
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
        intsInTree.add(data);
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
     * Produces a boolean representing if all elements fromTree are located within inTree
     *
     * @return true if the tree passed the conditions, false otherwise.
     */
    @Override
    public boolean isValid() {
        boolean AllElements = true;
        for(Integer i : this.intsInTree){
            if(!(new ContainsElementValidator(i, someTree).isValid())){
                AllElements = false;
                break;
            }
        }
        return AllElements;
    }
}
