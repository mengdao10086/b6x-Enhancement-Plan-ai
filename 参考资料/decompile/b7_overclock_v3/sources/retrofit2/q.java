package retrofit2;

import com.google.common.net.HttpHeaders;
import com.tencent.connect.common.Constants;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import nu.y;
import okhttp3.b0;
import okhttp3.t;
import okhttp3.x;
import retrofit2.n;

/* JADX INFO: loaded from: classes6.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Method f48685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final okhttp3.u f48686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f48687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f48688d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public final okhttp3.t f48689e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    public final okhttp3.w f48690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f48691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f48692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f48693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n<?>[] f48694j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f48695k;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final s f48699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Method f48700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Annotation[] f48701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Annotation[][] f48702d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Type[] f48703e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f48704f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f48705g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f48706h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f48707i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f48708j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f48709k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f48710l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f48711m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        @Nullable
        public String f48712n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public boolean f48713o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public boolean f48714p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public boolean f48715q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        @Nullable
        public String f48716r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        @Nullable
        public okhttp3.t f48717s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        @Nullable
        public okhttp3.w f48718t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        @Nullable
        public Set<String> f48719u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        @Nullable
        public n<?>[] f48720v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public boolean f48721w;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public static final Pattern f48697y = Pattern.compile("\\{([a-zA-Z][a-zA-Z0-9_-]*)\\}");

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public static final String f48696x = "[a-zA-Z][a-zA-Z0-9_-]*";

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public static final Pattern f48698z = Pattern.compile(f48696x);

        public a(s sVar, Method method) {
            this.f48699a = sVar;
            this.f48700b = method;
            this.f48701c = method.getAnnotations();
            this.f48703e = method.getGenericParameterTypes();
            this.f48702d = method.getParameterAnnotations();
        }

        public static Class<?> a(Class<?> cls) {
            return Boolean.TYPE == cls ? Boolean.class : Byte.TYPE == cls ? Byte.class : Character.TYPE == cls ? Character.class : Double.TYPE == cls ? Double.class : Float.TYPE == cls ? Float.class : Integer.TYPE == cls ? Integer.class : Long.TYPE == cls ? Long.class : Short.TYPE == cls ? Short.class : cls;
        }

        public static Set<String> h(String str) {
            Matcher matcher = f48697y.matcher(str);
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            while (matcher.find()) {
                linkedHashSet.add(matcher.group(1));
            }
            return linkedHashSet;
        }

        public q b() {
            for (Annotation annotation : this.f48701c) {
                e(annotation);
            }
            if (this.f48712n == null) {
                throw w.m(this.f48700b, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
            }
            if (!this.f48713o) {
                if (this.f48715q) {
                    throw w.m(this.f48700b, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
                if (this.f48714p) {
                    throw w.m(this.f48700b, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
                }
            }
            int length = this.f48702d.length;
            this.f48720v = new n[length];
            int i10 = length - 1;
            int i11 = 0;
            while (true) {
                boolean z10 = true;
                if (i11 >= length) {
                    break;
                }
                n<?>[] nVarArr = this.f48720v;
                Type type = this.f48703e[i11];
                Annotation[] annotationArr = this.f48702d[i11];
                if (i11 != i10) {
                    z10 = false;
                }
                nVarArr[i11] = f(i11, type, annotationArr, z10);
                i11++;
            }
            if (this.f48716r == null && !this.f48711m) {
                throw w.m(this.f48700b, "Missing either @%s URL or @Url parameter.", this.f48712n);
            }
            boolean z11 = this.f48714p;
            if (!z11 && !this.f48715q && !this.f48713o && this.f48706h) {
                throw w.m(this.f48700b, "Non-body HTTP method cannot contain @Body.", new Object[0]);
            }
            if (z11 && !this.f48704f) {
                throw w.m(this.f48700b, "Form-encoded method must contain at least one @Field.", new Object[0]);
            }
            if (!this.f48715q || this.f48705g) {
                return new q(this);
            }
            throw w.m(this.f48700b, "Multipart method must contain at least one @Part.", new Object[0]);
        }

        public final okhttp3.t c(String[] strArr) {
            t.a aVar = new t.a();
            for (String str : strArr) {
                int iIndexOf = str.indexOf(58);
                if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                    throw w.m(this.f48700b, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                }
                String strSubstring = str.substring(0, iIndexOf);
                String strTrim = str.substring(iIndexOf + 1).trim();
                if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                    try {
                        this.f48718t = okhttp3.w.h(strTrim);
                    } catch (IllegalArgumentException e10) {
                        throw w.n(this.f48700b, e10, "Malformed content type: %s", strTrim);
                    }
                } else {
                    aVar.b(strSubstring, strTrim);
                }
            }
            return aVar.i();
        }

        public final void d(String str, String str2, boolean z10) {
            String str3 = this.f48712n;
            if (str3 != null) {
                throw w.m(this.f48700b, "Only one HTTP method is allowed. Found: %s and %s.", str3, str);
            }
            this.f48712n = str;
            this.f48713o = z10;
            if (str2.isEmpty()) {
                return;
            }
            int iIndexOf = str2.indexOf(63);
            if (iIndexOf != -1 && iIndexOf < str2.length() - 1) {
                String strSubstring = str2.substring(iIndexOf + 1);
                if (f48697y.matcher(strSubstring).find()) {
                    throw w.m(this.f48700b, "URL query string \"%s\" must not have replace block. For dynamic query parameters use @Query.", strSubstring);
                }
            }
            this.f48716r = str2;
            this.f48719u = h(str2);
        }

        public final void e(Annotation annotation) {
            if (annotation instanceof nu.b) {
                d("DELETE", ((nu.b) annotation).value(), false);
                return;
            }
            if (annotation instanceof nu.f) {
                d(Constants.HTTP_GET, ((nu.f) annotation).value(), false);
                return;
            }
            if (annotation instanceof nu.g) {
                d("HEAD", ((nu.g) annotation).value(), false);
                return;
            }
            if (annotation instanceof nu.n) {
                d("PATCH", ((nu.n) annotation).value(), true);
                return;
            }
            if (annotation instanceof nu.o) {
                d(Constants.HTTP_POST, ((nu.o) annotation).value(), true);
                return;
            }
            if (annotation instanceof nu.p) {
                d("PUT", ((nu.p) annotation).value(), true);
                return;
            }
            if (annotation instanceof nu.m) {
                d("OPTIONS", ((nu.m) annotation).value(), false);
                return;
            }
            if (annotation instanceof nu.h) {
                nu.h hVar = (nu.h) annotation;
                d(hVar.method(), hVar.path(), hVar.hasBody());
                return;
            }
            if (annotation instanceof nu.k) {
                String[] strArrValue = ((nu.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw w.m(this.f48700b, "@Headers annotation is empty.", new Object[0]);
                }
                this.f48717s = c(strArrValue);
                return;
            }
            if (annotation instanceof nu.l) {
                if (this.f48714p) {
                    throw w.m(this.f48700b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f48715q = true;
            } else if (annotation instanceof nu.e) {
                if (this.f48715q) {
                    throw w.m(this.f48700b, "Only one encoding annotation is allowed.", new Object[0]);
                }
                this.f48714p = true;
            }
        }

        @Nullable
        public final n<?> f(int i10, Type type, @Nullable Annotation[] annotationArr, boolean z10) {
            n<?> nVar;
            if (annotationArr != null) {
                nVar = null;
                for (Annotation annotation : annotationArr) {
                    n<?> nVarG = g(i10, type, annotationArr, annotation);
                    if (nVarG != null) {
                        if (nVar != null) {
                            throw w.o(this.f48700b, i10, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        nVar = nVarG;
                    }
                }
            } else {
                nVar = null;
            }
            if (nVar != null) {
                return nVar;
            }
            if (z10) {
                try {
                    if (w.h(type) == kotlin.coroutines.c.class) {
                        this.f48721w = true;
                        return null;
                    }
                } catch (NoClassDefFoundError unused) {
                }
            }
            throw w.o(this.f48700b, i10, "No Retrofit annotation found.", new Object[0]);
        }

        @Nullable
        public final n<?> g(int i10, Type type, Annotation[] annotationArr, Annotation annotation) {
            if (annotation instanceof y) {
                j(i10, type);
                if (this.f48711m) {
                    throw w.o(this.f48700b, i10, "Multiple @Url method annotations found.", new Object[0]);
                }
                if (this.f48707i) {
                    throw w.o(this.f48700b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f48708j) {
                    throw w.o(this.f48700b, i10, "A @Url parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f48709k) {
                    throw w.o(this.f48700b, i10, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f48710l) {
                    throw w.o(this.f48700b, i10, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f48716r != null) {
                    throw w.o(this.f48700b, i10, "@Url cannot be used with @%s URL", this.f48712n);
                }
                this.f48711m = true;
                if (type == okhttp3.u.class || type == String.class || type == URI.class || ((type instanceof Class) && "android.net.Uri".equals(((Class) type).getName()))) {
                    return new n.p(this.f48700b, i10);
                }
                throw w.o(this.f48700b, i10, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
            }
            if (annotation instanceof nu.s) {
                j(i10, type);
                if (this.f48708j) {
                    throw w.o(this.f48700b, i10, "A @Path parameter must not come after a @Query.", new Object[0]);
                }
                if (this.f48709k) {
                    throw w.o(this.f48700b, i10, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                }
                if (this.f48710l) {
                    throw w.o(this.f48700b, i10, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                }
                if (this.f48711m) {
                    throw w.o(this.f48700b, i10, "@Path parameters may not be used with @Url.", new Object[0]);
                }
                if (this.f48716r == null) {
                    throw w.o(this.f48700b, i10, "@Path can only be used with relative url on @%s", this.f48712n);
                }
                this.f48707i = true;
                nu.s sVar = (nu.s) annotation;
                String strValue = sVar.value();
                i(i10, strValue);
                return new n.k(this.f48700b, i10, strValue, this.f48699a.o(type, annotationArr), sVar.encoded());
            }
            if (annotation instanceof nu.t) {
                j(i10, type);
                nu.t tVar = (nu.t) annotation;
                String strValue2 = tVar.value();
                boolean zEncoded = tVar.encoded();
                Class<?> clsH = w.h(type);
                this.f48708j = true;
                if (!Iterable.class.isAssignableFrom(clsH)) {
                    return clsH.isArray() ? new n.l(strValue2, this.f48699a.o(a(clsH.getComponentType()), annotationArr), zEncoded).b() : new n.l(strValue2, this.f48699a.o(type, annotationArr), zEncoded);
                }
                if (type instanceof ParameterizedType) {
                    return new n.l(strValue2, this.f48699a.o(w.g(0, (ParameterizedType) type), annotationArr), zEncoded).c();
                }
                throw w.o(this.f48700b, i10, clsH.getSimpleName() + " must include generic type (e.g., " + clsH.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof nu.v) {
                j(i10, type);
                boolean zEncoded2 = ((nu.v) annotation).encoded();
                Class<?> clsH2 = w.h(type);
                this.f48709k = true;
                if (!Iterable.class.isAssignableFrom(clsH2)) {
                    return clsH2.isArray() ? new n.C0558n(this.f48699a.o(a(clsH2.getComponentType()), annotationArr), zEncoded2).b() : new n.C0558n(this.f48699a.o(type, annotationArr), zEncoded2);
                }
                if (type instanceof ParameterizedType) {
                    return new n.C0558n(this.f48699a.o(w.g(0, (ParameterizedType) type), annotationArr), zEncoded2).c();
                }
                throw w.o(this.f48700b, i10, clsH2.getSimpleName() + " must include generic type (e.g., " + clsH2.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof nu.u) {
                j(i10, type);
                Class<?> clsH3 = w.h(type);
                this.f48710l = true;
                if (!Map.class.isAssignableFrom(clsH3)) {
                    throw w.o(this.f48700b, i10, "@QueryMap parameter type must be Map.", new Object[0]);
                }
                Type typeI = w.i(type, clsH3, Map.class);
                if (!(typeI instanceof ParameterizedType)) {
                    throw w.o(this.f48700b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType = (ParameterizedType) typeI;
                Type typeG = w.g(0, parameterizedType);
                if (String.class == typeG) {
                    return new n.m(this.f48700b, i10, this.f48699a.o(w.g(1, parameterizedType), annotationArr), ((nu.u) annotation).encoded());
                }
                throw w.o(this.f48700b, i10, "@QueryMap keys must be of type String: " + typeG, new Object[0]);
            }
            if (annotation instanceof nu.i) {
                j(i10, type);
                String strValue3 = ((nu.i) annotation).value();
                Class<?> clsH4 = w.h(type);
                if (!Iterable.class.isAssignableFrom(clsH4)) {
                    return clsH4.isArray() ? new n.f(strValue3, this.f48699a.o(a(clsH4.getComponentType()), annotationArr)).b() : new n.f(strValue3, this.f48699a.o(type, annotationArr));
                }
                if (type instanceof ParameterizedType) {
                    return new n.f(strValue3, this.f48699a.o(w.g(0, (ParameterizedType) type), annotationArr)).c();
                }
                throw w.o(this.f48700b, i10, clsH4.getSimpleName() + " must include generic type (e.g., " + clsH4.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof nu.j) {
                if (type == okhttp3.t.class) {
                    return new n.h(this.f48700b, i10);
                }
                j(i10, type);
                Class<?> clsH5 = w.h(type);
                if (!Map.class.isAssignableFrom(clsH5)) {
                    throw w.o(this.f48700b, i10, "@HeaderMap parameter type must be Map.", new Object[0]);
                }
                Type typeI2 = w.i(type, clsH5, Map.class);
                if (!(typeI2 instanceof ParameterizedType)) {
                    throw w.o(this.f48700b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType2 = (ParameterizedType) typeI2;
                Type typeG2 = w.g(0, parameterizedType2);
                if (String.class == typeG2) {
                    return new n.g(this.f48700b, i10, this.f48699a.o(w.g(1, parameterizedType2), annotationArr));
                }
                throw w.o(this.f48700b, i10, "@HeaderMap keys must be of type String: " + typeG2, new Object[0]);
            }
            if (annotation instanceof nu.c) {
                j(i10, type);
                if (!this.f48714p) {
                    throw w.o(this.f48700b, i10, "@Field parameters can only be used with form encoding.", new Object[0]);
                }
                nu.c cVar = (nu.c) annotation;
                String strValue4 = cVar.value();
                boolean zEncoded3 = cVar.encoded();
                this.f48704f = true;
                Class<?> clsH6 = w.h(type);
                if (!Iterable.class.isAssignableFrom(clsH6)) {
                    return clsH6.isArray() ? new n.d(strValue4, this.f48699a.o(a(clsH6.getComponentType()), annotationArr), zEncoded3).b() : new n.d(strValue4, this.f48699a.o(type, annotationArr), zEncoded3);
                }
                if (type instanceof ParameterizedType) {
                    return new n.d(strValue4, this.f48699a.o(w.g(0, (ParameterizedType) type), annotationArr), zEncoded3).c();
                }
                throw w.o(this.f48700b, i10, clsH6.getSimpleName() + " must include generic type (e.g., " + clsH6.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof nu.d) {
                j(i10, type);
                if (!this.f48714p) {
                    throw w.o(this.f48700b, i10, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                }
                Class<?> clsH7 = w.h(type);
                if (!Map.class.isAssignableFrom(clsH7)) {
                    throw w.o(this.f48700b, i10, "@FieldMap parameter type must be Map.", new Object[0]);
                }
                Type typeI3 = w.i(type, clsH7, Map.class);
                if (!(typeI3 instanceof ParameterizedType)) {
                    throw w.o(this.f48700b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType3 = (ParameterizedType) typeI3;
                Type typeG3 = w.g(0, parameterizedType3);
                if (String.class == typeG3) {
                    f fVarO = this.f48699a.o(w.g(1, parameterizedType3), annotationArr);
                    this.f48704f = true;
                    return new n.e(this.f48700b, i10, fVarO, ((nu.d) annotation).encoded());
                }
                throw w.o(this.f48700b, i10, "@FieldMap keys must be of type String: " + typeG3, new Object[0]);
            }
            if (annotation instanceof nu.q) {
                j(i10, type);
                if (!this.f48715q) {
                    throw w.o(this.f48700b, i10, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                }
                nu.q qVar = (nu.q) annotation;
                this.f48705g = true;
                String strValue5 = qVar.value();
                Class<?> clsH8 = w.h(type);
                if (strValue5.isEmpty()) {
                    if (!Iterable.class.isAssignableFrom(clsH8)) {
                        if (clsH8.isArray()) {
                            if (x.c.class.isAssignableFrom(clsH8.getComponentType())) {
                                return n.o.f48661a.b();
                            }
                            throw w.o(this.f48700b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                        }
                        if (x.c.class.isAssignableFrom(clsH8)) {
                            return n.o.f48661a;
                        }
                        throw w.o(this.f48700b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    if (type instanceof ParameterizedType) {
                        if (x.c.class.isAssignableFrom(w.h(w.g(0, (ParameterizedType) type)))) {
                            return n.o.f48661a.c();
                        }
                        throw w.o(this.f48700b, i10, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                    }
                    throw w.o(this.f48700b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
                }
                okhttp3.t tVarP = okhttp3.t.p(HttpHeaders.CONTENT_DISPOSITION, "form-data; name=\"" + strValue5 + "\"", "Content-Transfer-Encoding", qVar.encoding());
                if (!Iterable.class.isAssignableFrom(clsH8)) {
                    if (!clsH8.isArray()) {
                        if (x.c.class.isAssignableFrom(clsH8)) {
                            throw w.o(this.f48700b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                        }
                        return new n.i(this.f48700b, i10, tVarP, this.f48699a.m(type, annotationArr, this.f48701c));
                    }
                    Class<?> clsA = a(clsH8.getComponentType());
                    if (x.c.class.isAssignableFrom(clsA)) {
                        throw w.o(this.f48700b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.f48700b, i10, tVarP, this.f48699a.m(clsA, annotationArr, this.f48701c)).b();
                }
                if (type instanceof ParameterizedType) {
                    Type typeG4 = w.g(0, (ParameterizedType) type);
                    if (x.c.class.isAssignableFrom(w.h(typeG4))) {
                        throw w.o(this.f48700b, i10, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                    }
                    return new n.i(this.f48700b, i10, tVarP, this.f48699a.m(typeG4, annotationArr, this.f48701c)).c();
                }
                throw w.o(this.f48700b, i10, clsH8.getSimpleName() + " must include generic type (e.g., " + clsH8.getSimpleName() + "<String>)", new Object[0]);
            }
            if (annotation instanceof nu.r) {
                j(i10, type);
                if (!this.f48715q) {
                    throw w.o(this.f48700b, i10, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                }
                this.f48705g = true;
                Class<?> clsH9 = w.h(type);
                if (!Map.class.isAssignableFrom(clsH9)) {
                    throw w.o(this.f48700b, i10, "@PartMap parameter type must be Map.", new Object[0]);
                }
                Type typeI4 = w.i(type, clsH9, Map.class);
                if (!(typeI4 instanceof ParameterizedType)) {
                    throw w.o(this.f48700b, i10, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                }
                ParameterizedType parameterizedType4 = (ParameterizedType) typeI4;
                Type typeG5 = w.g(0, parameterizedType4);
                if (String.class == typeG5) {
                    Type typeG6 = w.g(1, parameterizedType4);
                    if (x.c.class.isAssignableFrom(w.h(typeG6))) {
                        throw w.o(this.f48700b, i10, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                    }
                    return new n.j(this.f48700b, i10, this.f48699a.m(typeG6, annotationArr, this.f48701c), ((nu.r) annotation).encoding());
                }
                throw w.o(this.f48700b, i10, "@PartMap keys must be of type String: " + typeG5, new Object[0]);
            }
            if (annotation instanceof nu.a) {
                j(i10, type);
                if (this.f48714p || this.f48715q) {
                    throw w.o(this.f48700b, i10, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                }
                if (this.f48706h) {
                    throw w.o(this.f48700b, i10, "Multiple @Body method annotations found.", new Object[0]);
                }
                try {
                    f fVarM = this.f48699a.m(type, annotationArr, this.f48701c);
                    this.f48706h = true;
                    return new n.c(this.f48700b, i10, fVarM);
                } catch (RuntimeException e10) {
                    throw w.p(this.f48700b, e10, i10, "Unable to create @Body converter for %s", type);
                }
            }
            if (!(annotation instanceof nu.x)) {
                return null;
            }
            j(i10, type);
            Class<?> clsH10 = w.h(type);
            for (int i11 = i10 - 1; i11 >= 0; i11--) {
                n<?> nVar = this.f48720v[i11];
                if ((nVar instanceof n.q) && ((n.q) nVar).f48664a.equals(clsH10)) {
                    throw w.o(this.f48700b, i10, "@Tag type " + clsH10.getName() + " is duplicate of parameter #" + (i11 + 1) + " and would always overwrite its value.", new Object[0]);
                }
            }
            return new n.q(clsH10);
        }

        public final void i(int i10, String str) {
            if (!f48698z.matcher(str).matches()) {
                throw w.o(this.f48700b, i10, "@Path parameter name must match %s. Found: %s", f48697y.pattern(), str);
            }
            if (!this.f48719u.contains(str)) {
                throw w.o(this.f48700b, i10, "URL \"%s\" does not contain \"{%s}\".", this.f48716r, str);
            }
        }

        public final void j(int i10, Type type) {
            if (w.j(type)) {
                throw w.o(this.f48700b, i10, "Parameter type must not include a type variable or wildcard: %s", type);
            }
        }
    }

    public q(a aVar) {
        this.f48685a = aVar.f48700b;
        this.f48686b = aVar.f48699a.f48727c;
        this.f48687c = aVar.f48712n;
        this.f48688d = aVar.f48716r;
        this.f48689e = aVar.f48717s;
        this.f48690f = aVar.f48718t;
        this.f48691g = aVar.f48713o;
        this.f48692h = aVar.f48714p;
        this.f48693i = aVar.f48715q;
        this.f48694j = aVar.f48720v;
        this.f48695k = aVar.f48721w;
    }

    public static q b(s sVar, Method method) {
        return new a(sVar, method).b();
    }

    public b0 a(Object[] objArr) throws IOException {
        n<?>[] nVarArr = this.f48694j;
        int length = objArr.length;
        if (length != nVarArr.length) {
            throw new IllegalArgumentException("Argument count (" + length + ") doesn't match expected count (" + nVarArr.length + ee.a.f26979d);
        }
        p pVar = new p(this.f48687c, this.f48686b, this.f48688d, this.f48689e, this.f48690f, this.f48691g, this.f48692h, this.f48693i);
        if (this.f48695k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(objArr[i10]);
            nVarArr[i10].a(pVar, objArr[i10]);
        }
        return pVar.k().z(k.class, new k(this.f48685a, arrayList)).b();
    }
}
