package okio;

import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import kotlin.z1;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001 B\u0019\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019B\u0019\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001cB\u0019\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u001dB!\b\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u0012\u0006\u0010\u001e\u001a\u00020\t\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u0018\u0010\u001fJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000f\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0015\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000b¨\u0006!"}, d2 = {"Lokio/y;", "Lokio/t;", "Lokio/r0;", "Lokio/j;", "source", "", "byteCount", "Lkotlin/z1;", "V0", "Lokio/ByteString;", "d", "()Lokio/ByteString;", "Ljava/security/MessageDigest;", "b", "Ljava/security/MessageDigest;", "messageDigest", "Ljavax/crypto/Mac;", "c", "Ljavax/crypto/Mac;", SocializeProtocolConstants.PROTOCOL_KEY_MAC, "f", "hash", "sink", so.d.f50128b, "<init>", "(Lokio/r0;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/r0;Ljava/lang/String;)V", "(Lokio/r0;Ljavax/crypto/Mac;)V", "key", "(Lokio/r0;Lokio/ByteString;Ljava/lang/String;)V", "a", "okio"}, k = 1, mv = {1, 5, 1})
public final class y extends t implements r0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f44248d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final MessageDigest f44249b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final Mac f44250c;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Lokio/y$a;", "", "Lokio/r0;", "sink", "Lokio/y;", "d", "e", "f", "g", "Lokio/ByteString;", "key", "a", "b", "c", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final y a(@yt.k r0 sink, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            kotlin.jvm.internal.f0.p(key, "key");
            return new y(sink, key, hh.c.f31295a);
        }

        @hk.m
        @yt.k
        public final y b(@yt.k r0 sink, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            kotlin.jvm.internal.f0.p(key, "key");
            return new y(sink, key, "HmacSHA256");
        }

        @hk.m
        @yt.k
        public final y c(@yt.k r0 sink, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            kotlin.jvm.internal.f0.p(key, "key");
            return new y(sink, key, "HmacSHA512");
        }

        @hk.m
        @yt.k
        public final y d(@yt.k r0 sink) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            return new y(sink, "MD5");
        }

        @hk.m
        @yt.k
        public final y e(@yt.k r0 sink) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            return new y(sink, et.e.f27137f);
        }

        @hk.m
        @yt.k
        public final y f(@yt.k r0 sink) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            return new y(sink, "SHA-256");
        }

        @hk.m
        @yt.k
        public final y g(@yt.k r0 sink) {
            kotlin.jvm.internal.f0.p(sink, "sink");
            return new y(sink, "SHA-512");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@yt.k r0 sink, @yt.k MessageDigest digest) {
        super(sink);
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(digest, "digest");
        this.f44249b = digest;
        this.f44250c = null;
    }

    @hk.m
    @yt.k
    public static final y h(@yt.k r0 r0Var, @yt.k ByteString byteString) {
        return f44248d.a(r0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final y i(@yt.k r0 r0Var, @yt.k ByteString byteString) {
        return f44248d.b(r0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final y k(@yt.k r0 r0Var, @yt.k ByteString byteString) {
        return f44248d.c(r0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final y l(@yt.k r0 r0Var) {
        return f44248d.d(r0Var);
    }

    @hk.m
    @yt.k
    public static final y m(@yt.k r0 r0Var) {
        return f44248d.e(r0Var);
    }

    @hk.m
    @yt.k
    public static final y n(@yt.k r0 r0Var) {
        return f44248d.f(r0Var);
    }

    @hk.m
    @yt.k
    public static final y u(@yt.k r0 r0Var) {
        return f44248d.g(r0Var);
    }

    @Override // okio.t, okio.r0
    public void V0(@yt.k j source, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(source, "source");
        a1.e(source.m2(), 0L, j10);
        p0 p0Var = source.f44116a;
        kotlin.jvm.internal.f0.m(p0Var);
        long j11 = 0;
        while (j11 < j10) {
            int iMin = (int) Math.min(j10 - j11, p0Var.f44176c - p0Var.f44175b);
            MessageDigest messageDigest = this.f44249b;
            if (messageDigest != null) {
                messageDigest.update(p0Var.f44174a, p0Var.f44175b, iMin);
            } else {
                Mac mac = this.f44250c;
                kotlin.jvm.internal.f0.m(mac);
                mac.update(p0Var.f44174a, p0Var.f44175b, iMin);
            }
            j11 += (long) iMin;
            p0Var = p0Var.f44179f;
            kotlin.jvm.internal.f0.m(p0Var);
        }
        super.V0(source, j10);
    }

    @hk.h(name = "-deprecated_hash")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "hash", imports = {}))
    @yt.k
    public final ByteString d() {
        return f();
    }

    @hk.h(name = "hash")
    @yt.k
    public final ByteString f() {
        byte[] result;
        MessageDigest messageDigest = this.f44249b;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.f44250c;
            kotlin.jvm.internal.f0.m(mac);
            result = mac.doFinal();
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return new ByteString(result);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public y(@yt.k r0 sink, @yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        kotlin.jvm.internal.f0.o(messageDigest, "getInstance(algorithm)");
        this(sink, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y(@yt.k r0 sink, @yt.k Mac mac) {
        super(sink);
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(mac, "mac");
        this.f44250c = mac;
        this.f44249b = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public y(@yt.k r0 sink, @yt.k ByteString key, @yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.N0(), algorithm));
            z1 z1Var = z1.f38230a;
            kotlin.jvm.internal.f0.o(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
            this(sink, mac);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
