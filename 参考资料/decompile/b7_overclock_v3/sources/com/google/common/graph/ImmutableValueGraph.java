package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.Immutable;
import i1.a;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Immutable(containerOf = {"N", a.X4})
@Beta
public final class ImmutableValueGraph<N, V> extends ConfigurableValueGraph<N, V> {
    private ImmutableValueGraph(ValueGraph<N, V> valueGraph) {
        super(ValueGraphBuilder.from(valueGraph), getNodeConnections(valueGraph), valueGraph.edges().size());
    }

    private static <N, V> GraphConnections<N, V> connectionsOf(final ValueGraph<N, V> valueGraph, final N n10) {
        Function<N, V> function = new Function<N, V>() { // from class: com.google.common.graph.ImmutableValueGraph.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.google.common.base.Function
            public V apply(N n11) {
                return (V) valueGraph.edgeValueOrDefault(n10, n11, null);
            }
        };
        return valueGraph.isDirected() ? DirectedGraphConnections.ofImmutable(valueGraph.predecessors((Object) n10), Maps.asMap(valueGraph.successors((Object) n10), function)) : UndirectedGraphConnections.ofImmutable(Maps.asMap(valueGraph.adjacentNodes(n10), function));
    }

    public static <N, V> ImmutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        return valueGraph instanceof ImmutableValueGraph ? (ImmutableValueGraph) valueGraph : new ImmutableValueGraph<>(valueGraph);
    }

    private static <N, V> ImmutableMap<N, GraphConnections<N, V>> getNodeConnections(ValueGraph<N, V> valueGraph) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n10 : valueGraph.nodes()) {
            builder.put(n10, connectionsOf(valueGraph, n10));
        }
        return builder.build();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(EndpointPair endpointPair, @NullableDecl Object obj) {
        return super.edgeValueOrDefault(endpointPair, obj);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(EndpointPair endpointPair) {
        return super.hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.BaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors(obj);
    }

    @Deprecated
    public static <N, V> ImmutableValueGraph<N, V> copyOf(ImmutableValueGraph<N, V> immutableValueGraph) {
        return (ImmutableValueGraph) Preconditions.checkNotNull(immutableValueGraph);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.ValueGraph
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.ValueGraph
    @NullableDecl
    public /* bridge */ /* synthetic */ Object edgeValueOrDefault(Object obj, Object obj2, @NullableDecl Object obj3) {
        return super.edgeValueOrDefault(obj, obj2, obj3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.ConfigurableValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public /* bridge */ /* synthetic */ boolean hasEdgeConnecting(Object obj, Object obj2) {
        return super.hasEdgeConnecting(obj, obj2);
    }
}
