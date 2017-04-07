package org.com.nullpointer4j.se.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public final class RunnerCDI {

    public static <T extends ApplicationCDI> boolean run(
        final Class<T> clazz) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        T application = container.instance().select(clazz).get();
        application.run();
        weld.shutdown();
        return true;
    }
}
