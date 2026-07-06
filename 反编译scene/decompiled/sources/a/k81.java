package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class k81 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k81 f6584a = new k81();

    public k81() {
        super(1);
    }

    public final String a(int i) {
        if (i <= 0) {
            return "Auto";
        }
        int i2 = (i + 50) - 100;
        StringBuilder sb = new StringBuilder();
        sb.append(i2 < 0 ? "" : "+");
        sb.append(i2);
        sb.append("%");
        return sb.toString();
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
