package threelayer;


public class UserVO {
	private int _EmployeeID;
    private String _firstname;
    private String _lastname;
    private String _Birthday;
    private String _City;
    private int ProductID;
    private int UnitsInStock;
    private int UnitsOnOrder;
    
    private int Population;
    private String Month;
    private String City;
    private String HDate;
    /// <constructor>
    /// Constructor UserVO
    /// </constructor>
    public UserVO()
    {
        //
        // TODO: Add constructor logic here
        //
    }
    
    
    
    public int getidUser()
    {
    	return _EmployeeID;
    }

    public void setidUser(int value)
    {
    	_EmployeeID = value;
    }

    public String getfirstname()
    {
    	return _firstname;
    }
        
    public void setfirstname(String value)
    {
    	_firstname = value;
    }

    public String getlastname()
    {
    	return _lastname;
    }
    public void setlastname(String value)
    {
        _lastname = value;
    }    

    public String getbirthday()
    {
    	return _Birthday;
    }

    public void setbirthday(String value)
    {
    	_Birthday = value;
    }    
    
    public String getcity()
    {
    	return _City;
    }

    public void setcity(String value)
    {
    	_City = value;
    }    
    
    public void setPopulation(int value)
    {
    	Population = value;
    }
    
    public int getPopulation()
    {
    	return Population;
    }
        
    public void setMonth(String value)
    {
    	Month = value;
    }
    
    public String getMonth()
    {
    	return Month;
    }
        
    public void setCity(String value)
    {
    	City = value;
    }
    
    public String getCity()
    {
    	return City;
    }
    
    public int getProductID()
    {
    	return ProductID;
    }
        
    public void setProductID(int value)
    {
    	ProductID = value;
    }
    
    public int getUnitsInStock()
    {
    	return UnitsInStock;
    }
        
    public void setUnitsInStock(int value)
    {
    	UnitsInStock = value;
    }
    
    public int getUnitsOnOrder()
    {
    	return UnitsOnOrder;
    }
        
    public void setUnitsOnOrder(int value)
    {
    	UnitsOnOrder = value;
    }
}