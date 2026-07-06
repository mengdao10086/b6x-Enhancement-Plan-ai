package a;

import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: D:\下载\Claude Code\scene_decompile\extracted\classes.dex */
public class vn0 {
    public boolean a(Method[] methodArr, String str) {
        for (Method method : methodArr) {
            if (str.equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    public boolean b(Class<?> cls) {
        return cls != null && cls.isArray();
    }

    public boolean c(Class<?> cls) {
        return cls != null && (Boolean.TYPE.isAssignableFrom(cls) || Boolean.class.isAssignableFrom(cls));
    }

    public boolean d(Class<?> cls) {
        return cls != null && Collection.class.isAssignableFrom(cls);
    }

    public boolean e(Class<?> cls) {
        return cls != null && List.class.isAssignableFrom(cls);
    }

    public boolean f(Class<?> cls) {
        return cls != null && Map.class.isAssignableFrom(cls);
    }

    public final boolean g(Object obj) {
        return obj instanceof g30 ? g30.f959a.equals(obj) : obj == null;
    }

    public boolean h(Class<?> cls) {
        return cls != null && (Byte.TYPE.isAssignableFrom(cls) || Short.TYPE.isAssignableFrom(cls) || Integer.TYPE.isAssignableFrom(cls) || Long.TYPE.isAssignableFrom(cls) || Float.TYPE.isAssignableFrom(cls) || Double.TYPE.isAssignableFrom(cls) || Number.class.isAssignableFrom(cls));
    }

    public final boolean i(Class<?> cls) {
        return (cls == null || j(cls) || b(cls) || d(cls) || f(cls)) ? false : true;
    }

    public final boolean j(Class<?> cls) {
        return c(cls) || h(cls) || k(cls);
    }

    public boolean k(Class<?> cls) {
        return cls != null && (String.class.isAssignableFrom(cls) || Character.TYPE.isAssignableFrom(cls) || Character.class.isAssignableFrom(cls));
    }

    public final <T> T l(Class<T> cls) throws e30 {
        if (cls == null) {
            return null;
        }
        if (!cls.isInterface()) {
            try {
                return cls.newInstance();
            } catch (Exception unused) {
                throw new e30("unknown class type: " + cls);
            }
        }
        if (cls.equals(Map.class)) {
            return (T) new HashMap();
        }
        if (cls.equals(List.class)) {
            return (T) new ArrayList();
        }
        if (cls.equals(Set.class)) {
            return (T) new HashSet();
        }
        throw new e30("unknown interface: " + cls);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> T[] m(d30 d30Var, Class<T> cls) {
        if (cls == null || g(d30Var)) {
            return null;
        }
        int iG = d30Var.g();
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, iG));
        for (int i = 0; i < iG; i++) {
            try {
                tArr[i] = p(d30Var.d(i), cls);
            } catch (e30 e) {
                e.printStackTrace();
            }
        }
        return tArr;
    }

    public <T> Collection<T> n(d30 d30Var, Class<?> cls, Class<T> cls2) {
        if (cls == null || cls2 == null || g(d30Var)) {
            return null;
        }
        k52 k52Var = (Collection<T>) ((Collection) l(cls));
        for (int i = 0; i < d30Var.g(); i++) {
            try {
                k52Var.add(p(d30Var.d(i), cls2));
            } catch (e30 e) {
                e.printStackTrace();
            }
        }
        return k52Var;
    }

    public String o(String str, String str2) {
        if (str == null || "".equals(str)) {
            return null;
        }
        return str2 + str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public <T> T p(g30 g30Var, Class<T> cls) {
        T t;
        if (cls == null || g(g30Var) || (t = (T) l(cls)) == null) {
            return null;
        }
        if (f(cls)) {
            s(t, g30Var);
        } else {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                String strO = o(field.getName(), "set");
                if (a(declaredMethods, strO)) {
                    try {
                        t(t, cls.getMethod(strO, field.getType()), field, g30Var);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return t;
    }

    public <T> T q(String str, Class<T> cls) {
        if (cls == null || str == null || str.length() == 0) {
            return null;
        }
        g30 g30Var = new g30(str);
        if (g(g30Var)) {
            return null;
        }
        return (T) p(g30Var, cls);
    }

    public void r(Object obj, Method method, String str, Object obj2) {
        if (obj2 != null) {
            try {
                if (!"".equals(obj2)) {
                    if ("String".equals(str)) {
                        method.invoke(obj, obj2.toString());
                    } else if ("Date".equals(str)) {
                        method.invoke(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(obj2.toString()));
                    } else if ("Integer".equals(str) || "int".equals(str)) {
                        method.invoke(obj, Integer.valueOf(Integer.parseInt(obj2.toString())));
                    } else if ("Long".equalsIgnoreCase(str)) {
                        method.invoke(obj, Long.valueOf(Long.parseLong(obj2.toString())));
                    } else if ("Double".equalsIgnoreCase(str)) {
                        method.invoke(obj, Double.valueOf(Double.parseDouble(obj2.toString())));
                    } else if ("Boolean".equalsIgnoreCase(str)) {
                        method.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(obj2.toString())));
                    } else {
                        method.invoke(obj, obj2);
                        Log.e("JSONHelper", "JSONHelper>>>>setFiedlValue -> not supper type" + str);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void s(Object obj, g30 g30Var) {
        try {
            Iterator<String> itK = g30Var.k();
            Map map = (Map) obj;
            while (itK.hasNext()) {
                String next = itK.next();
                map.put(next, g30Var.b(next));
            }
        } catch (e30 e) {
            e.printStackTrace();
        }
    }

    public final void t(Object obj, Method method, Field field, g30 g30Var) {
        Object objP;
        String simpleName;
        Type[] actualTypeArguments;
        String name = field.getName();
        Class<?> type = field.getType();
        try {
            if (b(type)) {
                Class<?> componentType = type.getComponentType();
                d30 d30VarP = g30Var.p(name);
                if (g(d30VarP)) {
                    return;
                }
                objP = m(d30VarP, componentType);
                simpleName = type.getSimpleName();
            } else if (d(type)) {
                Class cls = null;
                Type genericType = field.getGenericType();
                if ((genericType instanceof ParameterizedType) && (actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments()) != null && actualTypeArguments.length > 0) {
                    cls = (Class) actualTypeArguments[0];
                }
                d30 d30VarP2 = g30Var.p(name);
                if (g(d30VarP2)) {
                    return;
                }
                objP = n(d30VarP2, type, cls);
                simpleName = type.getSimpleName();
            } else if (j(type)) {
                objP = g30Var.m(name);
                if (objP == null) {
                    return;
                } else {
                    simpleName = type.getSimpleName();
                }
            } else if (!i(type)) {
                if (!e(type)) {
                    throw new Exception("unknow type!");
                }
                return;
            } else {
                g30 g30VarQ = g30Var.q(name);
                if (g(g30VarQ)) {
                    return;
                }
                objP = p(g30VarQ, type);
                simpleName = type.getSimpleName();
            }
            r(obj, method, simpleName, objP);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
