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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class b90 extends e80 {
    public final boolean A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g82<? super n30, Boolean> f5684a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public s80 f244a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AbsListView f245a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public HashMap f246a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<n30> f247a;
    public String d;
    public String e;
    public final int k;
    public boolean z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b90(boolean z, List<n30> list, boolean z2, s80 s80Var, int i) {
        super(list.size() > i ? y20.dialog_item_chooser : y20.dialog_item_chooser_small, z);
        f92.d(list, "items");
        this.f247a = list;
        this.A = z2;
        this.f244a = s80Var;
        this.k = i;
        this.d = "";
        this.e = "";
        this.z = true;
    }

    public /* synthetic */ b90(boolean z, List list, boolean z2, s80 s80Var, int i, int i2, b92 b92Var) {
        this(z, list, (i2 & 4) != 0 ? false : z2, (i2 & 8) != 0 ? null : s80Var, (i2 & 16) != 0 ? 7 : i);
    }

    @Override // a.e80
    public void C1() {
        HashMap map = this.f246a;
        if (map != null) {
            map.clear();
        }
    }

    @Override // a.e80, androidx.fragment.app.Fragment
    public void D0(View view, Bundle bundle) {
        f92.d(view, "view");
        super.D0(view, bundle);
        AbsListView absListView = (AbsListView) view.findViewById(x20.item_list);
        this.f245a = absListView;
        f92.c(absListView, "absListView");
        M1(absListView);
        view.findViewById(x20.btn_cancel).setOnClickListener(new v80(this));
        view.findViewById(x20.btn_confirm).setOnClickListener(new w80(this, absListView));
        CompoundButton compoundButton = (CompoundButton) view.findViewById(x20.select_all);
        boolean z = true;
        if (compoundButton != null) {
            if (this.A) {
                v70 v70Var = (v70) ((ListAdapter) absListView.getAdapter());
                compoundButton.setVisibility(0);
                List<n30> list = this.f247a;
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((n30) obj).c()) {
                        arrayList.add(obj);
                    }
                }
                compoundButton.setChecked(arrayList.size() == this.f247a.size());
                compoundButton.setOnClickListener(new x80(v70Var));
                if (v70Var != null) {
                    v70Var.o(new u80(this, compoundButton));
                }
            } else {
                compoundButton.setVisibility(8);
            }
        }
        if (this.f247a.size() <= this.k || this.f247a.size() <= 10) {
            View viewFindViewById = view.findViewById(x20.search_bar);
            f92.c(viewFindViewById, "view.findViewById<View>(R.id.search_bar)");
            viewFindViewById.setVisibility(8);
        } else {
            View viewFindViewById2 = view.findViewById(x20.search_box_clear);
            EditText editText = (EditText) view.findViewById(x20.search_box);
            editText.addTextChangedListener(new t80(viewFindViewById2, absListView));
            f92.c(viewFindViewById2, "clearBtn");
            f92.c(editText, "searchBox");
            Editable text = editText.getText();
            if (text != null && text.length() != 0) {
                z = false;
            }
            viewFindViewById2.setVisibility(z ? 8 : 0);
            viewFindViewById2.setOnClickListener(new y80(editText));
        }
        N1();
        P1();
        O1();
    }

    public final void H1(AbsListView absListView) {
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterItemChooser");
        }
        v70 v70Var = (v70) listAdapter;
        List<n30> listJ = v70Var.j();
        boolean[] zArrI = v70Var.i();
        s80 s80Var = this.f244a;
        if (s80Var != null) {
            s80Var.a(listJ, zArrI);
        }
        v1();
    }

    public final b90 I1(String str) {
        f92.d(str, "message");
        this.e = str;
        O1();
        return this;
    }

    public final b90 J1(g82<? super n30, Boolean> g82Var) {
        this.f5684a = g82Var;
        AbsListView absListView = this.f245a;
        v70 v70Var = (v70) (absListView != null ? (ListAdapter) absListView.getAdapter() : null);
        if (v70Var != null) {
            v70Var.m(g82Var);
        }
        return this;
    }

    public final b90 K1(String str) {
        f92.d(str, "title");
        this.d = str;
        P1();
        return this;
    }

    public final b90 L1(boolean z) {
        if (this.z != z) {
            this.z = z;
            N1();
        }
        return this;
    }

    public final void M1(AbsListView absListView) {
        Context context = absListView.getContext();
        f92.c(context, "gridView.context");
        v70 v70Var = new v70(context, new ArrayList(this.f247a), this.A);
        v70Var.l(new z80(this, absListView));
        v70Var.m(this.f5684a);
        m42 m42Var = m42.f6769a;
        absListView.setAdapter((ListAdapter) v70Var);
    }

    public final void N1() {
        View viewM = M();
        if (viewM != null) {
            viewM.post(new a90(this));
        }
    }

    public final void O1() {
        TextView textView;
        View viewM = M();
        if (viewM == null || (textView = (TextView) viewM.findViewById(x20.dialog_desc)) == null) {
            return;
        }
        textView.setText(this.e);
        textView.setVisibility(this.e.length() > 0 ? 0 : 8);
    }

    public final void P1() {
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
