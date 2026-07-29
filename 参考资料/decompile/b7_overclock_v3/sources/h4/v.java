package h4;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import g.n0;
import h4.n;

/* JADX INFO: loaded from: classes2.dex */
public class v<Model> implements n<Model, Model> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v<?> f30521a = new v<>();

    public static class a<Model> implements o<Model, Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<?> f30522a = new a<>();

        @Deprecated
        public a() {
        }

        public static <T> a<T> b() {
            return (a<T>) f30522a;
        }

        @Override // h4.o
        public void a() {
        }

        @Override // h4.o
        @n0
        public n<Model, Model> c(r rVar) {
            return v.c();
        }
    }

    public static class b<Model> implements com.bumptech.glide.load.data.d<Model> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Model f30523a;

        public b(Model model) {
            this.f30523a = model;
        }

        @Override // com.bumptech.glide.load.data.d
        @n0
        public Class<Model> a() {
            return (Class<Model>) this.f30523a.getClass();
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
        public void f(@n0 Priority priority, @n0 d.a<? super Model> aVar) {
            aVar.d(this.f30523a);
        }
    }

    @Deprecated
    public v() {
    }

    public static <T> v<T> c() {
        return (v<T>) f30521a;
    }

    @Override // h4.n
    public n.a<Model> a(@n0 Model model, int i10, int i11, @n0 c4.e eVar) {
        return new n.a<>(new u4.e(model), new b(model));
    }

    @Override // h4.n
    public boolean b(@n0 Model model) {
        return true;
    }
}
