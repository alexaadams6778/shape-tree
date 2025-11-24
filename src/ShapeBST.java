/*
 * Written by Alexa Adams
 */

import java.io.*;
import java.util.Scanner;

public class ShapeBST 
{
	private class Node	//internal node class
	{
		Shape shape;
		Node leftChild;
		Node rightChild;
		
		public Node(Shape aShape)
		{
			shape = aShape;
			leftChild = rightChild = null;
		}
	}
	
	private Node root;	//head
	
	public ShapeBST()
	{
		root = null;
	}
	
	public void add(Shape aShape)	//recursive helper method to start recursion
	{
		if(root == null)
			root = new Node(aShape);
		else
			add(root, aShape);		//recursive call
	}
	
	private Node add(Node aNode, Shape aShape)
	{
		if(aNode == null)
			aNode = new Node(aShape);
		else if(aShape.compareTo(aNode.shape) < 0)	//go left
			aNode.leftChild = add(aNode.leftChild, aShape);
		else if(aShape.compareTo(aNode.shape) > 0)	//go right
			aNode.rightChild = add(aNode.rightChild, aShape);
		
		return aNode;
	}
	
	public void remove(Shape aShape)
	{
		root = remove(root, aShape);		//helper method to start recursion
	}
	
	private Node remove(Node aNode, Shape aShape)
	{
		if(aNode == null)
			return null;
		else if(aShape.compareTo(aNode.shape) < 0)
			aNode.leftChild = remove(aNode.leftChild, aShape);
		else if(aShape.compareTo(aNode.shape) > 0)
			aNode.rightChild = remove(aNode.rightChild, aShape);
		else	//found it
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			else if(aNode.leftChild == null)
				return aNode.rightChild;
			
			Node temp = findSmallest(aNode.rightChild);
			aNode.shape = temp.shape;
			aNode.rightChild = remove(aNode.rightChild, temp.shape);
		}
		
		return aNode;
	}
	
	private Node findSmallest(Node aNode)	//helper to find the smallest value in tree
	{
		if(aNode == null)
			return null;
		else if(aNode.leftChild == null)
			return aNode;
		else
			return findSmallest(aNode.leftChild);
	}
	
	public boolean search(Shape aShape)
	{
		return search(root, aShape);		//helper method to access root
	}
	
	private boolean search(Node aNode, Shape aShape)
	{
		if(aNode == null)
			return false;
		else if(aShape.compareTo(aNode.shape) < 0)	//go left
			return search(aNode.leftChild, aShape);
		else if(aShape.compareTo(aNode.shape) > 0)	//go right
			return search(aNode.rightChild, aShape);
		else
			return true;
	}
	
	public void printPreOrder()
	{
		printPreOrder(root);	//helper method to access root
	}
	
	private void printPreOrder(Node aNode)	//prints pre-order traversal
	{
		if(aNode == null)
			return;
		
		System.out.println(aNode.shape.toString());
		printPreOrder(aNode.leftChild);		//left
		printPreOrder(aNode.rightChild);	//right
	}
	
	public void printInOrder()
	{
		printInOrder(root);		//helper method to access root
	}
	
	private void printInOrder(Node aNode)	//prints in-order traversal
	{
		if(aNode == null)
			return;
		
		printInOrder(aNode.leftChild);	//left
		System.out.println(aNode.shape.toString());
		printInOrder(aNode.rightChild);	//right
	}
	
	public void printPostOrder()
	{
		printPostOrder(root);		//helper method to access root
	}
	
	private void printPostOrder(Node aNode)		//prints post-order traversal
	{
		if(aNode == null)
			return;
		
		printPostOrder(aNode.leftChild);	//left
		printPostOrder(aNode.rightChild);	//right
		System.out.println(aNode.shape.toString());
	}
	
	public void readFromFile(String filename)
	{
	    try {
	        Scanner fileScanner = new Scanner(new File(filename));
	        
	        while (fileScanner.hasNextLine()) 
	        {
	            String line = fileScanner.nextLine().trim();
	            if (line.isEmpty()) 
	            	continue;	//invalid
	            
	            String[] parts = line.split("\t");
	            if (parts.length < 2) 
	            	continue;
	            
	            String type = parts[0].trim();

	            if (type.equalsIgnoreCase("Circle") && parts.length >= 2) {
	                double r = Double.parseDouble(parts[1].trim());
	                add(new Shape.Circle(r));
	            } else if (type.equalsIgnoreCase("Rectangle") && parts.length >= 3) {
	                double l = Double.parseDouble(parts[1].trim());
	                double w = Double.parseDouble(parts[2].trim());
	                add(new Shape.Rectangle(l, w));
	            } else if (type.toLowerCase().contains("right") && parts.length >= 3) {
	                double b = Double.parseDouble(parts[1].trim());
	                double h = Double.parseDouble(parts[2].trim());
	                add(new Shape.RightTriangle(b, h));
	            }
	        }
	        
	        fileScanner.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}
	
	public void writeToFile(String filename) 
	{
	    try 
	    {
	        PrintWriter writer = new PrintWriter(new File(filename));
	        writeInOrder(root, writer);
	        writer.close();
	    } 
	    catch (Exception e) 
	    {
	    	e.printStackTrace();
	    }
	}

	private void writeInOrder(Node node, PrintWriter writer) 
	{
		if (node == null) 
	        return;

	    writeInOrder(node.leftChild, writer);
	    writer.println(node.shape.toFileString()); 
	    writeInOrder(node.rightChild, writer);
	}
	
	public Shape findMax()
	{
	    if (root == null)
	        return null;
	    
	    Node current = root;
	    while (current.rightChild != null)
	        current = current.rightChild;
	    
	    return current.shape;
	}
	
	public void removeGreaterThan(double maxArea)
	{
	    root = removeGreaterThan(root, maxArea);	//starts recursion
	}

	private Node removeGreaterThan(Node node, double maxArea)
	{
	    if (node == null)
	    	return null;
	    
	    if (node.shape.getArea() > maxArea)
	        return removeGreaterThan(node.leftChild, maxArea); //get rid of node and right subtree
	    
	    node.rightChild = removeGreaterThan(node.rightChild, maxArea);
	    return node;
	}
	
	public boolean isEmpty()
	{
		if(root == null)
			return true;
		return false;
	}
}
