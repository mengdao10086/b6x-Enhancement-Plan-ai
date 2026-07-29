package kotlin.jvm.internal;

import kotlin.reflect.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyReference1 extends PropertyReference implements kotlin.reflect.p {
    public PropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c R0() {
        return n0.u(this);
    }

    @Override // ik.l
    public Object i(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.p
    @kotlin.v0(version = "1.1")
    public Object t(Object obj) {
        return ((kotlin.reflect.p) U0()).t(obj);
    }

    @kotlin.v0(version = "1.1")
    public PropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public p.a a() {
        return ((kotlin.reflect.p) U0()).a();
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
