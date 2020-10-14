# meta-dac

		git clone -b dunfell git://git.yoctoproject.org/poky.git dunfell

		cd dunfell
		git clone -b dunfell git://git.yoctoproject.org/meta-raspberrypi
		git clone -b dunfell git://git.yoctoproject.org/meta-virtualization
		git clone -b dunfell git://git.openembedded.org/meta-openembedded
		git clone -b dunfell https://github.com/meta-qt5/meta-qt5.git
		git clone https://github.com/stagingrdkm/meta-dac-sdk.git

		source oe-init-build-env

		bitbake-layers add-layer ../meta-openembedded/meta-oe
		bitbake-layers add-layer ../meta-openembedded/meta-python
		bitbake-layers add-layer ../meta-openembedded/meta-filesystems
		bitbake-layers add-layer ../meta-openembedded/meta-networking
		bitbake-layers add-layer ../meta-raspberrypi
		bitbake-layers add-layer ../meta-dac-sdk
		bitbake-layers add-layer ../meta-virtualization
		bitbake-layers add-layer ../meta-qt5

		echo 'MACHINE="raspberrypi3"' >> conf/local.conf

		# Test OCI images
		bitbake dac-image-wayland-egl-test
		bitbake dac-image-wayland-egl-test-input
		bitbake dac-image-essos-sample
		bitbake dac-image-essos-egl
		bitbake dac-image-qt-test
		bitbake dac-image-shell

