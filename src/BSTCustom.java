
public class BSTCustom {
	
	BSTCustom left; 
	BSTCustom right;
	int value;
	
	public BSTCustom(int value) {
		this.value = value;
	}
	
	public boolean contains(int value) {
		if(value < this.value) {
			if(left != null)
				return left.contains(value);
			else
				return false;
		}
		else if(value > this.value) {
			if(right != null)
				return right.contains(value);
			else
				return false;
		}
		else {
			return true;
		}
	}
	
	public void insert(int value) {
		if(value < this.value) {
			if(left != null)
				left.insert(value);
			else
				left = new BSTCustom(value);
		}
		else if(value > this.value) {
			if(right != null)
				right.insert(value);
			else
				right = new BSTCustom(value);
		}
	}
	
	public void remove(int value) {
		remove(value, null);
	}
	
	public void remove(int value, BSTCustom parent) {
		if(value < this.value) {
			if(left != null)
				left.remove(value, this);
		}
		else if(value > this.value) {
			if(right != null)
				right.remove(value, this);
		}
		else {
			if(left != null && right != null) {
				this.value= right.getMinValue();
				right.remove(this.value, this);
			}
			else if(left == null && right != null) {
				if(parent.left == this) {
					parent.left = this.right;
				}
				else if(parent.right == this) {
					parent.right = this.right;
				}
			}
			else if(left != null && right == null) {
				if(parent.left == this) {
					parent.left = this.left;
				}
				else if(parent.right == this) {
					parent.right = this.left;
				}
			}
			else if(left == null && right == null) {
				if(parent.left.value == value)
					parent.left = null;
				else if(parent.right.value == value)
					parent.right = null;
			}
		}
	}

	private int getMinValue() {
		if(left != null)
			left.getMinValue();
		return this.value;	
	}
}
