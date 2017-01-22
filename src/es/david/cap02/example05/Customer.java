package es.david.cap02.example05;

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
	
	///////////////////////////////////////
	///////////////////////////////////////
	/**
	 * Metodo que tiene dos funciones de entrada 
	 * @param test Funcion que controlara el valor de la funcion si queremos enable o !enable
	 * @param func Funcion para controlar que valor del atributo queremos
	 * @return
	 */
	public static <B> List <B> getField(Function1<Customer, Boolean> test, Function1<Customer, B> func)
	{
		ArrayList<B> outList = new ArrayList<B>();
		for(Customer customer: Customer.allCustomers)
		{
			if(test.call(customer))
			{
				outList.add(func.call(customer));
			}
		}
		return outList;
	}

	public static final Function1<Customer, Boolean> EnabledCustomer = 
		new Function1<Customer,Boolean>()
		{
			@Override
			public Boolean call(Customer customer) 
			{
				return customer.enable == true; // return customer.enable;
			}
		};
	
	/**
	 * Funcion en la que obtenemos un <b>true</b> si el customer tiene el atributo en false
	 */
	public static final Function1<Customer, Boolean> DisabledCustomer = 
		new Function1<Customer,Boolean>()
		{
			@Override
			public Boolean call(Customer customer) 
			{
				return customer.enable == false; // return !customer.enable;
			}
		};
		
	public static List<String> getDisabledCustomerNames()
	{
		return Customer.getField
				(
					Customer.DisabledCustomer, 			// Funcion para obtener los disale
					new Function1<Customer,String>() 	// Funcion lambda
					{
						@Override
						public String call(Customer customer) 
						{
							return customer.name;
						}
						
					}
				);
	}
}
