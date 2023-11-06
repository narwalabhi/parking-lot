package repo;

import models.Gate;

import java.util.HashMap;

public class GateRepo {

    private static  final HashMap<Integer, Gate> gates = new HashMap<>();

    public void addGate(Gate gate) {
        gates.put(gate.getId(), gate);
    }

    public Gate getGate(int gateId) {
        return gates.get(gateId);
    }

    public void updateGate(Gate gate) {
        gates.put(gate.getId(), gate);
    }

    public void deleteGate(int gateId) {
        gates.remove(gateId);
    }

}
