package kotlinx.coroutines.selects;

import ik.q;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class OnTimeout$selectClause$1 extends FunctionReferenceImpl implements q<OnTimeout, j<?>, Object, z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final OnTimeout$selectClause$1 f38995c = new OnTimeout$selectClause$1();

    public OnTimeout$selectClause$1() {
        super(3, OnTimeout.class, "register", "register(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ z1 A(OnTimeout onTimeout, j<?> jVar, Object obj) {
        X0(onTimeout, jVar, obj);
        return z1.f38230a;
    }

    public final void X0(@yt.k OnTimeout onTimeout, @yt.k j<?> jVar, @yt.l Object obj) {
        onTimeout.d(jVar, obj);
    }
}
