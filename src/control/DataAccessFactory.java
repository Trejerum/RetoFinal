package control;

public class DataAccessFactory {

	private static DataAccess dataAccess;
	
	public static DataAccess getDataAccess() {
		if(dataAccess == null) {
			dataAccess = new DataAccessImpl();
		}
		return dataAccess;
	}
}
