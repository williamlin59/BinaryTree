package trees;

public class StandardBinaryTree<T> extends AbstractBinaryTree<T> {
	 //="Root="+root.element;
	//private String output="";
	public static void main(String[] args) {
		StandardBinaryTree<String> tree = new StandardBinaryTree<String>();
		
	}

	
	public Position<T> addRoot(T e) {
		root = new Node(e);
		return root;
	}
	
	public Position<T> insertLeft(Position<T> p, T e) {
		if (hasLeft(p)) throw new DuplicateNodeException();
		
		Node n = new Node(e);
		n.parent = toNode(p);
		toNode(p).left = n;
		size++;
		
		return n;
	}
	
	public Position<T> insertRight(Position<T> p, T e) {
		if (hasRight(p)) throw new DuplicateNodeException();
		
		Node n = new Node(e);
		n.parent = toNode(p);
		toNode(p).right = n;
		size++;
		
		return n;
		
	}

	public T remove(Position<T> p) {
		Object Temp=(T) new Object();
		if(hasRight(p)&&hasLeft(p))throw new DuplicateNodeException();
		else if(p==root){
			Temp=root.parent;
			if(hasRight(p)){
				root=toNode(p).right;
				toNode(p).right=null;
			}
			else{
				root=toNode(p).left;
				toNode(p).left=null;
			}
			root.parent=null;
			toNode(p).element=null;
		}
		else if(hasRight(p)||hasLeft(p)){
			Temp=toNode(p).element;
			toNode(p).element=null;
			if(hasRight(p)){	
				//toNode(p).element=toNode(p).right.element;
				toNode(p).right.parent=toNode(p).parent;
				if(toNode(p).parent.right==p){
				toNode(p).parent.right=toNode(p).right;
				}
				else{
					toNode(p).parent.left=toNode(p).right;
				}
				toNode(p).right=null;
				toNode(p).parent=null;
			}
			else{
				toNode(p).left.parent=toNode(p).parent;
				
				if(toNode(p).parent.right==p){
				toNode(p).parent.right=toNode(p).left;
				}
				else{
				toNode(p).parent.left=toNode(p).left;				
				}
				toNode(p).left=null;
				toNode(p).parent=null;
			}
		}
		else if(!hasRight(p)&&!hasLeft(p)){
			Temp=toNode(p).element;
			toNode(p).element=null;
			if(toNode(p).parent.left==p){
				toNode(p).parent.left=null;
			}
			else if(toNode(p).parent.right==p){
				toNode(p).parent.right=null;
			}
			toNode(p).parent=null;
		}
		return (T) Temp;
	}
	
	public void attach(Position<T> v, StandardBinaryTree<T> t1, StandardBinaryTree<T> t2) {
		if (isInternal(v)) throw new DuplicateNodeException();
		
		toNode(v).left = toNode(t1.root());
		toNode(t1.root()).parent = toNode(v);
		toNode(v).right = toNode(t2.root());
		toNode(t2.root()).parent = toNode(v);
		size += t1.size() + t2.size();
	}


}
		

