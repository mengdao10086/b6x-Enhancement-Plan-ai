package okhttp3;

import com.arialyy.aria.core.ProtocolType;
import kotlin.DeprecationLevel;
import kotlin.t0;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0004j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/TlsVersion;", "", "", "-deprecated_javaName", "()Ljava/lang/String;", "javaName", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "TLS_1_3", "TLS_1_2", "TLS_1_1", "TLS_1_0", "SSL_3_0", "okhttp"}, k = 1, mv = {1, 6, 0})
public enum TlsVersion {
    TLS_1_3("TLSv1.3"),
    TLS_1_2(ProtocolType.TLSv1_2),
    TLS_1_1(ProtocolType.TLSv1_1),
    TLS_1_0(ProtocolType.TLSv1),
    SSL_3_0(ProtocolType.SSLv3);


    @yt.k
    public static final a Companion = new a(null);

    @yt.k
    private final String javaName;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lokhttp3/TlsVersion$a;", "", "", "javaName", "Lokhttp3/TlsVersion;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        @hk.m
        @yt.k
        public final TlsVersion a(@yt.k String javaName) {
            kotlin.jvm.internal.f0.p(javaName, "javaName");
            int iHashCode = javaName.hashCode();
            if (iHashCode != 79201641) {
                if (iHashCode != 79923350) {
                    switch (iHashCode) {
                        case -503070503:
                            if (javaName.equals(ProtocolType.TLSv1_1)) {
                                return TlsVersion.TLS_1_1;
                            }
                            break;
                        case -503070502:
                            if (javaName.equals(ProtocolType.TLSv1_2)) {
                                return TlsVersion.TLS_1_2;
                            }
                            break;
                        case -503070501:
                            if (javaName.equals("TLSv1.3")) {
                                return TlsVersion.TLS_1_3;
                            }
                            break;
                    }
                } else if (javaName.equals(ProtocolType.TLSv1)) {
                    return TlsVersion.TLS_1_0;
                }
            } else if (javaName.equals(ProtocolType.SSLv3)) {
                return TlsVersion.SSL_3_0;
            }
            throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Unexpected TLS version: ", javaName));
        }
    }

    TlsVersion(String str) {
        this.javaName = str;
    }

    @hk.m
    @yt.k
    public static final TlsVersion forJavaName(@yt.k String str) {
        return Companion.a(str);
    }

    @hk.h(name = "-deprecated_javaName")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @t0(expression = "javaName", imports = {}))
    @yt.k
    /* JADX INFO: renamed from: -deprecated_javaName, reason: not valid java name */
    public final String m10deprecated_javaName() {
        return this.javaName;
    }

    @hk.h(name = "javaName")
    @yt.k
    public final String javaName() {
        return this.javaName;
    }
}
