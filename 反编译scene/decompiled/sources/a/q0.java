package a;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class q0 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public p0 f2490a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f2491a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DialogInterface.OnCancelListener f2492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DialogInterface.OnClickListener f2493a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DialogInterface.OnDismissListener f2494a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DialogInterface.OnKeyListener f2495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DialogInterface.OnMultiChoiceClickListener f2496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Cursor f2497a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f2498a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LayoutInflater f2499a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public View f2500a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AdapterView.OnItemSelectedListener f2501a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListAdapter f2502a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence f2503a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f2504a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public CharSequence[] f2506a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean[] f2507a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public DialogInterface.OnClickListener f2508b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Drawable f2509b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public View f2510b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public CharSequence f2511b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public String f2512b;
    public int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public DialogInterface.OnClickListener f2514c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Drawable f2515c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public CharSequence f2516c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2517c;
    public int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public DialogInterface.OnClickListener f2518d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public Drawable f2519d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public CharSequence f2520d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2521d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public CharSequence f2522e;
    public int f;
    public int g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7164a = 0;
    public int b = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f2513b = false;
    public int h = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2505a = true;

    public q0(Context context) {
        this.f2491a = context;
        this.f2499a = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void a(AlertController alertController) {
        View view = this.f2500a;
        if (view != null) {
            alertController.l(view);
        } else {
            CharSequence charSequence = this.f2503a;
            if (charSequence != null) {
                alertController.q(charSequence);
            }
            Drawable drawable = this.f2498a;
            if (drawable != null) {
                alertController.n(drawable);
            }
            int i = this.f7164a;
            if (i != 0) {
                alertController.m(i);
            }
            int i2 = this.b;
            if (i2 != 0) {
                alertController.m(alertController.c(i2));
            }
        }
        CharSequence charSequence2 = this.f2511b;
        if (charSequence2 != null) {
            alertController.o(charSequence2);
        }
        if (this.f2516c != null || this.f2509b != null) {
            alertController.k(-1, this.f2516c, this.f2493a, null, this.f2509b);
        }
        if (this.f2520d != null || this.f2515c != null) {
            alertController.k(-2, this.f2520d, this.f2508b, null, this.f2515c);
        }
        if (this.f2522e != null || this.f2519d != null) {
            alertController.k(-3, this.f2522e, this.f2514c, null, this.f2519d);
        }
        if (this.f2506a != null || this.f2497a != null || this.f2502a != null) {
            b(alertController);
        }
        View view2 = this.f2510b;
        if (view2 != null) {
            if (this.f2513b) {
                alertController.t(view2, this.d, this.e, this.f, this.g);
                return;
            } else {
                alertController.s(view2);
                return;
            }
        }
        int i3 = this.c;
        if (i3 != 0) {
            alertController.r(i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.appcompat.app.AlertController r11) {
        /*
            r10 = this;
            android.view.LayoutInflater r0 = r10.f2499a
            int r1 = r11.k
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            androidx.appcompat.app.AlertController$RecycleListView r0 = (androidx.appcompat.app.AlertController.RecycleListView) r0
            boolean r1 = r10.f2517c
            r8 = 1
            if (r1 == 0) goto L35
            android.database.Cursor r1 = r10.f2497a
            if (r1 != 0) goto L26
            a.l0 r9 = new a.l0
            android.content.Context r3 = r10.f2491a
            int r4 = r11.l
            r5 = 16908308(0x1020014, float:2.3877285E-38)
            java.lang.CharSequence[] r6 = r10.f2506a
            r1 = r9
            r2 = r10
            r7 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L6b
        L26:
            a.m0 r9 = new a.m0
            android.content.Context r3 = r10.f2491a
            android.database.Cursor r4 = r10.f2497a
            r5 = 0
            r1 = r9
            r2 = r10
            r6 = r0
            r7 = r11
            r1.<init>(r2, r3, r4, r5, r6, r7)
            goto L6b
        L35:
            boolean r1 = r10.f2521d
            if (r1 == 0) goto L3c
            int r1 = r11.m
            goto L3e
        L3c:
            int r1 = r11.n
        L3e:
            r4 = r1
            android.database.Cursor r1 = r10.f2497a
            r2 = 16908308(0x1020014, float:2.3877285E-38)
            if (r1 == 0) goto L5d
            android.widget.SimpleCursorAdapter r9 = new android.widget.SimpleCursorAdapter
            android.content.Context r3 = r10.f2491a
            android.database.Cursor r5 = r10.f2497a
            java.lang.String[] r6 = new java.lang.String[r8]
            java.lang.String r1 = r10.f2504a
            r7 = 0
            r6[r7] = r1
            int[] r1 = new int[r8]
            r1[r7] = r2
            r2 = r9
            r7 = r1
            r2.<init>(r3, r4, r5, r6, r7)
            goto L6b
        L5d:
            android.widget.ListAdapter r9 = r10.f2502a
            if (r9 == 0) goto L62
            goto L6b
        L62:
            a.s0 r9 = new a.s0
            android.content.Context r1 = r10.f2491a
            java.lang.CharSequence[] r3 = r10.f2506a
            r9.<init>(r1, r4, r2, r3)
        L6b:
            a.p0 r1 = r10.f2490a
            if (r1 == 0) goto L72
            r1.a(r0)
        L72:
            r11.f3969a = r9
            int r1 = r10.h
            r11.h = r1
            android.content.DialogInterface$OnClickListener r1 = r10.f2518d
            if (r1 == 0) goto L85
            a.n0 r1 = new a.n0
            r1.<init>(r10, r11)
        L81:
            r0.setOnItemClickListener(r1)
            goto L8f
        L85:
            android.content.DialogInterface$OnMultiChoiceClickListener r1 = r10.f2496a
            if (r1 == 0) goto L8f
            a.o0 r1 = new a.o0
            r1.<init>(r10, r0, r11)
            goto L81
        L8f:
            android.widget.AdapterView$OnItemSelectedListener r1 = r10.f2501a
            if (r1 == 0) goto L96
            r0.setOnItemSelectedListener(r1)
        L96:
            boolean r1 = r10.f2521d
            if (r1 == 0) goto L9e
            r0.setChoiceMode(r8)
            goto La6
        L9e:
            boolean r1 = r10.f2517c
            if (r1 == 0) goto La6
            r1 = 2
            r0.setChoiceMode(r1)
        La6:
            r11.f3970a = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.q0.b(androidx.appcompat.app.AlertController):void");
    }
}
