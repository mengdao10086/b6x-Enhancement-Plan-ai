package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(((r) hVar).h(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.q
    public Object get(Object obj, Object obj2) {
        return a().O0(obj, obj2);
    }

    @Override // kotlin.reflect.m
    public void y(Object obj, Object obj2, Object obj3) {
        c().O0(obj, obj2, obj3);
    }

    @kotlin.v0(version = "1.4")
    public MutablePropertyReference2Impl(Class cls, String str, String str2, int i10) {
        super(cls, str, str2, i10);
    }
}
