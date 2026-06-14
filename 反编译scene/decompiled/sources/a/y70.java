package a;

import a.d70;
import android.widget.CompoundButton;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class y70 implements f70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d80 f7954a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f3661a;

    public y70(d80 d80Var, CompoundButton compoundButton) {
        this.f7954a = d80Var;
        this.f3661a = compoundButton;
    }

    @Override // a.f70
    public void a(List<? extends d70.a> list) {
        f92.d(list, "selected");
        this.f3661a.setChecked(list.size() == this.f7954a.f512a.size());
    }
}
