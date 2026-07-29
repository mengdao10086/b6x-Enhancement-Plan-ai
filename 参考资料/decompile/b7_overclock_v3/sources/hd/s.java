package hd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.common.base.Supplier;
import hd.x;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes3.dex */
public final class s<T, E extends x> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f31124i = 0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f31125j = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hd.c f31126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f31127b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Supplier<E> f31128c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b<T, E> f31129d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CopyOnWriteArraySet<c<T, E>> f31130e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayDeque<Runnable> f31131f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ArrayDeque<Runnable> f31132g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f31133h;

    public interface a<T> {
        void i(T t10);
    }

    public interface b<T, E extends x> {
        void a(T t10, E e10);
    }

    public static final class c<T, E extends x> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nonnull
        public final T f31134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public E f31135b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f31136c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f31137d;

        public c(@Nonnull T t10, Supplier<E> supplier) {
            this.f31134a = t10;
            this.f31135b = supplier.get();
        }

        public void a(int i10, a<T> aVar) {
            if (this.f31137d) {
                return;
            }
            if (i10 != -1) {
                this.f31135b.a(i10);
            }
            this.f31136c = true;
            aVar.i(this.f31134a);
        }

        public void b(Supplier<E> supplier, b<T, E> bVar) {
            if (this.f31137d || !this.f31136c) {
                return;
            }
            E e10 = this.f31135b;
            this.f31135b = supplier.get();
            this.f31136c = false;
            bVar.a(this.f31134a, e10);
        }

        public void c(b<T, E> bVar) {
            this.f31137d = true;
            if (this.f31136c) {
                bVar.a(this.f31134a, this.f31135b);
            }
        }

        public boolean equals(@g.p0 Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            return this.f31134a.equals(((c) obj).f31134a);
        }

        public int hashCode() {
            return this.f31134a.hashCode();
        }
    }

    public s(Looper looper, hd.c cVar, Supplier<E> supplier, b<T, E> bVar) {
        this(new CopyOnWriteArraySet(), looper, cVar, supplier, bVar);
    }

    public static /* synthetic */ void g(CopyOnWriteArraySet copyOnWriteArraySet, int i10, a aVar) {
        Iterator it2 = copyOnWriteArraySet.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).a(i10, aVar);
        }
    }

    public void c(T t10) {
        if (this.f31133h) {
            return;
        }
        hd.a.g(t10);
        this.f31130e.add(new c<>(t10, this.f31128c));
    }

    @g.j
    public s<T, E> d(Looper looper, b<T, E> bVar) {
        return new s<>(this.f31130e, looper, this.f31126a, this.f31128c, bVar);
    }

    public void e() {
        if (this.f31132g.isEmpty()) {
            return;
        }
        if (!this.f31127b.e(0)) {
            this.f31127b.d(0).sendToTarget();
        }
        boolean z10 = !this.f31131f.isEmpty();
        this.f31131f.addAll(this.f31132g);
        this.f31132g.clear();
        if (z10) {
            return;
        }
        while (!this.f31131f.isEmpty()) {
            this.f31131f.peekFirst().run();
            this.f31131f.removeFirst();
        }
    }

    public final boolean f(Message message) {
        int i10 = message.what;
        if (i10 == 0) {
            Iterator<c<T, E>> it2 = this.f31130e.iterator();
            while (it2.hasNext()) {
                it2.next().b(this.f31128c, this.f31129d);
                if (this.f31127b.e(0)) {
                    break;
                }
            }
        } else if (i10 == 1) {
            l(message.arg1, (a) message.obj);
            j();
        }
        return true;
    }

    public void h(int i10, a<T> aVar) {
        this.f31127b.h(1, i10, 0, aVar).sendToTarget();
    }

    public void i(final int i10, final a<T> aVar) {
        final CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(this.f31130e);
        this.f31132g.add(new Runnable() { // from class: hd.r
            @Override // java.lang.Runnable
            public final void run() {
                s.g(copyOnWriteArraySet, i10, aVar);
            }
        });
    }

    public void j() {
        Iterator<c<T, E>> it2 = this.f31130e.iterator();
        while (it2.hasNext()) {
            it2.next().c(this.f31129d);
        }
        this.f31130e.clear();
        this.f31133h = true;
    }

    public void k(T t10) {
        for (c<T, E> cVar : this.f31130e) {
            if (cVar.f31134a.equals(t10)) {
                cVar.c(this.f31129d);
                this.f31130e.remove(cVar);
            }
        }
    }

    public void l(int i10, a<T> aVar) {
        i(i10, aVar);
        e();
    }

    public s(CopyOnWriteArraySet<c<T, E>> copyOnWriteArraySet, Looper looper, hd.c cVar, Supplier<E> supplier, b<T, E> bVar) {
        this.f31126a = cVar;
        this.f31130e = copyOnWriteArraySet;
        this.f31128c = supplier;
        this.f31129d = bVar;
        this.f31131f = new ArrayDeque<>();
        this.f31132g = new ArrayDeque<>();
        this.f31127b = cVar.c(looper, new Handler.Callback() { // from class: hd.q
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f31120a.f(message);
            }
        });
    }
}
