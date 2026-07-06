package a;

import a.p80;
import android.content.Intent;
import com.omarea.krscript.model.ClickableNode;
import com.omarea.krscript.model.KrScriptActionHandler;
import java.util.Arrays;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class vd0 implements KrScriptActionHandler.AddToFavoritesHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ fe0 f7682a;

    public vd0(fe0 fe0Var) {
        this.f7682a = fe0Var;
    }

    @Override // com.omarea.krscript.model.KrScriptActionHandler.AddToFavoritesHandler
    public void onAddToFavorites(ClickableNode clickableNode, Intent intent) {
        f92.d(clickableNode, "clickableNode");
        if (intent != null) {
            p80.a aVar = p80.f2403a;
            cl clVarJ = this.f7682a.j();
            f92.b(clVarJ);
            f92.c(clVarJ, "activity!!");
            String strJ = this.f7682a.J(ob0.kr_shortcut_create);
            f92.c(strJ, "getString(R.string.kr_shortcut_create)");
            q92 q92Var = q92.f7191a;
            String strJ2 = this.f7682a.J(ob0.kr_shortcut_create_desc);
            f92.c(strJ2, "getString(R.string.kr_shortcut_create_desc)");
            String str = String.format(strJ2, Arrays.copyOf(new Object[]{clickableNode.getTitle()}, 1));
            f92.c(str, "java.lang.String.format(format, *args)");
            aVar.i(clVarJ, (16 & 2) != 0 ? "" : strJ, (16 & 4) != 0 ? "" : str, (16 & 8) != 0 ? null : new ud0(this, intent, clickableNode), (16 & 16) != 0 ? null : null);
        }
    }
}
