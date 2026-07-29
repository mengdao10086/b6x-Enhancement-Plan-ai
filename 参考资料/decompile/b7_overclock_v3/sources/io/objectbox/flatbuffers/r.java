package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f32761b;

    public void a() {
        b(0, null);
    }

    public void b(int i10, ByteBuffer byteBuffer) {
        this.f32761b = byteBuffer;
        if (byteBuffer != null) {
            this.f32760a = i10;
        } else {
            this.f32760a = 0;
        }
    }
}
