package a;

import android.view.View;
import com.omarea.Scene;
import com.omarea.vtools.activities.ActivityFpsSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class ta1 implements s80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f7483a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ActivityFpsSession.l f3009a;

    public ta1(ActivityFpsSession.l lVar, n92 n92Var) {
        this.f3009a = lVar;
        this.f7483a = n92Var;
    }

    /* JADX WARN: Type inference failed for: r11v1, types: [T, java.util.ArrayList, java.util.Collection] */
    @Override // a.s80
    public void a(List<n30> list, boolean[] zArr) {
        f92.d(list, "selected");
        f92.d(zArr, "status");
        n92 n92Var = this.f7483a;
        ArrayList arrayList = this.f3009a.f5258a;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (list.contains((n30) obj)) {
                arrayList2.add(obj);
            }
        }
        ?? arrayList3 = new ArrayList(z42.m(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            String strE = ((n30) it.next()).e();
            f92.b(strE);
            arrayList3.add(strE);
        }
        n92Var.f6891a = arrayList3;
        Scene.f4798a.g().edit().putString("chart_optional", i52.H((List) this.f7483a.f6891a, ",", null, null, 0, null, null, 62, null)).apply();
        int i = 0;
        for (Object obj2 : this.f3009a.f5258a) {
            int i2 = i + 1;
            if (i < 0) {
                y42.l();
                throw null;
            }
            n30 n30Var = (n30) obj2;
            if (zArr[i]) {
                Object objB = n30Var.b();
                if (objB == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                ((View) objB).setVisibility(0);
            } else {
                Object objB2 = n30Var.b();
                if (objB2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                }
                ((View) objB2).setVisibility(8);
            }
            i = i2;
        }
    }
}
