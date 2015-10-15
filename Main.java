import java.util.*;
import java.util.regex.*;
import static java.lang.System.out;

public class Main {

    public static boolean works(String a, String b) {
	/*	boolean ayy;
	StringBuilder sb = new StringBuilder();
	sb.append(".*");
	for( int i = 0; i < b.length(); i++ )
	{
	    sb.append(b.charAt(i));
	    sb.append(".*");
	}

	return Pattern.matches( sb.toString(), a );*/
	if (a.equals(b)) return false;

	int count=0;
	for (int i=0;i<a.length();i++ ){
	    if (a.charAt(i)==b.charAt(count)) {
		count++;
	    }
	    if (count==b.length()) break;
	    
	}
	return count==b.length();
	    
    }
    public static int comp(String a, String b) {
	return -(a.length() - b.length());
    }
    public static void main(String args[]){

	
	Scanner sc=new Scanner(System.in);
	int n;
	try {
	    while (true){
		n=sc.nextInt();
		if (n==0) continue;
		String master=sc.next();
		ArrayList<String> ar=new ArrayList<String>();
	    
		for (int i=0;i<n;i++) {
		    ar.add(sc.next());
		    
		}
		//		ar.sort((p1,p2)->comp(p1,p2));
		Collections.sort(ar,new Comparator<String>() { 
			public int compare(String a, String b) {
			    return -(a.length() - (b.length()));
			}
		    });
		Stack <String> st1=new Stack<String>();
		Stack<String> st2=new Stack<String>();
		
		st1.push(master);
		st2.push(master);
		boolean HALL=true;
		for (int i=0;i<n && HALL;i++) {
		    
		    if (works(st1.peek(),ar.get(i))){
			st1.push(ar.get(i));
		    }
		    else if (works(st2.peek(),ar.get(i))) {
			st2.push(ar.get(i));
		    }
		    else {

			HALL=false;
		    
		    //aiwugefiuawef
		    }
		}

		if (!HALL) {
		    out.println("impossible");
		}
		else {
		    int siz1=st1.size()-1;
		    int siz2=st2.size()-1;
		    if (siz1<siz2) {
			out.println(siz1+" "+siz2);
			for (int i=0;i<siz1;i++) 
			    out.println(st1.pop());
			for (int i=0;i<siz2;i++) 
			    out.println(st2.pop());
		    }
		    else{
			out.println(siz2+" "+siz1);
			for (int i=0;i<siz2;i++) 
			    out.println(st2.pop());
			for (int i=0;i<siz1;i++) 
			    out.println(st1.pop());
		    }

		}
	    }
	}
	catch(Exception e) {

	    //falwep[a;
	}

    }

}