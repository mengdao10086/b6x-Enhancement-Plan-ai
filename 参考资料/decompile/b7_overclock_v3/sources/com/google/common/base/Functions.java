package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import ee.a;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: loaded from: classes7.dex */
@GwtCompatible
public final class Functions {

    public static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        private final E value;

        public ConstantFunction(@NullableDecl E e10) {
            this.value = e10;
        }

        @Override // com.google.common.base.Function
        public E apply(@NullableDecl Object obj) {
            return this.value;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.equal(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        public int hashCode() {
            E e10 = this.value;
            if (e10 == null) {
                return 0;
            }
            return e10.hashCode();
        }

        public String toString() {
            return "Functions.constant(" + this.value + a.f26979d;
        }
    }

    public static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @NullableDecl
        public final V defaultValue;
        public final Map<K, ? extends V> map;

        public ForMapWithDefault(Map<K, ? extends V> map, @NullableDecl V v10) {
            this.map = (Map) Preconditions.checkNotNull(map);
            this.defaultValue = v10;
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k10) {
            V v10 = this.map.get(k10);
            return (v10 != null || this.map.containsKey(k10)) ? v10 : this.defaultValue;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            return this.map.equals(forMapWithDefault.map) && Objects.equal(this.defaultValue, forMapWithDefault.defaultValue);
        }

        public int hashCode() {
            return Objects.hashCode(this.map, this.defaultValue);
        }

        public String toString() {
            return "Functions.forMap(" + this.map + ", defaultValue=" + this.defaultValue + a.f26979d;
        }
    }

    public static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final Function<A, ? extends B> f21200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Function<B, C> f21201g;

        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.f21201g = (Function) Preconditions.checkNotNull(function);
            this.f21200f = (Function) Preconditions.checkNotNull(function2);
        }

        @Override // com.google.common.base.Function
        public C apply(@NullableDecl A a10) {
            return (C) this.f21201g.apply(this.f21200f.apply(a10));
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            return this.f21200f.equals(functionComposition.f21200f) && this.f21201g.equals(functionComposition.f21201g);
        }

        public int hashCode() {
            return this.f21200f.hashCode() ^ this.f21201g.hashCode();
        }

        public String toString() {
            return this.f21201g + a.f26978c + this.f21200f + a.f26979d;
        }
    }

    public static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        public final Map<K, V> map;

        public FunctionForMapNoDefault(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        @Override // com.google.common.base.Function
        public V apply(@NullableDecl K k10) {
            V v10 = this.map.get(k10);
            Preconditions.checkArgument(v10 != null || this.map.containsKey(k10), "Key '%s' not present in map", k10);
            return v10;
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        public int hashCode() {
            return this.map.hashCode();
        }

        public String toString() {
            return "Functions.forMap(" + this.map + a.f26979d;
        }
    }

    public enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        @Override // com.google.common.base.Function
        @NullableDecl
        public Object apply(@NullableDecl Object obj) {
            return obj;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    public static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        public int hashCode() {
            return this.predicate.hashCode();
        }

        public String toString() {
            return "Functions.forPredicate(" + this.predicate + a.f26979d;
        }

        private PredicateFunction(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.common.base.Function
        public Boolean apply(@NullableDecl T t10) {
            return Boolean.valueOf(this.predicate.apply(t10));
        }
    }

    public static class SupplierFunction<T> implements Function<Object, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        @Override // com.google.common.base.Function
        public T apply(@NullableDecl Object obj) {
            return this.supplier.get();
        }

        @Override // com.google.common.base.Function
        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        public int hashCode() {
            return this.supplier.hashCode();
        }

        public String toString() {
            return "Functions.forSupplier(" + this.supplier + a.f26979d;
        }

        private SupplierFunction(Supplier<T> supplier) {
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier);
        }
    }

    public enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        @Override // com.google.common.base.Function
        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }
    }

    private Functions() {
    }

    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    public static <E> Function<Object, E> constant(@NullableDecl E e10) {
        return new ConstantFunction(e10);
    }

    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new PredicateFunction(predicate);
    }

    public static <T> Function<Object, T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction(supplier);
    }

    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @NullableDecl V v10) {
        return new ForMapWithDefault(map, v10);
    }
}
