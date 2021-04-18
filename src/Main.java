import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        //读取输入
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        //第一次拆分
        String[] sa = s.split(";");
        //第二次拆分
        String[] dou1 = sa[0].split(",");
        String[] dou2 = sa[1].split(",");
        String[] dou3 = sa[2].split(",");
        String[] int1 = sa[3].split(",");
        String[] dou4 = sa[4].split(",");
        String[] a = sa[5].split(",");

        Boolean flag = false;
        double count = 0;

        int x1 = Integer.parseInt(int1[0]);
        int x2 = Integer.parseInt(int1[1]);
        int x3 = Integer.parseInt(int1[2]);
        int x4 = Integer.parseInt(int1[3]);
        int x5 = Integer.parseInt(int1[4]);

        //循环判断
        for(int i=0;i<3;i++){
            //TODO dou2 dou3
            Double a11 = Double.parseDouble(dou1[0]);
            Double a12 = Double.parseDouble(dou1[1]);
            Double a13 = Double.parseDouble(dou1[2]);
            Double a14 = Double.parseDouble(dou1[3]);
            Double a15 = Double.parseDouble(dou1[4]);
            double temp = ((a11*x1 + a12*x2 + a13*x3 +a14*x4) - Double.parseDouble(dou4[i]));
            if(count<temp)
                count=temp;
            if("<".equals(a[i].toString())){
                if((a11*x1 + a12*x2 + a13*x3 +a14*x4) < Double.parseDouble(dou4[i])){
                    flag = true;
                }
            }
            if("<=".equals(a[i].toString())){
                if((a11*x1 + a12*x2 + a13*x3 +a14*x4) <= Double.parseDouble(dou4[i])){
                    flag = true;
                }
            }
            if(">".equals(a[i].toString())){
                if((a11*x1 + a12*x2 + a13*x3 +a14*x4) > Double.parseDouble(dou4[i])){
                    flag = true;
                }
            }
            if(">=".equals(a[i].toString())){
                if((a11*x1 + a12*x2 + a13*x3 +a14*x4) >= Double.parseDouble(dou4[i])){
                    flag = true;
                }
            }
            if("=".equals(a[i].toString())){
                if((a11*x1 + a12*x2 + a13*x3 +a14*x4) == Double.parseDouble(dou4[i])){
                    flag = true;
                }
            }
        }

        System.out.print(flag);
        System.out.print(" " + count);
        //2.3,3,5.6,7,6;    11,3,8.6,25,1;  0.3,9,5.3,66,7.8;   1,3,2,7,5;  340,670,80.6;   <=,<=,<=
    }
}
