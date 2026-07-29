package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.a0;
import okhttp3.c0;
import okhttp3.e;
import okhttp3.e0;
import retrofit2.a;
import retrofit2.c;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Method, t<?>> f48725a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e.a f48726b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final okhttp3.u f48727c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<f.a> f48728d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<c.a> f48729e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final Executor f48730f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f48731g;

    public class a implements InvocationHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f48732a = o.g();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object[] f48733b = new Object[0];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Class f48734c;

        public a(Class cls) {
            this.f48734c = cls;
        }

        @Override // java.lang.reflect.InvocationHandler
        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) throws Throwable {
            if (method.getDeclaringClass() == Object.class) {
                return method.invoke(this, objArr);
            }
            if (objArr == null) {
                objArr = this.f48733b;
            }
            return this.f48732a.i(method) ? this.f48732a.h(method, this.f48734c, obj, objArr) : s.this.h(method).a(objArr);
        }
    }

    public s(e.a aVar, okhttp3.u uVar, List<f.a> list, List<c.a> list2, @Nullable Executor executor, boolean z10) {
        this.f48726b = aVar;
        this.f48727c = uVar;
        this.f48728d = list;
        this.f48729e = list2;
        this.f48730f = executor;
        this.f48731g = z10;
    }

    public okhttp3.u a() {
        return this.f48727c;
    }

    public c<?, ?> b(Type type, Annotation[] annotationArr) {
        return j(null, type, annotationArr);
    }

    public List<c.a> c() {
        return this.f48729e;
    }

    public e.a d() {
        return this.f48726b;
    }

    @Nullable
    public Executor e() {
        return this.f48730f;
    }

    public List<f.a> f() {
        return this.f48728d;
    }

    public <T> T g(Class<T> cls) {
        p(cls);
        return (T) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new a(cls));
    }

    public t<?> h(Method method) {
        t<?> tVarB;
        t<?> tVar = this.f48725a.get(method);
        if (tVar != null) {
            return tVar;
        }
        synchronized (this.f48725a) {
            tVarB = this.f48725a.get(method);
            if (tVarB == null) {
                tVarB = t.b(this, method);
                this.f48725a.put(method, tVarB);
            }
        }
        return tVarB;
    }

    public b i() {
        return new b(this);
    }

    public c<?, ?> j(@Nullable c.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f48729e.indexOf(aVar) + 1;
        int size = this.f48729e.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            c<?, ?> cVarA = this.f48729e.get(i10).a(type, annotationArr, this);
            if (cVarA != null) {
                return cVarA;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate call adapter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f48729e.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f48729e.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f48729e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, c0> k(@Nullable f.a aVar, Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f48728d.indexOf(aVar) + 1;
        int size = this.f48728d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            f<T, c0> fVar = (f<T, c0>) this.f48728d.get(i10).c(type, annotationArr, annotationArr2, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate RequestBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f48728d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f48728d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f48728d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<e0, T> l(@Nullable f.a aVar, Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f48728d.indexOf(aVar) + 1;
        int size = this.f48728d.size();
        for (int i10 = iIndexOf; i10 < size; i10++) {
            f<e0, T> fVar = (f<e0, T>) this.f48728d.get(i10).d(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        StringBuilder sb2 = new StringBuilder("Could not locate ResponseBody converter for ");
        sb2.append(type);
        sb2.append(".\n");
        if (aVar != null) {
            sb2.append("  Skipped:");
            for (int i11 = 0; i11 < iIndexOf; i11++) {
                sb2.append("\n   * ");
                sb2.append(this.f48728d.get(i11).getClass().getName());
            }
            sb2.append('\n');
        }
        sb2.append("  Tried:");
        int size2 = this.f48728d.size();
        while (iIndexOf < size2) {
            sb2.append("\n   * ");
            sb2.append(this.f48728d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb2.toString());
    }

    public <T> f<T, c0> m(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        return k(null, type, annotationArr, annotationArr2);
    }

    public <T> f<e0, T> n(Type type, Annotation[] annotationArr) {
        return l(null, type, annotationArr);
    }

    public <T> f<T, String> o(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f48728d.size();
        for (int i10 = 0; i10 < size; i10++) {
            f<T, String> fVar = (f<T, String>) this.f48728d.get(i10).e(type, annotationArr, this);
            if (fVar != null) {
                return fVar;
            }
        }
        return a.d.f48568a;
    }

    public final void p(Class<?> cls) {
        if (!cls.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(cls);
        while (!arrayDeque.isEmpty()) {
            Class<?> cls2 = (Class) arrayDeque.removeFirst();
            if (cls2.getTypeParameters().length != 0) {
                StringBuilder sb2 = new StringBuilder("Type parameters are unsupported on ");
                sb2.append(cls2.getName());
                if (cls2 != cls) {
                    sb2.append(" which is an interface of ");
                    sb2.append(cls.getName());
                }
                throw new IllegalArgumentException(sb2.toString());
            }
            Collections.addAll(arrayDeque, cls2.getInterfaces());
        }
        if (this.f48731g) {
            o oVarG = o.g();
            for (Method method : cls.getDeclaredMethods()) {
                if (!oVarG.i(method) && !Modifier.isStatic(method.getModifiers())) {
                    h(method);
                }
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final o f48736a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public e.a f48737b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public okhttp3.u f48738c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final List<f.a> f48739d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final List<c.a> f48740e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public Executor f48741f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f48742g;

        public b(o oVar) {
            this.f48739d = new ArrayList();
            this.f48740e = new ArrayList();
            this.f48736a = oVar;
        }

        public b a(c.a aVar) {
            List<c.a> list = this.f48740e;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b b(f.a aVar) {
            List<f.a> list = this.f48739d;
            Objects.requireNonNull(aVar, "factory == null");
            list.add(aVar);
            return this;
        }

        public b c(String str) {
            Objects.requireNonNull(str, "baseUrl == null");
            return e(okhttp3.u.C(str));
        }

        public b d(URL url) {
            Objects.requireNonNull(url, "baseUrl == null");
            return e(okhttp3.u.C(url.toString()));
        }

        public b e(okhttp3.u uVar) {
            Objects.requireNonNull(uVar, "baseUrl == null");
            if ("".equals(uVar.L().get(r0.size() - 1))) {
                this.f48738c = uVar;
                return this;
            }
            throw new IllegalArgumentException("baseUrl must end in /: " + uVar);
        }

        public s f() {
            if (this.f48738c == null) {
                throw new IllegalStateException("Base URL required.");
            }
            e.a a0Var = this.f48737b;
            if (a0Var == null) {
                a0Var = new a0();
            }
            e.a aVar = a0Var;
            Executor executorC = this.f48741f;
            if (executorC == null) {
                executorC = this.f48736a.c();
            }
            Executor executor = executorC;
            ArrayList arrayList = new ArrayList(this.f48740e);
            arrayList.addAll(this.f48736a.a(executor));
            ArrayList arrayList2 = new ArrayList(this.f48739d.size() + 1 + this.f48736a.e());
            arrayList2.add(new retrofit2.a());
            arrayList2.addAll(this.f48739d);
            arrayList2.addAll(this.f48736a.d());
            return new s(aVar, this.f48738c, Collections.unmodifiableList(arrayList2), Collections.unmodifiableList(arrayList), executor, this.f48742g);
        }

        public List<c.a> g() {
            return this.f48740e;
        }

        public b h(e.a aVar) {
            Objects.requireNonNull(aVar, "factory == null");
            this.f48737b = aVar;
            return this;
        }

        public b i(Executor executor) {
            Objects.requireNonNull(executor, "executor == null");
            this.f48741f = executor;
            return this;
        }

        public b j(a0 a0Var) {
            Objects.requireNonNull(a0Var, "client == null");
            return h(a0Var);
        }

        public List<f.a> k() {
            return this.f48739d;
        }

        public b l(boolean z10) {
            this.f48742g = z10;
            return this;
        }

        public b() {
            this(o.g());
        }

        public b(s sVar) {
            this.f48739d = new ArrayList();
            this.f48740e = new ArrayList();
            o oVarG = o.g();
            this.f48736a = oVarG;
            this.f48737b = sVar.f48726b;
            this.f48738c = sVar.f48727c;
            int size = sVar.f48728d.size() - oVarG.e();
            for (int i10 = 1; i10 < size; i10++) {
                this.f48739d.add(sVar.f48728d.get(i10));
            }
            int size2 = sVar.f48729e.size() - this.f48736a.b();
            for (int i11 = 0; i11 < size2; i11++) {
                this.f48740e.add(sVar.f48729e.get(i11));
            }
            this.f48741f = sVar.f48730f;
            this.f48742g = sVar.f48731g;
        }
    }
}
