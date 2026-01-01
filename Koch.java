/** Draws the Koch curve and the the Koch snowflake fractal. */
public class Koch {

	public static void main(String[] args) {

		//// Uncomment the first code block to test the curve function.
		//// Uncomment the second code block to test the snowflake function.
		//// Uncomment only one block in each test, and remember to compile
		//// the class whenever you change the test.

        
		//curve(Integer.parseInt(args[0]),
			//   Double.parseDouble(args[1]), Double.parseDouble(args[2]), 
		    //   Double.parseDouble(args[3]), Double.parseDouble(args[4]));
		


		snowFlake(Integer.parseInt(args[0]));
	}

	/** Gets n, x1, y1, x2, y2,
     *  and draws a Koch curve of depth n from (x1,y1) to (x2,y2). */
	public static void curve(int n, double x1, double y1, double x2, double y2) {
		StdDraw.line(x1, y1, x2, y2);
		if (n != 0){
			double thx = (x2 - x1)/3.0;
			double thy = (y2 - y1)/3.0;
			double xl = x1 + thx;
			double yl = y1 + thy;
			double xr = x1 + 2.0 * thx;
			double yr = y1 + 2.0 * thy;
			
			double angle = Math.PI / 3.0; // 60°
    		double ux = xr - xl;
    		double uy = yr - yl;
			
			double xc = xl + ux * Math.cos(angle) - uy * Math.sin(angle);
			double yc = yl + ux * Math.sin(angle) + uy * Math.cos(angle);
			
			StdDraw.setPenColor(StdDraw.WHITE);
			StdDraw.line(xl, yl, xr, yr); 

			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.line(xl, yl, xc, yc);         
			StdDraw.line(xc, yc, xr, yr);
			
			curve(n-1,x1 ,y1 ,xl ,yl);
			curve(n-1,xl ,yl ,xc ,yc);
			curve(n-1,xc ,yc ,xr ,yr);
			curve(n-1,xr ,yr ,x2 ,y2);
		}

		//// Write the rest of your code below.
	}

    /** Gets n, and draws a Koch snowflake of n edges in the standard canvass. */
	public static void snowFlake(int n) {
		// A little tweak that makes the drawing look better
		StdDraw.setYscale(0, 1.1);
		StdDraw.setXscale(0, 1.1);

		double x1 = 0.2, y1 = 0.2;
    	double x2 = 0.8, y2 = 0.2;

    	double side = x2 - x1;
		double height = (Math.sqrt(3) / 2.0) * side; 

		double x3 = (x1 + x2) / 2.0; 
		double y3 = y1 + height;

		curve(n, x2, y2, x1, y1); 
		curve(n, x3, y3, x2, y2);  
		curve(n, x1, y1, x3, y3);
		// Draws a Koch snowflake of depth n
		//// Write the rest of your code below.
	}
}
