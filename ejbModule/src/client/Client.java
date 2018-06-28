package src.client;

import src.MySessionBeanRemote;
import src.entity.Employee;

import java.util.Hashtable;
import java.util.Properties;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.InitialContext;


public class Client {

	private static final String LOOKUP_STRING = "java:comp/env/ejb/MySessionBean";  //"java:global/MyEjbProject/src/MySessionBean"; //MySessionBean#src.MySessionBeanRemote

//	private static final String INITIAL_CONTEXT_FACTORY = "weblogic.jndi.WLInitialContextFactory";//org.jnp.interfaces.NamingContextFactory
	private static Context initialContext;

	public static void main(String[] args) {
		MySessionBeanRemote remote = doLookup();
		Employee employee = new Employee();
		
		employee.setFirstName("ghazaleh");
		employee.setLastName("shahrokhi");
		employee.setEmail("gh.nshahrokhi@gmail.com");

		Employee employee1 = new Employee();
		employee1.setFirstName("test");
		employee1.setLastName("test1");
		employee1.setEmail("testi@gmail.com");
		remote.addEmployee(employee);
		remote.addEmployee(employee1);
	}
	

	public static Context getInitialContext() throws NamingException {
//		if (initialContext == null) {
//			// Properties extends HashTable
//			Properties prop = new Properties();
//			prop.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
////			prop.put(Context.URL_PKG_PREFIXES, JNP_INTERFACES);
//			prop.put(Context.PROVIDER_URL,  "t3://localhost:7001");
//			
////		    prop.put("java.naming.factory.url.pkgs", "weblogic.jndi.factories:weblogic.corba.j2ee.naming.url");  
//		    prop.put( Context.SECURITY_PRINCIPAL, "weblogic");  
//		    prop.put( Context.SECURITY_CREDENTIALS, "weblogic1");
			initialContext = new InitialContext();
//		}
		
		
//		weblogic.jndi.Environment environment = new weblogic.jndi.Environment();
//		environment.setInitialContextFactory(weblogic.jndi.Environment.DEFAULT_INITIAL_CONTEXT_FACTORY);
//		environment.setProviderURL("t3://localhost:7001");
//		environment.setSecurityPrincipal("weblogic");
//		environment.setSecurityCredentials("weblogic1");
//		initialContext = (InitialContext) environment.getInitialContext();
		
		
//		  Hashtable<String, String> ht = new Hashtable<String, String>();
//		  ht.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
//		  ht.put(Context.PROVIDER_URL,"t3://localhost:7001");
//		  ht.put("java.naming.factory.url.pkgs", "weblogic.jndi.factories:weblogic.corba.j2ee.naming.url");  
//		  ht.put( Context.SECURITY_PRINCIPAL, "weblogic");  
//		  ht.put( Context.SECURITY_CREDENTIALS, "weblogic1");
//		 
//		  try {
//			  initialContext = new InitialContext(ht);
//		    // Use the context in your program
//		  }
//		  catch (NamingException e) {
//		    // a failure occurred
//		  }
//		  finally {
//		    try {initialContext.close();}
//		    catch (Exception e) {
//		      // a failure occurred
//		    }
//		  }
		
		
		return initialContext;
	}
	

	private static MySessionBeanRemote doLookup() {
		Context context = null;
		MySessionBeanRemote bean = null;
		try {
			// 1. Obtaining Context
			context = getInitialContext();
			// 2. Lookup and cast
//			weblogic.ejb.spi.BusinessObject obj = (weblogic.ejb.spi.BusinessObject) context.lookup("MyEJBRemoteMappedName#br.com.ejbclient.MyEJBRemote");
//			EmployeeInterface myEJB = (EmployeeInterface) obj._WL_getBusinessObjectHandle().getBusinessObject();
			bean = (MySessionBeanRemote) context.lookup(LOOKUP_STRING);
		} catch (NamingException e) {
			e.printStackTrace();
		}
		return bean;
	}

}


