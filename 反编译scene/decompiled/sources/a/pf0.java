package a;

import android.content.Context;
import com.omarea.krscript.model.PageMenuOption;
import com.omarea.krscript.model.PageNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class pf0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7112a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PageNode f2424a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<PageMenuOption> f2425a;

    public pf0(Context context, PageNode pageNode) {
        f92.d(context, "applicationContext");
        f92.d(pageNode, "pageNode");
        this.f7112a = context;
        this.f2424a = pageNode;
    }

    public final ArrayList<PageMenuOption> a() {
        PageNode pageNode = this.f2424a;
        if (this.f2425a == null) {
            if (pageNode.getPageMenuOptionsSh().length() > 0) {
                String strC = yc0.c(this.f7112a, pageNode.getPageMenuOptionsSh(), pageNode);
                if (!f92.a(strC, "error")) {
                    f92.c(strC, "result");
                    for (String str : ec2.d0(strC, new String[]{"\n"}, false, 0, 6, null)) {
                        PageMenuOption pageMenuOption = new PageMenuOption(pageNode.getPageConfigPath());
                        if (ec2.C(str, "|", false, 2, null)) {
                            List listD0 = ec2.d0(str, new String[]{"|"}, false, 0, 6, null);
                            pageMenuOption.setKey((String) listD0.get(0));
                            str = (String) listD0.get(1);
                        } else {
                            pageMenuOption.setKey(str);
                        }
                        pageMenuOption.setTitle(str);
                    }
                }
            } else if (pageNode.getPageMenuOptions() != null) {
                this.f2425a = pageNode.getPageMenuOptions();
            }
        }
        return this.f2425a;
    }
}
