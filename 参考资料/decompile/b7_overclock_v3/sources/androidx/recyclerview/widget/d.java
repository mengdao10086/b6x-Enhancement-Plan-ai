package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c;
import androidx.recyclerview.widget.i;
import g.n0;
import g.p0;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public class d<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f6861h = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.recyclerview.widget.c<T> f6863b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f6864c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<b<T>> f6865d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public List<T> f6866e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @n0
    public List<T> f6867f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f6868g;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ List f6870b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f6871c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Runnable f6872d;

        /* JADX INFO: renamed from: androidx.recyclerview.widget.d$a$a, reason: collision with other inner class name */
        public class C0063a extends i.b {
            public C0063a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            public boolean areContentsTheSame(int i10, int i11) {
                Object obj = a.this.f6869a.get(i10);
                Object obj2 = a.this.f6870b.get(i11);
                if (obj != null && obj2 != null) {
                    return d.this.f6863b.b().a(obj, obj2);
                }
                if (obj == null && obj2 == null) {
                    return true;
                }
                throw new AssertionError();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            public boolean areItemsTheSame(int i10, int i11) {
                Object obj = a.this.f6869a.get(i10);
                Object obj2 = a.this.f6870b.get(i11);
                return (obj == null || obj2 == null) ? obj == null && obj2 == null : d.this.f6863b.b().b(obj, obj2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.recyclerview.widget.i.b
            @p0
            public Object getChangePayload(int i10, int i11) {
                Object obj = a.this.f6869a.get(i10);
                Object obj2 = a.this.f6870b.get(i11);
                if (obj == null || obj2 == null) {
                    throw new AssertionError();
                }
                return d.this.f6863b.b().c(obj, obj2);
            }

            @Override // androidx.recyclerview.widget.i.b
            public int getNewListSize() {
                return a.this.f6870b.size();
            }

            @Override // androidx.recyclerview.widget.i.b
            public int getOldListSize() {
                return a.this.f6869a.size();
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i.c f6875a;

            public b(i.c cVar) {
                this.f6875a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a aVar = a.this;
                d dVar = d.this;
                if (dVar.f6868g == aVar.f6871c) {
                    dVar.c(aVar.f6870b, this.f6875a, aVar.f6872d);
                }
            }
        }

        public a(List list, List list2, int i10, Runnable runnable) {
            this.f6869a = list;
            this.f6870b = list2;
            this.f6871c = i10;
            this.f6872d = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f6864c.execute(new b(i.a(new C0063a())));
        }
    }

    public interface b<T> {
        void a(@n0 List<T> list, @n0 List<T> list2);
    }

    public static class c implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f6877a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@n0 Runnable runnable) {
            this.f6877a.post(runnable);
        }
    }

    public d(@n0 RecyclerView.g gVar, @n0 i.d<T> dVar) {
        this(new androidx.recyclerview.widget.b(gVar), new c.a(dVar).a());
    }

    public void a(@n0 b<T> bVar) {
        this.f6865d.add(bVar);
    }

    @n0
    public List<T> b() {
        return this.f6867f;
    }

    public void c(@n0 List<T> list, @n0 i.c cVar, @p0 Runnable runnable) {
        List<T> list2 = this.f6867f;
        this.f6866e = list;
        this.f6867f = Collections.unmodifiableList(list);
        cVar.f(this.f6862a);
        d(list2, runnable);
    }

    public final void d(@n0 List<T> list, @p0 Runnable runnable) {
        Iterator<b<T>> it2 = this.f6865d.iterator();
        while (it2.hasNext()) {
            it2.next().a(list, this.f6867f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void e(@n0 b<T> bVar) {
        this.f6865d.remove(bVar);
    }

    public void f(@p0 List<T> list) {
        g(list, null);
    }

    public void g(@p0 List<T> list, @p0 Runnable runnable) {
        int i10 = this.f6868g + 1;
        this.f6868g = i10;
        List<T> list2 = this.f6866e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f6867f;
        if (list == null) {
            int size = list2.size();
            this.f6866e = null;
            this.f6867f = Collections.emptyList();
            this.f6862a.onRemoved(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f6863b.a().execute(new a(list2, list, i10, runnable));
            return;
        }
        this.f6866e = list;
        this.f6867f = Collections.unmodifiableList(list);
        this.f6862a.onInserted(0, list.size());
        d(list3, runnable);
    }

    public d(@n0 t tVar, @n0 androidx.recyclerview.widget.c<T> cVar) {
        this.f6865d = new CopyOnWriteArrayList();
        this.f6867f = Collections.emptyList();
        this.f6862a = tVar;
        this.f6863b = cVar;
        if (cVar.c() != null) {
            this.f6864c = cVar.c();
        } else {
            this.f6864c = f6861h;
        }
    }
}
