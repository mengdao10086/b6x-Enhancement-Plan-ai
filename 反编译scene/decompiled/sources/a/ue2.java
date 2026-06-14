package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ue2 implements jf2 {
    public final boolean b;

    public ue2(boolean z) {
        this.b = z;
    }

    @Override // a.jf2
    public boolean a() {
        return this.b;
    }

    @Override // a.jf2
    public gg2 c() {
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(a() ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
