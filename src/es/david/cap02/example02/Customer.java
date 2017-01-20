package es.david.cap02.example02;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	public Integer id = 0;

	public String name = "";
	public String adress = "";
	public String state = "";
	public String primaryContact = "";
	public String domanin = "";
	public Boolean enable = true;

	public Customer() {
	}

	private interface Function1<A1, B> 
	{
		public B call(A1 in1);
	}

	private static class CustomerAddres implements Function1<Customer, String> {
		@Override
		public String call(Customer customer) {
			return customer.adress;
		}
	}

	private static class CustomerName implements Function1<Customer, String> {
		@Override
		public String call(Customer customer) {
			return customer.name;
		}
	}

	private static class CustomerState implements Function1<Customer, String> {
		@Override
		public String call(Customer customer) {
			return customer.state;
		}
	}

	private static class CustomerPrimaryContact implements Function1<Customer, String> {
		@Override
		public String call(Customer customer) {
			return customer.primaryContact;
		}
	}
	private static class CustomerDomain implements Function1<Customer, String>
	{
		@Override
		public String call(Customer customer) 
		{
			return customer.domanin;
		}
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
	
	public static List<String> getEnabledCustomerAddresses()
	{
		return Customer.getEnableCustomerField(new CustomerAddres());
	}
	public static List<String> getEnabledCustomerNames()
	{
		return Customer.getEnableCustomerField(new CustomerName());
	}
	public static List<String> getEnabledCustomerState()
	{
		return Customer.getEnableCustomerField(new CustomerState());
	}
	public static List<String> getEnabledCustomerPrimaryContact()
	{
		return Customer.getEnableCustomerField(new CustomerPrimaryContact());
	}
	public static List<String> getEnabledCustomerDomains()
	{
		return Customer.getEnableCustomerField(new CustomerDomain());
	}
	
	// si quisieramos una funcion que nos devuelva todos los Customer
	private static class CustomerAsCustomer implements Function1<Customer, Customer>
	{
		@Override
		public Customer call(Customer customer) 
		{
			return customer;
		}
	}	
	
	//////////////////////////////////////////////////////////////////////////////////
	//funciones lambda
	//////////////////////////////////////////////////////////////////////////////////
	public static List<String> getEnabledCustomerAddresdAnonimous() 
	{
		return Customer.getEnableCustomerField
		(
			new Function1<Customer, String>() 
			{
				public String call(Customer customer){return customer.adress;}
			}
		);
	}
}