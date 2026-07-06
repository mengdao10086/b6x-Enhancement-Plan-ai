package androidx.lifecycle;

import a.fn;
import a.hn;
import a.in;
import a.kn;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class FullLifecycleObserverAdapter implements in {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fn f8203a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final in f4279a;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f8204a;

        static {
            int[] iArr = new int[hn.a.values().length];
            f8204a = iArr;
            try {
                iArr[hn.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f8204a[hn.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f8204a[hn.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f8204a[hn.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f8204a[hn.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f8204a[hn.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f8204a[hn.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // a.in
    public void a(kn knVar, hn.a aVar) {
        switch (a.f8204a[aVar.ordinal()]) {
            case 1:
                this.f8203a.d(knVar);
                break;
            case 2:
                this.f8203a.f(knVar);
                break;
            case 3:
                this.f8203a.c(knVar);
                break;
            case 4:
                this.f8203a.b(knVar);
                break;
            case 5:
                this.f8203a.e(knVar);
                break;
            case 6:
                this.f8203a.g(knVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        in inVar = this.f4279a;
        if (inVar != null) {
            inVar.a(knVar, aVar);
        }
    }
}
