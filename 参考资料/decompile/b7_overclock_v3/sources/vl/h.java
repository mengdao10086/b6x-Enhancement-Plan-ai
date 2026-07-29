package vl;

import kotlin.d0;
import kotlin.jvm.internal.f0;
import okhttp3.e0;
import okhttp3.w;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\f"}, d2 = {"Lvl/h;", "Lokhttp3/e0;", "", "contentLength", "Lokhttp3/w;", so.d.f50127a, "Lokio/l;", "source", "", "contentTypeString", "<init>", "(Ljava/lang/String;JLokio/l;)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class h extends e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @l
    public final String f53215a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f53216b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final okio.l f53217c;

    public h(@l String str, long j10, @yt.k okio.l source) {
        f0.p(source, "source");
        this.f53215a = str;
        this.f53216b = j10;
        this.f53217c = source;
    }

    @Override // okhttp3.e0
    public long contentLength() {
        return this.f53216b;
    }

    @Override // okhttp3.e0
    @l
    public w contentType() {
        String str = this.f53215a;
        if (str == null) {
            return null;
        }
        return w.f43984e.d(str);
    }

    @Override // okhttp3.e0
    @yt.k
    public okio.l source() {
        return this.f53217c;
    }
}
