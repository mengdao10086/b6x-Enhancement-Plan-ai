package com.android.motionelf.adb;

import ik.p;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.z1;
import kotlinx.coroutines.o0;
import yt.k;
import yt.l;
import zj.d;

/* JADX INFO: loaded from: classes2.dex */
@d(c = "com.android.motionelf.adb.AdbManager$enableNetAdbFromWifiAdb$1", f = "AdbManager.kt", i = {}, l = {123, 132}, m = "invokeSuspend", n = {}, s = {})
public final class AdbManager$enableNetAdbFromWifiAdb$1 extends SuspendLambda implements p<o0, c<? super z1>, Object> {
    public final /* synthetic */ int $port;
    public Object L$0;
    public Object L$1;
    public int label;
    public final /* synthetic */ AdbManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbManager$enableNetAdbFromWifiAdb$1(AdbManager adbManager, int i10, c<? super AdbManager$enableNetAdbFromWifiAdb$1> cVar) {
        super(2, cVar);
        this.this$0 = adbManager;
        this.$port = i10;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final c<z1> M(@l Object obj, @k c<?> cVar) {
        return new AdbManager$enableNetAdbFromWifiAdb$1(this.this$0, this.$port, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00fc  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object q0(@yt.k java.lang.Object r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 273
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.motionelf.adb.AdbManager$enableNetAdbFromWifiAdb$1.q0(java.lang.Object):java.lang.Object");
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l c<? super z1> cVar) {
        return ((AdbManager$enableNetAdbFromWifiAdb$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
