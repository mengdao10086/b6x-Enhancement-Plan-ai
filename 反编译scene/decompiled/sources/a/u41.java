package a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.ActivityCacheInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class u41 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q41 f7565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f3136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ComponentInfo> f3138a;
    public String b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final ArrayList<ComponentInfo> f3139b;
    public String c;

    public u41(Context context, ArrayList<ComponentInfo> arrayList, String str, String str2, String str3) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        f92.d(str, "type");
        f92.d(str2, "keywords");
        f92.d(str3, "launcherActivity");
        this.f3135a = context;
        this.f3139b = arrayList;
        this.f3137a = str;
        this.b = str2;
        this.c = str3;
        this.f3136a = context.getPackageManager();
        new HashMap();
        this.f3138a = c(this.f3139b, this.b);
    }

    public /* synthetic */ u41(Context context, ArrayList arrayList, String str, String str2, String str3, int i, b92 b92Var) {
        this(context, arrayList, str, (i & 8) != 0 ? "" : str2, (i & 16) != 0 ? "" : str3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [java.lang.Iterable, java.util.ArrayList<android.content.pm.ComponentInfo>, java.util.List] */
    /* JADX WARN: Type inference failed for: r10v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r10v5 */
    public final ArrayList<ComponentInfo> c(ArrayList<ComponentInfo> arrayList, String str) {
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
            ix0 ix0Var = new ix0(this.f3135a);
            String str3 = this.f3137a;
            ComponentInfo componentInfo = (ComponentInfo) i52.C(arrayList);
            if (componentInfo == null || (str2 = componentInfo.packageName) == null) {
                str2 = "";
            }
            ArrayList<ActivityCacheInfo> arrayListN = ix0Var.n(str3, str2, lowerCase);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                ComponentInfo componentInfo2 = (ComponentInfo) obj;
                f92.c(arrayListN, "result");
                Iterator it = arrayListN.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (f92.a(((ActivityCacheInfo) next).name, componentInfo2.name)) {
                        break;
                    }
                }
                if (next != null) {
                    arrayList2.add(obj);
                }
            }
            arrayList = arrayList2;
        }
        return new ArrayList<>(i52.S(arrayList, new r41(this)));
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public ComponentInfo getItem(int i) {
        ArrayList<ComponentInfo> arrayList = this.f3138a;
        f92.b(arrayList);
        ComponentInfo componentInfo = arrayList.get(i);
        f92.c(componentInfo, "list!![position]");
        return componentInfo;
    }

    public final boolean e(ComponentInfo componentInfo) {
        int componentEnabledSetting = this.f3136a.getComponentEnabledSetting(new ComponentName(componentInfo.packageName, componentInfo.name));
        return componentEnabledSetting == 0 || componentEnabledSetting == 1;
    }

    public final SpannableString f(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.b.length() == 0) {
            return spannableString;
        }
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String str2 = this.b;
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
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.b.length() + iN, 33);
        return spannableString;
    }

    public final void g(String str) {
        f92.d(str, "text");
        this.b = str;
        this.f3138a = c(this.f3139b, str);
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ComponentInfo> arrayList = this.f3138a;
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
            this.f7565a = new q41(this);
            view = View.inflate(context, 2131558617, null);
            q41 q41Var = this.f7565a;
            if (q41Var != null) {
                f92.b(view);
                q41Var.l((TextView) view.findViewById(2131361824));
                q41Var.k((TextView) view.findViewById(t61.ItemText));
                q41Var.i((ImageView) view.findViewById(2131361811));
                q41Var.j((CompoundButton) view.findViewById(t61.ItemSwitch));
                q41Var.g(view);
            }
            f92.c(view, "convertView");
            view.setTag(this.f7565a);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.contents.AdapterComponents.ViewHolder");
            }
            this.f7565a = (q41) tag;
        }
        q41 q41Var2 = this.f7565a;
        if (q41Var2 != null) {
            ComponentInfo item = getItem(i);
            String string = item.loadLabel(this.f3136a).toString();
            boolean zE = e(item);
            q41Var2.a().setAlpha(((item.exported && zE) || (f92.a(this.f3137a, "activity") ^ true)) ? 1.0f : 0.3f);
            TextView textViewF = q41Var2.f();
            if (textViewF != null) {
                textViewF.setText(f(string));
            }
            TextView textViewE = q41Var2.e();
            if (textViewE != null) {
                String str = item.name;
                f92.c(str, "item.name");
                textViewE.setText(f(str));
            }
            CompoundButton compoundButtonD = q41Var2.d();
            if (compoundButtonD != null) {
                compoundButtonD.setChecked(zE);
            }
            String str2 = item.name;
            q41Var2.h(str2);
            qc2.d(hf2.f6309a, qe2.b(), null, new t41(q41Var2, item, str2, null, this, i), 2, null);
        }
        f92.b(view);
        return view;
    }

    public final void h(ArrayList<ComponentInfo> arrayList) {
        f92.d(arrayList, "list");
        this.f3139b.clear();
        this.f3139b.addAll(arrayList);
        g(this.b);
    }
}
