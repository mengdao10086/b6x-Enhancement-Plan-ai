package kotlinx.coroutines.sync;

import ik.q;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.z1;
import kotlinx.coroutines.selects.j;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
public /* synthetic */ class MutexImpl$onLock$1 extends FunctionReferenceImpl implements q<MutexImpl, j<?>, Object, z1> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl$onLock$1 f39047c = new MutexImpl$onLock$1();

    public MutexImpl$onLock$1() {
        super(3, MutexImpl.class, "onLockRegFunction", "onLockRegFunction(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // ik.q
    public /* bridge */ /* synthetic */ z1 A(MutexImpl mutexImpl, j<?> jVar, Object obj) {
        X0(mutexImpl, jVar, obj);
        return z1.f38230a;
    }

    public final void X0(@k MutexImpl mutexImpl, @k j<?> jVar, @l Object obj) {
        mutexImpl.B(jVar, obj);
    }
}
