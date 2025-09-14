package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.customer;
import com.example.demo.Service.customerService;

@Controller
public class appcontroller
{
		@Autowired
		customerService obj;
		//bank front page
		@GetMapping("/")
		public String function0()
		{
			return "index";
		}
		//page not  found
		@GetMapping("/notfound")
		public String notfound()
		{
			return "notfound";
		}
		//main page with button
		@GetMapping("/main")
		public String mainwindow()
		{
			return "main";
		}
		//update records
		@GetMapping("/update")	
			public String updatewindow()
			{
				return"update";
			}
		
		
		//bank info page
		@GetMapping("/info")
		public String info()
		{
			return "info";
		}
		
		//display all record of customer
		@GetMapping("/show")
		public String function1(Model model)
		{
			model.addAttribute("records",obj.showAll());
			return "showdata";
		}
		//insert method to insert new details
		@GetMapping("/insert")
		public String insert()
		{
			return "insertdata";
		}
		//insert new account into database
		@SuppressWarnings({ "unused",})
		@PostMapping("/insertrecord")
		public String insertrecord(@RequestParam int gBank_ID,@RequestParam String gName,@RequestParam String gAddress,@RequestParam String gPhone_No,@RequestParam int gBalance,@RequestParam int gLoan_Amt,Model model)
		{
			customer s=new customer(gBank_ID,gName,gAddress,gPhone_No,gBalance,gLoan_Amt);
			if(s!=null)
			{
				obj.insertdata(s);
				model.addAttribute("records",obj.showAll());
				return "main";
			}
			else
			{
			return "notfound";
		    }
		}
		@GetMapping("/search")
		public String function2 ()
		{
			return "searchdata";
		}
		

		//searching by Bank_id
		@GetMapping("/searchbybankid")
		public String search(@RequestParam int gBank_ID,Model model)
		{
			//System.out.println("hi");
		Optional<customer> cust=obj.search(gBank_ID);
		if(cust.isPresent()==true)
		{
			
			customer c=cust.get();
			String x=" Bank_ID= "+c.getBank_ID()+"<br>"+" Name= "+c.getName()+"<br>"+" Address= "+c.getAddress()+"<br>"+" Phone_No= "+c.getPhone_No()+"<br>"+" Balance= "+c.getBalance()+"<br>"+" Loan_Amt ="+c.getLoan_Amt()+"<br>"; 
			//System.out.println(x);
			model.addAttribute("searchrecords",c);
			
	       return "showsearch";	
		}
		else
		{
			return "notfound";
		}
		}
		//delete details
		@GetMapping("/delete")
		public String function3()
		{
			return "deletedata";
		}
		@GetMapping("deletedbybankid")
		public String delete(@RequestParam int gBank_ID,Model model)
		{
			//System.out.println("hi");
			Optional<customer> cust=obj.search(gBank_ID);
			if(cust.isPresent()==true)
			{
			customer c=cust.get();
			obj.deletedata(gBank_ID);
			model.addAttribute("deleterecord",c);
			return "showdelete";			
		    }
			else
			{
				return "notfound";
			}
		
		}
		//deposit amount
		@GetMapping("/deposit")
		public String deposit()
		{
			return "deposit";
		}
		//deposit amt into existing account
		@PostMapping("/depositamt")
		public String deposit(@RequestParam int gBank_ID,@RequestParam int gDeposit,Model model)
		{
			//System.out.println("hi");
			Optional<customer> cust=obj.search(gBank_ID);
			if(cust.isPresent()==true)
			{
			customer c=cust.get();
			int bal=c.getBalance();
			int new_bal=bal+gDeposit;
			c.setBalance(new_bal);
			
			
			obj.insertdata(c);
			model.addAttribute("records",c);
			return "main";
		
				
		    }
			else
			{
				return "notfound";
			}
		
		}
		@GetMapping("/withdraw")
		public String withdraw()
		{
			return "withdraw";
		}
		@PostMapping("/withdrawamt")
		public String withdraw(@RequestParam int gBank_ID,@RequestParam int gDeposit,Model model)
		{
			//System.out.println("hi");
			Optional<customer> cust=obj.search(gBank_ID);
			if(cust.isPresent()==true)
			{
			customer c=cust.get();
			int bal=c.getBalance();
			int new_bal=bal-gDeposit;
			c.setBalance(new_bal);
			
			
			obj.insertdata(c);
			model.addAttribute("records",c);
			return "main";
		
				
		    }
			else
			{
				return "notfound";
			}
		
		}
		//admin login
		@GetMapping("/admin")
		public String admin()
		{
			return "admin";
		}
		@PostMapping("/adminlogin")
		public String login(@RequestParam String Username,@RequestParam int Password,Model model)
		{
			model.addAttribute("records",obj.showAll());
		
			String key="SHASHWAT_SINGH";
			int pass=7220541;
			if(Username.equals(key) && pass==Password)
			{
				return "showdata";
			}
			else
			{
				return "notfound";
			}
		
		}
		@GetMapping("/loan")
		public String loan()
		{
			return "loan";
		}
		@PostMapping("/loanamt")
	    public String loan(@RequestParam int gBank_ID,@RequestParam int Loanamt,Model model)
		{
			//System.out.println("hi");
			Optional<customer> cust=obj.search(gBank_ID);
			if(cust.isPresent()==true)
			{
			customer c=cust.get();
			int bal=c.getLoan_Amt();
			int oldbal=c.getBalance();
			int new_bal=oldbal+Loanamt;
			c.setLoan_Amt(bal+Loanamt);
			c.setBalance(new_bal);
			
			
			obj.insertdata(c);
			model.addAttribute("records",c);
			return "main";
		
				
		    }
			else
			{
				return "notfound";
			}
		
		}
		
		
		@GetMapping("/repayloan")
		public String repayloan()
		{
			return "repayloan";
		}
		@PostMapping("/repayloanamt")
	    public String repayloan(@RequestParam int gBank_ID,@RequestParam int Repayloanamt,Model model)
		{
			//System.out.println("hi");
			Optional<customer> cust=obj.search(gBank_ID);
			if(cust.isPresent()==true)
			{
			customer c=cust.get();
			int bal=c.getLoan_Amt();
			int new_bal=bal-Repayloanamt;
			c.setLoan_Amt(new_bal);
		
			
			
			obj.insertdata(c);
			model.addAttribute("records",c);
			return "main";
		
				
		    }
			else
			{
				return "notfound";
			}
		
		}
		
		
		
		
}


