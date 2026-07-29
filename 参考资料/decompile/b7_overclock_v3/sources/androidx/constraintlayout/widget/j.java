package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class j {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4500h = "ConstraintLayoutStates";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f4501i = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f4503b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4502a = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4504c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4505d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray<a> f4506e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArray<d> f4507f = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0.a f4508g = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4509a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<b> f4510b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4511c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f4512d;

        public a(Context context, XmlPullParser parser) {
            this.f4511c = -1;
            this.f4512d = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f4509a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4509a);
                } else if (index == R.styleable.State_constraints) {
                    this.f4511c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4511c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4511c);
                    context.getResources().getResourceName(this.f4511c);
                    if (xc.d.f55101w.equals(resourceTypeName)) {
                        this.f4512d = true;
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(b size) {
            this.f4510b.add(size);
        }

        public int b(float width, float height) {
            for (int i10 = 0; i10 < this.f4510b.size(); i10++) {
                if (this.f4510b.get(i10).a(width, height)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4515c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4516d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4517e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4518f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f4519g;

        public b(Context context, XmlPullParser parser) {
            this.f4514b = Float.NaN;
            this.f4515c = Float.NaN;
            this.f4516d = Float.NaN;
            this.f4517e = Float.NaN;
            this.f4518f = -1;
            this.f4519g = false;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f4518f = typedArrayObtainStyledAttributes.getResourceId(index, this.f4518f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4518f);
                    context.getResources().getResourceName(this.f4518f);
                    if (xc.d.f55101w.equals(resourceTypeName)) {
                        this.f4519g = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f4517e = typedArrayObtainStyledAttributes.getDimension(index, this.f4517e);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f4515c = typedArrayObtainStyledAttributes.getDimension(index, this.f4515c);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f4516d = typedArrayObtainStyledAttributes.getDimension(index, this.f4516d);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f4514b = typedArrayObtainStyledAttributes.getDimension(index, this.f4514b);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float widthDp, float heightDp) {
            if (!Float.isNaN(this.f4514b) && widthDp < this.f4514b) {
                return false;
            }
            if (!Float.isNaN(this.f4515c) && heightDp < this.f4515c) {
                return false;
            }
            if (Float.isNaN(this.f4516d) || widthDp <= this.f4516d) {
                return Float.isNaN(this.f4517e) || heightDp <= this.f4517e;
            }
            return false;
        }
    }

    public j(Context context, XmlPullParser parser) {
        b(context, parser);
    }

    public int a(int currentConstrainSettId, int stateId, float width, float height) {
        a aVar = this.f4506e.get(stateId);
        if (aVar == null) {
            return stateId;
        }
        if (width == -1.0f || height == -1.0f) {
            if (aVar.f4511c == currentConstrainSettId) {
                return currentConstrainSettId;
            }
            Iterator<b> it2 = aVar.f4510b.iterator();
            while (it2.hasNext()) {
                if (currentConstrainSettId == it2.next().f4518f) {
                    return currentConstrainSettId;
                }
            }
            return aVar.f4511c;
        }
        b bVar = null;
        for (b bVar2 : aVar.f4510b) {
            if (bVar2.a(width, height)) {
                if (currentConstrainSettId == bVar2.f4518f) {
                    return currentConstrainSettId;
                }
                bVar = bVar2;
            }
        }
        return bVar != null ? bVar.f4518f : aVar.f4511c;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(android.content.Context r10, org.xmlpull.v1.XmlPullParser r11) {
        /*
            r9 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r11)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r10.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = 0
        L10:
            if (r3 >= r1) goto L25
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L22
            int r5 = r9.f4502a
            int r4 = r0.getResourceId(r4, r5)
            r9.f4502a = r4
        L22:
            int r3 = r3 + 1
            goto L10
        L25:
            r0.recycle()
            r0 = 0
            int r1 = r11.getEventType()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
        L2d:
            r3 = 1
            if (r1 == r3) goto La7
            if (r1 == 0) goto L96
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r1 == r6) goto L46
            if (r1 == r5) goto L3b
            goto L99
        L3b:
            java.lang.String r1 = r11.getName()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            boolean r1 = r4.equals(r1)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r1 == 0) goto L99
            return
        L46:
            java.lang.String r1 = r11.getName()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            r7 = -1
            int r8 = r1.hashCode()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            switch(r8) {
                case 80204913: goto L6e;
                case 1301459538: goto L64;
                case 1382829617: goto L5d;
                case 1901439077: goto L53;
                default: goto L52;
            }     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
        L52:
            goto L78
        L53:
            java.lang.String r3 = "Variant"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r1 == 0) goto L78
            r3 = 3
            goto L79
        L5d:
            boolean r1 = r1.equals(r4)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r1 == 0) goto L78
            goto L79
        L64:
            java.lang.String r3 = "LayoutDescription"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r1 == 0) goto L78
            r3 = 0
            goto L79
        L6e:
            java.lang.String r3 = "State"
            boolean r1 = r1.equals(r3)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r1 == 0) goto L78
            r3 = 2
            goto L79
        L78:
            r3 = -1
        L79:
            if (r3 == r6) goto L89
            if (r3 == r5) goto L7e
            goto L99
        L7e:
            androidx.constraintlayout.widget.j$b r1 = new androidx.constraintlayout.widget.j$b     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            r1.<init>(r10, r11)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            if (r0 == 0) goto L99
            r0.a(r1)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            goto L99
        L89:
            androidx.constraintlayout.widget.j$a r0 = new androidx.constraintlayout.widget.j$a     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            r0.<init>(r10, r11)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            android.util.SparseArray<androidx.constraintlayout.widget.j$a> r1 = r9.f4506e     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            int r3 = r0.f4509a     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            r1.put(r3, r0)     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            goto L99
        L96:
            r11.getName()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
        L99:
            int r1 = r11.next()     // Catch: java.io.IOException -> L9e org.xmlpull.v1.XmlPullParserException -> La3
            goto L2d
        L9e:
            r10 = move-exception
            r10.printStackTrace()
            goto La7
        La3:
            r10 = move-exception
            r10.printStackTrace()
        La7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.j.b(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public boolean c(int id2, float width, float height) {
        int i10 = this.f4504c;
        if (i10 != id2) {
            return true;
        }
        a aVarValueAt = id2 == -1 ? this.f4506e.valueAt(0) : this.f4506e.get(i10);
        int i11 = this.f4505d;
        return (i11 == -1 || !aVarValueAt.f4510b.get(i11).a(width, height)) && this.f4505d != aVarValueAt.b(width, height);
    }

    public void d(c0.a constraintsChangedListener) {
        this.f4508g = constraintsChangedListener;
    }

    public int e(int id2, int width, int height) {
        return f(-1, id2, width, height);
    }

    public int f(int currentId, int id2, float width, float height) {
        int iB;
        if (currentId == id2) {
            a aVarValueAt = id2 == -1 ? this.f4506e.valueAt(0) : this.f4506e.get(this.f4504c);
            if (aVarValueAt == null) {
                return -1;
            }
            return ((this.f4505d == -1 || !aVarValueAt.f4510b.get(currentId).a(width, height)) && currentId != (iB = aVarValueAt.b(width, height))) ? iB == -1 ? aVarValueAt.f4511c : aVarValueAt.f4510b.get(iB).f4518f : currentId;
        }
        a aVar = this.f4506e.get(id2);
        if (aVar == null) {
            return -1;
        }
        int iB2 = aVar.b(width, height);
        return iB2 == -1 ? aVar.f4511c : aVar.f4510b.get(iB2).f4518f;
    }
}
