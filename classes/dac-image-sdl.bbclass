SUMMARY = "Base class for DAC Images with SDL support"

inherit  dac-image-base

DISTRO_FEATURES_append = " libglvnd-as-stubs-provider"
DISTRO_FEATURES_append = " wayland"

IMAGE_INSTALL_append = " libglvnd"
IMAGE_INSTALL_append = " wayland"
IMAGE_INSTALL_append = " libsdl2"


cleanup_hw_dependent_libs () {
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libEGL*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLES*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLdispatch*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libwayland-egl*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libwayland-server*
}

ROOTFS_POSTPROCESS_COMMAND += 'cleanup_hw_dependent_libs;'