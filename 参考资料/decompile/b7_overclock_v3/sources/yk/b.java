package yk;

import android.annotation.SuppressLint;
import hk.m;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;
import java.security.ProtectionDomain;
import kotlin.Result;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import sun.misc.Signal;
import sun.misc.SignalHandler;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@SuppressLint({"all"})
@IgnoreJRERequirement
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @k
    public static final b f57359a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f57360b;

    public static final class a implements ClassFileTransformer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @k
        public static final a f57361a = new a();

        @l
        public byte[] a(@l ClassLoader classLoader, @k String str, @l Class<?> cls, @k ProtectionDomain protectionDomain, @l byte[] bArr) {
            if (classLoader == null || !f0.g(str, "kotlin/coroutines/jvm/internal/DebugProbesKt")) {
                return null;
            }
            kotlinx.coroutines.debug.internal.a.f38439a.b(true);
            return kotlin.io.a.p(classLoader.getResourceAsStream("DebugProbesKt.bin"));
        }
    }

    static {
        Object objB;
        try {
            Result.a aVar = Result.f37633a;
            String property = System.getProperty("kotlinx.coroutines.debug.enable.creation.stack.trace");
            objB = Result.b(property != null ? Boolean.valueOf(Boolean.parseBoolean(property)) : null);
        } catch (Throwable th2) {
            Result.a aVar2 = Result.f37633a;
            objB = Result.b(u0.a(th2));
        }
        Boolean bool = (Boolean) (Result.l(objB) ? null : objB);
        f57360b = bool != null ? bool.booleanValue() : DebugProbesImpl.f38422a.u();
    }

    public static final void c(Signal signal) {
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f38422a;
        if (debugProbesImpl.z()) {
            debugProbesImpl.f(System.out);
        } else {
            System.out.println((Object) "Cannot perform coroutines dump, debug probes are disabled");
        }
    }

    @m
    public static final void d(@l String str, @k Instrumentation instrumentation) {
        kotlinx.coroutines.debug.internal.a.f38439a.b(true);
        instrumentation.addTransformer(a.f57361a);
        DebugProbesImpl debugProbesImpl = DebugProbesImpl.f38422a;
        debugProbesImpl.K(f57360b);
        debugProbesImpl.x();
        f57359a.b();
    }

    public final void b() {
        try {
            Signal.handle(new Signal("TRAP"), new SignalHandler() { // from class: yk.a
                public final void a(Signal signal) {
                    b.c(signal);
                }
            });
        } catch (Throwable unused) {
        }
    }
}
