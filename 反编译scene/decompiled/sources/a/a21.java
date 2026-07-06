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
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public final class a21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5562a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ih0 f17a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final nb2 f18a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f19a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SharedPreferences f20a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PackageManager f21a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Drawable f22a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f23a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<ProcessInfo> f24a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Drawable f25b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<ProcessInfo> f26b;

    public a21(Context context, ArrayList<ProcessInfo> arrayList, String str, int i, int i2) {
        f92.d(context, "context");
        f92.d(arrayList, "processes");
        f92.d(str, "keywords");
        this.f19a = context;
        this.f26b = arrayList;
        this.f23a = str;
        this.f5562a = i;
        this.b = i2;
        this.f17a = new ih0(context, 256, 0, 4, null);
        this.f22a = yb.d(this.f19a, 2131231120);
        this.f25b = yb.d(this.f19a, 2131231121);
        this.f21a = this.f19a.getPackageManager();
        this.f20a = this.f19a.getSharedPreferences("ProcessNameCache", 0);
        j();
        qc2.d(xd2.a(qe2.b()), null, null, new w11(this, null), 3, null);
        new nb2("u[0-9]+_.*");
        this.f18a = new nb2(".*\\..*");
    }

    public /* synthetic */ a21(Context context, ArrayList arrayList, String str, int i, int i2, int i3, b92 b92Var) {
        this(context, (i3 & 2) != 0 ? new ArrayList() : arrayList, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? 4 : i, (i3 & 16) != 0 ? 32 : i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.ArrayList<com.omarea.model.ProcessInfo> b() {
        /*
            r10 = this;
            java.lang.String r0 = r10.f23a
            java.util.Locale r1 = java.util.Locale.ENGLISH
            java.lang.String r2 = "Locale.ENGLISH"
            a.f92.c(r1, r2)
            if (r0 == 0) goto L74
            java.lang.String r0 = r0.toLowerCase(r1)
            java.lang.String r1 = "(this as java.lang.String).toLowerCase(locale)"
            a.f92.c(r0, r1)
            int r1 = r0.length()
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L1e
            r1 = r3
            goto L1f
        L1e:
            r1 = r2
        L1f:
            java.util.ArrayList<com.omarea.model.ProcessInfo> r4 = r10.f26b
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Iterator r4 = r4.iterator()
        L2a:
            boolean r6 = r4.hasNext()
            if (r6 == 0) goto L65
            java.lang.Object r6 = r4.next()
            r7 = r6
            com.omarea.model.ProcessInfo r7 = (com.omarea.model.ProcessInfo) r7
            if (r1 != 0) goto L3f
            boolean r8 = r10.g(r7, r0)
            if (r8 == 0) goto L5e
        L3f:
            int r8 = r10.b
            if (r8 == r3) goto L59
            r9 = 4
            if (r8 == r9) goto L50
            r9 = 32
            if (r8 == r9) goto L4b
            goto L59
        L4b:
            boolean r7 = r10.e(r7)
            goto L5a
        L50:
            boolean r7 = r10.e(r7)
            if (r7 != 0) goto L57
            goto L59
        L57:
            r7 = r2
            goto L5a
        L59:
            r7 = r3
        L5a:
            if (r7 == 0) goto L5e
            r7 = r3
            goto L5f
        L5e:
            r7 = r2
        L5f:
            if (r7 == 0) goto L2a
            r5.add(r6)
            goto L2a
        L65:
            a.x11 r0 = new a.x11
            r0.<init>(r10)
            java.util.List r0 = a.i52.S(r5, r0)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>(r0)
            return r1
        L74:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type java.lang.String"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a21.b():java.util.ArrayList");
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ProcessInfo getItem(int i) {
        ArrayList<ProcessInfo> arrayList = this.f24a;
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
            boolean r0 = r10 instanceof a.y11
            if (r0 == 0) goto L13
            r0 = r10
            a.y11 r0 = (a.y11) r0
            int r1 = r0.f7941a
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7941a = r1
            goto L18
        L13:
            a.y11 r0 = new a.y11
            r0.<init>(r9, r10)
        L18:
            java.lang.Object r10 = r0.f3646a
            java.lang.Object r1 = a.r62.c()
            int r2 = r0.f7941a
            r3 = 1
            if (r2 == 0) goto L40
            if (r2 != r3) goto L38
            java.lang.Object r1 = r0.d
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            java.lang.Object r1 = r0.c
            android.content.SharedPreferences$Editor r1 = (android.content.SharedPreferences.Editor) r1
            int r1 = r0.b
            java.lang.Object r0 = r0.f3647b
            a.a21 r0 = (a.a21) r0
            a.h42.b(r10)
            goto Lb0
        L38:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L40:
            a.h42.b(r10)
            android.content.SharedPreferences r10 = r9.f20a
            java.lang.String r2 = "nameCache"
            a.f92.c(r10, r2)
            java.util.Map r10 = r10.getAll()
            int r10 = r10.size()
            android.content.SharedPreferences r4 = r9.f20a
            android.content.SharedPreferences$Editor r4 = r4.edit()
            r4.clear()
            a.kh0 r5 = new a.kh0
            android.content.Context r6 = r9.f19a
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
            android.content.SharedPreferences r6 = r9.f20a
            a.f92.c(r6, r2)
            java.util.Map r2 = r6.getAll()
            int r2 = r2.size()
            if (r2 == r10) goto Lb0
            a.fg2 r2 = a.qe2.c()
            a.z11 r6 = new a.z11
            r7 = 0
            r6.<init>(r9, r7)
            r0.f3647b = r9
            r0.b = r10
            r0.c = r4
            r0.d = r5
            r0.f7941a = r3
            java.lang.Object r10 = a.oc2.g(r2, r6, r0)
            if (r10 != r1) goto Lb0
            return r1
        Lb0:
            a.m42 r10 = a.m42.f6769a
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a21.d(a.b62):java.lang.Object");
    }

    public final boolean e(ProcessInfo processInfo) {
        String str = processInfo.name;
        if (str != null) {
            if ((str.length() > 0) && this.f20a.contains(l(processInfo))) {
                return true;
            }
        }
        String str2 = processInfo.command;
        f92.c(str2, "processInfo.command");
        if (ec2.C(str2, "app_process", false, 2, null)) {
            String str3 = processInfo.name;
            f92.c(str3, "processInfo.name");
            if (this.f18a.f(str3)) {
                return true;
            }
        }
        return false;
    }

    public final SpannableString f(String str) {
        SpannableString spannableString = new SpannableString(str);
        if (this.f23a.length() == 0) {
            return spannableString;
        }
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase();
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase()");
        String str2 = this.f23a;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase2 = str2.toLowerCase();
        f92.c(lowerCase2, "(this as java.lang.String).toLowerCase()");
        int iN = ec2.N(lowerCase, lowerCase2, 0, false, 6, null);
        if (iN < 0) {
            return spannableString;
        }
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#0094ff")), iN, this.f23a.length() + iN, 33);
        return spannableString;
    }

    public final boolean g(ProcessInfo processInfo, String str) {
        String str2 = processInfo.friendlyName;
        f92.c(str2, "item.friendlyName");
        Locale locale = Locale.ENGLISH;
        f92.c(locale, "Locale.ENGLISH");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str2.toLowerCase(locale);
        f92.c(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!ec2.C(lowerCase, str, false, 2, null)) {
            String str3 = processInfo.name;
            f92.c(str3, "item.name");
            Locale locale2 = Locale.ENGLISH;
            f92.c(locale2, "Locale.ENGLISH");
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = str3.toLowerCase(locale2);
            f92.c(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (!ec2.C(lowerCase2, str, false, 2, null)) {
                String str4 = processInfo.user;
                f92.c(str4, "item.user");
                Locale locale3 = Locale.ENGLISH;
                f92.c(locale3, "Locale.ENGLISH");
                if (str4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase3 = str4.toLowerCase(locale3);
                f92.c(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                if (!ec2.C(lowerCase3, str, false, 2, null)) {
                    String str5 = processInfo.command;
                    f92.c(str5, "item.command");
                    Locale locale4 = Locale.ENGLISH;
                    f92.c(locale4, "Locale.ENGLISH");
                    if (str5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase4 = str5.toLowerCase(locale4);
                    f92.c(lowerCase4, "(this as java.lang.String).toLowerCase(locale)");
                    if (!ec2.C(lowerCase4, str, false, 2, null)) {
                        String str6 = processInfo.cmdline;
                        f92.c(str6, "item.cmdline");
                        Locale locale5 = Locale.ENGLISH;
                        f92.c(locale5, "Locale.ENGLISH");
                        if (str6 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase5 = str6.toLowerCase(locale5);
                        f92.c(lowerCase5, "(this as java.lang.String).toLowerCase(locale)");
                        if (!ec2.C(lowerCase5, str, false, 2, null) && !ec2.C(String.valueOf(processInfo.pid), str, false, 2, null)) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<ProcessInfo> arrayList = this.f24a;
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
            view = View.inflate(this.f19a, 2131558633, null);
        }
        f92.b(view);
        o(i, view);
        return view;
    }

    public final void h(ImageView imageView, ProcessInfo processInfo) {
        Drawable drawableK;
        if (e(processInfo)) {
            try {
                ih0 ih0Var = this.f17a;
                String str = processInfo.name;
                f92.c(str, "item.name");
                drawableK = ih0Var.k((String) i52.A(ec2.d0(str, new String[]{":"}, false, 0, 6, null)));
            } catch (Exception unused) {
                drawableK = null;
            }
            if (drawableK == null) {
                drawableK = this.f22a;
            }
        } else {
            drawableK = this.f25b;
        }
        imageView.setImageDrawable(drawableK);
    }

    public final void i() {
        String string;
        String strSubstring;
        Iterator<ProcessInfo> it = this.f26b.iterator();
        while (it.hasNext()) {
            ProcessInfo next = it.next();
            f92.c(next, "item");
            if (!e(next)) {
                string = next.name;
            } else if (this.f20a.contains(next.name)) {
                SharedPreferences sharedPreferences = this.f20a;
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
                        ApplicationInfo applicationInfo = this.f21a.getApplicationInfo(strSubstring, 0);
                        f92.c(applicationInfo, "pm.getApplicationInfo(name, 0)");
                        next.friendlyName = "" + applicationInfo.loadLabel(this.f21a);
                    } catch (Exception unused) {
                        next.friendlyName = strSubstring;
                    }
                } finally {
                    this.f20a.edit().putString(next.name, next.friendlyName).apply();
                }
            }
            next.friendlyName = string;
        }
    }

    public final void j() {
        this.f24a = b();
        notifyDataSetChanged();
    }

    public final void k(ArrayList<ProcessInfo> arrayList) {
        f92.d(arrayList, "processes");
        this.f26b = arrayList;
        i();
        j();
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

    public final void n(String str) {
        f92.d(str, "keywords");
        this.f23a = str;
        j();
    }

    public final void o(int i, View view) {
        StringBuilder sb;
        String str;
        ProcessInfo item = getItem(i);
        if (f92.a(item.friendlyName, item.name)) {
            View viewFindViewById = view.findViewById(t61.ProcessFriendlyName);
            f92.c(viewFindViewById, "findViewById<TextView>(R.id.ProcessFriendlyName)");
            String str2 = item.friendlyName;
            f92.c(str2, "processInfo.friendlyName");
            ((TextView) viewFindViewById).setText(f(str2));
            TextView textView = (TextView) view.findViewById(t61.ProcessName);
            textView.setVisibility(8);
            textView.setText("");
        } else {
            View viewFindViewById2 = view.findViewById(t61.ProcessFriendlyName);
            f92.c(viewFindViewById2, "findViewById<TextView>(R.id.ProcessFriendlyName)");
            String str3 = item.friendlyName;
            f92.c(str3, "processInfo.friendlyName");
            ((TextView) viewFindViewById2).setText(f(str3));
            TextView textView2 = (TextView) view.findViewById(t61.ProcessName);
            textView2.setVisibility(0);
            String str4 = item.name;
            f92.c(str4, "processInfo.name");
            textView2.setText(f(str4));
        }
        View viewFindViewById3 = view.findViewById(t61.ProcessPID);
        f92.c(viewFindViewById3, "findViewById<TextView>(R.id.ProcessPID)");
        ((TextView) viewFindViewById3).setText(f(String.valueOf(item.pid)));
        View viewFindViewById4 = view.findViewById(t61.ProcessCPU);
        f92.c(viewFindViewById4, "findViewById<TextView>(R.id.ProcessCPU)");
        ((TextView) viewFindViewById4).setText("" + item.getCpu() + "%");
        View viewFindViewById5 = view.findViewById(t61.ProcessRES);
        f92.c(viewFindViewById5, "findViewById<TextView>(R.id.ProcessRES)");
        TextView textView3 = (TextView) viewFindViewById5;
        long j = item.res;
        if (j > 8192) {
            sb = new StringBuilder();
            sb.append("");
            sb.append((int) (j / ((long) 1024)));
            str = "MB";
        } else {
            sb = new StringBuilder();
            sb.append("");
            sb.append(j);
            str = "KB";
        }
        sb.append(str);
        textView3.setText(sb.toString());
        View viewFindViewById6 = view.findViewById(t61.ProcessIcon);
        f92.c(viewFindViewById6, "findViewById<ImageView>(R.id.ProcessIcon)");
        h((ImageView) viewFindViewById6, item);
    }

    public final void p(int i) {
        this.f5562a = i;
        j();
    }
}
