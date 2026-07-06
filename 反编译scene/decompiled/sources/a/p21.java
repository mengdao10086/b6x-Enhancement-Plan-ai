package a;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih0 f7077a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2377a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2378a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<AppInfo> f2379a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, Integer> f2380a;
    public final String b;

    public p21(Context context, ArrayList<AppInfo> arrayList, String str) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        f92.d(str, "firstMode");
        this.f2377a = context;
        this.b = str;
        this.f7077a = new ih0(context, 300, 0, 4, null);
        this.f2378a = "";
        this.f2379a = b(arrayList, "");
        HashMap<String, Integer> map = new HashMap<>();
        map.put(wu0.f3480a.p(), Integer.valueOf(e(2131099718)));
        map.put(wu0.f3480a.c(), Integer.valueOf(e(2131099703)));
        map.put(wu0.f3480a.o(), Integer.valueOf(e(2131099716)));
        map.put(wu0.f3480a.i(), Integer.valueOf(e(2131099705)));
        map.put(wu0.f3480a.j(), -7829368);
        m42 m42Var = m42.f6769a;
        this.f2380a = map;
    }

    public final ArrayList<AppInfo> b(ArrayList<AppInfo> arrayList, String str) {
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (lowerCase.length() == 0) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (f((AppInfo) obj, lowerCase)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    public final int c(String str) {
        Integer num;
        if (this.f2380a.containsKey(str)) {
            num = this.f2380a.get(str);
        } else {
            if (!(str.length() == 0) || !this.f2380a.containsKey(this.b)) {
                return -7829368;
            }
            num = this.f2380a.get(this.b);
        }
        f92.b(num);
        return num.intValue();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AppInfo getItem(int i) {
        ArrayList<AppInfo> arrayList = this.f2379a;
        f92.b(arrayList);
        AppInfo appInfo = arrayList.get(i);
        f92.c(appInfo, "list!![position]");
        return appInfo;
    }

    public final int e(int i) {
        Resources.Theme theme = this.f2377a.getTheme();
        Resources resources = this.f2377a.getResources();
        return Build.VERSION.SDK_INT >= 23 ? resources.getColor(i, theme) : resources.getColor(i);
    }

    public final boolean f(AppInfo appInfo, String str) {
        String packageName = appInfo.getPackageName();
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (packageName == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = packageName.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!ec2.C(lowerCase, str, false, 2, null)) {
            String appName = appInfo.getAppName();
            Locale locale2 = Locale.getDefault();
            f92.c(locale2, "Locale.getDefault()");
            if (appName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = appName.toLowerCase(locale2);
            f92.c(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (!ec2.C(lowerCase2, str, false, 2, null)) {
                String string = appInfo.path.toString();
                Locale locale3 = Locale.getDefault();
                f92.c(locale3, "Locale.getDefault()");
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = string.toLowerCase(locale3);
                f92.c(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                if (!ec2.C(lowerCase3, str, false, 2, null)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final void g(int i, View view) {
        TextView textViewB;
        f92.d(view, "convertView");
        AppInfo item = getItem(i);
        m21 m21Var = new m21(this);
        m21Var.g((TextView) view.findViewById(2131361824));
        m21Var.h((TextView) view.findViewById(t61.ItemSummary));
        m21Var.f((TextView) view.findViewById(2131361806));
        m21Var.e((ImageView) view.findViewById(2131361811));
        TextView textViewC = m21Var.c();
        if (textViewC != null) {
            textViewC.setText(item.getAppName());
        }
        ImageView imageViewA = m21Var.a();
        f92.b(imageViewA);
        imageViewA.setTag(Integer.valueOf(i));
        qc2.d(xd2.a(qe2.b()), null, null, new o21(imageViewA, null, this, view, item, i), 3, null);
        if (item.stateTags != null) {
            TextView textViewD = m21Var.d();
            if (textViewD != null) {
                String string = item.stateTags.toString();
                textViewD.setTextColor(c(string));
                textViewD.setVisibility(0);
                textViewD.setText(wu0.f3480a.k(string));
            }
        } else {
            TextView textViewD2 = m21Var.d();
            if (textViewD2 != null) {
                textViewD2.setVisibility(8);
            }
        }
        if (m21Var.b() == null || (textViewB = m21Var.b()) == null) {
            return;
        }
        textViewB.setText(item.desc);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<AppInfo> arrayList = this.f2379a;
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
        if (view == null) {
            view = View.inflate(this.f2377a, 2131558635, null);
        }
        f92.b(view);
        g(i, view);
        return view;
    }
}
