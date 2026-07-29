package qk;

/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class d {
    public static /* synthetic */ int a(double d10) {
        long jDoubleToLongBits = Double.doubleToLongBits(d10);
        return (int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32));
    }
}
