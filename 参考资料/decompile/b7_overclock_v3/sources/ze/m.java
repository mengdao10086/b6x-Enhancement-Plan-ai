package ze;

import com.google.zxing.client.result.ParsedResultType;

/* JADX INFO: loaded from: classes7.dex */
public final class m extends q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f58532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f58533c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f58534d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f58535e;

    public m(double d10, double d11, double d12, String str) {
        super(ParsedResultType.GEO);
        this.f58532b = d10;
        this.f58533c = d11;
        this.f58534d = d12;
        this.f58535e = str;
    }

    @Override // ze.q
    public String a() {
        StringBuilder sb2 = new StringBuilder(20);
        sb2.append(this.f58532b);
        sb2.append(", ");
        sb2.append(this.f58533c);
        if (this.f58534d > 0.0d) {
            sb2.append(", ");
            sb2.append(this.f58534d);
            sb2.append('m');
        }
        if (this.f58535e != null) {
            sb2.append(" (");
            sb2.append(this.f58535e);
            sb2.append(')');
        }
        return sb2.toString();
    }

    public double e() {
        return this.f58534d;
    }

    public String f() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("geo:");
        sb2.append(this.f58532b);
        sb2.append(',');
        sb2.append(this.f58533c);
        if (this.f58534d > 0.0d) {
            sb2.append(',');
            sb2.append(this.f58534d);
        }
        if (this.f58535e != null) {
            sb2.append('?');
            sb2.append(this.f58535e);
        }
        return sb2.toString();
    }

    public double g() {
        return this.f58532b;
    }

    public double h() {
        return this.f58533c;
    }

    public String i() {
        return this.f58535e;
    }
}
