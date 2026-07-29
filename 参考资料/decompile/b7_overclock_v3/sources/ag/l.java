package ag;

import com.blankj.utilcode.util.i0;
import g.n0;
import g.p0;

/* JADX INFO: loaded from: classes7.dex */
public class l implements f {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f679f = 4000;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f680g = 5;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final char f681h = 9484;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final char f682i = 9492;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final char f683j = 9500;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final char f684k = 9474;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final String f685l = "────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final String f686m = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f687n = "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final String f688o = "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────";

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final String f689p = "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @n0
    public final h f693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @p0
    public final String f694e;

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f695a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f696b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f697c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @p0
        public h f698d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @p0
        public String f699e;

        @n0
        public l a() {
            if (this.f698d == null) {
                this.f698d = new i();
            }
            return new l(this);
        }

        @n0
        public b b(@p0 h hVar) {
            this.f698d = hVar;
            return this;
        }

        @n0
        public b c(int i10) {
            this.f695a = i10;
            return this;
        }

        @n0
        public b d(int i10) {
            this.f696b = i10;
            return this;
        }

        @n0
        public b e(boolean z10) {
            this.f697c = z10;
            return this;
        }

        @n0
        public b f(@p0 String str) {
            this.f699e = str;
            return this;
        }

        public b() {
            this.f695a = 2;
            this.f696b = 0;
            this.f697c = true;
            this.f699e = "PRETTY_LOGGER";
        }
    }

    @n0
    public static b k() {
        return new b();
    }

    @Override // ag.f
    public void a(int i10, @p0 String str, @n0 String str2) {
        n.a(str2);
        String strB = b(str);
        j(i10, strB);
        i(i10, strB, this.f690a);
        byte[] bytes = str2.getBytes();
        int length = bytes.length;
        if (length <= 4000) {
            if (this.f690a > 0) {
                h(i10, strB);
            }
            g(i10, strB, str2);
            e(i10, strB);
            return;
        }
        if (this.f690a > 0) {
            h(i10, strB);
        }
        for (int i11 = 0; i11 < length; i11 += 4000) {
            g(i10, strB, new String(bytes, i11, Math.min(length - i11, 4000)));
        }
        e(i10, strB);
    }

    @p0
    public final String b(@p0 String str) {
        if (n.d(str) || n.b(this.f694e, str)) {
            return this.f694e;
        }
        return this.f694e + "-" + str;
    }

    public final String c(@n0 String str) {
        n.a(str);
        return str.substring(str.lastIndexOf(j3.b.f36044h) + 1);
    }

    public final int d(@n0 StackTraceElement[] stackTraceElementArr) {
        n.a(stackTraceElementArr);
        for (int i10 = 5; i10 < stackTraceElementArr.length; i10++) {
            String className = stackTraceElementArr[i10].getClassName();
            if (!className.equals(k.class.getName()) && !className.equals(j.class.getName())) {
                return i10 - 1;
            }
        }
        return -1;
    }

    public final void e(int i10, @p0 String str) {
        f(i10, str, "└────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public final void f(int i10, @p0 String str, @n0 String str2) {
        n.a(str2);
        this.f693d.a(i10, str, str2);
    }

    public final void g(int i10, @p0 String str, @n0 String str2) {
        n.a(str2);
        for (String str3 : str2.split(System.getProperty("line.separator"))) {
            f(i10, str, i0.f11850o + str3);
        }
    }

    public final void h(int i10, @p0 String str) {
        f(i10, str, "├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄");
    }

    public final void i(int i10, @p0 String str, int i11) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (this.f692c) {
            f(i10, str, "│ Thread: " + Thread.currentThread().getName());
            h(i10, str);
        }
        int iD = d(stackTrace) + this.f691b;
        if (i11 + iD > stackTrace.length) {
            i11 = (stackTrace.length - iD) - 1;
        }
        String str2 = "";
        while (i11 > 0) {
            int i12 = i11 + iD;
            if (i12 < stackTrace.length) {
                str2 = str2 + "   ";
                f(i10, str, f684k + zc.f.f58383m + str2 + c(stackTrace[i12].getClassName()) + j3.b.f36044h + stackTrace[i12].getMethodName() + i0.f11861z + " (" + stackTrace[i12].getFileName() + ":" + stackTrace[i12].getLineNumber() + ee.a.f26979d);
            }
            i11--;
        }
    }

    public final void j(int i10, @p0 String str) {
        f(i10, str, "┌────────────────────────────────────────────────────────────────────────────────────────────────────────────────");
    }

    public l(@n0 b bVar) {
        n.a(bVar);
        this.f690a = bVar.f695a;
        this.f691b = bVar.f696b;
        this.f692c = bVar.f697c;
        this.f693d = bVar.f698d;
        this.f694e = bVar.f699e;
    }
}
