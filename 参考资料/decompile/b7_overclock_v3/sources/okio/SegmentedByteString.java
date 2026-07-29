package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import w.w;

/* JADX INFO: loaded from: classes5.dex */
@kotlin.d0(bv = {}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0=\u0012\u0006\u0010G\u001a\u00020C¢\u0006\u0004\bH\u0010IJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0001H\u0016J\b\u0010\u000b\u001a\u00020\u0001H\u0016J\u0017\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u0006H\u0010¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0010\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0006H\u0016J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0016J\u0017\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010\"\u001a\u00020!H\u0016J'\u0010)\u001a\u00020#2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0010¢\u0006\u0004\b)\u0010*J(\u0010.\u001a\u00020-2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016J(\u0010/\u001a\u00020-2\u0006\u0010'\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016J(\u00102\u001a\u00020#2\u0006\u0010'\u001a\u00020\u00132\u0006\u00100\u001a\u00020\u001d2\u0006\u00101\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\u0013H\u0016J\u0018\u00104\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0013H\u0016J\u0018\u00105\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u001d2\u0006\u00103\u001a\u00020\u0013H\u0016J\u000f\u00106\u001a\u00020\u001dH\u0010¢\u0006\u0004\b6\u00107J\u0013\u00109\u001a\u00020-2\b\u0010+\u001a\u0004\u0018\u000108H\u0096\u0002J\b\u0010:\u001a\u00020\u0013H\u0016J\b\u0010;\u001a\u00020\u0006H\u0016J\b\u0010<\u001a\u00020\u0001H\u0002R \u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0=8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u001a\u0010G\u001a\u00020C8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010D\u001a\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lokio/SegmentedByteString;", "Lokio/ByteString;", "Ljava/lang/Object;", "writeReplace", "Ljava/nio/charset/Charset;", "charset", "", "B0", "h", "B", "K0", "M0", "algorithm", "p", "(Ljava/lang/String;)Lokio/ByteString;", "key", "D", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "i", "", "beginIndex", "endIndex", "F0", "pos", "", "P", "(I)B", "y", "()I", "", "N0", "Ljava/nio/ByteBuffer;", "f", "Ljava/io/OutputStream;", "out", "Lkotlin/z1;", "P0", "Lokio/j;", "buffer", w.c.R, "byteCount", "Q0", "(Lokio/j;II)V", "other", "otherOffset", "", "o0", "p0", "target", "targetOffset", com.flydigi.sdk.bluetooth.l.f16298a, "fromIndex", "L", "U", "O", "()[B", "", "equals", "hashCode", "toString", "T0", "", "e", "[[B", "S0", "()[[B", "segments", "", "[I", "R0", "()[I", "directory", "<init>", "([[B[I)V", "okio"}, k = 1, mv = {1, 5, 1})
public final class SegmentedByteString extends ByteString {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @yt.k
    public final transient byte[][] f44034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @yt.k
    public final transient int[] f44035f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(@yt.k byte[][] segments, @yt.k int[] directory) {
        super(ByteString.f44030d.w());
        kotlin.jvm.internal.f0.p(segments, "segments");
        kotlin.jvm.internal.f0.p(directory, "directory");
        this.f44034e = segments;
        this.f44035f = directory;
    }

    private final Object writeReplace() {
        return T0();
    }

    @Override // okio.ByteString
    @yt.k
    public String B() {
        return T0().B();
    }

    @Override // okio.ByteString
    @yt.k
    public String B0(@yt.k Charset charset) {
        kotlin.jvm.internal.f0.p(charset, "charset");
        return T0().B0(charset);
    }

