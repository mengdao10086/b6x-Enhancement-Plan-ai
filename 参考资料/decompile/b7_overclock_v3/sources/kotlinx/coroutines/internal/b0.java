package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlinx.coroutines.m2;
import kotlinx.coroutines.y1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.jvm.internal.t0({"SMAP\nMainDispatchers.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MainDispatchers.kt\nkotlinx/coroutines/internal/MainDispatchersKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,134:1\n1#2:135\n*E\n"})
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final String f38783a = "kotlinx.coroutines.fast.service.loader";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final boolean f38784b = true;

    public static final c0 a(Throwable th2, String str) throws Throwable {
        if (f38784b) {
            return new c0(th2, str);
        }
        if (th2 != null) {
            throw th2;
        }
        e();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ c0 b(Throwable th2, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            th2 = null;
        }
        if ((i10 & 2) != 0) {
            str = null;
        }
        return a(th2, str);
    }

    public static /* synthetic */ void c() {
    }

    @y1
    public static final boolean d(@yt.k m2 m2Var) {
        return m2Var.m2() instanceof c0;
    }

    @yt.k
    public static final Void e() {
        throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
    }

    @y1
    @yt.k
    public static final m2 f(@yt.k z zVar, @yt.k List<? extends z> list) {
        try {
            return zVar.b(list);
        } catch (Throwable th2) {
            return a(th2, zVar.a());
        }
    }
}
