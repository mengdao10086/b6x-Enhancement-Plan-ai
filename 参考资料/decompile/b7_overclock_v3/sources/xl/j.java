package xl;

import java.io.IOException;
import java.util.List;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.internal.http2.ErrorCode;
import okio.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\bJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H&J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H&J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H&¨\u0006\u0014"}, d2 = {"Lxl/j;", "", "", "streamId", "", "Lxl/a;", "requestHeaders", "", "a", "responseHeaders", "last", "b", "Lokio/l;", "source", "byteCount", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lkotlin/z1;", "c", "okhttp"}, k = 1, mv = {1, 6, 0})
public interface j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final a f55594a = a.f55596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final j f55595b = new a.C0656a();

    @d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0001¨\u0006\b"}, d2 = {"Lxl/j$a;", "", "Lxl/j;", "CANCEL", "Lxl/j;", "<init>", "()V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f55596a = new a();

        /* JADX INFO: renamed from: xl.j$a$a, reason: collision with other inner class name */
        @d0(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J&\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\n\u001a\u00020\u0007H\u0016J(\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lxl/j$a$a;", "Lxl/j;", "", "streamId", "", "Lxl/a;", "requestHeaders", "", "a", "responseHeaders", "last", "b", "Lokio/l;", "source", "byteCount", "d", "Lokhttp3/internal/http2/ErrorCode;", "errorCode", "Lkotlin/z1;", "c", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
        public static final class C0656a implements j {
            @Override // xl.j
            public boolean a(int i10, @yt.k List<xl.a> requestHeaders) {
                f0.p(requestHeaders, "requestHeaders");
                return true;
            }

            @Override // xl.j
            public boolean b(int i10, @yt.k List<xl.a> responseHeaders, boolean z10) {
                f0.p(responseHeaders, "responseHeaders");
                return true;
            }

            @Override // xl.j
            public void c(int i10, @yt.k ErrorCode errorCode) {
                f0.p(errorCode, "errorCode");
            }

            @Override // xl.j
            public boolean d(int i10, @yt.k l source, int i11, boolean z10) throws IOException {
                f0.p(source, "source");
                source.skip(i11);
                return true;
            }
        }
    }

    boolean a(int i10, @yt.k List<xl.a> list);

    boolean b(int i10, @yt.k List<xl.a> list, boolean z10);

    void c(int i10, @yt.k ErrorCode errorCode);

    boolean d(int i10, @yt.k l lVar, int i11, boolean z10) throws IOException;
}
