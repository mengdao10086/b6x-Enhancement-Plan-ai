package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final String f4178h = "ConstraintLayoutStates";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final boolean f4179i = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConstraintLayout f4180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f4181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4182c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4183d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SparseArray<a> f4184e = new SparseArray<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public SparseArray<d> f4185f = new SparseArray<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c0.a f4186g = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public ArrayList<C0037b> f4188b = new ArrayList<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public d f4190d;

        public a(Context context, XmlPullParser parser) {
            this.f4189c = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.State);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.State_android_id) {
                    this.f4187a = typedArrayObtainStyledAttributes.getResourceId(index, this.f4187a);
                } else if (index == R.styleable.State_constraints) {
                    this.f4189c = typedArrayObtainStyledAttributes.getResourceId(index, this.f4189c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4189c);
                    context.getResources().getResourceName(this.f4189c);
                    if (xc.d.f55101w.equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4190d = dVar;
                        dVar.G(context, this.f4189c);
                    }
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public void a(C0037b size) {
            this.f4188b.add(size);
        }

        public int b(float width, float height) {
            for (int i10 = 0; i10 < this.f4188b.size(); i10++) {
                if (this.f4188b.get(i10).a(width, height)) {
                    return i10;
                }
            }
            return -1;
        }
    }

    /* JADX INFO: renamed from: androidx.constraintlayout.widget.b$b, reason: collision with other inner class name */
    public static class C0037b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f4191a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f4192b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f4193c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public float f4194d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public float f4195e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f4196f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public d f4197g;

        public C0037b(Context context, XmlPullParser parser) {
            this.f4192b = Float.NaN;
            this.f4193c = Float.NaN;
            this.f4194d = Float.NaN;
            this.f4195e = Float.NaN;
            this.f4196f = -1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.Variant);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i10 = 0; i10 < indexCount; i10++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i10);
                if (index == R.styleable.Variant_constraints) {
                    this.f4196f = typedArrayObtainStyledAttributes.getResourceId(index, this.f4196f);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f4196f);
                    context.getResources().getResourceName(this.f4196f);
                    if (xc.d.f55101w.equals(resourceTypeName)) {
                        d dVar = new d();
                        this.f4197g = dVar;
                        dVar.G(context, this.f4196f);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f4195e = typedArrayObtainStyledAttributes.getDimension(index, this.f4195e);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f4193c = typedArrayObtainStyledAttributes.getDimension(index, this.f4193c);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f4194d = typedArrayObtainStyledAttributes.getDimension(index, this.f4194d);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f4192b = typedArrayObtainStyledAttributes.getDimension(index, this.f4192b);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public boolean a(float widthDp, float heightDp) {
            if (!Float.isNaN(this.f4192b) && widthDp < this.f4192b) {
                return false;
            }
            if (!Float.isNaN(this.f4193c) && heightDp < this.f4193c) {
                return false;
            }
            if (Float.isNaN(this.f4194d) || widthDp <= this.f4194d) {
                return Float.isNaN(this.f4195e) || heightDp <= this.f4195e;
            }
            return false;
        }
    }

    public b(Context context, ConstraintLayout layout, int resourceID) {
        this.f4180a = layout;
        a(context, resourceID);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r9, int r10) {
        /*
            r8 = this;
            android.content.res.Resources r0 = r9.getResources()
            android.content.res.XmlResourceParser r10 = r0.getXml(r10)
            r0 = 0
            int r1 = r10.getEventType()     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
        Ld:
            r2 = 1
            if (r1 == r2) goto L8c
            if (r1 == 0) goto L7b
            r3 = 2
            if (r1 == r3) goto L17
            goto L7e
        L17:
            java.lang.String r1 = r10.getName()     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            r4 = -1
            int r5 = r1.hashCode()     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            r6 = 4
            r7 = 3
            switch(r5) {
                case -1349929691: goto L4d;
                case 80204913: goto L43;
                case 1382829617: goto L3a;
                case 1657696882: goto L30;
                case 1901439077: goto L26;
                default: goto L25;
            }     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
        L25:
            goto L57
        L26:
            java.lang.String r2 = "Variant"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L57
            r2 = 3
            goto L58
        L30:
            java.lang.String r2 = "layoutDescription"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L57
            r2 = 0
            goto L58
        L3a:
            java.lang.String r5 = "StateSet"
            boolean r1 = r1.equals(r5)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L57
            goto L58
        L43:
            java.lang.String r2 = "State"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L57
            r2 = 2
            goto L58
        L4d:
            java.lang.String r2 = "ConstraintSet"
            boolean r1 = r1.equals(r2)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r1 == 0) goto L57
            r2 = 4
            goto L58
        L57:
            r2 = -1
        L58:
            if (r2 == r3) goto L6e
            if (r2 == r7) goto L63
            if (r2 == r6) goto L5f
            goto L7e
        L5f:
            r8.c(r9, r10)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            goto L7e
        L63:
            androidx.constraintlayout.widget.b$b r1 = new androidx.constraintlayout.widget.b$b     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            r1.<init>(r9, r10)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            if (r0 == 0) goto L7e
            r0.a(r1)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            goto L7e
        L6e:
            androidx.constraintlayout.widget.b$a r0 = new androidx.constraintlayout.widget.b$a     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            r0.<init>(r9, r10)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            android.util.SparseArray<androidx.constraintlayout.widget.b$a> r1 = r8.f4184e     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            int r2 = r0.f4187a     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            r1.put(r2, r0)     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            goto L7e
        L7b:
            r10.getName()     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
        L7e:
            int r1 = r10.next()     // Catch: java.io.IOException -> L83 org.xmlpull.v1.XmlPullParserException -> L88
            goto Ld
        L83:
            r9 = move-exception
            r9.printStackTrace()
            goto L8c
        L88:
            r9 = move-exception
            r9.printStackTrace()
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.b.a(android.content.Context, int):void");
    }

    public boolean b(int id2, float width, float height) {
        int i10 = this.f4182c;
        if (i10 != id2) {
            return true;
        }
        a aVarValueAt = id2 == -1 ? this.f4184e.valueAt(0) : this.f4184e.get(i10);
        int i11 = this.f4183d;
        return (i11 == -1 || !aVarValueAt.f4188b.get(i11).a(width, height)) && this.f4183d != aVarValueAt.b(width, height);
    }

    public final void c(Context context, XmlPullParser parser) {
        d dVar = new d();
        int attributeCount = parser.getAttributeCount();
        for (int i10 = 0; i10 < attributeCount; i10++) {
            String attributeName = parser.getAttributeName(i10);
            String attributeValue = parser.getAttributeValue(i10);
            if (attributeName != null && attributeValue != null && "id".equals(attributeName)) {
                int identifier = attributeValue.contains(fh.a.f28350w) ? context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName()) : -1;
                if (identifier == -1 && attributeValue.length() > 1) {
                    identifier = Integer.parseInt(attributeValue.substring(1));
                }
                dVar.x0(context, parser);
                this.f4185f.put(identifier, dVar);
                return;
            }
        }
    }

    public void d(c0.a constraintsChangedListener) {
        this.f4186g = constraintsChangedListener;
    }

    public void e(int id2, float width, float height) {
        int iB;
        int i10 = this.f4182c;
        if (i10 == id2) {
            a aVarValueAt = id2 == -1 ? this.f4184e.valueAt(0) : this.f4184e.get(i10);
            int i11 = this.f4183d;
            if ((i11 == -1 || !aVarValueAt.f4188b.get(i11).a(width, height)) && this.f4183d != (iB = aVarValueAt.b(width, height))) {
                d dVar = iB == -1 ? this.f4181b : aVarValueAt.f4188b.get(iB).f4197g;
                int i12 = iB == -1 ? aVarValueAt.f4189c : aVarValueAt.f4188b.get(iB).f4196f;
                if (dVar == null) {
                    return;
                }
                this.f4183d = iB;
                c0.a aVar = this.f4186g;
                if (aVar != null) {
                    aVar.b(-1, i12);
                }
                dVar.r(this.f4180a);
                c0.a aVar2 = this.f4186g;
                if (aVar2 != null) {
                    aVar2.a(-1, i12);
                    return;
                }
                return;
            }
            return;
        }
        this.f4182c = id2;
        a aVar3 = this.f4184e.get(id2);
        int iB2 = aVar3.b(width, height);
        d dVar2 = iB2 == -1 ? aVar3.f4190d : aVar3.f4188b.get(iB2).f4197g;
        int i13 = iB2 == -1 ? aVar3.f4189c : aVar3.f4188b.get(iB2).f4196f;
        if (dVar2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NO Constraint set found ! id=");
            sb2.append(id2);
            sb2.append(", dim =");
            sb2.append(width);
            sb2.append(", ");
            sb2.append(height);
            return;
        }
        this.f4183d = iB2;
        c0.a aVar4 = this.f4186g;
        if (aVar4 != null) {
            aVar4.b(id2, i13);
        }
        dVar2.r(this.f4180a);
        c0.a aVar5 = this.f4186g;
        if (aVar5 != null) {
            aVar5.a(id2, i13);
        }
    }
}
