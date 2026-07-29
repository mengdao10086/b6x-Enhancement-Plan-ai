package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
class ConfigurableNetwork<N, E> extends AbstractNetwork<N, E> {
    private final boolean allowsParallelEdges;
    private final boolean allowsSelfLoops;
    private final ElementOrder<E> edgeOrder;
    public final MapIteratorCache<E, N> edgeToReferenceNode;
    private final boolean isDirected;
    public final MapIteratorCache<N, NetworkConnections<N, E>> nodeConnections;
    private final ElementOrder<N> nodeOrder;

    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.nodeOrder.createMap(networkBuilder.expectedNodeCount.or(10).intValue()), networkBuilder.edgeOrder.createMap(networkBuilder.expectedEdgeCount.or(20).intValue()));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n10) {
        return checkedConnections(n10).adjacentNodes();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.allowsParallelEdges;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.allowsSelfLoops;
    }

    public final NetworkConnections<N, E> checkedConnections(N n10) {
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n10);
        if (networkConnections != null) {
            return networkConnections;
        }
        Preconditions.checkNotNull(n10);
        throw new IllegalArgumentException(String.format(GraphConstants.NODE_NOT_IN_GRAPH, n10));
    }

    public final N checkedReferenceNode(E e10) {
        N n10 = this.edgeToReferenceNode.get(e10);
        if (n10 != null) {
            return n10;
        }
        Preconditions.checkNotNull(e10);
        throw new IllegalArgumentException(String.format(GraphConstants.EDGE_NOT_IN_GRAPH, e10));
    }

    public final boolean containsEdge(@NullableDecl E e10) {
        return this.edgeToReferenceNode.containsKey(e10);
    }

    public final boolean containsNode(@NullableDecl N n10) {
        return this.nodeConnections.containsKey(n10);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.edgeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.edgeToReferenceNode.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n10, N n11) {
        NetworkConnections<N, E> networkConnectionsCheckedConnections = checkedConnections(n10);
        if (!this.allowsSelfLoops && n10 == n11) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(containsNode(n11), GraphConstants.NODE_NOT_IN_GRAPH, n11);
        return networkConnectionsCheckedConnections.edgesConnecting(n11);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n10) {
        return checkedConnections(n10).inEdges();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n10) {
        return checkedConnections(n10).incidentEdges();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e10) {
        N nCheckedReferenceNode = checkedReferenceNode(e10);
        return EndpointPair.of(this, nCheckedReferenceNode, this.nodeConnections.get(nCheckedReferenceNode).adjacentNode(e10));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.isDirected;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.nodeOrder;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.nodeConnections.unmodifiableKeySet();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n10) {
        return checkedConnections(n10).outEdges();
    }

    @Override // com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n10) {
        return checkedConnections(n10).predecessors();
    }

    @Override // com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n10) {
        return checkedConnections(n10).successors();
    }

    public ConfigurableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        this.isDirected = networkBuilder.directed;
        this.allowsParallelEdges = networkBuilder.allowsParallelEdges;
        this.allowsSelfLoops = networkBuilder.allowsSelfLoops;
        this.nodeOrder = (ElementOrder<N>) networkBuilder.nodeOrder.cast();
        this.edgeOrder = (ElementOrder<E>) networkBuilder.edgeOrder.cast();
        this.nodeConnections = map instanceof TreeMap ? new MapRetrievalCache<>(map) : new MapIteratorCache<>(map);
        this.edgeToReferenceNode = new MapIteratorCache<>(map2);
    }
}
