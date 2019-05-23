package control;

public class LogicFactory {

	private static Logic logicI;
	
	public static Logic getLogic(){
		if(logicI==null) {
			logicI=new LogicImpl();
		}
		return logicI;
	}
}
