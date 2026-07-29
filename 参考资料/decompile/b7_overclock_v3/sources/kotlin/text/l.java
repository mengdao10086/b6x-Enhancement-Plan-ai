package kotlin.text;

/* JADX INFO: loaded from: classes5.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @yt.k
    public static final l f38183a = new l();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @hk.e
    @yt.k
    public static final Regex f38184b;

    static {
        String str = "[eE][+-]?(\\p{Digit}+)";
        f38184b = new Regex("[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + ("((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + str + ")?)|(\\.((\\p{Digit}+))(" + str + ")?)|((" + ("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))") + ")[pP][+-]?(\\p{Digit}+))") + ")[fFdD]?))[\\x00-\\x20]*");
    }
}
