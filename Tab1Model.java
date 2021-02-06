public class Tab1Model{




  public float a,b,c,accuracy,y;
  public int fun_ID;
  public float xStart,xEnd;

	public void setInit(float a,float b,float c,int fun_ID,float xStart,float xEnd, float accuracy){

		this.a =a;
	    this.b = b; 
	    this.c = c; 
	    this.fun_ID = fun_ID; 
	    this.xStart = xStart; 
	    this.xEnd = xEnd;
	    this.accuracy = accuracy;
	}

    public float rangeY(){

        float y_min = calculateY(xStart), y_max = calculateY(xStart),y;

        for(float x=xStart;x<=xEnd;x+=(float)(xEnd-xStart)/100000) {
            y = calculateY(x);

            if (y > y_max){
                y_max = y;
            }
            else if(y < y_min){

                y_min = y;
            }

        }
       return  2*( (Math.abs(y_min) < Math.abs(y_max))? Math.abs(y_max): Math.abs(y_min));
    }


    public float rangeX(){
        return 2*( (Math.abs(xStart) < Math.abs(xEnd))? Math.abs(xEnd): Math.abs(xStart));
    }


    public float calculateY(float x)
    {
        if (fun_ID==1) {


            y = a * x +   b + c;

            return y;
        }
        else if (fun_ID==2) {

            y = a * x*x + b*x - c;

           return y;

        }
        else if (fun_ID==3) {

            y = a * x*x*x +  b*x*x + c;

            return y;
        }

        return  0;

    }

    public float findRoot()
    {
        float ans = xStart;
        float a=xStart;
        float b=xEnd;



            while ((b-a)>accuracy)
            {
                
                   if (Math.abs(calculateY(ans)) <= accuracy)
                    break;
                    // Find middle point
                
                // Check if middle point is root
                     ans = (a+b)/(float)2;

                    // Decide the side to repeat the steps
                if ((calculateY(ans))*calculateY(a) < 0)
                    b = ans;
                else
                    a = ans;

                // System.out.println("there is infinii cycly   "+accuracy + " ans  "+ ans);
                // System.out.println(a+" a  b  "+b);


            }
            //prints value of c upto 4 decimal places
        
            return ans;
    }


    public float findRootSecant()
    {
        //secant method
        /// https://www.geeksforgeeks.org/program-to-find-root-of-an-equations-using-secant-method/
        float x1=xStart;
        float x2=xEnd;
        double  E = accuracy;
        float n = 0, xm, x0, c;


            do {

                // calculate the intermediate
                // value
                x0 = (x1 * calculateY(x2) - x2 * calculateY(x1))
                        / (calculateY(x2) - calculateY(x1));

                // check if x0 is root of
                // equation or not
                c = calculateY(x1) * calculateY(x0);

                // update the value of interval
                x1 = x2;
                x2 = x0;

                // update number of iteration
                n++;

                // if x0 is the root of equation
                // then break the loop
                if (c == 0)
                    break;
                xm = (x1 * calculateY(x2) - x2 * calculateY(x1))
                        / (calculateY(x2) - calculateY(x1));

                // repeat the loop until the
                // convergence
            } while (Math.abs(xm - x0) >= E);

            
            return x0;

    }





	
}