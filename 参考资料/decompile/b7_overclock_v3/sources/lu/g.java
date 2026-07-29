package lu;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.c;
import retrofit2.r;
import retrofit2.s;
import xi.h0;
import xi.i0;
import xi.j;
import xi.q;
import xi.z;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final h0 f40481a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f40482b;

    public g(@Nullable h0 h0Var, boolean z10) {
        this.f40481a = h0Var;
        this.f40482b = z10;
    }

    public static g d() {
        return new g(null, false);
    }

    public static g e() {
        return new g(null, true);
    }

    public static g f(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler == null");
        return new g(h0Var, false);
    }

    @Override // retrofit2.c.a
    @Nullable
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        Type typeB;
        boolean z10;
        boolean z11;
        Class<?> clsC = c.a.c(type);
        if (clsC == xi.a.class) {
            return new f(Void.class, this.f40481a, this.f40482b, false, true, false, false, false, true);
        }
        boolean z12 = clsC == j.class;
        boolean z13 = clsC == i0.class;
        boolean z14 = clsC == q.class;
        if (clsC != z.class && !z12 && !z13 && !z14) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z12 ? !z13 ? z14 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeB2 = c.a.b(0, (ParameterizedType) type);
        Class<?> clsC2 = c.a.c(typeB2);
        if (clsC2 == r.class) {
            if (!(typeB2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            typeB = c.a.b(0, (ParameterizedType) typeB2);
            z10 = false;
        } else {
            if (clsC2 != d.class) {
                typeB = typeB2;
                z10 = false;
                z11 = true;
                return new f(typeB, this.f40481a, this.f40482b, z10, z11, z12, z13, z14, false);
            }
            if (!(typeB2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            typeB = c.a.b(0, (ParameterizedType) typeB2);
            z10 = true;
        }
        z11 = false;
        return new f(typeB, this.f40481a, this.f40482b, z10, z11, z12, z13, z14, false);
    }
}
