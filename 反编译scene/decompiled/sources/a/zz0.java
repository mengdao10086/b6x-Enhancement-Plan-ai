package a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class zz0 extends RecyclerView.g<a> implements b61, Filterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih0 f8111a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public yz0 f3912a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3913a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Filter f3914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f3915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f3916a;
    public yz0 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<AppInfo> f3917b;
    public boolean c;

    public final class a extends c61 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f8112a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public TextView f3918a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f3919a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(zz0 zz0Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final ImageView O() {
            return this.f8112a;
        }

        public final TextView P() {
            return this.f3918a;
        }

        public final String Q() {
            return this.f3919a;
        }

        public final void R(ImageView imageView) {
            this.f8112a = imageView;
        }

        public final void S(TextView textView) {
            this.f3918a = textView;
        }

        public final void T(String str) {
            this.f3919a = str;
        }
    }

    public zz0(Context context, ArrayList<AppInfo> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        this.f3913a = context;
        this.f3917b = arrayList;
        this.f8111a = new ih0(context, 0, 0, 6, null);
        this.f3916a = this.f3917b;
        this.f3915a = new Object();
    }

    public final AppInfo C(int i) {
        if (this.c) {
            AppInfo appInfo = this.f3917b.get(i);
            f92.c(appInfo, "apps.get(position)");
            return appInfo;
        }
        if (i < this.f3916a.size()) {
            AppInfo appInfo2 = this.f3916a.get(i);
            f92.c(appInfo2, "filterApps[position]");
            return appInfo2;
        }
        AppInfo item = AppInfo.getItem();
        item.setPackageName("plus");
        String string = this.f3913a.getString(u61.freezer_add);
        f92.c(string, "context.getString(R.string.freezer_add)");
        item.setAppName(string);
        f92.c(item, "AppInfo.getItem().apply …reezer_add)\n            }");
        return item;
    }

    public final ArrayList<AppInfo> D() {
        return this.c ? this.f3917b : this.f3916a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "viewHolder");
        AppInfo appInfoC = C(i);
        String packageName = appInfoC.getPackageName();
        aVar.T(packageName);
        TextView textViewP = aVar.P();
        f92.b(textViewP);
        textViewP.setText(appInfoC.getAppName());
        ImageView imageViewO = aVar.O();
        if (imageViewO != null) {
            Boolean bool = appInfoC.enabled;
            f92.c(bool, "item.enabled");
            imageViewO.setAlpha((!bool.booleanValue() || appInfoC.suspended.booleanValue()) ? 0.3f : 1.0f);
        }
        if (f92.a(appInfoC.getPackageName(), "plus")) {
            ImageView imageViewO2 = aVar.O();
            f92.b(imageViewO2);
            imageViewO2.setImageDrawable(yb.d(this.f3913a, 2131230968));
        } else {
            qc2.d(hf2.f6309a, qe2.b(), null, new b01(aVar, null, this, appInfoC, aVar, packageName), 2, null);
        }
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new c01(this, i));
        ((RecyclerView.d0) aVar).f4387a.setOnLongClickListener(new d01(this, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f3913a).inflate(2131558631, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.S((TextView) viewInflate.findViewById(2131361824));
        aVar.R((ImageView) viewInflate.findViewById(2131361811));
        return aVar;
    }

    public final void G(AppInfo appInfo) {
        f92.d(appInfo, "item");
        this.f3917b.remove(appInfo);
        this.f3916a.remove(appInfo);
        i();
    }

    public final void H(boolean z) {
        xz0 xz0Var;
        if (this.c != z) {
            this.c = z;
            if (!z && (xz0Var = (xz0) this.f3914a) != null) {
                xz0Var.filter(xz0Var.a());
            }
            i();
        }
    }

    public final void I(ArrayList<AppInfo> arrayList) {
        f92.d(arrayList, "<set-?>");
        this.f3916a = arrayList;
    }

    public final void J(yz0 yz0Var) {
        this.f3912a = yz0Var;
    }

    public final void K(yz0 yz0Var) {
        this.b = yz0Var;
    }

    @Override // a.b61
    public void a(int i, int i2) {
        try {
            if (i < e() && i2 < e()) {
                AppInfo appInfoRemove = this.f3916a.remove(i);
                f92.c(appInfoRemove, "filterApps.removeAt(fromPosition)");
                this.f3916a.add(i2, appInfoRemove);
                k(i, i2);
            }
        } catch (Exception unused) {
        }
    }

    @Override // a.b61
    public void b(int i) {
        this.f3917b.remove(i);
        l(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return this.c ? this.f3917b.size() : this.f3916a.size() + 1;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f3914a == null) {
            this.f3914a = new xz0(this);
        }
        Filter filter = this.f3914a;
        f92.b(filter);
        return filter;
    }
}
