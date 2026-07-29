package okio;

import java.util.zip.Inflater;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "-InflaterSourceExtensions")
@kotlin.d0(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¨\u0006\u0005"}, d2 = {"Lokio/t0;", "Ljava/util/zip/Inflater;", "inflater", "Lokio/a0;", "a", "okio"}, k = 2, mv = {1, 5, 1})
public final class g {
    @yt.k
    public static final a0 a(@yt.k t0 t0Var, @yt.k Inflater inflater) {
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        return new a0(t0Var, inflater);
    }

    public static /* synthetic */ a0 b(t0 t0Var, Inflater inflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            inflater = new Inflater();
        }
        kotlin.jvm.internal.f0.p(t0Var, "<this>");
        kotlin.jvm.internal.f0.p(inflater, "inflater");
        return new a0(t0Var, inflater);
    }
}
