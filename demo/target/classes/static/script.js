const API_BASE = "/api/leaves";
const form = document.getElementById("leaveForm");
const tableBody = document.getElementById("leaveTableBody");

// Fetch and display all leaves
function loadLeaves() {
    fetch(API_BASE)
        .then(res => res.json())
        .then(data => {
            tableBody.innerHTML = "";
            data.forEach(leave => {
                const row = document.createElement("tr");
                row.innerHTML = `
                    <td>${leave.id}</td>
                    <td>${leave.employeeName}</td>
                    <td>${leave.leaveType}</td>
                    <td>${leave.startDate}</td>
                    <td>${leave.endDate}</td>
                    <td>${leave.status}</td>
                    <td>
                        <button class="action-btn approve" onclick="updateStatus(${leave.id}, 'Approved')">Approve</button>
                        <button class="action-btn reject" onclick="updateStatus(${leave.id}, 'Rejected')">Reject</button>
                        <button class="action-btn delete" onclick="deleteLeave(${leave.id})">Delete</button>
                    </td>
                `;
                tableBody.appendChild(row);
            });
        });
}

// Submit new leave
form.addEventListener("submit", function (e) {
    e.preventDefault();
    const newLeave = {
        employeeName: document.getElementById("employeeName").value,
        leaveType: document.getElementById("leaveType").value,
        startDate: document.getElementById("startDate").value,
        endDate: document.getElementById("endDate").value
    };

    fetch(API_BASE, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(newLeave)
    }).then(() => {
        form.reset();
        loadLeaves();
    });
});

// Update leave status
function updateStatus(id, status) {
    fetch(`${API_BASE}/${id}/status?status=${status}`, {
        method: "PATCH"
    }).then(() => loadLeaves());
}

// Delete a leave entry
function deleteLeave(id) {
    fetch(`${API_BASE}/${id}`, {
        method: "DELETE"
    }).then(() => loadLeaves());
}

// Initial load
loadLeaves();
