package androidx.core.os;

import android.os.Handler;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.t0;
import kotlin.z1;

/* JADX INFO: loaded from: classes2.dex */
public final class k {

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postAtTime$runnable$1\n*L\n1#1,69:1\n*E\n"})
    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<z1> f4659a;

        public a(ik.a<z1> aVar) {
            this.f4659a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4659a.o();
        }
    }

    @t0({"SMAP\nHandler.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Handler.kt\nandroidx/core/os/HandlerKt$postDelayed$runnable$1\n*L\n1#1,69:1\n*E\n"})
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ik.a<z1> f4660a;

        public b(ik.a<z1> aVar) {
            this.f4660a = aVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f4660a.o();
        }
    }

    @yt.k
    public static final Runnable a(@yt.k Handler handler, long j10, @yt.l Object obj, @yt.k ik.a<z1> action) {
        f0.p(handler, "<this>");
        f0.p(action, "action");
        a aVar = new a(action);
        handler.postAtTime(aVar, obj, j10);
        return aVar;
    }

    public static /* synthetic */ Runnable b(Handler handler, long j10, Object obj, ik.a action, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        f0.p(handler, "<this>");
        f0.p(action, "action");
        a aVar = new a(action);
        handler.postAtTime(aVar, obj, j10);
        return aVar;
    }

    @yt.k
    public static final Runnable c(@yt.k Handler handler, long j10, @yt.l Object obj, @yt.k ik.a<z1> action) {
        f0.p(handler, "<this>");
        f0.p(action, "action");
        b bVar = new b(action);
        if (obj == null) {
            handler.postDelayed(bVar, j10);
        } else {
            j.d(handler, bVar, obj, j10);
        }
        return bVar;
    }

    public static /* synthetic */ Runnable d(Handler handler, long j10, Object obj, ik.a action, int i10, Object obj2) {
        if ((i10 & 2) != 0) {
            obj = null;
        }
        f0.p(handler, "<this>");
        f0.p(action, "action");
        b bVar = new b(action);
        if (obj == null) {
            handler.postDelayed(bVar, j10);
        } else {
            j.d(handler, bVar, obj, j10);
        }
        return bVar;
    }
}
