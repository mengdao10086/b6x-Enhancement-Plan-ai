package a;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Filterable;
import android.widget.ListAdapter;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class t80 implements TextWatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f7475a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final /* synthetic */ AbsListView f3001a;

    public t80(View view, AbsListView absListView) {
        this.f7475a = view;
        this.f3001a = absListView;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        if (editable != null) {
            View view = this.f7475a;
            f92.c(view, "clearBtn");
            view.setVisibility(editable.length() > 0 ? 0 : 8);
        }
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        AbsListView absListView = this.f3001a;
        f92.c(absListView, "absListView");
        ListAdapter listAdapter = (ListAdapter) absListView.getAdapter();
        if (listAdapter == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.widget.Filterable");
        }
        ((Filterable) listAdapter).getFilter().filter(charSequence == null ? "" : charSequence.toString());
    }
}
