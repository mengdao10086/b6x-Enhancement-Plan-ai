package a;

import android.widget.CompoundButton;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u80 implements l70 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b90 f7574a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ CompoundButton f3154a;

    public u80(b90 b90Var, CompoundButton compoundButton) {
        this.f7574a = b90Var;
        this.f3154a = compoundButton;
    }

    @Override // a.l70
    public void a(List<n30> list) {
        f92.d(list, "selected");
        this.f3154a.setChecked(list.size() == this.f7574a.f247a.size());
    }
}
