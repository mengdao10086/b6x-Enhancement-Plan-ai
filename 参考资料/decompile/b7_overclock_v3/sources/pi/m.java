package pi;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes5.dex */
public class m<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b<T> f46682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f46683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public pi.a<T> f46684c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f46685d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f46686e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f46687f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public g<T, Object> f46688g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public k f46689h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public i f46690i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public f f46691j;

    public class a implements pi.a<T>, h<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f46692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public m<T>.a.b f46693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public m<T>.a.C0530a f46694c;

        /* JADX INFO: renamed from: pi.m$a$a, reason: collision with other inner class name */
        public class C0530a implements j<T> {
            public C0530a() {
            }

            @Override // pi.j
            public void a(T t10) {
                if (a.this.f46692a.W()) {
                    return;
                }
                try {
                    m.this.f46684c.b(t10);
                } catch (Error | RuntimeException e10) {
                    a.this.f(e10, "Observer failed without an ErrorObserver set");
                }
            }
        }

        public class b implements j<Throwable> {
            public b() {
            }

            @Override // pi.j
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(Throwable th2) {
                if (a.this.f46692a.W()) {
                    return;
                }
                m.this.f46690i.onError(th2);
            }
        }

        public a(e eVar) {
            this.f46692a = eVar;
            if (m.this.f46689h != null) {
                this.f46694c = new C0530a();
                if (m.this.f46690i != null) {
                    this.f46693b = new b();
                }
            }
        }

        @Override // pi.h
        public pi.a<T> a() {
            return m.this.f46684c;
        }

        @Override // pi.a
        public void b(T t10) {
            if (m.this.f46688g != null) {
                g(t10);
            } else {
                e(t10);
            }
        }

        public void e(T t10) {
            if (this.f46692a.W()) {
                return;
            }
            if (m.this.f46689h != null) {
                m.this.f46689h.a(this.f46694c, t10);
                return;
            }
            try {
                m.this.f46684c.b(t10);
            } catch (Error | RuntimeException e10) {
                f(e10, "Observer failed without an ErrorObserver set");
            }
        }

        public final void f(Throwable th2, String str) {
            if (m.this.f46690i == null) {
                RuntimeException runtimeException = new RuntimeException(str, th2);
                runtimeException.printStackTrace();
                throw runtimeException;
            }
            if (this.f46692a.W()) {
                return;
            }
            if (m.this.f46689h != null) {
                m.this.f46689h.a(this.f46693b, th2);
            } else {
                m.this.f46690i.onError(th2);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final void g(T t10) {
            if (this.f46692a.W()) {
                return;
            }
            try {
                e(m.this.f46688g.a(t10));
            } catch (Throwable th2) {
                f(th2, "Transformer failed without an ErrorObserver set");
            }
        }
    }

    @li.c
    public m(b<T> bVar, @Nullable Object obj) {
        this.f46682a = bVar;
        this.f46683b = obj;
    }

    public m<T> e(f fVar) {
        this.f46691j = fVar;
        return this;
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
    public d f(pi.a<T> aVar) {
        n nVar;
        if (this.f46685d) {
            nVar = new n(aVar);
            aVar = nVar;
        } else {
            nVar = null;
        }
        this.f46684c = aVar;
        e eVar = new e(this.f46682a, this.f46683b, aVar);
        if (nVar != null) {
            nVar.c(eVar);
        }
        f fVar = this.f46691j;
        if (fVar != null) {
            fVar.a(eVar);
        }
        if (this.f46688g != null || this.f46689h != null || this.f46690i != null) {
            aVar = new a(eVar);
        }
        if (!this.f46686e) {
            this.f46682a.b(aVar, this.f46683b);
            if (!this.f46687f) {
                this.f46682a.c(aVar, this.f46683b);
            }
        } else {
            if (this.f46687f) {
                throw new IllegalStateException("Illegal combination of single() and onlyChanges()");
            }
            this.f46682a.c(aVar, this.f46683b);
        }
        return eVar;
    }

    public m<T> g(k kVar) {
        if (this.f46689h != null) {
            throw new IllegalStateException("Only one scheduler allowed");
        }
        this.f46689h = kVar;
        return this;
    }

    public m<T> h(i iVar) {
        if (this.f46690i != null) {
            throw new IllegalStateException("Only one errorObserver allowed");
        }
        this.f46690i = iVar;
        return this;
    }

    public m<T> i() {
        this.f46687f = true;
        return this;
    }

    public m<T> j() {
        this.f46686e = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <TO> m<TO> k(g<T, TO> gVar) {
        if (this.f46688g != null) {
            throw new IllegalStateException("Only one transformer allowed");
        }
        this.f46688g = gVar;
        return this;
    }

    public m<T> l() {
        this.f46685d = true;
        return this;
    }
}
