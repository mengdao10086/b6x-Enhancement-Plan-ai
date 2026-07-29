package o4;

import g.n0;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a<?, ?>> f42712a = new ArrayList();

    public static final class a<Z, R> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<Z> f42713a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Class<R> f42714b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e<Z, R> f42715c;

        public a(@n0 Class<Z> cls, @n0 Class<R> cls2, @n0 e<Z, R> eVar) {
            this.f42713a = cls;
            this.f42714b = cls2;
            this.f42715c = eVar;
        }

        public boolean a(@n0 Class<?> cls, @n0 Class<?> cls2) {
            return this.f42713a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.f42714b);
        }
    }

    @n0
    public synchronized <Z, R> e<Z, R> a(@n0 Class<Z> cls, @n0 Class<R> cls2) {
        if (cls2.isAssignableFrom(cls)) {
            return g.b();
        }
        for (a<?, ?> aVar : this.f42712a) {
            if (aVar.a(cls, cls2)) {
                return (e<Z, R>) aVar.f42715c;
            }
        }
        throw new IllegalArgumentException("No transcoder registered to transcode from " + cls + " to " + cls2);
    }

    @n0
    public synchronized <Z, R> List<Class<R>> b(@n0 Class<Z> cls, @n0 Class<R> cls2) {
        ArrayList arrayList = new ArrayList();
        if (cls2.isAssignableFrom(cls)) {
            arrayList.add(cls2);
            return arrayList;
        }
        for (a<?, ?> aVar : this.f42712a) {
            if (aVar.a(cls, cls2) && !arrayList.contains(aVar.f42714b)) {
                arrayList.add(aVar.f42714b);
            }
        }
        return arrayList;
    }

    public synchronized <Z, R> void c(@n0 Class<Z> cls, @n0 Class<R> cls2, @n0 e<Z, R> eVar) {
        this.f42712a.add(new a<>(cls, cls2, eVar));
    }
}
