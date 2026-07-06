package a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u70 extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g82<? super n30, m42> f7571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3146a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Filter f3147a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3148a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<n30> f3149a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<n30> f3150a;
    public final ArrayList<n30> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<n30> f3151b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3152b;

    public u70(Context context, List<n30> list, List<n30> list2, boolean z) {
        f92.d(context, "context");
        f92.d(list, "items");
        f92.d(list2, "selectedItems");
        this.f3146a = context;
        this.f3150a = list;
        this.f3151b = list2;
        this.f3152b = z;
        this.f3149a = new ArrayList<>(this.f3150a);
        this.f3148a = new Object();
        ArrayList<n30> arrayList = new ArrayList<>();
        Iterator<T> it = this.f3151b.iterator();
        while (it.hasNext()) {
            arrayList.add((n30) it.next());
        }
        m42 m42Var = m42.f6769a;
        this.b = arrayList;
        this.f7571a = s70.f7369a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public n30 getItem(int i) {
        n30 n30Var = this.f3149a.get(i);
        f92.c(n30Var, "filterItems[position]");
        return n30Var;
    }

    public final g82<n30, m42> f() {
        return this.f7571a;
    }

    public final boolean[] g() {
        List<n30> list = this.f3150a;
        ArrayList arrayList = new ArrayList(z42.m(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(this.b.contains((n30) it.next())));
        }
        return i52.W(arrayList);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3149a.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3147a == null) {
            this.f3147a = new q70(this);
        }
        Filter filter = this.f3147a;
        f92.b(filter);
        return filter;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f92.d(viewGroup, "parent");
        if (view == null) {
            view = View.inflate(this.f3146a, this.f3152b ? y20.item_multiple_chooser_item : y20.item_single_chooser_item, null);
        }
        f92.b(view);
        k(i, view);
        return view;
    }

    public final List<n30> h() {
        return this.b;
    }

    public final void i(ArrayList<n30> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f3149a = arrayList;
    }

    public final void j(g82<? super n30, m42> g82Var) {
        f92.d(g82Var, "<set-?>");
        this.f7571a = g82Var;
    }

    public final void k(int i, View view) {
        f92.d(view, "convertView");
        n30 item = getItem(i);
        r70 r70Var = new r70(this);
        r70Var.g((TextView) view.findViewById(x20.ItemTitle));
        r70Var.f((TextView) view.findViewById(x20.ItemDesc));
        r70Var.e((ImageView) view.findViewById(x20.ItemIcon));
        r70Var.d((CompoundButton) view.findViewById(x20.ItemCheckBox));
        view.setOnClickListener(new t70(this, item, r70Var));
        TextView textViewC = r70Var.c();
        if (textViewC != null) {
            textViewC.setText(item.d());
        }
        TextView textViewB = r70Var.b();
        if (textViewB != null) {
            CharSequence charSequenceA = item.a();
            if (charSequenceA == null || charSequenceA.length() == 0) {
                textViewB.setVisibility(8);
            } else {
                textViewB.setText(item.a());
            }
        }
        CompoundButton compoundButtonA = r70Var.a();
        if (compoundButtonA != null) {
            compoundButtonA.setChecked(this.b.contains(item));
        }
    }
}
