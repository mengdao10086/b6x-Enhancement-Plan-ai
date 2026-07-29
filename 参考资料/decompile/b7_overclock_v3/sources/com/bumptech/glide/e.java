package com.bumptech.glide;

import g.p0;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<?>, b> f12123a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<?>, b> f12124a = new HashMap();

        public a b(b bVar) {
            this.f12124a.put(bVar.getClass(), bVar);
            return this;
        }

        public e c() {
            return new e(this);
        }

        public a d(b bVar, boolean z10) {
            if (z10) {
                b(bVar);
            } else {
                this.f12124a.remove(bVar.getClass());
            }
            return this;
        }
    }

    public interface b {
    }

    public e(a aVar) {
        this.f12123a = Collections.unmodifiableMap(new HashMap(aVar.f12124a));
    }

    @p0
    public <T extends b> T a(Class<T> cls) {
        return (T) this.f12123a.get(cls);
    }

    public boolean b(Class<? extends b> cls) {
        return this.f12123a.containsKey(cls);
    }
}
