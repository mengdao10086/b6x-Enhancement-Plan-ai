package a;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class z1 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f8025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final View f3785a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f3786a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Method f3787a;

    public z1(View view, String str) {
        this.f3785a = view;
        this.f3786a = str;
    }

    public final void a(Context context) {
        String str;
        Method method;
        while (context != null) {
            try {
                if (!context.isRestricted() && (method = context.getClass().getMethod(this.f3786a, View.class)) != null) {
                    this.f3787a = method;
                    this.f8025a = context;
                    return;
                }
            } catch (NoSuchMethodException unused) {
            }
            context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
        }
        int id = this.f3785a.getId();
        if (id == -1) {
            str = "";
        } else {
            str = " with id '" + this.f3785a.getContext().getResources().getResourceEntryName(id) + "'";
        }
        throw new IllegalStateException("Could not find method " + this.f3786a + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f3785a.getClass() + str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3787a == null) {
            a(this.f3785a.getContext());
        }
        try {
            this.f3787a.invoke(this.f8025a, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
