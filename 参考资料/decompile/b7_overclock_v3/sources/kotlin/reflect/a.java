package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.q
public final class a implements GenericArrayType, u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Type f38019a;

    public a(@yt.k Type elementType) {
        f0.p(elementType, "elementType");
        this.f38019a = elementType;
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof GenericArrayType) && f0.g(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    @yt.k
    public Type getGenericComponentType() {
        return this.f38019a;
    }

    @Override // java.lang.reflect.Type, kotlin.reflect.u
    @yt.k
    public String getTypeName() {
        return TypesJVMKt.j(this.f38019a) + okhttp3.u.f43953p;
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    @yt.k
    public String toString() {
        return getTypeName();
    }
}
