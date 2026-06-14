package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class xb0 implements eg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ hc0 f7873a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f3567a;

    public xb0(hc0 hc0Var, String str) {
        this.f7873a = hc0Var;
        this.f3567a = str;
    }

    @Override // a.eg0
    public String a() {
        return null;
    }

    @Override // a.eg0
    public int b() {
        return eg0.f5999a.a();
    }

    @Override // a.eg0
    public String c() {
        return "*/*";
    }

    @Override // a.eg0
    public void d(String str) {
        try {
            g30 g30Var = new g30();
            if (str == null || str.isEmpty()) {
                g30Var.x("absPath", null);
            } else {
                g30Var.x("absPath", str);
            }
            this.f7873a.f6300a.f1352a.post(new wb0(this, g30Var));
        } catch (Exception unused) {
        }
    }
}
