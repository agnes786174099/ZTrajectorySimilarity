
public class DemoRJava {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CallR cr=new CallR();
		if(cr.connect())
			System.out.println("Connect R success..");
		
//		String s=(String)cr.doRCmd("R.version.string",ExpectType.STRING);
//		System.out.println(s);
		double[] arr=(double[])cr.doRCmd("rnorm(10)",ExpectType.DOUBLE_ARR);
		for(double a:arr)
			System.out.print(a+",");

		cr.closeR();
	}

	public void callRJava(){
//		double[] arr=re.eval("rnorm(10)").asDoubleArray();
//		for(double a:arr)
//			System.out.print(a+",");
	}
}
