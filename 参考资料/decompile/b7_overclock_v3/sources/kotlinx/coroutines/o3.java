package kotlinx.coroutines;

import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;

/* JADX INFO: loaded from: classes5.dex */
public final class o3 {
    @yt.l
    public static final Object a(@yt.k kotlin.coroutines.c<? super kotlin.z1> cVar) {
        Object objH;
        CoroutineContext coroutineContextB = cVar.b();
        f2.z(coroutineContextB);
        kotlin.coroutines.c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(cVar);
        kotlinx.coroutines.internal.k kVar = cVarD instanceof kotlinx.coroutines.internal.k ? (kotlinx.coroutines.internal.k) cVarD : null;
        if (kVar == null) {
            objH = kotlin.z1.f38230a;
        } else {
            if (kVar.f38804d.j2(coroutineContextB)) {
                kVar.m(coroutineContextB, kotlin.z1.f38230a);
            } else {
                n3 n3Var = new n3();
                CoroutineContext coroutineContextL = coroutineContextB.L(n3Var);
                kotlin.z1 z1Var = kotlin.z1.f38230a;
                kVar.m(coroutineContextL, z1Var);
                objH = (!n3Var.f38913b || kotlinx.coroutines.internal.l.f(kVar)) ? yj.b.h() : z1Var;
            }
            objH = yj.b.h();
        }
        if (objH == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objH == yj.b.h() ? objH : kotlin.z1.f38230a;
    }
}
