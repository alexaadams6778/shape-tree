/*
 * Written by Alexa Adams
 */

public abstract class Shape implements Comparable<Shape>
{
	public abstract double getArea();
	
	public abstract String getType();
	
	public abstract String toString();
	
	public abstract String toFileString();
	
	public int compareTo(Shape other)
	{
		if(this.getArea() > other.getArea())
			return 1;
		else if(this.getArea() < other.getArea())
			return -1;
		else
			return this.getType().compareToIgnoreCase(other.getType());
	}
	
	public static class Circle extends Shape
	{
		private double radius;
		
		public Circle(double r)
		{
			radius = r;
		}
		
		public double getArea()
		{
			return radius * radius * Math.PI;
		}
		
		public String getType()
		{
			return "Circle";
		}
		
		public String toString()
		{
			return "Circle Radius: " + radius + " Area: " + getArea();
		}
		
		public String toFileString()
		{
			return "Circle\t" + radius;
		}
	}
	
	public static class Rectangle extends Shape
	{
		private double length;
		private double width;
		
		public Rectangle(double l, double w)
		{
			length = l;
			width = w;
		}
		
		public double getArea()
		{
			return length * width;
		}
		
		public String getType()
		{
			return "Rectangle";
		}
		
		public String toString()
		{
			return "Rectangle Length: " + length + " Width: " + width + " Area: " + getArea();
		}
		
		public String toFileString()
		{
			return "Rectangle\t" + length + "\t" + width;
		}
	}
	
	public static class RightTriangle extends Shape
	{
		private double base;
		private double height;
		
		public RightTriangle(double b, double h)
		{
			base = b;
			height = h;
		}
		
		public double getArea()
		{
			return base * height * 0.5;
		}
		
		public String getType()
		{
			return "Right Triangle";
		}
		
		public String toString()
		{
			return "Right Triangle Base: " + base + " Height: " + height + " Area: " + getArea();
		}
		
		public String toFileString()
		{
			return "Right Triangle\t" + base + "\t" + height;
		}
	}
}
