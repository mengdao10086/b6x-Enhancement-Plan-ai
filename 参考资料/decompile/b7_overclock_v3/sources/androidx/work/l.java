package androidx.work;

import androidx.annotation.RestrictTo;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static l f8565a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8566b = "WM-";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f8567c = 23;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f8568d = 20;

    public static class a extends l {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f8569e;

        public a(int loggingLevel) {
            super(loggingLevel);
            this.f8569e = loggingLevel;
        }

        @Override // androidx.work.l
        public void a(String tag, String message, Throwable... throwables) {
            if (this.f8569e > 3 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th2 = throwables[0];
        }

        @Override // androidx.work.l
        public void b(String tag, String message, Throwable... throwables) {
            if (this.f8569e > 6 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th2 = throwables[0];
        }

        @Override // androidx.work.l
        public void d(String tag, String message, Throwable... throwables) {
            if (this.f8569e > 4 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th2 = throwables[0];
        }

        @Override // androidx.work.l
        public void g(String tag, String message, Throwable... throwables) {
            if (this.f8569e > 2 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th2 = throwables[0];
        }

        @Override // androidx.work.l
        public void h(String tag, String message, Throwable... throwables) {
            if (this.f8569e > 5 || throwables == null || throwables.length < 1) {
                return;
            }
            Throwable th2 = throwables[0];
        }
    }

    public l(int loggingLevel) {
    }

    public static synchronized l c() {
        if (f8565a == null) {
            f8565a = new a(3);
        }
        return f8565a;
    }

    public static synchronized void e(l logger) {
        f8565a = logger;
    }

    public static String f(@n0 String tag) {
        int length = tag.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append(f8566b);
        int i10 = f8568d;
        if (length >= i10) {
            sb2.append(tag.substring(0, i10));
        } else {
            sb2.append(tag);
        }
        return sb2.toString();
    }

    public abstract void a(String tag, String message, Throwable... throwables);

    public abstract void b(String tag, String message, Throwable... throwables);

    public abstract void d(String tag, String message, Throwable... throwables);

    public abstract void g(String tag, String message, Throwable... throwables);

    public abstract void h(String tag, String message, Throwable... throwables);
}
