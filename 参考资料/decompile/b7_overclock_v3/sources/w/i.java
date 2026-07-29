package w;

import androidx.constraintlayout.core.motion.CustomAttribute;
import java.io.PrintStream;
import java.util.Arrays;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    public static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f53498d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f53499a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public CustomAttribute[] f53500b = new CustomAttribute[101];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f53501c;

        public a() {
            b();
        }

        public void a(int i10, CustomAttribute customAttribute) {
            if (this.f53500b[i10] != null) {
                e(i10);
            }
            this.f53500b[i10] = customAttribute;
            int[] iArr = this.f53499a;
            int i11 = this.f53501c;
            this.f53501c = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f53499a, 999);
            Arrays.fill(this.f53500b, (Object) null);
            this.f53501c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f53499a, this.f53501c)));
            System.out.print("K: [");
            int i10 = 0;
            while (i10 < this.f53501c) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(g(i10));
                printStream.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int d(int i10) {
            return this.f53499a[i10];
        }

        public void e(int i10) {
            this.f53500b[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.f53501c;
                if (i11 >= i13) {
                    this.f53501c = i13 - 1;
                    return;
                }
                int[] iArr = this.f53499a;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int f() {
            return this.f53501c;
        }

        public CustomAttribute g(int i10) {
            return this.f53500b[this.f53499a[i10]];
        }
    }

    public static class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f53502d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f53503a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public t.a[] f53504b = new t.a[101];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f53505c;

        public b() {
            b();
        }

        public void a(int i10, t.a aVar) {
            if (this.f53504b[i10] != null) {
                e(i10);
            }
            this.f53504b[i10] = aVar;
            int[] iArr = this.f53503a;
            int i11 = this.f53505c;
            this.f53505c = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f53503a, 999);
            Arrays.fill(this.f53504b, (Object) null);
            this.f53505c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f53503a, this.f53505c)));
            System.out.print("K: [");
            int i10 = 0;
            while (i10 < this.f53505c) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(g(i10));
                printStream.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int d(int i10) {
            return this.f53503a[i10];
        }

        public void e(int i10) {
            this.f53504b[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.f53505c;
                if (i11 >= i13) {
                    this.f53505c = i13 - 1;
                    return;
                }
                int[] iArr = this.f53503a;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int f() {
            return this.f53505c;
        }

        public t.a g(int i10) {
            return this.f53504b[this.f53503a[i10]];
        }
    }

    public static class c {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final int f53506d = 999;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int[] f53507a = new int[101];

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float[][] f53508b = new float[101][];

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f53509c;

        public c() {
            b();
        }

        public void a(int i10, float[] fArr) {
            if (this.f53508b[i10] != null) {
                e(i10);
            }
            this.f53508b[i10] = fArr;
            int[] iArr = this.f53507a;
            int i11 = this.f53509c;
            this.f53509c = i11 + 1;
            iArr[i11] = i10;
            Arrays.sort(iArr);
        }

        public void b() {
            Arrays.fill(this.f53507a, 999);
            Arrays.fill(this.f53508b, (Object) null);
            this.f53509c = 0;
        }

        public void c() {
            System.out.println("V: " + Arrays.toString(Arrays.copyOf(this.f53507a, this.f53509c)));
            System.out.print("K: [");
            int i10 = 0;
            while (i10 < this.f53509c) {
                PrintStream printStream = System.out;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(i10 == 0 ? "" : ", ");
                sb2.append(Arrays.toString(g(i10)));
                printStream.print(sb2.toString());
                i10++;
            }
            System.out.println("]");
        }

        public int d(int i10) {
            return this.f53507a[i10];
        }

        public void e(int i10) {
            this.f53508b[i10] = null;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                int i13 = this.f53509c;
                if (i11 >= i13) {
                    this.f53509c = i13 - 1;
                    return;
                }
                int[] iArr = this.f53507a;
                if (i10 == iArr[i11]) {
                    iArr[i11] = 999;
                    i12++;
                }
                if (i11 != i12) {
                    iArr[i11] = iArr[i12];
                }
                i12++;
                i11++;
            }
        }

        public int f() {
            return this.f53509c;
        }

        public float[] g(int i10) {
            return this.f53508b[this.f53507a[i10]];
        }
    }
}
