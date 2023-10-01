package Agent_AB;

import Agent_AB.Environment.LocationState;

public class AgentProgram {

	public Action execute(Percept p) {// location, status
		//TODO
		LocationState state = p.getLocationState();
		String location = p.getAgentLocation();
		if(state == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		}
		else if(location.equals(Environment.LOCATION_A)) {
			return Environment.MOVE_RIGHT;
		}
		else if(location.equals(Environment.LOCATION_B)) {
			return Environment.MOVE_LEFT;
		}
		else {
			return null;
		}
	}
}