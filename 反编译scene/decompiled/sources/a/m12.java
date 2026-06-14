package a;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.omarea.model.ProcessInfo;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class m12 implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n92 f6759a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ u12 f1879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ ListView f1880a;

    public m12(u12 u12Var, ListView listView, n92 n92Var) {
        this.f1879a = u12Var;
        this.f1880a = listView;
        this.f6759a = n92Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Integer] */
    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        ListAdapter adapter = this.f1880a.getAdapter();
        if (adapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterProcessMini");
        }
        f21 f21Var = (f21) adapter;
        ProcessInfo item = f21Var.getItem(i);
        if (item.name.equals(this.f1879a.f3113a.getPackageName())) {
            Toast.makeText(this.f1879a.f3113a, this.f1879a.f3113a.getString(u61.process_kill_scene), 0).show();
            return;
        }
        if (jCurrentTimeMillis - u12.f7556a <= 3000) {
            int i2 = item.pid;
            Integer num = (Integer) this.f6759a.f6891a;
            if (num != null && i2 == num.intValue()) {
                if (this.f1879a.o(item)) {
                    this.f1879a.f3112a.f(item);
                } else {
                    this.f1879a.f3112a.d(item);
                }
                f21Var.i(i);
                return;
            }
        }
        u12.f7556a = System.currentTimeMillis();
        this.f6759a.f6891a = Integer.valueOf(item.pid);
        Toast.makeText(this.f1879a.f3113a, this.f1879a.f3113a.getText(u61.process_kill_tip), 0).show();
    }
}
