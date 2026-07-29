package vl;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import okhttp3.Protocol;

/* JADX INFO: loaded from: classes5.dex */
@d0(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016¨\u0006\f"}, d2 = {"Lvl/k;", "", "", "toString", "Lokhttp3/Protocol;", "protocol", "", "code", "message", "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "a", "okhttp"}, k = 1, mv = {1, 6, 0})
public final class k {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f53222d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f53223e = 307;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f53224f = 308;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f53225g = 421;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f53226h = 100;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @hk.e
    @yt.k
    public final Protocol f53227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    public final int f53228b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @hk.e
    @yt.k
    public final String f53229c;

    @d0(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000b¨\u0006\u0011"}, d2 = {"Lvl/k$a;", "", "Lokhttp3/d0;", "response", "Lvl/k;", "a", "", "statusLine", "b", "", "HTTP_CONTINUE", "I", "HTTP_MISDIRECTED_REQUEST", "HTTP_PERM_REDIRECT", "HTTP_TEMP_REDIRECT", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @yt.k
        public final k a(@yt.k okhttp3.d0 response) {
            f0.p(response, "response");
            return new k(response.C1(), response.W(), response.m1());
        }

        @yt.k
        public final k b(@yt.k String statusLine) throws IOException {
            Protocol protocol;
            String strSubstring;
            f0.p(statusLine, "statusLine");
            int i10 = 9;
            if (kotlin.text.u.v2(statusLine, "HTTP/1.", false, 2, null)) {
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
                }
                int iCharAt = statusLine.charAt(7) - '0';
                if (iCharAt == 0) {
                    protocol = Protocol.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
                    }
                    protocol = Protocol.HTTP_1_1;
                }
            } else {
                if (!kotlin.text.u.v2(statusLine, "ICY ", false, 2, null)) {
                    throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
                }
                protocol = Protocol.HTTP_1_0;
                i10 = 4;
            }
            int i11 = i10 + 3;
            if (statusLine.length() < i11) {
                throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
            }
            try {
                String strSubstring2 = statusLine.substring(i10, i11);
                f0.o(strSubstring2, "this as java.lang.String…ing(startIndex, endIndex)");
                int i12 = Integer.parseInt(strSubstring2);
                if (statusLine.length() <= i11) {
                    strSubstring = "";
                } else {
                    if (statusLine.charAt(i11) != ' ') {
                        throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
                    }
                    strSubstring = statusLine.substring(i10 + 4);
                    f0.o(strSubstring, "this as java.lang.String).substring(startIndex)");
                }
                return new k(protocol, i12, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException(f0.C("Unexpected status line: ", statusLine));
            }
        }
    }

    public k(@yt.k Protocol protocol, int i10, @yt.k String message) {
        f0.p(protocol, "protocol");
        f0.p(message, "message");
        this.f53227a = protocol;
        this.f53228b = i10;
        this.f53229c = message;
    }

    @yt.k
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (this.f53227a == Protocol.HTTP_1_0) {
            sb2.append("HTTP/1.0");
        } else {
            sb2.append("HTTP/1.1");
        }
        sb2.append(zc.f.f58383m);
        sb2.append(this.f53228b);
        sb2.append(zc.f.f58383m);
        sb2.append(this.f53229c);
        String string = sb2.toString();
        f0.o(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
