package jn;

import gm.c0;
import gm.d;
import gm.f0;
import gm.w;

/* JADX INFO: loaded from: classes5.dex */
public class b extends w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f36520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f0 f36521b;

    public b(f0 f0Var) {
        this.f36521b = f0Var;
        this.f36520a = a.z(f0Var.K(0));
    }

    public static b x(Object obj) {
        if (obj instanceof b) {
            return (b) obj;
        }
        if (obj != null) {
            return new b(f0.J(obj));
        }
        return null;
    }

    public zn.b A() {
        return zn.b.z(this.f36521b.K(1));
    }

    @Override // gm.w, gm.h
    public c0 b() {
        return this.f36521b;
    }

    public a y() {
        return this.f36520a;
    }

    public d z() {
        return d.K(this.f36521b.K(2));
    }
}
