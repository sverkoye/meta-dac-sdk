SUMMARY = "Base class for DAC Images"

PACKAGE_CLASSES = "package_ipk"
IMAGE_FSTYPES = "container oci"
COMPATIBLE_MACHINE = "raspberrypi3"

inherit image
inherit image-oci

IMAGE_INSTALL = " "
IMAGE_INSTALL_append = " glibc"
IMAGE_INSTALL_append = " ldconfig"
IMAGE_INSTALL_append = " dash"

IMAGE_LINGUAS = " "
LICENSE = "MIT"

IMAGE_CMD_oci_append() {
    file_name="${IMAGE_NAME}${IMAGE_NAME_SUFFIX}-oci-${OCI_IMAGE_TAG}-${OCI_IMAGE_ARCH}${OCI_IMAGE_SUBARCH:+"-$OCI_IMAGE_SUBARCH"}-linux.oci-image.tar"
    ln -fs ${file_name} ${IMAGE_BASENAME}.tar
}
