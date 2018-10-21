package threelayer;


import java.sql.ResultSet;


public class UserDAO {
	private dbConnection conn;

    /// <constructor>
    /// Constructor UserDAO
    /// </constructor>
    public UserDAO()
    {
        conn = new dbConnection();
    }

    /// <method>
    /// Get User Email By Firstname or Lastname and return DataTable
    /// </method>
    public ResultSet searchByName(String _username)
    {
		String [] arr = _username.split("\\s+");
		String firstname=arr[0];
		String lastname=arr[1];
        String query = "select * from Employees where FirstName='"+firstname+"' or LastName='"+lastname+"'";
        	
        return conn.executeSelectQuery(query);
    }

    /// <method>
    /// Get User Email By Id and return DataTable
    /// </method>
    public ResultSet searchById(String _id)
    {
        String query = "select * from Employees where EmployeeID = "+_id;
      
        return conn.executeSelectQuery(query);
    }
    

	public ResultSet searchPopulationOfBirthday() {
		// TODO Auto-generated method stub
		String query = "select Datename(month,BirthDate) as month,count(*) population from Employees group by Datename(month,BirthDate)";

        return conn.executeSelectQuery(query);
		
	}
	
	public ResultSet searchSupplierOfCity() 
	{
		String query = "select City,count(*) population from Employees group by City";
        
        return conn.executeSelectQuery(query);
	}
	
	public ResultSet searchInStockAndOnOrder() 
	{
		String query = "select ProductID,UnitsInStock,UnitsOnOrder from Products";
        
        return conn.executeSelectQuery(query);
	}
}
