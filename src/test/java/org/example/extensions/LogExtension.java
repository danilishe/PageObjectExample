package org.example.extensions;

import io.qameta.atlas.core.api.MethodExtension;
import io.qameta.atlas.core.internal.Configuration;
import io.qameta.atlas.core.internal.TargetMethodInvoker;
import io.qameta.atlas.core.util.MethodInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;

public class LogExtension implements MethodExtension {
    Logger log = LogManager.getLogger();

    @Override
    public Object invoke(Object proxy, MethodInfo methodInfo, Configuration config) throws Throwable {
        log.info("Вызываем метод {} на объекте {}", methodInfo.getMethod(), proxy);
        return new TargetMethodInvoker().invoke(proxy, methodInfo, config);
    }

    @Override
    public boolean test(Method method) {
        return true;
    }
}
