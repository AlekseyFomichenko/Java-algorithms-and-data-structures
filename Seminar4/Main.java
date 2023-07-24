public class Main {
    public static void main(String[] args) {
        BinTree<Integer> bn = new BinTree<>();
        bn.add(9);
        bn.add(12);
        bn.add(5);
        bn.add(2);
        bn.add(10);
        bn.add(7);
        
        System.out.println(bn.contain(2));
        System.out.println(bn.contain(5));
        System.out.println(bn.contain(112));
        System.out.println(bn.contain(8));
    }
}
