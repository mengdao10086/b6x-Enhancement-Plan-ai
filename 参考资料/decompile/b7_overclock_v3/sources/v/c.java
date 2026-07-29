package v;

import androidx.constraintlayout.core.parser.CLParser;
import androidx.constraintlayout.core.parser.CLParsingException;
import androidx.constraintlayout.core.parser.d;
import androidx.constraintlayout.core.parser.f;
import w.u;
import w.v;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    public interface a {
        int get(int i10);
    }

    public interface b {
        int c(String str);
    }

    public static void a(String[] strArr) {
        c("{frame:22,\ntarget:'widget1',\neasing:'easeIn',\ncurveFit:'spline',\nprogress:0.3,\nalpha:0.2,\nelevation:0.7,\nrotationZ:23,\nrotationX:25.0,\nrotationY:27.0,\npivotX:15,\npivotY:17,\npivotTarget:'32',\npathRotate:23,\nscaleX:0.5,\nscaleY:0.7,\ntranslationX:5,\ntranslationY:7,\ntranslationZ:11,\n}");
    }

    public static u b(String str, b bVar, a aVar) {
        u uVar = new u();
        try {
            f fVarD = CLParser.d(str);
            int size = fVarD.size();
            for (int i10 = 0; i10 < size; i10++) {
                d dVar = (d) fVarD.z(i10);
                String strB = dVar.b();
                androidx.constraintlayout.core.parser.c cVarB0 = dVar.b0();
                int iC = bVar.c(strB);
                if (iC == -1) {
                    System.err.println("unknown type " + strB);
                } else {
                    int i11 = aVar.get(iC);
                    if (i11 == 1) {
                        uVar.d(iC, fVarD.E(i10));
                    } else if (i11 == 2) {
                        uVar.b(iC, cVarB0.i());
                        System.out.println("parse " + strB + " INT_MASK > " + cVarB0.i());
                    } else if (i11 == 4) {
                        uVar.a(iC, cVarB0.g());
                        System.out.println("parse " + strB + " FLOAT_MASK > " + cVarB0.g());
                    } else if (i11 == 8) {
                        uVar.c(iC, cVarB0.b());
                        System.out.println("parse " + strB + " STRING_MASK > " + cVarB0.b());
                    }
                }
            }
        } catch (CLParsingException e10) {
            e10.printStackTrace();
        }
        return uVar;
    }

    public static u c(String str) {
        return b(str, new b() { // from class: v.b
            @Override // v.c.b
            public final int c(String str2) {
                return v.a(str2);
            }
        }, new a() { // from class: v.a
            @Override // v.c.a
            public final int get(int i10) {
                return v.b(i10);
            }
        });
    }
}
