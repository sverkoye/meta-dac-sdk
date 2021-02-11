SUMMARY = "Base class for DAC Images with gstreamer support"

inherit  dac-image-base

IMAGE_INSTALL_append = " gstreamer1.0"

cleanup_hw_dependent_libs () {
}

ROOTFS_POSTPROCESS_COMMAND += 'cleanup_hw_dependent_libs;'
