package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class cg2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final li2 f5791a = new li2("COMPLETING_ALREADY");
    public static final li2 b = new li2("COMPLETING_WAITING_CHILDREN");
    public static final li2 c = new li2("COMPLETING_RETRY");
    public static final li2 d = new li2("TOO_LATE_TO_CANCEL");
    public static final li2 e = new li2("SEALED");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ue2 f398a = new ue2(false);

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final ue2 f399b = new ue2(true);

    public static final Object g(Object obj) {
        return obj instanceof jf2 ? new kf2((jf2) obj) : obj;
    }

    public static final Object h(Object obj) {
        jf2 jf2Var;
        kf2 kf2Var = (kf2) (!(obj instanceof kf2) ? null : obj);
        return (kf2Var == null || (jf2Var = kf2Var.f6601a) == null) ? obj : jf2Var;
    }
}
