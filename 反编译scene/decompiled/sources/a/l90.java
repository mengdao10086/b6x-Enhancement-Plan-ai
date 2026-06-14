package a;

import a.p80;
import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class l90 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e90 f6685a = new e90(null);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f1771a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c90 f1772a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p80.b f1773a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f1774a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f1775a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1776a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<n30> f1777a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1778a;
    public View b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f1779b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<n30> f1780b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f1781b;
    public View c;

    public l90(Context context, List<n30> list, List<n30> list2, boolean z) {
        f92.d(context, "context");
        f92.d(list, "items");
        f92.d(list2, "selectedItems");
        this.f1774a = context;
        this.f1777a = list;
        this.f1780b = list2;
        this.f1781b = z;
        this.f1771a = y20.dialog_item_chooser_small;
        this.f1776a = "";
        this.f1779b = "";
        this.f1778a = true;
    }

    public final View g() {
        View view = this.f1775a;
        if (view != null) {
            f92.b(view);
            return view;
        }
        View viewInflate = LayoutInflater.from(this.f1774a).inflate(this.f1771a, (ViewGroup) null);
        this.f1775a = viewInflate;
        this.b = viewInflate.findViewById(x20.btn_cancel);
        this.c = viewInflate.findViewById(x20.btn_confirm);
        f92.c(viewInflate, "view");
        return viewInflate;
    }

    public final void h() {
        p80.b bVar = this.f1773a;
        if (bVar != null) {
            bVar.c();
        }
    }

    public final void i(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterItemChooser2");
        }
        u70 u70Var = (u70) listAdapter;
        List<n30> listH = u70Var.h();
        boolean[] zArrG = u70Var.g();
        c90 c90Var = this.f1772a;
        if (c90Var != null) {
            c90Var.a(listH, zArrG);
        }
        h();
    }

    public final void j(View view) {
        AbsListView absListView = (AbsListView) view.findViewById(x20.item_list);
        f92.c(absListView, "absListView");
        n(absListView);
        View view2 = this.b;
        if (view2 != null) {
            view2.setOnClickListener(new g90(this));
        }
        View view3 = this.c;
        if (view3 != null) {
            view3.setOnClickListener(new h90(this, absListView));
        }
        if (this.f1777a.size() > 5) {
            View viewFindViewById = view.findViewById(x20.search_box_clear);
            EditText editText = (EditText) view.findViewById(x20.search_box);
            editText.addTextChangedListener(new f90(viewFindViewById, absListView));
            f92.c(viewFindViewById, "clearBtn");
            f92.c(editText, "searchBox");
            Editable text = editText.getText();
            viewFindViewById.setVisibility(text == null || text.length() == 0 ? 8 : 0);
            viewFindViewById.setOnClickListener(new i90(editText));
        }
        p();
        r();
        q();
    }

    public final l90 k(c90 c90Var) {
        this.f1772a = c90Var;
        return this;
    }

    public final l90 l(int i) {
        String string = this.f1774a.getString(i);
        f92.c(string, "context.getString(resId)");
        m(string);
        return this;
    }

    public final l90 m(String str) {
        f92.d(str, "title");
        this.f1776a = str;
        r();
        return this;
    }

    public final void n(AbsListView absListView) {
        Context context = absListView.getContext();
        f92.c(context, "gridView.context");
        u70 u70Var = new u70(context, this.f1777a, this.f1780b, this.f1781b);
        u70Var.j(new j90(this, absListView));
        m42 m42Var = m42.f6769a;
        absListView.setAdapter((ListAdapter) u70Var);
    }

    public final p80.b o() {
        p80.b bVar = this.f1773a;
        if (bVar == null || !bVar.g()) {
            j(g());
            p80.a aVar = p80.f2403a;
            Context context = this.f1774a;
            View view = this.f1775a;
            f92.b(view);
            this.f1773a = p80.a.t(aVar, context, view, false, 4, null);
        }
        p80.b bVar2 = this.f1773a;
        f92.b(bVar2);
        return bVar2;
    }

    public final void p() {
        View view = this.f1775a;
        if (view != null) {
            view.post(new k90(this));
        }
    }

    public final void q() {
        View view = this.f1775a;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(x20.dialog_desc);
            textView.setText(this.f1779b);
            textView.setVisibility(this.f1779b.length() > 0 ? 0 : 8);
        }
    }

    public final void r() {
        View view = this.f1775a;
        if (view != null) {
            TextView textView = (TextView) view.findViewById(x20.dialog_title);
            textView.setText(this.f1776a);
            textView.setVisibility(this.f1776a.length() > 0 ? 0 : 8);
        }
    }
}
