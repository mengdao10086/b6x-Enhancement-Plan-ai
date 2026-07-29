package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private GraphBuilder(boolean z10) {
        super(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N> GraphBuilder<N1> cast() {
        return this;
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return (GraphBuilder<N>) new GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder());
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    public GraphBuilder<N> allowsSelfLoops(boolean z10) {
        this.allowsSelfLoops = z10;
        return this;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new ConfigurableMutableGraph(this);
    }

    public GraphBuilder<N> expectedNodeCount(int i10) {
        this.expectedNodeCount = Optional.of(Integer.valueOf(Graphs.checkNonNegative(i10)));
        return this;
    }

    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        GraphBuilder<N1> graphBuilderCast = cast();
        graphBuilderCast.nodeOrder = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return graphBuilderCast;
    }
}
