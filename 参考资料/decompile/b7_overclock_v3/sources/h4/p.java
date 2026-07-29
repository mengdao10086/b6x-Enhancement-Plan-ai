package h4;

import androidx.core.util.n;
import com.bumptech.glide.Registry;
import g.n0;
import g.p0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f30489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f30490b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, C0364a<?>> f30491a = new HashMap();

        /* JADX INFO: renamed from: h4.p$a$a, reason: collision with other inner class name */
        public static class C0364a<Model> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final List<n<Model, ?>> f30492a;

            public C0364a(List<n<Model, ?>> list) {
                this.f30492a = list;
            }
        }

        public void a() {
            this.f30491a.clear();
        }

        @p0
        public <Model> List<n<Model, ?>> b(Class<Model> cls) {
            C0364a<?> c0364a = this.f30491a.get(cls);
            if (c0364a == null) {
                return null;
            }
            return (List<n<Model, ?>>) c0364a.f30492a;
        }

        public <Model> void c(Class<Model> cls, List<n<Model, ?>> list) {
            if (this.f30491a.put(cls, new C0364a<>(list)) == null) {
                return;
            }
            throw new IllegalStateException("Already cached loaders for model: " + cls);
        }
    }

    public p(@n0 n.a<List<Throwable>> aVar) {
        this(new r(aVar));
    }

    @n0
    public static <A> Class<A> c(@n0 A a10) {
        return (Class<A>) a10.getClass();
    }

    public synchronized <Model, Data> void a(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        this.f30489a.b(cls, cls2, oVar);
        this.f30490b.a();
    }

    public synchronized <Model, Data> n<Model, Data> b(@n0 Class<Model> cls, @n0 Class<Data> cls2) {
        return this.f30489a.d(cls, cls2);
    }

    @n0
    public synchronized List<Class<?>> d(@n0 Class<?> cls) {
        return this.f30489a.g(cls);
    }

    @n0
    public <A> List<n<A, ?>> e(@n0 A a10) {
        List<n<A, ?>> listF = f(c(a10));
        if (listF.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a10);
        }
        int size = listF.size();
        List<n<A, ?>> listEmptyList = Collections.emptyList();
        boolean z10 = true;
        for (int i10 = 0; i10 < size; i10++) {
            n<A, ?> nVar = listF.get(i10);
            if (nVar.b(a10)) {
                if (z10) {
                    listEmptyList = new ArrayList<>(size - i10);
                    z10 = false;
                }
                listEmptyList.add(nVar);
            }
        }
        if (listEmptyList.isEmpty()) {
            throw new Registry.NoModelLoaderAvailableException(a10, listF);
        }
        return listEmptyList;
    }

    @n0
    public final synchronized <A> List<n<A, ?>> f(@n0 Class<A> cls) {
        List<n<A, ?>> listB;
        listB = this.f30490b.b(cls);
        if (listB == null) {
            listB = Collections.unmodifiableList(this.f30489a.e(cls));
            this.f30490b.c(cls, listB);
        }
        return listB;
    }

    public synchronized <Model, Data> void g(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        this.f30489a.i(cls, cls2, oVar);
        this.f30490b.a();
    }

    public synchronized <Model, Data> void h(@n0 Class<Model> cls, @n0 Class<Data> cls2) {
        j(this.f30489a.j(cls, cls2));
        this.f30490b.a();
    }

    public synchronized <Model, Data> void i(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        j(this.f30489a.k(cls, cls2, oVar));
        this.f30490b.a();
    }

    public final <Model, Data> void j(@n0 List<o<? extends Model, ? extends Data>> list) {
        Iterator<o<? extends Model, ? extends Data>> it2 = list.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public p(@n0 r rVar) {
        this.f30490b = new a();
        this.f30489a = rVar;
    }
}
