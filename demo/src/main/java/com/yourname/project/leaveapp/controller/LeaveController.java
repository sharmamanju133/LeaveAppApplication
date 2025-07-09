package com.yourname.project.leaveapp.controller;

import com.yourname.project.leaveapp.model.Leave;
import com.yourname.project.leaveapp.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@CrossOrigin(origins = "*")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping
    public List<Leave> getAllLeaves() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/{id}")
    public Leave getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    @PostMapping
    public Leave createLeave(@RequestBody Leave leave) {
        return leaveService.createLeave(leave);
    }

    @PutMapping("/{id}")
    public Leave updateLeave(@PathVariable Long id, @RequestBody Leave leave) {
        return leaveService.updateLeave(id, leave);
    }

    @DeleteMapping("/{id}")
    public void deleteLeave(@PathVariable Long id) {
        leaveService.deleteLeave(id);
    }

    // NEW: PATCH for Approve/Reject
    @PatchMapping("/{id}/status")
    public Leave updateLeaveStatus(@PathVariable Long id, @RequestParam String status) {
        Leave leave = leaveService.getLeaveById(id);
        if (leave != null) {
            leave.setStatus(status);
            return leaveService.createLeave(leave);
        }
        return null;
    }
}
