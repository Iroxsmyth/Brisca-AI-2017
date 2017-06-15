package BriscaAI2017;

/**
 * Created by vikta on 6/7/2017.
 */

import aima.core.agent.Action;
import aima.core.search.framework.*;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.QueueSearch;
import java.util.List;
import aima.core.search.framework.Metrics;
import aima.core.search.framework.Node;
import aima.core.search.framework.NodeExpander;
import aima.core.search.framework.QueueFactory;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.SearchForStates;
import aima.core.search.framework.SearchUtils;



public class DepthFirstSearch implements SearchForActions, SearchForStates {
    QueueSearch implementation;

    public DepthFirstSearch(QueueSearch impl) {
        this.implementation = impl;
    }

    public List<Action> findActions(Problem p) {
        this.implementation.getNodeExpander().useParentLinks(true);
        Node node = this.implementation.findNode(p, QueueFactory.createLifoQueue());
        return node == null? SearchUtils.failure():SearchUtils.getSequenceOfActions(node);
    }

    public Object findState(Problem p) {
        this.implementation.getNodeExpander().useParentLinks(false);
        Node node = this.implementation.findNode(p, QueueFactory.createLifoQueue());
        return node == null?null:node.getState();
    }

    public NodeExpander getNodeExpander() {
        return this.implementation.getNodeExpander();
    }

    public Metrics getMetrics() {
        return this.implementation.getMetrics();
    }
}

