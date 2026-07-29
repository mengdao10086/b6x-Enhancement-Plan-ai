package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {
    public final Map<E, N> incidentEdgeMap;

    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.incidentEdgeMap = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addInEdge(E e10, N n10, boolean z10) {
        if (z10) {
            return;
        }
        addOutEdge(e10, n10);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void addOutEdge(E e10, N n10) {
        Preconditions.checkState(this.incidentEdgeMap.put(e10, n10) == null);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N adjacentNode(E e10) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.get(e10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> inEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> incidentEdges() {
        return Collections.unmodifiableSet(this.incidentEdgeMap.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> outEdges() {
        return incidentEdges();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> predecessors() {
        return adjacentNodes();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeInEdge(E e10, boolean z10) {
        if (z10) {
            return null;
        }
        return removeOutEdge(e10);
    }

    @Override // com.google.common.graph.NetworkConnections
    public N removeOutEdge(E e10) {
        return (N) Preconditions.checkNotNull(this.incidentEdgeMap.remove(e10));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> successors() {
        return adjacentNodes();
    }
}
