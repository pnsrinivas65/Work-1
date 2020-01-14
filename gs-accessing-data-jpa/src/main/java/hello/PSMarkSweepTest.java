package hello;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryManagerMXBean;
import java.util.List;

public class PSMarkSweepTest {

	
	public static void main(String s[]) {
		
		List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
		

	    for (GarbageCollectorMXBean bean : beans) {
	        System.out.println(bean.getName());
	    }
	    List<MemoryManagerMXBean> memoryBeans = ManagementFactory.getMemoryManagerMXBeans();
	    for (MemoryManagerMXBean memoryManagerMXBean : memoryBeans) {
			System.out.println("memoryManagerMXBean -->"+memoryManagerMXBean.getName());
		}
	    
	    memoryBeans.forEach(memoryManagerMXBean -> System.out.println(memoryManagerMXBean.getObjectName()));
	}
}
