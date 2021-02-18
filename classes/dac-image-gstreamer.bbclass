SUMMARY = "Base class for DAC Images with gstreamer support"

inherit  dac-image-base

IMAGE_INSTALL_append = " gstreamer1.0"

# All GStreamer libraries are bind-mounted on the target platform, remove them from OCI image
cleanup_gstreamer_libs () {
	rm -f ${IMAGE_ROOTFS}/etc/xdg/gstomx.conf
	rm -rf ${IMAGE_ROOTFS}/usr/lib/libgst*
	rm -rf ${IMAGE_ROOTFS}/usr/lib/gstreamer-1.0/*
}

ROOTFS_POSTPROCESS_COMMAND += 'cleanup_gstreamer_libs;'
