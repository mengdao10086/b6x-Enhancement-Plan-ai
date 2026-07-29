package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;

/* JADX INFO: loaded from: classes6.dex */
@IgnoreJRERequirement
public final class e extends c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c.a f48571a = new e();

    @IgnoreJRERequirement
    public static final class a<R> implements retrofit2.c<R, CompletableFuture<R>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f48572a;

        /* JADX INFO: renamed from: retrofit2.e$a$a, reason: collision with other inner class name */
        @IgnoreJRERequirement
        public class C0557a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CompletableFuture<R> f48573a;

            public C0557a(CompletableFuture<R> completableFuture) {
                this.f48573a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th2) {
                this.f48573a.completeExceptionally(th2);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, r<R> rVar) {
                if (rVar.g()) {
                    this.f48573a.complete(rVar.a());
                } else {
                    this.f48573a.completeExceptionally(new HttpException(rVar));
                }
            }
        }

        public a(Type type) {
            this.f48572a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f48572a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<R> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.z(new C0557a(bVar2));
            return bVar2;
        }
    }

    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final retrofit2.b<?> f48575a;

        public b(retrofit2.b<?> bVar) {
            this.f48575a = bVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z10) {
            if (z10) {
                this.f48575a.cancel();
            }
            return super.cancel(z10);
        }
    }

    @IgnoreJRERequirement
    public static final class c<R> implements retrofit2.c<R, CompletableFuture<r<R>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Type f48576a;

        @IgnoreJRERequirement
        public class a implements d<R> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final CompletableFuture<r<R>> f48577a;

            public a(CompletableFuture<r<R>> completableFuture) {
                this.f48577a = completableFuture;
            }

            @Override // retrofit2.d
            public void a(retrofit2.b<R> bVar, Throwable th2) {
                this.f48577a.completeExceptionally(th2);
            }

            @Override // retrofit2.d
            public void b(retrofit2.b<R> bVar, r<R> rVar) {
                this.f48577a.complete(rVar);
            }
        }

        public c(Type type) {
            this.f48576a = type;
        }

        @Override // retrofit2.c
        public Type a() {
            return this.f48576a;
        }

        @Override // retrofit2.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public CompletableFuture<r<R>> b(retrofit2.b<R> bVar) {
            b bVar2 = new b(bVar);
            bVar.z(new a(bVar2));
            return bVar2;
        }
    }

    @Override // retrofit2.c.a
    @Nullable
    public retrofit2.c<?, ?> a(Type type, Annotation[] annotationArr, s sVar) {
        if (c.a.c(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeB = c.a.b(0, (ParameterizedType) type);
        if (c.a.c(typeB) != r.class) {
            return new a(typeB);
        }
        if (typeB instanceof ParameterizedType) {
            return new c(c.a.b(0, (ParameterizedType) typeB));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
