package okhttp3;

import com.tencent.open.SocialConstants;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import okio.ByteString;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\fJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&J\u001a\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\u0012\u001a\u00020\u0011H&¨\u0006\u0013"}, d2 = {"Lokhttp3/g0;", "", "Lokhttp3/b0;", i1.a.f31577d5, "", "g", "", "text", "", "b", "Lokio/ByteString;", "bytes", "a", "", "code", "reason", "f", "Lkotlin/z1;", CommonNetImpl.CANCEL, "okhttp"}, k = 1, mv = {1, 6, 0})
public interface g0 {

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\b"}, d2 = {"Lokhttp3/g0$a;", "", "Lokhttp3/b0;", SocialConstants.TYPE_REQUEST, "Lokhttp3/h0;", "listener", "Lokhttp3/g0;", "b", "okhttp"}, k = 1, mv = {1, 6, 0})
    public interface a {
        @yt.k
        g0 b(@yt.k b0 b0Var, @yt.k h0 h0Var);
    }

    @yt.k
    b0 T();

    boolean a(@yt.k ByteString byteString);

    boolean b(@yt.k String str);

    void cancel();

    boolean f(int i10, @yt.l String str);

    long g();
}
