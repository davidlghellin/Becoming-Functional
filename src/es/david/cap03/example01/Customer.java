package es.david.cap03.example01;

import java.util.ArrayList;
import java.util.List;

public class Customer 
{

	public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	public Integer id = 0;

	public String name = "";
	public String adress = "";
	public String state = "";
	public String primaryContact = "";
	public String domanin = "";
	public Boolean enable = true;

	// añadimos contract
	public Contract contract;

	public Customer() {}
	
	public interface Function1<A1,B>
	{
		public B call(A1 a1);
	}
	
	public static Customer getCustomerById(Integer customer_id)
	{
		for (Customer customer : Customer.allCustomers) 
		{
			if(customer.id==customer_id)
				return customer;
		}
		return null;
	}
	
	public static ArrayList<Customer> getCustomerByIdList(Integer customer_id)
	{
		ArrayList<Customer> outList= new ArrayList<Customer>();
		for (Customer customer : Customer.allCustomers) 
		{
			if(customer.id==customer_id)
				outList.add(customer);
		}
		return outList;
	}
	
	public static ArrayList<Customer> filter(Function1<Customer, Boolean> test)
	{
		ArrayList<Customer> outList= new ArrayList<Customer>();
		for (Customer customer : Customer.allCustomers) 
		{
			if(test.call(customer))
				outList.add(customer);
		}
		return outList;
	}
	
	public static <B> List<B> getField
	(Function1<Customer, Boolean> test, Function1<Customer, B> func)
	{
		ArrayList<B> outList= new ArrayList<B>();
		for (Customer customer :Customer.filter(test)) 
		{
			outList.add(func.call(customer));
		}
		return outList;
	}
	
	public static ArrayList<Customer> getCustomerByIdList2(final Integer customer_id)
	{
		return Customer.filter(new Function1<Customer, Boolean>() 
		{
			@Override
			public Boolean call(Customer customer) 
			{
				return customer.id==customer_id;
			}
		});
	}
	
}
