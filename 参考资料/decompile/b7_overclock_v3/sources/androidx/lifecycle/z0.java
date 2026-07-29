package androidx.lifecycle;

import android.app.Application;
import androidx.annotation.RestrictTo;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import p1.a;

/* JADX INFO: loaded from: classes2.dex */
@kotlin.jvm.internal.t0({"SMAP\nViewModelProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ViewModelProvider.kt\nandroidx/lifecycle/ViewModelProvider\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,375:1\n1#2:376\n*E\n"})
public class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public final c1 f6272a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @yt.k
    public final b f6273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @yt.k
    public final p1.a f6274c;

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @yt.k
        public static final a f6281a = a.f6282a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ a f6282a = new a();

            @hk.m
            @yt.k
            public final b a(@yt.k p1.g<?>... initializers) {
                kotlin.jvm.internal.f0.p(initializers, "initializers");
                return new p1.b((p1.g[]) Arrays.copyOf(initializers, initializers.length));
            }
        }

        @yt.k
        <T extends x0> T a(@yt.k Class<T> cls);

        @yt.k
        <T extends x0> T b(@yt.k Class<T> cls, @yt.k p1.a aVar);
    }

    public static class c implements b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @yt.l
        public static c f6284c;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @yt.k
        public static final a f6283b = new a(null);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @hk.e
        @yt.k
        public static final a.b<String> f6285d = a.C0056a.f6286a;

        public static final class a {

            /* JADX INFO: renamed from: androidx.lifecycle.z0$c$a$a, reason: collision with other inner class name */
            public static final class C0056a implements a.b<String> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                @yt.k
                public static final C0056a f6286a = new C0056a();
            }

            public a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.u uVar) {
                this();
            }

            @hk.m
            public static /* synthetic */ void b() {
            }

            @yt.k
            @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
            public final c a() {
                if (c.f6284c == null) {
                    c.f6284c = new c();
                }
                c cVar = c.f6284c;
                kotlin.jvm.internal.f0.m(cVar);
                return cVar;
            }
        }

        @yt.k
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public static final c e() {
            return f6283b.a();
        }

        @Override // androidx.lifecycle.z0.b
        @yt.k
        public <T extends x0> T a(@yt.k Class<T> modelClass) throws InvocationTargetException {
            kotlin.jvm.internal.f0.p(modelClass, "modelClass");
            try {
                T tNewInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                kotlin.jvm.internal.f0.o(tNewInstance, "{\n                modelC…wInstance()\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e12);
            }
        }

        @Override // androidx.lifecycle.z0.b
        public /* synthetic */ x0 b(Class cls, p1.a aVar) {
            return a1.b(this, cls, aVar);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class d {
        public void c(@yt.k x0 viewModel) {
            kotlin.jvm.internal.f0.p(viewModel, "viewModel");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @hk.i
    public z0(@yt.k c1 store, @yt.k b factory) {
        this(store, factory, null, 4, null);
        kotlin.jvm.internal.f0.p(store, "store");
        kotlin.jvm.internal.f0.p(factory, "factory");
    }

    @hk.i
    public z0(@yt.k c1 store, @yt.k b factory, @yt.k p1.a defaultCreationExtras) {
        kotlin.jvm.internal.f0.p(store, "store");
        kotlin.jvm.internal.f0.p(factory, "factory");
        kotlin.jvm.internal.f0.p(defaultCreationExtras, "defaultCreationExtras");
        this.f6272a = store;
        this.f6273b = factory;
        this.f6274c = defaultCreationExtras;
    }

    @g.k0
    @yt.k
    public <T extends x0> T a(@yt.k Class<T> modelClass) {
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) b("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @g.k0
    @yt.k
    public <T extends x0> T b(@yt.k String key, @yt.k Class<T> modelClass) {
        T t10;
        kotlin.jvm.internal.f0.p(key, "key");
        kotlin.jvm.internal.f0.p(modelClass, "modelClass");
        T t11 = (T) this.f6272a.b(key);
        if (!modelClass.isInstance(t11)) {
            p1.e eVar = new p1.e(this.f6274c);
            eVar.c(c.f6285d, key);
            try {
                t10 = (T) this.f6273b.b(modelClass, eVar);
            } catch (AbstractMethodError unused) {
                t10 = (T) this.f6273b.a(modelClass);
            }
            this.f6272a.d(key, t10);
            return t10;
        }
        Object obj = this.f6273b;
        d dVar = obj instanceof d ? (d) obj : null;
        if (dVar != null) {
            kotlin.jvm.internal.f0.m(t11);
            dVar.c(t11);
        }
        kotlin.jvm.internal.f0.n(t11, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
        return t11;
    }

    public static class a extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @yt.k
        public static final String f6276g = "androidx.lifecycle.ViewModelProvider.DefaultKey";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @yt.l
        public static a f6277h;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @yt.l
        public final Application f6279e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @yt.k
        public static final C0054a f6275f = new C0054a(null);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @hk.e
        @yt.k
        public static final a.b<Application> f6278i = C0054a.C0055a.f6280a;

        /* JADX INFO: renamed from: androidx.lifecycle.z0$a$a, reason: collision with other inner class name */
        public static final class C0054a {

            /* JADX INFO: renamed from: androidx.lifecycle.z0$a$a$a, reason: collision with other inner class name */
            public static final class C0055a implements a.b<Application> {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                @yt.k
                public static final C0055a f6280a = new C0055a();
            }

            public C0054a() {
            }

            public /* synthetic */ C0054a(kotlin.jvm.internal.u uVar) {
                this();
            }

            @yt.k
            public final b a(@yt.k d1 owner) {
                kotlin.jvm.internal.f0.p(owner, "owner");
                return owner instanceof r ? ((r) owner).h0() : c.f6283b.a();
            }

            @hk.m
            @yt.k
            public final a b(@yt.k Application application) {
                kotlin.jvm.internal.f0.p(application, "application");
                if (a.f6277h == null) {
                    a.f6277h = new a(application);
                }
                a aVar = a.f6277h;
                kotlin.jvm.internal.f0.m(aVar);
                return aVar;
            }
        }

        public a(Application application, int i10) {
            this.f6279e = application;
        }

        @hk.m
        @yt.k
        public static final a i(@yt.k Application application) {
            return f6275f.b(application);
        }

        @Override // androidx.lifecycle.z0.c, androidx.lifecycle.z0.b
        @yt.k
        public <T extends x0> T a(@yt.k Class<T> modelClass) {
            kotlin.jvm.internal.f0.p(modelClass, "modelClass");
            Application application = this.f6279e;
            if (application != null) {
                return (T) h(modelClass, application);
            }
            throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
        }

        @Override // androidx.lifecycle.z0.c, androidx.lifecycle.z0.b
        @yt.k
        public <T extends x0> T b(@yt.k Class<T> modelClass, @yt.k p1.a extras) {
            kotlin.jvm.internal.f0.p(modelClass, "modelClass");
            kotlin.jvm.internal.f0.p(extras, "extras");
            if (this.f6279e != null) {
                return (T) a(modelClass);
            }
            Application application = (Application) extras.a(f6278i);
            if (application != null) {
                return (T) h(modelClass, application);
            }
            if (androidx.lifecycle.b.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return (T) super.a(modelClass);
        }

        public final <T extends x0> T h(Class<T> cls, Application application) {
            if (!androidx.lifecycle.b.class.isAssignableFrom(cls)) {
                return (T) super.a(cls);
            }
            try {
                T tNewInstance = cls.getConstructor(Application.class).newInstance(application);
                kotlin.jvm.internal.f0.o(tNewInstance, "{\n                try {\n…          }\n            }");
                return tNewInstance;
            } catch (IllegalAccessException e10) {
                throw new RuntimeException("Cannot create an instance of " + cls, e10);
            } catch (InstantiationException e11) {
                throw new RuntimeException("Cannot create an instance of " + cls, e11);
            } catch (NoSuchMethodException e12) {
                throw new RuntimeException("Cannot create an instance of " + cls, e12);
            } catch (InvocationTargetException e13) {
                throw new RuntimeException("Cannot create an instance of " + cls, e13);
            }
        }

        public a() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a(@yt.k Application application) {
            this(application, 0);
            kotlin.jvm.internal.f0.p(application, "application");
        }
    }

    public /* synthetic */ z0(c1 c1Var, b bVar, p1.a aVar, int i10, kotlin.jvm.internal.u uVar) {
        this(c1Var, bVar, (i10 & 4) != 0 ? a.C0519a.f46302b : aVar);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z0(@yt.k d1 owner) {
        this(owner.O0(), a.f6275f.a(owner), b1.a(owner));
        kotlin.jvm.internal.f0.p(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public z0(@yt.k d1 owner, @yt.k b factory) {
        this(owner.O0(), factory, b1.a(owner));
        kotlin.jvm.internal.f0.p(owner, "owner");
        kotlin.jvm.internal.f0.p(factory, "factory");
    }
}
