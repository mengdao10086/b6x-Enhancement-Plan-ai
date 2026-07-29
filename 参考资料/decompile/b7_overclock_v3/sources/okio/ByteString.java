package okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.DeprecationLevel;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\u001a\b\u0016\u0018\u0000 S2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001XB\u0011\b\u0000\u0012\u0006\u0010U\u001a\u00020-¢\u0006\u0004\bf\u0010gJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0006\u0010\u0010\u001a\u00020\u0000J\u0006\u0010\u0011\u001a\u00020\u0000J\u0006\u0010\u0012\u001a\u00020\u0000J\u0006\u0010\u0013\u001a\u00020\u0000J\u0017\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\nH\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0016J\u0010\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0016J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0000H\u0016J\u001f\u0010\u001b\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\nH\u0016J\b\u0010\u001e\u001a\u00020\nH\u0016J\b\u0010\u001f\u001a\u00020\u0000H\u0016J\b\u0010 \u001a\u00020\u0000H\u0016J\u001c\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\"\u001a\u00020!2\b\b\u0002\u0010#\u001a\u00020!H\u0017J\u0017\u0010'\u001a\u00020&2\u0006\u0010%\u001a\u00020!H\u0010¢\u0006\u0004\b'\u0010(J\u0018\u0010*\u001a\u00020&2\u0006\u0010)\u001a\u00020!H\u0087\u0002¢\u0006\u0004\b*\u0010(J\u000f\u0010+\u001a\u00020!H\u0010¢\u0006\u0004\b+\u0010,J\b\u0010.\u001a\u00020-H\u0016J\u000f\u0010/\u001a\u00020-H\u0010¢\u0006\u0004\b/\u00100J\b\u00102\u001a\u000201H\u0016J\u0010\u00104\u001a\u00020\u00052\u0006\u0010\b\u001a\u000203H\u0016J'\u00109\u001a\u00020\u00052\u0006\u00106\u001a\u0002052\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0010¢\u0006\u0004\b9\u0010:J(\u0010>\u001a\u00020=2\u0006\u00107\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00002\u0006\u0010<\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0016J(\u0010?\u001a\u00020=2\u0006\u00107\u001a\u00020!2\u0006\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0016J,\u0010B\u001a\u00020\u00052\b\b\u0002\u00107\u001a\u00020!2\u0006\u0010@\u001a\u00020-2\b\b\u0002\u0010A\u001a\u00020!2\u0006\u00108\u001a\u00020!H\u0016J\u000e\u0010D\u001a\u00020=2\u0006\u0010C\u001a\u00020\u0000J\u000e\u0010E\u001a\u00020=2\u0006\u0010C\u001a\u00020-J\u000e\u0010G\u001a\u00020=2\u0006\u0010F\u001a\u00020\u0000J\u000e\u0010H\u001a\u00020=2\u0006\u0010F\u001a\u00020-J\u001a\u0010J\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00002\b\b\u0002\u0010I\u001a\u00020!H\u0007J\u001a\u0010K\u001a\u00020!2\u0006\u0010;\u001a\u00020-2\b\b\u0002\u0010I\u001a\u00020!H\u0017J\u001a\u0010L\u001a\u00020!2\u0006\u0010;\u001a\u00020\u00002\b\b\u0002\u0010I\u001a\u00020!H\u0007J\u001a\u0010M\u001a\u00020!2\u0006\u0010;\u001a\u00020-2\b\b\u0002\u0010I\u001a\u00020!H\u0017J\u0013\u0010O\u001a\u00020=2\b\u0010;\u001a\u0004\u0018\u00010NH\u0096\u0002J\b\u0010P\u001a\u00020!H\u0016J\u0011\u0010Q\u001a\u00020!2\u0006\u0010;\u001a\u00020\u0000H\u0096\u0002J\b\u0010R\u001a\u00020\nH\u0016J\u0017\u0010S\u001a\u00020&2\u0006\u0010)\u001a\u00020!H\u0007¢\u0006\u0004\bS\u0010(J\u000f\u0010T\u001a\u00020!H\u0007¢\u0006\u0004\bT\u0010,R\u001a\u0010U\u001a\u00020-8\u0000X\u0080\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u00100R\"\u0010P\u001a\u00020!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bX\u0010Y\u001a\u0004\bZ\u0010,\"\u0004\b[\u0010\\R$\u0010c\u001a\u0004\u0018\u00010\n8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR\u0011\u0010e\u001a\u00020!8G¢\u0006\u0006\u001a\u0004\bd\u0010,¨\u0006h"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", "in", "Lkotlin/z1;", "readObject", "Ljava/io/ObjectOutputStream;", "out", "writeObject", "", "O0", "Ljava/nio/charset/Charset;", "charset", "B0", "h", "Z", "u0", "v0", "w0", "algorithm", "p", "(Ljava/lang/String;)Lokio/ByteString;", "key", i1.a.S4, "G", "H", "D", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "i", "B", "K0", "M0", "", "beginIndex", "endIndex", "F0", "pos", "", "P", "(I)B", "index", "v", "y", "()I", "", "N0", "O", "()[B", "Ljava/nio/ByteBuffer;", "f", "Ljava/io/OutputStream;", "P0", "Lokio/j;", "buffer", w.c.R, "byteCount", "Q0", "(Lokio/j;II)V", "other", "otherOffset", "", "o0", "p0", "target", "targetOffset", com.flydigi.sdk.bluetooth.l.f16298a, "prefix", "y0", "A0", "suffix", "t", "u", "fromIndex", "J", "L", "R", "U", "", "equals", "hashCode", "k", "toString", "c", "d", "data", "[B", "w", "a", "I", "x", "r0", "(I)V", "b", "Ljava/lang/String;", i1.a.W4, "()Ljava/lang/String;", "t0", "(Ljava/lang/String;)V", "utf8", "x0", "size", "<init>", "([B)V", "okio"}, k = 1, mv = {1, 5, 1})
public class ByteString implements Serializable, Comparable<ByteString> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public static final a f44029c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final ByteString f44030d = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient int f44031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.l
    public transient String f44032b;

    @yt.k
    private final byte[] data;

    @kotlin.d0(bv = {}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b+\u0010,J\u0014\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007J'\u0010\n\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u0005*\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000eJ\f\u0010\u0010\u001a\u00020\u0005*\u00020\u000fH\u0007J\u001d\u0010\u0013\u001a\u00020\u0005*\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0015\u001a\u0004\u0018\u00010\u0005*\u00020\u000fH\u0007J\f\u0010\u0016\u001a\u00020\u0005*\u00020\u000fH\u0007J\u001b\u0010\u0018\u001a\u00020\u0005*\u00020\u00172\u0006\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u001e\u0010\u0014J\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u000fH\u0007¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010!\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\fH\u0007¢\u0006\u0004\b!\u0010\u000eJ'\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b#\u0010\u000bJ\u001f\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00172\u0006\u0010\t\u001a\u00020\u0007H\u0007¢\u0006\u0004\b%\u0010\u0019R\u0014\u0010&\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010)\u001a\u00020(8\u0002X\u0082T¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lokio/ByteString$a;", "", "", "", "data", "Lokio/ByteString;", "n", "", w.c.R, "byteCount", "o", "([BII)Lokio/ByteString;", "Ljava/nio/ByteBuffer;", m0.k.f40564b, "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", com.flydigi.sdk.bluetooth.l.f16298a, "Ljava/nio/charset/Charset;", "charset", xf.j.f55230b, "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "h", "i", "Ljava/io/InputStream;", "q", "(Ljava/io/InputStream;I)Lokio/ByteString;", w.b.f53669e, "a", "(Ljava/lang/String;)Lokio/ByteString;", "b", "c", "d", "buffer", "e", "array", "f", "inputstream", "g", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 5, 1})
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
            this();
        }

        public static /* synthetic */ ByteString k(a aVar, String str, Charset charset, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                charset = kotlin.text.d.f38161b;
            }
            return aVar.j(str, charset);
        }

        public static /* synthetic */ ByteString p(a aVar, byte[] bArr, int i10, int i11, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = 0;
            }
            if ((i12 & 2) != 0) {
                i11 = bArr.length;
            }
            return aVar.o(bArr, i10, i11);
        }

        @hk.h(name = "-deprecated_decodeBase64")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        @yt.l
        public final ByteString a(@yt.k String string) {
            kotlin.jvm.internal.f0.p(string, "string");
            return h(string);
        }

        @hk.h(name = "-deprecated_decodeHex")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @yt.k
        public final ByteString b(@yt.k String string) {
            kotlin.jvm.internal.f0.p(string, "string");
            return i(string);
        }

        @hk.h(name = "-deprecated_encodeString")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @yt.k
        public final ByteString c(@yt.k String string, @yt.k Charset charset) {
            kotlin.jvm.internal.f0.p(string, "string");
            kotlin.jvm.internal.f0.p(charset, "charset");
            return j(string, charset);
        }

        @hk.h(name = "-deprecated_encodeUtf8")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @yt.k
        public final ByteString d(@yt.k String string) {
            kotlin.jvm.internal.f0.p(string, "string");
            return l(string);
        }

        @hk.h(name = "-deprecated_of")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @yt.k
        public final ByteString e(@yt.k ByteBuffer buffer) {
            kotlin.jvm.internal.f0.p(buffer, "buffer");
            return m(buffer);
        }

        @hk.h(name = "-deprecated_of")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @yt.k
        public final ByteString f(@yt.k byte[] array, int i10, int i11) {
            kotlin.jvm.internal.f0.p(array, "array");
            return o(array, i10, i11);
        }

        @hk.h(name = "-deprecated_read")
        @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @kotlin.t0(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @yt.k
        public final ByteString g(@yt.k InputStream inputstream, int i10) {
            kotlin.jvm.internal.f0.p(inputstream, "inputstream");
            return q(inputstream, i10);
        }

        @hk.m
        @yt.l
        public final ByteString h(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            byte[] bArrA = y0.a(str);
            if (bArrA != null) {
                return new ByteString(bArrA);
            }
            return null;
        }

        @hk.m
        @yt.k
        public final ByteString i(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            int i10 = 0;
            if (!(str.length() % 2 == 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("Unexpected hex string: ", str).toString());
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            int i11 = length - 1;
            if (i11 >= 0) {
                while (true) {
                    int i12 = i10 + 1;
                    int i13 = i10 * 2;
                    bArr[i10] = (byte) ((okio.internal.e.I(str.charAt(i13)) << 4) + okio.internal.e.I(str.charAt(i13 + 1)));
                    if (i12 > i11) {
                        break;
                    }
                    i10 = i12;
                }
            }
            return new ByteString(bArr);
        }

        @hk.h(name = "encodeString")
        @hk.m
        @yt.k
        public final ByteString j(@yt.k String str, @yt.k Charset charset) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            kotlin.jvm.internal.f0.p(charset, "charset");
            byte[] bytes = str.getBytes(charset);
            kotlin.jvm.internal.f0.o(bytes, "(this as java.lang.String).getBytes(charset)");
            return new ByteString(bytes);
        }

        @hk.m
        @yt.k
        public final ByteString l(@yt.k String str) {
            kotlin.jvm.internal.f0.p(str, "<this>");
            ByteString byteString = new ByteString(z0.a(str));
            byteString.t0(str);
            return byteString;
        }

        @hk.h(name = "of")
        @hk.m
        @yt.k
        public final ByteString m(@yt.k ByteBuffer byteBuffer) {
            kotlin.jvm.internal.f0.p(byteBuffer, "<this>");
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @hk.m
        @yt.k
        public final ByteString n(@yt.k byte... data) {
            kotlin.jvm.internal.f0.p(data, "data");
            byte[] bArrCopyOf = Arrays.copyOf(data, data.length);
            kotlin.jvm.internal.f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new ByteString(bArrCopyOf);
        }

        @hk.h(name = "of")
        @hk.m
        @yt.k
        public final ByteString o(@yt.k byte[] bArr, int i10, int i11) {
            kotlin.jvm.internal.f0.p(bArr, "<this>");
            a1.e(bArr.length, i10, i11);
            return new ByteString(kotlin.collections.m.G1(bArr, i10, i11 + i10));
        }

        @hk.h(name = "read")
        @hk.m
        @yt.k
        public final ByteString q(@yt.k InputStream inputStream, int i10) throws IOException {
            kotlin.jvm.internal.f0.p(inputStream, "<this>");
            int i11 = 0;
            if (!(i10 >= 0)) {
                throw new IllegalArgumentException(kotlin.jvm.internal.f0.C("byteCount < 0: ", Integer.valueOf(i10)).toString());
            }
            byte[] bArr = new byte[i10];
            while (i11 < i10) {
                int i12 = inputStream.read(bArr, i11, i10 - i11);
                if (i12 == -1) {
                    throw new EOFException();
                }
                i11 += i12;
            }
            return new ByteString(bArr);
        }
    }

    public ByteString(@yt.k byte[] data) {
        kotlin.jvm.internal.f0.p(data, "data");
        this.data = data;
    }

    public static /* synthetic */ ByteString G0(ByteString byteString, int i10, int i11, int i12, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
        }
        if ((i12 & 1) != 0) {
            i10 = 0;
        }
        if ((i12 & 2) != 0) {
            i11 = a1.f();
        }
        return byteString.F0(i10, i11);
    }

    public static /* synthetic */ int M(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return byteString.J(byteString2, i10);
    }

    public static /* synthetic */ int N(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        return byteString.L(bArr, i10);
    }

    public static /* synthetic */ int W(ByteString byteString, ByteString byteString2, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = a1.f();
        }
        return byteString.R(byteString2, i10);
    }

    public static /* synthetic */ int X(ByteString byteString, byte[] bArr, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i11 & 2) != 0) {
            i10 = a1.f();
        }
        return byteString.U(bArr, i10);
    }

    @hk.h(name = "of")
    @hk.m
    @yt.k
    public static final ByteString b0(@yt.k ByteBuffer byteBuffer) {
        return f44029c.m(byteBuffer);
    }

    @hk.m
    @yt.k
    public static final ByteString l0(@yt.k byte... bArr) {
        return f44029c.n(bArr);
    }

    public static /* synthetic */ void m(ByteString byteString, int i10, byte[] bArr, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyInto");
        }
        if ((i13 & 1) != 0) {
            i10 = 0;
        }
        if ((i13 & 4) != 0) {
            i11 = 0;
        }
        byteString.l(i10, bArr, i11, i12);
    }

    @hk.h(name = "of")
    @hk.m
    @yt.k
    public static final ByteString m0(@yt.k byte[] bArr, int i10, int i11) {
        return f44029c.o(bArr, i10, i11);
    }

    @hk.m
    @yt.l
    public static final ByteString n(@yt.k String str) {
        return f44029c.h(str);
    }

    @hk.m
    @yt.k
    public static final ByteString o(@yt.k String str) {
        return f44029c.i(str);
    }

    @hk.h(name = "encodeString")
    @hk.m
    @yt.k
    public static final ByteString q(@yt.k String str, @yt.k Charset charset) {
        return f44029c.j(str, charset);
    }

    @hk.h(name = "read")
    @hk.m
    @yt.k
    public static final ByteString q0(@yt.k InputStream inputStream, int i10) throws IOException {
        return f44029c.q(inputStream, i10);
    }

    @hk.m
    @yt.k
    public static final ByteString r(@yt.k String str) {
        return f44029c.l(str);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException {
        ByteString byteStringQ = f44029c.q(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, byteStringQ.data);
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @yt.l
    public final String A() {
        return this.f44032b;
    }

    public final boolean A0(@yt.k byte[] prefix) {
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        return p0(0, prefix, 0, prefix.length);
    }

    @yt.k
    public String B() {
        char[] cArr = new char[w().length * 2];
        byte[] bArrW = w();
        int length = bArrW.length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            byte b10 = bArrW[i10];
            i10++;
            int i12 = i11 + 1;
            cArr[i11] = okio.internal.e.J()[(b10 >> 4) & 15];
            i11 = i12 + 1;
            cArr[i12] = okio.internal.e.J()[b10 & 15];
        }
        return kotlin.text.u.u1(cArr);
    }

    @yt.k
    public String B0(@yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(charset, "charset");
        return new String(this.data, charset);
    }

    @yt.k
    public ByteString D(@yt.k String algorithm, @yt.k ByteString key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        kotlin.jvm.internal.f0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.N0(), algorithm));
            byte[] bArrDoFinal = mac.doFinal(this.data);
            kotlin.jvm.internal.f0.o(bArrDoFinal, "mac.doFinal(data)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @hk.i
    @yt.k
    public final ByteString D0() {
        return G0(this, 0, 0, 3, null);
    }

    @yt.k
    public ByteString E(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return D(hh.c.f31295a, key);
    }

    @hk.i
    @yt.k
    public final ByteString E0(int i10) {
        return G0(this, i10, 0, 2, null);
    }

    @hk.i
    @yt.k
    public ByteString F0(int i10, int i11) {
        int iL = a1.l(this, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException("beginIndex < 0".toString());
        }
        if (iL <= w().length) {
            if (iL - i10 >= 0) {
                return (i10 == 0 && iL == w().length) ? this : new ByteString(kotlin.collections.m.G1(w(), i10, iL));
            }
            throw new IllegalArgumentException("endIndex < beginIndex".toString());
        }
        throw new IllegalArgumentException(("endIndex > length(" + w().length + ')').toString());
    }

    @yt.k
    public ByteString G(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return D("HmacSHA256", key);
    }

    @yt.k
    public ByteString H(@yt.k ByteString key) {
        kotlin.jvm.internal.f0.p(key, "key");
        return D("HmacSHA512", key);
    }

    @hk.i
    public final int I(@yt.k ByteString other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return M(this, other, 0, 2, null);
    }

    @hk.i
    public final int J(@yt.k ByteString other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        return L(other.O(), i10);
    }

    @hk.i
    public final int K(@yt.k byte[] other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return N(this, other, 0, 2, null);
    }

    @yt.k
    public ByteString K0() {
        byte b10;
        for (int i10 = 0; i10 < w().length; i10++) {
            byte b11 = w()[i10];
            byte b12 = (byte) 65;
            if (b11 >= b12 && b11 <= (b10 = (byte) 90)) {
                byte[] bArrW = w();
                byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
                kotlin.jvm.internal.f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 + 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 + 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @hk.i
    public int L(@yt.k byte[] other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        int length = w().length - other.length;
        int iMax = Math.max(i10, 0);
        if (iMax <= length) {
            while (true) {
                int i11 = iMax + 1;
                if (a1.d(w(), iMax, other, 0, other.length)) {
                    return iMax;
                }
                if (iMax == length) {
                    break;
                }
                iMax = i11;
            }
        }
        return -1;
    }

    @yt.k
    public ByteString M0() {
        byte b10;
        for (int i10 = 0; i10 < w().length; i10++) {
            byte b11 = w()[i10];
            byte b12 = (byte) 97;
            if (b11 >= b12 && b11 <= (b10 = (byte) 122)) {
                byte[] bArrW = w();
                byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
                kotlin.jvm.internal.f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                bArrCopyOf[i10] = (byte) (b11 - 32);
                for (int i11 = i10 + 1; i11 < bArrCopyOf.length; i11++) {
                    byte b13 = bArrCopyOf[i11];
                    if (b13 >= b12 && b13 <= b10) {
                        bArrCopyOf[i11] = (byte) (b13 - 32);
                    }
                }
                return new ByteString(bArrCopyOf);
            }
        }
        return this;
    }

    @yt.k
    public byte[] N0() {
        byte[] bArrW = w();
        byte[] bArrCopyOf = Arrays.copyOf(bArrW, bArrW.length);
        kotlin.jvm.internal.f0.o(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return bArrCopyOf;
    }

    @yt.k
    public byte[] O() {
        return w();
    }

    @yt.k
    public String O0() {
        String strA = A();
        if (strA != null) {
            return strA;
        }
        String strC = z0.c(O());
        t0(strC);
        return strC;
    }

    public byte P(int i10) {
        return w()[i10];
    }

    public void P0(@yt.k OutputStream out) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        out.write(this.data);
    }

    @hk.i
    public final int Q(@yt.k ByteString other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return W(this, other, 0, 2, null);
    }

    public void Q0(@yt.k j buffer, int i10, int i11) {
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        okio.internal.e.H(this, buffer, i10, i11);
    }

    @hk.i
    public final int R(@yt.k ByteString other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        return U(other.O(), i10);
    }

    @hk.i
    public final int T(@yt.k byte[] other) {
        kotlin.jvm.internal.f0.p(other, "other");
        return X(this, other, 0, 2, null);
    }

    @hk.i
    public int U(@yt.k byte[] other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        int iMin = Math.min(a1.l(this, i10), w().length - other.length);
        if (iMin >= 0) {
            while (true) {
                int i11 = iMin - 1;
                if (a1.d(w(), iMin, other, 0, other.length)) {
                    return iMin;
                }
                if (i11 < 0) {
                    break;
                }
                iMin = i11;
            }
        }
        return -1;
    }

    @yt.k
    public final ByteString Z() {
        return p("MD5");
    }

    @hk.h(name = "-deprecated_getByte")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @kotlin.t0(expression = "this[index]", imports = {}))
    public final byte c(int i10) {
        return v(i10);
    }

    @hk.h(name = "-deprecated_size")
    @kotlin.k(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @kotlin.t0(expression = "size", imports = {}))
    public final int d() {
        return x0();
    }

    public boolean equals(@yt.l Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.x0() == w().length && byteString.p0(0, w(), 0, w().length)) {
                return true;
            }
        }
        return false;
    }

    @yt.k
    public ByteBuffer f() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(this.data).asReadOnlyBuffer();
        kotlin.jvm.internal.f0.o(byteBufferAsReadOnlyBuffer, "wrap(data).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @yt.k
    public String h() {
        return y0.c(w(), null, 1, null);
    }

    public int hashCode() {
        int iX = x();
        if (iX != 0) {
            return iX;
        }
        int iHashCode = Arrays.hashCode(w());
        r0(iHashCode);
        return iHashCode;
    }

    @yt.k
    public String i() {
        return y0.b(w(), y0.f());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0030 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0032 A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int compareTo(@yt.k okio.ByteString r10) {
        /*
            r9 = this;
            java.lang.String r0 = "other"
            kotlin.jvm.internal.f0.p(r10, r0)
            int r0 = r9.x0()
            int r1 = r10.x0()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        L13:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L2b
            byte r7 = r9.v(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.v(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L28
            int r4 = r4 + 1
            goto L13
        L28:
            if (r7 >= r8) goto L32
            goto L30
        L2b:
            if (r0 != r1) goto L2e
            goto L33
        L2e:
            if (r0 >= r1) goto L32
        L30:
            r3 = -1
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public void l(int i10, @yt.k byte[] target, int i11, int i12) {
        kotlin.jvm.internal.f0.p(target, "target");
        kotlin.collections.m.W0(w(), target, i11, i10, i12 + i10);
    }

    public boolean o0(int i10, @yt.k ByteString other, int i11, int i12) {
        kotlin.jvm.internal.f0.p(other, "other");
        return other.p0(i11, w(), i10, i12);
    }

    @yt.k
    public ByteString p(@yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        messageDigest.update(w(), 0, x0());
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.f0.o(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    public boolean p0(int i10, @yt.k byte[] other, int i11, int i12) {
        kotlin.jvm.internal.f0.p(other, "other");
        return i10 >= 0 && i10 <= w().length - i12 && i11 >= 0 && i11 <= other.length - i12 && a1.d(w(), i10, other, i11, i12);
    }

    public final void r0(int i10) {
        this.f44031a = i10;
    }

    public final boolean t(@yt.k ByteString suffix) {
        kotlin.jvm.internal.f0.p(suffix, "suffix");
        return o0(x0() - suffix.x0(), suffix, 0, suffix.x0());
    }

    public final void t0(@yt.l String str) {
        this.f44032b = str;
    }

    @yt.k
    public String toString() {
        String str;
        if (w().length == 0) {
            str = "[size=0]";
        } else {
            int iC = okio.internal.e.c(w(), 64);
            if (iC != -1) {
                String strO0 = O0();
                Objects.requireNonNull(strO0, "null cannot be cast to non-null type java.lang.String");
                String strSubstring = strO0.substring(0, iC);
                kotlin.jvm.internal.f0.o(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                String strL2 = kotlin.text.u.l2(kotlin.text.u.l2(kotlin.text.u.l2(strSubstring, "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
                if (iC >= strO0.length()) {
                    return "[text=" + strL2 + ']';
                }
                return "[size=" + w().length + " text=" + strL2 + "…]";
            }
            if (w().length > 64) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("[size=");
                sb2.append(w().length);
                sb2.append(" hex=");
                int iL = a1.l(this, 64);
                if (iL <= w().length) {
                    if (!(iL + 0 >= 0)) {
                        throw new IllegalArgumentException("endIndex < beginIndex".toString());
                    }
                    sb2.append((iL == w().length ? this : new ByteString(kotlin.collections.m.G1(w(), 0, iL))).B());
                    sb2.append("…]");
                    return sb2.toString();
                }
                throw new IllegalArgumentException(("endIndex > length(" + w().length + ')').toString());
            }
            str = "[hex=" + B() + ']';
        }
        return str;
    }

    public final boolean u(@yt.k byte[] suffix) {
        kotlin.jvm.internal.f0.p(suffix, "suffix");
        return p0(x0() - suffix.length, suffix, 0, suffix.length);
    }

    @yt.k
    public final ByteString u0() {
        return p(et.e.f27137f);
    }

    @hk.h(name = "getByte")
    public final byte v(int i10) {
        return P(i10);
    }

    @yt.k
    public final ByteString v0() {
        return p("SHA-256");
    }

    @yt.k
    public final byte[] w() {
        return this.data;
    }

    @yt.k
    public final ByteString w0() {
        return p("SHA-512");
    }

    public final int x() {
        return this.f44031a;
    }

    @hk.h(name = "size")
    public final int x0() {
        return y();
    }

    public int y() {
        return w().length;
    }

    public final boolean y0(@yt.k ByteString prefix) {
        kotlin.jvm.internal.f0.p(prefix, "prefix");
        return o0(0, prefix, 0, prefix.x0());
    }
}
