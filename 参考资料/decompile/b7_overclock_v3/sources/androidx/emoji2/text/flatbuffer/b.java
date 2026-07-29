package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5444a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5445b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f5446c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f5447d;

    public int a(int i10) {
        return this.f5444a + (i10 * this.f5446c);
    }

    public void b(int i10, int i11, ByteBuffer byteBuffer) {
        this.f5447d = byteBuffer;
        if (byteBuffer != null) {
            this.f5444a = i10;
            this.f5445b = byteBuffer.getInt(i10 - 4);
            this.f5446c = i11;
        } else {
            this.f5444a = 0;
            this.f5445b = 0;
            this.f5446c = 0;
        }
    }

    public int c() {
        return this.f5444a;
    }

    public int d() {
        return this.f5445b;
    }

    public void e() {
        b(0, 0, null);
    }
}
