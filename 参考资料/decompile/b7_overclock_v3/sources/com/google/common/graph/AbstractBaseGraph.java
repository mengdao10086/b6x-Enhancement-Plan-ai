package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    public static abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {
        public final BaseGraph<N> graph;
        public final N node;

        public static final class Directed<N> extends IncidentEdgeSet<N> {
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (!endpointPair.isOrdered()) {
                    return false;
                }
                Object objSource = endpointPair.source();
                Object objTarget = endpointPair.target();
                return (this.node.equals(objSource) && this.graph.successors((Object) this.node).contains(objTarget)) || (this.node.equals(objTarget) && this.graph.predecessors((Object) this.node).contains(objSource));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return (this.graph.inDegree(this.node) + this.graph.outDegree(this.node)) - (this.graph.successors((Object) this.node).contains(this.node) ? 1 : 0);
            }

            private Directed(BaseGraph<N> baseGraph, N n10) {
                super(baseGraph, n10);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.graph.predecessors((Object) this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.1
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n10) {
                        return EndpointPair.ordered(n10, Directed.this.node);
                    }
                }), Iterators.transform(Sets.difference(this.graph.successors((Object) this.node), ImmutableSet.of(this.node)).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Directed.2
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n10) {
                        return EndpointPair.ordered(Directed.this.node, n10);
                    }
                })));
            }
        }

        public static final class Undirected<N> extends IncidentEdgeSet<N> {
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair endpointPair = (EndpointPair) obj;
                if (endpointPair.isOrdered()) {
                    return false;
                }
                Set<N> setAdjacentNodes = this.graph.adjacentNodes(this.node);
                Object objNodeU = endpointPair.nodeU();
                Object objNodeV = endpointPair.nodeV();
                return (this.node.equals(objNodeV) && setAdjacentNodes.contains(objNodeU)) || (this.node.equals(objNodeU) && setAdjacentNodes.contains(objNodeV));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.graph.adjacentNodes(this.node).size();
            }

            private Undirected(BaseGraph<N> baseGraph, N n10) {
                super(baseGraph, n10);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return Iterators.unmodifiableIterator(Iterators.transform(this.graph.adjacentNodes(this.node).iterator(), new Function<N, EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.IncidentEdgeSet.Undirected.1
                    @Override // com.google.common.base.Function
                    public EndpointPair<N> apply(N n10) {
                        return EndpointPair.unordered(Undirected.this.node, n10);
                    }
                }));
            }
        }

        public static <N> IncidentEdgeSet<N> of(BaseGraph<N> baseGraph, N n10) {
            return baseGraph.isDirected() ? new Directed(baseGraph, n10) : new Undirected(baseGraph, n10);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        private IncidentEdgeSet(BaseGraph<N> baseGraph, N n10) {
            this.graph = baseGraph;
            this.node = n10;
        }
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n10) {
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((Object) n10).size(), successors((Object) n10).size());
        }
        Set<N> setAdjacentNodes = adjacentNodes(n10);
        return IntMath.saturatedAdd(setAdjacentNodes.size(), (allowsSelfLoops() && setAdjacentNodes.contains(n10)) ? 1 : 0);
    }

    public long edgeCount() {
        Iterator<N> it2 = nodes().iterator();
        long jDegree = 0;
        while (it2.hasNext()) {
            jDegree += (long) degree(it2.next());
        }
        Preconditions.checkState((1 & jDegree) == 0);
        return jDegree >>> 1;
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                return AbstractBaseGraph.this.isOrderingCompatible(endpointPair) && AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) && AbstractBaseGraph.this.successors(endpointPair.nodeU()).contains(endpointPair.nodeV());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.edgeCount());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.of(AbstractBaseGraph.this);
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n10, N n11) {
        Preconditions.checkNotNull(n10);
        Preconditions.checkNotNull(n11);
        return nodes().contains(n10) && successors((Object) n10).contains(n11);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n10) {
        return isDirected() ? predecessors((Object) n10).size() : degree(n10);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n10) {
        Preconditions.checkNotNull(n10);
        Preconditions.checkArgument(nodes().contains(n10), GraphConstants.NODE_NOT_IN_GRAPH, n10);
        return IncidentEdgeSet.of((BaseGraph) this, (Object) n10);
    }

    public final boolean isOrderingCompatible(EndpointPair<?> endpointPair) {
        return endpointPair.isOrdered() || !isDirected();
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n10) {
        return isDirected() ? successors((Object) n10).size() : degree(n10);
    }

    public final void validateEndpoints(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(isOrderingCompatible(endpointPair), GraphConstants.ENDPOINTS_MISMATCH);
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (!isOrderingCompatible(endpointPair)) {
            return false;
        }
        N nNodeU = endpointPair.nodeU();
        return nodes().contains(nNodeU) && successors((Object) nNodeU).contains(endpointPair.nodeV());
    }
}
