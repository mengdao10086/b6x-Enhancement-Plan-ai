package com.blankj.utilcode.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import androidx.lifecycle.Lifecycle;
import com.blankj.utilcode.util.ThreadUtils;
import java.util.Objects;

/* JADX INFO: loaded from: classes2.dex */
public final class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    public static Application f11894a;

    public static class a {
        public void a(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void b(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void c(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void d(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void e(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void f(@g.n0 Activity activity) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }

        public void g(@g.n0 Activity activity, Lifecycle.Event event) {
            Objects.requireNonNull(activity, "Argument 'activity' of type Activity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }

    public interface b<T> {
        void accept(T t10);
    }

    public interface c<Ret, Par> {
        Ret call(Par par);
    }

    public interface d {
        void a(Activity activity);

        void b(Activity activity);
    }

    public interface e<T> {
        T get();
    }

    public static abstract class f<Result> extends ThreadUtils.d<Result> {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public b<Result> f11895o;

        public f(b<Result> bVar) {
            this.f11895o = bVar;
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.f
        public void l(Result result) {
            b<Result> bVar = this.f11895o;
            if (bVar != null) {
                bVar.accept(result);
            }
        }
    }

    public j1() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Application a() {
        Application application = f11894a;
        if (application != null) {
            return application;
        }
        b(l1.L());
        Objects.requireNonNull(f11894a, "reflect failed.");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(l1.N());
        sb2.append(" reflect app success.");
        return f11894a;
    }

    public static void b(Application application) {
        if (application == null) {
            return;
        }
        Application application2 = f11894a;
        if (application2 == null) {
            f11894a = application;
            l1.l0(application);
            l1.K0();
        } else {
            if (application2.equals(application)) {
                return;
            }
            l1.d1(f11894a);
            f11894a = application;
            l1.l0(application);
        }
    }
}
