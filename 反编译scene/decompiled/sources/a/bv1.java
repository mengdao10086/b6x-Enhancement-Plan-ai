package a;

import com.omarea.krscript.model.PageNode;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class bv1 extends g92 implements v72<m42> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ cv1 f5736a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bv1(cv1 cv1Var) {
        super(0);
        this.f5736a = cv1Var;
    }

    public final void a() {
        PageNode pageNode = new PageNode("");
        pageNode.setTitle("MIUI/HyperOS");
        pageNode.setPageConfigPath("file:///android_asset/kr-script/miui/miui-thermal.xml");
        cl clVarJ = this.f5736a.f5832a.j();
        f92.b(clVarJ);
        f92.c(clVarJ, "activity!!");
        o32.b(new o32(clVarJ), pageNode, null, 2, null);
    }

    @Override // a.v72
    public /* bridge */ /* synthetic */ m42 i() {
        a();
        return m42.f6769a;
    }
}
