public class Matrix{
  private double[][] arr;
  private int x;
  private int y;
  public void Matrix(){
    this.x = 0;
    this.y = 0;
  }
  public void Matrix(int xvalue, int yvalue){
    this.arr = new double[xvalue][yvalue];
  }
  public void Matrix(double[][] array){
    this.arr = array;
  }
  public double[][] rref(double[][] array){
    for(int i = 0; i < array.length; i++){
      if(array[i][i] != 0 ){
        for(int j = 0; j < array[i].length; j++){
          array[i][j] /= array[i][i];
        }
      }
    }
    for(int i = 1; i < array.length; i++){
      for(int j = 0; j < array[i].length; j++){
        array[i][j] = array[i][j]-array[i-1][j]*array[i][j];
      }
    }
  return array;
  }
}