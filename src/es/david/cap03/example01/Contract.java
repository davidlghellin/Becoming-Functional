package es.david.cap03.example01;

import java.util.Calendar;

public class Contract 
{
	public Calendar begin_dates;
	public Calendar end_dates;
	public Boolean enable = true;
	
	public Contract(Calendar begin_dates)
	{
		this.begin_dates=begin_dates;
		this.end_dates=this.begin_dates.getInstance();
		this.end_dates.setTimeInMillis(this.begin_dates.getTimeInMillis());
		this.end_dates.add(Calendar.YEAR, 2);
		
	}
	
	public static void setContractDisableForCustomer(Integer customer_id)
	{
		for (Customer customer : Customer.allCustomers) 
		{
			if(customer.id ==customer_id)
				customer.contract.enable = false;
		}
	}
	
	////////////////////////////////////////////////
	///ejemplo 3-7
	////////////////////////////////////////////////
	public static void setContractDisableForCustomer2(Integer customer_id)
	{
		for (Customer customer : Customer.getCustomerByIdList2(customer_id)) 
		{
			customer.contract.enable =    true;
		}
	}
}
