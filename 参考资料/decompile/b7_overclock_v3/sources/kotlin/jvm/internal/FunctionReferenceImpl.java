package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes5.dex */
public class FunctionReferenceImpl extends FunctionReference {
    public FunctionReferenceImpl(int i10, kotlin.reflect.h hVar, String str, String str2) {
        super(i10, CallableReference.f37869b, ((r) hVar).h(), str, str2, !(hVar instanceof kotlin.reflect.d) ? 1 : 0);
    }

    @kotlin.v0(version = "1.4")
    public FunctionReferenceImpl(int i10, Class cls, String str, String str2, int i11) {
        super(i10, CallableReference.f37869b, cls, str, str2, i11);
    }

    @kotlin.v0(version = "1.4")
    public FunctionReferenceImpl(int i10, Object obj, Class cls, String str, String str2, int i11) {
        super(i10, obj, cls, str, str2, i11);
    }
}
