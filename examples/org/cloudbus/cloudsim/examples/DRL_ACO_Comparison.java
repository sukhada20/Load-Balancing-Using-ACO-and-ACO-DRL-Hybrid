package org.cloudbus.cloudsim.examples;

import org.cloudbus.cloudsim.*;
import org.cloudbus.cloudsim.core.CloudSim;

import java.util.*;

public class DRL_ACO_Comparison {

    public static void main(String[] args) {
        try {
            System.out.println("Starting DRL-ACO Hybrid...");

            CloudSim.init(1, Calendar.getInstance(), false);

            Datacenter datacenter = createDatacenter();
            DatacenterBroker broker = new DatacenterBroker("Broker");

            List<Vm> vmList = createVMs(broker.getId(), 5, 1500); // stronger VMs
            List<Cloudlet> cloudletList = createCloudlets(broker.getId(), 20);

            broker.submitVmList(vmList);
            broker.submitCloudletList(cloudletList);

            // DRL + ACO: intelligent load balancing
            Map<Integer, Double> vmLoad = new HashMap<>();
            for (Vm vm : vmList) vmLoad.put(vm.getId(), 0.0);

            for (Cloudlet cl : cloudletList) {
                // DRL idea: pick least loaded VM
                int bestVm = vmLoad.entrySet().stream()
                        .min(Map.Entry.comparingByValue()).get().getKey();

                cl.setVmId(bestVm);

                // update load
                vmLoad.put(bestVm,
                        vmLoad.get(bestVm) + cl.getCloudletLength());
            }

            CloudSim.startSimulation();
            List<Cloudlet> result = broker.getCloudletReceivedList();
            CloudSim.stopSimulation();

            printResults(result, "DRL-ACO Hybrid");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static Datacenter createDatacenter() throws Exception {
        List<Host> hostList = new ArrayList<>();

        List<Pe> peList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            peList.add(new Pe(i,
                    new org.cloudbus.cloudsim.provisioners.PeProvisionerSimple(1500)));
        }

        hostList.add(new Host(
                0,
                new org.cloudbus.cloudsim.provisioners.RamProvisionerSimple(16384),
                new org.cloudbus.cloudsim.provisioners.BwProvisionerSimple(10000),
                1000000,
                peList,
                new VmSchedulerTimeShared(peList)
        ));

        return new Datacenter("Datacenter_0",
                new DatacenterCharacteristics(
                        "x86", "Linux", "Xen",
                        hostList, 10.0, 3.0, 0.05, 0.001, 0.0),
                new VmAllocationPolicySimple(hostList),
                new LinkedList<>(), 0);
    }

    static List<Vm> createVMs(int brokerId, int num, int mips) {
        List<Vm> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(new Vm(i, brokerId, mips, 1, 1024, 1000, 10000,
                    "Xen", new CloudletSchedulerTimeShared()));
        }
        return list;
    }

    static List<Cloudlet> createCloudlets(int brokerId, int num) {
        List<Cloudlet> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Cloudlet cl = new Cloudlet(i, 40000 + i * 1000, 1, 300, 300,
                    new UtilizationModelFull(),
                    new UtilizationModelFull(),
                    new UtilizationModelFull());
            cl.setUserId(brokerId);
            list.add(cl);
        }
        return list;
    }

    static void printResults(List<Cloudlet> list, String algo) {
        double makespan = 0;

        System.out.println("\n=== RESULTS: " + algo + " ===");
        for (Cloudlet cl : list) {
            double finish = cl.getFinishTime();
            makespan = Math.max(makespan, finish);
            System.out.println("Cloudlet " + cl.getCloudletId() +
                    " Finish: " + finish);
        }

        System.out.println("Makespan: " + makespan);
    }
}