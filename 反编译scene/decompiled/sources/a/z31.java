package a;

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
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class z31 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih0 f8033a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f3792a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f3793a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<AppInfo> f3794a;

    public z31(Context context, ArrayList<AppInfo> arrayList) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        this.f3792a = context;
        this.f8033a = new ih0(context, 300, 0, 4, null);
        this.f3793a = "";
        this.f3794a = a(arrayList, "");
    }

    public final ArrayList<AppInfo> a(ArrayList<AppInfo> arrayList, String str) {
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
            if (d((AppInfo) obj, lowerCase)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public AppInfo getItem(int i) {
        ArrayList<AppInfo> arrayList = this.f3794a;
        f92.b(arrayList);
        AppInfo appInfo = arrayList.get(i);
        f92.c(appInfo, "list!![position]");
        return appInfo;
    }

    public final SpannableString c(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f3793a.length() == 0) {
            return spannableString;
        }
        Locale locale = Locale.getDefault();
        f92.c(locale, "Locale.getDefault()");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        String str2 = this.f3793a;
        Locale locale2 = Locale.getDefault();
        f92.c(locale2, "Locale.getDefault()");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase(locale2);
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f3793a.length() + iN, 33);
        return spannableString;
    }

    public final boolean d(AppInfo appInfo, String str) {
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

    public final void e(int i, View view) {
        f92.d(view, "convertView");
        AppInfo item = getItem(i);
        y31 y31Var = new y31(this);
        y31Var.f((TextView) view.findViewById(2131361824));
        y31Var.e((TextView) view.findViewById(2131361806));
        y31Var.d((ImageView) view.findViewById(2131361811));
        TextView textViewC = y31Var.c();
        if (textViewC != null) {
            textViewC.setText(c(item.getAppName()));
        }
        Drawable drawableJ = this.f8033a.j(item);
        ImageView imageViewA = y31Var.a();
        f92.b(imageViewA);
        if (drawableJ != null) {
            imageViewA.setImageDrawable(drawableJ);
        }
        CharSequence charSequence = item.desc;
        if (charSequence == null || charSequence.length() == 0) {
            TextView textViewB = y31Var.b();
            if (textViewB != null) {
                textViewB.setVisibility(8);
                return;
            }
            return;
        }
        TextView textViewB2 = y31Var.b();
        if (textViewB2 != null) {
            textViewB2.setText(item.desc);
        }
        TextView textViewB3 = y31Var.b();
        if (textViewB3 != null) {
            textViewB3.setVisibility(0);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<AppInfo> arrayList = this.f3794a;
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
            view = View.inflate(this.f3792a, 2131558642, null);
        }
        f92.b(view);
        e(i, view);
        return view;
    }
}
