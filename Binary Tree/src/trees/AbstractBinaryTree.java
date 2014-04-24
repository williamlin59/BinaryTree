package trees;

public abstract class AbstractBinaryTree<T> implements BinaryTree<T> {
	protected class Node implements Position<T> {
		T element;
		Node parent, left, right;
		
		public Node(T element) {
			this.element = element;
		}
		
		@Override
		public T element() {
			return element;
		}
	}
	
	protected Node root;
	protected int size = 0;
	
	@Override
	public Position<T> root() {
		return root;
	}

	protected Node toNode(Position<T> p) {
		return (Node) p;
	}
	
	@Override
	public Position<T> parent(Position<T> p) {
		return toNode(p).parent;
	}

	@Override
	public Iterator<Position<T>> children(final Position<T> p) {
		return new Iterator<Position<T>>() {
			Node current = toNode(p).left;
			
			@Override
			public boolean hasNext() {
				return (current != null);			}

			@Override
			public Position<T> next() {
				Node n = current;
				if (current == toNode(p).left) {
					current = toNode(p).right;
				} else {
					current = null;
				}
				return n;
			}
			
		};
	}

	@Override
	public boolean isInternal(Position<T> p) {
		return toNode(p).left != null || toNode(p).right != null;
	}

	@Override
	public boolean isExternal(Position<T> p) {
		return toNode(p).left == null && toNode(p).right == null;
	}

	@Override
	public boolean isRoot(Position<T> p) {
		return p == root;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<Position<T>> positions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T replace(Position<T> p, T t) {
		T temp = p.element();
		toNode(p).element = t;
		return temp;
	}

	@Override
	public Position<T> left(Position<T> p) {
		return toNode(p).left;
	}

	@Override
	public Position<T> right(Position<T> p) {
		return toNode(p).right;
	}

	@Override
	public boolean hasLeft(Position<T> p) {
		return toNode(p).left != null;
	}

	@Override
	public boolean hasRight(Position<T> p) {
		return toNode(p).right != null;
	}
}
