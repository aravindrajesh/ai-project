import java.util.Random;
public class simplegenalg {
    private int POP=30;
    private int LEN=10;
    private double MUT=10/LEN;
    private double REC=0.5;
    private double END=1000;
    private double SUMTARG=36;
    private double PRODTARG=360;
    private int[][]gene=new int[30][10];
    Random rnd=new Random();
    
    public simplegenalg()
    {}
        public void run()
{
int a,b,winner,loser;
getpop();
for(int t=0;t<END;t++)
{
a=(int)(POP * rnd.nextDouble());
b=(int)(POP * rnd.nextDouble());
if(evaluate(a)<evaluate(b))
{
winner=a;
loser=b;
}
else
{
winner=b;
loser=a;
}

for(int i=0;i<LEN;i++)
{
if(rnd.nextDouble()<REC)
{
gene[loser][i]=gene[winner][i];
}

if(rnd.nextDouble()<MUT)
{
gene[loser][i]=1-gene[loser][i];
}

if (evaluate(loser)==0.0)
{
display(t,loser);
}
}
}
}
public void display(int tno,int n)
{
System.out.println("after" +tno+ "tournements sum pile is");
for(int i=0;i<LEN;i++)
{
if(gene[n][i]==0)
{
System.out.println(+i+1);

}
}

System.out.println("product pile is ");
for(int i=0;i<LEN;i++)
{
if(gene[n][i]==1)
{
System.out.println(+i+1);
}
}
}
 public  double evaluate(int n)
{

int sum=0,prod=1;
double scaled_sum,scaled_prod,combinederror;
for(int i=0;i<LEN;i++)
{
if(gene[n][i]==0)
{
sum+=(i+1);
} 
else
{
prod*=(1+i);
}
}

scaled_sum=(sum-SUMTARG)/SUMTARG;
scaled_prod=(prod-PRODTARG)/PRODTARG;
combinederror=(Math.abs(scaled_sum))+(Math.abs(scaled_prod));
return combinederror;
} 
 public  void getpop()
{
for(int i=0;i<POP;i++)
{
for(int j=0;j<LEN;j++)
{
if(rnd.nextDouble()<0.5)
{
gene[i][j]=0;
}
else
{
gene[i][j]=1;
}
}
}
}
}