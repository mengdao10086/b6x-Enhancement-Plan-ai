package a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.omarea.model.ProcessInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class f21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f6067a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ih0 f839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nb2 f840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f842a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f844a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f845a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ProcessInfo> f846a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f847b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<ProcessInfo> f848b;

    public f21(Context context, ArrayList<ProcessInfo> arrayList, String str, int i, int i2) {
        f92.d(context, "context");
        f92.d(arrayList, "processes");
        f92.d(str, "keywords");
        this.f841a = context;
        this.f848b = arrayList;
        this.f845a = str;
        this.f6067a = i;
        this.b = i2;
        this.f839a = new ih0(context, 100, 48);
        this.f844a = yb.d(this.f841a, 2131231120);
        this.f847b = yb.d(this.f841a, 2131231121);
        this.f843a = this.f841a.getPackageManager();
        this.f842a = this.f841a.getSharedPreferences("ProcessNameCache", 0);
        j();
        qc2.d(xd2.a(qe2.b()), null, null, new b21(this, null), 3, null);
        new nb2("u[0-9]+_.*");
        this.f840a = new nb2(".*\\..*");
    }

    public /* synthetic */ f21(Context context, ArrayList arrayList, String str, int i, int i2, int i3, b92 b92Var) {
        this(context, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 4 : i, (i3 & 16) != 0 ? 32 : i2);
    }

    public final ArrayList<ProcessInfo> b() {
        ArrayList<ProcessInfo> arrayList = this.f848b;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            ProcessInfo processInfo = (ProcessInfo) obj;
            int i = this.b;
            boolean zE = true;
            if (i != 1 && i == 32) {
                zE = e(processInfo);
            }
            if (zE) {
                arrayList2.add(obj);
            }
        }
        return new ArrayList<>(arrayList2);
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ProcessInfo getItem(int i) {
        ArrayList<ProcessInfo> arrayList = this.f846a;
        if (arrayList == null) {
            f92.m("list");
            throw null;
        }
        ProcessInfo processInfo = arrayList.get(i);
        f92.c(processInfo, "list[position]");
        return processInfo;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final /* synthetic */ java.lang.Object d(a.b62<? super a.m42> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof a.c21
            if (r0 == 0) goto L13
            r0 = r10
            a.c21 r0 = (a.c21) r0
            int r1 = r0.f5753a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5753a = r1
            goto L18
        L13:
            a.c21 r0 = new a.c21
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f323a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f5753a
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r1 = r0.d
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r1 = r0.c
            android.content.SharedPreferences$Editor r1 = (android.content.SharedPreferences.Editor) r1
            int r1 = r0.b
            java.lang.Object r0 = r0.f324b
            a.f21 r0 = (a.f21) r0
            a.h42.b(r10)
            goto Lb0
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L40:
            a.h42.b(r10)
            android.content.SharedPreferences r10 = r9.f842a
            java.lang.String r2 = "nameCache"
            a.f92.c(r10, r2)
            java.util.Map r10 = r10.getAll()
            int r10 = r10.size()
            android.content.SharedPreferences r4 = r9.f842a
            android.content.SharedPreferences$Editor r4 = r4.edit()
            r4.clear()
            a.kh0 r5 = new a.kh0
            android.content.Context r6 = r9.f841a
            r7 = 0
            r5.<init>(r6, r7)
            java.util.ArrayList r5 = r5.c()
            java.util.Iterator r6 = r5.iterator()
        L6b:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L83
            java.lang.Object r7 = r6.next()
            com.omarea.model.AppInfo r7 = (com.omarea.model.AppInfo) r7
            java.lang.String r8 = r7.getPackageName()
            java.lang.String r7 = r7.getAppName()
            r4.putString(r8, r7)
            goto L6b
        L83:
            r4.apply()
            android.content.SharedPreferences r6 = r9.f842a
            a.f92.c(r6, r2)
            java.util.Map r2 = r6.getAll()
            int r2 = r2.size()
            if (r2 == r10) goto Lb0
            a.fg2 r2 = a.qe2.c()
            a.d21 r6 = new a.d21
            r7 = 0
            r6.<init>(r9, r7)
            r0.f324b = r9
            r0.b = r10
            r0.c = r4
            r0.d = r5
            r0.f5753a = r3
            java.lang.Object r10 = a.oc2.g(r2, r6, r0)
            if (r10 != r1) goto Lb0
            return r1
        Lb0:
            a.m42 r10 = a.m42.f6769a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.f21.d(a.b62):java.lang.Object");
    }

    public final boolean e(ProcessInfo processInfo) {
        String str = processInfo.name;
        if (str != null) {
            if ((str.length() > 0) && this.f842a.contains(l(processInfo))) {
                return true;
            }
        }
        String str2 = processInfo.command;
        f92.c(str2, "processInfo.command");
        if (ec2.C(str2, "app_process", false, 2, null)) {
            String str3 = processInfo.name;
            f92.c(str3, "processInfo.name");
            if (this.f840a.f(str3)) {
                return true;
            }
        }
        return false;
    }

    public final SpannableString f(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f845a.length() == 0) {
            return spannableString;
        }
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        String str2 = this.f845a;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase();
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f845a.length() + iN, 33);
        return spannableString;
    }

    public final void g(ImageView imageView, ProcessInfo processInfo) {
        Drawable drawableK;
        if (e(processInfo)) {
            try {
                ih0 ih0Var = this.f839a;
                String str = processInfo.name;
                f92.c(str, "item.name");
                drawableK = ih0Var.k((String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null)));
            } catch (Exception unused) {
                drawableK = null;
            }
            if (drawableK == null) {
                drawableK = this.f844a;
            }
        } else {
            drawableK = this.f847b;
        }
        imageView.setImageDrawable(drawableK);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ProcessInfo> arrayList = this.f846a;
        if (arrayList != null) {
            return arrayList.size();
        }
        f92.m("list");
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        f92.d(viewGroup, "parent");
        if (view == null) {
            view = View.inflate(this.f841a, 2131558634, null);
        }
        f92.b(view);
        n(i, view);
        return view;
    }

    public final void h() {
        String string;
        String strSubstring;
        Iterator<ProcessInfo> it = this.f848b.iterator();
        while (it.hasNext()) {
            ProcessInfo next = it.next();
            f92.c(next, "item");
            if (!e(next)) {
                string = next.name;
            } else if (this.f842a.contains(next.name)) {
                SharedPreferences sharedPreferences = this.f842a;
                String str = next.name;
                string = sharedPreferences.getString(str, str);
            } else {
                String str2 = next.name;
                f92.c(str2, "item.name");
                if (ec2.C(str2, ":", false, 2, null)) {
                    String str3 = next.name;
                    f92.c(str3, "item.name");
                    String str4 = next.name;
                    f92.c(str4, "item.name");
                    int iN = ec2.N(str4, ":", 0, false, 6, null);
                    if (str3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    strSubstring = str3.substring(0, iN);
                    f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                } else {
                    strSubstring = next.name;
                }
                try {
                    try {
                        ApplicationInfo applicationInfo = this.f843a.getApplicationInfo(strSubstring, 0);
                        f92.c(applicationInfo, "pm.getApplicationInfo(name, 0)");
                        next.friendlyName = "" + applicationInfo.loadLabel(this.f843a);
                    } catch (Exception unused) {
                        next.friendlyName = strSubstring;
                    }
                } finally {
                    this.f842a.edit().putString(next.name, next.friendlyName).apply();
                }
            }
            next.friendlyName = string;
        }
    }

    public final void i(int i) {
        ArrayList<ProcessInfo> arrayList = this.f846a;
        if (arrayList == null) {
            f92.m("list");
            throw null;
        }
        arrayList.remove(i);
        notifyDataSetChanged();
    }

    public final void j() {
        String strSubstring;
        ArrayList<ProcessInfo> arrayListB = b();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : arrayListB) {
            ProcessInfo processInfo = (ProcessInfo) obj;
            String str = processInfo.name;
            f92.c(str, "it.name");
            if (ec2.C(str, ":", false, 2, null) && e(processInfo)) {
                String str2 = processInfo.name;
                f92.c(str2, "it.name");
                String str3 = processInfo.name;
                f92.c(str3, "it.name");
                int iN = ec2.N(str3, ":", 0, false, 6, null);
                if (str2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                strSubstring = str2.substring(0, iN);
                f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            } else {
                strSubstring = processInfo.name;
            }
            Object arrayList = linkedHashMap.get(strSubstring);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(strSubstring, arrayList);
            }
            ((List) arrayList).add(obj);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.size());
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            ProcessInfo processInfo2 = (ProcessInfo) i52.A((List) entry.getValue());
            float f = 0.0f;
            Iterator it = ((Iterable) entry.getValue()).iterator();
            while (it.hasNext()) {
                f += ((ProcessInfo) it.next()).cpu;
            }
            processInfo2.cpu = f;
            arrayList2.add(processInfo2);
        }
        List listS = i52.S(arrayList2, new e21(this));
        if (listS.size() > 30) {
            listS = listS.subList(0, 30);
        }
        this.f846a = new ArrayList<>(listS);
        notifyDataSetChanged();
    }

    public final void k(ArrayList<ProcessInfo> arrayList) {
        f92.d(arrayList, "processes");
        this.f848b = arrayList;
        j();
        h();
    }

    public final String l(ProcessInfo processInfo) {
        String str = processInfo.name;
        if (str == null) {
            return "";
        }
        f92.c(str, "processInfo.name");
        if (!ec2.C(str, ":", false, 2, null)) {
            String str2 = processInfo.name;
            f92.c(str2, "processInfo.name");
            return str2;
        }
        String str3 = processInfo.name;
        f92.c(str3, "processInfo.name");
        String str4 = processInfo.name;
        f92.c(str4, "processInfo.name");
        int iN = ec2.N(str4, ":", 0, false, 6, null);
        if (str3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str3.substring(0, iN);
        f92.c(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final void m(int i) {
        this.b = i;
        j();
    }

    public final void n(int i, View view) {
        ProcessInfo item = getItem(i);
        View viewFindViewById = view.findViewById(t61.ProcessFriendlyName);
        f92.c(viewFindViewById, "findViewById<TextView>(R.id.ProcessFriendlyName)");
        String str = item.friendlyName;
        f92.c(str, "processInfo.friendlyName");
        ((TextView) viewFindViewById).setText(f(str));
        View viewFindViewById2 = view.findViewById(t61.ProcessCPU);
        f92.c(viewFindViewById2, "findViewById<TextView>(R.id.ProcessCPU)");
        q92 q92Var = q92.f7191a;
        String str2 = String.format("%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(item.cpu)}, 1));
        f92.c(str2, "java.lang.String.format(format, *args)");
        ((TextView) viewFindViewById2).setText(str2);
        View viewFindViewById3 = view.findViewById(t61.ProcessIcon);
        f92.c(viewFindViewById3, "findViewById(R.id.ProcessIcon)");
        g((ImageView) viewFindViewById3, item);
    }
}
