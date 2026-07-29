package lj;

import bj.e;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes5.dex */
public final class d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f39821a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f39822b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f39823c;

    public d(@e T t10, long j10, @e TimeUnit timeUnit) {
        this.f39821a = t10;
        this.f39822b = j10;
        this.f39823c = (TimeUnit) io.reactivex.internal.functions.a.g(timeUnit, "unit is null");
    }

    public long a() {
        return this.f39822b;
    }

    public long b(@e TimeUnit timeUnit) {
        return timeUnit.convert(this.f39822b, this.f39823c);
    }

    @e
    public TimeUnit c() {
        return this.f39823c;
    }

    @e
    public T d() {
        return this.f39821a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return io.reactivex.internal.functions.a.c(this.f39821a, dVar.f39821a) && this.f39822b == dVar.f39822b && io.reactivex.internal.functions.a.c(this.f39823c, dVar.f39823c);
    }

    public int hashCode() {
        T t10 = this.f39821a;
        int iHashCode = t10 != null ? t10.hashCode() : 0;
        long j10 = this.f39822b;
        return (((iHashCode * 31) + ((int) (j10 ^ (j10 >>> 31)))) * 31) + this.f39823c.hashCode();
    }

    public String toString() {
        return "Timed[time=" + this.f39822b + ", unit=" + this.f39823c + ", value=" + this.f39821a + "]";
    }
}
