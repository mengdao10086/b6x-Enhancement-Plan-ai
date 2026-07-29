package k4;

import com.bumptech.glide.load.data.e;
import g.n0;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class a implements e<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f36991a;

    /* JADX INFO: renamed from: k4.a$a, reason: collision with other inner class name */
    public static class C0419a implements e.a<ByteBuffer> {
        @Override // com.bumptech.glide.load.data.e.a
        @n0
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.e.a
        @n0
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public e<ByteBuffer> b(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f36991a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.e
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.e
    @n0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.f36991a.position(0);
        return this.f36991a;
    }
}
