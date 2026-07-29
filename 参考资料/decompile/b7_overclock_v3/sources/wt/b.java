package wt;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/* JADX INFO: loaded from: classes6.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f54810a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Constructor<?> f54811b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final tt.c f54812c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f54813d;

    /* JADX INFO: renamed from: wt.b$b, reason: collision with other inner class name */
    public static class C0642b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Executor f54814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Class<?> f54815b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public tt.c f54816c;

        public b a() {
            return b(null);
        }

        public b b(Object obj) {
            if (this.f54816c == null) {
                this.f54816c = tt.c.f();
            }
            if (this.f54814a == null) {
                this.f54814a = Executors.newCachedThreadPool();
            }
            if (this.f54815b == null) {
                this.f54815b = e.class;
            }
            return new b(this.f54814a, this.f54816c, this.f54815b, obj);
        }

        public C0642b c(tt.c cVar) {
            this.f54816c = cVar;
            return this;
        }

        public C0642b d(Class<?> cls) {
            this.f54815b = cls;
            return this;
        }

        public C0642b e(Executor executor) {
            this.f54814a = executor;
            return this;
        }

        public C0642b() {
        }
    }

    public interface c {
        void run() throws Exception;
    }

    public static C0642b b() {
        return new C0642b();
    }

    public static b c() {
        return new C0642b().a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(c cVar) {
        try {
            cVar.run();
        } catch (Exception e10) {
            try {
                Object objNewInstance = this.f54811b.newInstance(e10);
                if (objNewInstance instanceof d) {
                    ((d) objNewInstance).a(this.f54813d);
                }
                this.f54812c.q(objNewInstance);
            } catch (Exception e11) {
                this.f54812c.h().b(Level.SEVERE, "Original exception:", e10);
                throw new RuntimeException("Could not create failure event", e11);
            }
        }
    }

    public void d(final c cVar) {
        this.f54810a.execute(new Runnable() { // from class: wt.a
            @Override // java.lang.Runnable
            public final void run() {
                this.f54808a.e(cVar);
            }
        });
    }

    public b(Executor executor, tt.c cVar, Class<?> cls, Object obj) {
        this.f54810a = executor;
        this.f54812c = cVar;
        this.f54813d = obj;
        try {
            this.f54811b = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e10) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e10);
        }
    }
}
