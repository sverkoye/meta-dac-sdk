SUMMARY = "DAC Container with gstreamer test application"

inherit  dac-image-gstreamer

IMAGE_INSTALL = "gstreamer-test"

# needed
OCI_IMAGE_ENTRYPOINT = "/usr/bin/gst-play-test"
APP_METADATA_PATH = "metadatas/shell-appmetadata.json"

# optional
OCI_IMAGE_AUTHOR = "LGi"
OCI_IMAGE_AUTHOR_EMAIL = "info@lgi.com"
OCI_IMAGE_ENTRYPOINT_ARGS = "http://dash.akamaized.net/dash264/TestCases/2a/qualcomm/2/MultiRes.mpd"
OCI_IMAGE_WORKINGDIR = "/"
