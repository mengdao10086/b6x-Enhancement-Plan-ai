package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;

/* JADX INFO: loaded from: classes7.dex */
final class ConfigurableMutableNetwork<N, E> extends ConfigurableNetwork<N, E> implements MutableNetwork<N, E> {
    public ConfigurableMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> addNodeInternal(N n10) {
        NetworkConnections<N, E> networkConnectionsNewConnections = newConnections();
        Preconditions.checkState(this.nodeConnections.put(n10, networkConnectionsNewConnections) == null);
        return networkConnectionsNewConnections;
    }

    private NetworkConnections<N, E> newConnections() {
        return isDirected() ? allowsParallelEdges() ? DirectedMultiNetworkConnections.of() : DirectedNetworkConnections.of() : allowsParallelEdges() ? UndirectedMultiNetworkConnections.of() : UndirectedNetworkConnections.of();
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(N n10, N n11, E e10) {
        Preconditions.checkNotNull(n10, "nodeU");
        Preconditions.checkNotNull(n11, "nodeV");
        Preconditions.checkNotNull(e10, "edge");
        if (containsEdge(e10)) {
            EndpointPair<N> endpointPairIncidentNodes = incidentNodes(e10);
            EndpointPair endpointPairOf = EndpointPair.of(this, n10, n11);
            Preconditions.checkArgument(endpointPairIncidentNodes.equals(endpointPairOf), GraphConstants.REUSING_EDGE, e10, endpointPairIncidentNodes, endpointPairOf);
            return false;
        }
        NetworkConnections<N, E> networkConnectionsAddNodeInternal = this.nodeConnections.get(n10);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument(networkConnectionsAddNodeInternal == null || !networkConnectionsAddNodeInternal.successors().contains(n11), GraphConstants.PARALLEL_EDGES_NOT_ALLOWED, n10, n11);
        }
        boolean zEquals = n10.equals(n11);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!zEquals, GraphConstants.SELF_LOOPS_NOT_ALLOWED, n10);
        }
        if (networkConnectionsAddNodeInternal == null) {
            networkConnectionsAddNodeInternal = addNodeInternal(n10);
        }
        networkConnectionsAddNodeInternal.addOutEdge(e10, n11);
        NetworkConnections<N, E> networkConnectionsAddNodeInternal2 = this.nodeConnections.get(n11);
        if (networkConnectionsAddNodeInternal2 == null) {
            networkConnectionsAddNodeInternal2 = addNodeInternal(n11);
        }
        networkConnectionsAddNodeInternal2.addInEdge(e10, n10, zEquals);
        this.edgeToReferenceNode.put(e10, n10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        if (containsNode(n10)) {
            return false;
        }
        addNodeInternal(n10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeEdge(E e10) {
        Preconditions.checkNotNull(e10, "edge");
        N n10 = this.edgeToReferenceNode.get(e10);
        boolean z10 = false;
        if (n10 == null) {
            return false;
        }
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n10);
        N nAdjacentNode = networkConnections.adjacentNode(e10);
        NetworkConnections<N, E> networkConnections2 = this.nodeConnections.get(nAdjacentNode);
        networkConnections.removeOutEdge(e10);
        if (allowsSelfLoops() && n10.equals(nAdjacentNode)) {
            z10 = true;
        }
        networkConnections2.removeInEdge(e10, z10);
        this.edgeToReferenceNode.remove(e10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeNode(N n10) {
        Preconditions.checkNotNull(n10, "node");
        NetworkConnections<N, E> networkConnections = this.nodeConnections.get(n10);
        if (networkConnections == null) {
            return false;
        }
        UnmodifiableIterator<E> it2 = ImmutableList.copyOf((Collection) networkConnections.incidentEdges()).iterator();
        while (it2.hasNext()) {
            removeEdge(it2.next());
        }
        this.nodeConnections.remove(n10);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e10) {
        validateEndpoints(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e10);
    }
}
