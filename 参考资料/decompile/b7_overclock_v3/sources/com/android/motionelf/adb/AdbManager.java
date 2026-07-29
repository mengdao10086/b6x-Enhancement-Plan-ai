package com.android.motionelf.adb;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import androidx.lifecycle.d0;
import androidx.lifecycle.j0;
import androidx.lifecycle.k0;
import kotlin.jvm.internal.a0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.u;
import kotlin.z1;
import kotlinx.coroutines.d1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.u1;
import moe.shizuku.manager.adb.f;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes2.dex */
@t0({"SMAP\nAdbManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AdbManager.kt\ncom/android/motionelf/adb/AdbManager\n+ 2 Handler.kt\nandroidx/core/os/HandlerKt\n*L\n1#1,221:1\n33#2,12:222\n*S KotlinDebug\n*F\n+ 1 AdbManager.kt\ncom/android/motionelf/adb/AdbManager\n*L\n83#1:222,12\n*E\n"})
@SuppressLint({"NewApi"})
public final class AdbManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public final d0 f11257a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @l
    public f f11258b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @l
    public f f11259c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @g.k(api = 30)
    public final boolean f11260d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @k
    public final j0<Integer> f11261e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @k
    public final j0<Integer> f11262f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @l
    public a f11263g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public final Handler f11264h;

    public interface a {

        /* JADX INFO: renamed from: com.android.motionelf.adb.AdbManager$a$a, reason: collision with other inner class name */
        public static final class C0113a {
            public static /* synthetic */ void a(a aVar, boolean z10, Throwable th2, int i10, Object obj) {
                if (obj != null) {
                    throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPairResult");
                }
                if ((i10 & 2) != 0) {
                    th2 = null;
                }
                aVar.i(z10, th2);
            }
        }

        void g(int i10);

        void i(boolean z10, @l Throwable th2);

        void y();
    }

    public static final class b implements k0, a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.l f11265a;

        public b(ik.l function) {
            f0.p(function, "function");
            this.f11265a = function;
        }

        @Override // kotlin.jvm.internal.a0
        @k
        public final u<?> a() {
            return this.f11265a;
        }

        @Override // androidx.lifecycle.k0
        public final /* synthetic */ void b(Object obj) {
            this.f11265a.i(obj);
        }

        public final boolean equals(@l Object obj) {
            if ((obj instanceof k0) && (obj instanceof a0)) {
                return f0.g(a(), ((a0) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n+ 2 AdbManager.kt\ncom/android/motionelf/adb/AdbManager\n*L\n1#1,69:1\n84#2,3:70\n*E\n"})
    public static final class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            a aVar = AdbManager.this.f11263g;
            if (aVar != null) {
                aVar.y();
            }
            f fVar = AdbManager.this.f11258b;
            if (fVar != null) {
                fVar.m();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AdbManager(@k d0 context) {
        f0.p(context, "context");
        this.f11257a = context;
        boolean z10 = Build.VERSION.SDK_INT >= 30;
        this.f11260d = z10;
        j0<Integer> j0Var = new j0<>();
        this.f11261e = j0Var;
        j0<Integer> j0Var2 = new j0<>();
        this.f11262f = j0Var2;
        this.f11264h = new Handler();
        if (context instanceof a) {
            this.f11263g = (a) context;
        }
        if (z10) {
            j0Var.k(context, new b(new ik.l<Integer, z1>() { // from class: com.android.motionelf.adb.AdbManager.1
                {
                    super(1);
                }

                public final void b(Integer port) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("配对端口：");
                    sb2.append(port);
                    a aVar = AdbManager.this.f11263g;
                    if (aVar != null) {
                        f0.o(port, "port");
                        aVar.g(port.intValue());
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Integer num) {
                    b(num);
                    return z1.f38230a;
                }
            }));
            j0Var2.k(context, new b(new ik.l<Integer, z1>() { // from class: com.android.motionelf.adb.AdbManager.2
                {
                    super(1);
                }

                public final void b(Integer port) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("连接端口：");
                    sb2.append(port);
                    AdbManager.this.f11264h.removeCallbacksAndMessages(null);
                    f0.o(port, "port");
                    int iIntValue = port.intValue();
                    boolean z11 = false;
                    if (1 <= iIntValue && iIntValue < 65536) {
                        z11 = true;
                    }
                    if (z11) {
                        AdbManager.this.f(port.intValue());
                    }
                }

                @Override // ik.l
                public /* bridge */ /* synthetic */ z1 i(Integer num) {
                    b(num);
                    return z1.f38230a;
                }
            }));
        }
    }

    public final void f(int i10) {
        j.f(u1.f39074a, d1.c(), null, new AdbManager$enableNetAdbFromWifiAdb$1(this, i10, null), 2, null);
    }

    @k
    public final d0 g() {
        return this.f11257a;
    }

    public final void h(@k String command) {
        f0.p(command, "command");
        j.f(u1.f39074a, d1.c(), null, new AdbManager$runShellCommand$1(this, command, null), 2, null);
    }

    public final void i() {
        if (o5.b.i(this.f11257a)) {
            f fVar = this.f11258b;
            if (fVar != null) {
                fVar.m();
                return;
            }
            return;
        }
        if (this.f11260d) {
            f fVar2 = new f(this.f11257a, f.f41502i, this.f11262f);
            this.f11258b = fVar2;
            fVar2.l();
            this.f11264h.postDelayed(new c(), 2000L);
        }
    }

    public final void j(@k CharSequence pairCode) {
        f0.p(pairCode, "pairCode");
        if (this.f11261e.f() == null || j.f(u1.f39074a, d1.c(), null, new AdbManager$startAdbPair$1$1(this, pairCode, null), 2, null) == null) {
            m();
            a aVar = this.f11263g;
            if (aVar != null) {
                a.C0113a.a(aVar, false, null, 2, null);
                z1 z1Var = z1.f38230a;
            }
        }
    }

    public final void k() {
        if (o5.b.i(this.f11257a)) {
            f fVar = this.f11259c;
            if (fVar != null) {
                fVar.m();
                return;
            }
            return;
        }
        if (this.f11260d) {
            f fVar2 = new f(this.f11257a, f.f41503j, this.f11261e);
            this.f11259c = fVar2;
            fVar2.l();
        }
    }

    public final void l() {
        if (this.f11260d) {
            f fVar = this.f11258b;
            if (fVar != null) {
                fVar.m();
            }
            this.f11258b = null;
        }
    }

    public final void m() {
        if (this.f11260d) {
            f fVar = this.f11259c;
            if (fVar != null) {
                fVar.m();
            }
            this.f11259c = null;
        }
    }
}
