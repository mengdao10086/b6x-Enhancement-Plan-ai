package kotlin.jvm.internal;

import kotlin.reflect.k;
import kotlin.reflect.o;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MutablePropertyReference0 extends MutablePropertyReference implements kotlin.reflect.k {
    public MutablePropertyReference0() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c R0() {
        return n0.j(this);
    }

    @Override // kotlin.reflect.o
    @kotlin.v0(version = "1.1")
    public Object l() {
        return ((kotlin.reflect.k) U0()).l();
    }

    @Override // ik.a
    public Object o() {
        return get();
    }

    @kotlin.v0(version = "1.1")
    public MutablePropertyReference0(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public o.a a() {
        return ((kotlin.reflect.k) U0()).a();
    }

    @Override // kotlin.reflect.j
    public k.a c() {
        return ((kotlin.reflect.k) U0()).c();
    }

    @kotlin.v0(version = "1.4")
    public MutablePropertyReference0(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
