# ☁️ Intelligent Load Balancing in Cloud Computing using DRL-ACO Hybrid Scheduling

## 📖 Overview
This project presents a comparative analysis of load balancing strategies in cloud computing using the CloudSim simulation framework. The objective is to optimize resource utilization, improve task scheduling, and reduce overall execution time (Makespan) by implementing an intelligent DRL-ACO Hybrid scheduling algorithm.
Two approaches are evaluated:
* **ACO Only (Ant Colony Optimization Inspired Scheduling)**
* **DRL-ACO Hybrid Scheduling**
The results demonstrate that the proposed DRL-ACO Hybrid algorithm significantly outperforms traditional ACO-based scheduling by intelligently distributing workloads across virtual machines.

---

## 🎯 Objectives
* Simulate cloud resource allocation using CloudSim.
* Implement an ACO-inspired task scheduling algorithm.
* Develop a DRL-ACO Hybrid load balancing approach.
* Compare performance using Makespan.
* Analyze workload distribution and resource utilization.

---

## 🏗️ System Architecture
```text
            Cloud Users
                 │
                 ▼
         Datacenter Broker
                 │
                 ▼
         Scheduling Module
 ┌───────────────┬───────────────┐
 ▼                               ▼
ACO Only                  DRL-ACO Hybrid
 │                               │
 └───────────────┬───────────────┘
                 ▼
         Virtual Machines
                 ▼
              Hosts
                 ▼
            Datacenter
```

---

## 🔬 Algorithms Implemented
### 1️⃣ ACO Only Scheduling
The ACO-inspired scheduler assigns cloudlets to VMs using randomized VM selection.
#### Workflow
1. Create Datacenter and VMs.
2. Generate Cloudlets.
3. Randomly assign tasks to VMs.
4. Execute simulation.
5. Measure Makespan.
#### Limitations
* Uneven workload distribution
* VM overload situations
* Higher task completion time
* Lower resource utilization
  
---

### 2️⃣ DRL-ACO Hybrid Scheduling
The hybrid scheduler combines ideas from:
* Deep Reinforcement Learning (DRL)
* Ant Colony Optimization (ACO)
Instead of random allocation, cloudlets are assigned to the least-loaded VM, ensuring balanced resource utilization.
#### Workflow
1. Initialize VM load table.
2. Select least-loaded VM.
3. Assign cloudlet.
4. Update VM load.
5. Execute simulation.
6. Calculate Makespan.
#### Advantages
* Better load balancing
* Improved resource utilization
* Reduced execution time
* Lower Makespan
* Balanced workload distribution

---

## 🛠️ Technologies Used
| Technology         | Purpose                    |
| ------------------ | -------------------------- |
| Java               | Programming Language       |
| CloudSim           | Cloud Computing Simulation |
| DRL Concepts       | Intelligent Scheduling     |
| ACO Concepts       | Optimization Strategy      |
| Eclipse / IntelliJ | Development Environment    |

---

# 🏆 Experimental Results
## Results Summary
| Algorithm      | Makespan         |
| -------------- | ---------------- |
| ACO Only       | 302.096          |
| DRL-ACO Hybrid | 137.432          |
| Improvement    | 54.51% Reduction |

### Improvement Calculation
```text
Improvement (%) =
((302.096 - 137.432) / 302.096) × 100
= 54.51%
```

---

## 📈 ACO Only Results
<img width="466" height="580" alt="Screenshot 2026-04-23 125305" src="https://github.com/user-attachments/assets/d7080044-14c1-4435-91fc-dc9e442ca6ec" />

---

## 📈 DRL-ACO Hybrid Results
<img width="461" height="583" alt="Screenshot 2026-04-23 125251" src="https://github.com/user-attachments/assets/2efc09b2-532a-4d91-b2fa-4355ffca432d" />

---

## 📉 Performance Analysis
### Comparison
| Metric               | ACO Only   | DRL-ACO Hybrid |
| -------------------- | ---------- | -------------- |
| Cloudlets            | 20         | 20             |
| VMs                  | 5          | 5              |
| Scheduling Strategy  | Randomized | Load-Aware     |
| Makespan             | 302.096    | 137.432        |
| Resource Utilization | Moderate   | High           |
| Load Distribution    | Uneven     | Balanced       |
| Performance          | Baseline   | Superior       |

### Key Observations
- DRL-ACO distributes tasks more evenly across VMs.
- VM overload situations are minimized.
- Resource utilization is significantly improved.
- Cloudlet completion times become more uniform.
- Makespan is reduced by **54.51%**.

---

## 📌 Conclusion
The proposed **DRL-ACO Hybrid Load Balancing Algorithm** demonstrates significantly better performance than the traditional ACO-only scheduler.
### Key Achievement
```text
ACO Makespan      : 302.096
DRL-ACO Makespan  : 137.432
Improvement       : 54.51%
```
The intelligent load-aware scheduling strategy successfully improves workload distribution, reduces execution time, and enhances overall cloud system efficiency.

---

## 🚀 How to Run
### Prerequisites
* Java JDK 8+
* CloudSim Library
* Eclipse / IntelliJ IDEA
### Clone Repository
```bash
git clone https://github.com/yourusername/cloud-load-balancing-drl-aco.git
```
### Run ACO Scheduler
```bash
Run ACOOnlyComparison.java
```
### Run DRL-ACO Scheduler
```bash
Run DRL_ACO_Comparison.java
```
### Compare Makespan Values
Observe the Makespan values in the console output to compare scheduling performance.

---

## 🔮 Future Scope
* Full Deep Q-Network (DQN) implementation
* Dynamic VM scaling
* Energy-aware scheduling
* SLA-aware resource allocation
* Multi-datacenter simulation
* Kubernetes integration
* Real-time workload prediction

---

## 📄 License
This project is intended for educational, academic, and research purposes.

---

~ sukhada20
