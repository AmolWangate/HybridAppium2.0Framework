package com.test.ownerinterfaces;

import org.aeonbits.owner.Config;

@Config.Sources(value = "file:${user.dir}/src/test/resources/prop/EnvConfig.properties")
public interface IEnvConfigProp extends Config {

	String mode();

	String drivertype();

	String url();

	String username();

	String password();

	int maxretry();

	boolean overridereport();

	boolean openreport();

	boolean infoscreenshot();

	boolean passscreenshot();

	boolean failscreenshot();

	boolean skipscreenshot();
}
