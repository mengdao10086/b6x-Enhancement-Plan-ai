package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class wz0 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih0 f7837a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public uz0 f3496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<AppInfo> f3499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"UseSparseArrays"})
    public HashMap<Integer, Boolean> f3500a;
    public final boolean b;

    public wz0(Context context, ArrayList<AppInfo> arrayList, String str, boolean z) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        f92.d(str, "keywords");
        this.f3497a = context;
        this.f3498a = str;
        this.b = z;
        this.f7837a = new ih0(context, 256, 0, 4, null);
        this.f3500a = new HashMap<>();
        ArrayList<AppInfo> arrayListA = a(arrayList, this.f3498a);
        e(arrayListA);
        this.f3499a = arrayListA;
        int size = arrayListA.size();
        for (int i = 0; i < size; i++) {
            this.f3500a.put(Integer.valueOf(i), Boolean.valueOf(this.f3499a.get(i).stateTags != null && this.f3499a.get(i).getSelected()));
        }
    }

    public final ArrayList<AppInfo> a(ArrayList<AppInfo> arrayList, String str) {
        if (this.b) {
            return arrayList;
        }
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (lowerCase.length() == 0) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (d((AppInfo) obj, lowerCase)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppInfo getItem(int i) {
        ArrayList<AppInfo> arrayList = this.f3499a;
        f92.b(arrayList);
        AppInfo appInfo = arrayList.get(i);
        f92.c(appInfo, "list!![position]");
        return appInfo;
    }

    public final SpannableString c(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f3498a.length() == 0) {
            return spannableString;
        }
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        String str2 = this.f3498a;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase();
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f3498a.length() + iN, 33);
        return spannableString;
    }

    public final boolean d(AppInfo appInfo, String str) {
        String packageName = appInfo.getPackageName();
        if (packageName == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = packageName.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (!ec2.C(lowerCase, str, false, 2, null)) {
            String appName = appInfo.getAppName();
            if (appName == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = appName.toLowerCase();
            f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
            if (!ec2.C(lowerCase2, str, false, 2, null)) {
                String string = appInfo.path.toString();
                if (string == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = string.toLowerCase();
                f92.c(lowerCase3, "(this as java.lang.String).toLowerCase()");
                if (!ec2.C(lowerCase3, str, false, 2, null)) {
                    return false;
                }
            }
        }
        return true;
    }

    public final ArrayList<AppInfo> e(ArrayList<AppInfo> arrayList) {
        c52.n(arrayList, vz0.f7737a);
        return arrayList;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<AppInfo> arrayList = this.f3499a;
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
            this.f3496a = new uz0(this);
            view = View.inflate(context, 2131558615, null);
            uz0 uz0Var = this.f3496a;
            if (uz0Var != null) {
                f92.b(view);
                uz0Var.f((TextView) view.findViewById(2131361824));
                uz0Var.e((TextView) view.findViewById(t61.ItemText));
                uz0Var.d((ImageView) view.findViewById(2131361811));
            }
            f92.c(view, "convertView");
            view.setTag(this.f3496a);
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppBasic.ViewHolder");
            }
            this.f3496a = (uz0) tag;
        }
        uz0 uz0Var2 = this.f3496a;
        if (uz0Var2 != null) {
            AppInfo item = getItem(i);
            TextView textViewC = uz0Var2.c();
            if (textViewC != null) {
                textViewC.setText(c(item.getAppName()));
            }
            TextView textViewB = uz0Var2.b();
            if (textViewB != null) {
                textViewB.setText(c(item.getPackageName()));
            }
            Drawable drawableJ = this.f7837a.j(item);
            ImageView imageViewA = uz0Var2.a();
            f92.b(imageViewA);
            if (drawableJ != null) {
                imageViewA.setImageDrawable(drawableJ);
            }
        }
        f92.b(view);
        return view;
    }
}
