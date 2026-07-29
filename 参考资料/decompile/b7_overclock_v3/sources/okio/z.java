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
@kotlin.d0(bv = {}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\u001fB\u0019\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018B\u0019\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001bB\u0019\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0017\u0010\u001cB!\b\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u001d\u001a\u00020\b\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u0017\u0010\u001eJ\u0018\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u000f\u0010\t\u001a\u00020\bH\u0007¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u0013\u0010\n¨\u0006 "}, d2 = {"Lokio/z;", "Lokio/u;", "Lokio/t0;", "Lokio/j;", "sink", "", "byteCount", "F1", "Lokio/ByteString;", "d", "()Lokio/ByteString;", "Ljava/security/MessageDigest;", "b", "Ljava/security/MessageDigest;", "messageDigest", "Ljavax/crypto/Mac;", "c", "Ljavax/crypto/Mac;", SocializeProtocolConstants.PROTOCOL_KEY_MAC, "f", "hash", "source", so.d.f50128b, "<init>", "(Lokio/t0;Ljava/security/MessageDigest;)V", "", "algorithm", "(Lokio/t0;Ljava/lang/String;)V", "(Lokio/t0;Ljavax/crypto/Mac;)V", "key", "(Lokio/t0;Lokio/ByteString;Ljava/lang/String;)V", "a", "okio"}, k = 1, mv = {1, 5, 1})
public final class z extends u implements t0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @yt.k
    public static final a f44253d = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public final MessageDigest f44254b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.l
    public final Mac f44255c;

    @kotlin.d0(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u0010"}, d2 = {"Lokio/z$a;", "", "Lokio/t0;", "source", "Lokio/z;", "d", "e", "f", "g", "Lokio/ByteString;", "key", "a", "b", "c", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        @hk.m
        @yt.k
        public final z a(@yt.k t0 source, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(source, "source");
            kotlin.jvm.internal.f0.p(key, "key");
            return new z(source, key, hh.c.f31295a);
        }

        @hk.m
        @yt.k
        public final z b(@yt.k t0 source, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(source, "source");
            kotlin.jvm.internal.f0.p(key, "key");
            return new z(source, key, "HmacSHA256");
        }

        @hk.m
        @yt.k
        public final z c(@yt.k t0 source, @yt.k ByteString key) {
            kotlin.jvm.internal.f0.p(source, "source");
            kotlin.jvm.internal.f0.p(key, "key");
            return new z(source, key, "HmacSHA512");
        }

        @hk.m
        @yt.k
        public final z d(@yt.k t0 source) {
            kotlin.jvm.internal.f0.p(source, "source");
            return new z(source, "MD5");
        }

        @hk.m
        @yt.k
        public final z e(@yt.k t0 source) {
            kotlin.jvm.internal.f0.p(source, "source");
            return new z(source, et.e.f27137f);
        }

        @hk.m
        @yt.k
        public final z f(@yt.k t0 source) {
            kotlin.jvm.internal.f0.p(source, "source");
            return new z(source, "SHA-256");
        }

        @hk.m
        @yt.k
        public final z g(@yt.k t0 source) {
            kotlin.jvm.internal.f0.p(source, "source");
            return new z(source, "SHA-512");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@yt.k t0 source, @yt.k MessageDigest digest) {
        super(source);
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(digest, "digest");
        this.f44254b = digest;
        this.f44255c = null;
    }

    @hk.m
    @yt.k
    public static final z h(@yt.k t0 t0Var, @yt.k ByteString byteString) {
        return f44253d.a(t0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final z i(@yt.k t0 t0Var, @yt.k ByteString byteString) {
        return f44253d.b(t0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final z k(@yt.k t0 t0Var, @yt.k ByteString byteString) {
        return f44253d.c(t0Var, byteString);
    }

    @hk.m
    @yt.k
    public static final z l(@yt.k t0 t0Var) {
        return f44253d.d(t0Var);
    }

    @hk.m
    @yt.k
    public static final z m(@yt.k t0 t0Var) {
        return f44253d.e(t0Var);
    }

    @hk.m
    @yt.k
    public static final z n(@yt.k t0 t0Var) {
        return f44253d.f(t0Var);
    }

    @hk.m
    @yt.k
    public static final z u(@yt.k t0 t0Var) {
        return f44253d.g(t0Var);
    }

    @Override // okio.u, okio.t0
    public long F1(@yt.k j sink, long j10) throws IOException {
        kotlin.jvm.internal.f0.p(sink, "sink");
        long jF1 = super.F1(sink, j10);
        if (jF1 != -1) {
            long jM2 = sink.m2() - jF1;
            long jM22 = sink.m2();
            p0 p0Var = sink.f44116a;
            kotlin.jvm.internal.f0.m(p0Var);
            while (jM22 > jM2) {
                p0Var = p0Var.f44180g;
                kotlin.jvm.internal.f0.m(p0Var);
                jM22 -= (long) (p0Var.f44176c - p0Var.f44175b);
            }
            while (jM22 < sink.m2()) {
                int i10 = (int) ((((long) p0Var.f44175b) + jM2) - jM22);
                MessageDigest messageDigest = this.f44254b;
                if (messageDigest != null) {
                    messageDigest.update(p0Var.f44174a, i10, p0Var.f44176c - i10);
                } else {
                    Mac mac = this.f44255c;
                    kotlin.jvm.internal.f0.m(mac);
                    mac.update(p0Var.f44174a, i10, p0Var.f44176c - i10);
                }
                jM22 += (long) (p0Var.f44176c - p0Var.f44175b);
                p0Var = p0Var.f44179f;
                kotlin.jvm.internal.f0.m(p0Var);
                jM2 = jM22;
            }
        }
        return jF1;
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
        MessageDigest messageDigest = this.f44254b;
        if (messageDigest != null) {
            result = messageDigest.digest();
        } else {
            Mac mac = this.f44255c;
            kotlin.jvm.internal.f0.m(mac);
            result = mac.doFinal();
        }
        kotlin.jvm.internal.f0.o(result, "result");
        return new ByteString(result);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public z(@yt.k t0 source, @yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        kotlin.jvm.internal.f0.o(messageDigest, "getInstance(algorithm)");
        this(source, messageDigest);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public z(@yt.k t0 source, @yt.k Mac mac) {
        super(source);
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(mac, "mac");
        this.f44255c = mac;
        this.f44254b = null;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public z(@yt.k t0 source, @yt.k ByteString key, @yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(source, "source");
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.N0(), algorithm));
            z1 z1Var = z1.f38230a;
            kotlin.jvm.internal.f0.o(mac, "try {\n      Mac.getInsta…rgumentException(e)\n    }");
            this(source, mac);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }
}
