/*
Author (made changes): Nicole Hackler
Date: 12/07/2023

Exercise 25-11
(Display tree) Write a new view class that displays the tree
horizontally with the root on the left as shown in Figure 25.23.

I made changes to the existing code. I've marked where and what I did with **
Even though I've stated in the below comments on each line I reversed vGap with hGap and vs within
the program.
 */
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;



public class BTView extends Pane {

    private BST<Integer> tree = new BST<>();
    private double radius = 15; // Tree node radius
    private double hGap = 50; // Gap between two levels in a tree
    //**Changed vGap to hGap**

    BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
            // Display tree recursively
            displayTree(tree.getRoot(),  hGap,getHeight() / 2, getHeight() / 4);
            //**Changed getWidth() to getHeight() and swapped the x variable with the y**
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> root, double x, double y, double vGap) {
        if (root.left != null) {
            // Draw a line to the left node
            getChildren().add(new Line(x + vGap, y + hGap, x, y)); //**Changed - to a + on x variable**
            // Draw the left subtree recursively
            displayTree(root.left, x + vGap, y + hGap, hGap / 2); //**Changed - to a + on x variable**
            //**Swapped vGap with vGap and vs in both above methods**
        }

        if (root.right != null) {
            // Draw a line to the right node
            getChildren().add(new Line(x + vGap, y - hGap, x, y)); //**Changed + to a - on y variable**
            // Draw the right subtree recursively
            displayTree(root.right, x + vGap, y - hGap, vGap / 2); //**Changed + to a - on y variable**
            //**Swapped vGap with vGap and vs in both above methods**
        }

        // Display a node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, root.element + ""));
    }
}
