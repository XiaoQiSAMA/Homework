

public class BitTree {

    static class Node {
        public char data;
        public Node lchild;
        public Node rchild;
    }

    static String s = SWing.GetDate;
    static char[] input = s.toCharArray();
    static char[] visit = new char[128];
    static int i = 0;
    
    
    public static void bitTreeInit(Node root){
    	try {
    		if(i > input.length) return;
        root.data = input[i++];
        if(input[i] != '#') bitTreeInit(root.lchild = new Node());

        else i++;
        if(i > input.length) return;
        if(input[i] != '#') bitTreeInit(root.rchild = new Node());
        else i++;
    }catch(Exception e) {
    	
    }
   }


    public static void whilePreOrderTraverse(Node root) {
        Node[] Stack = new Node[input.length + 1];
        int top = 0;
        Stack[top++] = root;
        Node p = null;
        while (top > 0) {
            p = Stack[--top];
            if (p != null) {
                visit[i++] = p.data;
                Stack[top++] = p.rchild;
                Stack[top++] = p.lchild;
            }
        }
    }
    
    public static void preOrderTraverse(Node root) {
    	if(root == null) return;
    	visit[i++] = root.data;
    	preOrderTraverse(root.lchild);
    	preOrderTraverse(root.rchild);
    }

    public static void whileInOrderTraverse(Node root) {
        Node[] Stack = new Node[input.length + 1];
        int top = 0;
        Node p = root;
        do {
            while (p != null) {
                Stack[top++] = p;
                p = p.lchild;
            }
            p = Stack[--top];
            visit[i++] = p.data;
            if (p.rchild != null) {
                p = p.rchild;
            }
            else p = null;
        } while(p != null || top > 0);
    }

    public static void inOrderTraverse(Node root) {
    	if(root ==null) return;
    	inOrderTraverse(root.lchild);
    	visit[i++] = root.data;
    	inOrderTraverse(root.rchild);
    }

    public static void whilePostOrderTraverse(Node root) {
        Node[] Stack = new Node[input.length + 1];
        int top = 0;
        Node p = root;
        while (p != null || top > 0) {
            while(p != null) {
                Stack[top++] = p;
                if(p.lchild != null)p = p.lchild;
                else if(p.rchild != null)p = p.rchild;
                else p =null;
            }
            p = Stack[--top];
            visit[i++] = p.data;
            if(top == 0) break;
            
            if (top > 0 && p == Stack[--top].lchild) {
                p = Stack[top].rchild;
                top++;
            }
            else {
            	p = null;
            	top++;
            }
        }
    }
    
    public static void postOrderTraverse(Node root) {
    	if(root == null) return;
    	postOrderTraverse(root.lchild);
    	postOrderTraverse(root.rchild);
    	visit[i++] = root.data;
    }

    public static void depthOrderTraverse(Node root) {
    	Node[] array = new Node[input.length];
    	int font = 0,rear = 0;
    	while(root != null) {
    		visit[i++] = root.data;
    		if(root.lchild != null)
    		array[font++] = root.lchild;
    		if(root.rchild != null)
    		array[font++] = root.rchild;
    		root = array[rear++];
    	}
    }
    
    public static char findBefore(char loc,char[] array) {
    	int j = 0;
    	for(j = 0;j < array.length;j++) {
    		if(loc == array[j]) if(j > 0)return array[--j];
    	}
    	return '#';
    }
    
    public static char findAfter(char loc,char[] array) {
        int j =0;
    	for(j = 0; j < array.length;j++) {
    		if(j < array.length - 1 && loc == array[j] ) return array[++j];
    	}
    	return '#';
    }
    
    public static void visitToString() {
    	for(int j = 0; j < i; j++)
    		SWing.PutDate = SWing.PutDate + visit[j];
    }
    /*public static void main(String[] args){
        Node root = new Node();
        bitTreeInit(root);
        i = 0;
        whilePreOrderTraverse(root);
        for(int k = 0; k < i;k++) {
        	System.out.print(visit[k]);
        }

    }*/

}
