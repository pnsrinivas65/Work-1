package hello.ds;

public class TreeNode {
	
	public Integer data;
	public TreeNode leftNode;
	public TreeNode rightNode;

	
	public TreeNode(Integer data) {
		
		this.data = data;
	}
	
	
	public void insertData(Integer data) {
		System.out.println("this.data >= data --->"+(this.data >= data)+" data -->"+data+"tostring"+toString());
		if(this.data <= data) {
			if(this.rightNode == null) {
				this.rightNode = new TreeNode(data);
			} else {
				this.rightNode.insertData(data);
			}
		} else {
			
			if(this.leftNode == null) {
				this.leftNode = new TreeNode(data);
			} else {
				this.leftNode.insertData(data);
			}
		}
	}
	
	public TreeNode find(Integer data) {
		
		if(this.data == data) {
			
			return this;
		}
		
		if(this.data < data && leftNode != null) {
			
			return leftNode.find(leftNode.data);
		}
		
		if(this.data > data && rightNode != null) {
			
			return rightNode.find(rightNode.data);
		}
		
		return null;
	}
	
	
	public Integer smallest() {
		
		if(this.leftNode == null) {
			return this.data;
		}
		return this.leftNode.smallest();
	}
	
	
	public Integer largest() {
		if(this.rightNode == null) {
			
			return this.data;
		}
		return this.rightNode.largest();
	}
	/**
	 * @return the dataInteger
	 */
	public Integer getData() {
		return data;
	}
	
	
	/**
	 * @return the leftNode
	 */
	public TreeNode getLeftNode() {
		return leftNode;
	}
	/**
	 * @param leftNode the leftNode to set
	 */
	public void setLeftNode(TreeNode leftNode) {
		this.leftNode = leftNode;
	}
	/**
	 * @return the rightNode
	 */
	public TreeNode getRightNode() {
		return rightNode;
	}
	/**
	 * @param rightNode the rightNode to set
	 */
	public void setRightNode(TreeNode rightNode) {
		this.rightNode = rightNode;
	}

	
	@Override
	public String toString() {
		return String.valueOf(this.data);
	}

}
