package io.objectbox.query;

import io.objectbox.BoxStore;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
@li.c
public class m0<T> implements pi.b<List<T>>, Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Query<T> f32890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ii.a<T> f32891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<pi.a<List<T>>> f32892c = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Deque<pi.a<List<T>>> f32893d = new ArrayDeque();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile boolean f32894e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b<T> f32895f = new b<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public pi.a<Class<T>> f32896g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public pi.d f32897h;

    public static class b<T> implements pi.a<List<T>> {
        public b() {
        }

        @Override // pi.a
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void b(List<T> list) {
        }
    }

    public m0(Query<T> query, ii.a<T> aVar) {
        this.f32890a = query;
        this.f32891b = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(Class cls) {
        f();
    }

    @Override // pi.b
    public synchronized void a(pi.a<List<T>> aVar, @Nullable Object obj) {
        pi.c.a(this.f32892c, aVar);
        if (this.f32892c.isEmpty()) {
            this.f32897h.cancel();
            this.f32897h = null;
        }
    }

    @Override // pi.b
    public synchronized void b(pi.a<List<T>> aVar, @Nullable Object obj) {
        BoxStore boxStoreW = this.f32891b.w();
        if (this.f32896g == null) {
            this.f32896g = new pi.a() { // from class: io.objectbox.query.l0
                @Override // pi.a
                public final void b(Object obj2) {
                    this.f32888a.e((Class) obj2);
                }
            };
        }
        if (this.f32892c.isEmpty()) {
            if (this.f32897h != null) {
                throw new IllegalStateException("Existing subscription found");
            }
            this.f32897h = boxStoreW.P2(this.f32891b.l()).l().i().f(this.f32896g);
        }
        this.f32892c.add(aVar);
    }

    @Override // pi.b
    public void c(pi.a<List<T>> aVar, @Nullable Object obj) {
        g(aVar);
    }

    public void f() {
        g(this.f32895f);
    }

    public final void g(pi.a<List<T>> aVar) {
        synchronized (this.f32893d) {
            this.f32893d.add(aVar);
            if (!this.f32894e) {
                this.f32894e = true;
                this.f32891b.w().l2(this);
            }
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        boolean z10;
        while (true) {
            try {
                arrayList = new ArrayList();
            } finally {
            }
            synchronized (this.f32893d) {
                z10 = false;
                while (true) {
                    pi.a<List<T>> aVarPoll = this.f32893d.poll();
                    if (aVarPoll == null) {
                        break;
                    } else if (this.f32895f.equals(aVarPoll)) {
                        z10 = true;
                    } else {
                        arrayList.add(aVarPoll);
                    }
                    this.f32894e = false;
                }
                if (!z10 && arrayList.isEmpty()) {
                    this.f32894e = false;
                    return;
                }
                this.f32894e = false;
            }
            List<T> listW = this.f32890a.W();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((pi.a) it2.next()).b(listW);
            }
            if (z10) {
                Iterator<pi.a<List<T>>> it3 = this.f32892c.iterator();
                while (it3.hasNext()) {
                    it3.next().b(listW);
                }
            }
        }
    }
}
