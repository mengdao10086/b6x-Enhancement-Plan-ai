package a;

import a.go;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class tp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final sp f7520a;

    public tp(sp spVar) {
        this.f7520a = spVar;
    }

    public final int a(List<go.b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f6226a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    public void b(List<go.b> list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    public final void c(List<go.b> list, int i, go.b bVar, int i2, go.b bVar2) {
        int i3 = bVar.c < bVar2.b ? -1 : 0;
        if (bVar.b < bVar2.b) {
            i3++;
        }
        int i4 = bVar2.b;
        int i5 = bVar.b;
        if (i4 <= i5) {
            bVar.b = i5 + bVar2.c;
        }
        int i6 = bVar2.b;
        int i7 = bVar.c;
        if (i6 <= i7) {
            bVar.c = i7 + bVar2.c;
        }
        bVar2.b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    public final void d(List<go.b> list, int i, int i2) {
        go.b bVar = list.get(i);
        go.b bVar2 = list.get(i2);
        int i3 = bVar2.f6226a;
        if (i3 == 1) {
            c(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            e(list, i, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            f(list, i, bVar, i2, bVar2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00cb A[PHI: r0
  0x00cb: PHI (r0v12 int) = (r0v6 int), (r0v16 int) binds: [B:58:0x00c9, B:45:0x009f] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(java.util.List<a.go.b> r10, int r11, a.go.b r12, int r13, a.go.b r14) {
        /*
            Method dump skipped, instruction units count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.tp.e(java.util.List, int, a.go$b, int, a.go$b):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(java.util.List<a.go.b> r9, int r10, a.go.b r11, int r12, a.go.b r13) {
        /*
            r8 = this;
            int r0 = r11.c
            int r1 = r13.b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto Ld
            int r1 = r1 - r4
            r13.b = r1
            goto L20
        Ld:
            int r5 = r13.c
            int r1 = r1 + r5
            if (r0 >= r1) goto L20
            int r5 = r5 - r4
            r13.c = r5
            a.sp r0 = r8.f7520a
            int r1 = r11.b
            java.lang.Object r5 = r13.f1047a
            a.go$b r0 = r0.a(r2, r1, r4, r5)
            goto L21
        L20:
            r0 = r3
        L21:
            int r1 = r11.b
            int r5 = r13.b
            if (r1 > r5) goto L2b
            int r5 = r5 + r4
            r13.b = r5
            goto L41
        L2b:
            int r6 = r13.c
            int r7 = r5 + r6
            if (r1 >= r7) goto L41
            int r5 = r5 + r6
            int r5 = r5 - r1
            a.sp r3 = r8.f7520a
            int r1 = r1 + r4
            java.lang.Object r4 = r13.f1047a
            a.go$b r3 = r3.a(r2, r1, r5, r4)
            int r1 = r13.c
            int r1 = r1 - r5
            r13.c = r1
        L41:
            r9.set(r12, r11)
            int r11 = r13.c
            if (r11 <= 0) goto L4c
            r9.set(r10, r13)
            goto L54
        L4c:
            r9.remove(r10)
            a.sp r11 = r8.f7520a
            r11.b(r13)
        L54:
            if (r0 == 0) goto L59
            r9.add(r10, r0)
        L59:
            if (r3 == 0) goto L5e
            r9.add(r10, r3)
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.tp.f(java.util.List, int, a.go$b, int, a.go$b):void");
    }
}
