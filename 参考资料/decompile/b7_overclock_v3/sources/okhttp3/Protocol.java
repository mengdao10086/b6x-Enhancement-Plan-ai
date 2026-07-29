package okhttp3;

import java.io.IOException;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lokhttp3/Protocol;", "", "", "toString", "protocol", "Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", "QUIC", "okhttp"}, k = 1, mv = {1, 6, 0})
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2("h2"),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    @yt.k
    public static final a Companion = new a(null);

    @yt.k
    private final String protocol;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\b"}, d2 = {"Lokhttp3/Protocol$a;", "", "", "protocol", "Lokhttp3/Protocol;", "a", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 6, 0})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final Protocol a(@yt.k String protocol) throws IOException {
            kotlin.jvm.internal.f0.p(protocol, "protocol");
            Protocol protocol2 = Protocol.HTTP_1_0;
            if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                protocol2 = Protocol.HTTP_1_1;
                if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                    protocol2 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                        protocol2 = Protocol.HTTP_2;
                        if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                            protocol2 = Protocol.SPDY_3;
                            if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                                protocol2 = Protocol.QUIC;
                                if (!kotlin.jvm.internal.f0.g(protocol, protocol2.protocol)) {
                                    throw new IOException(kotlin.jvm.internal.f0.C("Unexpected protocol: ", protocol));
                                }
                            }
                        }
                    }
                }
            }
            return protocol2;
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @hk.m
    @yt.k
    public static final Protocol get(@yt.k String str) throws IOException {
        return Companion.a(str);
    }

    @Override // java.lang.Enum
    @yt.k
    public String toString() {
        return this.protocol;
    }
}
