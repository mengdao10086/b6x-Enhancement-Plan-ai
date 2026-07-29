package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes5.dex */
public class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f32705a;

    public d(ByteBuffer byteBuffer) {
        this.f32705a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // io.objectbox.flatbuffers.o, io.objectbox.flatbuffers.n
    public int a() {
        return this.f32705a.limit();
    }

    @Override // io.objectbox.flatbuffers.o
    public void b(int i10, byte[] bArr, int i11, int i12) {
        j((i12 - i11) + i10);
        int iPosition = this.f32705a.position();
        this.f32705a.position(i10);
        this.f32705a.put(bArr, i11, i12);
        this.f32705a.position(iPosition);
    }

    @Override // io.objectbox.flatbuffers.o
    public void c(int i10, double d10) {
        j(i10 + 8);
        this.f32705a.putDouble(i10, d10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void clear() {
        this.f32705a.clear();
    }

    @Override // io.objectbox.flatbuffers.o
    public void d(int i10, int i11) {
        j(i10 + 4);
        this.f32705a.putInt(i10, i11);
    }

    @Override // io.objectbox.flatbuffers.n
    public boolean e(int i10) {
        return get(i10) != 0;
    }

    @Override // io.objectbox.flatbuffers.o
    public void f(int i10, float f10) {
        j(i10 + 4);
        this.f32705a.putFloat(i10, f10);
    }

    @Override // io.objectbox.flatbuffers.n
    public byte[] g() {
        return this.f32705a.array();
    }

    @Override // io.objectbox.flatbuffers.n
    public byte get(int i10) {
        return this.f32705a.get(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public double getDouble(int i10) {
        return this.f32705a.getDouble(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public float getFloat(int i10) {
        return this.f32705a.getFloat(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public int getInt(int i10) {
        return this.f32705a.getInt(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public long getLong(int i10) {
        return this.f32705a.getLong(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public short getShort(int i10) {
        return this.f32705a.getShort(i10);
    }

    @Override // io.objectbox.flatbuffers.n
    public String h(int i10, int i11) {
        return Utf8Safe.i(this.f32705a, i10, i11);
    }

    @Override // io.objectbox.flatbuffers.o
    public void i(int i10, short s10) {
        j(i10 + 2);
        this.f32705a.putShort(i10, s10);
    }

    @Override // io.objectbox.flatbuffers.o
    public boolean j(int i10) {
        return i10 <= this.f32705a.limit();
    }

    @Override // io.objectbox.flatbuffers.o
    public void k(int i10, byte b10) {
        j(i10 + 1);
        this.f32705a.put(i10, b10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void l(int i10, long j10) {
        j(i10 + 8);
        this.f32705a.putLong(i10, j10);
    }

    @Override // io.objectbox.flatbuffers.o
    public int m() {
        return this.f32705a.position();
    }

    @Override // io.objectbox.flatbuffers.o
    public void n(int i10, boolean z10) {
        k(i10, z10 ? (byte) 1 : (byte) 0);
    }

    @Override // io.objectbox.flatbuffers.o
    public void o(byte[] bArr, int i10, int i11) {
        this.f32705a.put(bArr, i10, i11);
    }

    @Override // io.objectbox.flatbuffers.o
    public void p(byte b10) {
        this.f32705a.put(b10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putBoolean(boolean z10) {
        this.f32705a.put(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putDouble(double d10) {
        this.f32705a.putDouble(d10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putFloat(float f10) {
        this.f32705a.putFloat(f10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putInt(int i10) {
        this.f32705a.putInt(i10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putLong(long j10) {
        this.f32705a.putLong(j10);
    }

    @Override // io.objectbox.flatbuffers.o
    public void putShort(short s10) {
        this.f32705a.putShort(s10);
    }
}
