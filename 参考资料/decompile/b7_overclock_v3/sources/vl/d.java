package vl;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import kotlin.d0;
import okhttp3.b0;
import okhttp3.d0;
import okhttp3.internal.connection.RealConnection;
import okhttp3.t;
import okio.r0;
import okio.t0;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH&J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0010H&J\b\u0010\u0016\u001a\u00020\u0015H&J\b\u0010\u0017\u001a\u00020\bH&R\u0014\u0010\u001b\u001a\u00020\u00188&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001c"}, d2 = {"Lvl/d;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "", "contentLength", "Lokio/r0;", "i", "Lkotlin/z1;", "b", "f", "a", "", "expectContinue", "Lokhttp3/d0$a;", "d", "Lokhttp3/d0;", "response", "g", "Lokio/t0;", "c", "Lokhttp3/t;", "h", CommonNetImpl.CANCEL, "Lokhttp3/internal/connection/RealConnection;", "e", "()Lokhttp3/internal/connection/RealConnection;", xl.e.f55522j, "okhttp"}, k = 1, mv = {1, 6, 0})
public interface d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f53199a = a.f53201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f53200b = 100;

    @d0(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lvl/d$a;", "", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f53201a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f53202b = 100;
    }

    void a() throws IOException;

    void b(@yt.k b0 b0Var) throws IOException;

    @yt.k
    t0 c(@yt.k okhttp3.d0 d0Var) throws IOException;

    void cancel();

    @l
    d0.a d(boolean z10) throws IOException;

    @yt.k
    RealConnection e();

    void f() throws IOException;

    long g(@yt.k okhttp3.d0 d0Var) throws IOException;

    @yt.k
    t h() throws IOException;

    @yt.k
    r0 i(@yt.k b0 b0Var, long j10) throws IOException;
}
