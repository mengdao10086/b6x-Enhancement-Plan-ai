package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(kotlin.reflect.h hVar, String str, String str2) {
        super(CallableReference.f37869b, ((r) hVar).h(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @Override // kotlin.reflect.o
    public Object get() {
        return a().O0(new Object[0]);
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference0Impl(Class cls, String str, String str2, int i10) {
        super(CallableReference.f37869b, cls, str, str2, i10);
    }

    @kotlin.v0(version = "1.4")
    public PropertyReference0Impl(Object obj, Class cls, String str, String str2, int i10) {
        super(obj, cls, str, str2, i10);
    }
}
