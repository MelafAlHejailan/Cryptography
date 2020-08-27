package elgamal;
import java.util.*;
public class Elgamal {
static String plainText="";
static String cipherText="";
static int q,a,xa,k; //k small is random k and K capital is one time key
static double ya;
public static void main(String[] args) {
Scanner input=new Scanner(System.in);
System.out.print(" Enter prime number (q): "); 
int w=input.nextInt();
if(isPrime(w)){
    q=w;}
 System.out.print(" Enter random number {k) : "); //choose random integer 1<= k <=q-1
  int S=input.nextInt();
  if(1 <= S && S <= q-1 ){
      k=S;}
System.out.print(" Enter your name: ");
String name=input.next();
GenerateKeys(); 
String cipher=Encryption(name,q,a,xa,k,ya); 
System.out.print(" The CipherText is : "+cipher);
System.out.println("");
System.out.print(" The PlainText is :"+plainText);
System.out.println("");}
public static void GenerateKeys(){
Random x = new Random ();
if(isPrime(q)){ //check if q is prime number or not
a=findPrimitive(q); //choose a which is a<q and primitive root of q
xa=1+x.nextInt(q-1); //key 1< xa < q-1
ya=Math.pow(a, xa) % q; //ya=a^xa mood q
System.out.println("Public Key:PU=q="+q+",a="+a+",ya="+ya);
System.out.println("Private key (xa): ="+xa);}}
public static String Encryption(String message,int q,int a,int xa,int k,double ya){
double M;
double K=Math.pow(ya,k) % q; // k=ya^k mood q , K capital is one time key
System.out.println("one time key (k)="+K);
for (int i = 0; i < message.length(); i++) {
M=ConvertCharacterToNumber(message.charAt(i));
double C1=Math.pow(a,k) % q; // c1=a^K mood q
double C2=M*K % q ; // c2=kM mood q
String CipherText="["+C1+","+C2+"]";
cipherText=cipherText+CipherText;
plainText=plainText+ConvertNumberToCharacter(Decryption(C1,C2,xa,q,M));}
return cipherText;}
public static String Decryption(double C1,double C2,int xa,int q,double M){ 
double K=Math.pow(C1,xa) % q; // K=(c1)^xa mod q
double K1 =Math.pow(C1,q-1-xa) % q; // k^-1 =c1^q-1-xa
M = C2 * K1 % q;  
return Double.toString(M);}
public static int ConvertCharacterToNumber(char character){
   switch(character){
       case 'A': case 'a': return 1;
       case 'B': case 'b': return 2;
       case 'C': case 'c': return 3;
       case 'D': case 'd': return 4;
       case 'E': case 'e': return 5;
       case 'F': case 'f': return 6;
       case 'G': case 'g': return 7;
       case 'H': case 'h': return 8;
       case 'I': case 'i': return 9;
       case 'J': case 'j': return 10;
       case 'K': case 'k': return 11;
       case 'L': case 'l': return 12;
       case 'M': case 'm': return 13;
       case 'N': case 'n': return 14;
       case 'O': case 'o': return 15;
       case 'P': case 'p': return 16;
       case 'Q': case 'q': return 17;
       case 'R': case 'r': return 18;
       case 'S': case 's': return 19;
       case 'T': case 't': return 20;
       case 'U': case 'u': return 21;
       case 'V': case 'v': return 22;
       case 'W': case 'w': return 23;
       case 'X': case 'x': return 24;
       case 'Y': case 'y': return 25;
       case 'Z': case 'z': return 26;
       default: return -1;}}
public static char ConvertNumberToCharacter(String Character1){
double x=Double.parseDouble(Character1);
if(x==1) return 'A';
else if(x==2) return 'B';
else if(x==3) return 'C';
else if(x==4) return 'D';
else if(x==5) return 'E';
else if(x==6) return 'F';
else if(x==7) return 'G';
else if(x==8) return 'H';
else if(x==9) return 'I';
else if(x==10) return 'J';
else if(x==11) return 'K';
else if(x==12) return 'L';
else if(x==13) return 'M';
else if(x==14) return 'N';
else if(x==15) return 'O';
else if(x==16) return 'P';
else if(x==17) return 'Q';
else if(x==18) return 'R';
else if(x==19) return 'S';
else if(x==20) return 'T';
else if(x==21) return 'U';
else if(x==22) return 'V';
else if(x==23) return 'W';
else if(x==24) return 'X';
else if(x==25) return 'Y';
else if(x==26) return 'Z';
else return '$';}
public static boolean isPrime(int n){
if (n <= 1){
return false;}
if (n <= 3){
return true;}
if (n % 2 == 0 || n % 3 == 0){
return false;}
for (int i = 5; i * i <= n; i = i + 6){
if (n % i == 0 || n % (i + 2) == 0){
return false;}}
return true;}
public static int power(int x, int y, int p){
int res = 1;
x = x % p; 
while (y > 0){
if (y % 2 == 1){
res = (res * x) % p;}
y = y >> 1; 
x = (x * x) % p;}
return res;}
public static void findPrimefactors( HashSet <Integer> set, int n){
while (n % 2 == 0){
set.add(2);
n = n / 2;}
for (int i = 3; i <= Math.sqrt(n); i = i + 2){
while (n % i == 0){
set.add(i);
n = n / i;}}
if (n > 2){
set.add(n);}}
public static int findPrimitive(int n) {
HashSet <Integer> s = new HashSet <Integer>();
if (isPrime(n) == false){
return -1;}
int phi = n - 1;
findPrimefactors(s, phi);
for (int r = 2; r <= phi; r++){
boolean flag = false;
for (Integer a : s){
if (power(r, phi / (a), n) == 1){
flag = true;
break;}}
if (flag == false){
return r; }}
return -1;}}