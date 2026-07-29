package dm;

import java.io.IOException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.t;
import yt.k;
import yt.l;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0005BG\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0005\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\t\u001a\u00020\u0002HÆ\u0003J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\t\u0010\u000b\u001a\u00020\u0002HÆ\u0003J\t\u0010\f\u001a\u00020\u0002HÆ\u0003JP\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0016\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003¨\u0006\u001c"}, d2 = {"Ldm/f;", "", "", "clientOriginated", "i", "a", "", "b", "()Ljava/lang/Integer;", "c", "d", "e", "f", "perMessageDeflate", "clientMaxWindowBits", "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "g", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Ldm/f;", "", "toString", "hashCode", "other", "equals", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class f {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @k
    public static final a f26361g = new a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @k
    public static final String f26362h = "Sec-WebSocket-Extensions";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    public final boolean f26363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @l
    public final Integer f26364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    public final boolean f26365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @l
    public final Integer f26366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @hk.e
    public final boolean f26367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @hk.e
    public final boolean f26368f;

    @d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Ldm/f$a;", "", "Lokhttp3/t;", "responseHeaders", "Ldm/f;", "a", "", "HEADER_WEB_SOCKET_EXTENSION", "Ljava/lang/String;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        public final f a(@k t responseHeaders) throws IOException {
            f0.p(responseHeaders, "responseHeaders");
            int size = responseHeaders.size();
            int i10 = 0;
            boolean z10 = false;
            Integer numY0 = null;
            boolean z11 = false;
            Integer numY02 = null;
            boolean z12 = false;
            boolean z13 = false;
            while (i10 < size) {
                int i11 = i10 + 1;
                if (kotlin.text.u.L1(responseHeaders.j(i10), f.f26362h, true)) {
                    String strR = responseHeaders.r(i10);
                    int i12 = 0;
                    while (i12 < strR.length()) {
                        int iU = rl.f.u(strR, ',', i12, 0, 4, null);
                        int iS = rl.f.s(strR, zc.f.f58382l, i12, iU);
                        String strL0 = rl.f.l0(strR, i12, iS);
                        int i13 = iS + 1;
                        if (kotlin.text.u.L1(strL0, "permessage-deflate", true)) {
                            if (z10) {
                                z13 = true;
                            }
                            i12 = i13;
                            while (i12 < iU) {
                                int iS2 = rl.f.s(strR, zc.f.f58382l, i12, iU);
                                int iS3 = rl.f.s(strR, '=', i12, iS2);
                                String strL02 = rl.f.l0(strR, i12, iS3);
                                String strM4 = iS3 < iS2 ? StringsKt__StringsKt.m4(rl.f.l0(strR, iS3 + 1, iS2), "\"") : null;
                                i12 = iS2 + 1;
                                if (kotlin.text.u.L1(strL02, "client_max_window_bits", true)) {
                                    if (numY0 != null) {
                                        z13 = true;
                                    }
                                    numY0 = strM4 == null ? null : kotlin.text.t.Y0(strM4);
                                    if (numY0 == null) {
                                        z13 = true;
                                    }
                                } else if (kotlin.text.u.L1(strL02, "client_no_context_takeover", true)) {
                                    if (z11) {
                                        z13 = true;
                                    }
                                    if (strM4 != null) {
                                        z13 = true;
                                    }
                                    z11 = true;
                                } else if (kotlin.text.u.L1(strL02, "server_max_window_bits", true)) {
                                    if (numY02 != null) {
                                        z13 = true;
                                    }
                                    numY02 = strM4 == null ? null : kotlin.text.t.Y0(strM4);
                                    if (numY02 == null) {
                                        z13 = true;
                                    }
                                } else if (kotlin.text.u.L1(strL02, "server_no_context_takeover", true)) {
                                    if (z12) {
                                        z13 = true;
                                    }
                                    if (strM4 != null) {
                                        z13 = true;
                                    }
                                    z12 = true;
                                } else {
                                    z13 = true;
                                }
                            }
                            z10 = true;
                        } else {
                            i12 = i13;
                            z13 = true;
                        }
                    }
                }
                i10 = i11;
            }
            return new f(z10, numY0, z11, numY02, z12, z13);
        }
    }

    public f() {
        this(false, null, false, null, false, false, 63, null);
    }

    public f(boolean z10, @l Integer num, boolean z11, @l Integer num2, boolean z12, boolean z13) {
        this.f26363a = z10;
        this.f26364b = num;
        this.f26365c = z11;
        this.f26366d = num2;
        this.f26367e = z12;
        this.f26368f = z13;
    }

    public static /* synthetic */ f h(f fVar, boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = fVar.f26363a;
        }
        if ((i10 & 2) != 0) {
            num = fVar.f26364b;
        }
        Integer num3 = num;
        if ((i10 & 4) != 0) {
            z11 = fVar.f26365c;
        }
        boolean z14 = z11;
        if ((i10 & 8) != 0) {
            num2 = fVar.f26366d;
        }
        Integer num4 = num2;
        if ((i10 & 16) != 0) {
            z12 = fVar.f26367e;
        }
        boolean z15 = z12;
        if ((i10 & 32) != 0) {
            z13 = fVar.f26368f;
        }
        return fVar.g(z10, num3, z14, num4, z15, z13);
    }

    public final boolean a() {
        return this.f26363a;
    }

    @l
    public final Integer b() {
        return this.f26364b;
    }

    public final boolean c() {
        return this.f26365c;
    }

    @l
    public final Integer d() {
        return this.f26366d;
    }

    public final boolean e() {
        return this.f26367e;
    }

    public boolean equals(@l Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f26363a == fVar.f26363a && f0.g(this.f26364b, fVar.f26364b) && this.f26365c == fVar.f26365c && f0.g(this.f26366d, fVar.f26366d) && this.f26367e == fVar.f26367e && this.f26368f == fVar.f26368f;
    }

    public final boolean f() {
        return this.f26368f;
    }

    @k
    public final f g(boolean z10, @l Integer num, boolean z11, @l Integer num2, boolean z12, boolean z13) {
        return new f(z10, num, z11, num2, z12, z13);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public int hashCode() {
        boolean z10 = this.f26363a;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        Integer num = this.f26364b;
        int iHashCode = (i10 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z11 = this.f26365c;
        ?? r22 = z11;
        if (z11) {
            r22 = 1;
        }
        int i11 = (iHashCode + r22) * 31;
        Integer num2 = this.f26366d;
        int iHashCode2 = (i11 + (num2 != null ? num2.hashCode() : 0)) * 31;
        boolean z12 = this.f26367e;
        ?? r23 = z12;
        if (z12) {
            r23 = 1;
        }
        int i12 = (iHashCode2 + r23) * 31;
        boolean z13 = this.f26368f;
        return i12 + (z13 ? 1 : z13);
    }

    public final boolean i(boolean z10) {
        return z10 ? this.f26365c : this.f26367e;
    }

    @k
    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f26363a + ", clientMaxWindowBits=" + this.f26364b + ", clientNoContextTakeover=" + this.f26365c + ", serverMaxWindowBits=" + this.f26366d + ", serverNoContextTakeover=" + this.f26367e + ", unknownValues=" + this.f26368f + ')';
    }

    public /* synthetic */ f(boolean z10, Integer num, boolean z11, Integer num2, boolean z12, boolean z13, int i10, u uVar) {
        this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : num, (i10 & 4) != 0 ? false : z11, (i10 & 8) == 0 ? num2 : null, (i10 & 16) != 0 ? false : z12, (i10 & 32) != 0 ? false : z13);
    }
}
