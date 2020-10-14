SUMMARY = "DAC Container with wayland egl test application"

inherit  dac-image-wayland

IMAGE_INSTALL = "wayland-egl-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/wayland-egl-test"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
