package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        public Builder(int i10) {
            super(i10);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            if (this.size == 0) {
                return ImmutableBiMap.of();
            }
            sortEntries();
            this.entriesUsed = true;
            return new RegularImmutableBiMap(this.alternatingKeysAndValues, this.size);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k10, V v10) {
            super.put((Object) k10, (Object) v10);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        @Beta
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    public static class SerializedForm extends ImmutableMap.SerializedForm {
        private static final long serialVersionUID = 0;

        public SerializedForm(ImmutableBiMap<?, ?> immutableBiMap) {
            super(immutableBiMap);
        }

        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        public Object readResolve() {
            return createMap(new Builder());
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    @Beta
    public static <K, V> Builder<K, V> builderWithExpectedSize(int i10) {
        CollectPreconditions.checkNonnegative(i10, "expectedSize");
        return new Builder<>(i10);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.isPartialView()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.EMPTY;
    }

    @Override // com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public V forcePut(K k10, V v10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    @Override // com.google.common.collect.ImmutableMap
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10) {
        CollectPreconditions.checkEntryNotNull(k10, v10);
        return new RegularImmutableBiMap(new Object[]{k10, v10}, 1);
    }

    @Override // com.google.common.collect.ImmutableMap
    public final ImmutableSet<V> createValues() {
        throw new AssertionError("should never be called");
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11) {
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    @Beta
    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12) {
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        CollectPreconditions.checkEntryNotNull(k12, v12);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13) {
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        CollectPreconditions.checkEntryNotNull(k12, v12);
        CollectPreconditions.checkEntryNotNull(k13, v13);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k10, V v10, K k11, V v11, K k12, V v12, K k13, V v13, K k14, V v14) {
        CollectPreconditions.checkEntryNotNull(k10, v10);
        CollectPreconditions.checkEntryNotNull(k11, v11);
        CollectPreconditions.checkEntryNotNull(k12, v12);
        CollectPreconditions.checkEntryNotNull(k13, v13);
        CollectPreconditions.checkEntryNotNull(k14, v14);
        return new RegularImmutableBiMap(new Object[]{k10, v10, k11, v11, k12, v12, k13, v13, k14, v14}, 5);
    }
}
