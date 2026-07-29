package com.bumptech.glide.load.data;

import com.bumptech.glide.load.data.e;
import g.n0;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final e.a<?> f12189b = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, e.a<?>> f12190a = new HashMap();

    public class a implements e.a<Object> {
        @Override // com.bumptech.glide.load.data.e.a
        @n0
        public Class<Object> a() {
            throw new UnsupportedOperationException("Not implemented");
        }

        @Override // com.bumptech.glide.load.data.e.a
        @n0
        public e<Object> b(@n0 Object obj) {
            return new b(obj);
        }
    }

    public static final class b implements e<Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f12191a;

        public b(@n0 Object obj) {
            this.f12191a = obj;
        }

        @Override // com.bumptech.glide.load.data.e
        @n0
        public Object a() {
            return this.f12191a;
        }

        @Override // com.bumptech.glide.load.data.e
        public void b() {
        }
    }

    @n0
    public synchronized <T> e<T> a(@n0 T t10) {
        e.a<?> aVar;
        v4.m.d(t10);
        aVar = this.f12190a.get(t10.getClass());
        if (aVar == null) {
            Iterator<e.a<?>> it2 = this.f12190a.values().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                e.a<?> next = it2.next();
                if (next.a().isAssignableFrom(t10.getClass())) {
                    aVar = next;
                    break;
                }
            }
        }
        if (aVar == null) {
            aVar = f12189b;
        }
        return (e<T>) aVar.b(t10);
    }

    public synchronized void b(@n0 e.a<?> aVar) {
        this.f12190a.put(aVar.a(), aVar);
    }
}
