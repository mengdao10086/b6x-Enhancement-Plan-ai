package h4;

import androidx.core.util.n;
import com.bumptech.glide.Registry;
import g.i1;
import g.n0;
import g.p0;
import h4.n;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public class r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final c f30502e = new c();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final n<Object, Object> f30503f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b<?, ?>> f30504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f30505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<b<?, ?>> f30506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n.a<List<Throwable>> f30507d;

    public static class a implements n<Object, Object> {
        @Override // h4.n
        @p0
        public n.a<Object> a(@n0 Object obj, int i10, int i11, @n0 c4.e eVar) {
            return null;
        }

        @Override // h4.n
        public boolean b(@n0 Object obj) {
            return false;
        }
    }

    public static class b<Model, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<Model> f30508a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<Data> f30509b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final o<? extends Model, ? extends Data> f30510c;

        public b(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
            this.f30508a = cls;
            this.f30509b = cls2;
            this.f30510c = oVar;
        }

        public boolean a(@n0 Class<?> cls) {
            return this.f30508a.isAssignableFrom(cls);
        }

        public boolean b(@n0 Class<?> cls, @n0 Class<?> cls2) {
            return a(cls) && this.f30509b.isAssignableFrom(cls2);
        }
    }

    public static class c {
        @n0
        public <Model, Data> q<Model, Data> a(@n0 List<n<Model, Data>> list, @n0 n.a<List<Throwable>> aVar) {
            return new q<>(list, aVar);
        }
    }

    public r(@n0 n.a<List<Throwable>> aVar) {
        this(aVar, f30502e);
    }

    @n0
    public static <Model, Data> n<Model, Data> f() {
        return (n<Model, Data>) f30503f;
    }

    public final <Model, Data> void a(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar, boolean z10) {
        b<?, ?> bVar = new b<>(cls, cls2, oVar);
        List<b<?, ?>> list = this.f30504a;
        list.add(z10 ? list.size() : 0, bVar);
    }

    public synchronized <Model, Data> void b(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, true);
    }

    @n0
    public final <Model, Data> n<Model, Data> c(@n0 b<?, ?> bVar) {
        return (n) v4.m.d(bVar.f30510c.c(this));
    }

    @n0
    public synchronized <Model, Data> n<Model, Data> d(@n0 Class<Model> cls, @n0 Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z10 = false;
            for (b<?, ?> bVar : this.f30504a) {
                if (this.f30506c.contains(bVar)) {
                    z10 = true;
                } else if (bVar.b(cls, cls2)) {
                    this.f30506c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f30506c.remove(bVar);
                }
            }
            if (arrayList.size() > 1) {
                return this.f30505b.a(arrayList, this.f30507d);
            }
            if (arrayList.size() == 1) {
                return (n) arrayList.get(0);
            }
            if (!z10) {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
            return f();
        } catch (Throwable th2) {
            this.f30506c.clear();
            throw th2;
        }
    }

    @n0
    public synchronized <Model> List<n<Model, ?>> e(@n0 Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (b<?, ?> bVar : this.f30504a) {
                if (!this.f30506c.contains(bVar) && bVar.a(cls)) {
                    this.f30506c.add(bVar);
                    arrayList.add(c(bVar));
                    this.f30506c.remove(bVar);
                }
            }
        } catch (Throwable th2) {
            this.f30506c.clear();
            throw th2;
        }
        return arrayList;
    }

    @n0
    public synchronized List<Class<?>> g(@n0 Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (b<?, ?> bVar : this.f30504a) {
            if (!arrayList.contains(bVar.f30509b) && bVar.a(cls)) {
                arrayList.add(bVar.f30509b);
            }
        }
        return arrayList;
    }

    @n0
    public final <Model, Data> o<Model, Data> h(@n0 b<?, ?> bVar) {
        return (o<Model, Data>) bVar.f30510c;
    }

    public synchronized <Model, Data> void i(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        a(cls, cls2, oVar, false);
    }

    @n0
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> j(@n0 Class<Model> cls, @n0 Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<b<?, ?>> it2 = this.f30504a.iterator();
        while (it2.hasNext()) {
            b<?, ?> next = it2.next();
            if (next.b(cls, cls2)) {
                it2.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    @n0
    public synchronized <Model, Data> List<o<? extends Model, ? extends Data>> k(@n0 Class<Model> cls, @n0 Class<Data> cls2, @n0 o<? extends Model, ? extends Data> oVar) {
        List<o<? extends Model, ? extends Data>> listJ;
        listJ = j(cls, cls2);
        b(cls, cls2, oVar);
        return listJ;
    }

    @i1
    public r(@n0 n.a<List<Throwable>> aVar, @n0 c cVar) {
        this.f30504a = new ArrayList();
        this.f30506c = new HashSet();
        this.f30507d = aVar;
        this.f30505b = cVar;
    }
}
