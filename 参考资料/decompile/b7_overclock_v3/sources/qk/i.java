package qk;

import java.lang.Comparable;
import kotlin.jvm.internal.f0;
import qk.s;

/* JADX INFO: loaded from: classes5.dex */
public class i<T extends Comparable<? super T>> implements s<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final T f47401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final T f47402b;

    public i(@yt.k T start, @yt.k T endExclusive) {
        f0.p(start, "start");
        f0.p(endExclusive, "endExclusive");
        this.f47401a = start;
        this.f47402b = endExclusive;
    }

    @Override // qk.s
    @yt.k
    public T a() {
        return this.f47401a;
    }

    @Override // qk.s
    public boolean contains(@yt.k T t10) {
        return s.a.a(this, t10);
    }

    @Override // qk.s
    @yt.k
    public T d() {
        return this.f47402b;
    }

    public boolean equals(@yt.l Object obj) {
        if (obj instanceof i) {
            if (!isEmpty() || !((i) obj).isEmpty()) {
                i iVar = (i) obj;
                if (!f0.g(a(), iVar.a()) || !f0.g(d(), iVar.d())) {
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
        return (a().hashCode() * 31) + d().hashCode();
    }

    @Override // qk.s
    public boolean isEmpty() {
        return s.a.b(this);
    }

    @yt.k
    public String toString() {
        return a() + "..<" + d();
    }
}
