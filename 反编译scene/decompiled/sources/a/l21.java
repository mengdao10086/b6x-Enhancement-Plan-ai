package a;

import android.os.Handler;
import android.os.Looper;
import android.widget.BaseAdapter;
import com.omarea.Scene;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class l21 extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n50 f6668a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public u90 f1721a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Runnable f1723a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f1724a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<n50> f1725a;
    public n50 b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Runnable f1726b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1728b;
    public boolean c;
    public boolean e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f1722a = new Handler(Looper.getMainLooper());
    public boolean d = false;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f1727b = "/";

    public l21(n50 n50Var, Runnable runnable, u90 u90Var, String str, boolean z, boolean z2, Runnable runnable2, boolean z3) {
        this.f1728b = true;
        this.c = false;
        this.e = true;
        this.e = z3;
        this.f1728b = z;
        this.c = z2;
        this.f1726b = runnable2;
        h(n50Var, runnable, u90Var, str);
    }

    public n50 f() {
        return this.b;
    }

    public boolean g() {
        if (!this.d) {
            return false;
        }
        j(n50.f6876a.a(this.f6668a.e()));
        return true;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.d) {
            ArrayList<n50> arrayList = this.f1725a;
            if (arrayList == null) {
                return 1;
            }
            return arrayList.size() + 1;
        }
        ArrayList<n50> arrayList2 = this.f1725a;
        if (arrayList2 == null) {
            return 0;
        }
        return arrayList2.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.d ? i == 0 ? n50.f6876a.a(this.f6668a.e()) : this.f1725a.get(i - 1) : this.f1725a.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View getView(int r4, android.view.View r5, android.view.ViewGroup r6) {
        /*
            r3 = this;
            boolean r5 = r3.d
            r0 = 2131361824(0x7f0a0020, float:1.8343411E38)
            r1 = 2131558628(0x7f0d00e4, float:1.8742577E38)
            r2 = 0
            if (r5 == 0) goto L29
            if (r4 != 0) goto L29
            android.content.Context r4 = r6.getContext()
            android.view.View r4 = android.view.View.inflate(r4, r1, r2)
            android.view.View r5 = r4.findViewById(r0)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r6 = "..."
            r5.setText(r6)
            a.h21 r5 = new a.h21
            r5.<init>(r3)
            r4.setOnClickListener(r5)
            return r4
        L29:
            java.lang.Object r4 = r3.getItem(r4)
            a.n50 r4 = (a.n50) r4
            boolean r5 = r4.g()
            if (r5 == 0) goto L46
            android.content.Context r5 = r6.getContext()
            android.view.View r5 = android.view.View.inflate(r5, r1, r2)
            a.i21 r6 = new a.i21
            r6.<init>(r3, r4, r5)
        L42:
            r5.setOnClickListener(r6)
            goto L5b
        L46:
            android.content.Context r5 = r6.getContext()
            r6 = 2131558629(0x7f0d00e5, float:1.874258E38)
            android.view.View r5 = android.view.View.inflate(r5, r6, r2)
            boolean r6 = r3.f1728b
            if (r6 == 0) goto L5b
            a.j21 r6 = new a.j21
            r6.<init>(r3, r5, r4)
            goto L42
        L5b:
            boolean r6 = r3.c
            if (r6 == 0) goto L67
            a.k21 r6 = new a.k21
            r6.<init>(r3, r5, r4)
            r5.setOnLongClickListener(r6)
        L67:
            android.view.View r6 = r5.findViewById(r0)
            android.widget.TextView r6 = (android.widget.TextView) r6
            java.lang.String r0 = r4.d()
            r6.setText(r0)
            boolean r6 = r4.g()
            if (r6 != 0) goto L8e
            r6 = 2131361822(0x7f0a001e, float:1.8343407E38)
            android.view.View r6 = r5.findViewById(r6)
            android.widget.TextView r6 = (android.widget.TextView) r6
            long r0 = r4.f()
            java.lang.String r4 = r3.l(r0)
            r6.setText(r4)
        L8e:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: a.l21.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void h(n50 n50Var, Runnable runnable, u90 u90Var, String str) {
        this.f1727b = n50Var.b();
        this.f1723a = runnable;
        this.f1721a = u90Var;
        if (str != null) {
            if (str.startsWith(".")) {
                this.f1724a = str;
            } else {
                this.f1724a = "." + str;
            }
        }
        j(n50Var);
    }

    public /* synthetic */ void i(n50 n50Var) {
        n50 n50VarA = n50.f6876a.a(n50Var.e());
        String strB = n50VarA.b();
        int i = 0;
        this.d = n50VarA.c() && (this.e || !this.f1727b.startsWith(strB) || this.f1727b.length() <= strB.length());
        if (n50Var.c()) {
            String str = this.f1724a;
            if (str == null) {
                str = "";
            }
            ArrayList<n50> arrayListH = n50Var.h(str);
            while (i < arrayListH.size()) {
                int i2 = i + 1;
                for (int i3 = i2; i3 < arrayListH.size(); i3++) {
                    n50 n50Var2 = arrayListH.get(i3);
                    if (n50Var2.g() && !arrayListH.get(i).g()) {
                        n50 n50Var3 = arrayListH.get(i);
                        arrayListH.set(i, arrayListH.get(i3));
                        arrayListH.set(i3, n50Var3);
                    } else if (n50Var2.g() == arrayListH.get(i).g() && n50Var2.d().toLowerCase().compareTo(arrayListH.get(i).d().toLowerCase()) < 0) {
                        n50 n50Var4 = arrayListH.get(i);
                        arrayListH.set(i, n50Var2);
                        arrayListH.set(i3, n50Var4);
                    }
                }
                i = i2;
            }
            this.f1725a = arrayListH;
        }
        this.f6668a = n50Var;
        this.f1722a.post(new g21(this));
    }

    public final void j(final n50 n50Var) {
        this.f1721a.d(Scene.f4796a.getString(2131887088));
        new Thread(new Runnable() { // from class: a.tz0
            @Override // java.lang.Runnable
            public final void run() {
                this.f7548a.i(n50Var);
            }
        }).start();
    }

    public void k() {
        n50 n50Var = this.f6668a;
        if (n50Var != null) {
            j(n50Var);
        }
    }

    public final String l(long j) {
        if (j >= 1024) {
            return j < 1048576 ? String.format("%sKB", String.format("%.2f", Double.valueOf(j / 1024.0d))) : j < 1073741824 ? String.format("%sMB", String.format("%.2f", Double.valueOf(j / 1048576.0d))) : String.format("%sGB", String.format("%.2f", Double.valueOf(j / 1.073741824E9d)));
        }
        return j + "B";
    }
}
