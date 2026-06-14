package a;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.omarea.model.AppInfo;
import com.omarea.vtools.activities.ActivityAppActivities;
import com.omarea.vtools.activities.ActivityAppComponents;
import com.omarea.vtools.activities.ActivityAppContents;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class g81 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityAppContents.h f6182a;

    public g81(ActivityAppContents.h hVar) {
        this.f6182a = hVar;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        wz0 wz0Var = (wz0) this.f6182a.f5138a.get();
        if (wz0Var != null) {
            AppInfo item = wz0Var.getItem(i);
            Intent intent = new Intent(ActivityAppContents.this.getContext(), (Class<?>) (f92.a(this.f6182a.f5137a, "activity") ? ActivityAppActivities.class : ActivityAppComponents.class));
            intent.putExtra("packageName", item.getPackageName());
            intent.putExtra("appName", item.getAppName());
            intent.putExtra("keyword", ActivityAppContents.this.b);
            intent.putExtra("type", this.f6182a.f5137a);
            ActivityAppContents.this.startActivity(intent);
        }
    }
}
