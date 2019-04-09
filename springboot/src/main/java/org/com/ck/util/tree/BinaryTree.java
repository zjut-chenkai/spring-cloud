package org.com.ck.util.tree;

public class BinaryTree {
	/**
	 * 获取二叉树的深度
	 * @param node
	 * @return
	 */
	public int maxDeath(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = maxDeath(node.left);
		int right = maxDeath(node.right);
		return Math.max(left, right) + 1;
	}
}
