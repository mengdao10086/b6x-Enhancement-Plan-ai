package o5;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DecimalFormat f42771a = new DecimalFormat("0.00");

    public static float a(float f10) {
        return new BigDecimal(f10).setScale(1, 4).floatValue();
    }

    public static String b(long j10, boolean z10) {
        int i10 = z10 ? 1000 : 1024;
        if (j10 < i10) {
            return j10 + " B";
        }
        double d10 = j10;
        double d11 = i10;
        int iLog = (int) (Math.log(d10) / Math.log(d11));
        StringBuilder sb2 = new StringBuilder();
        sb2.append((z10 ? "kMGTPE" : "KMGTPE").charAt(iLog - 1));
        sb2.append(z10 ? "" : "i");
        return String.format(Locale.ENGLISH, "%.1f %sB", Double.valueOf(d10 / Math.pow(d11, iLog)), sb2.toString());
    }
}
