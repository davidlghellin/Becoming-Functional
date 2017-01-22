package es.david.cap02.example01;

import java.util.ArrayList;
import java.util.List;

public class Customer 
{
	public static  ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	public Integer id = 0;
	
	public String name = "";
	public String adress = "";
	public String state = "";
	public String primaryContact = "";
	public String domanin = "";
	public Boolean enable = true;
	
	public Customer(){}
	
	public static List<String> getEnabledCustomerNames()
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(customer.name);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomerStates()
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(customer.state);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomerPrimaryContact()
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(customer.primaryContact);
			}
		}
		return outList;
	}
	
	public static List<String> getEnabledCustomerDomains()
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(customer.domanin);
			}
		}
		return outList;
	}
	/*
	 * Como podemos ver en el codigo estamos repitiendo mucho copy-and-paste
	 */
	//////////////////////////////////////////////////////////////////////////////////
	/**
	 * Pasamos el campo y nos dara la lista con los nombres del campo que hemos pasado
	 * @param field
	 * @return
	 */
	public static List<String> getEnabledCustomerField(String field)
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				if(field == "name")
					outList.add(customer.name);
				
				else if(field == "state")
					outList.add(customer.state);
				
				else if(field == "primaryContact")
					outList.add(customer.primaryContact);
				
				else if(field == "domanin")
					outList.add(customer.domanin);
				else
					throw new IllegalArgumentException("field desconocido");
			}
		}
		return outList;
	}
	
	//////////////////////////////////////////////////////////////////////////
	
	private interface ConversionFunction
	{
		public String call(Customer customer);
	}
	
	public static List<String> getEnabledCustomerField(ConversionFunction fun)
	{
		ArrayList<String> outList = new ArrayList<String>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(fun.call(customer));
			}
		}
		return outList;
	}
	
	static private class CustomerAddres2 implements ConversionFunction
	{
		@Override
		public String call(Customer customer) 
		{
			return customer.adress;
		}
	}

	public static List<String> getEnabledCustomerAddreses() 
	{
		return Customer.getEnabledCustomerField(new CustomerAddres2());
	}
	
	/////////////////////////////////////////////////////////////////
	public interface Function1<A1,B>
	{
		public B call(A1 a1);
	}
	
	private static class CustomerAddres implements Function1<Customer, String>
	{
		@Override
		public String call(Customer customer) 
		{
			return customer.adress;
		}
	}

	public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> func)
	{
		ArrayList<B> outList = new ArrayList<B>();
		for(Customer customer: Customer.allCustomers)
		{
			if(customer.enable)
			{
				outList.add(func.call(customer));
			}
		}
		return outList;
	}
	
}
