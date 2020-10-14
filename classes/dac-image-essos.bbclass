SUMMARY = "Base class for DAC Images with essos egl support"

inherit dac-image-base

DISTRO_FEATURES_append = "libglvnd-as-stubs-provider"

IMAGE_INSTALL_append = " libglvnd"

OCI_IMAGE_ENV_VARS = "\
  WAYLAND_DISPLAY=wayland-0 \
  WAYLAND_DEBUG=0 \
"
cleanup_hw_dependent_libs () {
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libEGL*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLES*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libGLdispatch*
    rm -rf ${IMAGE_ROOTFS}/usr/lib/libessos*
}

ROOTFS_POSTPROCESS_COMMAND += 'cleanup_hw_dependent_libs;'
