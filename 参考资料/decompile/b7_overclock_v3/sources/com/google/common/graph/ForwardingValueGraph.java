package com.google.common.graph;

import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
abstract class ForwardingValueGraph<N, V> extends AbstractValueGraph<N, V> {
    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n10) {
        return delegate().adjacentNodes(n10);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return delegate().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int degree(N n10) {
        return delegate().degree(n10);
    }

    public abstract ValueGraph<N, V> delegate();

    @Override // com.google.common.graph.AbstractBaseGraph
    public long edgeCount() {
        return delegate().edges().size();
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(N n10, N n11, @NullableDecl V v10) {
        return delegate().edgeValueOrDefault(n10, n11, v10);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n10, N n11) {
        return delegate().hasEdgeConnecting(n10, n11);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int inDegree(N n10) {
        return delegate().inDegree(n10);
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return delegate().isDirected();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return delegate().nodeOrder();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return delegate().nodes();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public int outDegree(N n10) {
        return delegate().outDegree(n10);
    }

    @Override // com.google.common.graph.ValueGraph
    @NullableDecl
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v10) {
        return delegate().edgeValueOrDefault(endpointPair, v10);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return delegate().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n10) {
        return delegate().predecessors((Object) n10);
    }

    @Override // com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n10) {
        return delegate().successors((Object) n10);
    }
}
