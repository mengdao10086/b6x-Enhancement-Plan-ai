package m6;

import com.flydigi.cyberfox.h1.models.equalizer.parameters.ParameterType;
import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class b extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f40686k = 60;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecimalFormat f40687j;

    public b() {
        super(ParameterType.GAIN);
        this.f40687j = new DecimalFormat();
    }

    @Override // m6.d
    public int b() {
        return 60;
    }

    @Override // m6.d
    public String c(double d10) {
        if (!this.f40698g) {
            return "- dB";
        }
        this.f40687j.setMaximumFractionDigits(1);
        return this.f40687j.format(d10) + " dB";
    }
}
