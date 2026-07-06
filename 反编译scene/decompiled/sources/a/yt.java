package a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class yt extends cu {
    public yt() {
    }

    public yt(yt ytVar) {
        super(ytVar);
    }

    @Override // a.cu
    public boolean c() {
        return true;
    }

    public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        if (sc.j(xmlPullParser, "pathData")) {
            TypedArray typedArrayK = sc.k(resources, theme, attributeSet, mt.d);
            f(typedArrayK, xmlPullParser);
            typedArrayK.recycle();
        }
    }

    public final void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
        String string = typedArray.getString(0);
        if (string != null) {
            ((cu) this).f444a = string;
        }
        String string2 = typedArray.getString(1);
        if (string2 != null) {
            ((cu) this).f445a = xc.d(string2);
        }
        ((cu) this).f5828a = sc.g(typedArray, xmlPullParser, "fillType", 2, 0);
    }
}
