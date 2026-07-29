package h4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes2.dex */
public class b<Data> implements n<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0363b<Data> f30433a;

    public static class a implements o<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: h4.b$a$a, reason: collision with other inner class name */
        public class C0362a implements InterfaceC0363b<ByteBuffer> {
            public C0362a() {
            }

            @Override // h4.b.InterfaceC0363b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // h4.b.InterfaceC0363b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<byte[], ByteBuffer> c(@n0 r rVar) {
            return new b(new C0362a());
        }
    }

    /* JADX INFO: renamed from: h4.b$b, reason: collision with other inner class name */
    public interface InterfaceC0363b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    public static class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f30435a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0363b<Data> f30436b;

        public c(byte[] bArr, InterfaceC0363b<Data> interfaceC0363b) {
            this.f30435a = bArr;
            this.f30436b = interfaceC0363b;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<Data> a() {
            return this.f30436b.a();
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
        public void f(@n0 Priority priority, @n0 d.a<? super Data> aVar) {
            aVar.d(this.f30436b.b(this.f30435a));
        }
    }

    public static class d implements o<byte[], InputStream> {

        public class a implements InterfaceC0363b<InputStream> {
            public a() {
            }

            @Override // h4.b.InterfaceC0363b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // h4.b.InterfaceC0363b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<byte[], InputStream> c(@n0 r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0363b<Data> interfaceC0363b) {
        this.f30433a = interfaceC0363b;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 byte[] bArr, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(bArr), new c(bArr, this.f30433a));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 byte[] bArr) {
        return true;
    }
}
