package es.david.cap02.example03;

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
	
	/**
	 * 
	 * @author wizord
	 *
	 * Interface de la funcion que usaremos para las lambda
	 * @param <A1> parametro de entrada
	 * @param <B> parametro de salida
	 */
	private interface Function1<A1, B> 
	{
		public B call(A1 in1);
	}
	
	public static <B> List<B> getEnableCustomerField(Function1<Customer, B> func) 
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
	
	public static List<String> getEnableCustomerAddresses()
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return in1.adress;
				}
			}
		);
	}
	public static List<String> getEnableCustomerDomains()
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return in1.domanin;
				}
			}
		);
	}
	public static List<String> getEnableCustomerStates()
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return in1.state;
				}
			}
		);
	}
	public static List<String> getEnableCustomerPrimaryCotact()
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return in1.primaryContact;
				}
			}
		);
	}
	
	////////////////////////////////////////////////////////////////////
	///Direccion de correo de los dominios
	public static List<String> getEnableCustomerBossesEmail()
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return "boss@" + in1.domanin;
				}
			}
		);
	}
	//si queremos los presidents podriamos repetir el metodo anterior pero no cumpliriamos  el principio DRY 

	public static List<String> getEnableCustomerSomeoneEmail(final String someone)
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				@Override
				public String call(Customer in1) 
				{
					return someone + "@" + in1.domanin;
				}
			}
		);
	}
	


}
