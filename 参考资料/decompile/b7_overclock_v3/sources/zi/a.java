package zi;

import dj.o;
import java.util.Objects;
import java.util.concurrent.Callable;
import xi.h0;

/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile o<Callable<h0>, h0> f58595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile o<h0, h0> f58596b;

    public a() {
        throw new AssertionError("No instances.");
    }

    public static <T, R> R a(o<T, R> oVar, T t10) {
        try {
            return oVar.apply(t10);
        } catch (Throwable th2) {
            throw io.reactivex.exceptions.a.a(th2);
        }
    }

    public static h0 b(o<Callable<h0>, h0> oVar, Callable<h0> callable) {
        h0 h0Var = (h0) a(oVar, callable);
        Objects.requireNonNull(h0Var, "Scheduler Callable returned null");
        return h0Var;
    }

    public static h0 c(Callable<h0> callable) {
        try {
            h0 h0VarCall = callable.call();
            if (h0VarCall != null) {
                return h0VarCall;
            }
            throw new NullPointerException("Scheduler Callable returned null");
        } catch (Throwable th2) {
            throw io.reactivex.exceptions.a.a(th2);
        }
    }

    public static o<Callable<h0>, h0> d() {
        return f58595a;
    }

    public static o<h0, h0> e() {
        return f58596b;
    }

    public static h0 f(Callable<h0> callable) {
        Objects.requireNonNull(callable, "scheduler == null");
        o<Callable<h0>, h0> oVar = f58595a;
        return oVar == null ? c(callable) : b(oVar, callable);
    }

    public static h0 g(h0 h0Var) {
        Objects.requireNonNull(h0Var, "scheduler == null");
        o<h0, h0> oVar = f58596b;
        return oVar == null ? h0Var : (h0) a(oVar, h0Var);
    }

    public static void h() {
        i(null);
        j(null);
    }

    public static void i(o<Callable<h0>, h0> oVar) {
        f58595a = oVar;
    }

    public static void j(o<h0, h0> oVar) {
        f58596b = oVar;
    }
}
