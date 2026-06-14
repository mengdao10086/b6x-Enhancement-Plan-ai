package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wg1 extends g92 implements g82<Integer, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final wg1 f7787a = new wg1();

    public wg1() {
        super(1);
    }

    public final String a(int i) {
        return String.valueOf(i) + "(" + (i / 1024) + "MB)";
    }

    @Override // a.g82
    public /* bridge */ /* synthetic */ String f(Integer num) {
        return a(num.intValue());
    }
}
