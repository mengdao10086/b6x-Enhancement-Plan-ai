package qk;

import java.lang.Comparable;
import kotlin.jvm.internal.f0;
import qk.h;

/* JADX INFO: loaded from: classes5.dex */
public class j<T extends Comparable<? super T>> implements h<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final T f47403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final T f47404b;

    public j(@yt.k T start, @yt.k T endInclusive) {
        f0.p(start, "start");
        f0.p(endInclusive, "endInclusive");
        this.f47403a = start;
        this.f47404b = endInclusive;
    }

    @Override // qk.h
    @yt.k
    public T a() {
        return this.f47403a;
    }

    @Override // qk.h
    public boolean contains(@yt.k T t10) {
        return h.a.a(this, t10);
    }

    @Override // qk.h
    @yt.k
    public T e() {
        return this.f47404b;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof j) {
            if (!isEmpty() || !((j) obj).isEmpty()) {
                j jVar = (j) obj;
                if (!f0.g(a(), jVar.a()) || !f0.g(e(), jVar.e())) {
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (a().hashCode() * 31) + e().hashCode();
    }

    @Override // qk.h
    public boolean isEmpty() {
        return h.a.b(this);
    }

    @yt.k
    public String toString() {
        return a() + ".." + e();
    }
}
