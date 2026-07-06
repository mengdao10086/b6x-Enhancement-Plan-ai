package a;

import com.omarea.Scene;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class jn1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kn1 f6528a;

    public jn1(kn1 kn1Var) {
        this.f6528a = kn1Var;
    }

    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        String strE = ((n30) i52.A(list)).e();
        f92.b(strE);
        String strE2 = ul0.e(strE);
        if (strE2 == null || strE2.length() == 0) {
            Scene.c.p(Scene.f4798a, "温控配置解析失败", 0, 2, null);
        } else {
            p80.f2403a.i(this.f6528a.f6623a, (16 & 2) != 0 ? "" : "确定切换到该配置？", (16 & 4) != 0 ? "" : strE2, (16 & 8) != 0 ? null : new in1(this, strE), (16 & 16) != 0 ? null : null);
        }
    }
}
