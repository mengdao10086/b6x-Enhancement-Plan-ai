package io.objectbox.flatbuffers;

import java.util.Arrays;

/* JADX INFO: loaded from: classes5.dex */
public class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f32699a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32700b;

    public a() {
        this(10);
    }

    @Override // io.objectbox.flatbuffers.o, io.objectbox.flatbuffers.n
    public int a() {
        return this.f32700b;
    }

    @Override // io.objectbox.flatbuffers.o
    public void b(int i10, byte[] bArr, int i11, int i12) {
        j((i12 - i11) + i10);
        System.arraycopy(bArr, i11, this.f32699a, i10, i12);
    }

    @Override // io.objectbox.flatbuffers.o
    public void c(int i10, double d10) {
        j(i10 + 8);
        long jDoubleToRawLongBits = Double.doubleToRawLongBits(d10);
        int i11 = (int) jDoubleToRawLongBits;
        byte[] bArr = this.f32699a;
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >> 8) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i11 >> 16) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i11 >> 24) & 255);
        int i16 = (int) (jDoubleToRawLongBits >> 32);
        int i17 = i15 + 1;
        bArr[i15] = (byte) (i16 & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((i16 >> 8) & 255);
        bArr[i18] = (byte) ((i16 >> 16) & 255);
        bArr[i18 + 1] = (byte) ((i16 >> 24) & 255);
    }

    @Override // io.objectbox.flatbuffers.o
    public void clear() {
        this.f32700b = 0;
    }

    @Override // io.objectbox.flatbuffers.o
    public void d(int i10, int i11) {
        j(i10 + 4);
        byte[] bArr = this.f32699a;
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >> 8) & 255);
        bArr[i13] = (byte) ((i11 >> 16) & 255);
        bArr[i13 + 1] = (byte) ((i11 >> 24) & 255);
    }

    @Override // io.objectbox.flatbuffers.n
    public boolean e(int i10) {
        return this.f32699a[i10] != 0;
    }

    @Override // io.objectbox.flatbuffers.o
    public void f(int i10, float f10) {
        j(i10 + 4);
        int iFloatToRawIntBits = Float.floatToRawIntBits(f10);
        byte[] bArr = this.f32699a;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (iFloatToRawIntBits & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((iFloatToRawIntBits >> 8) & 255);
        bArr[i12] = (byte) ((iFloatToRawIntBits >> 16) & 255);
        bArr[i12 + 1] = (byte) ((iFloatToRawIntBits >> 24) & 255);
    }

    @Override // io.objectbox.flatbuffers.n
    public byte[] g() {
        return this.f32699a;
    }

    @Override // io.objectbox.flatbuffers.n
    public byte get(int i10) {
        return this.f32699a[i10];
    }

    @Override // io.objectbox.flatbuffers.n
    public double getDouble(int i10) {
        return Double.longBitsToDouble(getLong(i10));
    }

    @Override // io.objectbox.flatbuffers.n
    public float getFloat(int i10) {
        return Float.intBitsToFloat(getInt(i10));
    }

    @Override // io.objectbox.flatbuffers.n
    public int getInt(int i10) {
        byte[] bArr = this.f32699a;
        return (bArr[i10] & 255) | (bArr[i10 + 3] << 24) | ((bArr[i10 + 2] & 255) << 16) | ((bArr[i10 + 1] & 255) << 8);
    }

    @Override // io.objectbox.flatbuffers.n
    public long getLong(int i10) {
        byte[] bArr = this.f32699a;
        int i11 = i10 + 1;
        long j10 = ((long) bArr[i10]) & 255;
        int i12 = i11 + 1;
        int i13 = i12 + 1;
        long j11 = j10 | ((((long) bArr[i11]) & 255) << 8) | ((((long) bArr[i12]) & 255) << 16);
        int i14 = i13 + 1;
        long j12 = j11 | ((((long) bArr[i13]) & 255) << 24);
        int i15 = i14 + 1;
        long j13 = j12 | ((((long) bArr[i14]) & 255) << 32);
        int i16 = i15 + 1;
        return j13 | ((((long) bArr[i15]) & 255) << 40) | ((255 & ((long) bArr[i16])) << 48) | (((long) bArr[i16 + 1]) << 56);
    }

    @Override // io.objectbox.flatbuffers.n
    public short getShort(int i10) {
        byte[] bArr = this.f32699a;
        return (short) ((bArr[i10] & 255) | (bArr[i10 + 1] << 8));
    }

    @Override // io.objectbox.flatbuffers.n
    public String h(int i10, int i11) {
        return Utf8Safe.h(this.f32699a, i10, i11);
    }

    @Override // io.objectbox.flatbuffers.o
    public void i(int i10, short s10) {
        j(i10 + 2);
        byte[] bArr = this.f32699a;
        bArr[i10] = (byte) (s10 & 255);
        bArr[i10 + 1] = (byte) ((s10 >> 8) & 255);
    }

    @Override // io.objectbox.flatbuffers.o
    public boolean j(int i10) {
        if (i10 < 0) {
            throw new IllegalArgumentException("Capacity may not be negative (likely a previous int overflow)");
        }
        byte[] bArr = this.f32699a;
        if (bArr.length >= i10) {
            return true;
        }
        int length = bArr.length;
        int i11 = length + (length >> 1);
        if (i11 >= i10) {
            i10 = i11;
        }
        this.f32699a = Arrays.copyOf(bArr, i10);
        return true;
    }

    @Override // io.objectbox.flatbuffers.o
    public void k(int i10, byte b10) {
        j(i10 + 1);
        this.f32699a[i10] = b10;
    }

    @Override // io.objectbox.flatbuffers.o
    public void l(int i10, long j10) {
        j(i10 + 8);
        int i11 = (int) j10;
        byte[] bArr = this.f32699a;
        int i12 = i10 + 1;
        bArr[i10] = (byte) (i11 & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((i11 >> 8) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((i11 >> 16) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((i11 >> 24) & 255);
        int i16 = (int) (j10 >> 32);
        int i17 = i15 + 1;
        bArr[i15] = (byte) (i16 & 255);
        int i18 = i17 + 1;
        bArr[i17] = (byte) ((i16 >> 8) & 255);
        bArr[i18] = (byte) ((i16 >> 16) & 255);
        bArr[i18 + 1] = (byte) ((i16 >> 24) & 255);
    }

    @Override // io.objectbox.flatbuffers.o
    public int m() {
        return this.f32700b;
    }

    @Override // io.objectbox.flatbuffers.o
    public void n(int i10, boolean z10) {
        k(i10, z10 ? (byte) 1 : (byte) 0);
    }

    @Override // io.objectbox.flatbuffers.o
    public void o(byte[] bArr, int i10, int i11) {
        b(this.f32700b, bArr, i10, i11);
        this.f32700b += i11;
    }

    @Override // io.objectbox.flatbuffers.o
    public void p(byte b10) {
        k(this.f32700b, b10);
        this.f32700b++;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putBoolean(boolean z10) {
        n(this.f32700b, z10);
        this.f32700b++;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putDouble(double d10) {
        c(this.f32700b, d10);
        this.f32700b += 8;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putFloat(float f10) {
        f(this.f32700b, f10);
        this.f32700b += 4;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putInt(int i10) {
        d(this.f32700b, i10);
        this.f32700b += 4;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putLong(long j10) {
        l(this.f32700b, j10);
        this.f32700b += 8;
    }

    @Override // io.objectbox.flatbuffers.o
    public void putShort(short s10) {
        i(this.f32700b, s10);
        this.f32700b += 2;
    }

    public a(int i10) {
        this(new byte[i10]);
    }

    public a(byte[] bArr) {
        this.f32699a = bArr;
        this.f32700b = 0;
    }

    public a(byte[] bArr, int i10) {
        this.f32699a = bArr;
        this.f32700b = i10;
    }
}
