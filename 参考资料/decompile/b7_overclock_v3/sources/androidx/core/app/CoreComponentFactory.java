package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.annotation.RestrictTo;
import g.n0;
import g.p0;
import g.v0;

/* JADX INFO: loaded from: classes2.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
@v0(api = 28)
public class CoreComponentFactory extends AppComponentFactory {

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface a {
        Object a();
    }

    public static <T> T checkCompatWrapper(T t10) {
        T t11;
        return (!(t10 instanceof a) || (t11 = (T) ((a) t10).a()) == null) ? t10 : t11;
    }

    @Override // android.app.AppComponentFactory
    @n0
    public Activity instantiateActivity(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Activity) checkCompatWrapper(super.instantiateActivity(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public Application instantiateApplication(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Application) checkCompatWrapper(super.instantiateApplication(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public ContentProvider instantiateProvider(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (ContentProvider) checkCompatWrapper(super.instantiateProvider(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public BroadcastReceiver instantiateReceiver(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (BroadcastReceiver) checkCompatWrapper(super.instantiateReceiver(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public Service instantiateService(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Service) checkCompatWrapper(super.instantiateService(classLoader, str, intent));
    }
}
