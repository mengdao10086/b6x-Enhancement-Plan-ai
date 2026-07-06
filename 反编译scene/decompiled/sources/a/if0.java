package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.omarea.krscript.model.NodeInfoBase;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class if0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1355a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1356a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TextView f1357a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NodeInfoBase f1358a;
    public TextView b;
    public TextView c;

    public if0(Context context, int i, NodeInfoBase nodeInfoBase) {
        f92.d(context, "context");
        f92.d(nodeInfoBase, "config");
        this.f1355a = context;
        this.f6405a = i;
        this.f1358a = nodeInfoBase;
        View viewInflate = LayoutInflater.from(context).inflate(this.f6405a, (ViewGroup) null);
        this.f1356a = viewInflate;
        this.f1357a = (TextView) viewInflate.findViewById(mb0.kr_desc);
        this.b = (TextView) this.f1356a.findViewById(mb0.kr_summary);
        this.c = (TextView) this.f1356a.findViewById(mb0.kr_title);
        g(this.f1358a.getTitle());
        e(this.f1358a.getDesc());
        f(this.f1358a.getSummary());
    }

    public final String a() {
        return this.f1358a.getIndex();
    }

    public final String b() {
        return this.f1358a.getKey();
    }

    public final View c() {
        return this.f1356a;
    }

    public final View d() {
        View view = this.f1356a;
        f92.c(view, "layout");
        return view;
    }

    public final void e(String str) {
        f92.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.f1357a;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f1357a;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.f1357a;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public final void f(String str) {
        f92.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.b;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.b;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public final void g(String str) {
        f92.d(str, "value");
        if (str.length() == 0) {
            TextView textView = this.c;
            if (textView != null) {
                textView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.c;
        if (textView2 != null) {
            textView2.setText(str);
        }
        TextView textView3 = this.c;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
    }

    public void h() {
        if (this.f1358a.getDescSh().length() > 0) {
            NodeInfoBase nodeInfoBase = this.f1358a;
            String strC = yc0.c(this.f1355a, nodeInfoBase.getDescSh(), this.f1358a);
            f92.c(strC, "ScriptEnvironmen.execute…t, config.descSh, config)");
            nodeInfoBase.setDesc(strC);
            e(this.f1358a.getDesc());
        }
        if (this.f1358a.getSummarySh().length() > 0) {
            NodeInfoBase nodeInfoBase2 = this.f1358a;
            String strC2 = yc0.c(this.f1355a, nodeInfoBase2.getSummarySh(), this.f1358a);
            f92.c(strC2, "ScriptEnvironmen.execute…config.summarySh, config)");
            nodeInfoBase2.setSummary(strC2);
            f(this.f1358a.getSummary());
        }
    }
}
