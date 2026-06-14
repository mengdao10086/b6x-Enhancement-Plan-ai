package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class xg1 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final xg1 f7888a = new xg1();

    public xg1() {
        super(1);
    }

    public final String a(int i) {
        return i + '(' + (i / 100.0f) + "%)";
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
