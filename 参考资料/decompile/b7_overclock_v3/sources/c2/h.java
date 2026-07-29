package c2;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Pattern f9708j = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9710b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f9712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object[] f9713e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f9709a = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String[] f9711c = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9714f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9715g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9716h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f9717i = null;

    public h(String str) {
        this.f9710b = str;
    }

    public static void a(StringBuilder sb2, String str, String str2) {
        if (i(str2)) {
            return;
        }
        sb2.append(str);
        sb2.append(str2);
    }

    public static void b(StringBuilder sb2, String[] strArr) {
        int length = strArr.length;
        for (int i10 = 0; i10 < length; i10++) {
            String str = strArr[i10];
            if (i10 > 0) {
                sb2.append(", ");
            }
            sb2.append(str);
        }
        sb2.append(zc.f.f58383m);
    }

    public static h c(String str) {
        return new h(str);
    }

    public static boolean i(String str) {
        return str == null || str.length() == 0;
    }

    public h d(String[] strArr) {
        this.f9711c = strArr;
        return this;
    }

    public g e() {
        if (i(this.f9714f) && !i(this.f9715g)) {
            throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
        }
        StringBuilder sb2 = new StringBuilder(120);
        sb2.append("SELECT ");
        if (this.f9709a) {
            sb2.append("DISTINCT ");
        }
        String[] strArr = this.f9711c;
        if (strArr == null || strArr.length == 0) {
            sb2.append(" * ");
        } else {
            b(sb2, strArr);
        }
        sb2.append(" FROM ");
        sb2.append(this.f9710b);
        a(sb2, " WHERE ", this.f9712d);
        a(sb2, " GROUP BY ", this.f9714f);
        a(sb2, " HAVING ", this.f9715g);
        a(sb2, " ORDER BY ", this.f9716h);
        a(sb2, " LIMIT ", this.f9717i);
        return new a(sb2.toString(), this.f9713e);
    }

    public h f() {
        this.f9709a = true;
        return this;
    }

    public h g(String str) {
        this.f9714f = str;
        return this;
    }

    public h h(String str) {
        this.f9715g = str;
        return this;
    }

    public h j(String str) {
        if (i(str) || f9708j.matcher(str).matches()) {
            this.f9717i = str;
            return this;
        }
        throw new IllegalArgumentException("invalid LIMIT clauses:" + str);
    }

    public h k(String str) {
        this.f9716h = str;
        return this;
    }

    public h l(String str, Object[] objArr) {
        this.f9712d = str;
        this.f9713e = objArr;
        return this;
    }
}
