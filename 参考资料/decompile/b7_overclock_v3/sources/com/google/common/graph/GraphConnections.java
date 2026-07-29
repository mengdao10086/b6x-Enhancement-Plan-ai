package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
interface GraphConnections<N, V> {
    void addPredecessor(N n10, V v10);

    @CanIgnoreReturnValue
    V addSuccessor(N n10, V v10);

    Set<N> adjacentNodes();

    Set<N> predecessors();

    void removePredecessor(N n10);

    @CanIgnoreReturnValue
    V removeSuccessor(N n10);

    Set<N> successors();

    @NullableDecl
    V value(N n10);
}
