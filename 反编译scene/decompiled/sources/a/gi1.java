package a;

import android.content.res.Resources;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class gi1 extends hh1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g91 f6209a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gi1(g91 g91Var) {
        super(g91Var);
        f92.d(g91Var, "context");
        this.f6209a = g91Var;
    }

    public final void f() {
        boolean zA = this.f6209a.getThemeMode().a();
        ArrayList arrayList = new ArrayList();
        n30 n30Var = new n30();
        n30Var.i("全部隐藏");
        n30Var.j("wm overscan reset;settings put global policy_control immersive.full=apps,-android,-com.android.systemui");
        m42 m42Var = m42.f6769a;
        arrayList.add(n30Var);
        n30 n30Var2 = new n30();
        n30Var2.i("隐藏导航栏");
        n30Var2.j("wm overscan reset;settings put global policy_control immersive.navigation=*");
        m42 m42Var2 = m42.f6769a;
        arrayList.add(n30Var2);
        n30 n30Var3 = new n30();
        n30Var3.i("隐藏状态栏");
        n30Var3.j("wm overscan reset;settings put global policy_control immersive.status=apps,-android,-com.android.systemui");
        m42 m42Var3 = m42.f6769a;
        arrayList.add(n30Var3);
        n30 n30Var4 = new n30();
        n30Var4.i("恢复默认");
        n30Var4.j("wm overscan reset;settings put global policy_control null");
        m42 m42Var4 = m42.f6769a;
        arrayList.add(n30Var4);
        n30 n30Var5 = new n30();
        n30Var5.i("移走导航栏(overscan)");
        n30Var5.j("wm overscan 0,0,0,-" + g());
        m42 m42Var5 = m42.f6769a;
        arrayList.add(n30Var5);
        m42 m42Var6 = m42.f6769a;
        b90 b90Var = new b90(zA, arrayList, false, new fi1(this), 0, 16, null);
        b90Var.K1("请选择操作");
        b90Var.B1(this.f6209a.getSupportFragmentManager(), "immersive-options");
    }

    public final int g() {
        Resources resources = this.f6209a.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android")) + 1;
    }
}
