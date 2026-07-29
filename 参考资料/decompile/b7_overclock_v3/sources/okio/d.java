package okio;

import kotlin.DeprecationLevel;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.k(message = "changed in Okio 2.x")
@kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lokio/d;", "", "", w.b.f53669e, "", "a", "", "beginIndex", "endIndex", "b", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final d f44048a = new d();

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long a(@yt.k String string) {
        kotlin.jvm.internal.f0.p(string, "string");
        return w0.l(string, 0, 0, 3, null);
    }

    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long b(@yt.k String string, int i10, int i11) {
        kotlin.jvm.internal.f0.p(string, "string");
        return w0.k(string, i10, i11);
    }
}
