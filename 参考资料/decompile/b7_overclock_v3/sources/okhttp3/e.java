package okhttp3;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.IOException;
import okio.v0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0010\u001a\u00020\u0000H&¨\u0006\u0012"}, d2 = {"Lokhttp3/e;", "", "Lokhttp3/b0;", i1.a.f31577d5, "Lokhttp3/d0;", "X", "Lokhttp3/f;", "responseCallback", "Lkotlin/z1;", "b0", CommonNetImpl.CANCEL, "", "Z", i1.a.T4, "Lokio/v0;", "U", "clone", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface e extends Cloneable {

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lokhttp3/e$a;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/e;", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        @yt.k
        e a(@yt.k b0 b0Var);
    }

    @yt.k
    b0 T();

    @yt.k
    v0 U();

    boolean W();

    @yt.k
    d0 X() throws IOException;

    boolean Z();

    void b0(@yt.k f fVar);

    void cancel();

    @yt.k
    /* JADX INFO: renamed from: clone */
    e mo11clone();
}
