package p6;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f46442a = 32;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f46443b = 15;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f46444c = 1000;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f46445d = 1000;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f46446e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f46447f = 2000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f46448g = 63;

    /* JADX INFO: renamed from: p6.a$a, reason: collision with other inner class name */
    public static class C0524a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final byte f46449a = -1;

        /* JADX INFO: renamed from: p6.a$a$a, reason: collision with other inner class name */
        public class C0525a {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final byte f46450b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final byte f46451c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final byte f46452d = 2;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final byte f46453e = 3;

            public C0525a() {
            }
        }

        /* JADX INFO: renamed from: p6.a$a$b */
        public class b {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final byte f46455b = 0;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final byte f46456c = 1;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final byte f46457d = 2;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static final byte f46458e = 2;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public static final byte f46459f = 3;

            public b() {
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f46461a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final int f46462b = 1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final int f46463c = 1;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f46464d = 1;

        /* JADX INFO: renamed from: p6.a$b$a, reason: collision with other inner class name */
        public static class C0526a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final int f46465a = 0;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public static final int f46466b = 6;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final int f46467c = 6;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public static final int f46468d = 2;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface c {

        /* JADX INFO: renamed from: h5, reason: collision with root package name */
        public static final int f46469h5 = 0;

        /* JADX INFO: renamed from: i5, reason: collision with root package name */
        public static final int f46470i5 = 1;

        /* JADX INFO: renamed from: j5, reason: collision with root package name */
        public static final int f46471j5 = 2;

        /* JADX INFO: renamed from: k5, reason: collision with root package name */
        public static final int f46472k5 = 3;
    }

    public static String a(int i10) {
        if (i10 == 0) {
            return "LISTEN";
        }
        if (i10 == 1) {
            return "SYN_SENT";
        }
        if (i10 == 2) {
            return "ESTABLISHED";
        }
        if (i10 == 3) {
            return "CLOSING";
        }
        return "Unknown state (" + i10 + ee.a.f26979d;
    }
}
