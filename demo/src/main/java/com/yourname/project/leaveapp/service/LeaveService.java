package com.yourname.project.leaveapp.service;

import com.yourname.project.leaveapp.model.Leave;
import com.yourname.project.leaveapp.repository.LeaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveService {

    @Autowired
    private LeaveRepository leaveRepository;

    public List<Leave> getAllLeaves() {
        return leaveRepository.findAll();
    }

    public Leave getLeaveById(Long id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public Leave createLeave(Leave leave) {
        return leaveRepository.save(leave);
    }

    public Leave updateLeave(Long id, Leave updatedLeave) {
        Optional<Leave> optionalLeave = leaveRepository.findById(id);
        if (optionalLeave.isPresent()) {
            Leave leave = optionalLeave.get();
            leave.setEmployeeName(updatedLeave.getEmployeeName());
            leave.setLeaveType(updatedLeave.getLeaveType());
            leave.setStartDate(updatedLeave.getStartDate());
            leave.setEndDate(updatedLeave.getEndDate());
            leave.setStatus(updatedLeave.getStatus());
            return leaveRepository.save(leave);
        }
        return null;
    }

    public void deleteLeave(Long id) {
        leaveRepository.deleteById(id);
    }
}
