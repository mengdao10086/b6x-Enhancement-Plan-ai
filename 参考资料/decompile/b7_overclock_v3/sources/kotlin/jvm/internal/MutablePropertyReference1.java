package kotlin.jvm.internal;

import kotlin.reflect.l;
import kotlin.reflect.p;

/* JADX INFO: loaded from: classes5.dex */
public abstract class MutablePropertyReference1 extends MutablePropertyReference implements kotlin.reflect.l {
    public MutablePropertyReference1() {
    }

    @Override // kotlin.jvm.internal.CallableReference
    public kotlin.reflect.c R0() {
        return n0.k(this);
    }

    @Override // ik.l
    public Object i(Object obj) {
        return get(obj);
    }

    @Override // kotlin.reflect.p
    @kotlin.v0(version = "1.1")
    public Object t(Object obj) {
        return ((kotlin.reflect.l) U0()).t(obj);
    }

    @kotlin.v0(version = "1.1")
    public MutablePropertyReference1(Object obj) {
        super(obj);
    }

    @Override // kotlin.reflect.n
    public p.a a() {
        return ((kotlin.reflect.l) U0()).a();
    }

    @Override // kotlin.reflect.j
    public l.a c() {
        return ((kotlin.reflect.l) U0()).c();
    }

    @kotlin.v0(version = "1.4")
    public MutablePropertyReference1(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
