package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public final class Graphs {

    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    public static class TransposedGraph<N> extends ForwardingGraph<N> {
        private final Graph<N> graph;

        public TransposedGraph(Graph<N> graph) {
            this.graph = graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n10, N n11) {
            return delegate().hasEdgeConnecting(n11, n10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n10) {
            return delegate().outDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n10) {
            return delegate().inDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingGraph
        public Graph<N> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n10) {
            return delegate().successors((Object) n10);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n10) {
            return delegate().predecessors((Object) n10);
        }
    }

    public static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {
        private final Network<N, E> network;

        public TransposedNetwork(Network<N, E> network) {
            this.network = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        public Network<N, E> delegate() {
            return this.network;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(N n10, N n11) {
            return delegate().edgeConnectingOrNull(n11, n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N n10, N n11) {
            return delegate().edgesConnecting(n11, n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n10, N n11) {
            return delegate().hasEdgeConnecting(n11, n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n10) {
            return delegate().outDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N n10) {
            return delegate().outEdges(n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E e10) {
            EndpointPair<N> endpointPairIncidentNodes = delegate().incidentNodes(e10);
            return EndpointPair.of((Network<?, ?>) this.network, (Object) endpointPairIncidentNodes.nodeV(), (Object) endpointPairIncidentNodes.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n10) {
            return delegate().inDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N n10) {
            return delegate().inEdges(n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return delegate().edgeConnectingOrNull(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return delegate().edgesConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n10) {
            return delegate().successors((Object) n10);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n10) {
            return delegate().predecessors((Object) n10);
        }
    }

    public static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {
        private final ValueGraph<N, V> graph;

        public TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.graph = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        public ValueGraph<N, V> delegate() {
            return this.graph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(N n10, N n11, @NullableDecl V v10) {
            return delegate().edgeValueOrDefault(n11, n10, v10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n10, N n11) {
            return delegate().hasEdgeConnecting(n11, n10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n10) {
            return delegate().outDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n10) {
            return delegate().inDegree(n10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @NullableDecl
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @NullableDecl V v10) {
            return delegate().edgeValueOrDefault(Graphs.transpose(endpointPair), v10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return delegate().hasEdgeConnecting(Graphs.transpose(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n10) {
            return delegate().successors((Object) n10);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n10) {
            return delegate().predecessors((Object) n10);
        }
    }

    private Graphs() {
    }

    private static boolean canTraverseWithoutReusingEdge(Graph<?> graph, Object obj, @NullableDecl Object obj2) {
        return graph.isDirected() || !Objects.equal(obj2, obj);
    }

    @CanIgnoreReturnValue
    public static int checkNonNegative(int i10) {
        Preconditions.checkArgument(i10 >= 0, "Not true that %s is non-negative.", i10);
        return i10;
    }

    @CanIgnoreReturnValue
    public static int checkPositive(int i10) {
        Preconditions.checkArgument(i10 > 0, "Not true that %s is positive.", i10);
        return i10;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        Iterator<N> it2 = graph.nodes().iterator();
        while (it2.hasNext()) {
            mutableGraph.addNode(it2.next());
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (!graph.isDirected() && size >= graph.nodes().size()) {
            return true;
        }
        HashMap mapNewHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
        Iterator<N> it2 = graph.nodes().iterator();
        while (it2.hasNext()) {
            if (subgraphHasCycle(graph, mapNewHashMapWithExpectedSize, it2.next(), null)) {
                return true;
            }
        }
        return false;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        ConfigurableMutableGraph configurableMutableGraph = iterable instanceof Collection ? (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build() : (MutableGraph<N>) GraphBuilder.from(graph).build();
        Iterator<? extends N> it2 = iterable.iterator();
        while (it2.hasNext()) {
            configurableMutableGraph.addNode(it2.next());
        }
        for (N n10 : configurableMutableGraph.nodes()) {
            for (N n11 : graph.successors((Object) n10)) {
                if (configurableMutableGraph.nodes().contains(n11)) {
                    configurableMutableGraph.putEdge(n10, n11);
                }
            }
        }
        return configurableMutableGraph;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Set<N> reachableNodes(Graph<N> graph, N n10) {
        Preconditions.checkArgument(graph.nodes().contains(n10), GraphConstants.NODE_NOT_IN_GRAPH, n10);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayDeque arrayDeque = new ArrayDeque();
        linkedHashSet.add(n10);
        arrayDeque.add(n10);
        while (!arrayDeque.isEmpty()) {
            for (Object obj : graph.successors(arrayDeque.remove())) {
                if (linkedHashSet.add(obj)) {
                    arrayDeque.add(obj);
                }
            }
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    private static <N> boolean subgraphHasCycle(Graph<N> graph, Map<Object, NodeVisitState> map, N n10, @NullableDecl N n11) {
        NodeVisitState nodeVisitState = map.get(n10);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n10, nodeVisitState2);
        for (N n12 : graph.successors((Object) n10)) {
            if (canTraverseWithoutReusingEdge(graph, n12, n11) && subgraphHasCycle(graph, map, n12, n10)) {
                return true;
            }
        }
        map.put(n10, NodeVisitState.COMPLETE);
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        ConfigurableMutableGraph configurableMutableGraphBuild = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n10 : graph.nodes()) {
                Iterator it2 = reachableNodes(graph, n10).iterator();
                while (it2.hasNext()) {
                    configurableMutableGraphBuild.putEdge(n10, it2.next());
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n11 : graph.nodes()) {
                if (!hashSet.contains(n11)) {
                    Set setReachableNodes = reachableNodes(graph, n11);
                    hashSet.addAll(setReachableNodes);
                    int i10 = 1;
                    for (Object obj : setReachableNodes) {
                        int i11 = i10 + 1;
                        Iterator it3 = Iterables.limit(setReachableNodes, i10).iterator();
                        while (it3.hasNext()) {
                            configurableMutableGraphBuild.putEdge(obj, it3.next());
                        }
                        i10 = i11;
                    }
                }
            }
        }
        return configurableMutableGraphBuild;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        return !graph.isDirected() ? graph : graph instanceof TransposedGraph ? ((TransposedGraph) graph).graph : new TransposedGraph(graph);
    }

    @CanIgnoreReturnValue
    public static long checkNonNegative(long j10) {
        Preconditions.checkArgument(j10 >= 0, "Not true that %s is non-negative.", j10);
        return j10;
    }

    @CanIgnoreReturnValue
    public static long checkPositive(long j10) {
        Preconditions.checkArgument(j10 > 0, "Not true that %s is positive.", j10);
        return j10;
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (!valueGraph.isDirected()) {
            return valueGraph;
        }
        if (valueGraph instanceof TransposedValueGraph) {
            return ((TransposedValueGraph) valueGraph).graph;
        }
        return new TransposedValueGraph(valueGraph);
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        Iterator<N> it2 = valueGraph.nodes().iterator();
        while (it2.hasNext()) {
            mutableValueGraph.addNode(it2.next());
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            mutableValueGraph.putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null));
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (!network.isDirected()) {
            return network;
        }
        if (network instanceof TransposedNetwork) {
            return ((TransposedNetwork) network).network;
        }
        return new TransposedNetwork(network);
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        ConfigurableMutableValueGraph configurableMutableValueGraph;
        if (iterable instanceof Collection) {
            configurableMutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            configurableMutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).build();
        }
        Iterator<? extends N> it2 = iterable.iterator();
        while (it2.hasNext()) {
            configurableMutableValueGraph.addNode(it2.next());
        }
        for (N n10 : configurableMutableValueGraph.nodes()) {
            for (N n11 : valueGraph.successors((Object) n10)) {
                if (configurableMutableValueGraph.nodes().contains(n11)) {
                    configurableMutableValueGraph.putEdgeValue(n10, n11, valueGraph.edgeValueOrDefault(n10, n11, null));
                }
            }
        }
        return configurableMutableValueGraph;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        Iterator<N> it2 = network.nodes().iterator();
        while (it2.hasNext()) {
            mutableNetwork.addNode(it2.next());
        }
        for (E e10 : network.edges()) {
            EndpointPair<N> endpointPairIncidentNodes = network.incidentNodes(e10);
            mutableNetwork.addEdge(endpointPairIncidentNodes.nodeU(), endpointPairIncidentNodes.nodeV(), e10);
        }
        return mutableNetwork;
    }

    public static <N> EndpointPair<N> transpose(EndpointPair<N> endpointPair) {
        return endpointPair.isOrdered() ? EndpointPair.ordered(endpointPair.target(), endpointPair.source()) : endpointPair;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        ConfigurableMutableNetwork configurableMutableNetwork;
        if (iterable instanceof Collection) {
            configurableMutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            configurableMutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).build();
        }
        Iterator<? extends N> it2 = iterable.iterator();
        while (it2.hasNext()) {
            configurableMutableNetwork.addNode(it2.next());
        }
        for (E e10 : configurableMutableNetwork.nodes()) {
            for (E e11 : network.outEdges(e10)) {
                N nAdjacentNode = network.incidentNodes(e11).adjacentNode(e10);
                if (configurableMutableNetwork.nodes().contains(nAdjacentNode)) {
                    configurableMutableNetwork.addEdge(e10, nAdjacentNode, e11);
                }
            }
        }
        return configurableMutableNetwork;
    }
}
