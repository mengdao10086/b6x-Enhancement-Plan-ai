package r2;

import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.List;
import u2.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> implements q2.a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f47718a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public T f47719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public s2.d<T> f47720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f47721d;

    public interface a {
        void a(@n0 List<String> workSpecIds);

        void b(@n0 List<String> workSpecIds);
    }

    public c(s2.d<T> tracker) {
        this.f47720c = tracker;
    }

    @Override // q2.a
    public void a(@p0 T newValue) {
        this.f47719b = newValue;
        h(this.f47721d, newValue);
    }

    public abstract boolean b(@n0 r workSpec);

    public abstract boolean c(@n0 T currentValue);

    public boolean d(@n0 String workSpecId) {
        T t10 = this.f47719b;
        return t10 != null && c(t10) && this.f47718a.contains(workSpecId);
    }

    public void e(@n0 Iterable<r> workSpecs) {
        this.f47718a.clear();
        for (r rVar : workSpecs) {
            if (b(rVar)) {
                this.f47718a.add(rVar.f51841a);
            }
        }
        if (this.f47718a.isEmpty()) {
            this.f47720c.c(this);
        } else {
            this.f47720c.a(this);
        }
        h(this.f47721d, this.f47719b);
    }

    public void f() {
        if (this.f47718a.isEmpty()) {
            return;
        }
        this.f47718a.clear();
        this.f47720c.c(this);
    }

    public void g(@p0 a callback) {
        if (this.f47721d != callback) {
            this.f47721d = callback;
            h(callback, this.f47719b);
        }
    }

    public final void h(@p0 a callback, @p0 T currentValue) {
        if (this.f47718a.isEmpty() || callback == null) {
            return;
        }
        if (currentValue == null || c(currentValue)) {
            callback.b(this.f47718a);
        } else {
            callback.a(this.f47718a);
        }
    }
}
