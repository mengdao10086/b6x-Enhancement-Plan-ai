package h4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30439a = "ByteBufferFileLoader";

    public static final class a implements com.bumptech.glide.load.data.d<ByteBuffer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f30440a;

        public a(File file) {
            this.f30440a = file;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public DataSource e() {
            return DataSource.LOCAL;
        }

        @Override // com.bumptech.glide.load.data.d
        public void f(@n0 Priority priority, @n0 d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(v4.a.a(this.f30440a));
            } catch (IOException e10) {
                aVar.c(e10);
            }
        }
    }

    public static class b implements o<File, ByteBuffer> {
        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<File, ByteBuffer> c(@n0 r rVar) {
            return new d();
        }
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> a(@n0 File file, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(file), new a(file));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 File file) {
        return true;
    }
}
