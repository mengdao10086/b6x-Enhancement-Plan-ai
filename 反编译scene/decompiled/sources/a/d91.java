package a;

import a.d70;
import android.content.SharedPreferences;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class d91 implements w70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e91 f5874a;

    public d91(e91 e91Var) {
        this.f5874a = e91Var;
    }

    @Override // a.w70
    public void a(List<? extends d70.a> list) {
        f92.d(list, "apps");
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((d70.a) it.next()).getPackageName());
        }
        for (AppInfo appInfo : this.f5874a.f708a) {
            appInfo.setSelected(arrayList.contains(appInfo.getPackageName()));
        }
        SharedPreferences.Editor editorClear = this.f5874a.f5980a.edit().clear();
        for (d70.a aVar : list) {
            if (aVar.getSelected()) {
                editorClear.putBoolean(aVar.getPackageName(), true);
            }
        }
        editorClear.apply();
    }
}
