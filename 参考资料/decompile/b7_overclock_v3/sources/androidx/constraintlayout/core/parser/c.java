package androidx.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f3054f = 80;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f3055g = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final char[] f3056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f3057b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3058c = Long.MAX_VALUE;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f3059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3060e;

    public c(char[] cArr) {
        this.f3056a = cArr;
    }

    public void a(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(zc.f.f58383m);
        }
    }

    public String b() {
        String str = new String(this.f3056a);
        long j10 = this.f3058c;
        if (j10 != Long.MAX_VALUE) {
            long j11 = this.f3057b;
            if (j10 >= j11) {
                return str.substring((int) j11, ((int) j10) + 1);
            }
        }
        long j12 = this.f3057b;
        return str.substring((int) j12, ((int) j12) + 1);
    }

    public c d() {
        return this.f3059d;
    }

    public String e() {
        if (!CLParser.f3042d) {
            return "";
        }
        return m() + " -> ";
    }

    public long f() {
        return this.f3058c;
    }

    public float g() {
        if (this instanceof e) {
            return ((e) this).g();
        }
        return Float.NaN;
    }

    public int i() {
        if (this instanceof e) {
            return ((e) this).i();
        }
        return 0;
    }

    public int j() {
        return this.f3060e;
    }

    public long l() {
        return this.f3057b;
    }

    public String m() {
        String string = getClass().toString();
        return string.substring(string.lastIndexOf(46) + 1);
    }

    public boolean o() {
        return this.f3058c != Long.MAX_VALUE;
    }

    public boolean p() {
        return this.f3057b > -1;
    }

    public boolean q() {
        return this.f3057b == -1;
    }

    public void r(b bVar) {
        this.f3059d = bVar;
    }

    public void s(long j10) {
        if (this.f3058c != Long.MAX_VALUE) {
            return;
        }
        this.f3058c = j10;
        if (CLParser.f3042d) {
            System.out.println("closing " + hashCode() + " -> " + this);
        }
        b bVar = this.f3059d;
        if (bVar != null) {
            bVar.x(this);
        }
    }

    public void t(int i10) {
        this.f3060e = i10;
    }

    public String toString() {
        long j10 = this.f3057b;
        long j11 = this.f3058c;
        if (j10 > j11 || j11 == Long.MAX_VALUE) {
            return getClass() + " (INVALID, " + this.f3057b + "-" + this.f3058c + ee.a.f26979d;
        }
        return m() + " (" + this.f3057b + " : " + this.f3058c + ") <<" + new String(this.f3056a).substring((int) this.f3057b, ((int) this.f3058c) + 1) + ">>";
    }

    public void u(long j10) {
        this.f3057b = j10;
    }

    public String v(int i10, int i11) {
        return "";
    }

    public String w() {
        return "";
    }
}
