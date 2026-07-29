package m6;

import java.text.DecimalFormat;

/* JADX INFO: loaded from: classes7.dex */
public class c extends d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f40688k = 60;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final DecimalFormat f40689j;

    public c() {
        super(null);
        this.f40689j = new DecimalFormat();
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
        this.f40689j.setMaximumFractionDigits(1);
        return this.f40689j.format(d10) + " dB";
    }
}
