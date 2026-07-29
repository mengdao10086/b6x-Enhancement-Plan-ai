package androidx.work;

import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import g.n0;

/* JADX INFO: loaded from: classes2.dex */
public interface o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final b.c f8746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final b.C0089b f8747b;

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f8748a;

            public a(@n0 Throwable exception) {
                this.f8748a = exception;
            }

            @n0
            public Throwable a() {
                return this.f8748a;
            }

            @n0
            public String toString() {
                return String.format("FAILURE (%s)", this.f8748a.getMessage());
            }
        }

        /* JADX INFO: renamed from: androidx.work.o$b$b, reason: collision with other inner class name */
        public static final class C0089b extends b {
            @n0
            public String toString() {
                return "IN_PROGRESS";
            }

            public C0089b() {
            }
        }

        public static final class c extends b {
            @n0
            public String toString() {
                return "SUCCESS";
            }

            public c() {
            }
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public b() {
        }
    }

    static {
        f8746a = new b.c();
        f8747b = new b.C0089b();
    }

    @n0
    ListenableFuture<b.c> getResult();

    @n0
    LiveData<b> getState();
}
