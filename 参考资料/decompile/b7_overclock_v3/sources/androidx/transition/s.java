package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import g.n0;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f7991b = {Context.class, AttributeSet.class};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final androidx.collection.a<String, Constructor<?>> f7992c = new androidx.collection.a<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7993a;

    public s(@n0 Context context) {
        this.f7993a = context;
    }

    @n0
    public static s d(@n0 Context context) {
        return new s(context);
    }

    public final Object a(AttributeSet attributeSet, Class<?> cls, String str) {
        Object objNewInstance;
        Class<? extends U> clsAsSubclass;
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        if (attributeValue == null) {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
        try {
            androidx.collection.a<String, Constructor<?>> aVar = f7992c;
            synchronized (aVar) {
                Constructor<?> constructor = aVar.get(attributeValue);
                if (constructor == null && (clsAsSubclass = Class.forName(attributeValue, false, this.f7993a.getClassLoader()).asSubclass(cls)) != 0) {
                    constructor = clsAsSubclass.getConstructor(f7991b);
                    constructor.setAccessible(true);
                    aVar.put(attributeValue, constructor);
                }
                objNewInstance = constructor.newInstance(this.f7993a, attributeSet);
            }
            return objNewInstance;
        } catch (Exception e10) {
            throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e10);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x017d, code lost:
    
        return r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.transition.q b(org.xmlpull.v1.XmlPullParser r8, android.util.AttributeSet r9, androidx.transition.q r10) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 382
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.s.b(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, androidx.transition.q):androidx.transition.q");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0054, code lost:
    
        return r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.transition.u c(org.xmlpull.v1.XmlPullParser r5, android.util.AttributeSet r6, android.view.ViewGroup r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.getDepth()
            r1 = 0
        L5:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L12
            int r3 = r5.getDepth()
            if (r3 <= r0) goto L54
        L12:
            r3 = 1
            if (r2 == r3) goto L54
            r3 = 2
            if (r2 == r3) goto L19
            goto L5
        L19:
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "transitionManager"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L2b
            androidx.transition.u r1 = new androidx.transition.u
            r1.<init>()
            goto L5
        L2b:
            java.lang.String r3 = "transition"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L39
            if (r1 == 0) goto L39
            r4.h(r6, r5, r7, r1)
            goto L5
        L39:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown scene name: "
            r7.append(r0)
            java.lang.String r5 = r5.getName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L54:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.s.c(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.u");
    }

    @SuppressLint({"RestrictedApi"})
    public final void e(XmlPullParser xmlPullParser, AttributeSet attributeSet, q qVar) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (!xmlPullParser.getName().equals("target")) {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
                TypedArray typedArrayObtainStyledAttributes = this.f7993a.obtainStyledAttributes(attributeSet, p.f7918a);
                int iL = j0.n.l(typedArrayObtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                if (iL != 0) {
                    qVar.b(iL);
                } else {
                    int iL2 = j0.n.l(typedArrayObtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                    if (iL2 != 0) {
                        qVar.y(iL2, true);
                    } else {
                        String strM = j0.n.m(typedArrayObtainStyledAttributes, xmlPullParser, "targetName", 4);
                        if (strM != null) {
                            qVar.e(strM);
                        } else {
                            String strM2 = j0.n.m(typedArrayObtainStyledAttributes, xmlPullParser, "excludeName", 5);
                            if (strM2 != null) {
                                qVar.C(strM2, true);
                            } else {
                                String strM3 = j0.n.m(typedArrayObtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                if (strM3 != null) {
                                    try {
                                        qVar.B(Class.forName(strM3), true);
                                    } catch (ClassNotFoundException e10) {
                                        typedArrayObtainStyledAttributes.recycle();
                                        throw new RuntimeException("Could not create " + strM3, e10);
                                    }
                                } else {
                                    String strM4 = j0.n.m(typedArrayObtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                    if (strM4 != null) {
                                        qVar.d(Class.forName(strM4));
                                    }
                                }
                            }
                        }
                    }
                }
                typedArrayObtainStyledAttributes.recycle();
            }
        }
    }

    public q f(int i10) {
        XmlResourceParser xml = this.f7993a.getResources().getXml(i10);
        try {
            try {
                return b(xml, Xml.asAttributeSet(xml), null);
            } catch (IOException e10) {
                throw new InflateException(xml.getPositionDescription() + ": " + e10.getMessage(), e10);
            } catch (XmlPullParserException e11) {
                throw new InflateException(e11.getMessage(), e11);
            }
        } finally {
            xml.close();
        }
    }

    public u g(int i10, ViewGroup viewGroup) {
        XmlResourceParser xml = this.f7993a.getResources().getXml(i10);
        try {
            try {
                return c(xml, Xml.asAttributeSet(xml), viewGroup);
            } catch (IOException e10) {
                InflateException inflateException = new InflateException(xml.getPositionDescription() + ": " + e10.getMessage());
                inflateException.initCause(e10);
                throw inflateException;
            } catch (XmlPullParserException e11) {
                InflateException inflateException2 = new InflateException(e11.getMessage());
                inflateException2.initCause(e11);
                throw inflateException2;
            }
        } finally {
            xml.close();
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void h(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, u uVar) throws Resources.NotFoundException {
        q qVarF;
        TypedArray typedArrayObtainStyledAttributes = this.f7993a.obtainStyledAttributes(attributeSet, p.f7919b);
        int iL = j0.n.l(typedArrayObtainStyledAttributes, xmlPullParser, androidx.appcompat.graphics.drawable.a.f1755z, 2, -1);
        int iL2 = j0.n.l(typedArrayObtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        n nVarD = iL2 < 0 ? null : n.d(viewGroup, iL2, this.f7993a);
        int iL3 = j0.n.l(typedArrayObtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        n nVarD2 = iL3 >= 0 ? n.d(viewGroup, iL3, this.f7993a) : null;
        if (iL >= 0 && (qVarF = f(iL)) != null) {
            if (nVarD2 == null) {
                throw new RuntimeException("No toScene for transition ID " + iL);
            }
            if (nVarD == null) {
                uVar.l(nVarD2, qVarF);
            } else {
                uVar.k(nVarD, nVarD2, qVarF);
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
