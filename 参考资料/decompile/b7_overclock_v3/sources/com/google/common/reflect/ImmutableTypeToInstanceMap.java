package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
@Beta
public final class ImmutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {
    private final ImmutableMap<TypeToken<? extends B>, B> delegate;

    @Beta
    public static final class Builder<B> {
        private final ImmutableMap.Builder<TypeToken<? extends B>, B> mapBuilder;

        public ImmutableTypeToInstanceMap<B> build() {
            return new ImmutableTypeToInstanceMap<>(this.mapBuilder.build());
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(Class<T> cls, T t10) {
            this.mapBuilder.put(TypeToken.of((Class) cls), t10);
            return this;
        }

        private Builder() {
            this.mapBuilder = ImmutableMap.builder();
        }

        @CanIgnoreReturnValue
        public <T extends B> Builder<B> put(TypeToken<T> typeToken, T t10) {
            this.mapBuilder.put(typeToken.rejectTypeVariables(), t10);
            return this;
        }
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    public static <B> ImmutableTypeToInstanceMap<B> of() {
        return new ImmutableTypeToInstanceMap<>(ImmutableMap.of());
    }

    private <T extends B> T trustedGet(TypeToken<T> typeToken) {
        return this.delegate.get(typeToken);
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(TypeToken<T> typeToken) {
        return (T) trustedGet(typeToken.rejectTypeVariables());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(TypeToken<T> typeToken, T t10) {
        throw new UnsupportedOperationException();
    }

    private ImmutableTypeToInstanceMap(ImmutableMap<TypeToken<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    public <T extends B> T getInstance(Class<T> cls) {
        return (T) trustedGet(TypeToken.of((Class) cls));
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map, com.google.common.collect.BiMap
    @CanIgnoreReturnValue
    @Deprecated
    public B put(TypeToken<? extends B> typeToken, B b10) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.reflect.TypeToInstanceMap
    @CanIgnoreReturnValue
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t10) {
        throw new UnsupportedOperationException();
    }
}
