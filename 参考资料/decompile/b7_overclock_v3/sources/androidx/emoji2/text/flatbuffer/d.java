package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class d implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f5448a;

    public d(ByteBuffer byteBuffer) {
        this.f5448a = byteBuffer;
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    @Override // androidx.emoji2.text.flatbuffer.q, androidx.emoji2.text.flatbuffer.p
    public int a() {
        return this.f5448a.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void b(int i10, byte[] bArr, int i11, int i12) {
        j((i12 - i11) + i10);
        int iPosition = this.f5448a.position();
        this.f5448a.position(i10);
        this.f5448a.put(bArr, i11, i12);
        this.f5448a.position(iPosition);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void c(int i10, double d10) {
        j(i10 + 8);
        this.f5448a.putDouble(i10, d10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void d(int i10, int i11) {
        j(i10 + 4);
        this.f5448a.putInt(i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public boolean e(int i10) {
        return get(i10) != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void f(int i10, float f10) {
        j(i10 + 4);
        this.f5448a.putFloat(i10, f10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public byte[] g() {
        return this.f5448a.array();
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public byte get(int i10) {
        return this.f5448a.get(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public double getDouble(int i10) {
        return this.f5448a.getDouble(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public float getFloat(int i10) {
        return this.f5448a.getFloat(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public int getInt(int i10) {
        return this.f5448a.getInt(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public long getLong(int i10) {
        return this.f5448a.getLong(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public short getShort(int i10) {
        return this.f5448a.getShort(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.p
    public String h(int i10, int i11) {
        return Utf8Safe.h(this.f5448a, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void i(int i10, short s10) {
        j(i10 + 2);
        this.f5448a.putShort(i10, s10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public boolean j(int i10) {
        return i10 <= this.f5448a.limit();
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void k(int i10, byte b10) {
        j(i10 + 1);
        this.f5448a.put(i10, b10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void l(int i10, long j10) {
        j(i10 + 8);
        this.f5448a.putLong(i10, j10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public int m() {
        return this.f5448a.position();
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void n(int i10, boolean z10) {
        k(i10, z10 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void o(byte[] bArr, int i10, int i11) {
        this.f5448a.put(bArr, i10, i11);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void p(byte b10) {
        this.f5448a.put(b10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putBoolean(boolean z10) {
        this.f5448a.put(z10 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putDouble(double d10) {
        this.f5448a.putDouble(d10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putFloat(float f10) {
        this.f5448a.putFloat(f10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putInt(int i10) {
        this.f5448a.putInt(i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putLong(long j10) {
        this.f5448a.putLong(j10);
    }

    @Override // androidx.emoji2.text.flatbuffer.q
    public void putShort(short s10) {
        this.f5448a.putShort(s10);
    }
}
