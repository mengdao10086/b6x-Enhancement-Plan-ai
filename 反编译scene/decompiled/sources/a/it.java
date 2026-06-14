package a;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class it extends as {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f6440a = {"android:visibility:visibility", "android:visibility:parent"};
    public int b = 3;

    @Override // a.as
    public String[] D() {
        return f6440a;
    }

    @Override // a.as
    public boolean F(ks ksVar, ks ksVar2) {
        if (ksVar == null && ksVar2 == null) {
            return false;
        }
        if (ksVar != null && ksVar2 != null && ksVar2.f1686a.containsKey("android:visibility:visibility") != ksVar.f1686a.containsKey("android:visibility:visibility")) {
            return false;
        }
        ht htVarD0 = d0(ksVar, ksVar2);
        if (htVarD0.f1206a) {
            return htVarD0.f6340a == 0 || htVarD0.b == 0;
        }
        return false;
    }

    public final void c0(ks ksVar) {
        ksVar.f1686a.put("android:visibility:visibility", Integer.valueOf(ksVar.f6635a.getVisibility()));
        ksVar.f1686a.put("android:visibility:parent", ksVar.f6635a.getParent());
        int[] iArr = new int[2];
        ksVar.f6635a.getLocationOnScreen(iArr);
        ksVar.f1686a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0079, code lost:
    
        if (r9 == 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
    
        if (r0.f1205a == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0095, code lost:
    
        if (r0.f6340a == 0) goto L41;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final a.ht d0(a.ks r8, a.ks r9) {
        /*
            r7 = this;
            a.ht r0 = new a.ht
            r0.<init>()
            r1 = 0
            r0.f1206a = r1
            r0.f1208b = r1
            java.lang.String r2 = "android:visibility:parent"
            r3 = 0
            r4 = -1
            java.lang.String r5 = "android:visibility:visibility"
            if (r8 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1686a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L33
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1686a
            java.lang.Object r6 = r6.get(r5)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            r0.f6340a = r6
            java.util.Map<java.lang.String, java.lang.Object> r6 = r8.f1686a
            java.lang.Object r6 = r6.get(r2)
            android.view.ViewGroup r6 = (android.view.ViewGroup) r6
            r0.f1205a = r6
            goto L37
        L33:
            r0.f6340a = r4
            r0.f1205a = r3
        L37:
            if (r9 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r6 = r9.f1686a
            boolean r6 = r6.containsKey(r5)
            if (r6 == 0) goto L5a
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f1686a
            java.lang.Object r3 = r3.get(r5)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r0.b = r3
            java.util.Map<java.lang.String, java.lang.Object> r3 = r9.f1686a
            java.lang.Object r2 = r3.get(r2)
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            r0.f1207b = r2
            goto L5e
        L5a:
            r0.b = r4
            r0.f1207b = r3
        L5e:
            r2 = 1
            if (r8 == 0) goto L86
            if (r9 == 0) goto L86
            int r8 = r0.f6340a
            int r9 = r0.b
            if (r8 != r9) goto L70
            android.view.ViewGroup r8 = r0.f1205a
            android.view.ViewGroup r9 = r0.f1207b
            if (r8 != r9) goto L70
            return r0
        L70:
            int r8 = r0.f6340a
            int r9 = r0.b
            if (r8 == r9) goto L7c
            if (r8 != 0) goto L79
            goto L97
        L79:
            if (r9 != 0) goto L9a
            goto L8c
        L7c:
            android.view.ViewGroup r8 = r0.f1207b
            if (r8 != 0) goto L81
            goto L97
        L81:
            android.view.ViewGroup r8 = r0.f1205a
            if (r8 != 0) goto L9a
            goto L8c
        L86:
            if (r8 != 0) goto L91
            int r8 = r0.b
            if (r8 != 0) goto L91
        L8c:
            r0.f1208b = r2
        L8e:
            r0.f1206a = r2
            goto L9a
        L91:
            if (r9 != 0) goto L9a
            int r8 = r0.f6340a
            if (r8 != 0) goto L9a
        L97:
            r0.f1208b = r1
            goto L8e
        L9a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: a.it.d0(a.ks, a.ks):a.ht");
    }

    public abstract Animator e0(ViewGroup viewGroup, View view, ks ksVar, ks ksVar2);

    public Animator f0(ViewGroup viewGroup, ks ksVar, int i, ks ksVar2, int i2) {
        if ((this.b & 1) != 1 || ksVar2 == null) {
            return null;
        }
        if (ksVar == null) {
            View view = (View) ksVar2.f6635a.getParent();
            if (d0(t(view, false), E(view, false)).f1206a) {
                return null;
            }
        }
        return e0(viewGroup, ksVar2.f6635a, ksVar, ksVar2);
    }

    @Override // a.as
    public void g(ks ksVar) {
        c0(ksVar);
    }

    public abstract Animator g0(ViewGroup viewGroup, View view, ks ksVar, ks ksVar2);

    /* JADX WARN: Removed duplicated region for block: B:25:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0085 A[PHI: r2
  0x0085: PHI (r2v3 android.view.View) = 
  (r2v2 android.view.View)
  (r2v2 android.view.View)
  (r2v2 android.view.View)
  (r2v2 android.view.View)
  (r2v2 android.view.View)
  (r2v2 android.view.View)
  (r2v6 android.view.View)
 binds: [B:26:0x003e, B:31:0x004d, B:36:0x0072, B:38:0x0075, B:40:0x007b, B:42:0x007f, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.animation.Animator h0(android.view.ViewGroup r11, a.ks r12, int r13, a.ks r14, int r15) {
        /*
            Method dump skipped, instruction units count: 254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.it.h0(android.view.ViewGroup, a.ks, int, a.ks, int):android.animation.Animator");
    }

    public void i0(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.b = i;
    }

    @Override // a.as
    public void j(ks ksVar) {
        c0(ksVar);
    }

    @Override // a.as
    public Animator n(ViewGroup viewGroup, ks ksVar, ks ksVar2) {
        ht htVarD0 = d0(ksVar, ksVar2);
        if (!htVarD0.f1206a) {
            return null;
        }
        if (htVarD0.f1205a == null && htVarD0.f1207b == null) {
            return null;
        }
        return htVarD0.f1208b ? f0(viewGroup, ksVar, htVarD0.f6340a, ksVar2, htVarD0.b) : h0(viewGroup, ksVar, htVarD0.f6340a, ksVar2, htVarD0.b);
    }
}
