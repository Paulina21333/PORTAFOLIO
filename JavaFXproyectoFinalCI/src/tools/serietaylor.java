package tools;

public class serietaylor {
   private double X;
   private int N;

    public serietaylor() {
    }

    public serietaylor(double X, int N) {
        this.X = X;
        this.N = N;
    }

    public double getX() {
        return X;
    }

    public void setX(double X) {
        this.X = X;
    }

    public int getN() {
        return N;
    }

    public void setN(int N) {
        this.N = N;
    }

    @Override
    public String toString() {
        return "serietaylor{" + "X=" + X + ", N=" + N + '}';
    }
   public static double factorial(double N){
   if (N == 0){
   return 1;
   }
   else{
   return N * factorial(N -1);
   }
   }
   
   public static double taylor(double X, int N){
   double result = 1; 
    
    for (int i = 1; i <= N; i++) {
        result += Math.pow(X, i) / factorial(i);
    }
    
    return result;
   }
}

