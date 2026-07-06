package a;

import com.omarea.krscript.model.PageNode;
import com.omarea.vtools.activities.ActivityImg;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class oc1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActivityImg.h f7006a;

    public oc1(ActivityImg.h hVar) {
        this.f7006a = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PageNode pageNode = new PageNode("");
        pageNode.setTitle(" ");
        pageNode.setPageConfigPath("file:///android_asset/kr-script/img/img.xml");
        new o32(ActivityImg.this).a(pageNode, "install");
    }
}
