/*
 * Written by Alexa Adams
 */

import java.util.Scanner;

public class ShapeTreeHelper {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		ShapeBST ShapeTree = new ShapeBST();
		int choice;
		String type;
		double radius, base, height, length, width, area;
		
		System.out.print("Welcome to the Shape Tree Program!\n");
		
		do
		{
			System.out.print("\nSelect an option below:\n\n\t1. To read a shape tree from a file."
					+ "\n\t2. To print a tree traversal to the console.\n\t3. To add a shape\n\t"
					+ "4. To remove a shape.\n\t5. To search for a shape.\n\t6. To find the shape "
					+ "with the max area.\n\t7. To remove all shapes greater than an area.\n\t8. To print the shape tree to file.\n\t9. Quit.\n\n\tYour choice: ");
    		
			choice = scanner.nextInt();
			scanner.nextLine();	//clears buffer (\n leftover)
			
			switch(choice)
    		{
    			case 1: 	//reads a shape tree from a file
    				System.out.print("\nEnter the file name: ");
    				String inputFile = scanner.nextLine().trim();
    				ShapeTree.readFromFile(inputFile);
    				System.out.println("\nPrinting after Reading In-Order");
    				ShapeTree.printInOrder();
    				break;
    			
    			case 2:	//prints a user-entered tree traversal
    				if(ShapeTree.isEmpty())
    					System.out.println("\nThe shape tree is empty.");
    				else
    				{
	    				System.out.print("\nWhich traversal?\n\nEnter 1 for pre-order, 2, for in-order, or 3 for post-order: ");
	    				int traversal = Integer.parseInt(scanner.nextLine());
	    				while(traversal < 1 || traversal > 3)
	    				{
	    					System.out.print("\nInvalid input. Enter 1 for pre-order, 2, for in-order, or 3 for post-order: ");
	    					traversal = Integer.parseInt(scanner.nextLine());
	    				}
	    				
	    				if(traversal == 1)
	    					ShapeTree.printPreOrder();
	    				else if(traversal == 2)
	    					ShapeTree.printInOrder();
	    				else
	    					ShapeTree.printPostOrder();
    				}
    				break;
    				
    			case 3:		//adds a shape to the shape tree
    				System.out.print("\nEnter the type of shape: ");
    				type = scanner.nextLine().trim();
    				while(!type.equalsIgnoreCase("circle") && !type.equalsIgnoreCase("right triangle") && !type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nInvalid type. Enter circle, rectangle, or right triangle: ");
    					type = scanner.nextLine().trim();
    				}
    				
    				if(type.equalsIgnoreCase("circle"))
    				{
    					System.out.print("\nEnter the radius: ");
        				radius = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.add(new Shape.Circle(radius));
    				}
    				else if(type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nEnter the length: ");
        				length = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the width: ");
        				width = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.add(new Shape.Rectangle(length, width));
    				}
    				else if(type.equalsIgnoreCase("right triangle"))
    				{
    					System.out.print("\nEnter the base: ");
        				base = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the height: ");
        				height = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.add(new Shape.RightTriangle(base, height));
    				}
    				break;
    				
    			case 4:		//removes a shape from the shape tree
    				System.out.print("\nEnter the type of shape you want to remove: ");
    				type = scanner.nextLine().trim();
    				
    				while(!type.equalsIgnoreCase("circle") && !type.equalsIgnoreCase("right triangle") && !type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nInvalid type. Enter circle, rectangle, or right triangle: ");
    					type = scanner.nextLine().trim();
    				}
    				
    				if(type.equalsIgnoreCase("circle"))
    				{
    					System.out.print("\nEnter the radius: ");
        				radius = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.remove(new Shape.Circle(radius));
    				}
    				else if(type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nEnter the length: ");
        				length = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the width: ");
        				width = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.remove(new Shape.Rectangle(length, width));
    				}
    				else if(type.equalsIgnoreCase("right triangle"))
    				{
    					System.out.print("\nEnter the base: ");
        				base = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the height: ");
        				height = scanner.nextDouble();
        				scanner.nextLine();
        				ShapeTree.remove(new Shape.RightTriangle(base, height));
    				}
    				break;
    				
    			case 5:		//searches for a shape in the shape tree
    				System.out.print("\nEnter the type of shape you want to find: ");
    				type = scanner.nextLine().trim();
    				boolean found = false;
    				
    				while(!type.equalsIgnoreCase("circle") && !type.equalsIgnoreCase("right triangle") && !type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nInvalid type. Enter circle, rectangle, or right triangle: ");
    					type = scanner.nextLine().trim();
    				}
    				
    				if(type.equalsIgnoreCase("circle"))
    				{
    					System.out.print("\nEnter the radius: ");
        				radius = scanner.nextDouble();
        				scanner.nextLine();
        				found = ShapeTree.search(new Shape.Circle(radius));
    				}
    				else if(type.equalsIgnoreCase("rectangle"))
    				{
    					System.out.print("\nEnter the length: ");
        				length = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the width: ");
        				width = scanner.nextDouble();
        				scanner.nextLine();
        				found = ShapeTree.search(new Shape.Rectangle(length, width));
    				}
    				else if(type.equalsIgnoreCase("right triangle"))
    				{
    					System.out.print("\nEnter the base: ");
        				base = scanner.nextDouble();
        				scanner.nextLine();
        				System.out.print("\nEnter the height: ");
        				height = scanner.nextDouble();
        				scanner.nextLine();
        				found = ShapeTree.search(new Shape.RightTriangle(base, height));
    				}
    				
    				if(found)
    					System.out.print("\nThe shape was in the tree.\n");
    				else
    					System.out.print("\nThe shape was not in the tree.\n");
    				break;
    				
    			case 6:		//finds the shape with the max area
    				Shape maxShape = ShapeTree.findMax();
    				
    				if (maxShape == null)
    				    System.out.println("\nThe tree is empty.");
    				else
    				    System.out.println("\nThe shape with the max area " + maxShape);
    				break;
    				
    			case 7:		//removes all shapes greater than an area
    				System.out.print("Enter the maximum area: ");
					area = scanner.nextDouble();
					scanner.nextLine();
					ShapeTree.removeGreaterThan(area);
    				break;
    				
    			case 8:		//prints shape tree to file
    				System.out.print("\nEnter the file name: ");
    				String outputFile = scanner.nextLine().trim();
    				ShapeTree.writeToFile(outputFile);
    				System.out.println("\nTree written to " + outputFile);
    				break;
    			
    			case 9:		//quit
    				System.out.print("\n\tGoodbye!");
    				break;
    				
    			default:
    				System.out.println("\nThat is not a valid choice. Try again.");
    				break;
    		}
			
		}while(choice != 9);
		
		scanner.close();
	}

}
