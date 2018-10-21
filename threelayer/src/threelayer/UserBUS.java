package threelayer;


import java.sql.ResultSet;
import java.util.Vector;


public class UserBUS {
	private UserDAO _userDAO;

    /// <constructor>
    /// Constructor UserBUS
    /// </constructor>
    public UserBUS()
    {
        _userDAO  = new UserDAO();
    }

    /// <method>
    /// Get User Email By Firstname or Lastname and return VO
    /// </method>
    public Vector<UserVO> getEmpByName(String name)
    {
    	Vector<UserVO> result=new Vector<UserVO>();
        
        ResultSet dataTable = null;
        dataTable = _userDAO.searchByName(name);
        try
		{
        	while (dataTable.next()) 
    		{
            	UserVO userVO = new UserVO();
            	userVO.setidUser(dataTable.getInt("EmployeeID"));
            	userVO.setfirstname(dataTable.getString("FirstName"));
            	userVO.setlastname(dataTable.getString("LastName"));
            	userVO.setbirthday(dataTable.getString("BirthDate"));
            	userVO.setcity(dataTable.getString("City"));
            	result.add(userVO);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.print("错误:"+e.getStackTrace().toString());
		}
        return result;
    }

    /// <method>
    /// Get User Email By Id and return DataTable
    /// </method>
    
    public Vector<UserVO> getEmpById(String _id)
    {
        Vector<UserVO> result=new Vector<UserVO>();
        
        ResultSet dataTable = null;

        dataTable = _userDAO.searchById(_id);
        try
		{
        	while (dataTable.next()) 
    		{
            	UserVO userVO = new UserVO();
            	userVO.setidUser(dataTable.getInt("EmployeeID"));
            	userVO.setfirstname(dataTable.getString("Firstname"));
            	userVO.setlastname(dataTable.getString("LastName"));
            	userVO.setbirthday(dataTable.getString("BirthDate"));
            	userVO.setcity(dataTable.getString("City"));
            	result.add(userVO);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.print("错误:"+e.getStackTrace().toString());
		}
        return result;
    }
    
    public Vector<UserVO> getPopulationOfBirthdy()
    {
    	Vector<UserVO> result=new Vector<UserVO>();
        
        ResultSet dataTable = null;

        dataTable = _userDAO.searchPopulationOfBirthday();
        try
		{
        	while (dataTable.next()) 
    		{
            	UserVO userVO = new UserVO();
            	String month=dataTable.getString("month");
            	int pop=dataTable.getInt("population");
            	userVO.setMonth(month);
                userVO.setPopulation(pop);
                result.add(userVO);
            	
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.print("´啦啦啦:"+e.getStackTrace().toString());
		}
        return result;
    }
    
    public Vector<UserVO> getSupplierOfCity() 
    {
    	Vector<UserVO> result=new Vector<UserVO>();
        
        ResultSet dataTable = null;

        dataTable = _userDAO.searchSupplierOfCity();
        try
		{
        	while (dataTable.next()) 
    		{
            	UserVO userVO = new UserVO();
            	userVO.setCity(dataTable.getString("City"));
            	userVO.setPopulation(dataTable.getInt("population"));
            	result.add(userVO);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.print("´íÎó:"+e.getStackTrace().toString());
		}
        return result;
	}
    
    public Vector<UserVO> getInStockAndOnOrder() 
    {
    	Vector<UserVO> result=new Vector<UserVO>();
        
        ResultSet dataTable = null;

        dataTable = _userDAO.searchInStockAndOnOrder();
        try
		{
        	while (dataTable.next()) 
    		{
            	UserVO userVO = new UserVO();
            	userVO.setProductID(dataTable.getInt("ProductID"));
            	userVO.setUnitsInStock(dataTable.getInt("UnitsInStock"));
            	userVO.setUnitsOnOrder(dataTable.getInt("UnitsOnOrder"));
            	result.add(userVO);
    		}
		}
        catch(Exception e)
		{
			e.printStackTrace();
			
			System.out.print("´íÎó:"+e.getStackTrace().toString());
		}
        return result;
	}
}