    @Override // okio.ByteString
    @yt.k
    public ByteString D(@yt.k String algorithm, @yt.k ByteString key) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        kotlin.jvm.internal.f0.p(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.N0(), algorithm));
            int length = S0().length;
            int i10 = 0;
            int i11 = 0;
            while (i10 < length) {
                int i12 = R0()[length + i10];
                int i13 = R0()[i10];
                mac.update(S0()[i10], i12, i13 - i11);
                i10++;
                i11 = i13;
            }
            byte[] bArrDoFinal = mac.doFinal();
            kotlin.jvm.internal.f0.o(bArrDoFinal, "mac.doFinal()");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e10) {
            throw new IllegalArgumentException(e10);
        }
    }

    @Override // okio.ByteString
    @yt.k
    public ByteString F0(int i10, int i11) {
        int iL = a1.l(this, i11);
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i10 + " < 0").toString());
        }
        if (!(iL <= x0())) {
            throw new IllegalArgumentException(("endIndex=" + iL + " > length(" + x0() + ')').toString());
        }
        int i12 = iL - i10;
        if (!(i12 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + iL + " < beginIndex=" + i10).toString());
        }
        if (i10 == 0 && iL == x0()) {
            return this;
        }
        if (i10 == iL) {
            return ByteString.f44030d;
        }
        int iN = okio.internal.i.n(this, i10);
        int iN2 = okio.internal.i.n(this, iL - 1);
        byte[][] bArr = (byte[][]) kotlin.collections.m.M1(S0(), iN, iN2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iN <= iN2) {
            int i13 = iN;
            int i14 = 0;
            while (true) {
                int i15 = i13 + 1;
                iArr[i14] = Math.min(R0()[i13] - i10, i12);
                int i16 = i14 + 1;
                iArr[i14 + bArr.length] = R0()[S0().length + i13];
                if (i13 == iN2) {
                    break;
                }
                i13 = i15;
                i14 = i16;
            }
        }
        int i17 = iN != 0 ? R0()[iN - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i10 - i17);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    @yt.k
    public ByteString K0() {
        return T0().K0();
    }

    @Override // okio.ByteString
    public int L(@yt.k byte[] other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        return T0().L(other, i10);
    }

    @Override // okio.ByteString
    @yt.k
    public ByteString M0() {
        return T0().M0();
    }

    @Override // okio.ByteString
    @yt.k
    public byte[] N0() {
        byte[] bArr = new byte[x0()];
        int length = S0().length;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i10 < length) {
            int i13 = R0()[length + i10];
            int i14 = R0()[i10];
            int i15 = i14 - i11;
            kotlin.collections.m.W0(S0()[i10], bArr, i12, i13, i13 + i15);
            i12 += i15;
            i10++;
            i11 = i14;
        }
        return bArr;
    }

    @Override // okio.ByteString
    @yt.k
    public byte[] O() {
        return N0();
    }

    @Override // okio.ByteString
    public byte P(int i10) {
        a1.e(R0()[S0().length - 1], i10, 1L);
        int iN = okio.internal.i.n(this, i10);
        return S0()[iN][(i10 - (iN == 0 ? 0 : R0()[iN - 1])) + R0()[S0().length + iN]];
    }

    @Override // okio.ByteString
    public void P0(@yt.k OutputStream out) throws IOException {
        kotlin.jvm.internal.f0.p(out, "out");
        int length = S0().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = R0()[length + i10];
            int i13 = R0()[i10];
            out.write(S0()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
    }

    @Override // okio.ByteString
    public void Q0(@yt.k j buffer, int i10, int i11) {
        kotlin.jvm.internal.f0.p(buffer, "buffer");
        int i12 = i10 + i11;
        int iN = okio.internal.i.n(this, i10);
        while (i10 < i12) {
            int i13 = iN == 0 ? 0 : R0()[iN - 1];
            int i14 = R0()[iN] - i13;
            int i15 = R0()[S0().length + iN];
            int iMin = Math.min(i12, i14 + i13) - i10;
            int i16 = i15 + (i10 - i13);
            p0 p0Var = new p0(S0()[iN], i16, i16 + iMin, true, false);
            p0 p0Var2 = buffer.f44116a;
            if (p0Var2 == null) {
                p0Var.f44180g = p0Var;
                p0Var.f44179f = p0Var;
                buffer.f44116a = p0Var;
            } else {
                kotlin.jvm.internal.f0.m(p0Var2);
                p0 p0Var3 = p0Var2.f44180g;
                kotlin.jvm.internal.f0.m(p0Var3);
                p0Var3.c(p0Var);
            }
            i10 += iMin;
            iN++;
        }
        buffer.i2(buffer.m2() + ((long) i11));
    }

    @yt.k
    public final int[] R0() {
        return this.f44035f;
    }

    @yt.k
    public final byte[][] S0() {
        return this.f44034e;
    }

    public final ByteString T0() {
        return new ByteString(N0());
    }

    @Override // okio.ByteString
    public int U(@yt.k byte[] other, int i10) {
        kotlin.jvm.internal.f0.p(other, "other");
        return T0().U(other, i10);
    }

    @Override // okio.ByteString
    public boolean equals(@yt.l Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.x0() == x0() && o0(0, byteString, 0, x0())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    @yt.k
    public ByteBuffer f() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(N0()).asReadOnlyBuffer();
        kotlin.jvm.internal.f0.o(byteBufferAsReadOnlyBuffer, "wrap(toByteArray()).asReadOnlyBuffer()");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // okio.ByteString
    @yt.k
    public String h() {
        return T0().h();
    }

    @Override // okio.ByteString
    public int hashCode() {
        int iX = x();
        if (iX != 0) {
            return iX;
        }
        int length = S0().length;
        int i10 = 0;
        int i11 = 1;
        int i12 = 0;
        while (i10 < length) {
            int i13 = R0()[length + i10];
            int i14 = R0()[i10];
            byte[] bArr = S0()[i10];
            int i15 = (i14 - i12) + i13;
            while (i13 < i15) {
                i11 = (i11 * 31) + bArr[i13];
                i13++;
            }
            i10++;
            i12 = i14;
        }
        r0(i11);
        return i11;
    }

    @Override // okio.ByteString
    @yt.k
    public String i() {
        return T0().i();
    }

    @Override // okio.ByteString
    public void l(int i10, @yt.k byte[] target, int i11, int i12) {
        kotlin.jvm.internal.f0.p(target, "target");
        long j10 = i12;
        a1.e(x0(), i10, j10);
        a1.e(target.length, i11, j10);
        int i13 = i12 + i10;
        int iN = okio.internal.i.n(this, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : R0()[iN - 1];
            int i15 = R0()[iN] - i14;
            int i16 = R0()[S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            int i17 = i16 + (i10 - i14);
            kotlin.collections.m.W0(S0()[iN], target, i11, i17, i17 + iMin);
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
    }

    @Override // okio.ByteString
    public boolean o0(int i10, @yt.k ByteString other, int i11, int i12) {
        kotlin.jvm.internal.f0.p(other, "other");
        if (i10 < 0 || i10 > x0() - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iN = okio.internal.i.n(this, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : R0()[iN - 1];
            int i15 = R0()[iN] - i14;
            int i16 = R0()[S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!other.p0(i11, S0()[iN], i16 + (i10 - i14), iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
        return true;
    }

    @Override // okio.ByteString
    @yt.k
    public ByteString p(@yt.k String algorithm) throws NoSuchAlgorithmException {
        kotlin.jvm.internal.f0.p(algorithm, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        int length = S0().length;
        int i10 = 0;
        int i11 = 0;
        while (i10 < length) {
            int i12 = R0()[length + i10];
            int i13 = R0()[i10];
            messageDigest.update(S0()[i10], i12, i13 - i11);
            i10++;
            i11 = i13;
        }
        byte[] digestBytes = messageDigest.digest();
        kotlin.jvm.internal.f0.o(digestBytes, "digestBytes");
        return new ByteString(digestBytes);
    }

    @Override // okio.ByteString
    public boolean p0(int i10, @yt.k byte[] other, int i11, int i12) {
        kotlin.jvm.internal.f0.p(other, "other");
        if (i10 < 0 || i10 > x0() - i12 || i11 < 0 || i11 > other.length - i12) {
            return false;
        }
        int i13 = i12 + i10;
        int iN = okio.internal.i.n(this, i10);
        while (i10 < i13) {
            int i14 = iN == 0 ? 0 : R0()[iN - 1];
            int i15 = R0()[iN] - i14;
            int i16 = R0()[S0().length + iN];
            int iMin = Math.min(i13, i15 + i14) - i10;
            if (!a1.d(S0()[iN], i16 + (i10 - i14), other, i11, iMin)) {
                return false;
            }
            i11 += iMin;
            i10 += iMin;
            iN++;
        }
        return true;
    }

    @Override // okio.ByteString
    @yt.k
    public String toString() {
        return T0().toString();
    }

    @Override // okio.ByteString
    public int y() {
        return R0()[S0().length - 1];
    }
}
