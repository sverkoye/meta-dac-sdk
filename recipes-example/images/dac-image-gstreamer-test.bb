SUMMARY = "DAC Container with gstreamer test application"

inherit  dac-image-gstreamer

IMAGE_INSTALL = "gstreamer-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/gst-play-test"
APP_METADATA_PATH = "metadatas/shell-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = ""
OCI_IMAGE_WORKINGDIR = "/"
