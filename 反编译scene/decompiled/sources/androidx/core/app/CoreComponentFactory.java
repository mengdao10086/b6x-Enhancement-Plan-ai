package androidx.core.app;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Intent;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class CoreComponentFactory extends AppComponentFactory {
    public static <T> T a(T t) {
        return t;
    }

    @Override // android.app.AppComponentFactory
    public Activity instantiateActivity(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Activity activityInstantiateActivity = super.instantiateActivity(classLoader, str, intent);
        a(activityInstantiateActivity);
        return activityInstantiateActivity;
    }

    @Override // android.app.AppComponentFactory
    public Application instantiateApplication(ClassLoader classLoader, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Application applicationInstantiateApplication = super.instantiateApplication(classLoader, str);
        a(applicationInstantiateApplication);
        return applicationInstantiateApplication;
    }

    @Override // android.app.AppComponentFactory
    public ContentProvider instantiateProvider(ClassLoader classLoader, String str) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        ContentProvider contentProviderInstantiateProvider = super.instantiateProvider(classLoader, str);
        a(contentProviderInstantiateProvider);
        return contentProviderInstantiateProvider;
    }

    @Override // android.app.AppComponentFactory
    public BroadcastReceiver instantiateReceiver(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        BroadcastReceiver broadcastReceiverInstantiateReceiver = super.instantiateReceiver(classLoader, str, intent);
        a(broadcastReceiverInstantiateReceiver);
        return broadcastReceiverInstantiateReceiver;
    }

    @Override // android.app.AppComponentFactory
    public Service instantiateService(ClassLoader classLoader, String str, Intent intent) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Service serviceInstantiateService = super.instantiateService(classLoader, str, intent);
        a(serviceInstantiateService);
        return serviceInstantiateService;
    }
}
