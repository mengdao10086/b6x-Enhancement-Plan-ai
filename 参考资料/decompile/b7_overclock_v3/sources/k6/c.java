package k6;

import android.annotation.SuppressLint;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: classes7.dex */
public class c extends k6.a {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final boolean f37004l = false;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final byte[] f37005m = {1};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final byte[] f37006n = {0};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final int f37007o = 7;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f37008p = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f37009j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f37010k;

    @Retention(RetentionPolicy.SOURCE)
    @SuppressLint({"ShiftFlags"})
    public @interface a {
        public static final int Q2 = 1;
        public static final int R2 = 2;
        public static final int S2 = 3;
    }

    public interface b {
        boolean a(byte[] bArr);

        void b(int i10);

        void c(int i10);

        void d(int i10, boolean z10);
    }

    public c(b bVar, int i10) {
        super(i10);
        this.f37009j = "EqualizerGaiaManager";
        this.f37010k = bVar;
    }

    public void E(int i10) {
        if (i10 == 1) {
            l(C(gg.b.B0));
        } else if (i10 == 2) {
            l(C(661));
        } else {
            if (i10 != 3) {
                return;
            }
            l(C(gg.b.P0));
        }
    }

    public void F() {
        l(C(660));
    }

    public final void G(int i10, hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37010k.d(i10, bArrH[1] == 1);
        }
    }

    public final void H(hg.a aVar) {
        byte[] bArrH = aVar.h();
        if (bArrH.length >= 2) {
            this.f37010k.b(bArrH[1]);
        }
    }

    public void I(int i10, boolean z10) {
        byte[] bArr = z10 ? f37005m : f37006n;
        if (i10 == 1) {
            l(D(gg.b.A0, bArr));
        } else if (i10 == 2) {
            l(D(gg.b.f29510y0, bArr));
        } else {
            if (i10 != 3) {
                return;
            }
            l(D(gg.b.O0, bArr));
        }
    }

    public void J(int i10) {
        if (i10 >= 0 && i10 < 7) {
            l(D(gg.b.f29502w0, new byte[]{(byte) i10}));
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("setPreset used with parameter not between 0 and 6, value: ");
        sb2.append(i10);
    }

    @Override // gg.c
    public void o(hg.a aVar) {
    }

    @Override // gg.c
    public boolean p(hg.a aVar) {
        return false;
    }

    @Override // gg.c
    public void r(hg.a aVar) {
    }

    @Override // gg.c
    public void t(hg.a aVar) {
        int iE = aVar.e();
        if (iE == 672) {
            G(3, aVar);
        }
        switch (iE) {
            case 660:
                H(aVar);
                break;
            case 661:
                G(2, aVar);
                break;
            case gg.b.B0 /* 662 */:
                G(1, aVar);
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1117)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    @Override // gg.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void u(hg.a r2) {
        /*
            r1 = this;
            int r2 = r2.e()
            r0 = 544(0x220, float:7.62E-43)
            if (r2 == r0) goto L21
            r0 = 672(0x2a0, float:9.42E-43)
            if (r2 == r0) goto L21
            switch(r2) {
                case 532: goto L21;
                case 533: goto L1a;
                case 534: goto L13;
                default: goto Lf;
            }
        Lf:
            switch(r2) {
                case 660: goto L21;
                case 661: goto L1a;
                case 662: goto L13;
                default: goto L12;
            }
        L12:
            goto L27
        L13:
            k6.c$b r2 = r1.f37010k
            r0 = 1
            r2.c(r0)
            goto L27
        L1a:
            k6.c$b r2 = r1.f37010k
            r0 = 2
            r2.c(r0)
            goto L27
        L21:
            k6.c$b r2 = r1.f37010k
            r0 = 3
            r2.c(r0)
        L27:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: k6.c.u(hg.a):void");
    }

    @Override // gg.c
    public boolean y(byte[] bArr) {
        return this.f37010k.a(bArr);
    }
}
