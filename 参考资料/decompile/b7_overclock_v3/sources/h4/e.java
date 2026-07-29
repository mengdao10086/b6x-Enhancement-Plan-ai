package h4;

import android.util.Base64;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes2.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f30441b = "data:image";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f30442c = ";base64";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<Data> f30443a;

    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    public static final class b<Data> implements com.bumptech.glide.load.data.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a<Data> f30445b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Data f30446c;

        public b(String str, a<Data> aVar) {
            this.f30444a = str;
            this.f30445b = aVar;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<Data> a() {
            return this.f30445b.a();
        }

        @Override // com.bumptech.glide.load.data.d
        public void b() {
            try {
                this.f30445b.b(this.f30446c);
            } catch (IOException unused) {
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
                Data dataC = this.f30445b.c(this.f30444a);
                this.f30446c = dataC;
                aVar.d(dataC);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }
    }

    public static final class c<Model> implements o<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<InputStream> f30447a = new a();

        public class a implements a<InputStream> {
            public a() {
            }

            @Override // h4.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // h4.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // h4.e.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith(e.f30441b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(e.f30442c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Model, InputStream> c(@n0 r rVar) {
            return new e(this.f30447a);
        }
    }

    public e(a<Data> aVar) {
        this.f30443a = aVar;
    }

    @Override // h4.n
    public n.a<Data> a(@n0 Model model, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(model), new b(model.toString(), this.f30443a));
    }

    @Override // h4.n
    public boolean b(@n0 Model model) {
        return model.toString().startsWith(f30441b);
    }
}
