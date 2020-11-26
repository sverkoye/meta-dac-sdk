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

do_image_append() {
    from os import path

    deploy_dir = d.getVar('D')
    appmetadata_path = path.abspath(path.join(deploy_dir, "..", "rootfs", "appmetadata.json"))

    if not path.isfile(appmetadata_path):
        bb.error("Your main recipe must inherit from app-metadata-include. Please add \'inherit app-metadata-include\' to your main app recipe.")
        sys.exit(1)
}
