import annotation.Autowired;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;

public class MiniBeanFactory {

    private final HashMap<Class<?>, Object> singletonMap = new HashMap<>();

    /**
     * Get bean by class type. If not exists, create.
     *
     * @param cls
     * @return
     */
    public Object getBean(Class<?> cls) {
        Object bean = singletonMap.get(cls);
        if (bean == null) {
            try {
                bean = createBean(cls);
                singletonMap.put(cls, bean);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return bean;
    }

    /**
     * Create bean with setting dependencies.
     *
     * @param cls
     * @return
     * @throws Exception
     */
    private Object createBean(Class<?> cls) throws Exception {
        Constructor<?> constructor = cls.getDeclaredConstructor();
        Object bean = constructor.newInstance();

        Field[] declaredFields = cls.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.isAnnotationPresent(Autowired.class)) {
                field.setAccessible(true);
                Object dependency = getBean(field.getType());
                field.set(bean, dependency);
            }
        }

        return bean;
    }

}
