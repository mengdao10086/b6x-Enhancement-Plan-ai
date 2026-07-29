package ze;

import com.google.zxing.client.result.ParsedResultType;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes7.dex */
public final class k extends q {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final String f58515q = "KG";

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final String f58516r = "LB";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f58519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f58520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f58521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f58522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f58523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f58524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f58525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f58526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f58527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f58528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f58529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f58530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, String> f58531p;

    public k(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, Map<String, String> map) {
        super(ParsedResultType.PRODUCT);
        this.f58517b = str;
        this.f58518c = str2;
        this.f58519d = str3;
        this.f58520e = str4;
        this.f58521f = str5;
        this.f58522g = str6;
        this.f58523h = str7;
        this.f58524i = str8;
        this.f58525j = str9;
        this.f58526k = str10;
        this.f58527l = str11;
        this.f58528m = str12;
        this.f58529n = str13;
        this.f58530o = str14;
        this.f58531p = map;
    }

    @Override // ze.q
    public String a() {
        return String.valueOf(this.f58517b);
    }

    public String e() {
        return this.f58523h;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return Objects.equals(this.f58518c, kVar.f58518c) && Objects.equals(this.f58519d, kVar.f58519d) && Objects.equals(this.f58520e, kVar.f58520e) && Objects.equals(this.f58521f, kVar.f58521f) && Objects.equals(this.f58523h, kVar.f58523h) && Objects.equals(this.f58524i, kVar.f58524i) && Objects.equals(this.f58525j, kVar.f58525j) && Objects.equals(this.f58526k, kVar.f58526k) && Objects.equals(this.f58527l, kVar.f58527l) && Objects.equals(this.f58528m, kVar.f58528m) && Objects.equals(this.f58529n, kVar.f58529n) && Objects.equals(this.f58530o, kVar.f58530o) && Objects.equals(this.f58531p, kVar.f58531p);
    }

    public String f() {
        return this.f58524i;
    }

    public String g() {
        return this.f58520e;
    }

    public String h() {
        return this.f58522g;
    }

    public int hashCode() {
        return (((((((((((Objects.hashCode(this.f58518c) ^ Objects.hashCode(this.f58519d)) ^ Objects.hashCode(this.f58520e)) ^ Objects.hashCode(this.f58521f)) ^ Objects.hashCode(this.f58523h)) ^ Objects.hashCode(this.f58524i)) ^ Objects.hashCode(this.f58525j)) ^ Objects.hashCode(this.f58526k)) ^ Objects.hashCode(this.f58527l)) ^ Objects.hashCode(this.f58528m)) ^ Objects.hashCode(this.f58529n)) ^ Objects.hashCode(this.f58530o)) ^ Objects.hashCode(this.f58531p);
    }

    public String i() {
        return this.f58528m;
    }

    public String j() {
        return this.f58530o;
    }

    public String k() {
        return this.f58529n;
    }

    public String l() {
        return this.f58518c;
    }

    public String m() {
        return this.f58521f;
    }

    public String n() {
        return this.f58517b;
    }

    public String o() {
        return this.f58519d;
    }

    public Map<String, String> p() {
        return this.f58531p;
    }

    public String q() {
        return this.f58525j;
    }

    public String r() {
        return this.f58527l;
    }

    public String s() {
        return this.f58526k;
    }
}
