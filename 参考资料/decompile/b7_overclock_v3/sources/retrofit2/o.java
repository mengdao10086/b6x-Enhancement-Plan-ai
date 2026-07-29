package retrofit2;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.c;
import retrofit2.f;

/* JADX INFO: loaded from: classes6.dex */
public class o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final o f48665c = f();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f48666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Constructor<MethodHandles.Lookup> f48667b;

    public static final class a extends o {

        /* JADX INFO: renamed from: retrofit2.o$a$a, reason: collision with other inner class name */
        public static final class ExecutorC0559a implements Executor {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Handler f48668a = new Handler(Looper.getMainLooper());

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f48668a.post(runnable);
            }
        }

        public a() {
            super(Build.VERSION.SDK_INT >= 24);
        }

        @Override // retrofit2.o
        public Executor c() {
            return new ExecutorC0559a();
        }

        @Override // retrofit2.o
        @Nullable
        public Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
            if (Build.VERSION.SDK_INT >= 26) {
                return super.h(method, cls, obj, objArr);
            }
            throw new UnsupportedOperationException("Calling default methods on API 24 and 25 is not supported");
        }
    }

    public o(boolean z10) {
        this.f48666a = z10;
        Constructor<MethodHandles.Lookup> declaredConstructor = null;
        if (z10) {
            try {
                declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
                declaredConstructor.setAccessible(true);
            } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            }
        }
        this.f48667b = declaredConstructor;
    }

    public static o f() {
        return "Dalvik".equals(System.getProperty("java.vm.name")) ? new a() : new o(true);
    }

    public static o g() {
        return f48665c;
    }

    public List<? extends c.a> a(@Nullable Executor executor) {
        g gVar = new g(executor);
        return this.f48666a ? Arrays.asList(e.f48571a, gVar) : Collections.singletonList(gVar);
    }

    public int b() {
        return this.f48666a ? 2 : 1;
    }

    @Nullable
    public Executor c() {
        return null;
    }

    public List<? extends f.a> d() {
        return this.f48666a ? Collections.singletonList(m.f48618a) : Collections.emptyList();
    }

    public int e() {
        return this.f48666a ? 1 : 0;
    }

    @Nullable
    @IgnoreJRERequirement
    public Object h(Method method, Class<?> cls, Object obj, Object... objArr) throws Throwable {
        Constructor<MethodHandles.Lookup> constructor = this.f48667b;
        return (constructor != null ? constructor.newInstance(cls, -1) : MethodHandles.lookup()).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
    }

    @IgnoreJRERequirement
    public boolean i(Method method) {
        return this.f48666a && method.isDefault();
    }
}
