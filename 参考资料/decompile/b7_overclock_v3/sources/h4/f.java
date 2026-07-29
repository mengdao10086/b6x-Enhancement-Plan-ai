package h4;

import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public class f<Data> implements n<File, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30449b = "FileLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Data> f30450a;

    public static class a<Data> implements o<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<Data> f30451a;

        public a(d<Data> dVar) {
            this.f30451a = dVar;
        }

        @Override // h4.o
        public final void a() {
        }

        @Override // h4.o
        @n0
        public final n<File, Data> c(@n0 r rVar) {
            return new f(this.f30451a);
        }
    }

    public static class b extends a<ParcelFileDescriptor> {

        public class a implements d<ParcelFileDescriptor> {
            @Override // h4.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // h4.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // h4.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    public static final class c<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f30452a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d<Data> f30453b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Data f30454c;

        public c(File file, d<Data> dVar) {
            this.f30452a = file;
            this.f30453b = dVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<Data> a() {
            return this.f30453b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            Data data = this.f30454c;
            if (data != null) {
                try {
                    this.f30453b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.bumptech.glide.load.data.d
        public void cancel() {
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public DataSource e() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.bumptech.glide.load.data.d
        public void f(@n0 Priority priority, @n0 d.a<? super Data> aVar) {
            try {
                Data dataC = this.f30453b.c(this.f30452a);
                this.f30454c = dataC;
                aVar.d(dataC);
            } catch (FileNotFoundException e10) {
                aVar.c(e10);
            }
        }
    }

    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    public static class e extends a<InputStream> {

        public class a implements d<InputStream> {
            @Override // h4.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // h4.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // h4.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f30450a = dVar;
    }

    @Override // h4.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> a(@n0 File file, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(file), new c(file, this.f30450a));
    }

    @Override // h4.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(@n0 File file) {
        return true;
    }
}
