package um;

import gm.c0;
import gm.d2;

/* JADX INFO: loaded from: classes5.dex */
public class w extends gm.w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public v f52278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f52279b = true;

    public w() {
    }

    public w(v vVar) {
        this.f52278a = vVar;
    }

    public static w x(Object obj) {
        if (obj instanceof w) {
            return (w) obj;
        }
        if ((obj instanceof gm.u) || gm.w.w(obj, 5)) {
            return new w();
        }
        if (obj != null) {
            return new w(v.x(obj));
        }
        return null;
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f52279b ? d2.f29657b : this.f52278a.b();
    }

    public v y() {
        return this.f52278a;
    }

    public boolean z() {
        return this.f52279b;
    }
}
