package gov.hhs.onc.dcdt.service.test;


import gov.hhs.onc.dcdt.service.ToolService;
import gov.hhs.onc.dcdt.test.ToolTestNgFunctionalTests;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@ContextHierarchy({ @ContextConfiguration({ "classpath*:META-INF/spring/spring-service.xml", "classpath*:spring/spring-service.xml" }),
        @ContextConfiguration({ "classpath*:META-INF/spring/spring-service-standalone.xml", "classpath*:spring/spring-service-standalone.xml" }) })
public abstract class ToolServiceTestNgFunctionalTests<T extends AbstractApplicationContext, U extends ToolService<T>> extends ToolTestNgFunctionalTests {
    protected final static long SERVICE_SETUP_THREAD_SLEEP_TIME_MS = 1000L;

    protected ThreadPoolTaskExecutor serviceTaskExecutor;
    protected Class<U> serviceClass;
    protected U service;

    protected ToolServiceTestNgFunctionalTests(Class<U> serviceClass) {
        this.serviceClass = serviceClass;
    }

    @BeforeClass(timeOut = 30 * 1000)
    public void beforeTestClass() throws Exception {
        this.service = this.createService();
        this.serviceTaskExecutor.submit(this.service);

        while(!this.service.isRunning()) {
            Thread.sleep(SERVICE_SETUP_THREAD_SLEEP_TIME_MS);
        }
    }

    @AfterClass(timeOut = 30 * 1000)
    public void afterTestClass() throws Exception {
        if (this.service != null) {
            this.service.stop();

            while(this.service.isRunning()) {
                Thread.sleep(SERVICE_SETUP_THREAD_SLEEP_TIME_MS);
            }
        }
    }

    protected abstract U createService();

    @Required
    @Resource(name = "toolServiceTaskExecutor")
    protected void setServiceTaskExecutor(ThreadPoolTaskExecutor serviceTaskExecutor) {
        this.serviceTaskExecutor = serviceTaskExecutor;
    }
}
