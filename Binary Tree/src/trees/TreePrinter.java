package trees;

public class TreePrinter<T> implements Visitor<T> {
	private BinaryTree<T> tree;
	private String output="";
	
	public TreePrinter(BinaryTree<T> tree) {
		this.tree = tree;
	}

	public String toString() {
		return output;
	}
	public void cleaner(){
		output="";
	}
	@Override
	public void visit(Position<T> position, Object data) {
		output += (tree.root() == position ? "" : "\t") + position.element();
		if (tree.hasLeft(position)) {
			visit(tree.left(position), data.toString() +"\t");
		}
		else output += "\n";
		
		if (tree.hasRight(position)) {
			output += data.toString();
			visit(tree.right(position), data.toString() +"\t");
		}
	}

}