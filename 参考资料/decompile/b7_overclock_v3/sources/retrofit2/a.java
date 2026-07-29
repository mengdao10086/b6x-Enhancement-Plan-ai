package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.z1;
import okhttp3.c0;
import okhttp3.e0;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f48564a = true;

    /* JADX INFO: renamed from: retrofit2.a$a, reason: collision with other inner class name */
    public static final class C0556a implements retrofit2.f<e0, e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0556a f48565a = new C0556a();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e0 a(e0 e0Var) throws IOException {
            try {
                return w.a(e0Var);
            } finally {
                e0Var.close();
            }
        }
    }

    public static final class b implements retrofit2.f<c0, c0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f48566a = new b();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public c0 a(c0 c0Var) {
            return c0Var;
        }
    }

    public static final class c implements retrofit2.f<e0, e0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f48567a = new c();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public e0 a(e0 e0Var) {
            return e0Var;
        }
    }

    public static final class d implements retrofit2.f<Object, String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f48568a = new d();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public String a(Object obj) {
            return obj.toString();
        }
    }

    public static final class e implements retrofit2.f<e0, z1> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f48569a = new e();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public z1 a(e0 e0Var) {
            e0Var.close();
            return z1.f38230a;
        }
    }

    public static final class f implements retrofit2.f<e0, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f48570a = new f();

        @Override // retrofit2.f
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(e0 e0Var) {
            e0Var.close();
            return null;
        }
    }

    @Override // retrofit2.f.a
    @Nullable
    public retrofit2.f<?, c0> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        if (c0.class.isAssignableFrom(w.h(type))) {
            return b.f48566a;
        }
        return null;
    }

    @Override // retrofit2.f.a
    @Nullable
    public retrofit2.f<e0, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (type == e0.class) {
            return w.l(annotationArr, nu.w.class) ? c.f48567a : C0556a.f48565a;
        }
        if (type == Void.class) {
            return f.f48570a;
        }
        if (!this.f48564a || type != z1.class) {
            return null;
        }
        try {
            return e.f48569a;
        } catch (NoClassDefFoundError unused) {
            this.f48564a = false;
            return null;
        }
    }
}
