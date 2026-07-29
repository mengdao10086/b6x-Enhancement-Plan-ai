package com.google.common.graph;

import java.util.Set;

/* JADX INFO: loaded from: classes7.dex */
interface BaseGraph<N> extends SuccessorsFunction<N>, PredecessorsFunction<N> {
    Set<N> adjacentNodes(N n10);

    boolean allowsSelfLoops();

    int degree(N n10);

    Set<EndpointPair<N>> edges();

    boolean hasEdgeConnecting(EndpointPair<N> endpointPair);

    boolean hasEdgeConnecting(N n10, N n11);

    int inDegree(N n10);

    Set<EndpointPair<N>> incidentEdges(N n10);

    boolean isDirected();

    ElementOrder<N> nodeOrder();

    Set<N> nodes();

    int outDegree(N n10);

    Set<N> predecessors(N n10);

    @Override // com.google.common.graph.SuccessorsFunction
    Set<N> successors(N n10);
}
