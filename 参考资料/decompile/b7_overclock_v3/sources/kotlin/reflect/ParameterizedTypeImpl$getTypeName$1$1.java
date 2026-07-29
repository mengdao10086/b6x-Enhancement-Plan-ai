package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.f0;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class ParameterizedTypeImpl$getTypeName$1$1 extends FunctionReferenceImpl implements ik.l<Type, String> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ParameterizedTypeImpl$getTypeName$1$1 f38016c = new ParameterizedTypeImpl$getTypeName$1$1();

    public ParameterizedTypeImpl$getTypeName$1$1() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @Override // ik.l
    @yt.k
    /* JADX INFO: renamed from: X0, reason: merged with bridge method [inline-methods] */
    public final String i(@yt.k Type p02) {
        f0.p(p02, "p0");
        return TypesJVMKt.j(p02);
    }
}
