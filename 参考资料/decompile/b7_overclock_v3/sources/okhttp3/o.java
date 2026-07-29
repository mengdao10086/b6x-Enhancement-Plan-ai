package okhttp3;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\"\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Lokhttp3/o;", "", "", "username", "password", "Ljava/nio/charset/Charset;", "charset", "b", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final o f43927a = new o();

    @hk.i
    @hk.m
    @yt.k
    public static final String a(@yt.k String username, @yt.k String password) {
        kotlin.jvm.internal.f0.p(username, "username");
        kotlin.jvm.internal.f0.p(password, "password");
        return c(username, password, null, 4, null);
    }

    @hk.i
    @hk.m
    @yt.k
    public static final String b(@yt.k String username, @yt.k String password, @yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(username, "username");
        kotlin.jvm.internal.f0.p(password, "password");
        kotlin.jvm.internal.f0.p(charset, "charset");
        return kotlin.jvm.internal.f0.C("Basic ", ByteString.f44029c.j(username + ':' + password, charset).h());
    }

    public static /* synthetic */ String c(String str, String str2, Charset ISO_8859_1, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            ISO_8859_1 = StandardCharsets.ISO_8859_1;
            kotlin.jvm.internal.f0.o(ISO_8859_1, "ISO_8859_1");
        }
        return b(str, str2, ISO_8859_1);
    }
}
