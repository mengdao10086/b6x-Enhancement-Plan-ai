package com.android.motionelf.adb;

import android.content.SharedPreferences;
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
import moe.shizuku.manager.adb.a;
import moe.shizuku.manager.adb.j;
import yj.b;
import yt.k;
import yt.l;
import zj.d;

/* JADX INFO: loaded from: classes2.dex */
@d(c = "com.android.motionelf.adb.AdbManager$runShellCommand$1", f = "AdbManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AdbManager$runShellCommand$1 extends SuspendLambda implements p<o0, c<? super z1>, Object> {
    public final /* synthetic */ String $command;
    public int label;
    public final /* synthetic */ AdbManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbManager$runShellCommand$1(AdbManager adbManager, String str, c<? super AdbManager$runShellCommand$1> cVar) {
        super(2, cVar);
        this.this$0 = adbManager;
        this.$command = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @k
    public final c<z1> M(@l Object obj, @k c<?> cVar) {
        return new AdbManager$runShellCommand$1(this.this$0, this.$command, cVar);
    }

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
            StringBuilder sb2 = new StringBuilder();
            sb2.append("connect to ");
            sb2.append(InetAddress.getLoopbackAddress().getHostName());
            sb2.append(":5555");
            String hostName = InetAddress.getLoopbackAddress().getHostName();
            f0.o(hostName, "getLoopbackAddress().hostName");
            a aVar = new a(hostName, o5.b.f42732a, adbKey);
            String str = this.$command;
            try {
                Result.a aVar2 = Result.f37633a;
                aVar.a();
                StringBuilder sb3 = new StringBuilder();
                sb3.append("run ");
                sb3.append(str);
                aVar.h(str, new ik.l<byte[], z1>() { // from class: com.android.motionelf.adb.AdbManager$runShellCommand$1$1$1
                    public final void b(@k byte[] it2) {
                        f0.p(it2, "it");
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("shellCommand:");
                        sb4.append(new String(it2, kotlin.text.d.f38161b));
                    }

                    @Override // ik.l
                    public /* bridge */ /* synthetic */ z1 i(byte[] bArr) {
                        b(bArr);
                        return z1.f38230a;
                    }
                });
                aVar.close();
                objB = Result.b(z1.f38230a);
            } catch (Throwable th2) {
                Result.a aVar3 = Result.f37633a;
                objB = Result.b(u0.a(th2));
            }
            Throwable thF = Result.f(objB);
            if (thF != null) {
                thF.printStackTrace();
            }
            return z1.f38230a;
        } catch (Throwable th3) {
            th3.getMessage();
            th3.printStackTrace();
            return z1.f38230a;
        }
    }

    @Override // ik.p
    @l
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public final Object r0(@k o0 o0Var, @l c<? super z1> cVar) {
        return ((AdbManager$runShellCommand$1) M(o0Var, cVar)).q0(z1.f38230a);
    }
}
