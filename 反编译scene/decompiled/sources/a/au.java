package a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.util.AttributeSet;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class au extends bu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f5641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f135a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Matrix f136a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f137a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayList<bu> f138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f139a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Matrix f140b;
    public float c;
    public float d;
    public float e;
    public float f;
    public float g;

    public au() {
        super();
        this.f136a = new Matrix();
        this.f138a = new ArrayList<>();
        this.f5641a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f140b = new Matrix();
        this.f137a = null;
    }

    public au(au auVar, ba<String, Object> baVar) {
        cu ytVar;
        super();
        this.f136a = new Matrix();
        this.f138a = new ArrayList<>();
        this.f5641a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 1.0f;
        this.e = 1.0f;
        this.f = 0.0f;
        this.g = 0.0f;
        this.f140b = new Matrix();
        this.f137a = null;
        this.f5641a = auVar.f5641a;
        this.b = auVar.b;
        this.c = auVar.c;
        this.d = auVar.d;
        this.e = auVar.e;
        this.f = auVar.f;
        this.g = auVar.g;
        this.f139a = auVar.f139a;
        String str = auVar.f137a;
        this.f137a = str;
        this.f135a = auVar.f135a;
        if (str != null) {
            baVar.put(str, this);
        }
        this.f140b.set(auVar.f140b);
        ArrayList<bu> arrayList = auVar.f138a;
        for (int i = 0; i < arrayList.size(); i++) {
            bu buVar = arrayList.get(i);
            if (buVar instanceof au) {
                this.f138a.add(new au((au) buVar, baVar));
            } else {
                if (buVar instanceof zt) {
                    ytVar = new zt((zt) buVar);
                } else {
                    if (!(buVar instanceof yt)) {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    ytVar = new yt((yt) buVar);
                }
                this.f138a.add(ytVar);
                String str2 = ytVar.f444a;
                if (str2 != null) {
                    baVar.put(str2, ytVar);
                }
            }
        }
    }

    @Override // a.bu
    public boolean a() {
        for (int i = 0; i < this.f138a.size(); i++) {
            if (this.f138a.get(i).a()) {
                return true;
            }
        }
        return false;
    }

    @Override // a.bu
    public boolean b(int[] iArr) {
        boolean zB = false;
        for (int i = 0; i < this.f138a.size(); i++) {
            zB |= this.f138a.get(i).b(iArr);
        }
        return zB;
    }

    public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
        TypedArray typedArrayK = sc.k(resources, theme, attributeSet, mt.b);
        e(typedArrayK, xmlPullParser);
        typedArrayK.recycle();
    }

    public final void d() {
        this.f140b.reset();
        this.f140b.postTranslate(-this.b, -this.c);
        this.f140b.postScale(this.d, this.e);
        this.f140b.postRotate(this.f5641a, 0.0f, 0.0f);
        this.f140b.postTranslate(this.f + this.b, this.g + this.c);
    }

    public final void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
        this.f139a = null;
        this.f5641a = sc.f(typedArray, xmlPullParser, "rotation", 5, this.f5641a);
        this.b = typedArray.getFloat(1, this.b);
        this.c = typedArray.getFloat(2, this.c);
        this.d = sc.f(typedArray, xmlPullParser, "scaleX", 3, this.d);
        this.e = sc.f(typedArray, xmlPullParser, "scaleY", 4, this.e);
        this.f = sc.f(typedArray, xmlPullParser, "translateX", 6, this.f);
        this.g = sc.f(typedArray, xmlPullParser, "translateY", 7, this.g);
        String string = typedArray.getString(0);
        if (string != null) {
            this.f137a = string;
        }
        d();
    }

    public String getGroupName() {
        return this.f137a;
    }

    public Matrix getLocalMatrix() {
        return this.f140b;
    }

    public float getPivotX() {
        return this.b;
    }

    public float getPivotY() {
        return this.c;
    }

    public float getRotation() {
        return this.f5641a;
    }

    public float getScaleX() {
        return this.d;
    }

    public float getScaleY() {
        return this.e;
    }

    public float getTranslateX() {
        return this.f;
    }

    public float getTranslateY() {
        return this.g;
    }

    public void setPivotX(float f) {
        if (f != this.b) {
            this.b = f;
            d();
        }
    }

    public void setPivotY(float f) {
        if (f != this.c) {
            this.c = f;
            d();
        }
    }

    public void setRotation(float f) {
        if (f != this.f5641a) {
            this.f5641a = f;
            d();
        }
    }

    public void setScaleX(float f) {
        if (f != this.d) {
            this.d = f;
            d();
        }
    }

    public void setScaleY(float f) {
        if (f != this.e) {
            this.e = f;
            d();
        }
    }

    public void setTranslateX(float f) {
        if (f != this.f) {
            this.f = f;
            d();
        }
    }

    public void setTranslateY(float f) {
        if (f != this.g) {
            this.g = f;
            d();
        }
    }
}
