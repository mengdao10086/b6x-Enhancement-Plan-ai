package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xj0 {
    public double a(Float[] fArr) {
        double d = 0.0d;
        double dFloatValue = 0.0d;
        for (Float f : fArr) {
            dFloatValue += (double) f.floatValue();
        }
        double length = dFloatValue / ((double) fArr.length);
        for (Float f2 : fArr) {
            double dFloatValue2 = ((double) f2.floatValue()) - length;
            d += dFloatValue2 * dFloatValue2;
        }
        return d / ((double) fArr.length);
    }
}
