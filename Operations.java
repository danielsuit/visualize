import java.util.ArrayList;
public class Operations{
  public String doOper(String f){
    ArrayList<String> ops = new ArrayList<String>();
    String add = "";
    for(int i = 0; i < f.length(); i++){
      if(f.charAt(i)!='+'&&f.charAt(i)!='-'&&f.charAt(i)!='*'&&f.charAt(i)!='/'&&f.charAt(i)!='^'){
        add += f.charAt(i);
        if(i == f.length()-1){
          ops.add(add);
        }
      }
      else{
        if(add.equals("")==false){
          ops.add(add);
          add = "";
        }
        ops.add(f.substring(i,i+1));
      }
    }
    for(int i = 0; i < ops.size(); i++){
      if(ops.get(i).equals("^")){
        double num = Math.pow(Double.parseDouble(ops.get(i-1)), Double.parseDouble(ops.get(i+1)));
        ops.remove(i-1);
        ops.remove(i-1);
        ops.remove(i-1);
        ops.add(i-1, String.valueOf(num));
        i = 0;
      }
    }
    for(int i = 0; i < ops.size(); i++){
      if(ops.get(i).equals("*")){
        double res = Double.parseDouble(ops.get(i-1))*Double.parseDouble(ops.get(i+1));
        ops.remove(i-1);
        ops.remove(i-1);
        ops.remove(i-1);
        ops.add(i-1, String.valueOf(res));
        i = 0;
      }
      if(ops.get(i).equals("/")){
        double res = Double.parseDouble(ops.get(i-1))/Double.parseDouble(ops.get(i+1));
        ops.remove(i-1);
        ops.remove(i-1);
        ops.remove(i-1);
        ops.add(i-1, String.valueOf(res));
        i = 0;
      }
    }
    for(int i = 0; i < ops.size(); i++){
      if(ops.get(i).equals("+")){
        double res = Double.parseDouble(ops.get(i-1))+Double.parseDouble(ops.get(i+1));
        ops.remove(i-1);
        ops.remove(i-1);
        ops.remove(i-1);
        ops.add(i-1, String.valueOf(res));
        i = 0;
      }
      if(ops.get(i).equals("-")){
        double res = Double.parseDouble(ops.get(i-1))-Double.parseDouble(ops.get(i+1));
        ops.remove(i-1);
        ops.remove(i-1);
        ops.remove(i-1);
        ops.add(i-1, String.valueOf(res));
        i = 0;
      }
    }
    for(int i = 0; i < ops.size(); i++){
      System.out.print(ops.get(i)+" ");
    }
    return ops.get(0);
  }
  public String parenthesesParse(String op){
    String dm1 = "(7-182)((12738))";
    int c = 0;
    for(int i = 0; i < dm1.length(); i++){
      if(dm1.charAt(i) == 41){
        c++;
      }
    }
    if(c == 0){
      return "";
    }
    String d = "";
    for(int i = 0; i < dm1.length(); i++){
      if(dm1.charAt(i) == 40){
        for(int j = i; j < dm1.length(); j++){
          if(dm1.charAt(j) != 40){
            d += dm1.charAt(j);
            continue;
          }
          else if(dm1.charAt(j) == 41){
            d+=')';
            d = doOper(d);
            dm1 = dm1.substring(0, i)+d+(i+d.length());
          }
          else if(dm1.charAt(j) == 40){
            break;
          }
        }
      }
    }
    System.out.println();
    return "";
  }
  
}