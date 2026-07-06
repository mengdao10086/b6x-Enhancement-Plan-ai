package a;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ed2 extends gf2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f5991a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ed2 f722a = new ed2();
    public static boolean b;
    public static volatile Executor pool;

    static {
        String property;
        int iIntValue;
        try {
            property = System.getProperty("kotlinx.coroutines.default.parallelism");
        } catch (Throwable unused) {
            property = null;
        }
        if (property != null) {
            Integer numJ = ac2.j(property);
            if (numJ == null || numJ.intValue() < 1) {
                throw new IllegalStateException(("Expected positive number in kotlinx.coroutines.default.parallelism, but has " + property).toString());
            }
            iIntValue = numJ.intValue();
        } else {
            iIntValue = -1;
        }
        f5991a = iIntValue;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on CommonPool".toString());
    }

    @Override // a.od2
    public void l(l62 l62Var, Runnable runnable) {
        Runnable runnableB;
        try {
            Executor executorV = pool;
            if (executorV == null) {
                executorV = v();
            }
            rg2 rg2VarA = sg2.a();
            if (rg2VarA == null || (runnableB = rg2VarA.b(runnable)) == null) {
                runnableB = runnable;
            }
            executorV.execute(runnableB);
        } catch (RejectedExecutionException unused) {
            rg2 rg2VarA2 = sg2.a();
            if (rg2VarA2 != null) {
                rg2VarA2.f();
            }
            de2.f5890a.O(runnable);
        }
    }

    public final ExecutorService p() {
        return Executors.newFixedThreadPool(w(), new cd2(new AtomicInteger()));
    }

    public final ExecutorService t() {
        Class<?> cls;
        ExecutorService executorService;
        if (System.getSecurityManager() != null) {
            return p();
        }
        ExecutorService executorService2 = null;
        try {
            cls = Class.forName("java.util.concurrent.ForkJoinPool");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return p();
        }
        if (!b && f5991a < 0) {
            try {
                Method method = cls.getMethod("commonPool", new Class[0]);
                Object objInvoke = method != null ? method.invoke(null, new Object[0]) : null;
                if (!(objInvoke instanceof ExecutorService)) {
                    objInvoke = null;
                }
                executorService = (ExecutorService) objInvoke;
            } catch (Throwable unused2) {
                executorService = null;
            }
            if (executorService != null) {
                if (!f722a.y(cls, executorService)) {
                    executorService = null;
                }
                if (executorService != null) {
                    return executorService;
                }
            }
        }
        try {
            Object objNewInstance = cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(f722a.w()));
            if (!(objNewInstance instanceof ExecutorService)) {
                objNewInstance = null;
            }
            executorService2 = (ExecutorService) objNewInstance;
        } catch (Throwable unused3) {
        }
        return executorService2 != null ? executorService2 : p();
    }

    @Override // a.od2
    public String toString() {
        return "CommonPool";
    }

    public final synchronized Executor v() {
        Executor executorT;
        executorT = pool;
        if (executorT == null) {
            executorT = t();
            pool = executorT;
        }
        return executorT;
    }

    public final int w() {
        Integer numValueOf = Integer.valueOf(f5991a);
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        return numValueOf != null ? numValueOf.intValue() : ga2.b(Runtime.getRuntime().availableProcessors() - 1, 1);
    }

    public final boolean y(Class<?> cls, ExecutorService executorService) {
        executorService.submit(dd2.f5887a);
        Integer num = null;
        try {
            Object objInvoke = cls.getMethod("getPoolSize", new Class[0]).invoke(executorService, new Object[0]);
            if (!(objInvoke instanceof Integer)) {
                objInvoke = null;
            }
            num = (Integer) objInvoke;
        } catch (Throwable unused) {
        }
        return num != null && num.intValue() >= 1;
    }
}
