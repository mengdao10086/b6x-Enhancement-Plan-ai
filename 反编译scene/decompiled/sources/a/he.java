package a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class he {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ga<String, Typeface> f6305a = new ga<>(16);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ExecutorService f1158a = qe.a("fonts-androidx", 10, 10000);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f1157a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final ia<String, ArrayList<hf<ge>>> f1156a = new ia<>();

    public static String a(be beVar, int i) {
        return beVar.d() + "-" + i;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(ie ieVar) {
        int i = 1;
        if (ieVar.c() != 0) {
            return ieVar.c() != 1 ? -3 : -2;
        }
        je[] jeVarArrB = ieVar.b();
        if (jeVarArrB != null && jeVarArrB.length != 0) {
            i = 0;
            for (je jeVar : jeVarArrB) {
                int iB = jeVar.b();
                if (iB != 0) {
                    if (iB < 0) {
                        return -3;
                    }
                    return iB;
                }
            }
        }
        return i;
    }

    public static ge c(String str, Context context, be beVar, int i) {
        Typeface typefaceC = f6305a.c(str);
        if (typefaceC != null) {
            return new ge(typefaceC);
        }
        try {
            ie ieVarD = ae.d(context, beVar, null);
            int iB = b(ieVarD);
            if (iB != 0) {
                return new ge(iB);
            }
            Typeface typefaceB = zc.b(context, null, ieVarD.b(), i);
            if (typefaceB == null) {
                return new ge(-3);
            }
            f6305a.d(str, typefaceB);
            return new ge(typefaceB);
        } catch (PackageManager.NameNotFoundException unused) {
            return new ge(-1);
        }
    }

    public static Typeface d(Context context, be beVar, int i, Executor executor, xd xdVar) {
        String strA = a(beVar, i);
        Typeface typefaceC = f6305a.c(strA);
        if (typefaceC != null) {
            xdVar.b(new ge(typefaceC));
            return typefaceC;
        }
        de deVar = new de(xdVar);
        synchronized (f1157a) {
            ArrayList<hf<ge>> arrayList = f1156a.get(strA);
            if (arrayList != null) {
                arrayList.add(deVar);
                return null;
            }
            ArrayList<hf<ge>> arrayList2 = new ArrayList<>();
            arrayList2.add(deVar);
            f1156a.put(strA, arrayList2);
            ee eeVar = new ee(strA, context, beVar, i);
            if (executor == null) {
                executor = f1158a;
            }
            qe.b(executor, eeVar, new fe(strA));
            return null;
        }
    }

    public static Typeface e(Context context, be beVar, xd xdVar, int i, int i2) {
        String strA = a(beVar, i);
        Typeface typefaceC = f6305a.c(strA);
        if (typefaceC != null) {
            xdVar.b(new ge(typefaceC));
            return typefaceC;
        }
        if (i2 == -1) {
            ge geVarC = c(strA, context, beVar, i);
            xdVar.b(geVarC);
            return geVarC.f1000a;
        }
        try {
            ge geVar = (ge) qe.c(f1158a, new ce(strA, context, beVar, i), i2);
            xdVar.b(geVar);
            return geVar.f1000a;
        } catch (InterruptedException unused) {
            xdVar.b(new ge(-3));
            return null;
        }
    }
}
