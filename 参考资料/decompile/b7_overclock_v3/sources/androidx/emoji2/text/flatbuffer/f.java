package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends b {
    public f f(int i10, ByteBuffer byteBuffer) {
        b(i10, 1, byteBuffer);
        return this;
    }

    public byte g(int i10) {
        return this.f5447d.get(a(i10));
    }

    public int h(int i10) {
        return g(i10) & 255;
    }
}
