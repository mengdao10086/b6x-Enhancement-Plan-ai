package a;

import android.view.View;
import com.omarea.krscript.model.PageNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class hu1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ kv1 f6345a;

    public hu1(kv1 kv1Var) {
        this.f6345a = kv1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PageNode pageNode = new PageNode("");
        pageNode.setTitle("Flyme");
        pageNode.setPageConfigPath("file:///android_asset/kr-script/flyme/flyme.xml");
        cl clVarJ = this.f6345a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        o32.b(new o32(clVarJ), pageNode, null, 2, null);
    }
}
