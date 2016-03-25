import org.rosuda.JRI.Rengine;

/**
 * expect value type
 */
enum ExpectType{
	STRING,DOUBLE_ARR
}

/***
 * remember to close R(closeR())
 * @author Daphnis
 *
 */
public class CallR {
	private Rengine rengine;
	
	/***
	 * connect R
	 * @return boolean
	 */
	boolean connect(){
		rengine=new Rengine(new String[]{"--vanilla"},false,null);
		if(!rengine.waitForR())
			return false;
		return true;		
	}
	
	/***
	 * close R
	 */
	void closeR(){
		if(rengine!=null)
			rengine.end();
	}
	
	Object doRCmd(String cmd,ExpectType et){
		switch(et){
		case STRING:return rengine.eval(cmd).asString();
		case DOUBLE_ARR:return rengine.eval(cmd).asDoubleArray();
			default:return null;
		}
	}
}
