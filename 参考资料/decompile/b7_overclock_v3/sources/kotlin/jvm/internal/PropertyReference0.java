package kotlin.jvm.internal;

import kotlin.reflect.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyReference0 extends PropertyReference implements kotlin.reflect.o {
    public PropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c R0() {
        return n0.t(this);
    }

    @Override // kotlin.reflect.o
    @kotlin.v0(version = "1.1")
    public Object l() {
        return ((kotlin.reflect.o) U0()).l();
    }

    @Override // ik.a
    public Object o() {
        return get();
    }

    @kotlin.v0(version = "1.1")
    public PropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public o.a a() {
        return ((kotlin.reflect.o) U0()).a();
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
