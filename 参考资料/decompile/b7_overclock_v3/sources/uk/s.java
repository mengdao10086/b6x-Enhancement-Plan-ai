package uk;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.v0;

/* JADX INFO: loaded from: classes5.dex */
@v0(version = "1.3")
@k
public final class s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f52189a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f52190b;

    public s(T t10, long j10) {
        this.f52189a = t10;
        this.f52190b = j10;
    }

    public /* synthetic */ s(Object obj, long j10, u uVar) {
        this(obj, j10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ s d(s sVar, Object obj, long j10, int i10, Object obj2) {
        if ((i10 & 1) != 0) {
            obj = sVar.f52189a;
        }
        if ((i10 & 2) != 0) {
            j10 = sVar.f52190b;
        }
        return sVar.c(obj, j10);
    }

    public final T a() {
        return this.f52189a;
    }

    public final long b() {
        return this.f52190b;
    }

    @yt.k
    public final s<T> c(T t10, long j10) {
        return new s<>(t10, j10, null);
    }

    public final long e() {
        return this.f52190b;
    }

    public boolean equals(@yt.l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return f0.g(this.f52189a, sVar.f52189a) && e.p(this.f52190b, sVar.f52190b);
    }

    public final T f() {
        return this.f52189a;
    }

    public int hashCode() {
        T t10 = this.f52189a;
        return ((t10 == null ? 0 : t10.hashCode()) * 31) + e.Z(this.f52190b);
    }

    @yt.k
    public String toString() {
        return "TimedValue(value=" + this.f52189a + ", duration=" + ((Object) e.u0(this.f52190b)) + ')';
    }
}
