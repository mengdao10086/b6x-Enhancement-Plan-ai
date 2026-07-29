package m6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class e extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f40699k = 4096;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecimalFormat f40700j;

    public e() {
        super(ParameterType.QUALITY);
        this.f40700j = new DecimalFormat();
    }

    @Override // m6.d
    public int b() {
        return 4096;
    }

    @Override // m6.d
    public String c(double d10) {
        if (!this.f40698g) {
            return "-";
        }
        this.f40700j.setMaximumFractionDigits(2);
        return this.f40700j.format(d10);
    }
}
