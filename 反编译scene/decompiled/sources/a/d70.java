package a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.LruCache;
import android.view.LayoutInflater;
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
public final class d70 extends BaseAdapter implements Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f70 f5867a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final wd2 f496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LruCache<String, Drawable> f498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Filter f499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<a> f501a;
    public ArrayList<a> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f502b;

    public static class a {
        public boolean notFound;
        public boolean selected;
        public String appName = "";
        public String packageName = "";

        public final String getAppName() {
            return this.appName;
        }

        public final boolean getNotFound() {
            return this.notFound;
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final boolean getSelected() {
            return this.selected;
        }

        public final void setAppName(String str) {
            f92.d(str, "<set-?>");
            this.appName = str;
        }

        public final void setNotFound(boolean z) {
            this.notFound = z;
        }

        public final void setPackageName(String str) {
            f92.d(str, "<set-?>");
            this.packageName = str;
        }

        public final void setSelected(boolean z) {
            this.selected = z;
        }
    }

    public d70(Context context, ArrayList<a> arrayList, boolean z) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        this.f497a = context;
        this.b = arrayList;
        this.f502b = z;
        this.f501a = arrayList;
        this.f500a = new Object();
        this.f496a = xd2.a(ng2.b(null, 1, null).plus(qe2.b()));
        this.f498a = new LruCache<>(100);
        ArrayList<a> arrayList2 = this.f501a;
        if (arrayList2.size() > 1) {
            c52.n(arrayList2, new c70());
        }
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public a getItem(int i) {
        a aVar = this.f501a.get(i);
        f92.c(aVar, "filterApps[position]");
        return aVar;
    }

    public final List<a> g() {
        ArrayList<a> arrayList = this.b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((a) obj).getSelected()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f501a.size();
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f499a == null) {
            this.f499a = new e70(this);
        }
        Filter filter = this.f499a;
        f92.b(filter);
        return filter;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return getItem(i).getPackageName().hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f92.d(viewGroup, "parent");
        if (view == null) {
            view = LayoutInflater.from(this.f497a).inflate(this.f502b ? y20.app_multiple_chooser_item : y20.app_single_chooser_item, viewGroup, false);
        }
        f92.b(view);
        l(i, view);
        return view;
    }

    public final Drawable h(a aVar) {
        String packageName = aVar.getPackageName();
        Drawable drawable = this.f498a.get(packageName);
        if (drawable != null || aVar.getNotFound()) {
            return drawable;
        }
        try {
            Drawable applicationIcon = this.f497a.getPackageManager().getApplicationIcon(packageName);
            f92.c(applicationIcon, "context.packageManager.g…licationIcon(packageName)");
            this.f498a.put(packageName, applicationIcon);
        } catch (Exception unused) {
            aVar.setNotFound(true);
        }
        return this.f498a.get(packageName);
    }

    public final void i(ArrayList<a> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f501a = arrayList;
    }

    public final void j(boolean z) {
        Iterator<T> it = this.b.iterator();
        while (it.hasNext()) {
            ((a) it.next()).setSelected(z);
        }
        notifyDataSetChanged();
    }

    public final void k(f70 f70Var) {
        this.f5867a = f70Var;
    }

    public final void l(int i, View view) {
        g70 g70Var;
        f92.d(view, "convertView");
        a item = getItem(i);
        if (view.getTag() != null) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.common.ui.AdapterAppChooser.ViewHolder");
            }
            g70Var = (g70) tag;
        } else {
            g70Var = new g70(this);
            g70Var.h((TextView) view.findViewById(x20.ItemTitle));
            g70Var.g((TextView) view.findViewById(x20.ItemDesc));
            g70Var.f((ImageView) view.findViewById(x20.ItemIcon));
            g70Var.e((CompoundButton) view.findViewById(x20.ItemCheckBox));
            view.setTag(g70Var);
        }
        String packageName = item.getPackageName();
        g70Var.i(packageName);
        view.setOnClickListener(new j70(this, item, g70Var));
        TextView textViewD = g70Var.d();
        if (textViewD != null) {
            textViewD.setText(item.getAppName());
        }
        TextView textViewC = g70Var.c();
        if (textViewC != null) {
            textViewC.setText(item.getPackageName());
        }
        CompoundButton compoundButtonA = g70Var.a();
        if (compoundButtonA != null) {
            compoundButtonA.setChecked(item.getSelected());
        }
        ImageView imageViewB = g70Var.b();
        f92.b(imageViewB);
        imageViewB.setTag(packageName);
        qc2.d(this.f496a, null, null, new i70(imageViewB, null, this, item, packageName), 3, null);
    }
}
