package kotlin.jvm.internal;

import java.util.Collection;
import kotlin.jvm.KotlinReflectionNotSupportedError;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.v0(version = "1.1")
public final class l0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final Class<?> f37912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final String f37913b;

    public l0(@yt.k Class<?> jClass, @yt.k String moduleName) {
        f0.p(jClass, "jClass");
        f0.p(moduleName, "moduleName");
        this.f37912a = jClass;
        this.f37913b = moduleName;
    }

    public boolean equals(@yt.l Object obj) {
        return (obj instanceof l0) && f0.g(h(), ((l0) obj).h());
    }

    @Override // kotlin.jvm.internal.r
    @yt.k
    public Class<?> h() {
        return this.f37912a;
    }

    public int hashCode() {
        return h().hashCode();
    }

    @Override // kotlin.reflect.h
    @yt.k
    public Collection<kotlin.reflect.c<?>> n() {
        throw new KotlinReflectionNotSupportedError();
    }

    @yt.k
    public String toString() {
        return h().toString() + n0.f37924b;
    }
}
