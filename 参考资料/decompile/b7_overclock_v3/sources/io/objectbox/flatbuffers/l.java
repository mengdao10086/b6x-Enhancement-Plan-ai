package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public final class l extends b {
    public l f(int i10, ByteBuffer byteBuffer) {
        b(i10, 4, byteBuffer);
        return this;
    }

    public int g(int i10) {
        return this.f32704d.getInt(a(i10));
    }

    public long h(int i10) {
        return ((long) g(i10)) & 4294967295L;
    }
}
