package com.android.motionelf.adb;

import android.content.SharedPreferences;
import com.android.motionelf.adb.AdbManager;
import ik.p;
import java.net.InetAddress;
import kotlin.Result;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;
import kotlinx.coroutines.o0;
import moe.shizuku.manager.adb.AdbKey;
import moe.shizuku.manager.adb.AdbPairingClient;
import moe.shizuku.manager.adb.j;
import yj.b;
import yt.k;
import yt.l;
import zj.a;
import zj.d;

/* JADX INFO: loaded from: classes2.dex */
@d(c = "com.android.motionelf.adb.AdbManager$startAdbPair$1$1", f = "AdbManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AdbManager$startAdbPair$1$1 extends SuspendLambda implements p<o0, c<? super z1>, Object> {
    public final /* synthetic */ CharSequence $pairCode;
    public int label;
    public final /* synthetic */ AdbManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbManager$startAdbPair$1$1(AdbManager adbManager, CharSequence charSequence, c<? super AdbManager$startAdbPair$1$1> cVar) {
        super(2, cVar);
        this.this$0 = adbManager;
        this.$pairCode = charSequence;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final c<z1> M(@l Object obj, @k c<?> cVar) {
        return new AdbManager$startAdbPair$1$1(this.this$0, this.$pairCode, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @l
    public final Object q0(@k Object obj) throws Throwable {
        Object objB;
        b.h();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        u0.n(obj);
        try {
            SharedPreferences sharedPreferences = this.this$0.g().getSharedPreferences(this.this$0.g().getPackageName(), 0);
            f0.o(sharedPreferences, "context.getSharedPrefere…me, Context.MODE_PRIVATE)");
            AdbKey adbKey = new AdbKey(new j(sharedPreferences), "flydigi_lab");
            String hostName = InetAddress.getLoopbackAddress().getHostName();
            f0.o(hostName, "getLoopbackAddress().hostName");
            T tF = this.this$0.f11261e.f();
            f0.m(tF);
            AdbPairingClient adbPairingClient = new AdbPairingClient(hostName, ((Number) tF).intValue(), this.$pairCode.toString(), adbKey);
            try {
                Result.a aVar = Result.f37633a;
                objB = Result.b(a.a(adbPairingClient.i()));
            } catch (Throwable th2) {
                Result.a aVar2 = Result.f37633a;
                objB = Result.b(u0.a(th2));
            }
            AdbManager adbManager = this.this$0;
            Throwable thF = Result.f(objB);
            if (thF != null) {
                thF.printStackTrace();
                thF.getMessage();
                AdbManager.a aVar3 = adbManager.f11263g;
                if (aVar3 != null) {
                    aVar3.i(false, thF);
                }
            }
            AdbManager adbManager2 = this.this$0;
            if (Result.m(objB)) {
                ((Boolean) objB).booleanValue();
                adbManager2.m();
                AdbManager.a aVar4 = adbManager2.f11263g;
                if (aVar4 != null) {
                    AdbManager.a.C0113a.a(aVar4, true, null, 2, null);
                }
            }
            return z1.f38230a;
        } catch (Throwable th3) {
            th3.printStackTrace();
            return z1.f38230a;
        }
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l c<? super z1> cVar) {
        return ((AdbManager$startAdbPair$1$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
