package Task2;

import Task2.Environment.LocationState;

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
			return Environment.MOVE_DOWN;
		}
		else if(location.equals(Environment.LOCATION_C)) {
			return Environment.MOVE_LEFT;
		}
		else if(location.equals(Environment.LOCATION_D)) {
			return Environment.MOVE_UP;
		}
		else return null;
	}
}