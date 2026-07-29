package r4;

import g.n0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<String> f47733a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<a<?, ?>>> f47734b = new HashMap();

    public static class a<T, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<T> f47735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f47736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final c4.f<T, R> f47737c;

        public a(@n0 Class<T> cls, @n0 Class<R> cls2, c4.f<T, R> fVar) {
            this.f47735a = cls;
            this.f47736b = cls2;
            this.f47737c = fVar;
        }

        public boolean a(@n0 Class<?> cls, @n0 Class<?> cls2) {
            return this.f47735a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f47736b);
        }
    }

    public synchronized <T, R> void a(@n0 String str, @n0 c4.f<T, R> fVar, @n0 Class<T> cls, @n0 Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, fVar));
    }

    @n0
    public synchronized <T, R> List<c4.f<T, R>> b(@n0 Class<T> cls, @n0 Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it2 = this.f47733a.iterator();
        while (it2.hasNext()) {
            List<a<?, ?>> list = this.f47734b.get(it2.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f47737c);
                    }
                }
            }
        }
        return arrayList;
    }

    @n0
    public final synchronized List<a<?, ?>> c(@n0 String str) {
        List<a<?, ?>> arrayList;
        if (!this.f47733a.contains(str)) {
            this.f47733a.add(str);
        }
        arrayList = this.f47734b.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f47734b.put(str, arrayList);
        }
        return arrayList;
    }

    @n0
    public synchronized <T, R> List<Class<R>> d(@n0 Class<T> cls, @n0 Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<String> it2 = this.f47733a.iterator();
        while (it2.hasNext()) {
            List<a<?, ?>> list = this.f47734b.get(it2.next());
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f47736b)) {
                        arrayList.add(aVar.f47736b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void e(@n0 String str, @n0 c4.f<T, R> fVar, @n0 Class<T> cls, @n0 Class<R> cls2) {
        c(str).add(0, new a<>(cls, cls2, fVar));
    }

    public synchronized void f(@n0 List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.f47733a);
        this.f47733a.clear();
        Iterator<String> it2 = list.iterator();
        while (it2.hasNext()) {
            this.f47733a.add(it2.next());
        }
        for (String str : arrayList) {
            if (!list.contains(str)) {
                this.f47733a.add(str);
            }
        }
    }
}
