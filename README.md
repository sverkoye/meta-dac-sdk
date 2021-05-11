# meta-dac
		# On CentOS-7 switch default gcc to 7.x from https://www.softwarecollections.org/en/scls/rhscl/devtoolset-7/
		[ -f /opt/rh/devtoolset-7/enable ] && source /opt/rh/devtoolset-7/enable

		# Create build directory
		mkdir build; cd build

		# Install 'repo' tool from: https://android.googlesource.com/tools/repo
		repo init -u https://github.com/ZbyszekK/lgpub/ -m manifests/dac-dunfell-3.1.6-manifest.xml
		repo sync -v
		. ./oe-init-build-env
		cp ../.repo/manifests/manifests/bblayers.conf conf/

		# Select the target platform
		# for ARMv7
		echo 'MACHINE = "raspberrypi4"' >> conf/local.conf

		# Change package manager to ipk
		echo 'PACKAGE_CLASSES = "package_ipk"' >> conf/local.conf

		echo 'PREFERRED_PROVIDER_virtual/wpebackend = "wpebackend-rdk"' >> conf/local.conf

		# Build cobalt as DAC applictaion
		bitbake dac-image-cobalt
