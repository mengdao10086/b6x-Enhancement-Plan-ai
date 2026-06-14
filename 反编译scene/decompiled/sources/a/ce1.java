package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ce1 extends g92 implements g82<d42<? extends Integer, ? extends Integer>, CharSequence> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ce1 f5785a = new ce1();

    public ce1() {
        super(1);
    }

    @Override // a.g82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final CharSequence f(d42<Integer, Integer> d42Var) {
        f92.d(d42Var, "<name for destructuring parameter 0>");
        int iIntValue = d42Var.a().intValue();
        int iIntValue2 = d42Var.b().intValue();
        if (iIntValue == iIntValue2) {
            return String.valueOf(iIntValue);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(iIntValue);
        sb.append('-');
        sb.append(iIntValue2);
        return sb.toString();
    }
}
