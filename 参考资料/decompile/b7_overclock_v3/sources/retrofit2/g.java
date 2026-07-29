package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.b0;
import okio.v0;
import retrofit2.c;

/* JADX INFO: loaded from: classes6.dex */
public final class g extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Executor f48579a;

    public class a implements c<Object, retrofit2.b<?>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Type f48580a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f48581b;

        public a(Type type, Executor executor) {
            this.f48580a = type;
            this.f48581b = executor;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f48580a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public retrofit2.b<Object> b(retrofit2.b<Object> bVar) {
            Executor executor = this.f48581b;
            return executor == null ? bVar : new b(executor, bVar);
        }
    }

    public static final class b<T> implements retrofit2.b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Executor f48583a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final retrofit2.b<T> f48584b;

        public class a implements d<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f48585a;

            public a(d dVar) {
                this.f48585a = dVar;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void e(d dVar, Throwable th2) {
                dVar.a(b.this, th2);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void f(d dVar, r rVar) {
                if (b.this.f48584b.W()) {
                    dVar.a(b.this, new IOException("Canceled"));
                } else {
                    dVar.b(b.this, rVar);
                }
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<T> bVar, final Throwable th2) {
                Executor executor = b.this.f48583a;
                final d dVar = this.f48585a;
                executor.execute(new Runnable() { // from class: retrofit2.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48587a.e(dVar, th2);
                    }
                });
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<T> bVar, final r<T> rVar) {
                Executor executor = b.this.f48583a;
                final d dVar = this.f48585a;
                executor.execute(new Runnable() { // from class: retrofit2.i
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f48590a.f(dVar, rVar);
                    }
                });
            }
        }

        public b(Executor executor, retrofit2.b<T> bVar) {
            this.f48583a = executor;
            this.f48584b = bVar;
        }

        @Override // retrofit2.b
        public b0 T() {
            return this.f48584b.T();
        }

        @Override // retrofit2.b
        public v0 U() {
            return this.f48584b.U();
        }

        @Override // retrofit2.b
        public boolean W() {
            return this.f48584b.W();
        }

        @Override // retrofit2.b
        public r<T> X() throws IOException {
            return this.f48584b.X();
        }

        @Override // retrofit2.b
        public boolean Z() {
            return this.f48584b.Z();
        }

        @Override // retrofit2.b
        public void cancel() {
            this.f48584b.cancel();
        }

        @Override // retrofit2.b
        public void z(d<T> dVar) {
            Objects.requireNonNull(dVar, "callback == null");
            this.f48584b.z(new a(dVar));
        }

        @Override // retrofit2.b
        public retrofit2.b<T> clone() {
            return new b(this.f48583a, this.f48584b.clone());
        }
    }

    public g(@Nullable Executor executor) {
        this.f48579a = executor;
    }

    @Override // retrofit2.c.a
    @Nullable
    public c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.c(type) != retrofit2.b.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(w.g(0, (ParameterizedType) type), w.l(annotationArr, u.class) ? null : this.f48579a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
