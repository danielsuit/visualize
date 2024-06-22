  public class Graph {
  private int[][] arr;
  private int xmin;
  private int ymin;
  private int xmax;
  private int ymax;
  private Picture picture;
  public void Graph(){
    arr = new int[1000][1000];
    picture = new Picture(1000, 1000);
  }
  for(int i = 0; i < 1000; i++){
    for(int j = 0; j < 1000; j++){
      if((eval(i) - j) > -1 && (eval(i) - j) < 1){
        picture[i][j] = 1;
      }
    }
  }
  
}