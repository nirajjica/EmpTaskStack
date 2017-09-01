package com.eschool.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.eschool.domain.Employee;
import com.eschool.repository.AccountDataRepository;
import com.eschool.service.JobScheduleService;

/**
 * @Author Niraj Kumar
 * @createdOn 31-Aug-2017
 */


@Service
public class JobScheduleServiceImpl implements JobScheduleService{

	@Value("${csv.file.path}")
	private String dirPath;
	
	@Value("${archive.csv.file.path}")
	private String archiveDirPath;
	
	@Autowired
    private AccountDataRepository repository;
	
	
	@Scheduled(fixedDelay=300000)
	//300000 = 5 min
	@Override
	public void jobScheduleforCSV() {
		File csvFile = new File(dirPath+File.separator+"employee.csv");
		if(csvFile.isFile()){
			BufferedReader br = null;
	        String line = null;
	        String cvsSplitBy = ",";
			try {
				
	            br = new BufferedReader(new FileReader(csvFile));
	            br.readLine(); // this will read the first line
	            while ((line = br.readLine()) != null) {//loop will run from 2nd line
	            	//Employees will have attributes like code, firstname, lastname, email, address, phone, salary, manager.
	            	
	            		 // use comma as separator
		                String[] emp = line.split(cvsSplitBy);
		                
		                Employee employee = new Employee();
		                employee.setCode(emp[0]);
		                employee.setFname(emp[1]);
		                employee.setLname(emp[2]);
		                employee.setEmail(emp[3]);
		                employee.setAddress(emp[4]);
		                employee.setPhone(emp[5]);
		                employee.setSalary(Double.parseDouble(emp[6]));
		                //password
		                //userName
		                employee.setAccounttype(emp[1]);
		                employee.setCreatedate(new java.util.Date());
		                employee.setAccountstatus("ACTIVE");
		                //employee.setDepartment(null);
		                //employee.setRole(role);
		                employee.setVisible('Y');
		                //employee.setEmployee(employee);
		                
		                
		                
		                //repository.save(employee);

		                System.out.println("Employee [code= " + emp[0] + " , firstname=" + emp[1] + "]");
	            }
	            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyy_hh_mm");
	            
	            String date = simpleDateFormat.format(new java.util.Date());
	            
	            csvFile.renameTo(new File(archiveDirPath+File.separator+"employee_"+date+".csv"));

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		}else{
			System.out.println("file not found");
		}
		
		
	}

}
