package f0;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;
import androidx.core.app.CoreComponentFactory;
import g.n0;
import g.p0;
import g.v0;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: loaded from: classes2.dex */
@v0(28)
public class h extends AppComponentFactory {
    @n0
    public Activity a(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Activity) Class.forName(str, false, classLoader).asSubclass(Activity.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException("Couldn't call constructor", e10);
        }
    }

    @n0
    public Application b(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Application) Class.forName(str, false, classLoader).asSubclass(Application.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException("Couldn't call constructor", e10);
        }
    }

    @n0
    public ContentProvider c(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (ContentProvider) Class.forName(str, false, classLoader).asSubclass(ContentProvider.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException("Couldn't call constructor", e10);
        }
    }

    @n0
    public BroadcastReceiver d(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (BroadcastReceiver) Class.forName(str, false, classLoader).asSubclass(BroadcastReceiver.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException("Couldn't call constructor", e10);
        }
    }

    @n0
    public Service e(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        try {
            return (Service) Class.forName(str, false, classLoader).asSubclass(Service.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (NoSuchMethodException | InvocationTargetException e10) {
            throw new RuntimeException("Couldn't call constructor", e10);
        }
    }

    @Override // android.app.AppComponentFactory
    @n0
    public final Activity instantiateActivity(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Activity) CoreComponentFactory.checkCompatWrapper(a(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public final Application instantiateApplication(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Application) CoreComponentFactory.checkCompatWrapper(b(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public final ContentProvider instantiateProvider(@n0 ClassLoader classLoader, @n0 String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (ContentProvider) CoreComponentFactory.checkCompatWrapper(c(classLoader, str));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public final BroadcastReceiver instantiateReceiver(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (BroadcastReceiver) CoreComponentFactory.checkCompatWrapper(d(classLoader, str, intent));
    }

    @Override // android.app.AppComponentFactory
    @n0
    public final Service instantiateService(@n0 ClassLoader classLoader, @n0 String str, @p0 Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (Service) CoreComponentFactory.checkCompatWrapper(e(classLoader, str, intent));
    }
}
