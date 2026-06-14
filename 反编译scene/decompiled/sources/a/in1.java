package a;

import a.p80;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class in1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ jn1 f6429a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ String f1391a;

    public in1(jn1 jn1Var, String str) {
        this.f6429a = jn1Var;
        this.f1391a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str = this.f1391a;
        int iS = ec2.S(str, "_", 0, false, 6, null) + 1;
        int iS2 = ec2.S(this.f1391a, ".", 0, false, 6, null);
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iS, iS2);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        ul0.s(Integer.parseInt(strSubstring));
        p80.a.C(p80.f2403a, this.f6429a.f6528a.f6623a, "完工，但此操作并非一直生效。重启手机必然失效，切换应用/游戏也可能失效。", null, 4, null);
    }
}
