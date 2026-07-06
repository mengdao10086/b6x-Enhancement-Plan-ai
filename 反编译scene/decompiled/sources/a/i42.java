package a;

import java.io.Serializable;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class i42<T> implements z32<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v72<? extends T> f6376a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public volatile Object f1327a;
    public final Object b;

    public i42(v72<? extends T> v72Var, Object obj) {
        f92.d(v72Var, "initializer");
        this.f6376a = v72Var;
        this.f1327a = k42.f6573a;
        this.b = obj == null ? this : obj;
    }

    public /* synthetic */ i42(v72 v72Var, Object obj, int i, b92 b92Var) {
        this(v72Var, (i & 2) != 0 ? null : obj);
    }

    public boolean a() {
        return this.f1327a != k42.f6573a;
    }

    @Override // a.z32
    public T getValue() {
        T tI;
        T t = (T) this.f1327a;
        if (t != k42.f6573a) {
            return t;
        }
        synchronized (this.b) {
            tI = (T) this.f1327a;
            if (tI == k42.f6573a) {
                v72<? extends T> v72Var = this.f6376a;
                f92.b(v72Var);
                tI = v72Var.i();
                this.f1327a = tI;
                this.f6376a = null;
            }
        }
        return tI;
    }

    public String toString() {
        return a() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }
}
