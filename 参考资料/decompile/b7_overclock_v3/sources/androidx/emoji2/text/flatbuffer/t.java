package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5500a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ByteBuffer f5501b;

    public void a() {
        b(0, null);
    }

    public void b(int i10, ByteBuffer byteBuffer) {
        this.f5501b = byteBuffer;
        if (byteBuffer != null) {
            this.f5500a = i10;
        } else {
            this.f5500a = 0;
        }
    }
}
