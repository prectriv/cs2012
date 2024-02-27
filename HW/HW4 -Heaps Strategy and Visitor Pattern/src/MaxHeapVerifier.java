public class MaxHeapVerifier {

    public boolean verifyAdd(IBinTree before, int added, IBinTree after){

        boolean MaxHeap = new HeapValidator(after).isValid();
        boolean AllElements = new ContainsAllValidator(before, after).isValid();
        boolean Contains = new ContainsElementValidator(added, after).isValid();
        boolean Size = (new SizeVisitor(before).getSize() + 1) == new SizeVisitor(after).getSize();

        return MaxHeap && AllElements && Contains && Size;
    }

    public boolean verifyRemoveRoot(IBinTree before, int root, IBinTree after){

        boolean MaxHeap = new HeapValidator(after).isValid();
        boolean AllElements = new ContainsAllValidator(after, before).isValid();
        boolean Contains = !new ContainsElementValidator(root, after).isValid();
        boolean Size = (new SizeVisitor(before).getSize() - 1) == new SizeVisitor(after).getSize();

        return MaxHeap && AllElements && Contains && Size;
    }
}
