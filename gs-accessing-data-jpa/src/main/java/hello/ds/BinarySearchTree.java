package hello.ds;

public class BinarySearchTree {

	private TreeNode root;

	public static void main(String[] args) {
		int[] sample = { 212, 580, 6, 7, 28, 84, 112, 434, 860};
		BinarySearchTree bst = new BinarySearchTree();
		for (int x : sample) {
			bst.insert(x);
		}
		//System.out.println(bst.);
		System.out.println(bst.search(28));
		System.out.println(bst.largest());
		System.out.println(bst.smallest());
//		bst.delete(84);
		//System.out.println(bst.numOfLeafNodes());
		//System.out.println(bst.height());
		//bst.traverseInOrder();
	}
	
	public void insert(Integer data) {

		if (root == null) {

			root = new TreeNode(data);
		} else {

			root.insertData(data);
		}
	}

	public TreeNode search(Integer data) {

		if (root != null) {
			root.find(data);
		}

		return null;

	}

	public void delete(Integer data) {

		TreeNode current = this.root;
		TreeNode parent = this.root;
		boolean isLeftChild = false;

		if (current == null) {
			// since tree is empty
			return;
		}

		while (current != null && current.getData() != data) {

			parent = current;
			if (data < current.getData()) {
				current = current.getLeftNode();
				isLeftChild = true;
			} else {
				current = current.getRightNode();
				isLeftChild = false;
			}
		}

		if (current == null) {
			// unable to found the item to delete
			return;
		}

		// if does not have any leaf nodes
		if (current.getLeftNode() != null && current.getRightNode() != null) {
			// if root itself dones not have any data
			if (current == root) {
				root = null;
			} else {
				if (isLeftChild) {
					parent.setLeftNode(null);
				} else {
					parent.setRightNode(null);
				}
			}
			// node to be deleted has one child i.e. left node
		} else if (current.getRightNode() == null) {
			if (current == root) {
				root = current.getLeftNode();
			} else if (isLeftChild) {
				parent.setLeftNode(current.getLeftNode());
			} else {
				parent.setRightNode(current.getLeftNode());
			}
			// node to be deleted has one child i.e. right node
		} else if (current.getLeftNode() == null) {
			if (current == root) {
				root = current.getRightNode();
			} else if (isLeftChild) {
				parent.setLeftNode(current.getRightNode());
			} else {
				parent.setRightNode(current.getRightNode());
			}
		}
	}
	
	public Integer smallest() {
		
		if(this.root != null) {
			return root.smallest();
		}
		return null;
	}
	
	public Integer largest() {
		
		if(this.root != null) {
			return root.largest();
		}
		return null;
	}
}
