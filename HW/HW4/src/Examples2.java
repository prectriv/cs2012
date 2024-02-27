import org.junit.Test;

import static org.junit.Assert.*;

public class Examples2 {

    @Test
    public void testContainsElement() {
        int[] i1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        IBinTree someTree = IBinTree.makeTree(i1);
        ContainsElementValidator e1 = new ContainsElementValidator(3, someTree);

        assertTrue(e1.isValid());
        assertFalse(new ContainsElementValidator(9, someTree).isValid());
    }

    @Test
    public void testHeapValidator() {
        IBinTree mtHeap = new EmptyBT(new MaxHeapStrategy());
        IBinTree someTree;

        // Make a valid max heap with 2 4 6 8 16 15 7 3
        someTree = mtHeap.copy();
        someTree.apply(new MaxHeapStrategy());
        someTree = someTree.addInt(2).addInt(4).addInt(8).addInt(16)
                .addInt(15).addInt(7).addInt(3);

        assertTrue(new HeapValidator(someTree).isValid());
    }

    @Test
    public void testContainsAllValidator() {
        int[] i1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        IBinTree t1 = IBinTree.makeTree(i1);

        int[] i2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        IBinTree t2 = IBinTree.makeTree(i2);

        ContainsAllValidator v1 = new ContainsAllValidator(t1, t2);
        assertTrue(v1.isValid());

        ContainsAllValidator v2 = new ContainsAllValidator(t2, t1);
        assertFalse(v2.isValid());
    }

    @Test
    public void testGetSize() {
        int[] i1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        IBinTree t1 = IBinTree.makeTree(i1);
    }
}
