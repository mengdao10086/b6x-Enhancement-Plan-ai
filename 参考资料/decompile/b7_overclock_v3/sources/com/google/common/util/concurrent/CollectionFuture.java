package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true)
abstract class CollectionFuture<V, C> extends AggregateFuture<V, C> {

    public abstract class CollectionFutureRunningState extends AggregateFuture<V, C>.RunningState {
        private List<Optional<V>> values;

        public CollectionFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z10) {
            super(immutableCollection, z10, true);
            this.values = immutableCollection.isEmpty() ? ImmutableList.of() : Lists.newArrayListWithCapacity(immutableCollection.size());
            for (int i10 = 0; i10 < immutableCollection.size(); i10++) {
                this.values.add(null);
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void collectOneValue(boolean z10, int i10, @NullableDecl V v10) {
            List<Optional<V>> list = this.values;
            if (list != null) {
                list.set(i10, Optional.fromNullable(v10));
            } else {
                Preconditions.checkState(z10 || CollectionFuture.this.isCancelled(), "Future was done before all dependencies completed");
            }
        }

        public abstract C combine(List<Optional<V>> list);

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public final void handleAllCompleted() {
            List<Optional<V>> list = this.values;
            if (list != null) {
                CollectionFuture.this.set(combine(list));
            } else {
                Preconditions.checkState(CollectionFuture.this.isDone());
            }
        }

        @Override // com.google.common.util.concurrent.AggregateFuture.RunningState
        public void releaseResourcesAfterFailure() {
            super.releaseResourcesAfterFailure();
            this.values = null;
        }
    }

    public static final class ListFuture<V> extends CollectionFuture<V, List<V>> {

        public final class ListFutureRunningState extends CollectionFuture<V, List<V>>.CollectionFutureRunningState {
            public ListFutureRunningState(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z10) {
                super(immutableCollection, z10);
            }

            @Override // com.google.common.util.concurrent.CollectionFuture.CollectionFutureRunningState
            public List<V> combine(List<Optional<V>> list) {
                ArrayList arrayListNewArrayListWithCapacity = Lists.newArrayListWithCapacity(list.size());
                Iterator<Optional<V>> it2 = list.iterator();
                while (it2.hasNext()) {
                    Optional<V> next = it2.next();
                    arrayListNewArrayListWithCapacity.add(next != null ? next.orNull() : null);
                }
                return Collections.unmodifiableList(arrayListNewArrayListWithCapacity);
            }
        }

        public ListFuture(ImmutableCollection<? extends ListenableFuture<? extends V>> immutableCollection, boolean z10) {
            init(new ListFutureRunningState(immutableCollection, z10));
        }
    }
}
