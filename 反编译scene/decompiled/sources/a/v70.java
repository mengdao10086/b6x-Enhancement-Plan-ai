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
public final class v70 extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g82<? super n30, m42> f7665a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public l70 f3252a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3253a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Filter f3254a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3255a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<n30> f3256a;
    public g82<? super n30, Boolean> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<n30> f3257b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f3258b;

    public v70(Context context, ArrayList<n30> arrayList, boolean z) {
        f92.d(context, "context");
        f92.d(arrayList, "items");
        this.f3253a = context;
        this.f3257b = arrayList;
        this.f3258b = z;
        this.f3256a = arrayList;
        this.f3255a = new Object();
        this.f7665a = n70.f6883a;
    }

    public final ArrayList<n30> e() {
        return this.f3256a;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public n30 getItem(int i) {
        n30 n30Var = this.f3256a.get(i);
        f92.c(n30Var, "filterItems[position]");
        return n30Var;
    }

    public final g82<n30, m42> g() {
        return this.f7665a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f3256a.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3254a == null) {
            this.f3254a = new k70(this);
        }
        Filter filter = this.f3254a;
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
            view = View.inflate(this.f3253a, this.f3258b ? y20.item_multiple_chooser_item : y20.item_single_chooser_item, null);
        }
        f92.b(view);
        p(i, view);
        return view;
    }

    public final g82<n30, Boolean> h() {
        return this.b;
    }

    public final boolean[] i() {
        ArrayList<n30> arrayList = this.f3257b;
        ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Boolean.valueOf(((n30) it.next()).c()));
        }
        return i52.W(arrayList2);
    }

    public final List<n30> j() {
        ArrayList<n30> arrayList = this.f3257b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((n30) obj).c()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public final void k(ArrayList<n30> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f3256a = arrayList;
    }

    public final void l(g82<? super n30, m42> g82Var) {
        f92.d(g82Var, "<set-?>");
        this.f7665a = g82Var;
    }

    public final void m(g82<? super n30, Boolean> g82Var) {
        this.b = g82Var;
    }

    public final void n(boolean z) {
        Iterator<T> it = this.f3257b.iterator();
        while (it.hasNext()) {
            ((n30) it.next()).h(z);
        }
        notifyDataSetChanged();
    }

    public final void o(l70 l70Var) {
        this.f3252a = l70Var;
    }

    public final void p(int i, View view) {
        f92.d(view, "convertView");
        n30 item = getItem(i);
        m70 m70Var = new m70(this);
        m70Var.i((TextView) view.findViewById(x20.ItemTitle));
        m70Var.h((TextView) view.findViewById(x20.ItemDesc));
        m70Var.f((ImageView) view.findViewById(x20.ItemIcon));
        m70Var.e((CompoundButton) view.findViewById(x20.ItemCheckBox));
        m70Var.g(view.findViewById(x20.ItemDelete));
        view.setOnClickListener(new p70(this, item, m70Var));
        TextView textViewD = m70Var.d();
        if (textViewD != null) {
            textViewD.setText(item.d());
        }
        TextView textViewC = m70Var.c();
        if (textViewC != null) {
            CharSequence charSequenceA = item.a();
            if (charSequenceA == null || charSequenceA.length() == 0) {
                textViewC.setVisibility(8);
            } else {
                textViewC.setText(item.a());
            }
        }
        CompoundButton compoundButtonA = m70Var.a();
        if (compoundButtonA != null) {
            compoundButtonA.setChecked(item.c());
        }
        View viewB = m70Var.b();
        if (viewB != null) {
            viewB.setOnClickListener(new o70(this, item));
            viewB.setVisibility(this.b != null ? 0 : 8);
        }
    }
}
