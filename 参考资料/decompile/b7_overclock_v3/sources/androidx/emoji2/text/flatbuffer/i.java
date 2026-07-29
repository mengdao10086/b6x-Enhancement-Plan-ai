package androidx.emoji2.text.flatbuffer;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ boolean f5457o = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f5458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f5461d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f5462e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f5463f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f5464g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f5465h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f5466i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f5467j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f5468k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f5469l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f5470m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Utf8 f5471n;

    public static class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f5472a;

        public a(ByteBuffer byteBuffer) {
            this.f5472a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.f5472a.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    public static abstract class b {
        public abstract ByteBuffer a(int i10);

        public void b(ByteBuffer byteBuffer) {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5473a = new c();

        @Override // androidx.emoji2.text.flatbuffer.i.b
        public ByteBuffer a(int i10) {
            return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public i(int i10, b bVar) {
        this(i10, bVar, null, Utf8.d());
    }

    public static ByteBuffer N(ByteBuffer byteBuffer, b bVar) {
        int iCapacity = byteBuffer.capacity();
        if (((-1073741824) & iCapacity) != 0) {
            throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
        }
        int i10 = iCapacity == 0 ? 1 : iCapacity << 1;
        byteBuffer.position(0);
        ByteBuffer byteBufferA = bVar.a(i10);
        byteBufferA.position(byteBufferA.clear().capacity() - iCapacity);
        byteBufferA.put(byteBuffer);
        return byteBufferA;
    }

    public static boolean P(u uVar, int i10) {
        return uVar.d(i10) != 0;
    }

    public int A(int[] iArr) {
        Q();
        h0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            n(iArr[length]);
        }
        return E();
    }

    public ByteBuffer B() {
        L();
        return this.f5458a;
    }

    @Deprecated
    public final int C() {
        L();
        return this.f5459b;
    }

    public int D() {
        int i10;
        if (this.f5461d == null || !this.f5463f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        j(0);
        int iR = R();
        int i11 = this.f5462e - 1;
        while (i11 >= 0 && this.f5461d[i11] == 0) {
            i11--;
        }
        int i12 = i11 + 1;
        while (i11 >= 0) {
            int[] iArr = this.f5461d;
            q((short) (iArr[i11] != 0 ? iR - iArr[i11] : 0));
            i11--;
        }
        q((short) (iR - this.f5465h));
        q((short) ((i12 + 2) * 2));
        int i13 = 0;
        loop2: while (true) {
            if (i13 >= this.f5467j) {
                i10 = 0;
                break;
            }
            int iCapacity = this.f5458a.capacity() - this.f5466i[i13];
            int i14 = this.f5459b;
            short s10 = this.f5458a.getShort(iCapacity);
            if (s10 == this.f5458a.getShort(i14)) {
                for (int i15 = 2; i15 < s10; i15 += 2) {
                    if (this.f5458a.getShort(iCapacity + i15) != this.f5458a.getShort(i14 + i15)) {
                        break;
                    }
                }
                i10 = this.f5466i[i13];
                break loop2;
            }
            i13++;
        }
        if (i10 != 0) {
            int iCapacity2 = this.f5458a.capacity() - iR;
            this.f5459b = iCapacity2;
            this.f5458a.putInt(iCapacity2, i10 - iR);
        } else {
            int i16 = this.f5467j;
            int[] iArr2 = this.f5466i;
            if (i16 == iArr2.length) {
                this.f5466i = Arrays.copyOf(iArr2, i16 * 2);
            }
            int[] iArr3 = this.f5466i;
            int i17 = this.f5467j;
            this.f5467j = i17 + 1;
            iArr3[i17] = R();
            ByteBuffer byteBuffer = this.f5458a;
            byteBuffer.putInt(byteBuffer.capacity() - iR, R() - iR);
        }
        this.f5463f = false;
        return iR;
    }

    public int E() {
        if (!this.f5463f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f5463f = false;
        Y(this.f5468k);
        return R();
    }

    public void F(int i10) {
        I(i10, false);
    }

    public void G(int i10, String str) {
        H(i10, str, false);
    }

    public void H(int i10, String str, boolean z10) {
        T(this.f5460c, (z10 ? 4 : 0) + 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i11 = 3; i11 >= 0; i11--) {
            d((byte) str.charAt(i11));
        }
        I(i10, z10);
    }

    public void I(int i10, boolean z10) {
        T(this.f5460c, (z10 ? 4 : 0) + 4);
        n(i10);
        if (z10) {
            j(this.f5458a.capacity() - this.f5459b);
        }
        this.f5458a.position(this.f5459b);
        this.f5464g = true;
    }

    public void J(int i10) {
        I(i10, true);
    }

    public void K(int i10, String str) {
        H(i10, str, true);
    }

    public void L() {
        if (!this.f5464g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public i M(boolean z10) {
        this.f5469l = z10;
        return this;
    }

    public i O(ByteBuffer byteBuffer, b bVar) {
        this.f5470m = bVar;
        this.f5458a = byteBuffer;
        byteBuffer.clear();
        this.f5458a.order(ByteOrder.LITTLE_ENDIAN);
        this.f5460c = 1;
        this.f5459b = this.f5458a.capacity();
        this.f5462e = 0;
        this.f5463f = false;
        this.f5464g = false;
        this.f5465h = 0;
        this.f5467j = 0;
        this.f5468k = 0;
        return this;
    }

    public void Q() {
        if (this.f5463f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int R() {
        return this.f5458a.capacity() - this.f5459b;
    }

    public void S(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBuffer = this.f5458a;
            int i12 = this.f5459b - 1;
            this.f5459b = i12;
            byteBuffer.put(i12, (byte) 0);
        }
    }

    public void T(int i10, int i11) {
        if (i10 > this.f5460c) {
            this.f5460c = i10;
        }
        int i12 = ((~((this.f5458a.capacity() - this.f5459b) + i11)) + 1) & (i10 - 1);
        while (this.f5459b < i12 + i10 + i11) {
            int iCapacity = this.f5458a.capacity();
            ByteBuffer byteBuffer = this.f5458a;
            ByteBuffer byteBufferN = N(byteBuffer, this.f5470m);
            this.f5458a = byteBufferN;
            if (byteBuffer != byteBufferN) {
                this.f5470m.b(byteBuffer);
            }
            this.f5459b += this.f5458a.capacity() - iCapacity;
        }
        S(i12);
    }

    public void U(boolean z10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 1;
        this.f5459b = i10;
        byteBuffer.put(i10, z10 ? (byte) 1 : (byte) 0);
    }

    public void V(byte b10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 1;
        this.f5459b = i10;
        byteBuffer.put(i10, b10);
    }

    public void W(double d10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 8;
        this.f5459b = i10;
        byteBuffer.putDouble(i10, d10);
    }

    public void X(float f10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 4;
        this.f5459b = i10;
        byteBuffer.putFloat(i10, f10);
    }

    public void Y(int i10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i11 = this.f5459b - 4;
        this.f5459b = i11;
        byteBuffer.putInt(i11, i10);
    }

    public void Z(long j10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 8;
        this.f5459b = i10;
        byteBuffer.putLong(i10, j10);
    }

    public void a(int i10) {
        if (i10 != R()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void a0(short s10) {
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - 2;
        this.f5459b = i10;
        byteBuffer.putShort(i10, s10);
    }

    public void b(int i10, boolean z10, boolean z11) {
        if (this.f5469l || z10 != z11) {
            c(z10);
            f0(i10);
        }
    }

    public void b0(int i10, int i11) {
        int iCapacity = this.f5458a.capacity() - i10;
        if (this.f5458a.getShort((iCapacity - this.f5458a.getInt(iCapacity)) + i11) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i11 + " must be set");
    }

    public void c(boolean z10) {
        T(1, 0);
        U(z10);
    }

    public byte[] c0() {
        return d0(this.f5459b, this.f5458a.capacity() - this.f5459b);
    }

    public void d(byte b10) {
        T(1, 0);
        V(b10);
    }

    public byte[] d0(int i10, int i11) {
        L();
        byte[] bArr = new byte[i11];
        this.f5458a.position(i10);
        this.f5458a.get(bArr);
        return bArr;
    }

    public void e(int i10, byte b10, int i11) {
        if (this.f5469l || b10 != i11) {
            d(b10);
            f0(i10);
        }
    }

    public InputStream e0() {
        L();
        ByteBuffer byteBufferDuplicate = this.f5458a.duplicate();
        byteBufferDuplicate.position(this.f5459b);
        byteBufferDuplicate.limit(this.f5458a.capacity());
        return new a(byteBufferDuplicate);
    }

    public void f(double d10) {
        T(8, 0);
        W(d10);
    }

    public void f0(int i10) {
        this.f5461d[i10] = R();
    }

    public void g(int i10, double d10, double d11) {
        if (this.f5469l || d10 != d11) {
            f(d10);
            f0(i10);
        }
    }

    public void g0(int i10) {
        Q();
        int[] iArr = this.f5461d;
        if (iArr == null || iArr.length < i10) {
            this.f5461d = new int[i10];
        }
        this.f5462e = i10;
        Arrays.fill(this.f5461d, 0, i10, 0);
        this.f5463f = true;
        this.f5465h = R();
    }

    public void h(float f10) {
        T(4, 0);
        X(f10);
    }

    public void h0(int i10, int i11, int i12) {
        Q();
        this.f5468k = i11;
        int i13 = i10 * i11;
        T(4, i13);
        T(i12, i13);
        this.f5463f = true;
    }

    public void i(int i10, float f10, double d10) {
        if (this.f5469l || f10 != d10) {
            h(f10);
            f0(i10);
        }
    }

    public void j(int i10) {
        T(4, 0);
        Y(i10);
    }

    public void k(int i10, int i11, int i12) {
        if (this.f5469l || i11 != i12) {
            j(i11);
            f0(i10);
        }
    }

    public void l(int i10, long j10, long j11) {
        if (this.f5469l || j10 != j11) {
            m(j10);
            f0(i10);
        }
    }

    public void m(long j10) {
        T(8, 0);
        Z(j10);
    }

    public void n(int i10) {
        T(4, 0);
        Y((R() - i10) + 4);
    }

    public void o(int i10, int i11, int i12) {
        if (this.f5469l || i11 != i12) {
            n(i11);
            f0(i10);
        }
    }

    public void p(int i10, short s10, int i11) {
        if (this.f5469l || s10 != i11) {
            q(s10);
            f0(i10);
        }
    }

    public void q(short s10) {
        T(2, 0);
        a0(s10);
    }

    public void r(int i10, int i11, int i12) {
        if (i11 != i12) {
            a(i11);
            f0(i10);
        }
    }

    public void s() {
        this.f5459b = this.f5458a.capacity();
        this.f5458a.clear();
        this.f5460c = 1;
        while (true) {
            int i10 = this.f5462e;
            if (i10 <= 0) {
                this.f5462e = 0;
                this.f5463f = false;
                this.f5464g = false;
                this.f5465h = 0;
                this.f5467j = 0;
                this.f5468k = 0;
                return;
            }
            int[] iArr = this.f5461d;
            int i11 = i10 - 1;
            this.f5462e = i11;
            iArr[i11] = 0;
        }
    }

    public int t(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        h0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f5458a;
        int i10 = this.f5459b - iRemaining;
        this.f5459b = i10;
        byteBuffer2.position(i10);
        this.f5458a.put(byteBuffer);
        return E();
    }

    public int u(byte[] bArr) {
        int length = bArr.length;
        h0(1, length, 1);
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - length;
        this.f5459b = i10;
        byteBuffer.position(i10);
        this.f5458a.put(bArr);
        return E();
    }

    public int v(byte[] bArr, int i10, int i11) {
        h0(1, i11, 1);
        ByteBuffer byteBuffer = this.f5458a;
        int i12 = this.f5459b - i11;
        this.f5459b = i12;
        byteBuffer.position(i12);
        this.f5458a.put(bArr, i10, i11);
        return E();
    }

    public <T extends u> int w(T t10, int[] iArr) {
        t10.t(iArr, this.f5458a);
        return A(iArr);
    }

    public int x(CharSequence charSequence) {
        int iC = this.f5471n.c(charSequence);
        d((byte) 0);
        h0(1, iC, 1);
        ByteBuffer byteBuffer = this.f5458a;
        int i10 = this.f5459b - iC;
        this.f5459b = i10;
        byteBuffer.position(i10);
        this.f5471n.b(charSequence, this.f5458a);
        return E();
    }

    public int y(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        d((byte) 0);
        h0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f5458a;
        int i10 = this.f5459b - iRemaining;
        this.f5459b = i10;
        byteBuffer2.position(i10);
        this.f5458a.put(byteBuffer);
        return E();
    }

    public ByteBuffer z(int i10, int i11, int i12) {
        int i13 = i10 * i11;
        h0(i10, i11, i12);
        ByteBuffer byteBuffer = this.f5458a;
        int i14 = this.f5459b - i13;
        this.f5459b = i14;
        byteBuffer.position(i14);
        ByteBuffer byteBufferOrder = this.f5458a.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i13);
        return byteBufferOrder;
    }

    public i(int i10, b bVar, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f5460c = 1;
        this.f5461d = null;
        this.f5462e = 0;
        this.f5463f = false;
        this.f5464g = false;
        this.f5466i = new int[16];
        this.f5467j = 0;
        this.f5468k = 0;
        this.f5469l = false;
        i10 = i10 <= 0 ? 1 : i10;
        this.f5470m = bVar;
        if (byteBuffer != null) {
            this.f5458a = byteBuffer;
            byteBuffer.clear();
            this.f5458a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f5458a = bVar.a(i10);
        }
        this.f5471n = utf8;
        this.f5459b = this.f5458a.capacity();
    }

    public i(int i10) {
        this(i10, c.f5473a, null, Utf8.d());
    }

    public i() {
        this(1024);
    }

    public i(ByteBuffer byteBuffer, b bVar) {
        this(byteBuffer.capacity(), bVar, byteBuffer, Utf8.d());
    }

    public i(ByteBuffer byteBuffer) {
        this(byteBuffer, new c());
    }
}
