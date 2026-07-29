package ul;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.d0;
import kotlin.jvm.internal.c0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.v0;
import yt.k;
import zc.f;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0003\u001a*\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0080\bø\u0001\u0000\u001a7\u0010\u000b\u001a\u00028\u0000\"\u0004\b\u0000\u0010\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0080\bø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a \u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lul/a;", "task", "Lul/c;", "queue", "Lkotlin/Function0;", "", "messageBlock", "Lkotlin/z1;", "e", i1.a.f31577d5, "block", "d", "(Lul/a;Lul/c;Lik/a;)Ljava/lang/Object;", "message", "c", "", "ns", "b", "okhttp"}, k = 2, mv = {1, 6, 0})
public final class b {
    @k
    public static final String b(long j10) {
        String str;
        if (j10 <= -999500000) {
            str = ((j10 - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (j10 <= -999500) {
            str = ((j10 - ((long) 500000)) / ((long) 1000000)) + " ms";
        } else if (j10 <= 0) {
            str = ((j10 - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500) {
            str = ((j10 + ((long) 500)) / ((long) 1000)) + " µs";
        } else if (j10 < 999500000) {
            str = ((j10 + ((long) 500000)) / ((long) 1000000)) + " ms";
        } else {
            str = ((j10 + ((long) 500000000)) / ((long) 1000000000)) + " s ";
        }
        v0 v0Var = v0.f37964a;
        String str2 = String.format("%6s", Arrays.copyOf(new Object[]{str}, 1));
        f0.o(str2, "format(format, *args)");
        return str2;
    }

    public static final void c(a aVar, c cVar, String str) {
        Logger loggerA = d.f52207h.a();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.h());
        sb2.append(f.f58383m);
        v0 v0Var = v0.f37964a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        f0.o(str2, "format(format, *args)");
        sb2.append(str2);
        sb2.append(": ");
        sb2.append(aVar.b());
        loggerA.fine(sb2.toString());
    }

    public static final <T> T d(@k a task, @k c queue, @k ik.a<? extends T> block) {
        long jD;
        f0.p(task, "task");
        f0.p(queue, "queue");
        f0.p(block, "block");
        boolean zIsLoggable = d.f52207h.a().isLoggable(Level.FINE);
        if (zIsLoggable) {
            jD = queue.k().h().d();
            c(task, queue, "starting");
        } else {
            jD = -1;
        }
        try {
            T tO = block.o();
            c0.d(1);
            if (zIsLoggable) {
                c(task, queue, f0.C("finished run in ", b(queue.k().h().d() - jD)));
            }
            c0.c(1);
            return tO;
        } catch (Throwable th2) {
            c0.d(1);
            if (zIsLoggable) {
                c(task, queue, f0.C("failed a run in ", b(queue.k().h().d() - jD)));
            }
            c0.c(1);
            throw th2;
        }
    }

    public static final void e(@k a task, @k c queue, @k ik.a<String> messageBlock) {
        f0.p(task, "task");
        f0.p(queue, "queue");
        f0.p(messageBlock, "messageBlock");
        if (d.f52207h.a().isLoggable(Level.FINE)) {
            c(task, queue, messageBlock.o());
        }
    }
}
