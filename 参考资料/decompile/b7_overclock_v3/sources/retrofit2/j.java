package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.d0;
import okhttp3.e;
import okhttp3.e0;
import retrofit2.w;

/* JADX INFO: loaded from: classes6.dex */
public abstract class j<ResponseT, ReturnT> extends t<ReturnT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q f48593a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f48594b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f<e0, ResponseT> f48595c;

    public static final class a<ResponseT, ReturnT> extends j<ResponseT, ReturnT> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, ReturnT> f48596d;

        public a(q qVar, e.a aVar, f<e0, ResponseT> fVar, retrofit2.c<ResponseT, ReturnT> cVar) {
            super(qVar, aVar, fVar);
            this.f48596d = cVar;
        }

        @Override // retrofit2.j
        public ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            return this.f48596d.b(bVar);
        }
    }

    public static final class b<ResponseT> extends j<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f48597d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f48598e;

        public b(q qVar, e.a aVar, f<e0, ResponseT> fVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar, boolean z10) {
            super(qVar, aVar, fVar);
            this.f48597d = cVar;
            this.f48598e = z10;
        }

        @Override // retrofit2.j
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f48597d.b(bVar);
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) objArr[objArr.length - 1];
            try {
                return this.f48598e ? KotlinExtensions.b(bVarB, cVar) : KotlinExtensions.a(bVarB, cVar);
            } catch (Exception e10) {
                return KotlinExtensions.e(e10, cVar);
            }
        }
    }

    public static final class c<ResponseT> extends j<ResponseT, Object> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final retrofit2.c<ResponseT, retrofit2.b<ResponseT>> f48599d;

        public c(q qVar, e.a aVar, f<e0, ResponseT> fVar, retrofit2.c<ResponseT, retrofit2.b<ResponseT>> cVar) {
            super(qVar, aVar, fVar);
            this.f48599d = cVar;
        }

        @Override // retrofit2.j
        public Object c(retrofit2.b<ResponseT> bVar, Object[] objArr) {
            retrofit2.b<ResponseT> bVarB = this.f48599d.b(bVar);
            kotlin.coroutines.c cVar = (kotlin.coroutines.c) objArr[objArr.length - 1];
            try {
                return KotlinExtensions.c(bVarB, cVar);
            } catch (Exception e10) {
                return KotlinExtensions.e(e10, cVar);
            }
        }
    }

    public j(q qVar, e.a aVar, f<e0, ResponseT> fVar) {
        this.f48593a = qVar;
        this.f48594b = aVar;
        this.f48595c = fVar;
    }

    public static <ResponseT, ReturnT> retrofit2.c<ResponseT, ReturnT> d(s sVar, Method method, Type type, Annotation[] annotationArr) {
        try {
            return (retrofit2.c<ResponseT, ReturnT>) sVar.b(type, annotationArr);
        } catch (RuntimeException e10) {
            throw w.n(method, e10, "Unable to create call adapter for %s", type);
        }
    }

    public static <ResponseT> f<e0, ResponseT> e(s sVar, Method method, Type type) {
        try {
            return sVar.n(type, method.getAnnotations());
        } catch (RuntimeException e10) {
            throw w.n(method, e10, "Unable to create converter for %s", type);
        }
    }

    public static <ResponseT, ReturnT> j<ResponseT, ReturnT> f(s sVar, Method method, q qVar) {
        Type genericReturnType;
        boolean z10;
        boolean z11 = qVar.f48695k;
        Annotation[] annotations = method.getAnnotations();
        if (z11) {
            Type[] genericParameterTypes = method.getGenericParameterTypes();
            Type typeF = w.f(0, (ParameterizedType) genericParameterTypes[genericParameterTypes.length - 1]);
            if (w.h(typeF) == r.class && (typeF instanceof ParameterizedType)) {
                typeF = w.g(0, (ParameterizedType) typeF);
                z10 = true;
            } else {
                z10 = false;
            }
            genericReturnType = new w.b(null, retrofit2.b.class, typeF);
            annotations = v.a(annotations);
        } else {
            genericReturnType = method.getGenericReturnType();
            z10 = false;
        }
        retrofit2.c cVarD = d(sVar, method, genericReturnType, annotations);
        Type typeA = cVarD.a();
        if (typeA == d0.class) {
            throw w.m(method, "'" + w.h(typeA).getName() + "' is not a valid response body type. Did you mean ResponseBody?", new Object[0]);
        }
        if (typeA == r.class) {
            throw w.m(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
        }
        if (qVar.f48687c.equals("HEAD") && !Void.class.equals(typeA)) {
            throw w.m(method, "HEAD method must use Void as response type.", new Object[0]);
        }
        f fVarE = e(sVar, method, typeA);
        e.a aVar = sVar.f48726b;
        return !z11 ? new a(qVar, aVar, fVarE, cVarD) : z10 ? new c(qVar, aVar, fVarE, cVarD) : new b(qVar, aVar, fVarE, cVarD, false);
    }

    @Override // retrofit2.t
    @Nullable
    public final ReturnT a(Object[] objArr) {
        return c(new l(this.f48593a, objArr, this.f48594b, this.f48595c), objArr);
    }

    @Nullable
    public abstract ReturnT c(retrofit2.b<ResponseT> bVar, Object[] objArr);
}
