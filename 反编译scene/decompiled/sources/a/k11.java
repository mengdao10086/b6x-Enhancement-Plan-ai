package a;

import android.view.View;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class k11 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l11 f6564a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1595a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ File f1596a;

    public k11(l11 l11Var, View view, File file) {
        this.f6564a = l11Var;
        this.f1595a = view;
        this.f1596a = file;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p80.f2403a.i(this.f1595a.getContext(), "选定文件？", this.f1596a.getAbsolutePath(), new i11(this), new j11(this));
    }
}
