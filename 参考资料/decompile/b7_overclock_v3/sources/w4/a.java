package w4;

import android.util.Log;
import androidx.core.util.n;
import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f53896a = "FactoryPools";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f53897b = 20;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g<Object> f53898c = new C0632a();

    /* JADX INFO: renamed from: w4.a$a, reason: collision with other inner class name */
    public class C0632a implements g<Object> {
        @Override // w4.a.g
        public void a(@n0 Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements d<List<T>> {
        @Override // w4.a.d
        @n0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<T> create() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> implements g<List<T>> {
        @Override // w4.a.g
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@n0 List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T create();
    }

    public static final class e<T> implements n.a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<T> f53899a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g<T> f53900b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n.a<T> f53901c;

        public e(@n0 n.a<T> aVar, @n0 d<T> dVar, @n0 g<T> gVar) {
            this.f53901c = aVar;
            this.f53899a = dVar;
            this.f53900b = gVar;
        }

        @Override // androidx.core.util.n.a
        public T a() {
            T tA = this.f53901c.a();
            if (tA == null) {
                tA = this.f53899a.create();
                if (Log.isLoggable(a.f53896a, 2)) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Created new ");
                    sb2.append(tA.getClass());
                }
            }
            if (tA instanceof f) {
                ((f) tA).f().b(false);
            }
            return tA;
        }

        @Override // androidx.core.util.n.a
        public boolean b(@n0 T t10) {
            if (t10 instanceof f) {
                ((f) t10).f().b(true);
            }
            this.f53900b.a(t10);
            return this.f53901c.b(t10);
        }
    }

    public interface f {
        @n0
        w4.c f();
    }

    public interface g<T> {
        void a(@n0 T t10);
    }

    @n0
    public static <T extends f> n.a<T> a(@n0 n.a<T> aVar, @n0 d<T> dVar) {
        return b(aVar, dVar, c());
    }

    @n0
    public static <T> n.a<T> b(@n0 n.a<T> aVar, @n0 d<T> dVar, @n0 g<T> gVar) {
        return new e(aVar, dVar, gVar);
    }

    @n0
    public static <T> g<T> c() {
        return (g<T>) f53898c;
    }

    @n0
    public static <T extends f> n.a<T> d(int i10, @n0 d<T> dVar) {
        return a(new n.b(i10), dVar);
    }

    @n0
    public static <T extends f> n.a<T> e(int i10, @n0 d<T> dVar) {
        return a(new n.c(i10), dVar);
    }

    @n0
    public static <T> n.a<List<T>> f() {
        return g(20);
    }

    @n0
    public static <T> n.a<List<T>> g(int i10) {
        return b(new n.c(i10), new b(), new c());
    }
}
