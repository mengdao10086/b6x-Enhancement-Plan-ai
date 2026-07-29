package com.google.common.graph;

import com.google.common.base.Optional;

/* JADX INFO: loaded from: classes7.dex */
abstract class AbstractGraphBuilder<N> {
    public final boolean directed;
    public boolean allowsSelfLoops = false;
    public ElementOrder<N> nodeOrder = ElementOrder.insertion();
    public Optional<Integer> expectedNodeCount = Optional.absent();

    public AbstractGraphBuilder(boolean z10) {
        this.directed = z10;
    }
}
