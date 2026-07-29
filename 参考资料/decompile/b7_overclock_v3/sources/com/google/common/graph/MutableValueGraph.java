package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n10);

    @CanIgnoreReturnValue
    V putEdgeValue(EndpointPair<N> endpointPair, V v10);

    @CanIgnoreReturnValue
    V putEdgeValue(N n10, N n11, V v10);

    @CanIgnoreReturnValue
    V removeEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    V removeEdge(N n10, N n11);

    @CanIgnoreReturnValue
    boolean removeNode(N n10);
}
