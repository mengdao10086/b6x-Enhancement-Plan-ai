package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z52 extends g92 implements k82<String, i62, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z52 f8039a = new z52();

    public z52() {
        super(2);
    }

    @Override // a.k82
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final String d(String str, i62 i62Var) {
        f92.d(str, "acc");
        f92.d(i62Var, "element");
        if (str.length() == 0) {
            return i62Var.toString();
        }
        return str + ", " + i62Var;
    }
}
