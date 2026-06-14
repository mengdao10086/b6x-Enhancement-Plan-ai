package a;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gg2 extends wh2 implements jf2 {
    @Override // a.jf2
    public boolean a() {
        return true;
    }

    @Override // a.jf2
    public gg2 c() {
        return this;
    }

    @Override // a.zh2
    public String toString() {
        return be2.c() ? v("Active") : super.toString();
    }

    public final String v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object objN = n();
        if (objN == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        boolean z = true;
        for (zh2 zh2VarO = (zh2) objN; !f92.a(zh2VarO, this); zh2VarO = zh2VarO.o()) {
            if (zh2VarO instanceof wf2) {
                wf2 wf2Var = (wf2) zh2VarO;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(wf2Var);
            }
        }
        sb.append("]");
        String string = sb.toString();
        f92.c(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
