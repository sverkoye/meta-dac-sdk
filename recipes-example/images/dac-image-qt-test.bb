SUMMARY = "DAC Container with qt wayland test application"

inherit  dac-image-qt

IMAGE_INSTALL = "qt-egl-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/qt-egl-test"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
