package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;
import kotlin.v1;

/* JADX INFO: loaded from: classes5.dex */
public final class p extends b {
    public p f(int i10, ByteBuffer byteBuffer) {
        b(i10, 2, byteBuffer);
        return this;
    }

    public short g(int i10) {
        return this.f32704d.getShort(a(i10));
    }

    public int h(int i10) {
        return g(i10) & v1.f38215d;
    }
}
