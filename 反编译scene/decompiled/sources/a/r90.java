package a;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.AbsListView;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class r90 extends e80 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m90 f7283a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f2723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<n30> f2724a;
    public List<n30> b;
    public String d;
    public String e;
    public final boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r90(boolean z, List<n30> list, List<n30> list2, boolean z2, m90 m90Var) {
        super(list.size() > 7 ? y20.dialog_item_chooser : y20.dialog_item_chooser_small, z);
        f92.d(list, "items");
        f92.d(list2, "selectedItems");
        this.f2724a = list;
        this.b = list2;
        this.z = z2;
        this.f7283a = m90Var;
        this.d = "";
        this.e = "";
    }

    @Override // a.e80
    public void C1() {
        HashMap map = this.f2723a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // a.e80, androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        AbsListView absListView = (AbsListView) view.findViewById(x20.item_list);
        f92.c(absListView, "absListView");
        G1(absListView);
        view.findViewById(x20.btn_cancel).setOnClickListener(new o90(this));
        view.findViewById(x20.btn_confirm).setOnClickListener(new p90(this, absListView));
        CompoundButton compoundButton = (CompoundButton) view.findViewById(x20.select_all);
        if (compoundButton != null) {
            compoundButton.setVisibility(8);
        }
        if (this.f2724a.size() > 5) {
            View viewFindViewById = view.findViewById(x20.search_box_clear);
            EditText editText = (EditText) view.findViewById(x20.search_box);
            editText.addTextChangedListener(new n90(viewFindViewById, absListView));
            f92.c(viewFindViewById, "clearBtn");
            f92.c(editText, "searchBox");
            Editable text = editText.getText();
            viewFindViewById.setVisibility(text == null || text.length() == 0 ? 8 : 0);
            viewFindViewById.setOnClickListener(new q90(editText));
        }
        I1();
        H1();
    }

    public final void E1(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterItemChooser2");
        }
        u70 u70Var = (u70) listAdapter;
        List<n30> listH = u70Var.h();
        boolean[] zArrG = u70Var.g();
        m90 m90Var = this.f7283a;
        if (m90Var != null) {
            m90Var.a(listH, zArrG);
        }
        v1();
    }

    public final r90 F1(String str) {
        f92.d(str, "title");
        this.d = str;
        I1();
        return this;
    }

    public final void G1(AbsListView absListView) {
        Context context = absListView.getContext();
        f92.c(context, "gridView.context");
        absListView.setAdapter((ListAdapter) new u70(context, this.f2724a, this.b, this.z));
    }

    public final void H1() {
        TextView textView;
        View viewM = M();
        if (viewM == null || (textView = (TextView) viewM.findViewById(x20.dialog_desc)) == null) {
            return;
        }
        textView.setText(this.e);
        textView.setVisibility(this.e.length() > 0 ? 0 : 8);
    }

    public final void I1() {
        TextView textView;
        View viewM = M();
        if (viewM == null || (textView = (TextView) viewM.findViewById(x20.dialog_title)) == null) {
            return;
        }
        textView.setText(this.d);
        textView.setVisibility(this.d.length() > 0 ? 0 : 8);
    }

    @Override // a.e80, a.wk, androidx.fragment.app.Fragment
    public /* synthetic */ void l0() {
        super.l0();
        C1();
    }
}
