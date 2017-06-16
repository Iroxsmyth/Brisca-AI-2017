package aima.core.agent;

import java.util.List;

/**
 * An abstract description of possible discrete Environments in which Agent(s)
 * can perceive and act.
 * 
 * @author Ravi Mohan
 * @author Ciaran O'Reilly
 * @author Mike Stampone
 */
public interface Environment {
	/**
	 * Returns the Agents belonging to this Board.
	 * 
	 * @return The Agents belonging to this Board.
	 */
	List<Agent> getAgents();

	/**
	 * Add an agent to the Board.
	 * 
	 * @param agent
	 *            the agent to be added.
	 */
	void addAgent(Agent agent);

	/**
	 * Remove an agent from the environment.
	 * 
	 * @param agent
	 *            the agent to be removed.
	 */
	void removeAgent(Agent agent);

	/**
	 * Returns the EnvironmentObjects that exist in this Board.
	 * 
	 * @return the EnvironmentObjects that exist in this Board.
	 */
	List<EnvironmentObject> getEnvironmentObjects();

	/**
	 * Add an EnvironmentObject to the Board.
	 * 
	 * @param eo
	 *            the EnvironmentObject to be added.
	 */
	void addEnvironmentObject(EnvironmentObject eo);

	/**
	 * Remove an EnvironmentObject from the Board.
	 * 
	 * @param eo
	 *            the EnvironmentObject to be removed.
	 */
	void removeEnvironmentObject(EnvironmentObject eo);

	/**
	 * Move the Board one time step forward.
	 */
	void step();

	/**
	 * Move the Board n time steps forward.
	 * 
	 * @param n
	 *            the number of time steps to move the Board forward.
	 */
	void step(int n);

	/**
	 * Step through time steps until the Board has no more tasks.
	 */
	void stepUntilDone();

	/**
	 * Returns <code>true</code> if the Board is finished with its current
	 * task(s).
	 * 
	 * @return <code>true</code> if the Board is finished with its current
	 *         task(s).
	 */
	boolean isDone();

	/**
	 * Retrieve the performance measure associated with an Agent.
	 * 
	 * @param forAgent
	 *            the Agent for which a performance measure is to be retrieved.
	 * @return the performance measure associated with the Agent.
	 */
	double getPerformanceMeasure(Agent forAgent);

	/**
	 * Add a view on the Board.
	 * 
	 * @param ev
	 *            the EnvironmentView to be added.
	 */
	void addEnvironmentView(EnvironmentView ev);

	/**
	 * Remove a view on the Board.
	 * 
	 * @param ev
	 *            the EnvironmentView to be removed.
	 */
	void removeEnvironmentView(EnvironmentView ev);

	/**
	 * Notify all registered EnvironmentViews of a message.
	 * 
	 * @param msg
	 *            the message to notify the registered EnvironmentViews with.
	 */
	void notifyViews(String msg);
}
