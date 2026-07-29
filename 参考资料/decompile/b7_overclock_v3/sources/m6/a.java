package m6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class a extends d {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f40678l = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecimalFormat f40679j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f40680k;

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public double f40682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public double f40683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public double f40684d;

        public b() {
        }
    }

    public a() {
        super(ParameterType.FREQUENCY);
        this.f40679j = new DecimalFormat();
        this.f40680k = new b();
    }

    @Override // m6.d
    public int b() {
        return 3;
    }

    @Override // m6.d
    public String c(double d10) {
        if (!this.f40698g) {
            return "- Hz";
        }
        if (d10 < 50.0d) {
            this.f40679j.setMaximumFractionDigits(1);
            return this.f40679j.format(d10) + " Hz";
        }
        if (d10 < 1000.0d) {
            this.f40679j.setMaximumFractionDigits(0);
            return this.f40679j.format(d10) + " Hz";
        }
        this.f40679j.setMaximumFractionDigits(1);
        return this.f40679j.format(d10 / 1000.0d) + " kHz";
    }

    @Override // m6.d
    public int j() {
        double d10 = this.f40680k.f40681a;
        double dLog = Math.log(k());
        b bVar = this.f40680k;
        return (int) Math.round((d10 * (dLog - bVar.f40683c)) / bVar.f40684d);
    }

    @Override // m6.d
    public void p(double d10, double d11) {
        super.p(d10, d11);
        this.f40680k.f40681a = g() - h();
        this.f40680k.f40682b = Math.log(g());
        this.f40680k.f40683c = Math.log(h());
        b bVar = this.f40680k;
        bVar.f40684d = bVar.f40682b - bVar.f40683c;
    }

    @Override // m6.d
    public void s(int i10) {
        b bVar = this.f40680k;
        r((int) Math.round(Math.exp(bVar.f40683c + ((((double) i10) * bVar.f40684d) / ((double) bVar.f40681a)))));
    }
}
