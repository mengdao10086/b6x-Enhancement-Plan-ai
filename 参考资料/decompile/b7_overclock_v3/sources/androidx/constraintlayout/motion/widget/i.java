package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.Xml;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3722b = -1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f3723c = "CustomMethod";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f3724d = "CustomAttribute";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static HashMap<String, Constructor<? extends f>> f3725e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final String f3726f = "KeyFrames";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap<Integer, ArrayList<f>> f3727a = new HashMap<>();

    static {
        HashMap<String, Constructor<? extends f>> map = new HashMap<>();
        f3725e = map;
        try {
            map.put("KeyAttribute", g.class.getConstructor(new Class[0]));
            f3725e.put("KeyPosition", j.class.getConstructor(new Class[0]));
            f3725e.put("KeyCycle", h.class.getConstructor(new Class[0]));
            f3725e.put("KeyTimeCycle", l.class.getConstructor(new Class[0]));
            f3725e.put("KeyTrigger", m.class.getConstructor(new Class[0]));
        } catch (NoSuchMethodException unused) {
        }
    }

    public i() {
    }

    public static String f(int viewId, Context context) {
        return context.getResources().getResourceEntryName(viewId);
    }

    public void a(o motionController) {
        ArrayList<f> arrayList = this.f3727a.get(-1);
        if (arrayList != null) {
            motionController.b(arrayList);
        }
    }

    public void b(o motionController) {
        ArrayList<f> arrayList = this.f3727a.get(Integer.valueOf(motionController.f3845c));
        if (arrayList != null) {
            motionController.b(arrayList);
        }
        ArrayList<f> arrayList2 = this.f3727a.get(-1);
        if (arrayList2 != null) {
            for (f fVar : arrayList2) {
                if (fVar.g(((ConstraintLayout.b) motionController.f3844b.getLayoutParams()).f4078c0)) {
                    motionController.a(fVar);
                }
            }
        }
    }

    public void c(f key) {
        if (!this.f3727a.containsKey(Integer.valueOf(key.f3666b))) {
            this.f3727a.put(Integer.valueOf(key.f3666b), new ArrayList<>());
        }
        ArrayList<f> arrayList = this.f3727a.get(Integer.valueOf(key.f3666b));
        if (arrayList != null) {
            arrayList.add(key);
        }
    }

    public ArrayList<f> d(int id2) {
        return this.f3727a.get(Integer.valueOf(id2));
    }

    public Set<Integer> e() {
        return this.f3727a.keySet();
    }

    public i(Context context, XmlPullParser parser) {
        HashMap<String, ConstraintAttribute> map;
        HashMap<String, ConstraintAttribute> map2;
        f fVar = null;
        try {
            int eventType = parser.getEventType();
            while (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3 && "KeyFrameSet".equals(parser.getName())) {
                        return;
                    }
                } else {
                    String name = parser.getName();
                    if (f3725e.containsKey(name)) {
                        try {
                            Constructor<? extends f> constructor = f3725e.get(name);
                            if (constructor != null) {
                                f fVarNewInstance = constructor.newInstance(new Object[0]);
                                try {
                                    fVarNewInstance.f(context, Xml.asAttributeSet(parser));
                                    c(fVarNewInstance);
                                } catch (Exception unused) {
                                }
                                fVar = fVarNewInstance;
                            } else {
                                throw new NullPointerException("Keymaker for " + name + " not found");
                            }
                        } catch (Exception unused2) {
                        }
                    } else if (name.equalsIgnoreCase("CustomAttribute")) {
                        if (fVar != null && (map2 = fVar.f3669e) != null) {
                            ConstraintAttribute.q(context, parser, map2);
                        }
                    } else if (name.equalsIgnoreCase("CustomMethod") && fVar != null && (map = fVar.f3669e) != null) {
                        ConstraintAttribute.q(context, parser, map);
                    }
                }
                eventType = parser.next();
            }
        } catch (IOException e10) {
            e10.printStackTrace();
        } catch (XmlPullParserException e11) {
            e11.printStackTrace();
        }
    }
}
