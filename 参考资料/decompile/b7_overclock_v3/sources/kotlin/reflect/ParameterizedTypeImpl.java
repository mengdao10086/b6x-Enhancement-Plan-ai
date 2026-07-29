package kotlin.reflect;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;

/* JADX INFO: loaded from: classes5.dex */
@t0({"SMAP\nTypesJVM.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n37#2,2:231\n*S KotlinDebug\n*F\n+ 1 TypesJVM.kt\nkotlin/reflect/ParameterizedTypeImpl\n*L\n190#1:231,2\n*E\n"})
@kotlin.q
public final class ParameterizedTypeImpl implements ParameterizedType, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Class<?> f38013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final Type f38014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final Type[] f38015c;

    public ParameterizedTypeImpl(@yt.k Class<?> rawType, @yt.l Type type, @yt.k List<? extends Type> typeArguments) {
        f0.p(rawType, "rawType");
        f0.p(typeArguments, "typeArguments");
        this.f38013a = rawType;
        this.f38014b = type;
        this.f38015c = (Type[]) typeArguments.toArray(new Type[0]);
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            if (f0.g(this.f38013a, parameterizedType.getRawType()) && f0.g(this.f38014b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    @yt.k
    public Type[] getActualTypeArguments() {
        return this.f38015c;
    }

    @Override // java.lang.reflect.ParameterizedType
    @yt.l
    public Type getOwnerType() {
        return this.f38014b;
    }

    @Override // java.lang.reflect.ParameterizedType
    @yt.k
    public Type getRawType() {
        return this.f38013a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.u
    @yt.k
    public String getTypeName() throws IOException {
        StringBuilder sb2 = new StringBuilder();
        Type type = this.f38014b;
        if (type != null) {
            sb2.append(TypesJVMKt.j(type));
            sb2.append("$");
            sb2.append(this.f38013a.getSimpleName());
        } else {
            sb2.append(TypesJVMKt.j(this.f38013a));
        }
        Type[] typeArr = this.f38015c;
        if (!(typeArr.length == 0)) {
            ArraysKt___ArraysKt.lh(typeArr, sb2, (50 & 2) != 0 ? ", " : null, (50 & 4) != 0 ? "" : "<", (50 & 8) == 0 ? ">" : "", (50 & 16) != 0 ? -1 : 0, (50 & 32) != 0 ? "..." : null, (50 & 64) != 0 ? null : ParameterizedTypeImpl$getTypeName$1$1.f38016c);
        }
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    public int hashCode() {
        int iHashCode = this.f38013a.hashCode();
        Type type = this.f38014b;
        return (iHashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    @yt.k
    public String toString() {
        return getTypeName();
    }
}
