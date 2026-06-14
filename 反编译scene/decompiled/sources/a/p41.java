package a;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.ActivityCacheInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p41 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public l41 f7083a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f2388a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ActivityInfo> f2390a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<ActivityInfo> f2391b;

    public p41(Context context, ArrayList<ActivityInfo> arrayList, String str, String str2) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        f92.d(str, "keywords");
        f92.d(str2, "launcherActivity");
        this.f2387a = context;
        this.f2391b = arrayList;
        this.f2389a = str;
        this.b = str2;
        this.f2388a = context.getPackageManager();
        new HashMap();
        this.f2390a = c(this.f2391b, this.f2389a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Iterable, java.util.ArrayList<android.content.pm.ActivityInfo>, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r10v5 */
    public final ArrayList<ActivityInfo> c(ArrayList<ActivityInfo> arrayList, String str) {
        String str2;
        Object next;
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!(lowerCase.length() == 0)) {
            ix0 ix0Var = new ix0(this.f2387a);
            ActivityInfo activityInfo = (ActivityInfo) i52.C(arrayList);
            if (activityInfo == null || (str2 = activityInfo.packageName) == null) {
                str2 = "";
            }
            ArrayList<ActivityCacheInfo> arrayListL = ix0Var.l(str2, lowerCase);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                ActivityInfo activityInfo2 = (ActivityInfo) obj;
                f92.c(arrayListL, "result");
                Iterator it = arrayListL.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (f92.a(((ActivityCacheInfo) next).name, activityInfo2.name)) {
                        break;
                    }
                }
                if (next != null) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        return new ArrayList<>(i52.S(arrayList, new m41(this)));
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ActivityInfo getItem(int i) {
        ArrayList<ActivityInfo> arrayList = this.f2390a;
        f92.b(arrayList);
        ActivityInfo activityInfo = arrayList.get(i);
        f92.c(activityInfo, "list!![position]");
        return activityInfo;
    }

    public final SpannableString e(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f2389a.length() == 0) {
            return spannableString;
        }
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String str2 = this.f2389a;
        Locale locale2 = Locale.ENGLISH;
        f92.c(locale2, "Locale.ENGLISH");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase(locale2);
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f2389a.length() + iN, 33);
        return spannableString;
    }

    public final void f(String str) {
        f92.d(str, "text");
        this.f2389a = str;
        this.f2390a = c(this.f2391b, str);
        notifyDataSetChanged();
    }

    public final void g(String str) {
        f92.d(str, "launcherActivity");
        this.b = str;
        this.f2390a = c(this.f2391b, this.f2389a);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ActivityInfo> arrayList = this.f2390a;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f92.d(viewGroup, "parent");
        Context context = viewGroup.getContext();
        if (view == null) {
            this.f7083a = new l41(this);
            view = View.inflate(context, 2131558615, null);
            l41 l41Var = this.f7083a;
            if (l41Var != null) {
                f92.b(view);
                l41Var.j((TextView) view.findViewById(2131361824));
                l41Var.i((TextView) view.findViewById(t61.ItemText));
                l41Var.h((ImageView) view.findViewById(2131361811));
                l41Var.f(view);
            }
            f92.c(view, "convertView");
            view.setTag(this.f7083a);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterActivities.ViewHolder");
            }
            this.f7083a = (l41) tag;
        }
        l41 l41Var2 = this.f7083a;
        if (l41Var2 != null) {
            ActivityInfo item = getItem(i);
            String string = item.loadLabel(this.f2388a).toString();
            l41Var2.a().setAlpha((item.exported && item.enabled) ? 1.0f : 0.3f);
            TextView textViewE = l41Var2.e();
            if (textViewE != null) {
                textViewE.setText(e(string));
            }
            TextView textViewD = l41Var2.d();
            if (textViewD != null) {
                String str = item.name;
                f92.c(str, "item.name");
                textViewD.setText(e(str));
            }
            String str2 = item.name;
            l41Var2.g(str2);
            qc2.d(hf2.f6309a, qe2.b(), null, new o41(l41Var2, item, str2, null, this, i), 2, null);
        }
        f92.b(view);
        return view;
    }
}
