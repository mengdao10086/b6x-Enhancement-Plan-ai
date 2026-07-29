package androidx.constraintlayout.motion.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.d;
import com.blankj.utilcode.util.i0;
import com.bumptech.glide.load.engine.GlideException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.CharBuffer;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"LogConditional"})
public class c {
    public static void a(ViewGroup.LayoutParams param, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + GlideException.a.f12263d;
        System.out.println(" >>>>>>>>>>>>>>>>>>. dump " + str2 + GlideException.a.f12263d + param.getClass().getName());
        for (Field field : param.getClass().getFields()) {
            try {
                Object obj = field.get(param);
                String name = field.getName();
                if (name.contains("To") && !obj.toString().equals("-1")) {
                    System.out.println(str2 + d.f.f4450o + name + i0.f11861z + obj);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(" <<<<<<<<<<<<<<<<< dump " + str2);
    }

    public static void b(ViewGroup layout, String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str2 = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + str + GlideException.a.f12263d;
        int childCount = layout.getChildCount();
        System.out.println(str + " children " + childCount);
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = layout.getChildAt(i10);
            System.out.println(str2 + "     " + k(childAt));
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            for (Field field : layoutParams.getClass().getFields()) {
                try {
                    Object obj = field.get(layoutParams);
                    if (field.getName().contains("To") && !obj.toString().equals("-1")) {
                        System.out.println(str2 + d.f.f4450o + field.getName() + i0.f11861z + obj);
                    }
                } catch (IllegalAccessException unused) {
                }
            }
        }
    }

    public static void c(Object obj) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        String str = ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ee.a.f26979d;
        Class<?> cls = obj.getClass();
        System.out.println(str + "------------- " + cls.getName() + " --------------------");
        for (Field field : cls.getFields()) {
            try {
                Object obj2 = field.get(obj);
                if (field.getName().startsWith("layout_constraint") && ((!(obj2 instanceof Integer) || !obj2.toString().equals("-1")) && ((!(obj2 instanceof Integer) || !obj2.toString().equals("0")) && ((!(obj2 instanceof Float) || !obj2.toString().equals("1.0")) && (!(obj2 instanceof Float) || !obj2.toString().equals("0.5")))))) {
                    System.out.println(str + wn.a.f54751a + field.getName() + i0.f11861z + obj2);
                }
            } catch (IllegalAccessException unused) {
            }
        }
        System.out.println(str + "------------- " + cls.getSimpleName() + " --------------------");
    }

    public static String d(MotionEvent event) {
        int action = event.getAction();
        for (Field field : MotionEvent.class.getFields()) {
            try {
                if (Modifier.isStatic(field.getModifiers()) && field.getType().equals(Integer.TYPE) && field.getInt(null) == action) {
                    return field.getName();
                }
            } catch (IllegalAccessException unused) {
            }
        }
        return "---";
    }

    public static String e(int n10) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[n10 + 2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ee.a.f26979d;
    }

    public static String f() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "()";
    }

    public static String g() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ee.a.f26979d;
    }

    public static String h() {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
        return ".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ee.a.f26979d;
    }

    public static String i(Context context, int id2) {
        if (id2 == -1) {
            return o5.h.f42757n;
        }
        try {
            return context.getResources().getResourceEntryName(id2);
        } catch (Exception unused) {
            return "?" + id2;
        }
    }

    public static String j(Context context, int[] id2) {
        String resourceEntryName;
        try {
            String str = id2.length + "[";
            int i10 = 0;
            while (i10 < id2.length) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(i10 == 0 ? "" : i0.f11861z);
                String string = sb2.toString();
                try {
                    resourceEntryName = context.getResources().getResourceEntryName(id2[i10]);
                } catch (Resources.NotFoundException unused) {
                    resourceEntryName = "? " + id2[i10] + i0.f11861z;
                }
                str = string + resourceEntryName;
                i10++;
            }
            return str + "]";
        } catch (Exception e10) {
            e10.toString();
            return o5.h.f42757n;
        }
    }

    public static String k(View view) {
        try {
            return view.getContext().getResources().getResourceEntryName(view.getId());
        } catch (Exception unused) {
            return o5.h.f42757n;
        }
    }

    public static String l(MotionLayout layout, int stateId) {
        return m(layout, stateId, -1);
    }

    public static String m(MotionLayout layout, int stateId, int len) {
        int length;
        if (stateId == -1) {
            return "UNDEFINED";
        }
        String resourceEntryName = layout.getContext().getResources().getResourceEntryName(stateId);
        if (len == -1) {
            return resourceEntryName;
        }
        if (resourceEntryName.length() > len) {
            resourceEntryName = resourceEntryName.replaceAll("([^_])[aeiou]+", "$1");
        }
        if (resourceEntryName.length() <= len || (length = resourceEntryName.replaceAll("[^_]", "").length()) <= 0) {
            return resourceEntryName;
        }
        return resourceEntryName.replaceAll(CharBuffer.allocate((resourceEntryName.length() - len) / length).toString().replace((char) 0, '.') + "_", "_");
    }

    public static void n(String tag, String msg, int n10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(n10, stackTrace.length - 1);
        String str = i0.f11861z;
        for (int i10 = 1; i10 <= iMin; i10++) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            String str2 = ".(" + stackTrace[i10].getFileName() + ":" + stackTrace[i10].getLineNumber() + ") " + stackTrace[i10].getMethodName();
            str = str + i0.f11861z;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(msg);
            sb2.append(str);
            sb2.append(str2);
            sb2.append(str);
        }
    }

    public static void o(String msg, int n10) {
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        int iMin = Math.min(n10, stackTrace.length - 1);
        String str = i0.f11861z;
        for (int i10 = 1; i10 <= iMin; i10++) {
            StackTraceElement stackTraceElement = stackTrace[i10];
            String str2 = ".(" + stackTrace[i10].getFileName() + ":" + stackTrace[i10].getLineNumber() + ") ";
            str = str + i0.f11861z;
            System.out.println(msg + str + str2 + str);
        }
    }
}
