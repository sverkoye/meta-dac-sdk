SUMMARY = "Base class for DAC Images with gstreamer support"

inherit dac-image-wayland

IMAGE_INSTALL_append = " gstreamer1.0"
IMAGE_INSTALL_append = " gstreamer1.0-plugins-base"
IMAGE_INSTALL_append = " glib-2.0"

cleanup_gstreamer_libs () {
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libgstfbdevsink.so
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libgstwaylandsink.so
}

ROOTFS_POSTPROCESS_COMMAND += 'cleanup_gstreamer_libs;'
