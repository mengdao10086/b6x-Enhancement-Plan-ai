package l6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.Filter;
import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;
import m6.d;
import m6.e;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Filter f39457a = Filter.BYPASS;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f39458b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d[] f39459c;

    public a() {
        d[] dVarArr = new d[ParameterType.getSize()];
        this.f39459c = dVarArr;
        dVarArr[ParameterType.FREQUENCY.ordinal()] = new m6.a();
        dVarArr[ParameterType.GAIN.ordinal()] = new m6.b();
        dVarArr[ParameterType.QUALITY.ordinal()] = new e();
    }

    public Filter a() {
        return this.f39457a;
    }

    public d b() {
        return this.f39459c[ParameterType.FREQUENCY.ordinal()];
    }

    public d c() {
        return this.f39459c[ParameterType.GAIN.ordinal()];
    }

    public d d() {
        return this.f39459c[ParameterType.QUALITY.ordinal()];
    }

    public void e() {
        this.f39458b = false;
        int i10 = 1;
        while (true) {
            d[] dVarArr = this.f39459c;
            if (i10 >= dVarArr.length) {
                return;
            }
            dVarArr[i10].l();
            i10++;
        }
    }

    public boolean f() {
        int i10 = 1;
        while (true) {
            d[] dVarArr = this.f39459c;
            if (i10 >= dVarArr.length) {
                return this.f39458b;
            }
            if (dVarArr[i10].m() && !this.f39459c[i10].n()) {
                return false;
            }
            i10++;
        }
    }

    public void g(Filter filter, boolean z10) {
        this.f39457a = filter;
        Filter.defineParameters(filter, this.f39459c[ParameterType.FREQUENCY.ordinal()], this.f39459c[ParameterType.GAIN.ordinal()], this.f39459c[ParameterType.QUALITY.ordinal()]);
        if (z10) {
            return;
        }
        this.f39458b = true;
    }
}
