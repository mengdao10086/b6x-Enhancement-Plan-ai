package io.objectbox.flatbuffers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public class i {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f32714p = 2147483639;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f32715q = 1024;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final /* synthetic */ boolean f32716r = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ByteBuffer f32717a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32718b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32719c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f32720d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f32721e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f32722f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f32723g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f32724h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int[] f32725i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f32726j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f32727k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f32728l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public b f32729m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Utf8 f32730n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Map<String, Integer> f32731o;

    public static class a extends InputStream {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ByteBuffer f32732a;

        public a(ByteBuffer byteBuffer) {
            this.f32732a = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.f32732a.get() & 255;
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
        public static final c f32733a = new c();

        @Override // io.objectbox.flatbuffers.i.b
        public ByteBuffer a(int i10) {
            return ByteBuffer.allocate(i10).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public i(int i10, b bVar) {
        this(i10, bVar, null, Utf8.e());
    }

    public static ByteBuffer O(ByteBuffer byteBuffer, b bVar) {
        int i10;
        int iCapacity = byteBuffer.capacity();
        if (iCapacity == 0) {
            i10 = 1024;
        } else {
            i10 = 2147483639;
            if (iCapacity == 2147483639) {
                throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            }
            if (((-1073741824) & iCapacity) == 0) {
                i10 = iCapacity << 1;
            }
        }
        byteBuffer.position(0);
        ByteBuffer byteBufferA = bVar.a(i10);
        byteBufferA.position(byteBufferA.clear().capacity() - iCapacity);
        byteBufferA.put(byteBuffer);
        return byteBufferA;
    }

    public static boolean Q(s sVar, int i10) {
        return sVar.d(i10) != 0;
    }

    public ByteBuffer A(int i10, int i11, int i12) {
        int i13 = i10 * i11;
        i0(i10, i11, i12);
        ByteBuffer byteBuffer = this.f32717a;
        int i14 = this.f32718b - i13;
        this.f32718b = i14;
        byteBuffer.position(i14);
        ByteBuffer byteBufferOrder = this.f32717a.slice().order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.limit(i13);
        return byteBufferOrder;
    }

    public int B(int[] iArr) {
        R();
        i0(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            n(iArr[length]);
        }
        return F();
    }

    public ByteBuffer C() {
        M();
        return this.f32717a;
    }

    @Deprecated
    public final int D() {
        M();
        return this.f32718b;
    }

    public int E() {
        int i10;
        if (this.f32720d == null || !this.f32722f) {
            throw new AssertionError("FlatBuffers: endTable called without startTable");
        }
        j(0);
        int iS = S();
        int i11 = this.f32721e - 1;
        while (i11 >= 0 && this.f32720d[i11] == 0) {
            i11--;
        }
        int i12 = i11 + 1;
        while (i11 >= 0) {
            int[] iArr = this.f32720d;
            q((short) (iArr[i11] != 0 ? iS - iArr[i11] : 0));
            i11--;
        }
        q((short) (iS - this.f32724h));
        q((short) ((i12 + 2) * 2));
        int i13 = 0;
        loop2: while (true) {
            if (i13 >= this.f32726j) {
                i10 = 0;
                break;
            }
            int iCapacity = this.f32717a.capacity() - this.f32725i[i13];
            int i14 = this.f32718b;
            short s10 = this.f32717a.getShort(iCapacity);
            if (s10 == this.f32717a.getShort(i14)) {
                for (int i15 = 2; i15 < s10; i15 += 2) {
                    if (this.f32717a.getShort(iCapacity + i15) != this.f32717a.getShort(i14 + i15)) {
                        break;
                    }
                }
                i10 = this.f32725i[i13];
                break loop2;
            }
            i13++;
        }
        if (i10 != 0) {
            int iCapacity2 = this.f32717a.capacity() - iS;
            this.f32718b = iCapacity2;
            this.f32717a.putInt(iCapacity2, i10 - iS);
        } else {
            int i16 = this.f32726j;
            int[] iArr2 = this.f32725i;
            if (i16 == iArr2.length) {
                this.f32725i = Arrays.copyOf(iArr2, i16 * 2);
            }
            int[] iArr3 = this.f32725i;
            int i17 = this.f32726j;
            this.f32726j = i17 + 1;
            iArr3[i17] = S();
            ByteBuffer byteBuffer = this.f32717a;
            byteBuffer.putInt(byteBuffer.capacity() - iS, S() - iS);
        }
        this.f32722f = false;
        return iS;
    }

    public int F() {
        if (!this.f32722f) {
            throw new AssertionError("FlatBuffers: endVector called without startVector");
        }
        this.f32722f = false;
        Z(this.f32727k);
        return S();
    }

    public void G(int i10) {
        J(i10, false);
    }

    public void H(int i10, String str) {
        I(i10, str, false);
    }

    public void I(int i10, String str, boolean z10) {
        U(this.f32719c, (z10 ? 4 : 0) + 8);
        if (str.length() != 4) {
            throw new AssertionError("FlatBuffers: file identifier must be length 4");
        }
        for (int i11 = 3; i11 >= 0; i11--) {
            d((byte) str.charAt(i11));
        }
        J(i10, z10);
    }

    public void J(int i10, boolean z10) {
        U(this.f32719c, (z10 ? 4 : 0) + 4);
        n(i10);
        if (z10) {
            j(this.f32717a.capacity() - this.f32718b);
        }
        this.f32717a.position(this.f32718b);
        this.f32723g = true;
    }

    public void K(int i10) {
        J(i10, true);
    }

    public void L(int i10, String str) {
        I(i10, str, true);
    }

    public void M() {
        if (!this.f32723g) {
            throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
        }
    }

    public i N(boolean z10) {
        this.f32728l = z10;
        return this;
    }

    public i P(ByteBuffer byteBuffer, b bVar) {
        this.f32729m = bVar;
        this.f32717a = byteBuffer;
        byteBuffer.clear();
        this.f32717a.order(ByteOrder.LITTLE_ENDIAN);
        this.f32719c = 1;
        this.f32718b = this.f32717a.capacity();
        this.f32721e = 0;
        this.f32722f = false;
        this.f32723g = false;
        this.f32724h = 0;
        this.f32726j = 0;
        this.f32727k = 0;
        Map<String, Integer> map = this.f32731o;
        if (map != null) {
            map.clear();
        }
        return this;
    }

    public void R() {
        if (this.f32722f) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int S() {
        return this.f32717a.capacity() - this.f32718b;
    }

    public void T(int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            ByteBuffer byteBuffer = this.f32717a;
            int i12 = this.f32718b - 1;
            this.f32718b = i12;
            byteBuffer.put(i12, (byte) 0);
        }
    }

    public void U(int i10, int i11) {
        if (i10 > this.f32719c) {
            this.f32719c = i10;
        }
        int i12 = ((~((this.f32717a.capacity() - this.f32718b) + i11)) + 1) & (i10 - 1);
        while (this.f32718b < i12 + i10 + i11) {
            int iCapacity = this.f32717a.capacity();
            ByteBuffer byteBuffer = this.f32717a;
            ByteBuffer byteBufferO = O(byteBuffer, this.f32729m);
            this.f32717a = byteBufferO;
            if (byteBuffer != byteBufferO) {
                this.f32729m.b(byteBuffer);
            }
            this.f32718b += this.f32717a.capacity() - iCapacity;
        }
        T(i12);
    }

    public void V(boolean z10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 1;
        this.f32718b = i10;
        byteBuffer.put(i10, z10 ? (byte) 1 : (byte) 0);
    }

    public void W(byte b10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 1;
        this.f32718b = i10;
        byteBuffer.put(i10, b10);
    }

    public void X(double d10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 8;
        this.f32718b = i10;
        byteBuffer.putDouble(i10, d10);
    }

    public void Y(float f10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 4;
        this.f32718b = i10;
        byteBuffer.putFloat(i10, f10);
    }

    public void Z(int i10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i11 = this.f32718b - 4;
        this.f32718b = i11;
        byteBuffer.putInt(i11, i10);
    }

    public void a(int i10) {
        if (i10 != S()) {
            throw new AssertionError("FlatBuffers: struct must be serialized inline.");
        }
    }

    public void a0(long j10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 8;
        this.f32718b = i10;
        byteBuffer.putLong(i10, j10);
    }

    public void b(int i10, boolean z10, boolean z11) {
        if (this.f32728l || z10 != z11) {
            c(z10);
            g0(i10);
        }
    }

    public void b0(short s10) {
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - 2;
        this.f32718b = i10;
        byteBuffer.putShort(i10, s10);
    }

    public void c(boolean z10) {
        U(1, 0);
        V(z10);
    }

    public void c0(int i10, int i11) {
        int iCapacity = this.f32717a.capacity() - i10;
        if (this.f32717a.getShort((iCapacity - this.f32717a.getInt(iCapacity)) + i11) != 0) {
            return;
        }
        throw new AssertionError("FlatBuffers: field " + i11 + " must be set");
    }

    public void d(byte b10) {
        U(1, 0);
        W(b10);
    }

    public byte[] d0() {
        return e0(this.f32718b, this.f32717a.capacity() - this.f32718b);
    }

    public void e(int i10, byte b10, int i11) {
        if (this.f32728l || b10 != i11) {
            d(b10);
            g0(i10);
        }
    }

    public byte[] e0(int i10, int i11) {
        M();
        byte[] bArr = new byte[i11];
        this.f32717a.position(i10);
        this.f32717a.get(bArr);
        return bArr;
    }

    public void f(double d10) {
        U(8, 0);
        X(d10);
    }

    public InputStream f0() {
        M();
        ByteBuffer byteBufferDuplicate = this.f32717a.duplicate();
        byteBufferDuplicate.position(this.f32718b);
        byteBufferDuplicate.limit(this.f32717a.capacity());
        return new a(byteBufferDuplicate);
    }

    public void g(int i10, double d10, double d11) {
        if (this.f32728l || d10 != d11) {
            f(d10);
            g0(i10);
        }
    }

    public void g0(int i10) {
        this.f32720d[i10] = S();
    }

    public void h(float f10) {
        U(4, 0);
        Y(f10);
    }

    public void h0(int i10) {
        R();
        int[] iArr = this.f32720d;
        if (iArr == null || iArr.length < i10) {
            this.f32720d = new int[i10];
        }
        this.f32721e = i10;
        Arrays.fill(this.f32720d, 0, i10, 0);
        this.f32722f = true;
        this.f32724h = S();
    }

    public void i(int i10, float f10, double d10) {
        if (this.f32728l || f10 != d10) {
            h(f10);
            g0(i10);
        }
    }

    public void i0(int i10, int i11, int i12) {
        R();
        this.f32727k = i11;
        int i13 = i10 * i11;
        U(4, i13);
        U(i12, i13);
        this.f32722f = true;
    }

    public void j(int i10) {
        U(4, 0);
        Z(i10);
    }

    public void k(int i10, int i11, int i12) {
        if (this.f32728l || i11 != i12) {
            j(i11);
            g0(i10);
        }
    }

    public void l(int i10, long j10, long j11) {
        if (this.f32728l || j10 != j11) {
            m(j10);
            g0(i10);
        }
    }

    public void m(long j10) {
        U(8, 0);
        a0(j10);
    }

    public void n(int i10) {
        U(4, 0);
        Z((S() - i10) + 4);
    }

    public void o(int i10, int i11, int i12) {
        if (this.f32728l || i11 != i12) {
            n(i11);
            g0(i10);
        }
    }

    public void p(int i10, short s10, int i11) {
        if (this.f32728l || s10 != i11) {
            q(s10);
            g0(i10);
        }
    }

    public void q(short s10) {
        U(2, 0);
        b0(s10);
    }

    public void r(int i10, int i11, int i12) {
        if (i11 != i12) {
            a(i11);
            g0(i10);
        }
    }

    public void s() {
        this.f32718b = this.f32717a.capacity();
        this.f32717a.clear();
        this.f32719c = 1;
        while (true) {
            int i10 = this.f32721e;
            if (i10 <= 0) {
                break;
            }
            int[] iArr = this.f32720d;
            int i11 = i10 - 1;
            this.f32721e = i11;
            iArr[i11] = 0;
        }
        this.f32721e = 0;
        this.f32722f = false;
        this.f32723g = false;
        this.f32724h = 0;
        this.f32726j = 0;
        this.f32727k = 0;
        Map<String, Integer> map = this.f32731o;
        if (map != null) {
            map.clear();
        }
    }

    public int t(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        i0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f32717a;
        int i10 = this.f32718b - iRemaining;
        this.f32718b = i10;
        byteBuffer2.position(i10);
        this.f32717a.put(byteBuffer);
        return F();
    }

    public int u(byte[] bArr) {
        int length = bArr.length;
        i0(1, length, 1);
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - length;
        this.f32718b = i10;
        byteBuffer.position(i10);
        this.f32717a.put(bArr);
        return F();
    }

    public int v(byte[] bArr, int i10, int i11) {
        i0(1, i11, 1);
        ByteBuffer byteBuffer = this.f32717a;
        int i12 = this.f32718b - i11;
        this.f32718b = i12;
        byteBuffer.position(i12);
        this.f32717a.put(bArr, i10, i11);
        return F();
    }

    public int w(String str) {
        Map<String, Integer> map = this.f32731o;
        if (map == null) {
            this.f32731o = new HashMap();
            int iY = y(str);
            this.f32731o.put(str, Integer.valueOf(iY));
            return iY;
        }
        Integer numValueOf = map.get(str);
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(y(str));
            this.f32731o.put(str, numValueOf);
        }
        return numValueOf.intValue();
    }

    public <T extends s> int x(T t10, int[] iArr) {
        t10.t(iArr, this.f32717a);
        return B(iArr);
    }

    public int y(CharSequence charSequence) {
        int iD = this.f32730n.d(charSequence);
        d((byte) 0);
        i0(1, iD, 1);
        ByteBuffer byteBuffer = this.f32717a;
        int i10 = this.f32718b - iD;
        this.f32718b = i10;
        byteBuffer.position(i10);
        this.f32730n.b(charSequence, this.f32717a);
        return F();
    }

    public int z(ByteBuffer byteBuffer) {
        int iRemaining = byteBuffer.remaining();
        d((byte) 0);
        i0(1, iRemaining, 1);
        ByteBuffer byteBuffer2 = this.f32717a;
        int i10 = this.f32718b - iRemaining;
        this.f32718b = i10;
        byteBuffer2.position(i10);
        this.f32717a.put(byteBuffer);
        return F();
    }

    public i(int i10, b bVar, ByteBuffer byteBuffer, Utf8 utf8) {
        this.f32719c = 1;
        this.f32720d = null;
        this.f32721e = 0;
        this.f32722f = false;
        this.f32723g = false;
        this.f32725i = new int[16];
        this.f32726j = 0;
        this.f32727k = 0;
        this.f32728l = false;
        i10 = i10 <= 0 ? 1024 : i10;
        this.f32729m = bVar;
        if (byteBuffer != null) {
            this.f32717a = byteBuffer;
            byteBuffer.clear();
            this.f32717a.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f32717a = bVar.a(i10);
        }
        this.f32730n = utf8;
        this.f32718b = this.f32717a.capacity();
    }

    public i(int i10) {
        this(i10, c.f32733a, null, Utf8.e());
    }

    public i() {
        this(1024);
    }

    public i(ByteBuffer byteBuffer, b bVar) {
        this(byteBuffer.capacity(), bVar, byteBuffer, Utf8.e());
    }

    public i(ByteBuffer byteBuffer) {
        this(byteBuffer, new c());
    }
}
