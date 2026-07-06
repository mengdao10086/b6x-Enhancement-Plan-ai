package a;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.omarea.model.ProcessInfo;
import com.omarea.vtools.activities.ActivityProcess;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class yr1 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ zs1 f8006a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f3768a;

    public yr1(ListView listView, zs1 zs1Var) {
        this.f3768a = listView;
        this.f8006a = zs1Var;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ProcessInfo processInfo = (ProcessInfo) adapterView.getItemAtPosition(i);
        Intent intent = new Intent(this.f3768a.getContext(), (Class<?>) ActivityProcess.class);
        intent.addFlags(268435456);
        intent.putExtra("name", processInfo != null ? processInfo.name : null);
        this.f8006a.s1(intent);
    }
}
