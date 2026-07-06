package a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.Editable;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class nj implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ActionMode.Callback f6924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final TextView f2098a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Class<?> f2099a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Method f2100a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f2101a;
    public boolean b = false;

    public nj(ActionMode.Callback callback, TextView textView) {
        this.f6924a = callback;
        this.f2098a = textView;
    }

    public final Intent a() {
        return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
    }

    public final Intent b(ResolveInfo resolveInfo, TextView textView) {
        Intent intentPutExtra = a().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !d(textView));
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        return intentPutExtra.setClassName(activityInfo.packageName, activityInfo.name);
    }

    public final List<ResolveInfo> c(Context context, PackageManager packageManager) {
        ArrayList arrayList = new ArrayList();
        if (!(context instanceof Activity)) {
            return arrayList;
        }
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(a(), 0)) {
            if (e(resolveInfo, context)) {
                arrayList.add(resolveInfo);
            }
        }
        return arrayList;
    }

    public final boolean d(TextView textView) {
        return (textView instanceof Editable) && textView.onCheckIsTextEditor() && textView.isEnabled();
    }

    public final boolean e(ResolveInfo resolveInfo, Context context) {
        if (context.getPackageName().equals(resolveInfo.activityInfo.packageName)) {
            return true;
        }
        ActivityInfo activityInfo = resolveInfo.activityInfo;
        if (!activityInfo.exported) {
            return false;
        }
        String str = activityInfo.permission;
        return str == null || context.checkSelfPermission(str) == 0;
    }

    public final void f(Menu menu) {
        Context context = this.f2098a.getContext();
        PackageManager packageManager = context.getPackageManager();
        if (!this.b) {
            this.b = true;
            try {
                Class<?> cls = Class.forName("com.android.internal.view.menu.MenuBuilder");
                this.f2099a = cls;
                this.f2100a = cls.getDeclaredMethod("removeItemAt", Integer.TYPE);
                this.f2101a = true;
            } catch (ClassNotFoundException | NoSuchMethodException unused) {
                this.f2099a = null;
                this.f2100a = null;
                this.f2101a = false;
            }
        }
        try {
            Method declaredMethod = (this.f2101a && this.f2099a.isInstance(menu)) ? this.f2100a : menu.getClass().getDeclaredMethod("removeItemAt", Integer.TYPE);
            for (int size = menu.size() - 1; size >= 0; size--) {
                MenuItem item = menu.getItem(size);
                if (item.getIntent() != null && "android.intent.action.PROCESS_TEXT".equals(item.getIntent().getAction())) {
                    declaredMethod.invoke(menu, Integer.valueOf(size));
                }
            }
            List<ResolveInfo> listC = c(context, packageManager);
            for (int i = 0; i < listC.size(); i++) {
                ResolveInfo resolveInfo = listC.get(i);
                menu.add(0, 0, i + 100, resolveInfo.loadLabel(packageManager)).setIntent(b(resolveInfo, this.f2098a)).setShowAsAction(1);
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused2) {
        }
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
        return this.f6924a.onActionItemClicked(actionMode, menuItem);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
        return this.f6924a.onCreateActionMode(actionMode, menu);
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode actionMode) {
        this.f6924a.onDestroyActionMode(actionMode);
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
        f(menu);
        return this.f6924a.onPrepareActionMode(actionMode, menu);
    }
}
