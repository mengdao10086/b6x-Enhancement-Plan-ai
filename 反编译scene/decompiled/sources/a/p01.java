package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.AppInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class p01 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ih0 f7070a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public k01 f2345a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final w90 f2346a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2347a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2348a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<AppInfo> f2349a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @SuppressLint({"UseSparseArrays"})
    public HashMap<Integer, Boolean> f2350a;
    public final boolean b;

    public p01(Context context, ArrayList<AppInfo> arrayList, String str, boolean z) {
        f92.d(context, "context");
        f92.d(arrayList, "apps");
        f92.d(str, "keywords");
        this.f2347a = context;
        this.f2348a = str;
        this.b = z;
        this.f7070a = new ih0(context, 256, 0, 4, null);
        this.f2346a = new w90();
        this.f2350a = new HashMap<>();
        ArrayList<AppInfo> arrayListB = b(arrayList, this.f2348a);
        j(arrayListB);
        this.f2349a = arrayListB;
        int size = arrayListB.size();
        for (int i = 0; i < size; i++) {
            this.f2350a.put(Integer.valueOf(i), Boolean.valueOf(this.f2349a.get(i).stateTags != null && this.f2349a.get(i).getSelected()));
        }
    }

    public /* synthetic */ p01(Context context, ArrayList arrayList, String str, boolean z, int i, b92 b92Var) {
        this(context, arrayList, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? false : z);
    }

    public final ArrayList<AppInfo> b(ArrayList<AppInfo> arrayList, String str) {
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
            if (h((AppInfo) obj, lowerCase)) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    public final boolean c() {
        Iterator<Map.Entry<Integer, Boolean>> it = this.f2350a.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (it.next().getValue().booleanValue()) {
                i++;
            }
        }
        ArrayList<AppInfo> arrayList = this.f2349a;
        f92.b(arrayList);
        return i == arrayList.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public AppInfo getItem(int i) {
        ArrayList<AppInfo> arrayList = this.f2349a;
        f92.b(arrayList);
        AppInfo appInfo = arrayList.get(i);
        f92.c(appInfo, "list!![position]");
        return appInfo;
    }

    public final ArrayList<AppInfo> e() {
        HashMap<Integer, Boolean> map = this.f2350a;
        Set<Integer> setKeySet = map.keySet();
        f92.c(setKeySet, "states.keys");
        ArrayList<Integer> arrayList = new ArrayList();
        for (Object obj : setKeySet) {
            if (f92.a(map.get((Integer) obj), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        ArrayList<AppInfo> arrayList2 = new ArrayList<>();
        for (Integer num : arrayList) {
            f92.c(num, "it");
            arrayList2.add(getItem(num.intValue()));
        }
        return arrayList2.isEmpty() ? new ArrayList<>() : arrayList2;
    }

    public final HashMap<Integer, Boolean> f() {
        return this.f2350a;
    }

    public final boolean g() {
        HashMap<Integer, Boolean> map = this.f2350a;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Integer, Boolean>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                return !linkedHashMap.isEmpty();
            }
            Map.Entry<Integer, Boolean> next = it.next();
            if (next.getValue().booleanValue()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<AppInfo> arrayList = this.f2349a;
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
        View view2;
        CheckBox checkBoxC;
        f92.d(viewGroup, "parent");
        Context context = viewGroup.getContext();
        if (view == null) {
            this.f2345a = new k01(this);
            View viewInflate = View.inflate(context, 2131558620, null);
            k01 k01Var = this.f2345a;
            if (k01Var != null) {
                f92.b(viewInflate);
                k01Var.j((TextView) viewInflate.findViewById(2131361824));
                k01Var.f((TextView) viewInflate.findViewById(t61.ItemEnabledStateText));
                k01Var.i((TextView) viewInflate.findViewById(t61.ItemText));
                k01Var.g((ImageView) viewInflate.findViewById(2131361811));
                k01Var.h((CheckBox) viewInflate.findViewById(t61.select_state));
                ImageView imageViewB = k01Var.b();
                f92.b(imageViewB);
                imageViewB.setTag(getItem(i).getPackageName());
            }
            f92.c(viewInflate, "convertView");
            viewInflate.setTag(this.f2345a);
            view2 = viewInflate;
        } else {
            Object tag = view.getTag();
            if (tag == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.omarea.ui.AdapterAppList.ViewHolder");
            }
            this.f2345a = (k01) tag;
            view2 = view;
        }
        k01 k01Var2 = this.f2345a;
        if (k01Var2 != null) {
            AppInfo item = getItem(i);
            TextView textViewE = k01Var2.e();
            if (textViewE != null) {
                textViewE.setText(this.f2346a.a(item.getAppName(), this.f2348a));
            }
            TextView textViewD = k01Var2.d();
            if (textViewD != null) {
                textViewD.setText(this.f2346a.a(item.getPackageName(), this.f2348a));
            }
            ImageView imageViewB2 = k01Var2.b();
            f92.b(imageViewB2);
            imageViewB2.setTag(Integer.valueOf(i));
            qc2.d(xd2.a(qe2.b()), null, null, new m01(item, imageViewB2, null, this, i), 3, null);
            TextView textViewA = k01Var2.a();
            if (textViewA != null) {
                CharSequence charSequence = item.stateTags;
                if (charSequence == null || charSequence.length() == 0) {
                    textViewA.setText("");
                    textViewA.setVisibility(8);
                } else {
                    textViewA.setText(item.stateTags);
                    textViewA.setVisibility(0);
                }
            }
            CheckBox checkBoxC2 = k01Var2.c();
            if (checkBoxC2 != null) {
                checkBoxC2.setOnCheckedChangeListener(new n01(this, i));
            }
            CheckBox checkBoxC3 = k01Var2.c();
            if (checkBoxC3 != null) {
                checkBoxC3.setChecked(f92.a(this.f2350a.get(Integer.valueOf(i)), Boolean.TRUE));
            }
            if (this.b && (checkBoxC = k01Var2.c()) != null) {
                checkBoxC.setVisibility(8);
            }
        }
        f92.b(view2);
        return view2;
    }

    public final boolean h(AppInfo appInfo, String str) {
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

    public final void i(boolean z) {
        Iterator<Map.Entry<Integer, Boolean>> it = this.f2350a.entrySet().iterator();
        while (it.hasNext()) {
            this.f2350a.put(it.next().getKey(), Boolean.valueOf(z));
        }
    }

    public final ArrayList<AppInfo> j(ArrayList<AppInfo> arrayList) {
        c52.n(arrayList, o01.f6966a);
        return arrayList;
    }
}
