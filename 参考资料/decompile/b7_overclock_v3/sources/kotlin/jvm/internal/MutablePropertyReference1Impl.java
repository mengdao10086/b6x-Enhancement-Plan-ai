package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    public MutablePropertyReference1Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.f37869b, ((r) hVar).h(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.l
    public void b0(Object obj, Object obj2) {
        c().O0(obj, obj2);
    }

    @Override // kotlin.reflect.p
    public Object get(Object obj) {
        return a().O0(obj);
    }

    @kotlin.v0(version = "1.4")
    public MutablePropertyReference1Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.f37869b, cls, str, str2, i10);
    }

    @kotlin.v0(version = "1.4")
    public MutablePropertyReference1Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
