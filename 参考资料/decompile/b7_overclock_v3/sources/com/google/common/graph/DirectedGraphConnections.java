package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {
    private static final Object PRED = new Object();
    private final Map<N, Object> adjacentNodeValues;
    private int predecessorCount;
    private int successorCount;

    public static final class PredAndSucc {
        private final Object successorValue;

        public PredAndSucc(Object obj) {
            this.successorValue = obj;
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, int i10, int i11) {
        this.adjacentNodeValues = (Map) Preconditions.checkNotNull(map);
        this.predecessorCount = Graphs.checkNonNegative(i10);
        this.successorCount = Graphs.checkNonNegative(i11);
        Preconditions.checkState(i10 <= map.size() && i11 <= map.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isPredecessor(@NullableDecl Object obj) {
        return obj == PRED || (obj instanceof PredAndSucc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isSuccessor(@NullableDecl Object obj) {
        return (obj == PRED || obj == null) ? false : true;
    }

    public static <N, V> DirectedGraphConnections<N, V> of() {
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), 0, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> DirectedGraphConnections<N, V> ofImmutable(Set<N> set, Map<N, V> map) {
        HashMap map2 = new HashMap();
        map2.putAll(map);
        for (N n10 : set) {
            Object objPut = map2.put(n10, PRED);
            if (objPut != null) {
                map2.put(n10, new PredAndSucc(objPut));
            }
        }
        return new DirectedGraphConnections<>(ImmutableMap.copyOf((Map) map2), set.size(), map.size());
    }

    @Override // com.google.common.graph.GraphConnections
    public void addPredecessor(N n10, V v10) {
        Map<N, Object> map = this.adjacentNodeValues;
        Object obj = PRED;
        Object objPut = map.put(n10, obj);
        if (objPut == null) {
            int i10 = this.predecessorCount + 1;
            this.predecessorCount = i10;
            Graphs.checkPositive(i10);
        } else if (objPut instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n10, objPut);
        } else if (objPut != obj) {
            this.adjacentNodeValues.put(n10, new PredAndSucc(objPut));
            int i11 = this.predecessorCount + 1;
            this.predecessorCount = i11;
            Graphs.checkPositive(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V addSuccessor(N n10, V v10) {
        V v11 = (V) this.adjacentNodeValues.put(n10, v10);
        if (v11 == 0) {
            int i10 = this.successorCount + 1;
            this.successorCount = i10;
            Graphs.checkPositive(i10);
            return null;
        }
        if (v11 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n10, new PredAndSucc(v10));
            return (V) ((PredAndSucc) v11).successorValue;
        }
        if (v11 != PRED) {
            return v11;
        }
        this.adjacentNodeValues.put(n10, new PredAndSucc(v10));
        int i11 = this.successorCount + 1;
        this.successorCount = i11;
        Graphs.checkPositive(i11);
        return null;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(this.adjacentNodeValues.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> predecessors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isPredecessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.predecessorCount;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                final Iterator it2 = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1.1
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            if (DirectedGraphConnections.isPredecessor(entry.getValue())) {
                                return (N) entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public void removePredecessor(N n10) {
        Object obj = this.adjacentNodeValues.get(n10);
        if (obj == PRED) {
            this.adjacentNodeValues.remove(n10);
            int i10 = this.predecessorCount - 1;
            this.predecessorCount = i10;
            Graphs.checkNonNegative(i10);
            return;
        }
        if (obj instanceof PredAndSucc) {
            this.adjacentNodeValues.put(n10, ((PredAndSucc) obj).successorValue);
            int i11 = this.predecessorCount - 1;
            this.predecessorCount = i11;
            Graphs.checkNonNegative(i11);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V removeSuccessor(Object obj) {
        Object obj2;
        V v10 = (V) this.adjacentNodeValues.get(obj);
        if (v10 == 0 || v10 == (obj2 = PRED)) {
            return null;
        }
        if (v10 instanceof PredAndSucc) {
            this.adjacentNodeValues.put(obj, obj2);
            int i10 = this.successorCount - 1;
            this.successorCount = i10;
            Graphs.checkNonNegative(i10);
            return (V) ((PredAndSucc) v10).successorValue;
        }
        this.adjacentNodeValues.remove(obj);
        int i11 = this.successorCount - 1;
        this.successorCount = i11;
        Graphs.checkNonNegative(i11);
        return v10;
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> successors() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@NullableDecl Object obj) {
                return DirectedGraphConnections.isSuccessor(DirectedGraphConnections.this.adjacentNodeValues.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.successorCount;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public UnmodifiableIterator<N> iterator() {
                final Iterator it2 = DirectedGraphConnections.this.adjacentNodeValues.entrySet().iterator();
                return new AbstractIterator<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2.1
                    @Override // com.google.common.collect.AbstractIterator
                    public N computeNext() {
                        while (it2.hasNext()) {
                            Map.Entry entry = (Map.Entry) it2.next();
                            if (DirectedGraphConnections.isSuccessor(entry.getValue())) {
                                return (N) entry.getKey();
                            }
                        }
                        return endOfData();
                    }
                };
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.GraphConnections
    public V value(N n10) {
        V v10 = (V) this.adjacentNodeValues.get(n10);
        if (v10 == PRED) {
            return null;
        }
        return v10 instanceof PredAndSucc ? (V) ((PredAndSucc) v10).successorValue : v10;
    }
}
