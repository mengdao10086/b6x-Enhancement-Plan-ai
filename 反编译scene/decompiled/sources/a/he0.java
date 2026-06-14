package a;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.omarea.krscript.model.ActionParamInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class he0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ge0 f6306a = new ge0(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public cl f1159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinearLayout f1160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String[] f1161a;

    public he0(LinearLayout linearLayout, cl clVar) {
        f92.d(linearLayout, "linearLayout");
        f92.d(clVar, "activity");
        this.f1160a = linearLayout;
        this.f1159a = clVar;
        this.f1161a = new String[]{"bool", "checkbox", "switch"};
    }

    public final void a(View view, ActionParamInfo actionParamInfo) {
        View viewInflate = LayoutInflater.from(this.f1159a).inflate(nb0.kr_param_row, (ViewGroup) null);
        String title = actionParamInfo.getTitle();
        if (title == null || title.length() == 0) {
            View viewFindViewById = viewInflate.findViewById(mb0.kr_param_title);
            f92.c(viewFindViewById, "layout.findViewById<TextView>(R.id.kr_param_title)");
            ((TextView) viewFindViewById).setVisibility(8);
        } else {
            View viewFindViewById2 = viewInflate.findViewById(mb0.kr_param_title);
            f92.c(viewFindViewById2, "layout.findViewById<TextView>(R.id.kr_param_title)");
            ((TextView) viewFindViewById2).setText(actionParamInfo.getTitle());
        }
        String label = actionParamInfo.getLabel();
        if ((label == null || label.length() == 0) || u42.k(this.f1161a, actionParamInfo.getType())) {
            View viewFindViewById3 = viewInflate.findViewById(mb0.kr_param_label);
            f92.c(viewFindViewById3, "layout.findViewById<TextView>(R.id.kr_param_label)");
            ((TextView) viewFindViewById3).setVisibility(8);
        } else {
            ((TextView) viewInflate.findViewById(mb0.kr_param_label)).setText(actionParamInfo.getLabel());
        }
        String desc = actionParamInfo.getDesc();
        if (desc == null || desc.length() == 0) {
            View viewFindViewById4 = viewInflate.findViewById(mb0.kr_param_desc);
            f92.c(viewFindViewById4, "layout.findViewById<TextView>(R.id.kr_param_desc)");
            ((TextView) viewFindViewById4).setVisibility(8);
        } else {
            View viewFindViewById5 = viewInflate.findViewById(mb0.kr_param_desc);
            f92.c(viewFindViewById5, "layout.findViewById<TextView>(R.id.kr_param_desc)");
            ((TextView) viewFindViewById5).setText(actionParamInfo.getDesc());
        }
        ((FrameLayout) viewInflate.findViewById(mb0.kr_param_input)).addView(view);
        this.f1160a.addView(viewInflate);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
        ((FrameLayout.LayoutParams) layoutParams).gravity = 16;
    }

    public final String b(ActionParamInfo actionParamInfo) {
        StringBuilder sb = new StringBuilder();
        String title = actionParamInfo.getTitle();
        if (!(title == null || title.length() == 0)) {
            sb.append(actionParamInfo.getTitle());
            sb.append(" ");
        }
        String label = actionParamInfo.getLabel();
        if (!(label == null || label.length() == 0)) {
            sb.append(actionParamInfo.getLabel());
            sb.append(" ");
        }
        sb.append("(");
        sb.append(actionParamInfo.getName());
        sb.append(") ");
        String string = sb.toString();
        f92.c(string, "tips.toString()");
        return string;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01bc A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0186 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.HashMap<java.lang.String, java.lang.String> c(java.util.ArrayList<com.omarea.krscript.model.ActionParamInfo> r14) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.he0.c(java.util.ArrayList):java.util.HashMap");
    }

    public final void d(ArrayList<ActionParamInfo> arrayList, cg0 cg0Var) {
        View viewB;
        f92.d(arrayList, "actionParamInfos");
        for (ActionParamInfo actionParamInfo : arrayList) {
            if (actionParamInfo.getOptionsFromShell() == null || f92.a(actionParamInfo.getType(), "app") || f92.a(actionParamInfo.getType(), "packages")) {
                if (f92.a(actionParamInfo.getType(), "bool") || f92.a(actionParamInfo.getType(), "checkbox")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new uf0(actionParamInfo, this.f1159a).b();
                } else if (f92.a(actionParamInfo.getType(), "switch")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new tg0(actionParamInfo, this.f1159a).b();
                } else if (f92.a(actionParamInfo.getType(), "seekbar")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new og0(actionParamInfo, this.f1159a).b();
                } else if (f92.a(actionParamInfo.getType(), "file") || f92.a(actionParamInfo.getType(), "folder")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new hg0(actionParamInfo, this.f1159a, cg0Var).d();
                } else if (f92.a(actionParamInfo.getType(), "app") || f92.a(actionParamInfo.getType(), "packages")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new sf0(actionParamInfo, this.f1159a).e();
                } else if (f92.a(actionParamInfo.getType(), "color")) {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new ag0(actionParamInfo, this.f1159a).g();
                } else {
                    f92.c(actionParamInfo, "actionParamInfo");
                    viewB = new bg0(actionParamInfo, this.f1159a).a();
                }
            } else if (actionParamInfo.getMultiple()) {
                f92.c(actionParamInfo, "actionParamInfo");
                viewB = new kg0(actionParamInfo, this.f1159a).e();
            } else {
                f92.c(actionParamInfo, "actionParamInfo");
                viewB = new rg0(actionParamInfo, this.f1159a).d();
            }
            a(viewB, actionParamInfo);
        }
    }
}
