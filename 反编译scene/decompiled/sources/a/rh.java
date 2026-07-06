package a;

import a.sh;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public abstract class rh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Field f7299a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f2741a;
    public static Field b;
    public static Field c;

    static {
        try {
            Field declaredField = View.class.getDeclaredField("mAttachInfo");
            f7299a = declaredField;
            declaredField.setAccessible(true);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            Field declaredField2 = cls.getDeclaredField("mStableInsets");
            b = declaredField2;
            declaredField2.setAccessible(true);
            Field declaredField3 = cls.getDeclaredField("mContentInsets");
            c = declaredField3;
            declaredField3.setAccessible(true);
            f2741a = true;
        } catch (ReflectiveOperationException e) {
            Log.w("WindowInsetsCompat", "Failed to get visible insets from AttachInfo " + e.getMessage(), e);
        }
    }

    public static sh a(View view) {
        if (f2741a && view.isAttachedToWindow()) {
            try {
                Object obj = f7299a.get(view.getRootView());
                if (obj != null) {
                    Rect rect = (Rect) b.get(obj);
                    Rect rect2 = (Rect) c.get(obj);
                    if (rect != null && rect2 != null) {
                        sh.a aVar = new sh.a();
                        aVar.b(uc.c(rect));
                        aVar.c(uc.c(rect2));
                        sh shVarA = aVar.a();
                        shVarA.p(shVarA);
                        shVarA.d(view.getRootView());
                        return shVarA;
                    }
                }
            } catch (IllegalAccessException e) {
                Log.w("WindowInsetsCompat", "Failed to get insets from AttachInfo. " + e.getMessage(), e);
            }
        }
        return null;
    }
}
