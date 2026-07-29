package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@Immutable(containerOf = {"B"})
@GwtIncompatible
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        private static <B, T extends B> T cast(Class<T> cls, B b10) {
            return (T) Primitives.wrap(cls).cast(b10);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> immutableMapBuild = this.mapBuilder.build();
            return immutableMapBuild.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<>(immutableMapBuild);
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> cls, T t10) {
            this.mapBuilder.put(cls, t10);
            return this;
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class key = entry.getKey();
                T value = entry.getValue();
                this.mapBuilder.put((Class<? extends B>) key, (B) cast(key, value));
            }
            return this;
        }
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof ImmutableClassToInstanceMap ? (ImmutableClassToInstanceMap) map : new Builder().putAll(map).build();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(Preconditions.checkNotNull(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        throw new UnsupportedOperationException();
    }

    public Object readResolve() {
        return isEmpty() ? of() : this;
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t10) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t10));
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }
}
