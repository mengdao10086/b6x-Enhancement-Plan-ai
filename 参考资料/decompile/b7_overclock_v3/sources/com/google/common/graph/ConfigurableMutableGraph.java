package com.google.common.graph;

import com.google.common.graph.GraphConstants;

/* JADX INFO: loaded from: classes7.dex */
final class ConfigurableMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {
    private final MutableValueGraph<N, GraphConstants.Presence> backingValueGraph;

    public ConfigurableMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.backingValueGraph = new ConfigurableMutableValueGraph(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n10) {
        return this.backingValueGraph.addNode(n10);
    }

    @Override // com.google.common.graph.ForwardingGraph
    public BaseGraph<N> delegate() {
        return this.backingValueGraph;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n10, N n11) {
        return this.backingValueGraph.putEdgeValue(n10, n11, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n10, N n11) {
        return this.backingValueGraph.removeEdge(n10, n11) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n10) {
        return this.backingValueGraph.removeNode(n10);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        validateEndpoints(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
