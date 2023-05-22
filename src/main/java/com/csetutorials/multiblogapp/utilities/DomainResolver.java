package com.csetutorials.multiblogapp.utilities;

public class DomainResolver {

	private static ThreadLocal<String> currentDomain = new InheritableThreadLocal<>();

	public static String getDomain() {
		return currentDomain.get();
	}

	public static void setDomain(String tenant) {
		currentDomain.set(tenant);
	}

	public static void clear() {
		currentDomain.set(null);
	}

}
