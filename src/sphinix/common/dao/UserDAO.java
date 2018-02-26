package sphinix.common.dao;


public interface UserDAO{
	public boolean checkUser(String userName, String password)throws Exception;
	
}
