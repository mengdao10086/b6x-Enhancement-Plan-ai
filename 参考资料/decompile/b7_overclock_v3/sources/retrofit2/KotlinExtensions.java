package retrofit2;

import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.d0;
import kotlin.jvm.internal.f0;
import kotlin.u0;
import kotlin.z1;

/* JADX INFO: loaded from: classes6.dex */
@hk.h(name = "KotlinExtensions")
@d0(bv = {}, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u001c\u0010\u0002\u001a\u00028\u0000\"\u0006\b\u0000\u0010\u0000\u0018\u0001*\u00020\u0001H\u0086\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a+\u0010\b\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0000*\u00020\u0004*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005H\u0087@ø\u0001\u0000¢\u0006\u0004\b\b\u0010\u0007\u001a)\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\t\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0086@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u0007\u001a\u001b\u0010\u000e\u001a\u00020\r*\u00060\u000bj\u0002`\fH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {i1.a.f31577d5, "Lretrofit2/s;", "d", "(Lretrofit2/s;)Ljava/lang/Object;", "", "Lretrofit2/b;", "a", "(Lretrofit2/b;Lkotlin/coroutines/c;)Ljava/lang/Object;", "b", "Lretrofit2/r;", "c", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "e", "(Ljava/lang/Exception;Lkotlin/coroutines/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {1, 4, 0})
public final class KotlinExtensions {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$a", "Lretrofit2/d;", "Lretrofit2/b;", f0.v.E0, "Lretrofit2/r;", "response", "Lkotlin/z1;", "b", "", "t", "a", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class a<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.o f48559a;

        public a(kotlinx.coroutines.o oVar) {
            this.f48559a = oVar;
        }

        @Override // retrofit2.d
        public void a(@yt.k retrofit2.b<T> call, @yt.k Throwable t10) {
            f0.q(call, "call");
            f0.q(t10, "t");
            kotlinx.coroutines.o oVar = this.f48559a;
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(u0.a(t10)));
        }

        @Override // retrofit2.d
        public void b(@yt.k retrofit2.b<T> call, @yt.k r<T> response) {
            f0.q(call, "call");
            f0.q(response, "response");
            if (!response.g()) {
                kotlinx.coroutines.o oVar = this.f48559a;
                HttpException httpException = new HttpException(response);
                Result.a aVar = Result.f37633a;
                oVar.x(Result.b(u0.a(httpException)));
                return;
            }
            T tA = response.a();
            if (tA != null) {
                kotlinx.coroutines.o oVar2 = this.f48559a;
                Result.a aVar2 = Result.f37633a;
                oVar2.x(Result.b(tA));
                return;
            }
            Object objP = call.T().p(k.class);
            if (objP == null) {
                f0.L();
            }
            f0.h(objP, "call.request().tag(Invocation::class.java)!!");
            Method method = ((k) objP).b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Response from ");
            f0.h(method, "method");
            Class<?> declaringClass = method.getDeclaringClass();
            f0.h(declaringClass, "method.declaringClass");
            sb2.append(declaringClass.getName());
            sb2.append('.');
            sb2.append(method.getName());
            sb2.append(" was null but response body type was declared as non-null");
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException(sb2.toString());
            kotlinx.coroutines.o oVar3 = this.f48559a;
            Result.a aVar3 = Result.f37633a;
            oVar3.x(Result.b(u0.a(kotlinNullPointerException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J(\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016J \u0010\n\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$b", "Lretrofit2/d;", "Lretrofit2/b;", f0.v.E0, "Lretrofit2/r;", "response", "Lkotlin/z1;", "b", "", "t", "a", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class b<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.o f48560a;

        public b(kotlinx.coroutines.o oVar) {
            this.f48560a = oVar;
        }

        @Override // retrofit2.d
        public void a(@yt.k retrofit2.b<T> call, @yt.k Throwable t10) {
            f0.q(call, "call");
            f0.q(t10, "t");
            kotlinx.coroutines.o oVar = this.f48560a;
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(u0.a(t10)));
        }

        @Override // retrofit2.d
        public void b(@yt.k retrofit2.b<T> call, @yt.k r<T> response) {
            f0.q(call, "call");
            f0.q(response, "response");
            if (response.g()) {
                kotlinx.coroutines.o oVar = this.f48560a;
                T tA = response.a();
                Result.a aVar = Result.f37633a;
                oVar.x(Result.b(tA));
                return;
            }
            kotlinx.coroutines.o oVar2 = this.f48560a;
            HttpException httpException = new HttpException(response);
            Result.a aVar2 = Result.f37633a;
            oVar2.x(Result.b(u0.a(httpException)));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @d0(bv = {}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J$\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016J\u001e\u0010\n\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\u000b"}, d2 = {"retrofit2/KotlinExtensions$c", "Lretrofit2/d;", "Lretrofit2/b;", f0.v.E0, "Lretrofit2/r;", "response", "Lkotlin/z1;", "b", "", "t", "a", "retrofit"}, k = 1, mv = {1, 4, 0})
    public static final class c<T> implements retrofit2.d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.o f48561a;

        public c(kotlinx.coroutines.o oVar) {
            this.f48561a = oVar;
        }

        @Override // retrofit2.d
        public void a(@yt.k retrofit2.b<T> call, @yt.k Throwable t10) {
            f0.q(call, "call");
            f0.q(t10, "t");
            kotlinx.coroutines.o oVar = this.f48561a;
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(u0.a(t10)));
        }

        @Override // retrofit2.d
        public void b(@yt.k retrofit2.b<T> call, @yt.k r<T> response) {
            f0.q(call, "call");
            f0.q(response, "response");
            kotlinx.coroutines.o oVar = this.f48561a;
            Result.a aVar = Result.f37633a;
            oVar.x(Result.b(response));
        }
    }

    @d0(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0004\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/z1;", "run", "()V", "retrofit2/KotlinExtensions$suspendAndThrow$2$1", "<anonymous>"}, k = 3, mv = {1, 4, 0})
    public static final class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.coroutines.c f48562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Exception f48563b;

        public d(kotlin.coroutines.c cVar, Exception exc) {
            this.f48562a = cVar;
            this.f48563b = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            kotlin.coroutines.c cVarD = IntrinsicsKt__IntrinsicsJvmKt.d(this.f48562a);
            Exception exc = this.f48563b;
            Result.a aVar = Result.f37633a;
            cVarD.x(Result.b(u0.a(exc)));
        }
    }

    @yt.l
    public static final <T> Object a(@yt.k final retrofit2.b<T> bVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.B(new ik.l<Throwable, z1>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                bVar.cancel();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        bVar.z(new a(pVar));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    @hk.h(name = "awaitNullable")
    @yt.l
    public static final <T> Object b(@yt.k final retrofit2.b<T> bVar, @yt.k kotlin.coroutines.c<? super T> cVar) {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.B(new ik.l<Throwable, z1>() { // from class: retrofit2.KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                bVar.cancel();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        bVar.z(new b(pVar));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    @yt.l
    public static final <T> Object c(@yt.k final retrofit2.b<T> bVar, @yt.k kotlin.coroutines.c<? super r<T>> cVar) {
        kotlinx.coroutines.p pVar = new kotlinx.coroutines.p(IntrinsicsKt__IntrinsicsJvmKt.d(cVar), 1);
        pVar.B(new ik.l<Throwable, z1>() { // from class: retrofit2.KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1
            {
                super(1);
            }

            public final void b(@yt.l Throwable th2) {
                bVar.cancel();
            }

            @Override // ik.l
            public /* bridge */ /* synthetic */ z1 i(Throwable th2) {
                b(th2);
                return z1.f38230a;
            }
        });
        bVar.z(new c(pVar));
        Object objC = pVar.C();
        if (objC == yj.b.h()) {
            zj.f.c(cVar);
        }
        return objC;
    }

    public static final /* synthetic */ <T> T d(@yt.k s create) {
        f0.q(create, "$this$create");
        f0.y(4, i1.a.f31577d5);
        return (T) create.g(Object.class);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @yt.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(@yt.k java.lang.Exception r4, @yt.k kotlin.coroutines.c<?> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = yj.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            kotlin.u0.n(r5)
            goto L5c
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            kotlin.u0.n(r5)
            r0.L$0 = r4
            r0.label = r3
            kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.d1.a()
            kotlin.coroutines.CoroutineContext r2 = r0.b()
            retrofit2.KotlinExtensions$d r3 = new retrofit2.KotlinExtensions$d
            r3.<init>(r0, r4)
            r5.h2(r2, r3)
            java.lang.Object r4 = yj.b.h()
            java.lang.Object r5 = yj.b.h()
            if (r4 != r5) goto L59
            zj.f.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.z1 r4 = kotlin.z1.f38230a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Exception, kotlin.coroutines.c):java.lang.Object");
    }
}
