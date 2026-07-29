package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
class ConfigurableValueGraph<N, V> extends AbstractValueGraph<N, V> {
    private final boolean allowsSelfLoops;
    public long edgeCount;
    private final boolean isDirected;
    public final MapIteratorCache<N, GraphConnections<N, V>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.nodeOrder.createMap(abstractGraphBuilder.expectedNodeCount.or(10).intValue()), 0L);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n10) {
        return checkedConnections(n10).adjacentNodes();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final GraphConnections<N, V> checkedConnections(N n10) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        if (graphConnections != null) {
            return graphConnections;
        }
        Preconditions.checkNotNull(n10);
        throw new IllegalArgumentException("Node " + n10 + " is not an element of this graph.");
    }

    public final boolean containsNode(@NullableDecl N n10) {
        return this.nodeConnections.containsKey(n10);
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return this.edgeCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n10, N n11, @NullableDecl V v10) {
        return (V) edgeValueOrDefault_internal(Preconditions.checkNotNull(n10), Preconditions.checkNotNull(n11), v10);
    }

    public final V edgeValueOrDefault_internal(N n10, N n11, V v10) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        V vValue = graphConnections == null ? null : graphConnections.value(n11);
        return vValue == null ? v10 : vValue;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n10, N n11) {
        return hasEdgeConnecting_internal(Preconditions.checkNotNull(n10), Preconditions.checkNotNull(n11));
    }

    public final boolean hasEdgeConnecting_internal(N n10, N n11) {
        GraphConnections<N, V> graphConnections = this.nodeConnections.get(n10);
        return graphConnections != null && graphConnections.successors().contains(n11);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v10) {
        validateEndpoints(endpointPair);
        return edgeValueOrDefault_internal(endpointPair.nodeU(), endpointPair.nodeV(), v10);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return isOrderingCompatible(endpointPair) && hasEdgeConnecting_internal(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n10) {
        return checkedConnections(n10).predecessors();
    }

    @Override // com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n10) {
        return checkedConnections(n10).successors();
    }

    public ConfigurableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j10) {
        this.isDirected = abstractGraphBuilder.directed;
        this.allowsSelfLoops = abstractGraphBuilder.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) abstractGraphBuilder.nodeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeCount = Graphs.checkNonNegative(j10);
    }
}
