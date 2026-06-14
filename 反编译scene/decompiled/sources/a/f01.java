package a;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f01 extends RecyclerView.g<a> implements b61 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e01 f6058a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ih0 f827a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ru0 f828a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f829a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f830a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f831a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<AppInfo> f832a;
    public e01 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<AppInfo> f833b;
    public final boolean c;
    public boolean d;

    public final class a extends c61 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ImageView f6059a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f834a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(f01 f01Var, View view) {
            super(view);
            f92.d(view, "view");
        }

        public final ImageView O() {
            return this.f6059a;
        }

        public final String P() {
            return this.f834a;
        }

        public final void Q(ImageView imageView) {
            this.f6059a = imageView;
        }

        public final void R(TextView textView) {
        }

        public final void S(String str) {
            this.f834a = str;
        }
    }

    public f01(Context context, ArrayList<AppInfo> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        this.f829a = context;
        this.f833b = arrayList;
        int i = 0;
        this.f827a = new ih0(context, i, 0, 6, null);
        this.f832a = this.f833b;
        this.f830a = yb.d(this.f829a, 2131231120);
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(0.05f);
        new ColorMatrixColorFilter(colorMatrix);
        this.f831a = "android";
        this.f828a = new ru0(this.f829a, false, i, 6, null);
    }

    public final boolean C() {
        return this.d;
    }

    public final AppInfo D(int i) {
        if (i < this.f832a.size()) {
            AppInfo appInfo = this.f832a.get(i);
            f92.c(appInfo, "filterApps[position]");
            return appInfo;
        }
        AppInfo item = AppInfo.getItem();
        item.setPackageName("plus");
        String string = this.f829a.getString(u61.freezer_add);
        f92.c(string, "context.getString(R.string.freezer_add)");
        item.setAppName(string);
        f92.c(item, "AppInfo.getItem().apply …reezer_add)\n            }");
        return item;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public void n(a aVar, int i) {
        f92.d(aVar, "viewHolder");
        AppInfo appInfoD = D(i);
        String packageName = appInfoD.getPackageName();
        aVar.S(packageName);
        ImageView imageViewO = aVar.O();
        if (imageViewO != null) {
            imageViewO.setAlpha((f92.a(appInfoD.getPackageName(), this.f831a) || C()) ? 1.0f : 0.2f);
        }
        if (f92.a(appInfoD.getPackageName(), "plus")) {
            ImageView imageViewO2 = aVar.O();
            f92.b(imageViewO2);
            imageViewO2.setImageDrawable(yb.d(this.f829a, 2131230968));
        } else {
            ImageView imageViewO3 = aVar.O();
            f92.b(imageViewO3);
            qc2.d(hf2.f6309a, qe2.b(), null, new h01(imageViewO3, null, this, appInfoD, packageName, aVar), 2, null);
        }
        ((RecyclerView.d0) aVar).f4387a.setOnClickListener(new i01(this, i));
        ((RecyclerView.d0) aVar).f4387a.setOnLongClickListener(new j01(this, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public a p(ViewGroup viewGroup, int i) {
        f92.d(viewGroup, "parent");
        View viewInflate = LayoutInflater.from(this.f829a).inflate(2131558621, viewGroup, false);
        f92.c(viewInflate, "convertView");
        a aVar = new a(this, viewInflate);
        aVar.R((TextView) viewInflate.findViewById(2131361824));
        aVar.Q((ImageView) viewInflate.findViewById(2131361811));
        return aVar;
    }

    public final void G(boolean z) {
        this.d = z;
        i();
    }

    public final void H(e01 e01Var) {
        this.f6058a = e01Var;
    }

    public final void I(String str) {
        f92.d(str, "selected");
        if (!f92.a(str, this.f831a)) {
            String str2 = this.f831a;
            this.f831a = str;
            ArrayList<AppInfo> arrayList = this.f833b;
            ArrayList arrayList2 = new ArrayList(z42.m(arrayList, 10));
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((AppInfo) it.next()).getPackageName());
            }
            int iIndexOf = arrayList2.indexOf(str2);
            if (iIndexOf > -1) {
                j(iIndexOf);
            }
            ArrayList<AppInfo> arrayList3 = this.f833b;
            ArrayList arrayList4 = new ArrayList(z42.m(arrayList3, 10));
            Iterator<T> it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((AppInfo) it2.next()).getPackageName());
            }
            int iIndexOf2 = arrayList4.indexOf(str);
            if (iIndexOf2 > -1) {
                j(iIndexOf2);
            }
        }
    }

    @Override // a.b61
    public void a(int i, int i2) {
        AppInfo appInfoRemove = this.f833b.remove(i);
        f92.c(appInfoRemove, "apps.removeAt(fromPosition)");
        this.f833b.add(i2, appInfoRemove);
        k(i, i2);
    }

    @Override // a.b61
    public void b(int i) {
        this.f833b.remove(i);
        l(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.g
    public int e() {
        return !this.c ? this.f833b.size() : this.f832a.size() + 1;
    }
}
