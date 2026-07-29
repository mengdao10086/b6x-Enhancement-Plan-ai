package io.objectbox.flatbuffers;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f32701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f32702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f32703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ByteBuffer f32704d;

    public int a(int i10) {
        return this.f32701a + (i10 * this.f32703c);
    }

    public void b(int i10, int i11, ByteBuffer byteBuffer) {
        this.f32704d = byteBuffer;
        if (byteBuffer != null) {
            this.f32701a = i10;
            this.f32702b = byteBuffer.getInt(i10 - 4);
            this.f32703c = i11;
        } else {
            this.f32701a = 0;
            this.f32702b = 0;
            this.f32703c = 0;
        }
    }

    public int c() {
        return this.f32701a;
    }

    public int d() {
        return this.f32702b;
    }

    public void e() {
        b(0, 0, null);
    }
}
