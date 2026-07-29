package okio;

import java.util.zip.Deflater;

/* JADX INFO: loaded from: classes5.dex */
@hk.h(name = "-DeflaterSinkExtensions")
@kotlin.d0(bv = {}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0001H\u0086\b¨\u0006\u0005"}, d2 = {"Lokio/r0;", "Ljava/util/zip/Deflater;", "deflater", "Lokio/o;", "a", "okio"}, k = 2, mv = {1, 5, 1})
public final class a {
    @yt.k
    public static final o a(@yt.k r0 r0Var, @yt.k Deflater deflater) {
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        kotlin.jvm.internal.f0.p(deflater, "deflater");
        return new o(r0Var, deflater);
    }

    public static /* synthetic */ o b(r0 r0Var, Deflater deflater, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            deflater = new Deflater();
        }
        kotlin.jvm.internal.f0.p(r0Var, "<this>");
        kotlin.jvm.internal.f0.p(deflater, "deflater");
        return new o(r0Var, deflater);
    }
}
