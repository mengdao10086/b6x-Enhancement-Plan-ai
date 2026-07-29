package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes2.dex */
public class ConstraintAttribute {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final String f4030i = "TransitionLayout";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f4031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f4032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AttributeType f4033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4034d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f4035e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f4036f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f4037g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f4038h;

    public enum AttributeType {
        INT_TYPE,
        FLOAT_TYPE,
        COLOR_TYPE,
        COLOR_DRAWABLE_TYPE,
        STRING_TYPE,
        BOOLEAN_TYPE,
        DIMENSION_TYPE,
        REFERENCE_TYPE
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f4039a;

        static {
            int[] iArr = new int[AttributeType.values().length];
            f4039a = iArr;
            try {
                iArr[AttributeType.REFERENCE_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4039a[AttributeType.BOOLEAN_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4039a[AttributeType.STRING_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4039a[AttributeType.COLOR_TYPE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4039a[AttributeType.COLOR_DRAWABLE_TYPE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f4039a[AttributeType.INT_TYPE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f4039a[AttributeType.FLOAT_TYPE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f4039a[AttributeType.DIMENSION_TYPE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public ConstraintAttribute(String name, AttributeType attributeType) {
        this.f4031a = false;
        this.f4032b = name;
        this.f4033c = attributeType;
    }

    public static int b(int c10) {
        int i10 = (c10 & (~(c10 >> 31))) - 255;
        return (i10 & (i10 >> 31)) + 255;
    }

    public static HashMap<String, ConstraintAttribute> d(HashMap<String, ConstraintAttribute> base, View view) {
        HashMap<String, ConstraintAttribute> map = new HashMap<>();
        Class<?> cls = view.getClass();
        for (String str : base.keySet()) {
            ConstraintAttribute constraintAttribute = base.get(str);
            try {
                if (str.equals("BackgroundColor")) {
                    map.put(str, new ConstraintAttribute(constraintAttribute, Integer.valueOf(((ColorDrawable) view.getBackground()).getColor())));
                } else {
                    map.put(str, new ConstraintAttribute(constraintAttribute, cls.getMethod("getMap" + str, new Class[0]).invoke(view, new Object[0])));
                }
            } catch (IllegalAccessException e10) {
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.printStackTrace();
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
            }
        }
        return map;
    }

    public static void q(Context context, XmlPullParser parser, HashMap<String, ConstraintAttribute> custom) {
        AttributeType attributeType;
        Object objValueOf;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(parser), R.styleable.CustomAttribute);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        Object objValueOf2 = null;
        AttributeType attributeType2 = null;
        boolean z10 = false;
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i10);
            if (index == R.styleable.CustomAttribute_attributeName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == R.styleable.CustomAttribute_methodName) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == R.styleable.CustomAttribute_customBoolean) {
                objValueOf2 = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                attributeType2 = AttributeType.BOOLEAN_TYPE;
            } else {
                if (index == R.styleable.CustomAttribute_customColorValue) {
                    attributeType = AttributeType.COLOR_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customColorDrawableValue) {
                    attributeType = AttributeType.COLOR_DRAWABLE_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else if (index == R.styleable.CustomAttribute_customPixelDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics()));
                } else if (index == R.styleable.CustomAttribute_customDimension) {
                    attributeType = AttributeType.DIMENSION_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.CustomAttribute_customFloatValue) {
                    attributeType = AttributeType.FLOAT_TYPE;
                    objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                } else if (index == R.styleable.CustomAttribute_customIntegerValue) {
                    attributeType = AttributeType.INT_TYPE;
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                } else if (index == R.styleable.CustomAttribute_customStringValue) {
                    attributeType = AttributeType.STRING_TYPE;
                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                } else if (index == R.styleable.CustomAttribute_customReference) {
                    attributeType = AttributeType.REFERENCE_TYPE;
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                    if (resourceId == -1) {
                        resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                    }
                    objValueOf = Integer.valueOf(resourceId);
                }
                Object obj = objValueOf;
                attributeType2 = attributeType;
                objValueOf2 = obj;
            }
        }
        if (string != null && objValueOf2 != null) {
            custom.put(string, new ConstraintAttribute(string, attributeType2, objValueOf2, z10));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void r(View view, HashMap<String, ConstraintAttribute> map) {
        Class<?> cls = view.getClass();
        for (String str : map.keySet()) {
            ConstraintAttribute constraintAttribute = map.get(str);
            String str2 = constraintAttribute.f4031a ? str : "set" + str;
            try {
                switch (a.f4039a[constraintAttribute.f4033c.ordinal()]) {
                    case 1:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f4034d));
                        break;
                    case 2:
                        cls.getMethod(str2, Boolean.TYPE).invoke(view, Boolean.valueOf(constraintAttribute.f4037g));
                        break;
                    case 3:
                        cls.getMethod(str2, CharSequence.class).invoke(view, constraintAttribute.f4036f);
                        break;
                    case 4:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f4038h));
                        break;
                    case 5:
                        Method method = cls.getMethod(str2, Drawable.class);
                        ColorDrawable colorDrawable = new ColorDrawable();
                        colorDrawable.setColor(constraintAttribute.f4038h);
                        method.invoke(view, colorDrawable);
                        break;
                    case 6:
                        cls.getMethod(str2, Integer.TYPE).invoke(view, Integer.valueOf(constraintAttribute.f4034d));
                        break;
                    case 7:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f4035e));
                        break;
                    case 8:
                        cls.getMethod(str2, Float.TYPE).invoke(view, Float.valueOf(constraintAttribute.f4035e));
                        break;
                }
            } catch (IllegalAccessException e10) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" Custom Attribute \"");
                sb2.append(str);
                sb2.append("\" not found on ");
                sb2.append(cls.getName());
                e10.printStackTrace();
            } catch (NoSuchMethodException e11) {
                e11.getMessage();
                StringBuilder sb3 = new StringBuilder();
                sb3.append(" Custom Attribute \"");
                sb3.append(str);
                sb3.append("\" not found on ");
                sb3.append(cls.getName());
                StringBuilder sb4 = new StringBuilder();
                sb4.append(cls.getName());
                sb4.append(" must have a method ");
                sb4.append(str2);
            } catch (InvocationTargetException e12) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(" Custom Attribute \"");
                sb5.append(str);
                sb5.append("\" not found on ");
                sb5.append(cls.getName());
                e12.printStackTrace();
            }
        }
    }

    public void a(View view) {
        String str;
        Class<?> cls = view.getClass();
        String str2 = this.f4032b;
        if (this.f4031a) {
            str = str2;
        } else {
            str = "set" + str2;
        }
        try {
            switch (a.f4039a[this.f4033c.ordinal()]) {
                case 1:
                case 6:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f4034d));
                    break;
                case 2:
                    cls.getMethod(str, Boolean.TYPE).invoke(view, Boolean.valueOf(this.f4037g));
                    break;
                case 3:
                    cls.getMethod(str, CharSequence.class).invoke(view, this.f4036f);
                    break;
                case 4:
                    cls.getMethod(str, Integer.TYPE).invoke(view, Integer.valueOf(this.f4038h));
                    break;
                case 5:
                    Method method = cls.getMethod(str, Drawable.class);
                    ColorDrawable colorDrawable = new ColorDrawable();
                    colorDrawable.setColor(this.f4038h);
                    method.invoke(view, colorDrawable);
                    break;
                case 7:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f4035e));
                    break;
                case 8:
                    cls.getMethod(str, Float.TYPE).invoke(view, Float.valueOf(this.f4035e));
                    break;
            }
        } catch (IllegalAccessException e10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" Custom Attribute \"");
            sb2.append(str2);
            sb2.append("\" not found on ");
            sb2.append(cls.getName());
            e10.printStackTrace();
        } catch (NoSuchMethodException e11) {
            e11.getMessage();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(" Custom Attribute \"");
            sb3.append(str2);
            sb3.append("\" not found on ");
            sb3.append(cls.getName());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(cls.getName());
            sb4.append(" must have a method ");
            sb4.append(str);
        } catch (InvocationTargetException e12) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(" Custom Attribute \"");
            sb5.append(str2);
            sb5.append("\" not found on ");
            sb5.append(cls.getName());
            e12.printStackTrace();
        }
    }

    public boolean c(ConstraintAttribute constraintAttribute) {
        AttributeType attributeType;
        if (constraintAttribute == null || (attributeType = this.f4033c) != constraintAttribute.f4033c) {
            return false;
        }
        switch (a.f4039a[attributeType.ordinal()]) {
            case 1:
            case 6:
                if (this.f4034d == constraintAttribute.f4034d) {
                }
                break;
            case 2:
                if (this.f4037g == constraintAttribute.f4037g) {
                }
                break;
            case 3:
                if (this.f4034d == constraintAttribute.f4034d) {
                }
                break;
            case 4:
            case 5:
                if (this.f4038h == constraintAttribute.f4038h) {
                }
                break;
            case 7:
                if (this.f4035e == constraintAttribute.f4035e) {
                }
                break;
            case 8:
                if (this.f4035e == constraintAttribute.f4035e) {
                }
                break;
        }
        return false;
    }

    public int e() {
        return this.f4038h;
    }

    public float f() {
        return this.f4035e;
    }

    public int g() {
        return this.f4034d;
    }

    public String h() {
        return this.f4032b;
    }

    public String i() {
        return this.f4036f;
    }

    public AttributeType j() {
        return this.f4033c;
    }

    public float k() {
        switch (a.f4039a[this.f4033c.ordinal()]) {
            case 2:
                return this.f4037g ? 1.0f : 0.0f;
            case 3:
                throw new RuntimeException("Cannot interpolate String");
            case 4:
            case 5:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 6:
                return this.f4034d;
            case 7:
                return this.f4035e;
            case 8:
                return this.f4035e;
            default:
                return Float.NaN;
        }
    }

    public void l(float[] ret) {
        switch (a.f4039a[this.f4033c.ordinal()]) {
            case 2:
                ret[0] = this.f4037g ? 1.0f : 0.0f;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int i10 = (this.f4038h >> 24) & 255;
                float fPow = (float) Math.pow(((r0 >> 16) & 255) / 255.0f, 2.2d);
                float fPow2 = (float) Math.pow(((r0 >> 8) & 255) / 255.0f, 2.2d);
                float fPow3 = (float) Math.pow((r0 & 255) / 255.0f, 2.2d);
                ret[0] = fPow;
                ret[1] = fPow2;
                ret[2] = fPow3;
                ret[3] = i10 / 255.0f;
                return;
            case 6:
                ret[0] = this.f4034d;
                return;
            case 7:
                ret[0] = this.f4035e;
                return;
            case 8:
                ret[0] = this.f4035e;
                return;
            default:
                return;
        }
    }

    public boolean m() {
        return this.f4037g;
    }

    public boolean n() {
        int i10 = a.f4039a[this.f4033c.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? false : true;
    }

    public boolean o() {
        return this.f4031a;
    }

    public int p() {
        int i10 = a.f4039a[this.f4033c.ordinal()];
        return (i10 == 4 || i10 == 5) ? 4 : 1;
    }

    public void s(int value) {
        this.f4038h = value;
    }

    public void t(float value) {
        this.f4035e = value;
    }

    public void u(int value) {
        this.f4034d = value;
    }

    public void v(String value) {
        this.f4036f = value;
    }

    public void w(Object value) {
        switch (a.f4039a[this.f4033c.ordinal()]) {
            case 1:
            case 6:
                this.f4034d = ((Integer) value).intValue();
                break;
            case 2:
                this.f4037g = ((Boolean) value).booleanValue();
                break;
            case 3:
                this.f4036f = (String) value;
                break;
            case 4:
            case 5:
                this.f4038h = ((Integer) value).intValue();
                break;
            case 7:
                this.f4035e = ((Float) value).floatValue();
                break;
            case 8:
                this.f4035e = ((Float) value).floatValue();
                break;
        }
    }

    public void x(float[] value) {
        switch (a.f4039a[this.f4033c.ordinal()]) {
            case 1:
            case 6:
                this.f4034d = (int) value[0];
                return;
            case 2:
                this.f4037g = ((double) value[0]) > 0.5d;
                return;
            case 3:
                throw new RuntimeException("Color does not have a single color to interpolate");
            case 4:
            case 5:
                int iHSVToColor = Color.HSVToColor(value);
                this.f4038h = iHSVToColor;
                this.f4038h = (b((int) (value[3] * 255.0f)) << 24) | (iHSVToColor & 16777215);
                return;
            case 7:
                this.f4035e = value[0];
                return;
            case 8:
                this.f4035e = value[0];
                return;
            default:
                return;
        }
    }

    public ConstraintAttribute(String name, AttributeType attributeType, Object value, boolean method) {
        this.f4032b = name;
        this.f4033c = attributeType;
        this.f4031a = method;
        w(value);
    }

    public ConstraintAttribute(ConstraintAttribute source, Object value) {
        this.f4031a = false;
        this.f4032b = source.f4032b;
        this.f4033c = source.f4033c;
        w(value);
    }
}
