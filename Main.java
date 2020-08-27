import java.math.BigInteger ;
import java.util.Scanner;
import java.lang.*;
//The code I used to spigot calculate the digits of pi was found by using the Pi rosetta code found at
//https://rosettacode.org/wiki/Pi#Java
 
public class Main {
  final BigInteger TWO = BigInteger.valueOf(2) ;
  final BigInteger THREE = BigInteger.valueOf(3) ;
  final BigInteger FOUR = BigInteger.valueOf(4) ;
  final BigInteger SEVEN = BigInteger.valueOf(7) ;
 
  BigInteger q = BigInteger.ONE ;
  BigInteger r = BigInteger.ZERO ;
  BigInteger t = BigInteger.ONE ;
  BigInteger k = BigInteger.ONE ;
  BigInteger n = BigInteger.valueOf(3) ;
  BigInteger l = BigInteger.valueOf(3) ;
  String s2="";
    
  public void calcPiDigits()
  {
    BigInteger nn, nr ;
    int i=0;
    {
        while(i<1)
        {
        if(FOUR.multiply(q).add(r).subtract(t).compareTo(n.multiply(t)) == -1)
        {
          int num=n.intValue(); //Rosetta code had an if statemengt to create a decimal point for 3.1, I deleted this so pi string starts with 31
          s2=Integer.toString(num);
          i++;
          nr = BigInteger.TEN.multiply(r.subtract(n.multiply(t))) ;
          n = BigInteger.TEN.multiply(THREE.multiply(q).add(r)).divide(t).subtract(BigInteger.TEN.multiply(n)) ;
          q = q.multiply(BigInteger.TEN) ;
          r = nr ;
          System.out.flush() ;
        }
        else
        {
          nr = TWO.multiply(q).add(r).multiply(l) ;
          nn = q.multiply((SEVEN.multiply(k))).add(TWO).add(r.multiply(l)).divide(t.multiply(l)) ;
          q = q.multiply(k) ;
          t = t.multiply(l) ;
          l = l.add(TWO) ;
          k = k.add(BigInteger.ONE) ;
          n = nn ;
          r = nr ;
        }
        }
    }
  }
 
  public static void main(String[] args) {
    Main p = new Main() ;
    boolean check=false;
    boolean found=false;
    String myZip="";
    int count=1;
    Scanner scan = new Scanner(System.in);
        while(!check)
        {
            System.out.println("Let's find your zip code in 1 millon digits of");
            System.out.println("Enter 5 digit zipcode: ");
            int zippy = scan.nextInt();
            myZip=Integer.toString(zippy);
            if(myZip.length()==5)
            {
                check=true;
            }
            else
            {
                System.out.println("Please enter zipcode in 5 digit format");
            }
        }

   
    for(int i=0; i<=1000000;i++)
     //This code works, but it takes a VERY long time when there is 1000000 digits of pi. When I made i<=1000, it found everything quite quickly (of course)
    {
        p.calcPiDigits();
        if(p.s2.charAt(0)==myZip.charAt(0))
        {
            p.calcPiDigits();
            if(p.s2.charAt((0))==myZip.charAt(1))
            {    p.calcPiDigits();
                 if(p.s2.charAt((0))==myZip.charAt(2))
                 {
                    p.calcPiDigits();
                    if(p.s2.charAt((0))==myZip.charAt(3))
                    {
                        p.calcPiDigits();
                         if(p.s2.charAt((0))==myZip.charAt(4))
                         {
                              System.out.println("We found your zip in the "+ count +" position of pi!");
                              found=true;
                         }
                        
                    }
                 }
            }
            
        }
        count++;

        
    }
    while(!found)
        {
            System.out.println("Zipcode not found in 1000000 digits of pi!");
            found=true;
        }
    
  }
}
