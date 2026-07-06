package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class j81 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j81 f6486a = new j81();

    public j81() {
        super(1);
    }

    public final String a(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(i < 0 ? "" : "+");
        sb.append(i);
        sb.append("‰");
        return sb.toString();
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
