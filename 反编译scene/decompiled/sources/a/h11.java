package a;

import android.view.View;
import java.io.File;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class h11 implements View.OnLongClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l11 f6263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ View f1090a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ File f1091a;

    public h11(l11 l11Var, View view, File file) {
        this.f6263a = l11Var;
        this.f1090a = view;
        this.f1091a = file;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        p80.f2403a.i(this.f1090a.getContext(), "选定目录？", this.f1091a.getAbsolutePath(), new f11(this), new g11(this));
        return true;
    }
}
