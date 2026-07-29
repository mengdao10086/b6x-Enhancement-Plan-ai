package zn;

import gm.j2;
import gm.n2;
import java.util.Enumeration;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public class g0 extends gm.w {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f58748d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f58749e = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f58750f = 3;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c0 f58751a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Vector f58752b = new Vector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f58753c;

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public g0(gm.f0 r6) {
        /*
            r5 = this;
            r5.<init>()
            r0 = 0
            r5.f58751a = r0
            java.util.Vector r0 = new java.util.Vector
            r0.<init>()
            r5.f58752b = r0
            r0 = -1
            r5.f58753c = r0
            r0 = 0
            gm.h r1 = r6.K(r0)
            boolean r1 = r1 instanceof gm.n0
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L29
            gm.h r1 = r6.K(r0)
            gm.n0 r1 = (gm.n0) r1
            zn.c0 r0 = zn.c0.z(r1, r0)
        L25:
            r5.f58751a = r0
            r0 = 1
            goto L38
        L29:
            int r1 = r6.size()
            if (r1 != r2) goto L38
            gm.h r0 = r6.K(r0)
            zn.c0 r0 = zn.c0.A(r0)
            goto L25
        L38:
            gm.h r1 = r6.K(r0)
            boolean r1 = r1 instanceof gm.f0
            if (r1 == 0) goto L88
            gm.h r6 = r6.K(r0)
            gm.f0 r6 = (gm.f0) r6
            java.util.Enumeration r6 = r6.L()
        L4a:
            boolean r0 = r6.hasMoreElements()
            if (r0 == 0) goto L87
            java.lang.Object r0 = r6.nextElement()
            gm.c0 r0 = (gm.c0) r0
            boolean r1 = r0 instanceof gm.y
            if (r1 == 0) goto L5c
            r1 = 2
            goto L67
        L5c:
            boolean r1 = r0 instanceof gm.r0
            if (r1 == 0) goto L62
            r1 = 3
            goto L67
        L62:
            boolean r1 = r0 instanceof gm.f2
            if (r1 == 0) goto L7f
            r1 = 1
        L67:
            int r4 = r5.f58753c
            if (r4 >= 0) goto L6d
            r5.f58753c = r1
        L6d:
            int r4 = r5.f58753c
            if (r1 != r4) goto L77
            java.util.Vector r1 = r5.f58752b
            r1.addElement(r0)
            goto L4a
        L77:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Mix of value types in IetfAttrSyntax"
            r6.<init>(r0)
            throw r6
        L7f:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Bad value type encoding IetfAttrSyntax"
            r6.<init>(r0)
            throw r6
        L87:
            return
        L88:
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Non-IetfAttrSyntax encoding"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: zn.g0.<init>(gm.f0):void");
    }

    public static g0 x(Object obj) {
        if (obj instanceof g0) {
            return (g0) obj;
        }
        if (obj != null) {
            return new g0(gm.f0.J(obj));
        }
        return null;
    }

    public Object[] A() {
        int i10 = 0;
        if (z() == 1) {
            int size = this.f58752b.size();
            gm.z[] zVarArr = new gm.z[size];
            while (i10 != size) {
                zVarArr[i10] = (gm.z) this.f58752b.elementAt(i10);
                i10++;
            }
            return zVarArr;
        }
        if (z() == 2) {
            int size2 = this.f58752b.size();
            gm.y[] yVarArr = new gm.y[size2];
            while (i10 != size2) {
                yVarArr[i10] = (gm.y) this.f58752b.elementAt(i10);
                i10++;
            }
            return yVarArr;
        }
        int size3 = this.f58752b.size();
        gm.r0[] r0VarArr = new gm.r0[size3];
        while (i10 != size3) {
            r0VarArr[i10] = (gm.r0) this.f58752b.elementAt(i10);
            i10++;
        }
        return r0VarArr;
    }

    @Override // gm.w, gm.h
    public gm.c0 b() {
        gm.i iVar = new gm.i(2);
        c0 c0Var = this.f58751a;
        if (c0Var != null) {
            iVar.a(new n2(0, c0Var));
        }
        gm.i iVar2 = new gm.i(this.f58752b.size());
        Enumeration enumerationElements = this.f58752b.elements();
        while (enumerationElements.hasMoreElements()) {
            iVar2.a((gm.h) enumerationElements.nextElement());
        }
        iVar.a(new j2(iVar2));
        return new j2(iVar);
    }

    public c0 y() {
        return this.f58751a;
    }

    public int z() {
        return this.f58753c;
    }
}
