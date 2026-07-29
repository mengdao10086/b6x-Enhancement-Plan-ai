package kotlin.reflect;

import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class TypesJVMKt$typeToString$unwrap$1 extends FunctionReferenceImpl implements ik.l<Class<?>, Class<?>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypesJVMKt$typeToString$unwrap$1 f38018c = new TypesJVMKt$typeToString$unwrap$1();

    public TypesJVMKt$typeToString$unwrap$1() {
        super(1, Class.class, "getComponentType", "getComponentType()Ljava/lang/Class;", 0);
    }

    @Override // ik.l
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final Class<?> i(@yt.k Class<?> p02) {
        f0.p(p02, "p0");
        return p02.getComponentType();
    }
}
