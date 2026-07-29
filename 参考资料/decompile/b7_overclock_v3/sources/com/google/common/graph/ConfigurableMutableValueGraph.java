package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* JADX INFO: loaded from: classes7.dex */
final class ConfigurableMutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> implements MutableValueGraph<N, V> {
    public ConfigurableMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> addNodeInternal(N n10) {
        GraphConnections<N, V> graphConnectionsNewConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n10, graphConnectionsNewConnections) == null);
        return graphConnectionsNewConnections;
    }

    private GraphConnections<N, V> newConnections() {
        return isDirected() ? DirectedGraphConnections.of() : UndirectedGraphConnections.of();
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean addNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        if (containsNode(n10)) {
            return false;
        }
        addNodeInternal(n10);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(N n10, N n11, V v10) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        Preconditions.checkNotNull(v10, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n10.equals(n11), GraphConstants.SELF_LOOPS_NOT_ALLOWED, n10);
        }
        GraphConnections<N, V> graphConnectionsAddNodeInternal = this.nodeConnections.get(n10);
        if (graphConnectionsAddNodeInternal == null) {
            graphConnectionsAddNodeInternal = addNodeInternal(n10);
        }
        V vAddSuccessor = graphConnectionsAddNodeInternal.addSuccessor(n11, v10);
        GraphConnections<N, V> graphConnectionsAddNodeInternal2 = this.nodeConnections.get(n11);
        if (graphConnectionsAddNodeInternal2 == null) {
            graphConnectionsAddNodeInternal2 = addNodeInternal(n11);
        }
        graphConnectionsAddNodeInternal2.addPredecessor(n10, v10);
        if (vAddSuccessor == null) {
            long j10 = this.edgeCount + 1;
            this.edgeCount = j10;
            Graphs.checkPositive(j10);
        }
        return vAddSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(N n10, N n11) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        GraphConnections<N, V> graphConnections2 = this.nodeConnections.get(n11);
        if (graphConnections == null || graphConnections2 == null) {
            return null;
        }
        V vRemoveSuccessor = graphConnections.removeSuccessor(n11);
        if (vRemoveSuccessor != null) {
            graphConnections2.removePredecessor(n10);
            long j10 = this.edgeCount - 1;
            this.edgeCount = j10;
            Graphs.checkNonNegative(j10);
        }
        return vRemoveSuccessor;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean removeNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        if (graphConnections == null) {
            return false;
        }
        if (allowsSelfLoops() && graphConnections.removeSuccessor(n10) != null) {
            graphConnections.removePredecessor(n10);
            this.edgeCount--;
        }
        Iterator<N> it2 = graphConnections.successors().iterator();
        while (it2.hasNext()) {
            this.nodeConnections.getWithoutCaching(it2.next()).removePredecessor(n10);
            this.edgeCount--;
        }
        if (isDirected()) {
            Iterator<N> it3 = graphConnections.predecessors().iterator();
            while (it3.hasNext()) {
                Preconditions.checkState(this.nodeConnections.getWithoutCaching(it3.next()).removeSuccessor(n10) != null);
                this.edgeCount--;
            }
        }
        this.nodeConnections.remove(n10);
        Graphs.checkNonNegative(this.edgeCount);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public V putEdgeValue(EndpointPair<N> endpointPair, V v10) {
        validateEndpoints(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v10);
    }
}
