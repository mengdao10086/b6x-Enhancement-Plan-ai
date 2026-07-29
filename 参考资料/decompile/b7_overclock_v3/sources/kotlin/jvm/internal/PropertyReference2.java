package kotlin.jvm.internal;

import kotlin.reflect.q;

/* JADX INFO: loaded from: classes5.dex */
public abstract class PropertyReference2 extends PropertyReference implements kotlin.reflect.q {
    public PropertyReference2() {
    }

    @Override // kotlin.reflect.q
    @kotlin.v0(version = "1.1")
    public Object E0(Object obj, Object obj2) {
        return ((kotlin.reflect.q) U0()).E0(obj, obj2);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c R0() {
        return n0.v(this);
    }

    @Override // ik.p
    public Object r0(Object obj, Object obj2) {
        return get(obj, obj2);
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference2(Class cls, String str, String str2, int i10) {
        super(CallableReference.f37869b, cls, str, str2, i10);
    }

    @Override // kotlin.reflect.n
    public q.a a() {
        return ((kotlin.reflect.q) U0()).a();
    }
}
