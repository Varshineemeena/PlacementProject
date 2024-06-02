package com.opm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.opm.dao.JobDAOImpl;
import com.opm.entity.Applications;
import com.opm.entity.Company;
import com.opm.entity.Job;
import com.opm.entity.Student;
import com.opm.service.JobServiceImpl;

@RestController
@CrossOrigin("http://localhost:3000/")
public class JobController {
//	@Autowired
//	JobDAOImpl dao;
	
	@Autowired
	JobServiceImpl dao;
	
	@PostMapping("/CreateJob")
    public String addJob(@RequestBody Job job) {
        String msg="";
        try {
            dao.addJob(job);
            msg="Job Details Saved";
        }catch(Exception e) {
            msg="Job Details not saved";
        }
        return msg;
    }
	
	@GetMapping("/getAllJob")
    public List<Job> getAllJob() {
        try {
            return dao.getallJobs();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
	
//	@PutMapping("/UpdateJob")
//    public String updateJobInfo(@RequestBody Job job) {
//        String msg = "";
//        try {
//            dao.updateJobInfo(job);
//            msg = "Job Details Updated";
//        } catch (Exception e) {
//            msg = "Job Details not Updated";
//        }
//        return msg;
//    }
// 
// @GetMapping("/getJobById/{id}")
//    public List<Job> getJob(@PathVariable Long id) {
//        try {
//            return dao.getJobById(id);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return null;
//    }

// @DeleteMapping("/DeleteJob/{id}")
//    public String deleteJobInfo(@PathVariable int id) {
//        String msg = "";
//        try {
//            dao.deleteJob(id);
//            msg = "Job Details Deleted";
//        } catch (Exception e) {
//            msg = "Job Details not Deleted";
//        }
//        return msg;
//    }
 @GetMapping("/GetJobIds")
 public List<Long> getJobIdlists() {
     try {
         return dao.getJobIdlist();
     } catch (Exception e) {
         e.printStackTrace();
     }
     return null;
 }
 
 @GetMapping("/getJobByCid/{id}")
 public List<Job> getByJobId(@PathVariable long id){
	 try {
		return dao.getByCompanyIdss(id);
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
 }
 
// @GetMapping("/getJobBySid/{id}")
// public List<Job> getByCompanyId(@PathVariable long id){
//	 try {
//		return dao.getByStudentIdss(id);
//	} catch (Exception e) {
//		e.printStackTrace();
//		return null;
//	}
// }
 
// @DeleteMapping("/DeleteJob/{id}")
// public String deleteJobInfo(@PathVariable Long id) {
//     String msg = "";
//     try {
//         dao.deleteJob(id);
//         msg = "Applications Details Deleted";
//     } catch (Exception e) {
//         msg = "Applications Details not Deleted";
//     }
//     return msg;
// }
 
 
//Approve
 
@PutMapping("/updatejob/{id}")
public ResponseEntity<?> updateJob(@PathVariable("id") Long id,
                                      @RequestBody Job updatedBill) {
    return dao.updateBill(id, updatedBill);
}

//@DeleteMapping("/DeleteJob/{id}")
//public String deleteJobInfo(@PathVariable Long id) {
//    String msg = "";
//    try {
//        dao.deleteJob(id);
//        msg = "Job Details Deleted";
//    } catch (Exception e) {
//        msg = "Job Details not Deleted";
//    }
//    return msg;
//}

@GetMapping("/getJobById/{id}")
public Job getJob(@PathVariable Long id) {
    try {
        return dao.getJobId(id);
    } catch (Exception e) {
        e.printStackTrace();
    }

    return null;
}

@DeleteMapping("/deletejob/{id}")
public ResponseEntity<?> deleteJob(@PathVariable Long id) {
    try {
        dao.deleteJob(id);
        return ResponseEntity.ok().build();
    } catch (Exception e) {
        // Handle the exception appropriately
        return ResponseEntity.badRequest().body("Error deleting application: " + e.getMessage());
    }
}






}
